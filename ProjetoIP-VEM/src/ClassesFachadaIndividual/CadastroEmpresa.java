package ClassesFachadaIndividual;
import Excecoes.EmpresaJaCadastradaException;
import Excecoes.EmpresaNaoEncontradaException;
import ClassesBasicas.EmpresaVem;
import Excecoes.RepositorioEmpresaCheioException;
import Repositorios.InterfaceRepositorioEmpresa;


	//-------------------------------------Classe Fachada Empresa---------------------------------------//

	public class CadastroEmpresa {
							
	private InterfaceRepositorioEmpresa repContas;
	
	public CadastroEmpresa (InterfaceRepositorioEmpresa rep)  {
		this.repContas = rep;
	}
	
	//--------------------------------------Cadastrar Empresa------------------------------------------//
	public void cadastrarEmpresa (EmpresaVem empresa) throws EmpresaJaCadastradaException, RepositorioEmpresaCheioException {
		if(this.repContas.existe(empresa.getCnpj()) == false) {
			this.repContas.inserir(empresa);
		} else {
			throw new EmpresaJaCadastradaException();
		}
	}
	
	//-------------------------------------Remover Empresa--------------------------------------------//
	public void removerEmpresa (String cnpj) throws EmpresaNaoEncontradaException  {
		this.repContas.remover(cnpj);
	}
	
	//------------------------------------Atualizar Empresa-------------------------------------------//
	public void atualizarEmpresa (EmpresaVem empresa) throws EmpresaNaoEncontradaException {
		this.repContas.atualizarEmpresa(empresa);
	}
	
	//---------------------------------------Verificador----------------------------------------------//
	public boolean existeEmpresa (String cnpj) {
		return this.repContas.existe(cnpj);
	}
	
	//-------------------------------------Procurar Empresa--------------------------------------------//
	public EmpresaVem procurarEmpresa (String cnpj) throws EmpresaNaoEncontradaException {
		return this.repContas.procurar(cnpj);
	}
	
	
	
	
	
}
