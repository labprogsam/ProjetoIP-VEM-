package Excecoes;

public class EmpresaJaCadastradaException extends Exception {
	
	public EmpresaJaCadastradaException () {
		super("Empresa já cadastrada.");
	}
	
}
