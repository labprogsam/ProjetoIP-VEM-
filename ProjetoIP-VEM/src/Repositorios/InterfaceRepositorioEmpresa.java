package Repositorios;
import Excecoes.EmpresaNaoEncontradaException;
import ClassesBasicas.EmpresaVem;
import Excecoes.EmpresaJaCadastradaException;

public interface InterfaceRepositorioEmpresa {
	 
	void inserir(EmpresaVem empresa)
	 	throws EmpresaJaCadastradaException;
	
	 void remover(String cnpj)
	 	throws EmpresaNaoEncontradaException;
	 
	 void atualizarEmpresa (EmpresaVem empresa)
	 	throws EmpresaNaoEncontradaException;
	 
	 boolean existe (String cnpj);
	 	

}
