package Excecoes;

public class EntrarFeriasException extends Exception {
    public EntrarFeriasException()
    {
        super("O usuario do vem ja está de ferias");
    }
}
