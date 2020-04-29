package ejercicioOtraVez.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAO <T, ti> {

    public boolean insert(T t) throws DataBaseException;

    public boolean update(T t) throws DataBaseException;

    public boolean delete(ti id) throws DataBaseException;

    public List<T> getAll() throws DataBaseException;

    public T getSandwichByID(ti id) throws DataBaseException;

    public T create(ResultSet rs) throws SQLException;
}
