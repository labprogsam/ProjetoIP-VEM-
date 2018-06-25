package Excecoes;

public class VemJaCadastradoException extends Exception {
    private String codigo;

    public VemJaCadastradoException(String codigo)
    {
        super("Vem ja cadastrado");
        this.codigo = codigo;
    }

    public String getCodigo()
    {
        return this.codigo;
    }
}
