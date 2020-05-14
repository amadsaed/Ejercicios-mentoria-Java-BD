package ejercicioOtraVez.DAO;

public abstract class DAOFactory {

    private static final int MySql = 1;

    public abstract SandwichDAO getSandwichDAO();
    public abstract OrderDAO getOrderDAO();
    public abstract TicketDAO getTicketDAO();

    public static DAOFactory getDAOFactory(int DB) throws DataBaseException {
        switch(DB) {

            case MySql:
                return new MySqlDAOFactory();

            default:
                throw new DataBaseException("error, No database selected ");
        }
    }


}
