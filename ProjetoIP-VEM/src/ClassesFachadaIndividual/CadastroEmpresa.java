package ClassesFachadaIndividual;
import Excecoes.EmpresaJaCadastradaException;
import Excecoes.EmpresaNaoEncontradaException;
import ClassesBasicas.EmpresaVem;
import Repositorios.RepositorioEmpresaArray;
import Repositorios.RepositorioEmpresasLista;
import Excecoes.RepositorioEmpresaCheioException;


	//-------------------------------------Classe Fachada Empresa---------------------------------------//

public class CadastroEmpresa {
							
	private RepositorioEmpresaArray repContas;
	
	public CadastroEmpresa (RepositorioEmpresaArray rep)  {
		this.repContas = rep;
	}
	
	//--------------------------------------Cadastrar Empresa------------------------------------------//
	public void cadastrar (EmpresaVem empresa) throws EmpresaJaCadastradaException, RepositorioEmpresaCheioException {
		if(this.repContas.existe(empresa.getCnpj()) == false) {
			this.repContas.inserir(empresa);
		} else {
			throw new EmpresaJaCadastradaException();
		}
	}
	
	//-------------------------------------Remover Empresa--------------------------------------------//
	public void remover (String cnpj) throws EmpresaNaoEncontradaException  {
		this.repContas.remover(cnpj);
	}
	
	//------------------------------------Atualizar Empresa-------------------------------------------//
	public void atualizar (EmpresaVem empresa) throws EmpresaNaoEncontradaException {
		this.repContas.atualizarEmpresa(empresa);
	}
	
	//---------------------------------------Verificador----------------------------------------------//
	public boolean existe (String cnpj) {
		return this.repContas.existe(cnpj);
	}
	
	//-------------------------------------Procurar Empresa--------------------------------------------//
	public EmpresaVem procurar (String cnpj) throws EmpresaNaoEncontradaException {
		return this.repContas.procurar(cnpj);
	}
	
	
	
	
	
}
