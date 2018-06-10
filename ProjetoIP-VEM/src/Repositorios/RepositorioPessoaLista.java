package Repositorios;

import ClassesBasicas.Pessoa;

public class RepositorioPessoaLista implements InterfaceRepositorioPessoa{
	
	private Pessoa pessoa;
	private RepositorioPessoaLista proximo;
	
	public RepositorioPessoaLista() {
		this.pessoa = null;
		this.proximo = null;
	}
	
	public void inserir(Pessoa pessoa) {
		if(this.pessoa == null) {
			this.pessoa = pessoa;
			this.proximo = new RepositorioPessoaLista();
		}
		else if(this.pessoa.getCpf().equals(pessoa.getCpf())) {
			//exceção
		}
		else {
			this.proximo.inserir(pessoa);
		}
	}

	public void atualizar(Pessoa pessoa) {
		if(this.pessoa == null) {
			//exceção
		}
		else if(this.pessoa.getCpf().equals(pessoa.getCpf())) {
				this.pessoa = pessoa;
		}
		
		this.proximo.atualizar(pessoa);
	}

	public void remover(String cpf) {
		if(this.pessoa == null) {
			//exceção
		}
		else if(this.pessoa.getCpf().equals(cpf)) {
			this.pessoa = this.proximo.pessoa;
			this.proximo = this.proximo.proximo;
		}
		
		this.proximo.remover(cpf);
	}

	public Pessoa procurar(String cpf) {
		if(this.pessoa == null) 
			// exceção
		if(this.pessoa.getCpf().equals(cpf))
			return this.pessoa;
		return this.proximo.procurar(cpf);
	}

	public boolean existe(String cpf) {
		if(this.pessoa == null)
			return false;
		else if(this.pessoa.getCpf().equals(cpf))
			return true;
		return this.proximo.existe(cpf);
	}

}
