package Excecoes;

public class RepositorioPessoaCheioException extends Exception{
	public RepositorioPessoaCheioException() {
		super("O Repositorio de pessoas esta cheio.");
	}
}
