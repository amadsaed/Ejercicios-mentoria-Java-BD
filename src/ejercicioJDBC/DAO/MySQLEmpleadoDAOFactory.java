package ejercicioJDBC.DAO;

public class MySQLEmpleadoDAOFactory extends EmpleadoDAOFactory {
    @Override
    public ModificationDAO getEmpleadoModificationDAO() {
        return new MySQLEmpleadoModificationDAO();
    }
    @Override
    public CreationDAO getEmpleadoCreationDAO() {
        return new MySQLEmpleadoCreationDAO();
    }
}
