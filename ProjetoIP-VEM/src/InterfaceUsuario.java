import ClasseFachadaGeral.AgenciaVem;
import ClassesFachadaIndividual.*;
import Repositorios.*;
import Excecoes.*;
import java.util.Scanner;

public class InterfaceUsuario {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String op;
		boolean sair = false;
		RepositorioEmpresasLista repEmpresa = new RepositorioEmpresasLista(); 
		RepositorioPessoaLista repPessoa = new RepositorioPessoaLista(); 
		RepositorioVemLista repVem = new RepositorioVemLista(); 
		CadastroEmpresa empresa = new CadastroEmpresa(repEmpresa); 
		CadastroVem vem = new CadastroVem(repVem);
		CadastroPessoa pessoa = new CadastroPessoa(repPessoa);
		AgenciaVem sistema = new AgenciaVem(vem, empresa, pessoa);
		
		while(!sair) {
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("1 - Vem");
			System.out.println("2 - Empresa");
			System.out.println("3 - Sair");
			System.out.println("--------------------------------------------------------------------------------------");
			op = in.next();
			if(op.equals("1")) {
				boolean sairVem = false;
				String opVem; 
				while(!sairVem) {
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.println("1 - Criar Vem");
					System.out.println("2 - Recarregar Vem");			
					System.out.println("3 - Atualizar Vem");			
					System.out.println("4 - Bloquear Vem");			
					System.out.println("5 - Excluir Vem");
					System.out.println("6 - Sair");
					System.out.println("--------------------------------------------------------------------------------------");
					opVem = in.next();
					if(opVem.equals("1")) {
						//implentando
					}else if(opVem.equals("2")) {
						//implentando
					}else if(opVem.equals("3")) {
						//implentando
					}else if(opVem.equals("4")) {
						//implentando
					}else if(opVem.equals("5")) {
						//implentando
					}else if(opVem.equals("6")) {
						sairVem = true;
					}else {
						System.out.println("Entrada invalida!!!");
					}
				}
				
				
				
			
			}else if(op.equals("2")) {
				boolean sairEmpresa = false;
				String opEmpresa; 
				while(!sairEmpresa) {
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.println("1 - Criar Empresa");			
					System.out.println("2 - Atualizar Empresa");			
					System.out.println("3 - Excluir Empresa");
					System.out.println("4 - Sair");
					System.out.println("--------------------------------------------------------------------------------------");
					opEmpresa = in.next();
					if(opEmpresa.equals("1")) {
						//implentando
					}else if(opEmpresa.equals("2")) {
						//implentando
					}else if(opEmpresa.equals("3")) {
						//implentando
					}else if(opEmpresa.equals("4")) {
						sairEmpresa = true;
					}else {
						System.out.println("Entrada invalida!!!");
					}
				}
				
			}else if(op.equals("3")) {
				sair = true;
			}else {
				System.out.println("Entrada invalida!!!");
			}
			
		}
	}

}
