package ejercicioJDBC.DAO;

public abstract class DAOFactory {
    public static final int MYSQL = 1 ;
    public static final int ORACLE = 2 ;


    public abstract ModificationDAO getEmpleadoModificationDAO ();
    public abstract ModificationDAO getAgenciaModificationDAO();

    public abstract CreationDAO getEmpleadoCreationDAO();
    public abstract CreationDAO getAgenciaCreationDAO();

    public static DAOFactory getDAOFactory ( int dataBase){
        switch (dataBase){
            case MYSQL :
                return new EmpleadoDAOFactory();
            case ORACLE :
               //return new OracleDAOFactory();
            default:
                return null;
        }

    }
}
