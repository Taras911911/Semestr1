package DAO;

import Classes.Speciality;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

class SpecialityDAOImpl implements SpecialityDAO {

    private Connection connection;
    private Statement st;
    private List<Speciality> list;
    private PreparedStatement preparedStatement;

    SpecialityDAOImpl() {

        try {
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Speciality find(int id) {
        Speciality spec = null;
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM special WHERE (id =?)");
            preparedStatement.setInt(1,id);
            ResultSet res = preparedStatement.executeQuery();

            res.next();

            spec = new Speciality(res.getInt("id"), res.getString("special_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spec;
    }


    public List<Speciality> findAll() {
        List<Speciality> specialities = new LinkedList<Speciality>();
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM special");
            ResultSet res = preparedStatement.executeQuery();

            while(res.next()) {

                Speciality spec = new Speciality(res.getInt("id"), res.getString("special_name"));
                specialities.add(spec);
            }
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialities;
    }


    public void save(Speciality speciality) {

        try {

            preparedStatement = connection.prepareStatement("INSERT INTO special(special_name) VALUES (?");
            preparedStatement.setString(1,speciality.getName());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int id) {

        try {

            preparedStatement = connection.prepareStatement("DELETE FROM special WHERE (id =?)");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
