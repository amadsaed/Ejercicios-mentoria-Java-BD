package e14;

public abstract class EstadoCuenta {

    public abstract double retirar (double saldoActual , double cantidadARetirar) throws SinSaldoException, CuentaBloqueadaException;
    public abstract double depositar (double saldoActual , double cantidadADepositar) throws CuentaBloqueadaException;







}
