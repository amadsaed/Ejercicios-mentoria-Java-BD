package ejercicioJDBC.DAO;

public class MySQL_Agencia_DAO_Factory extends Agencia_DAO_Factory {

    @Override
    public Modification_DAO getAgenciaModificationDAO() {
        return new MySQL_Agencia_Modification_DAO();
    }
    @Override
    public Report_DAO getAgenciaCreationDAO() {
        return new MYSQL_Agencia_Report_DAO();
    }
}
