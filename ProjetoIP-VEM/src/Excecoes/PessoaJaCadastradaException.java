package Excecoes;

public class PessoaJaCadastradaException extends Exception{
	public PessoaJaCadastradaException() {
		super("Essa pessoa ja tem um cadastro no sistema");
	}
}
