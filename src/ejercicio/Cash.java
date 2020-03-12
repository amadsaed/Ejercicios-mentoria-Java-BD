package ejercicio;

public class Cash implements Payment{

    @Override
    public int pay(int amount) {
        return amount;
    }

}