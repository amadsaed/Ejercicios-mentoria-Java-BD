package ejercicioOtraVez.DAO;

import ejercicioOtraVez.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderRegisterSandwichDAO implements DAO <Order,Integer > {

    private static final String INSERT = "INSERT INTO order_register_sandwich(quantity, number_order, id_sandwich)" +
            "VALUES(?, (SELECT MAX(number) FROM the_order), ?)";

    @Override
    public boolean insert(Order o) throws DataBaseException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //MODIFICAR
        try {
            conn = MySQLDAOFactory.createConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, o.getTicket().getNumber());
            if(ps.executeUpdate() != 0) {
                System.out.println("Order saved succesfully");
            }else {
                throw new DataBaseException("Error to save the product");
            }
        }catch(SQLException e) {
            throw new DataBaseException("Error in SQL", e);
        }finally {
            MySQLDAOFactory.closeConnection(conn, ps, rs);
        }
        return true;
    }

    @Override
    public boolean update(Order t) throws DataBaseException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Integer id) throws DataBaseException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Order> getAll(){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Order getSandwichByID(Integer id) throws DataBaseException {
        return null;
    }

    @Override
    public Order creat(ResultSet rs) throws SQLException {
        return null;
    }
}
