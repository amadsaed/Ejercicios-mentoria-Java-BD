package ejercicioOtraVez;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ejercicioOtraVez.DAO.CanNotReciveDataException;
import ejercicioOtraVez.DAO.DataBaseException;
import ejercicioOtraVez.DAO.MySqlDAOFactory;
import ejercicioOtraVez.DAO.OrderDAO;
import org.junit.BeforeClass;
import org.junit.Test;

public class CashierTest {

    private static Cashier cashier;
    private static List<Sandwich> sandwiches;
    private Sandwich sandwich;
    private static OrderDAO orderDAO;
    private static Order order;
    /*
    @BeforeClass
    public static void tearDown() {
        Map<Integer,Integer> stock = new TreeMap<Integer,Integer>();
        stock.put(1,2);
        stock.put(2,3);
        Ticket ticket;
        order = new Order(stock, new Ticket(1,200, "cash"));
        orderDAO = new OrderDAO();
    }


    @Test
    public void test() throws DataBaseException {
        Map<Integer, Integer> mapStocks = new TreeMap<Integer, Integer>();
        for(int i = 0; i < sandwiches.size(); i++) {
            sandwich = sandwiches.get(i);
            if(!mapStocks.containsKey(sandwich.getIdSandwich())) {
                mapStocks.put(sandwich.getIdSandwich(), 1);
            }else {
                mapStocks.replace(sandwich.getIdSandwich(),mapStocks.get(sandwich.getIdSandwich())+1);
            }
        }
        System.out.println(mapStocks.toString());
    }


 */

    @Test
    public void insertTest()  throws DataBaseException, CanNotReciveDataException {
        orderDAO.insert(order);

    }


}