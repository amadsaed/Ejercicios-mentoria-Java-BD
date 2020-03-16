package ejercicioOtraVez;

import java.util.concurrent.BlockingQueue;

public class Preparer extends Thread{

    private BlockingQueue<Order> orders;
    private int cantClients;

    public Preparer(BlockingQueue<Order> orders, int cantClients){
        this.orders = orders;
        this.cantClients = cantClients;
    }

    @Override
    public void run(){
        for(int i = 0; i < cantClients; i++){
            while (this.orders.isEmpty()) {
            }
            deliverOrder(this.orders.poll());
        }

    }

    private void deliverOrder (Order order){
        for (Sandwich s: order.getSandwiches()){
            s.setReady(true);
        }
        order.setReady(true);
        System.out.println("the order has been delivered !");
    }
}
