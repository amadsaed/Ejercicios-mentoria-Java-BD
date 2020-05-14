package ejercicioOtraVez.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "amadsaed94";
    public static final String PASS = "";


    @Override
    public SandwichDAO getSandwichDAO() {
        return new MysqlSandwichDAO();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return new MysqlOrderDAO();
    }

    @Override
    public TicketDAO getTicketDAO() {
        return new MysqlTicketDAO();
    }


    public static Connection openConnection() {
        Connection conn = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            if(conn != null){
                //System.out.println("Established Connection");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Invalid Connection");
        }
        return conn;
    }


    public static void closeConnections(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            conn.close();
            //rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






}