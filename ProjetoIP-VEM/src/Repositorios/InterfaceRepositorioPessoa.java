package Repositorios;
import ClassesBasicas.Pessoa;

public interface InterfaceRepositorioPessoa {
	public void inserir(Pessoa pessoa);
	public void atualizar(Pessoa pessoa);
	public void remover(String cpf);
	public Pessoa procurar(String cpf);
	public boolean existe(String cpf);
//ainda falta adicionar as exceções
}
