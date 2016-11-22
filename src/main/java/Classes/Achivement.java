package Classes;


public class Achivement {
    private Doctor doctor;
    private String type;
    private int id;

    public Achivement(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public Achivement(Doctor doctor, String type, int id) {
        this.doctor= doctor;
        this.type = type;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Doctor getDoctor() {

        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
