package Excecoes;

public class SairFeriasException extends Exception{
     public SairFeriasException()
     {
         super("O usuário do vem já está fora do período de férias");
     }
}
