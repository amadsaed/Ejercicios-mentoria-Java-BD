package ejercicioOtraVez;

import ejercicioOtraVez.DAO.DataBaseException;
import ejercicioOtraVez.DAO.TicketDAO;

import java.util.ArrayList;
import java.util.List;


public class CashBox {

    private List<Ticket> tickets;
    private TicketDAO ticketDAO;


    public CashBox(TicketDAO ticketDAO) {
        this.tickets = new ArrayList<Ticket>();
        this.ticketDAO = ticketDAO;
    }

    public Ticket generateTicket(int amount, String typePay){
        Ticket ticket = new Ticket( amount, typePay);
        saveTicket(ticket);
        return ticket;
    }

    public void saveTicket(Ticket ticket){//insert ticket into database
        try {
            this.ticketDAO.insert(ticket);
        } catch (DataBaseException e) {
            System.out.println(e.getMessage());
        }
    }

    public int calculateTotal(){
        int total = 0;
        for (int i = 0 ; i < tickets.size() ; i++){
            total += tickets.get(i).getAmount();
        }
        return total;
    }

    public String toString() {
        return "$ " + calculateTotal();
    }
}