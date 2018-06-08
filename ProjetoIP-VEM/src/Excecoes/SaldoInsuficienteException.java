package Excecoes;

public class SaldoInsuficienteException extends Exception {

    private double saldo;
    public SaldoInsuficienteException(double saldo)
    {
        super("Saldo insuficiente");
        this.saldo = saldo;
    }
}
