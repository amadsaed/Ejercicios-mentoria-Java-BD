package ejercicioOtraVez;

import java.util.List;

public class Sandwich {

    private List<Ingredient> ingredients;
    private int price ;
    private int idSandwich;

    public Sandwich(int id, int price, List<Ingredient> ingredients){
        this.idSandwich = id;
        this.ingredients = ingredients;
        this.price = price;
    }

    public void addIngredients(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }


    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdSandwich() {
        return idSandwich;
    }

    public void setIdSandwich(int idSandwich) {
        this.idSandwich = idSandwich;
    }

    public String toString(){
        return this.idSandwich + ") " +
                "$" + this.price +
                " which has " + this.ingredients.toString() + "\n";
    }




}