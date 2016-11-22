package DAO;

import Classes.Achivement;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


class AchivementsDAOImpl implements AchivementsDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement st;
    private List<Achivement> list;

    AchivementsDAOImpl() {

        try {
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Achivement find(int id) {

        Achivement ach = null;
        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM achives WHERE (id = ?)");
            preparedStatement.setInt(1,id);
            ResultSet res = preparedStatement.executeQuery();


            res.next();
            ach = new Achivement(res.getString("achive_name"), res.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ach;
    }


    public List<Achivement> findAll() {

        list = new LinkedList<Achivement>();

        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM achives");
            ResultSet res = preparedStatement.executeQuery();

            Achivement ach;
            while (res.next()) {
                ach = new Achivement(res.getString("achive_name"), res.getInt("id"));
                list.add(ach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }



    public void save(Achivement achivement) {

        try {
           // "INSERT INTO achivements(ach_sub, ach_name) VALUES ( " + achivement.getSubject().getId() +", '" + achivement.getType() + "')")
            preparedStatement = connection.prepareStatement("INSERT INTO achivements(achive_name) VALUES (?)");
            preparedStatement.setString(1,achivement.getType());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void delete(int id) {

        try {

            preparedStatement = connection.prepareStatement("DELETE FROM achives WHERE (id =?)");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();




           //st.executeUpdate(
            //        "DELETE FROM achivements WHERE (id =" + id + ")"
            //);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void update(Achivement achivement) {

        try {
            preparedStatement = connection.prepareStatement("UPDATE achives SET ach_name = ? WHERE id =?");
            preparedStatement.setString(1,achivement.getType());
            preparedStatement.setInt(2,achivement.getId());
            preparedStatement.executeUpdate();




           // st.executeUpdate(
           //         "UPDATE achivements SET ach_sub =" + achivement.getSubject().getId() + ", ach_name = '" + achivement.getType() + "' WHERE id =" + achivement.getId()
           // );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
