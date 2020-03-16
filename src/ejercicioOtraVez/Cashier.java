package ejercicioOtraVez;

import ejercicio.NotEnoughCashException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Cashier extends Thread{

    private BlockingQueue<Order> orders;
    private BlockingQueue<Client> clients;
    private CashBox cashBox;
    private List<Stock> stocks;
    private List<Sandwich> sandwiches;
    private int cantClients;

    public Cashier(BlockingQueue<Order> orders, BlockingQueue<Client> clients, List<Stock> stocks, List<Sandwich> sandwiches, int cantClients) {
        this.orders = orders;
        this.clients = clients;
        this.cashBox = new CashBox();
        this.stocks = stocks;
        this.sandwiches = sandwiches;
        this.cantClients = cantClients;
    }

    @Override
    public void run(){
        List<Sandwich> mySandwiches;
        Client client;
        Sandwich sandwich;
        Order order;
        String typePay;
        int num;
        for(int j = 0; j < cantClients; j++){
            int totalAmount = 0;
            while(this.clients.isEmpty()){
            }
            mySandwiches = new ArrayList<Sandwich>();
            client = this.clients.poll();
            System.out.println("How many sandwich do yo want?");
            num = client.intRandom();
            System.out.println("Select the sandwich that you want");
            showMenu();
            for(int i = 0; i < num; i++){
                sandwich = selectSandwich(sandwichRandom());
                decreaseStock(sandwich);
                totalAmount += sandwich.getPrice();
                mySandwiches.add(sandwich);
            }
            System.out.println("How do you want to pay?");
            typePay = client.typePayRandom();
            try {
                this.sendOrder(new Order(mySandwiches, charge(typePay, client.pay(typePay, totalAmount))));
            } catch (NotEnoughCashException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void decreaseStock(Sandwich sandwich) {
        int i = 0;
        int quantity;
        while(i < this.stocks.size() && sandwich.getIdSandwich() != this.stocks.get(i).getIdSandwich()){
            i++;
        }
        quantity = this.stocks.get(i).getStockQuantity();
        this.stocks.get(i).setStockQuantity(quantity-1);
    }

    private void sendOrder(Order order){
        this.orders.add(order);
    }

    private Ticket charge(String typePay, int totalAmount){
       return this.cashBox.generateTicket(totalAmount, typePay);
    }

    private Sandwich selectSandwich(int id){
        int i = 0;
        Sandwich sandwich;
        while (i < this.sandwiches.size() && this.sandwiches.get(i).getIdSandwich() != id){
           i++;
        }
        sandwich = this.sandwiches.get(i);
            System.out.println("You choose: " + sandwich + "which has : " + sandwich.getIngredients());

        return sandwich;
    }

    private void showMenu(){
        for(Sandwich s : this.sandwiches){
            System.out.println(s.toString());
            for(Ingredient i : s.getIngredients()){
                System.out.println(i.getName());
            }
        }
    }

    public int sandwichRandom(){
        Random rand1 = new Random();
        int n1 = rand1.nextInt(5);
     return n1;
    }

}
