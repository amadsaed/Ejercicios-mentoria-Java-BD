package ejercicioOtraVez.DAO;

import ejercicioOtraVez.Sandwich;

import java.util.List;
import java.util.Map;

public interface SandwichDAO {

    public void decreaseStock(Map<Integer, Integer> stocks) throws DataBaseException, UpdateDataException;

    public int getTotalStock() throws DataBaseException, UpdateDataException;

    public boolean isAvailableStock(Map<Integer, Integer> stocks) throws DataBaseException;

    public List<Sandwich> getAllSandwiches() throws DataBaseException;

}