package e14;

public class CuentaVacia extends EstadoCuenta {
    @Override
    public double retirar (double saldoActual, double cantidadARetirar) throws SinSaldoException {

        throw new SinSaldoException("no tenes saldo pobre ");

    }

    @Override
    public double depositar(double saldoActual, double cantidadADepositar) {
        return saldoActual+cantidadADepositar;
    }


}
