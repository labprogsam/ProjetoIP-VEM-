package Repositorios;
import ClassesBasicas.Pessoa;

public class RepositorioPessoaArray implements InterfaceRepositorioPessoa {
	Pessoa[] pessoas;
	private int indice;

	
//falta colocar as exceçoes aqui
	public RepositorioPessoaArray() {
		this.indice = 0;
		this.pessoas = new Pessoa[100];
	}
	
	public void inserir(Pessoa pessoa) {
		if(existe(pessoa.getCpf())) {
			//exceção
		}
		else {
			this.pessoas[indice] = pessoa;
			this.indice ++;
		}
	}

	public void atualizar(Pessoa pessoa) {
		boolean pessoa_encontrada = false;
		for(int i = 0; i < this.indice && pessoa_encontrada == false; i++) {
			if(this.pessoas[i].getCpf().equals(pessoa.getCpf()))
				this.pessoas[i] = pessoa;
		}
	}

	public void remover(String cpf) {
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
		}
		else {
			//exceção
		}
		this.indice -- ;
	}

	public Pessoa procurar(String cpf) { 
		for(int i = 0; i < this.indice; i++) {
			if(this.pessoas[i].getCpf().equals(cpf))
				return this.pessoas[i];
		}
		//exceção
		return null;
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
