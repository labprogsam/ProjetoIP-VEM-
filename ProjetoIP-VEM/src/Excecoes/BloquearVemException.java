package Excecoes;

public class BloquearVemException extends Exception {
    public BloquearVemException()
    {
        super("O vem ja está bloqueado");
    }
}
