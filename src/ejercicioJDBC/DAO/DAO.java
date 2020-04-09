package ejercicioJDBC.DAO;

public interface DAO < T , v> {

    public boolean crear ( T e) throws NotFoundException, NoConnectionException;

    public boolean eliminar ( v pk) throws NotFoundException, NoConnectionException;

    public T consultarPorClavePrimaria (v pk) throws NotFoundException, NoConnectionException;

    public boolean actualizar( T e ) throws NotFoundException, NoConnectionException;

}
