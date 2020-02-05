package e12;

public class Vehiculo {

protected int id ;

protected double tarrifa;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTarrifa(double tarrifa) {
        this.tarrifa = tarrifa;
    }

    public double getTarrifa() {
        return tarrifa;
    }

    public Vehiculo() {
    }

    public Vehiculo(int id) {
        this.id = id;
    }

    public Vehiculo(double tarrifa) {
        this.tarrifa = tarrifa;
    }

    public Vehiculo(int id ,double tarrifa) {
        this.tarrifa = tarrifa;
        this.id = id;
    }

}
