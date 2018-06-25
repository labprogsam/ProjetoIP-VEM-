package Excecoes;

public class EmpresaNaoEncontradaException extends Exception {
	
	public EmpresaNaoEncontradaException() {
		super("Empresa nao cadastrada.");
	}
}
