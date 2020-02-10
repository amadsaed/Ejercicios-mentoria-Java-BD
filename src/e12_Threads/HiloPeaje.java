package e12_Threads;

import java.util.concurrent.BlockingQueue;

public class HiloPeaje extends Thread {

    boolean hayVehiculoEmergencia = false;

    BlockingQueue<Vehiculo> cola ;

    public HiloPeaje(BlockingQueue<Vehiculo> cola) {
        this.cola = cola;
    }

    public int calcularGanancia (){

        if (!Test.cola.isEmpty()){
            Vehiculo v = Test.cola.poll();
            Test.contadorTarrifas += v.getTarrifa();
            System.out.println("cobrando "+ v + " "+ v.getTarrifa());
        }

        return Test.contadorTarrifas;
    }

    public void run(){

        if (!Test.cola.isEmpty()){

            if (hayVehiculoEmergencia){

                int i = 0;

                while (!(Test.cola.peek() instanceof Emergencia)){
                    i++;
                    Test.cola.poll();

                }
                Test.cola.poll();

                hayVehiculoEmergencia= false;

                System.out.println("dejando pasar "+ i++ + " autos");

            }
            else {
                calcularGanancia();
            }

        }


    }


}
