package ClassesFachadaIndividual;
import Excecoes.EmpresaJaCadastradaException;
import ClassesBasicas.EmpresaVem;
import Repositorios.RepositorioEmpresaArray;

public class CadastroEmpresa {

	private RepositorioEmpresaArray repContas;
	
	public CadastroEmpresa (RepositorioEmpresaArray rep) throws EmpresaJaCadastradaException {
		this.repContas = rep;
	}
	public void cadastrar (EmpresaVem empresa) throws EmpresaJaCadastradaException {
			if(this.repContas.existe(empresa.getCnpj()) == false){
				this.repContas.inserir(empresa);
			} else {
				throw new EmpresaJaCadastradaException ();
			}
			
		
	}
}
