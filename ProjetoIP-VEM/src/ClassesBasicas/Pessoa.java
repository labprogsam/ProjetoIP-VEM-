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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}
