package Excecoes;

public class VemJaCadastradoException extends Exception {
    private String codigo;

    public VemJaCadastradoException()
    {
        super("Vem já cadastrado");
    }

    public String getCodigo()
    {
        return this.codigo;
    }
}
