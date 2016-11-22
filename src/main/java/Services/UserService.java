package Services;

import Classes.Achivement;
import Classes.User;

import javax.servlet.http.Cookie;
import java.util.List;


public interface UserService {

    boolean isRegistered(String login);

    boolean saveUser(User user);

    boolean checkPassword(String login, String password);

    Cookie generateCookies();

    void saveToken(int userId, String token);

    User isExistToken(String token);

    User getUser(int id);

    User getUser(String login);

    void addTimeToUser(int timeId, int userId);
}
