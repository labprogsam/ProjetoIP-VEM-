package Excecoes;

public class RepositorioPessoaCheioException extends Exception{
	public RepositorioPessoaCheioException() {
		super("O Repositório de pessoas está cheio.");
	}
}
