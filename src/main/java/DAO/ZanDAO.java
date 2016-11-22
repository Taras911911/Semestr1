package DAO;


public interface ZanDAO {


    int[][] findAllForUser(int user_id);

    int[][] findAll();

    void save(int time_id, int user_id);

    void delete(int time_id, int user_id);

}
