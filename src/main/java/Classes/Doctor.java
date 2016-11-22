package Classes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Doctor {
    private int id;
    private String name;
    private Speciality speciality;
    private List <Achivement> achivements;
    private List<Time> times;
    private Hospital hospital;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
    public Doctor(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Doctor(int id, String name, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.achivements = new LinkedList<Achivement>();
    }

    public Doctor(int id, String name, Speciality speciality, List<Achivement> achivements) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.achivements = achivements;
    }

    public Doctor(int id, String name, Speciality speciality, Hospital hospital) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.hospital = hospital;
        this.achivements = new LinkedList<Achivement>();
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public List<Achivement> getAchivements() {
        return achivements;
    }

    public void setAchivements(List<Achivement> achivements) {
        this.achivements = achivements;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public  String getAchToString(){
        String str = "";
        Iterator<Achivement> iterator = achivements.iterator();
        while(iterator.hasNext()){
            str += iterator.next().getType() + "  ";

        }
        return  str;
    }
}
