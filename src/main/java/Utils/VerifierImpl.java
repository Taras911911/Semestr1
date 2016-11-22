package Utils;


import DAO.ConnectionPSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class VerifierImpl implements Verifier {

    private Connection connection;
    private Statement st;

    public VerifierImpl() {
        try {
            this.connection = ConnectionPSQL.getConnection();
            this.st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean existAchivement(int userId) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM achivements WHERE (id =" + userId + ")"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean existSpeciality(int id) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM specialities WHERE (id =" + id + ")"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean existHospital(int id) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM hospitals WHERE (id =" + id + ")"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean existUser(int id) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM users WHERE (id =" + id + ")"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean existUser(String login) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM users WHERE (user_login = '" + login + "')"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean existZanForUser(int user_id) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM zan WHERE (id_user = '" + user_id + "')"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean existDoctorsForHos(int hos_id) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM hos_dor WHERE (hos_id = '" + hos_id + "')"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean existDoctor(int doc_id) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM doctors WHERE (id = '" + doc_id + "')"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean existTimesForDoctor(int doc_id) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM times WHERE (doc_id = '" + doc_id + "')"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean timeInUse(int timeId) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM zan WHERE (id_time = '" + timeId + "')"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean existAchiveForDoc(int doc_id) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM doctor_achive WHERE (id_doctor = '" + doc_id + "')"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean existHosForDoc(int doc_id) {
        try {
            ResultSet resultSet = st.executeQuery(
                    "SELECT * FROM hos_dor WHERE (doc_id = '" + doc_id + "')"
            );

            if (!resultSet.next()) {
                return false;
            } else
                return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
