package ejercicioJDBC.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgenciaDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test";

    public Connection createConnection(){
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con= DriverManager.getConnection(URL,"amadsaed94","");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    @Override
    public DAO getEmpleadoDAO() {
        return null;
    }

    @Override
    public DAO getAgenciaDAO() {
        return null;
    }
}
