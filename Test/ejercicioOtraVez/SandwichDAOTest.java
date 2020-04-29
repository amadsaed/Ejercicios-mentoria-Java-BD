package ejercicioOtraVez;

import ejercicioOtraVez.DAO.DAO;
import ejercicioOtraVez.DAO.DAOFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import static ejercicioOtraVez.DAO.DAOFactory.MYSQL;

public class SandwichDAOTest {
    private static DAO<Sandwich,Integer> sandwichDAO;
    @BeforeClass
    public static void configurarTest(){
        DAOFactory factory= DAOFactory.getDAOFactory(MYSQL);
        sandwichDAO = factory.getSandwichDAO();
    }

    @Test
    public void getSandwichByIDTest(){
        System.out.println(sandwichDAO.getSandwichByID(1).toString());
    }
}
