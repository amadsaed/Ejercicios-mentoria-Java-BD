package ejercicioOtraVez.DAO;

import ejercicioOtraVez.Sandwich;

import java.util.List;
import java.util.Map;

public interface MySqlSandwichDAO {

    public void decreaseStock(Map<Integer, Integer> stocks) throws DataBaseException, CanNotReciveDataException;

    public int getAllSandwichsStock() throws DataBaseException, CanNotReciveDataException;

    public boolean getSandwichStock(Map<Integer, Integer> stocks) throws DataBaseException;

    public List<Sandwich> getAllSandwiches() throws DataBaseException;

}