package ejercicioOtraVez;

import java.util.List;

public class Order {

    private List<Sandwich> sandwiches;
    private Ticket ticket;
    private Boolean isReady;

    public Order(List<Sandwich> sandwiches, Ticket ticket) {
        this.sandwiches = sandwiches;
        this.ticket = ticket;
        this.isReady = false;
    }

}
