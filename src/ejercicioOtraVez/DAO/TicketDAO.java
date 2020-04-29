package ejercicioOtraVez.DAO;
import ejercicioOtraVez.Ticket;
import java.sql.*;
import java.util.List;

public class TicketDAO implements DAO<Ticket , Integer> {

    private static final String INSERT = "INSERT INTO ticket (number , amount , type_pay , date) VALUES (?,?,?,?)";

    @Override
    public boolean insert(Ticket ticket) throws DataBaseException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, ticket.getNumber());
            ps.setInt(2, ticket.getAmount());
            ps.setString(3, ticket.getTypePay());
            ps.setDate(4, ticket.getDate());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new DataBaseException("error en data base ", ex);
        } finally {
            MySQLDAOFactory.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public boolean update(Ticket ticket) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public Ticket getSandwichByID(Integer id) {
        return null;
    }

    @Override
    public Ticket create(ResultSet rs) throws SQLException {
        return null;
    }


}
