package e14;

public class CuentaActiva extends EstadoCuenta {


    @Override
    public double retirar(double saldoActual, double cantidadARetirar) {
        if (saldoActual != 0 && cantidadARetirar<= saldoActual){
            double saldoNuevo;
            saldoNuevo = saldoActual-cantidadARetirar;
            return saldoNuevo;
        }
        return 0;
    }

    @Override
    public double depositar(double saldoActual, double cantidadADepositar) {
        return saldoActual+cantidadADepositar;
    }


}
