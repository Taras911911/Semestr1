package Services;

import Classes.Doctor;
import Classes.Hospital;

import java.util.List;

public interface HospitalService {

    Hospital getHospital(int idHos);

    List<Hospital> getAllHospitals();

    Doctor getDoctor(int idDoc);

    List<Doctor> getAllDotorss();


}
