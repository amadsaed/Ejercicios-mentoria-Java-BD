package ejercicioJDBC.DAO;

public class MySQLAgenciaModificationDAO implements ModificationDAO<Agencia , String> {

    private MySQLAgenciaDAOFactory mySQLAgenciaDAOFactory;

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
