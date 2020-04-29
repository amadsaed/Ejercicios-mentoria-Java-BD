package ejercicioJDBC.DAO;

// un DAO para crear nuevos registros y filas  en nueva tabla en la base de datos
public interface CreationDAO < T , v > {

    public Empleado consultarEducacion ( v pk)  throws  DataBaseException , NotFoundException;

    public Empleado consultarTrabajo (v pk)  throws  DataBaseException, NotFoundException;

    public Empleado consultarPrestamo (T t) throws  DataBaseException, NotFoundException;
}
