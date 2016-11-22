package DAO;


public interface HosDorDAO {

    int[][] findforHospital(int hos_id);

    int[] findForDoc(int doc_id);

    int[][] findAll();

    void save(int hos_id, int doc_id);

    void delete(int hos_id, int doc_id);

    void update(int hos_id, int doc_id);
}
