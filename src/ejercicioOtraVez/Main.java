package ejercicioOtraVez;

import ejercicioOtraVez.DAO.DataBaseException;
import ejercicioOtraVez.DAO.MySqlDAOFactory;
import ejercicioOtraVez.DAO.MySqlSandwichDAO;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        ExecutionContext app = null;

        try {
            app = new ExecutionContext(generateSandwichesFromDataBase());
            Thread.sleep(3000);
        } catch (InterruptedException | DataBaseException e) {
            e.printStackTrace();
        }
        app.startExecution();
    }

    public static List<Sandwich> generateSandwichesFromDataBase() throws DataBaseException{
        MySqlDAOFactory myDAO = new MySqlDAOFactory();
        MySqlSandwichDAO sandwichDAO = myDAO.getSandwichDAO();
        return sandwichDAO.getAllSandwiches();
    }

}