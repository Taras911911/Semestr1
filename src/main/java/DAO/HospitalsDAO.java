package DAO;

import Classes.Hospital;
import java.util.List;


public interface HospitalsDAO {

    Hospital find(int id);

    List<Hospital> findAll();

    void save(Hospital hospital);

    void delete(int id);

    void update(Hospital hospital);
}
