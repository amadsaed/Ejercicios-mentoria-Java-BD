package ejercicio;

import java.util.concurrent.BlockingQueue;

public abstract class Employee extends Thread{


    private BlockingQueue<Ticket> tickets;
    private BlockingQueue<Client> waitClients;

    public Employee(BlockingQueue<Ticket> tickets, BlockingQueue<Client> waitClients ) {
        this.tickets = tickets;
        this.waitClients = waitClients;
    }

    public void addTickets(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Ticket pollTicket() {
        return this.tickets.poll();
    }

    public void addClientForWait(Client client) {
        this.waitClients.add(client);
    }

    public BlockingQueue<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(BlockingQueue<Ticket> tickets) {
        this.tickets = tickets;
    }
    public BlockingQueue<Client> getWaitClients() {
        return waitClients;
    }
    public void setWaitClients(BlockingQueue<Client> waitClients) {
        this.waitClients = waitClients;
    }


}