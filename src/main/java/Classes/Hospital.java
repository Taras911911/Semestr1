package Classes;

import java.util.LinkedList;
import java.util.List;

public class Hospital {

    private int id;
    private String name;
    private String country;
    private String city;
    private String address;
    private String about;
    private List<Doctor> doctors;


    public Hospital(int id, String name, String country, String city, String address, String about, List<Doctor> doctors) {

        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.about = about;
        this.doctors = doctors;
    }

    public Hospital(int id, String name, String country, String city, String address, String about) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.about = about;
        this.doctors = new LinkedList<Doctor>();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getAbout() {
        return about;
    }



}
