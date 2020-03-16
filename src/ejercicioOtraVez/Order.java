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

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }
}
