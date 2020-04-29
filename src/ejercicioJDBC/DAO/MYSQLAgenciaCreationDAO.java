package ejercicioJDBC.DAO;

public class MYSQLAgenciaCreationDAO implements CreationDAO <Agencia,String> {

    @Override
    public Empleado consultarEducacion(String pk) throws DataBaseException, NotFoundException {
        return null;
    }

    @Override
    public Empleado consultarTrabajo(String pk) throws DataBaseException, NotFoundException {
        return null;
    }

    @Override
    public Empleado consultarPrestamo(Agencia agencia) throws DataBaseException, NotFoundException {
        return null;
    }
}
