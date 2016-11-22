package Classes;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private String city;
    private List<Time> times;
    private  String login;
    private String password;

    public User(int id, String name, String surname, String city, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.login = login;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setSubjects(List<Time> times) {
        this.times = times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public int getId() {
        return id;
    }
}
