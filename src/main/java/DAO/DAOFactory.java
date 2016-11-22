package DAO;




import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DAOFactory {

    private static Properties properties;



    static {

        properties = new Properties();

        try {

            properties.load(

                    new FileInputStream("C:\\Users\\Dns\\Desktop\\Semestr\\resources\\DAO.properties"));

        } catch (IOException e) {

            e.printStackTrace();

        }



    }



    public static AchivementsDAO getAchivementsDAO() {

        AchivementsDAO achivementsDAO = null;

        try {

            achivementsDAO = (AchivementsDAO) Class.forName( properties.getProperty("achivementDAO.class")).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return achivementsDAO;

    }



    public static DocAchiveDAO getDocAchiveDAO() {

        DocAchiveDAO docAchiveDAO = null;

        try {

            docAchiveDAO = (DocAchiveDAO) Class.forName( properties.getProperty("docAchiveDAO.class")).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return docAchiveDAO;

    }





    public static HosDorDAO getHosDorDAO() {

        HosDorDAO extraDao = null;

        try {

            extraDao = (HosDorDAO) Class.forName( properties.getProperty("HosDorDAO.class")).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return extraDao;

    }





    public static ZanDAO getZanDAO() {

        ZanDAO zanDAO = null;

        try {

             zanDAO = (ZanDAO) Class.forName(properties.getProperty("ZanDAO.class")).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return zanDAO;

    }





    public static SpecialityDAO getSpecialityDAO() {

        SpecialityDAO specialityDAO = null;

        try {

            specialityDAO = (SpecialityDAO) Class.forName(properties.getProperty("specialityDAO.class")

            ).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return specialityDAO;

    }





    public static DoctorsDAO getDoctorsDAO() {

        DoctorsDAO doctorsDAO = null;

        try {

            doctorsDAO = (DoctorsDAO) Class.forName(

                    properties.getProperty("DoctorsDAO.class")

            ).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return doctorsDAO;

    }



    public static HospitalsDAO getHospitalsDAO() {

        HospitalsDAO hospitalsDAO = null;

        try {

            hospitalsDAO = (HospitalsDAO) Class.forName(

                    properties.getProperty("HospitalsDAO.class")

            ).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return hospitalsDAO;

    }


    public static TimesDAO getTimesDAO() {

        TimesDAO timesDAO = null;

        try {

            timesDAO = (TimesDAO) Class.forName(

                    properties.getProperty("timesDAO.class")

            ).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return timesDAO;

    }

    public static WeekDaysDAO getWeekDaysDAO() {

        WeekDaysDAO weekDaysDAO = null;

        try {

            weekDaysDAO = (WeekDaysDAO) Class.forName(

                    properties.getProperty("weekDaysDAO.class")

            ).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return weekDaysDAO;

    }

    public static UsersDAO getUsersDAO() {

        UsersDAO usersDAO = null;

        try {

            usersDAO = (UsersDAO) Class.forName(

                    properties.getProperty("userDAO.class")

            ).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return usersDAO;

    }
}
