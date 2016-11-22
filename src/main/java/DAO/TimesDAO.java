package DAO;


import Classes.Time;

import java.util.List;

public interface TimesDAO {

    Time find(int id);

    List<Time> findForDoctor(int doc_id);

    List<Time> findAll();

    void save(Time time);

    void delete(int id);


}
