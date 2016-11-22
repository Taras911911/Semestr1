package Services;

import Classes.*;
import DAO.*;
import Utils.Verifier;
import Utils.VerifierFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HospitalServiceImpl implements HospitalService {

    Connection connection;
    Statement statement;
    Verifier verifier;
    DoctorsDAO docDao;
    SpecialityDAO specDAO;
    HospitalsDAO hosDAO;
    DocAchiveDAO docAchiveDAO;
    ZanDAO zanDAO;
    HosDorDAO hosDorDAO;
    AchivementsDAO achDAO;
    TimesDAO timesDAO;

    HospitalServiceImpl() {
        try {
            connection = ConnectionPSQL.getConnection();
            statement = connection.createStatement();
            verifier = VerifierFactory.getVerifier();
            specDAO = DAOFactory.getSpecialityDAO();
            hosDAO = DAOFactory.getHospitalsDAO();
            zanDAO = DAOFactory.getZanDAO();
            docDao = DAOFactory.getDoctorsDAO();
            hosDorDAO = DAOFactory.getHosDorDAO();
            achDAO = DAOFactory.getAchivementsDAO();
            timesDAO = DAOFactory.getTimesDAO();
            docAchiveDAO = DAOFactory.getDocAchiveDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hospital getHospital(int idHos) {
        if(verifier.existHospital(idHos)) {
            Hospital hospital = hosDAO.find(idHos);
            List<Doctor> doctors = new LinkedList<Doctor>();
            if(verifier.existDoctorsForHos(idHos)) {
                int[][] hos_dor = hosDorDAO.findforHospital(idHos);
                for (int i=0; i < hos_dor.length; i++) {
                    Doctor doc = getDoctor(hos_dor[i][1]);
                    doc.setHospital(hospital);
                    doctors.add(doc);
                }
            }
            hospital.setDoctors(doctors);
            return hospital;
        } else
        return null;
    }

    @Override
    public List<Hospital> getAllHospitals() {
        List<Hospital> hospitals = new LinkedList<Hospital>();
        List<Hospital> hos = hosDAO.findAll();
        Iterator<Hospital> iterator = hos.iterator();
        while (iterator.hasNext()) {
            Hospital hospital = iterator.next();
            List<Doctor> doctors = new LinkedList<Doctor>();
            if(verifier.existDoctorsForHos(hospital.getId())) {
                int[][] hos_dor = hosDorDAO.findforHospital(hospital.getId());
                for (int i=0; i < hos_dor.length; i++) {
                    Doctor doc = getDoctor(hos_dor[i][1]);
                    doc.setHospital(hospital);
                    doctors.add(doc);
                }
            }
            hospital.setDoctors(doctors);
            hospitals.add(hospital);
        }

        return hospitals;
    }

    @Override
    public Doctor getDoctor(int idDoc) {
        Doctor doctor = null;

        if(verifier.existDoctor(idDoc)) {
            doctor = docDao.find(idDoc);
            List<Time> times = new LinkedList<Time>();
            if (verifier.existTimesForDoctor(idDoc)) {
                List<Time> tis = timesDAO.findForDoctor(idDoc);
                Iterator<Time> iterator = tis.iterator();
                while(iterator.hasNext()) {
                    Time time = iterator.next();
                    if (verifier.timeInUse(time.getId()))
                        time.setUse(true);
                    times.add(time);
                }
            }
            List<Achivement> achives = new LinkedList<Achivement>();
            if (verifier.existAchiveForDoc(idDoc)) {
                int[][] achs = docAchiveDAO.findAllAchivementForDoctor(idDoc);
                for(int i =0; i < achs.length; i++) {
                    Achivement ach = achDAO.find(achs[i][1]);
                    ach.setDoctor(doctor);
                    achives.add(ach);
                }
            }
            if (verifier.existHosForDoc(idDoc))
                doctor.setHospital(hosDAO.find(hosDorDAO.findForDoc(idDoc)[0]));
            doctor.setAchivements(achives);
            doctor.setTimes(times);
        }

        return doctor;
    }

    @Override
    public List<Doctor> getAllDotorss() {
        List<Doctor> doctors = new LinkedList<Doctor>();
        List<Doctor> docs = docDao.findAll();
        Iterator<Doctor> iterator = docs.iterator();
        while (iterator.hasNext()) {
            Doctor doctor = iterator.next();
            List<Time> times = new LinkedList<Time>();
            if (verifier.existTimesForDoctor(doctor.getId())) {
                List<Time> tis = timesDAO.findForDoctor(doctor.getId());
                Iterator<Time> it = tis.iterator();
                while(it.hasNext()) {
                    Time time = it.next();
                    if (verifier.timeInUse(time.getId()))
                        time.setUse(true);
                    times.add(time);
                }
            }
            List<Achivement> achives = new LinkedList<Achivement>();
            if (verifier.existAchiveForDoc(doctor.getId())) {
                int[][] achs = docAchiveDAO.findAllAchivementForDoctor(doctor.getId());
                for(int i = 0; i < achs.length; i++) {
                    Achivement ach = achDAO.find(achs[i][1]);
                    ach.setDoctor(doctor);
                    achives.add(ach);
                }
            }
            if (verifier.existHosForDoc(doctor.getId()))
                doctor.setHospital(hosDAO.find(hosDorDAO.findForDoc(doctor.getId())[0]));
            doctor.setAchivements(achives);
            doctor.setTimes(times);
            doctors.add(doctor);
        }
        return doctors;
    }


}
