package DAO;


import java.sql.*;
import java.util.ArrayList;

class DocAchiveDAOImpl implements DocAchiveDAO {

    private Connection connection;
    private Statement st;
    private PreparedStatement preparedStatement;

    DocAchiveDAOImpl() {

        try {
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int[][] findAllAchivementForDoctor(int doc_id) {

        int[][] achives = new int[0][0];
        ArrayList<int[]> cost = new ArrayList<>();

        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM doctor_achive WHERE ( id_doctor =?)");
            preparedStatement.setInt(1, doc_id);
            ResultSet res = preparedStatement.executeQuery();


            // ResultSet res = st.executeQuery(
            //         "SELECT * FROM achives WHERE ( univ_id = " + univ_id + ")"
            // );


            int i = 0;
            while (res.next()) {
                int[] achive1 = new int[6];
                achive1[0] = doc_id;
                achive1[1] = res.getInt("id_achive");
                i++;
                cost.add(achive1);
            }
            achives = new int[i][6];
            for (int k = 0; k < i; k++) {
                achives[k] = cost.get(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return achives;
    }


    public int[][] findAll() {

        int[][] achives = new int[0][0];
        ArrayList<int[]> achive = new ArrayList<>();

        try {
            ResultSet res = st.executeQuery(
                    "SELECT * FROM costs"
            );
            int i = 0;
            while (res.next()) {
                int[] achive1 = new int[6];
                achive1[0] = res.getInt("id_doctor");
                achive1[1] = res.getInt("id_achive");
                i++;
                achive.add(achive1);
            }
            achives = new int[i][6];
            for (int k = 0; k < i; k++) {
                achives[k] = achive.get(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return achives;
    }


    public void save(int doc_id, int achive_id) {

        try {

            preparedStatement = connection.prepareStatement("INSERT INTO doctor_achive VALUES ( ?, ?)");
            preparedStatement.setInt(1, doc_id);
            preparedStatement.setInt(2, achive_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void delete(int doc_id, int achive_id) {

        try {

            preparedStatement = connection.prepareStatement("DELETE FROM doctor_achive WHERE (id_doctor =?, id_achive =?)");
            preparedStatement.setInt(1, doc_id);
            preparedStatement.setInt(2, achive_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


