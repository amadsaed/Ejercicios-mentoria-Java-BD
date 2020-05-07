package ejercicioJDBC.DAO;

public class MySQL_Agencia_Modification_DAO implements Modification_DAO<Agencia , String> {

    private MySQL_Agencia_DAO_Factory mySQLAgenciaDAOFactory;

    private static final String SELECT = "SELECT * FROM agencia WHERE nombre = ?";

    @Override
    public boolean crear(Agencia e) {
        return false;
    }

    @Override
    public boolean eliminar(String pk) {
        return false;
    }

    @Override
    public Agencia consultarPorClavePrimaria(String pk) {
        return null;
    }

    @Override
    public boolean actualizar(Agencia e) {
    return false;
    }
}
