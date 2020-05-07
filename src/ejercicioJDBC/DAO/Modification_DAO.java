package ejercicioJDBC.DAO;

public interface Modification_DAO< T , v> {

    //un DAO para modificar y hacer cambios en la misma tabla en la base de datos

    public boolean crear ( T e) throws  DataBaseException;

    public boolean eliminar ( v pk) throws DataBaseException;

    public T consultarPorClavePrimaria (v pk) throws NotFoundException, DataBaseException;

    public boolean actualizar( T e ) throws  DataBaseException;

}
