package Excecoes;

public class RecargaInvalidaException extends Exception{
    public RecargaInvalidaException()
    {
        super("Valor da recarga é inválido");
    }
}
