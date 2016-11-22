package DAO;


import Classes.Day;

import java.util.List;

public interface WeekDaysDAO {

    Day find(int id);

    List<Day> findAll();

}
