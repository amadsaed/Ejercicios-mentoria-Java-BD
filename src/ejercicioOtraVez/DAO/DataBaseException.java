package ejercicioOtraVez.DAO;

import java.sql.SQLException;

public class DataBaseException extends Exception{

        public DataBaseException (String message ) {
            super(message);
        }

        public DataBaseException(String message , Exception e) {
            super(message, e);
        }
    }
