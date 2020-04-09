package ejercicioJDBC.DAO;

public abstract class DAOFactory {
    public static final int MYSQL = 1 ;
    public static final int ORACLE = 2 ;


    public abstract DAO getEmpleadoDAO ();
    public abstract DAO getAgenciaDAO();

    public static DAOFactory getDAOFactory ( int dataBase){
        switch (dataBase){
            case MYSQL :
                return new MySQLDAOFactory();
            case ORACLE :
               //return new OracleDAOFactory();
            default:
                return null;
        }

    }
}
