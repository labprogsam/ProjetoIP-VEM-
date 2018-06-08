package Excecoes;

public class RepositorioEmpresaCheioException extends Exception {

	public RepositorioEmpresaCheioException() {
		super("O Repositório de empresas está cheio.");
	}
}
