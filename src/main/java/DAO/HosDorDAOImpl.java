package DAO;

import java.sql.*;
import java.util.ArrayList;

class HosDorDAOImpl implements HosDorDAO {

    private Connection connection;
    private Statement st;
    private PreparedStatement preparedStatement;

    HosDorDAOImpl() {

        try {
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public int[][] findAll() {

        int[][] ePoints = new int[0][0];
        ArrayList<int[]> points = new ArrayList<>();

        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM hos_dor");
            ResultSet res = preparedStatement.executeQuery();

            int i = 0;
            while (res.next()) {
                int[] point = new int[2];
                point[0] = res.getInt("hos_id");
                point[1] = res.getInt("doc_id");
                i++;
                points.add(point);
            }
            ePoints = new int[i][2];
            for (int k = 0; k < i; k++) {
                ePoints[k] = points.get(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ePoints;
    }


    public int[][] findforHospital(int hos_id) {

        int[][] ePoints = new int[0][0];
        ArrayList<int[]> points = new ArrayList<>();

        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM hos_dor WHERE hos_id =?");
            preparedStatement.setInt(1, hos_id);
            ResultSet res = preparedStatement.executeQuery();

            int i = 0;
            while (res.next()) {
                int[] point = new int[2];
                point[0] = res.getInt("hos_id");
                point[1] = res.getInt("doc_id");
                i++;
                points.add(point);
            }
            ePoints = new int[i][2];
            for (int k = 0; k < i; k++) {
                ePoints[k] = points.get(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ePoints;
    }

    @Override
    public int[] findForDoc(int doc_id) {
        int[] hos = new int[2];
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM hos_dor WHERE doc_id =?");
            preparedStatement.setInt(1, doc_id);
            ResultSet res = preparedStatement.executeQuery();

            res.next();
            hos[0] = res.getInt("hos_id");
            hos[1] = res.getInt("doc_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hos;
    }


    public void save(int hos_id, int doc_id) {

        try {


            preparedStatement = connection.prepareStatement("INSERT INTO hos_dor VALUES (?,?)");
            preparedStatement.setInt(1, hos_id);
            preparedStatement.setInt(2, doc_id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void delete(int hos_id, int doc_id) {

        try {


            preparedStatement = connection.prepareStatement("DELETE FROM hos_dor WHERE (hos_id =?, doc_id =?)");
            preparedStatement.setInt(1, hos_id);
            preparedStatement.setInt(2, doc_id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void update(int hos_id, int doc_id) {

        try {

            preparedStatement = connection.prepareStatement("UPDATE hos_dor SET hos_id = ? WHERE (doc_id =?)");
            preparedStatement.setInt(1, hos_id);
            preparedStatement.setInt(2, doc_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
