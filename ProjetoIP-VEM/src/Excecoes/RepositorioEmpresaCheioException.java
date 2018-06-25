package Excecoes;

public class RepositorioEmpresaCheioException extends Exception {

	public RepositorioEmpresaCheioException() {
		super("O Repositorio de empresas esta cheio.");
	}
}
