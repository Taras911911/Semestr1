import DAO.DAOFactory;

/**
 * Created by Dns on 22.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(DAOFactory.getTimesDAO().findForDoctor(6));
    }
}
