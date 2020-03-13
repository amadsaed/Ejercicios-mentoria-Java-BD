package ejercicioOtraVez;

import ejercicio.NotEnoughCashException;

public class Client {
    private static final int CASH = 1;
    private int availableAmount;
    private Payment payment;

    public Client(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public int pay(int typePay, int amount) throws NotEnoughCashException {
        if(typePay == CASH) {
            this.payment = new Cash();
            if(this.availableAmount < amount) {
                throw new NotEnoughCashException("You do not have enough money to pay");
            }else {
                this.availableAmount -= amount;
                return payment.pay(amount);
            }
        }else {
            this.payment = new CreditCard();
            return this.payment.pay(amount);
        }
    }
}
