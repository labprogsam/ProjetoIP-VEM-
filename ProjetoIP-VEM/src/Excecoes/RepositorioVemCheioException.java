package Excecoes;

public class RepositorioVemCheioException extends Exception {

    public RepositorioVemCheioException()
    {
        super("Armazenamento de vem esta cheio");
    }
}
