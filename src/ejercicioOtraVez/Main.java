package ejercicioOtraVez;


import ejercicioOtraVez.DAO.DAO;
import ejercicioOtraVez.DAO.DataBaseException;
import ejercicioOtraVez.DAO.MySQLDAOFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ExecutionContext app = null;

        try {
            app = new ExecutionContext(generateSandwiches());
            Thread.sleep(5000);
        } catch (InterruptedException | DataBaseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        app.startExecution();
    }

    public static List<Sandwich> generateSandwiches() throws DataBaseException{
        List<Sandwich> sandwiches = new ArrayList<Sandwich>();
        MySQLDAOFactory myDAO = new MySQLDAOFactory();
        DAO sandwichDAO = myDAO.getSandwichDAO();
        return sandwichDAO.getAll();
    }

}