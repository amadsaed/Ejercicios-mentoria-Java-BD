package ejercicioOtraVez.DAO;
import ejercicioOtraVez.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderDAO implements DAO<Order, Integer>{

    private static final String INSERT = "INSERT INTO the_order(number_ticket) VALUES(?)";

    private static final String INSERT_REGISTER =  "INSERT INTO order_register_sandwich(quantity, number_order, id_sandwich)" +
            "VALUES(?, (SELECT MAX(number) FROM the_order), ?)";
    //private static final String UPDATE = "UPDATE the_order SET number = ?, number_ticket = ? WHERE number = ?";
    //private static final String DELETE = "DELETE FROM the_order WHERE number = ?";
    //private static final String GET_ALL_ORDERS = "SELECT *FROM the_order";
    //private static final String GET_ONE_ORDER = "SELECT * FROM the_order WHERE number = ?";


    public boolean insert(Order o, Map<Integer, Integer> stocks) throws DataBaseException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean saved = false;

        try {
            conn = MySQLDAOFactory.createConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, o.getTicket().getNumber());
            if(ps.executeUpdate() != 0) {
                System.out.println("Order saved succesfully");
                for (Map.Entry<Integer, Integer> s : stocks.entrySet()) {
                    ps = conn.prepareStatement(INSERT_REGISTER);
                    ps.setInt(1, s.getValue());
                    ps.setInt(2, s.getKey());
                    if(ps.executeUpdate() != 0) {
                        System.out.println("Register sandwich saved succesfully");
                        saved = true;
                    }else {
                        throw new NotFoundException("not found");
                    }
                }
            }else {
                throw new DataBaseException("Error to save the product");
            }
        }catch(SQLException | NotFoundException e) {
            throw new DataBaseException("Error in SQL", e);
        }finally {
            MySQLDAOFactory.closeConnection(conn, ps, rs);
        }
        return saved;
    }

    @Override
    public boolean insert(Order order) throws DataBaseException {
        return false;
    }

    @Override
    public boolean update(Order t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Order> getAll() throws DataBaseException {
        return null;
    }

    @Override
    public Order getSandwichByID(Integer id) throws DataBaseException {
        return null;
    }

    @Override
    public Order create(ResultSet rs) throws SQLException {
        return null;
    }

}

