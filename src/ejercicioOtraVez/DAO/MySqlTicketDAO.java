package ejercicioOtraVez.DAO;


import ejercicioOtraVez.Ticket;

public interface MySqlTicketDAO {

    public void insert(Ticket t) throws DataBaseException;

}