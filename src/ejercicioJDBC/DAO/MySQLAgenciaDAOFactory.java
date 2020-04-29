package ejercicioJDBC.DAO;

public class MySQLAgenciaDAOFactory extends AgenciaDAOFactory {

    @Override
    public ModificationDAO getAgenciaModificationDAO() {
        return new MySQLAgenciaModificationDAO();
    }
    @Override
    public CreationDAO getAgenciaCreationDAO() {
        return new MYSQLAgenciaCreationDAO();
    }
}
