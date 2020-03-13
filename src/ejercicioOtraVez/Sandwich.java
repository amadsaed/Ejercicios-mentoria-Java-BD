package ejercicioOtraVez;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private List<Ingredient> ingredients;
    private Boolean isReady;
    private int price ;
    private int idSandwich;

    public Sandwich(int id, int price, List<Ingredient> ingredients){
        this.idSandwich = id;
        this.ingredients = ingredients;
        this.price = price;
        this.isReady = false;
    }

    public void addIngredients(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

}
