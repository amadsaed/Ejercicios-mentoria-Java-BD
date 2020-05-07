package ejercicioJDBC.DAO;

public class MySQL_Empleado_DAO_Factory extends Empleado_DAO_Factory {
    @Override
    public Modification_DAO getEmpleadoModificationDAO() {
        return new MySQL_Empleado_Modification_DAO();
    }
    @Override
    public Report_DAO getEmpleadoCreationDAO() {
        return new MySQL_Empleado_Report_DAO();
    }
}
