package ejercicioOtraVez;
import java.sql.Date;

public class Ticket {
    private int number;
    private int amount ;
    private String typePay;
    private Date date;

    public Ticket(int amount, String typePay){
        this.amount = amount;
        this.typePay = typePay;
        this.number = number+1;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTypePay() {
        return typePay;
    }

    public void setTypePay(String typePay) {
        this.typePay = typePay;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
