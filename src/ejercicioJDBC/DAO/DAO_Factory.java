package ejercicioJDBC.DAO;

public abstract class DAO_Factory {
    public static final int MYSQL = 1 ;
    public static final int ORACLE = 2 ;


    public abstract Modification_DAO getEmpleadoModificationDAO ();
    public abstract Modification_DAO getAgenciaModificationDAO();

    public abstract Report_DAO getEmpleadoCreationDAO();
    public abstract Report_DAO getAgenciaCreationDAO();

    public  static DAO_Factory getDAOFactory (int dataBase){
        switch (dataBase){
            case MYSQL :
                return new Empleado_DAO_Factory();
            case ORACLE :
               //return new OracleDAOFactory();
            default:
                return null;
        }

    }
}
