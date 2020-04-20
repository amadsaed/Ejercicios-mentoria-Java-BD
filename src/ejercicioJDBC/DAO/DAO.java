package ejercicioJDBC.DAO;

public interface DAO < T , v> {

    public boolean crear ( T e) throws  DataBaseException;

    public boolean eliminar ( v pk) throws DataBaseException;

    public T consultarPorClavePrimaria (v pk) throws NotFoundException, DataBaseException;

    public boolean actualizar( T e ) throws  DataBaseException;

}
