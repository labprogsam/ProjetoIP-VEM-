package Repositorios;
import Excecoes.EmpresaJaCadastradaException;
import Excecoes.EmpresaNaoEncontradaException;
import ClassesBasicas.EmpresaVem;
import Excecoes.RepositorioEmpresaCheioException;

public interface InterfaceRepositorioEmpresa {
	 
	void inserir(EmpresaVem empresa)
		throws RepositorioEmpresaCheioException,
		EmpresaJaCadastradaException;
	
	 void remover(String cnpj)
	 	throws EmpresaNaoEncontradaException;
	 
	 void atualizarEmpresa (EmpresaVem empresa)
	 	throws EmpresaNaoEncontradaException;
	 
	 boolean existe (String cnpj);
			 
	 EmpresaVem procurar (String cnpj) 
	 	throws EmpresaNaoEncontradaException;
	 	

}
