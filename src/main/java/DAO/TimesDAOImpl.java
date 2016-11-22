package DAO;



import Classes.Time;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TimesDAOImpl implements TimesDAO {


    private Connection connection;
    private Statement st;
    private PreparedStatement preparedStatement;


    TimesDAOImpl() {

        try {
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<Time>  findForDoctor(int doc_id) {
        List<Time> times = new LinkedList<Time>();
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM times WHERE (doc_id = ?)");
            preparedStatement.setInt(1, doc_id);
            ResultSet res = preparedStatement.executeQuery();
            DoctorsDAO doctorsDAO = DAOFactory.getDoctorsDAO();
            WeekDaysDAO weekDaysDAO = DAOFactory.getWeekDaysDAO();
            while (res.next()) {
                Time  time = new Time(doctorsDAO.find(doc_id),res.getString("day_time"),weekDaysDAO.find(res.getInt("day_id")),res.getInt("id"));
                times.add(time);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return times;

    }
    @Override
    public Time  find(int id) {
    Time time = null;
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM times WHERE (id =?)");
            preparedStatement.setInt(1,id);
            ResultSet res = preparedStatement.executeQuery();
            DoctorsDAO doctorsDAO = DAOFactory.getDoctorsDAO();
            WeekDaysDAO weekDaysDAO = DAOFactory.getWeekDaysDAO();
            res.next();
            time = new Time(doctorsDAO.find(res.getInt("doc_id")),res.getString("day_time"),weekDaysDAO.find(res.getInt("day_id")),id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return time;

    }

    @Override
    public List<Time>  findAll() {
        List<Time> times = new LinkedList<Time>();
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM times");
            ResultSet res = preparedStatement.executeQuery();
            DoctorsDAO doctorsDAO = DAOFactory.getDoctorsDAO();
            WeekDaysDAO weekDaysDAO = DAOFactory.getWeekDaysDAO();


            while (res.next()) {
                Time  time = new Time(doctorsDAO.find(res.getInt("doc_id")),res.getString("day_time"),weekDaysDAO.find(res.getInt("day_id")),res.getInt("id"));
                times.add(time);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return times;
    }

    @Override
    public void save(Time time) {
        try {

            preparedStatement = connection.prepareStatement("INSERT INTO times(doc_id, day_id, day_time ) VALUES (?,?,?)");
            preparedStatement.setInt(1,time.getDoctor().getId());
            preparedStatement.setInt(2,time.getDay().getId());
            preparedStatement.setString(3,time.getTime());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM times WHERE (id =?)");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
