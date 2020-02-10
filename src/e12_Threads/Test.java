package e12_Threads;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public  class Test {

    static BlockingQueue<Vehiculo> cola = new LinkedBlockingQueue<Vehiculo>();

    static int contadorTarrifas = 0;

    public static void main(String[] args) throws InterruptedException {

        Test test= new Test();

        HiloCreadorVehiculos h1 = new HiloCreadorVehiculos(cola);

        HiloPeaje h2 = new HiloPeaje(cola);


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

                Thread.sleep(3000);

                h1.run();

                h2.run();

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
