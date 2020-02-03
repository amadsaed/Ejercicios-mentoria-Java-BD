package e14;

public class CuentaBloqueada extends EstadoCuenta {


    @Override
    public double retirar(double saldoActual, double cantidadARetirar) throws CuentaBloqueadaException {

        throw new CuentaBloqueadaException("no se puede retirar dinero porque la cuenta esta bloqueado");
    }

    @Override
    public double depositar(double saldoActual, double cantidadADepositar) throws CuentaBloqueadaException {
        throw new CuentaBloqueadaException("no se puede depositar dinero porque la cuenta esta bloqueado");

    }

}
