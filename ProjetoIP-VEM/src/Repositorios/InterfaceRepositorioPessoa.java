package Repositorios;
import ClassesBasicas.Pessoa;
import Excecoes.PessoaJaCadastradaException;
import Excecoes.RepositorioPessoaCheioException;
import Excecoes.PessoaNaoEncontradaException;

public interface InterfaceRepositorioPessoa {
	void inserir(Pessoa pessoa)
		throws RepositorioPessoaCheioException,
		PessoaJaCadastradaException;
	
	void atualizar(Pessoa pessoa)
		throws PessoaNaoEncontradaException;
	
	void remover(String cpf)
		throws PessoaNaoEncontradaException;
		
	Pessoa procurar(String cpf)
		throws PessoaNaoEncontradaException;
		
	boolean existe(String cpf)
		throws PessoaNaoEncontradaException;
		
}
