package ejercicioOtraVez.DAO;

import ejercicioOtraVez.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OrderDAO implements MySqlOrderDAO {

    private static final String INSERT_ORDER = "INSERT INTO orders (number_ticket) VALUES((SELECT MAX(number) FROM tickets))";

    private static final String INSERT_SANDWICH_REGISTER = "INSERT INTO order_register_sandwich(quantity, number_order, id_sandwich)" +
            "VALUES(?, (SELECT MAX(number) FROM orders), ?)";


    @Override
    public boolean insert(Order o) throws DataBaseException, CanNotReciveDataException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean saved = false;
        try {
            conn = MySqlDAOFactory.openConnection();
            ps = conn.prepareStatement(INSERT_ORDER);
          //  ps.setInt(1, o.getTicket().getNumber());
            if(ps.executeUpdate() != 0) {
                System.out.println("Order saved successfully");
                for (Map.Entry<Integer, Integer> s : o.getSandwiches().entrySet()) {
                    ps = conn.prepareStatement(INSERT_SANDWICH_REGISTER);
                    ps.setInt(1, s.getValue());
                    ps.setInt(2, s.getKey());
                    if(ps.executeUpdate() != 0) {
                        saved = true;
                    }else {
                        throw new CanNotReciveDataException("Could not save the order correctly");
                    }
                }
            }else {
                throw new DataBaseException("Error to save the product");
            }
        }catch(SQLException e) {
            throw new DataBaseException("Error in SQL ", e);
        }finally {
            MySqlDAOFactory.closeConnections(conn, ps, null);
        }
        return saved;
    }

}