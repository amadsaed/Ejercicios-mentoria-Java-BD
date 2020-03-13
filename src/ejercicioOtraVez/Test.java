package ejercicioOtraVez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

    public static void main(String[] args) {

        BlockingQueue<Order> orders = new ArrayBlockingQueue<Order>(1024);
        BlockingQueue<Client> clients = new ArrayBlockingQueue<Client>(1024);

        Cashier cashier = new Cashier(orders, clients, generateStocks(), generateSandwiches());

    }


    public static List<Stock> generateStocks(){
        List<Stock> stocks = new ArrayList<Stock>();
        stocks.add(new Stock(1, 20));//0 posicion = get(i)
        stocks.add(new Stock(2, 20));//1
        stocks.add(new Stock(3, 15));//2
        stocks.add(new Stock(4, 15));//3
        stocks.add(new Stock(5, 10));//4
        return stocks;
    }

    public static List<Sandwich> generateSandwiches(){
        List<Sandwich> sandwiches = new ArrayList<Sandwich>();
        sandwiches.add(new Sandwich(1, 150, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("rawHam"), new Ingredient("danbo")))));
        sandwiches.add(new Sandwich(2, 200, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("rawHam"), new Ingredient("cheddar")))));
        sandwiches.add(new Sandwich(3, 170, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("cookedHam"), new Ingredient("cheddar")))));
        sandwiches.add(new Sandwich(4, 120, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("cookedHam"), new Ingredient("danbo")))));
        sandwiches.add(new Sandwich(5, 100, new ArrayList<Ingredient>(Arrays.asList(new Ingredient("salami"), new Ingredient("danbo")))));
        return sandwiches;
    }
}