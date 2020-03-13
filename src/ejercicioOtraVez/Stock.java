package ejercicioOtraVez;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private int idSandwich;
    private int stockQuantity;

    public Stock(int id, int stock){
        this.idSandwich = id;
        this.stockQuantity = stock;
    }

    public List<Stock> generateStocks(){
       List<Stock> stocks = new ArrayList<Stock>();
       stocks.add(new Stock(1, 20));
       stocks.add(new Stock(2, 20));
       stocks.add(new Stock(3, 15));
       stocks.add(new Stock(4, 15));
       stocks.add(new Stock(5, 10));
       return stocks;
    }

    public int getIdSandwich() {
        return idSandwich;
    }

    public void setIdSandwich(int idSandwich) {
        this.idSandwich = idSandwich;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int cantStock) {
        this.stockQuantity = cantStock;
    }
}
