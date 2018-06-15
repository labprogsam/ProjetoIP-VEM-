package Excecoes;

public class DesbloquearVemException extends Exception{
    public DesbloquearVemException()
    {
        super("O vem ja está desbloqueado");
    }
}
