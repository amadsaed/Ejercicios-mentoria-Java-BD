package e12;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public  class Test1 {

    int contadorTarrifas = 0;

    Vehiculo vehiculo = new Vehiculo();

    Queue<Vehiculo> cola = new LinkedList<>();

    boolean hayVehiculoEmergencia = false;

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

    public void crearVehiculoFrecuentementeEnCola() throws InterruptedException {

        int sleep = 5000;

        Random rand2 = new Random();

        double n2 = rand2.nextDouble();

        double n3= rand2.nextInt(10);

        System.out.println(n2);

        if (n2 >= 0.5){

            Thread.sleep(sleep);

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
        System.out.println(cola);
    }

    public  void agregarVehiculo(Vehiculo vehiculo){
        cola.add(vehiculo);


    }

    public int calcularGanancia (){

        if (!cola.isEmpty()){
            Vehiculo v = this.cola.poll();
            contadorTarrifas += v.getTarrifa();
            System.out.println("cobrando "+ v + " "+ v.getTarrifa());
        }

        return contadorTarrifas;
    }

    public void atenderVehiculo(){

        if (!cola.isEmpty()){

            if (hayVehiculoEmergencia){

                int i = 0;

                while (!(cola.peek() instanceof Emergencia)){
                    i++;
                    cola.poll();

                }
                cola.poll();

                hayVehiculoEmergencia= false;

                System.out.println("dejando pasar "+ i++ + " autos");

            }
            else {
                calcularGanancia();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {

        e12.Test1 test= new e12.Test1();

            final long EXECUTION_TIME = 2;

            // Guarda la hora de comienzo
            LocalTime start = LocalTime.now();

            // Se actualiza a cada instante
            LocalTime current;

            // Guarda el tiempo de ejecucion
            long interval = 0;

            System.out.println(start);

            // Mientras no haya pasado X minuto de ejecucion
            while (interval != EXECUTION_TIME) {

                test.crearVehiculoFrecuentementeEnCola();

                test.atenderVehiculo();

                current = LocalTime.now();

               // System.out.println(current);

			/* Calcula el tiempo que paso entre el inicio
			y el momento actual*/
                interval = ChronoUnit.MINUTES.between(start, current);
            }

            System.out.println("la ganancia total es: " + test.contadorTarrifas);

            LocalTime end = LocalTime.now();

            System.out.println("La aplicacion se ejecuto durante " + interval + " Minuto");

            System.out.println("Comenzo a ejecutarse a las: " + start);

            System.out.println("Finalizo a las: " + end);
        }


}
