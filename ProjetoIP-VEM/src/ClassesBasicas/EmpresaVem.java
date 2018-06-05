package ClassesBasicas;

public class EmpresaVem {
	private String nomeEmpresa;
	private String cnpj;
	private String endereco;
	private String fone;
	
	public EmpresaVem (String empresa, String cnpj, String endereco, String fone ) {
		this.nomeEmpresa = empresa;
		this.cnpj = cnpj;
		this.endereco = endereco;;
		this.fone = fone;
			
	}
	public String getNomeEmpresa() {
		return this.nomeEmpresa;
	}
	public void setNomeEmpresa(String NovoNome) {
		this.nomeEmpresa = NovoNome;
	}
	public String getCnpj () {
		return this.cnpj;
	}
	public void setCnpj (String novoCnpj) {
		this.cnpj = novoCnpj;
	}                 
	public String getEndereco () {
		return this.endereco;
	}
	public void setEndereco (String novoEndereco) {
		this.endereco = novoEndereco;
	}
	public String getFone () {
		return this.fone;
	}
	public void setProprietario (String novoFone) {
		this.fone = novoFone;	
	}
	
	
	
}
