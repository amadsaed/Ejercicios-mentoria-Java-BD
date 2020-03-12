package ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private String type;
    private int price;
    private boolean state;
    private Bread bread;
    private List<Ingredient> ingredients;
    private  Ingredient ingredient;

    protected static final String OPCION_1 = "Jamon Crudo y Danbo";
    protected static final String OPCION_2 = "Jamon Cocido y Danbo";
    protected static final String OPCION_3 = "Jamon Crudo y Cheddar";
    protected static final String OPCION_4 = "Jamon Cocido y Cheddar";
    protected static final String OPCION_5 = "Salami y Danbo";

    protected static final int PRECIO_1 = 150;
    protected static final int PRECIO_2 = 120;
    protected static final int PRECIO_3 = 200;
    protected static final int PRECIO_4 = 170;
    protected static final int PRECIO_5 = 100;

    public Sandwich() {
    }

    public Sandwich(String type, int price, List<Ingredient> ingredients) {
        this.ingredients= ingredients;
        this.type = type;
        this.price = price;
        this.state = false;//por preparar
    }

    private List<Ingredient> addIngredients (Ingredient ingredient1, Ingredient ingredient2){
        ingredients= new ArrayList<Ingredient>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        return ingredients;
    }

    private Sandwich initializeSandwich(String type, int price,List<Ingredient> ingredients ) {
        //this.total += price;
        return new Sandwich(type, price, ingredients);
    }

    public Sandwich selectSandwich(int i) {
        Sandwich sandwich = null;

        switch(i) {

            case 1:
                sandwich = initializeSandwich(OPCION_1, PRECIO_1,addIngredients(ingredient=new Ham("jamon crudo", 100),ingredient=new Cheese("danbo", 100)));

                break;

            case 2:
                sandwich = initializeSandwich(OPCION_2, PRECIO_2,addIngredients(ingredient=new Ham("jamon cocido", 100),ingredient=new Cheese("danbo", 100)));
                break;

            case 3:
                sandwich = initializeSandwich(OPCION_3, PRECIO_3,addIngredients(ingredient=new Ham("jamon crudo", 100),ingredient=new Cheese("chedar", 100)));
                break;

            case 4:
                sandwich = initializeSandwich(OPCION_4, PRECIO_4,addIngredients(ingredient=new Ham("jamon cocido", 100),ingredient=new Cheese("chedar", 100)));
                break;

            case 5:
                sandwich = initializeSandwich(OPCION_5, PRECIO_5, addIngredients(ingredient=new Salami("salami", 100),ingredient=new Cheese("danbo", 100)));
                break;

            default:
                System.out.println("No sandwich selected");
                break;
        }
        return sandwich;
    }


    public void addBread(Bread bread) {
        this.setBread(bread);
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public Bread getBread() {
        return bread;
    }
    public void setBread(Bread bread) {
        this.bread = bread;
    }


    public String toString() {
        return "Sandwich: " + this.type;
    }

}