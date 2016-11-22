package Services;

import Classes.*;
import DAO.*;
import Utils.MD5;
import Utils.TokenMaker;
import Utils.Verifier;
import Utils.VerifierFactory;

import javax.servlet.http.Cookie;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class UserServiceImpl implements UserService {

    Connection connection;
    Statement statement;
    Verifier verifier;
    DoctorsDAO doctorsDao;
    UsersDAO userDao;
    WeekDaysDAO weekDaysDao;
    TimesDAO timesDao;
    ZanDAO zanDao;
    static List<Token> tokens;


    UserServiceImpl() {
        try {

            connection = ConnectionPSQL.getConnection();
            statement = connection.createStatement();
            verifier = VerifierFactory.getVerifier();
            userDao = DAOFactory.getUsersDAO();
            doctorsDao = DAOFactory.getDoctorsDAO();
            weekDaysDao = DAOFactory.getWeekDaysDAO();
            timesDao = DAOFactory.getTimesDAO();
            tokens = new LinkedList<Token>();
            zanDao = DAOFactory.getZanDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean isRegistered(String login) {
        if (verifier.existUser(login)){
            return true;
        }
        return false;
    }

    public boolean saveUser(User user) {
        user.setPassword(MD5.getHash(user.getPassword()));
        if (verifier.existUser(user.getLogin())) {
            return false;
        }else {
            userDao.save(user);
            return true;
        }
    }

    public boolean checkPassword(String login, String password) {

        if(verifier.existUser(login)) {
            return userDao.find(login).getPassword().equals(MD5.getHash(password));
        } else
            return false;
    }

    public Cookie generateCookies() {
        Cookie cookie = new Cookie("MSiteCookie", TokenMaker.generateToken());
        return cookie;
    }


    public void saveToken(int userId, String token) {
        tokens.add(new Token(userId, token));
    }

    public User isExistToken(String token) {
        Iterator<Token> iterator = tokens.iterator();
        Token now;
        while(iterator.hasNext()) {
            now = iterator.next();
            if(now.getToken().equals(token)) {
                return getUser(now.getUserId());
            }
        }
        return null;
    }

    public User getUser(int id) {
        if (verifier.existUser(id)) {
            User user = userDao.find(id);
            List<Time> times = new LinkedList<>();
            if(verifier.existZanForUser(id)) {
                int[][] zan = zanDao.findAllForUser(id);
                for (int i=0; i< zan.length; i++) {
                    times.add(timesDao.find(zan[i][0]));
                }
            }
            user.setTimes(times);
            return user;
        } else {
            return null;
        }
    }

    public User getUser(String login) {
        if (verifier.existUser(login)) {
            User user = userDao.find(login);
            List<Time> times = new LinkedList<>();
            if(verifier.existZanForUser(user.getId())) {
                int[][] zan = zanDao.findAllForUser(user.getId());
                for (int i=0; i< zan.length; i++) {
                    times.add(timesDao.find(zan[i][0]));
                }
            }
            user.setTimes(times);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void addTimeToUser(int timeId, int userId) {
        if(verifier.existUser(userId) && !verifier.timeInUse(timeId)) {
            zanDao.save(timeId, userId);
        }
    }
}