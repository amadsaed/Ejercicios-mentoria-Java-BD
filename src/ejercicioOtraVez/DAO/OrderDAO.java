package ejercicioOtraVez.DAO;


import ejercicioOtraVez.Order;

public interface OrderDAO {

    public boolean insert(Order o) throws DataBaseException, UpdateDataException;

}