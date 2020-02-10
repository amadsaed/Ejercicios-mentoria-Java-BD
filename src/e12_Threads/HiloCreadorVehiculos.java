package e12_Threads;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class HiloCreadorVehiculos extends Thread {

    Vehiculo vehiculo = new Vehiculo();

    BlockingQueue<Vehiculo> cola ;

    public HiloCreadorVehiculos(BlockingQueue<Vehiculo> cola) {
        this.cola = cola;
    }

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
                vehiculo = new Policia();
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

    public  void agregarVehiculo(Vehiculo vehiculo){
        Test.cola.add(vehiculo);


    }

    public void run(){

            boolean hayVehiculoEmergencia = false;

            Random rand2 = new Random();

            double n2 = rand2.nextDouble();

            double n3= rand2.nextInt(10);

            System.out.println(n2);

            if (n2 >= 0.5){


                for (int i =0 ; i < n3 ; i++){

                    System.out.println("creando vehiculo !");

                    Vehiculo vehNuevo = crearVehiculo();

                    while (hayVehiculoEmergencia && vehNuevo instanceof Emergencia){
                        vehNuevo= crearVehiculo();
                    }

                    if(vehNuevo instanceof Emergencia){

                        hayVehiculoEmergencia= true;
                    }

                    agregarVehiculo(vehNuevo);

                }

            }
            else {
                System.out.println("no hay nuevos vehiculos !");
            }
            System.out.println(Test.cola);
        }
    }
