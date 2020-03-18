package ejercicioOtraVez;

public class CreditCard implements Payment{

    @Override
    public int pay(int amount) {
        return amount;
    }


    public String toString() {
        return "credit card";
    }

}