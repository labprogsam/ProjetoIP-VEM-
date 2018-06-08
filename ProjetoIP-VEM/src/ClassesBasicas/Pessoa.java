package ClassesBasicas;

public class Pessoa {
	private String nome;
	private String cpf;
	private String rg;
	private int idade;
	private char sexo;
	private String endereco;
	private String profissao;
	
	public Pessoa(String nome, String cpf, String rg, int idade,char sexo,String endereco,String profissao) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.idade = idade;
		this.sexo = sexo;
		this.endereco = endereco;
		this.profissao = profissao;
	}
}
