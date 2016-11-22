package Services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ServiceFactory {

    private static Properties properties;


    static {

        properties = new Properties();

        try {

            properties.load(

                    new FileInputStream("C:\\Users\\Dns\\Desktop\\Semestr\\resources\\service.properties"));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    public static HospitalService getHospitalService() {

        HospitalService hospitalService = null;

        try {

            hospitalService = (HospitalService) Class.forName(properties.getProperty("hospitalServ.class")).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return hospitalService;

    }


    public static UserService getUserService() {

        UserService userService = null;

        try {

            userService = (UserService) Class.forName(properties.getProperty("userServ.class")).newInstance();

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return userService;

    }

}