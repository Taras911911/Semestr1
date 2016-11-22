package DAO;


public interface DocAchiveDAO {


    int[][] findAllAchivementForDoctor(int doc_id);

    int[][] findAll();

    void save(int doc_id, int achive_id);

    void delete(int doc_id, int achive_id);

}
