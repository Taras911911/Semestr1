package Classes;

public class Time {
    private Doctor doctor;
    private String time;
    private Day day;
    private boolean use;
    private int id;

    public Time(Doctor doctor, String time, Day day, int id) {
        this.doctor = doctor;
        this.time = time;
        this.day = day;
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public int getId() {
        return id;
    }
}
