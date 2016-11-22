package DAO;

import Classes.Doctor;


import java.util.List;

public interface DoctorsDAO {

    Doctor find(int id);

    List<Doctor> findAll();

    void save(Doctor doctor);

    void delete(int id);

    void update(Doctor doctor);
}
