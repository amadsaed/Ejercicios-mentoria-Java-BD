package ejercicioOtraVez.DAO;

public abstract class DAOFactory {

    public static final int MYSQL = 1 ;
    public static final int ORACLE = 2 ;


    public abstract DAO getSandwichDAO();
    public abstract DAO getOrderRegisterSandwichDAO();
    public abstract DAO getOrderDAO();
    public abstract DAO getTicketDAO();


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
