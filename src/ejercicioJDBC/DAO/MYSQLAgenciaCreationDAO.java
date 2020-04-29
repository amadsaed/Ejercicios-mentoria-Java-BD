package ejercicioJDBC.DAO;

public class MYSQLAgenciaCreationDAO implements CreationDAO <Agencia,String> {
    @Override
    public boolean consultarEducacion(Agencia e) throws DataBaseException {
        return false;
    }

    @Override
    public boolean consultarTrabajo(Agencia e) throws DataBaseException {
        return false;
    }
}
