package ejercicioOtraVez.DAO;


import ejercicioOtraVez.Ticket;

public interface TicketDAO {

    public void insert(Ticket t) throws DataBaseException;

}