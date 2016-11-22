package DAO;

import Classes.Doctor;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

class DoctorsDAOImpl implements DoctorsDAO {

    private Connection connection;
    private Statement st;
    private PreparedStatement preparedStatement;
    private SpecialityDAO specialityDAO;


    DoctorsDAOImpl() {

        try {
            specialityDAO = DAOFactory.getSpecialityDAO();
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Doctor find(int id) {

        Doctor doc = null;
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM doctors WHERE id =?");
            preparedStatement.setInt(1,id);
            ResultSet res = preparedStatement.executeQuery();

            res.next();
            doc = new Doctor(res.getInt("id"), res.getString("doc_name"), specialityDAO.find(res.getInt("id_spec")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doc;
    }


    public List<Doctor> findAll() {

        List<Doctor> doc = new LinkedList<Doctor>();
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM doctors");
            ResultSet res = preparedStatement.executeQuery();


            while (res.next())
              doc.add(new Doctor(res.getInt("id"), res.getString("doc_name"), specialityDAO.find(res.getInt("id_spec"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doc;
    }


    public void save(Doctor doctor) {

        try {

            preparedStatement = connection.prepareStatement("INSERT INTO doctors(doc_name) VALUES (?)");
            preparedStatement.setString(1,doctor.getName());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int id) {

        try {

            preparedStatement = connection.prepareStatement("DELETE FROM doctors WHERE (id =?)");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void update(Doctor doctor) {

        try {

            preparedStatement = connection.prepareStatement("UPDATE doctors SET doc_name =? WHERE id =?");
            preparedStatement.setString(1,doctor.getName());
            preparedStatement.setInt(2,doctor.getId());
            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
