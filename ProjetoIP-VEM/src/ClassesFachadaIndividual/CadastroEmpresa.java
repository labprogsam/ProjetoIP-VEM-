package ClassesFachadaIndividual;
import Excecoes.EmpresaJaCadastradaException;
import Excecoes.EmpresaNaoEncontradaException;
import ClassesBasicas.EmpresaVem;
import Repositorios.RepositorioEmpresaArray;
import Repositorios.RepositorioEmpresasLista;
import Excecoes.RepositorioEmpresaCheioException;

public class CadastroEmpresa {

	private RepositorioEmpresaArray repContas;
	
	public CadastroEmpresa (RepositorioEmpresaArray rep)  {
		this.repContas = rep;
	}
	
	public void cadastrar (EmpresaVem empresa) throws EmpresaJaCadastradaException, RepositorioEmpresaCheioException {
		if(this.repContas.existe(empresa.getCnpj()) == false) {
			this.repContas.inserir(empresa);
		} else {
			throw new EmpresaJaCadastradaException();
		}
	}
	
	public void remover (String cnpj) throws EmpresaNaoEncontradaException  {
		this.repContas.remover(cnpj);
	}
	
	public void atualizar (EmpresaVem empresa) throws EmpresaNaoEncontradaException {
		this.repContas.atualizarEmpresa(empresa);
	}
	
	public boolean existe (String cnpj) {
		return this.repContas.existe(cnpj);
	}
	
	public EmpresaVem procurar (String cnpj) throws EmpresaNaoEncontradaException {
		return this.repContas.procurar(cnpj);
	}
	
	
	
	
	
}
