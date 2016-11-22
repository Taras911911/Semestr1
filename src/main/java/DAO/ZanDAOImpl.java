package DAO;

import java.sql.*;
import java.util.ArrayList;

class ZanDAOImpl implements ZanDAO {

    private Connection connection;
    private Statement st;
    private PreparedStatement preparedStatement;

    ZanDAOImpl() {

        try {
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    public int[][] findAllForUser(int user_id) {

        int[][] points = new int[0][0];
        ArrayList<int[]> point = new ArrayList<>();

        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM zan WHERE ( id_user = ?)");
            preparedStatement.setInt(1,user_id);
            ResultSet res = preparedStatement.executeQuery();


            int i = 0;
            while (res.next()) {
                int[] poin = new int[2];
                poin[0] = res.getInt("id_time");
                poin[1] = res.getInt("id_user");
                i++;
                point.add(poin);
            }
            points = new int[i][2];
            for (int k=0; k<i; k++) {
                points[k] = point.get(k);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return points;
    }




    public int[][] findAll() {

        int[][] points = new int[0][0];
        ArrayList<int[]> point = new ArrayList<>();

        try {
            ResultSet res = st.executeQuery(
                    "SELECT * FROM zan"
            );
            int i = 0;
            while (res.next()) {
                int[] poin = new int[2];
                poin[0] = res.getInt("id_time");
                poin[1] = res.getInt("id_user");

                i++;
                point.add(poin);
            }
            points = new int[i][2];
            for (int k=0; k<i; k++) {
                points[k] = point.get(k);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return points;
    }


    public void save(int time_id, int user_id) {

        try {


            preparedStatement = connection.prepareStatement( "INSERT INTO zan VALUES (?,?)");
            preparedStatement.setInt(1,time_id);
            preparedStatement.setInt(2,user_id);
            preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void delete(int time_id, int user_id) {

        try {

            preparedStatement = connection.prepareStatement("DELETE FROM zan WHERE (id_time =?, id_user =?)");
            preparedStatement.setInt(1,time_id);
            preparedStatement.setInt(2,user_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
