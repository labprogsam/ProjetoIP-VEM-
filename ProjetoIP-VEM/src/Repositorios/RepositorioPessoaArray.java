package Repositorios;
import ClassesBasicas.Pessoa;
import Excecoes.PessoaJaCadastradaException;
import Excecoes.RepositorioPessoaCheioException;
import Excecoes.PessoaNaoEncontradaException;

public class RepositorioPessoaArray implements InterfaceRepositorioPessoa {
	private Pessoa[] pessoas;
	private int indice;

	
	public RepositorioPessoaArray() {
		this.indice = 0;
		this.pessoas = new Pessoa[100];
	}
	
	public void inserir(Pessoa pessoa) throws RepositorioPessoaCheioException{
		if(this.indice >= this.pessoas.length) {
			throw new RepositorioPessoaCheioException();
		}
		else {
			this.pessoas[indice] = pessoa;
			this.indice ++;
		}
	}

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException{
		boolean pessoa_encontrada = false;
		if(existe(pessoa.getCpf())) {
			for(int i = 0; i < this.indice && pessoa_encontrada == false; i++) {
				this.pessoas[i] = pessoa;
			}
		}else {
			throw new PessoaNaoEncontradaException();
		}
	}

	public void remover(String cpf) throws PessoaNaoEncontradaException{
		boolean moverPessoa = false;
		if(existe(cpf)) {
			for(int i = 0; i < this.indice; i++) {
				if(moverPessoa) {
					this.pessoas[i-1] = this.pessoas[i];
				}
				else {
					if(this.pessoas[i].getCpf().equals(cpf))
						moverPessoa = true;
						this.pessoas[i] = null;
				}
			}
			this.indice -- ;
		}else {
			throw new PessoaNaoEncontradaException();
		}
	}

	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException { 
		for(int i = 0; i < this.indice; i++) {
			if(this.pessoas[i].getCpf().equals(cpf))
				return this.pessoas[i];
		}
		throw new PessoaNaoEncontradaException();
	}

	public boolean existe(String cpf) {
		boolean pessoa_encontrada = false; 
		for(int i = 0; i < this.indice && pessoa_encontrada == false; i++) {
			if(this.pessoas[i].getCpf().equals(cpf))
				pessoa_encontrada = true;
		}
		return pessoa_encontrada;
	}	
}
