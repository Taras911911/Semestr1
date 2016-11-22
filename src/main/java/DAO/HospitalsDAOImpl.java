package DAO;



import Classes.Hospital;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

class HospitalsDAOImpl implements HospitalsDAO {


    private Connection connection;
    private Statement st;
    private PreparedStatement preparedStatement;

    HospitalsDAOImpl() {

        try {
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Hospital find(int id) {

        Hospital hospital = null;
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM hospitals WHERE (id =?)");
            preparedStatement.setInt(1,id);
            ResultSet res = preparedStatement.executeQuery();


            while (res.next())
            hospital = new Hospital(res.getInt("id"), res.getString("hos_name"),
                    res.getString("country"), res.getString("city"), res.getString("address"), res.getString("about"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospital;
    }


    @Override
    public List<Hospital> findAll() {

        List<Hospital> hospitals =new LinkedList<Hospital>();
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM hospitals");
            ResultSet res = preparedStatement.executeQuery();


            while (res.next())
            hospitals.add(new Hospital(res.getInt("id"), res.getString("hos_name"),
                    res.getString("country"), res.getString("city"), res.getString("address"), res.getString("about")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitals;
    }

    @Override
    public void save(Hospital hospital) {

        try {

            preparedStatement = connection.prepareStatement("INSERT INTO hospitals(hos_name, country, city, address, about) " +
                    "VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,hospital.getName());
            preparedStatement.setString(2,hospital.getCountry());
            preparedStatement.setString(3,hospital.getCity());
            preparedStatement.setString(4,hospital.getAddress());
            preparedStatement.setString(5,hospital.getAbout());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

        try {

            preparedStatement = connection.prepareStatement("DELETE FROM hospitals WHERE (id =?)");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Hospital hospital) {

        try {

            preparedStatement = connection.prepareStatement("UPDATE hospitals SET hos_name =?, country = ?, city =?, address = ?, about = ? WHERE id = ?");
            preparedStatement.setString(1,hospital.getName());
            preparedStatement.setString(2,hospital.getCountry());
            preparedStatement.setString(3,hospital.getCity());
            preparedStatement.setString(4,hospital.getAddress());
            preparedStatement.setString(5,hospital.getAbout());
            preparedStatement.setInt(6,hospital.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
