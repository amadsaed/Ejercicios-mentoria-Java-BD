package ejercicioJDBC.DAO;

public class NoConnectionException extends Exception{
    public NoConnectionException(String message , Exception e) {
        super(message, e);
    }
}
