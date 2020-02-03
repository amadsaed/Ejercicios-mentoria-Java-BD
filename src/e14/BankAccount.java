package e14;

public class BankAccount {

    private double saldo;
    private EstadoCuenta estado;
    private int contadorFallidos = 0;

    public BankAccount(){
        saldo=100;
        estado =  new  CuentaActiva();
    }


    public void mostrarSaldo (){
        System.out.println(saldo);
    }

    public void retirarDinero(double cantidad)  {

        try {
            saldo= estado.retirar(saldo,cantidad);
            if (saldo==0){
                estado = new CuentaVacia();
            }

        }catch (CuentaBloqueadaException e){

            System.out.println("ocurrió una excepcion "+ e.getMessage());

        }catch (SinSaldoException e){

             contadorFallidos += 1;

            System.out.println("ocurrió una excepcion "+ e.getMessage());

            if (contadorFallidos==3){
                bloquearCuenta();
            }

        }catch (Exception e){

            System.out.println("ocurrió una excepcion "+ e.getMessage());
        }
    }

    private  void bloquearCuenta (){
        estado= new CuentaBloqueada();
    }

    public void depositarDinero (double cantidadADepositar){
        try {
            contadorFallidos=0;
            saldo= estado.depositar(saldo,cantidadADepositar);
            if (estado instanceof CuentaVacia){
                estado = new CuentaActiva();
            }

        } catch (CuentaBloqueadaException e) {
            System.out.println("ocurrió una excepcion "+ e.getMessage());
        }
    }


    public void desbloquear(){
        if (estado instanceof CuentaBloqueada){
            estado = new CuentaVacia();
            System.out.println("la cuenta se desbloqueó !!");

        }else {
            System.out.println("la cuenta no esta bloqueada !!");
        }
    }



}
