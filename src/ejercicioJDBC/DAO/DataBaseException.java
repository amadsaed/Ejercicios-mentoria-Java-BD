package ejercicioJDBC.DAO;

public class DataBaseException extends Exception{
    public DataBaseException(String message , Exception e) {
        super(message, e);
    }
}
