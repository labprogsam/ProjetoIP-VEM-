package Excecoes;

public class TipoVemInvalidoException extends Exception {

    public TipoVemInvalidoException()
    {
        super("Esse tipo de vem não é válido para essa operação");
    }
}
