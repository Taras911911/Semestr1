package DAO;


import Classes.Day;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WeekDaysDAOImpl implements WeekDaysDAO {

    private Connection connection;
    private Statement st;
    private PreparedStatement preparedStatement;

    WeekDaysDAOImpl() {

        try {
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Day find(int id) {
       Day day = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM week_days WHERE (id =?)");
            preparedStatement.setInt(1,id);
            ResultSet res = preparedStatement.executeQuery();
            res.next();
            day = new Day(id, res.getString("day"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return day;
    }

    @Override
    public List<Day> findAll() {
        List<Day> days = new LinkedList<Day>();
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM week_days");
            ResultSet res = preparedStatement.executeQuery();


            while (res.next()) {
              Day  day = new Day(res.getInt("id"), res.getString("day"));
               days.add(day);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return days;
    }

}

