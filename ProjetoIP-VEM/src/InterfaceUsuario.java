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
					opEmpresa = in.nextLine();
					
					if(opEmpresa.equals("1")) {
						System.out.println("Insira o nome da empresa:");
						String nome = in.nextLine();
						System.out.println("Insira o cnpj da empresa:");
						String cnpj = in.nextLine();
						System.out.println("Insira o endreço:");
						String endereco = in.nextLine();
						System.out.println("Insira o telefone:");
						String telefone = in.nextLine();
						empresa = new EmpresaVem(nome,cnpj,endereco,telefone);
						sistema.cadastrarEmpresa(empresa);
					
						
					}else if(opEmpresa.equals("2")) {
						System.out.println("Insira o cnpj da empresa que você deseja alterar:");
						System.out.println("(Insira 0 caso deseje voltar:)");
						String cnpj =  in.nextLine();
						while(!cnpj.equals("0")) {
							if(sistema.existeEmpresa(cnpj)) {
								empresa = sistema.procurarEmpresa(cnpj);
								String opAtualizarVem;
								System.out.println("--------------------------------------------------------------------------------------");
								System.out.println("1 - Alterar nome");			
								System.out.println("2 - Alterar endereço");			
								System.out.println("3 - Alterar telefone");
								System.out.println("--------------------------------------------------------------------------------------");
								opAtualizarVem = in.nextLine();
								if(opAtualizarVem.equals("1") || opAtualizarVem.equals("2") || opAtualizarVem.equals("3")) {
									if(opAtualizarVem.equals("1")) {
										System.out.println("Insira o novo nome da empresa:");
										empresa.setNomeEmpresa(in.nextLine());
									}else if(opAtualizarVem.equals("2")) {
										System.out.println("Insira o novo endereço da empresa:");
										empresa.setEndereco(in.nextLine());
									}else {
										System.out.println("Insira o novo telefone da empresa:");
										empresa.setFone(in.nextLine());
									}
									System.out.println("Alteração realizada com sucesso!!!");
									cnpj = "0";
								}else {
									System.out.println("ERRO!!!");
									System.out.println("Você não inseriu nenhuma das opções validas!");
								}
							}else {
								System.out.println("ERRO!!!");
								System.out.println("empresa com esse cnpj não foi encontrada!");
								System.out.println("Insira o cnpj novamente:");
								System.out.println("(Insira 0 caso deseje voltar:)");
								cnpj =  in.nextLine();
							}
						}
						
						
					}else if(opEmpresa.equals("3")) {
						System.out.println("Insira o cnpj da empresa que você deseja excluir:");
						System.out.println("(Insira 0 caso deseje voltar)");
						String cnpj =  in.nextLine();
						while(!cnpj.equals("0")) {
							if(sistema.existeEmpresa(cnpj)) {
								sistema.removerEmpresa(cnpj);
								System.out.println("Empresa excluida com sucesso!!!");
								cnpj = "0";
							}
							else {
								System.out.println("ERRO!!!");
								System.out.println("empresa com esse cnpj não foi encontrada!");
								System.out.println("(Insira 0 caso deseje voltar)");
								System.out.println("Insira o cnpj novamente:");
								cnpj =  in.nextLine();
							}
						}
						
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
