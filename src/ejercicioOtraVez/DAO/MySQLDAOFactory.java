package ejercicioOtraVez.DAO;

import java.sql.*;

public class MySQLDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test";

    public static Connection createConnection(){
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con= DriverManager.getConnection(URL,"amadsaed94","");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

   public static void closeConnection (Connection conn , PreparedStatement ps , ResultSet rs){
        try{
            conn.close();
            ps.close();
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();// excepcion nuestra
        }
    }


    @Override
    public DAO getSandwichDAO() {
        return new SandwichDAO();
    }

    @Override
    public DAO getOrderRegisterSandwichDAO() {
        return null;
    }

    @Override
    public DAO getOrderDAO() {
        return null;
    }

    @Override
    public DAO getTicketDAO() {
        return null;
    }
}
