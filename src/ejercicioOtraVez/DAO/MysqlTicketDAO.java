package ejercicioOtraVez.DAO;

import ejercicioOtraVez.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MysqlTicketDAO implements TicketDAO {

    private static final String INSERT = "INSERT INTO tickets(amount, type_pay, date) VALUES(?, ?, ?)";


    @Override
    public void insert(Ticket t) throws DataBaseException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = MySqlDAOFactory.openConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, t.getAmount());
            ps.setString(2, t.getTypePay());
            ps.setTimestamp(3, t.getDate());
            if(ps.executeUpdate() != 0) {
                System.out.println("Ticket saved successfully");
            }else {
                throw new DataBaseException("Error saving the ticket");
            }
        }catch (SQLException e) {
            throw new DataBaseException("Error into the database", e);
        } finally {
            MySqlDAOFactory.closeConnections(conn, ps, null);
        }
    }

}