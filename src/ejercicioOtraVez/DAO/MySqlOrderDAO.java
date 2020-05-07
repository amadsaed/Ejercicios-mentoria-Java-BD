package ejercicioOtraVez.DAO;


import ejercicioOtraVez.Order;

public interface MySqlOrderDAO {

    public boolean insert(Order o) throws DataBaseException, CanNotReciveDataException;

}