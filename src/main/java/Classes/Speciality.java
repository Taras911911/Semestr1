package Classes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Speciality {

    private int id;
    private String name;
    private Doctor doctor;


    public Speciality(int id, String name) {
        this.id = id;
        this.name = name;
        this.doctor = null;
    }



    public Speciality(int id, Doctor doctor, String name) {
        this.id = id;
        this.doctor = doctor;
        this.name = name;
}



    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

