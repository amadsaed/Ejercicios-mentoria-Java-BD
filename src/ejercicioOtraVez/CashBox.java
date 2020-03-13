package ejercicioOtraVez;

import java.util.List;

public class CashBox {

    private List<Ticket> tickets;

    public Ticket generateTicket(int amount, String typePay){
        Ticket ticket = new Ticket(amount, typePay);
        saveTicket(ticket);
        return ticket;
    }

    public void saveTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public int calculateTotal(){
        int total = 0;
        for (int i = 0 ; i < tickets.size() ; i++){
           total += tickets.get(i).getAmount();
        }
        return total;
    }
}
