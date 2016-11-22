package Utils;


public interface Verifier {

    boolean existAchivement(int userId);

    boolean existSpeciality(int id);

    boolean existHospital(int id);

    boolean existUser(int id);

    boolean existUser(String login);

    boolean existZanForUser(int user_id);

    boolean existDoctorsForHos(int hos_id);

    boolean existDoctor(int doc_id);

    boolean existTimesForDoctor(int doc_id);

    boolean timeInUse(int timeId);

    boolean existAchiveForDoc(int doc_id);

    boolean existHosForDoc(int doc_id);
}
