package ejercicioJDBC.DAO;

public class NotFoundException extends Exception {

    public NotFoundException(String message , Exception e) {
        super(message , e);
    }
    public NotFoundException(String message) {
        super(message );
    }
}
