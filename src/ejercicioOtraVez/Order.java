package ejercicioOtraVez;

import java.util.List;

public class Order {

    private List<Sandwich> sandwiches;
    private Ticket ticket;
    private boolean isReady;

    public Order(List<Sandwich> sandwiches, Ticket ticket) {
        this.sandwiches = sandwiches;
        this.ticket = ticket;
        this.isReady = false;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
