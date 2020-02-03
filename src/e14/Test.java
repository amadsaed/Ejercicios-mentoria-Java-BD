package e14;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();

        Scanner entradaEscaner = new Scanner (System.in);

        char entradaTeclado;

        do {

            System.out.println("Ingrese su opcion: ");
            System.out.println("Retirar Dinero -- 1");
            System.out.println("Depositar Dinero -- 2");
            System.out.println("Ver saldo -- 3");
            System.out.println("Salir -- 4");

            entradaTeclado = entradaEscaner.nextLine().charAt(0);

            switch(entradaTeclado) {

                case '1':
                    System.out.println("Ingrese la cantidad a Retirar de dinero");
                    double cantidadRitirar = Double.parseDouble(entradaEscaner.nextLine());
                    bankAccount.retirarDinero(cantidadRitirar);
                    break;

                case '2':
                    System.out.println("Ingrese la cantidad a Depositar de dinero");
                    double cantidadDepositar = Double.parseDouble(entradaEscaner.nextLine());
                    bankAccount.depositarDinero(cantidadDepositar);

                    break;

                case '3':
                    bankAccount.mostrarSaldo();
                    break;
            }
        }while(entradaTeclado != '4');

}
}
