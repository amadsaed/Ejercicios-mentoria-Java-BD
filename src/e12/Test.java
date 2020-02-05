package e12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public  class Test {

    int contadorTarrifas = 0;

    Vehiculo vehiculo = new Vehiculo();

    Queue<Vehiculo> cola = new LinkedList<>();



    public Vehiculo crearVehiculo (){
        Random rand1 = new Random();
        int n1 = rand1.nextInt(7);
        System.out.println(n1);

        switch (n1){

            case 0 :
                vehiculo = new Ambulancia();
                break;
            case 1 :
                vehiculo = new Bombero();
                break;
            case 2:
                vehiculo = new Policía();
                break;
            case 3:
                vehiculo = new Moto();
                break;
            case 4 :
                vehiculo = new Auto2Puertas();
                break;
            case 5:
                vehiculo = new Auto4Puertas();
                break;
            case 6:
                vehiculo = new Camion();
                break;
        }
        return vehiculo;

    }

    public void crearVehiculoFrecuentementeEnCola(){
        Random rand2 = new Random();

        double n2 = rand2.nextDouble();

        System.out.println(n2);
        if (n2 >= 0.5){
            System.out.println("creando vehiculo !");

            Vehiculo vehNuevo = crearVehiculo();
            agregarVehiculo(vehNuevo);

        }
        else {
            System.out.println("no hay vehiculos !");
        }
        System.out.println(cola);
    }

    public  void agregarVehiculo(Vehiculo vehiculo){
        cola.add(vehiculo);


    }


    public int calcularGanancia (){

        while(!this.cola.isEmpty()) {

            contadorTarrifas += this.cola.poll().getTarrifa();

        }
        return contadorTarrifas;
    }

    public static void main(String[] args) {


        Test test= new Test();
      for(int i = 0; i < 20; i++) {
          test.crearVehiculoFrecuentementeEnCola();

      }
        System.out.println("la ganancia es :"+ test.calcularGanancia());
    }

}
