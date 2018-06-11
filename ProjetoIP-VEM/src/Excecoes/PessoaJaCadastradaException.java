package Excecoes;

public class PessoaJaCadastradaException extends Exception{
	public PessoaJaCadastradaException() {
		super("Essa pessoa já tem um cadastro no sistema");
	}
}
