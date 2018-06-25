import ClasseFachadaGeral.AgenciaVem;
import ClassesFachadaIndividual.*;
import Repositorios.*;
import ClassesBasicas.*;
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
		CadastroEmpresa cadEmpresa = new CadastroEmpresa(repEmpresa); 
		CadastroVem cadVem = new CadastroVem(repVem);
		CadastroPessoa cadPessoa = new CadastroPessoa(repPessoa);
		EmpresaVem empresa = null;
		Vem vem = null;
		Pessoa pessoa = null;
		
		AgenciaVem sistema = new AgenciaVem(cadVem, cadEmpresa, cadPessoa);
		
		while(!sair) {
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("1 - Vem");
			System.out.println("2 - Empresa");
			System.out.println("3 - Sair");
			System.out.println("--------------------------------------------------------------------------------------");
			op = in.nextLine();
			
			if(op.equals("1")) {
				boolean sairVem = false;
				String opVem; 
				while(!sairVem) {
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.println("1 - Criar Vem");
					System.out.println("2 - Recarregar Vem");					
					System.out.println("3 - Bloquear Vem");
					System.out.println("4 - Excluir Vem");
					System.out.println("5 - Relatorio");					
					System.out.println("6 - Sair");
					System.out.println("--------------------------------------------------------------------------------------");
					opVem = in.nextLine();
					
					if(opVem.equals("1")) {
						System.out.println("--------------------------------------------------------------------------------------");
						System.out.println("Qual tipo de vem você deseja criar:");
						System.out.println("1 - Vem Comum");						
						System.out.println("2 - Vem Trabalhador");
						System.out.println("3 - Vem Estudantil");
						System.out.println("4 - Vem Livre");
						System.out.println("--------------------------------------------------------------------------------------");
						String tipoVem = in.nextLine();
						if(tipoVem.equals("1") || tipoVem.equals("2") || tipoVem.equals("3") || tipoVem.equals("4")) {
							System.out.println("Insira o cpf da pessoa:");
							String cpf = in.nextLine();
							try {
								pessoa = sistema.procurarPessoa(cpf);
								if((pessoa.isVemComum() && tipoVem.equals("1")) || (pessoa.isVemTrabalhador() && tipoVem.equals("2")) || (pessoa.isVemEstudante() && tipoVem.equals("3")) || (pessoa.isVemLivre() && tipoVem.equals("4"))) {
									System.out.println("Essa pessoa já tem um vem desse tipo cadastrado!");
									pessoa = null;
									} 
								}
							 catch (NumberFormatException | PessoaNaoEncontradaException e) {
								System.out.println(e);
								System.out.println("Você deseja inserir uma nova pessoa com o cpf"+ cpf +"? (S ou N)");
								if(in.nextLine().equals("S")) {
									System.out.println("Insira o nome da pessoa:");
									String nome = in.nextLine();
									System.out.println("Insira o rg:");
									String rg = in.nextLine();
									System.out.println("Insira a idade:");
									int idade = Integer.parseInt(in.nextLine());
									System.out.println("Insira o sexo:");
									char sexo = in.nextLine().toLowerCase().charAt(0);
									System.out.println("Insira o endereco:");
									String endereco = in.nextLine();
									System.out.println("Insira a profissao:");
									String profissao = in.nextLine();
									pessoa = new Pessoa(nome,cpf,rg,idade,sexo,endereco,profissao);
								}
							}
							
							if(pessoa != null) {
								System.out.println("Insira o cnpj da Empresa:");
								String cnpj = in.nextLine();
								try {
									empresa = sistema.procurarEmpresa(cnpj);
									System.out.println("Insira o codigo do Vem:");
									String codigo = in.nextLine();
									if(tipoVem.equals("1"))
										vem = new VemComum(codigo,pessoa, empresa);
									else if(tipoVem.equals("2"))
										vem = new VemTrabalhador(codigo,pessoa, empresa);
									else if(tipoVem.equals("3"))
										vem = new VemEstudantil(codigo,pessoa, empresa);
									else 
										vem = new VemLivre(codigo,pessoa, empresa);
									
									sistema.cadastrarPessoa(pessoa);
									sistema.cadastrarVem(vem, pessoa, empresa);
									if(tipoVem.equals("1"))
										pessoa.setVemComum(true);
									else if(tipoVem.equals("2"))
										pessoa.setVemTrabalhador(true);
									else if(tipoVem.equals("3"))
										pessoa.setVemEstudante(true);
									else 
										pessoa.setVemLivre(true);
									
								} catch (EmpresaNaoEncontradaException | PessoaJaCadastradaException | RepositorioPessoaCheioException | PessoaNaoEncontradaException | VemJaCadastradoException | RepositorioVemCheioException e) {
									System.out.println(e);
								}
							}
							
							
						}else {
							System.out.println("Opa!! Você inseriu uma opcao invalida.");							
						}
						
					}else if(opVem.equals("2")) {
						//implementando
							
					}else if(opVem.equals("3")) {
						String codigo;
						System.out.println("Insira o código:");
						codigo = in.nextLine();
						try {
							sistema.bloquearVem(codigo);
						} catch (BloquearVemException |VemNaoEncontradoException e) {
							System.out.println(e);
						}
							
					}else if(opVem.equals("4")) {
						String codigo;
						System.out.println("Insira o código:");
						codigo = in.nextLine();
						try {
							vem = sistema.procurarVem(codigo);
							if(vem instanceof VemLivre)
								vem.getUsuario().setVemLivre(false);
							else if(vem instanceof VemTrabalhador)
								vem.getUsuario().setVemTrabalhador(false);
							else if(vem instanceof VemEstudantil)
								vem.getUsuario().setVemEstudante(false);
							else if(vem instanceof VemComum)
								vem.getUsuario().setVemComum(false);
							sistema.removerVem(codigo);
						} catch (VemNaoEncontradoException e) {
							System.out.println(e);
						}
					}else if(opVem.equals("5")) {
						System.out.println(sistema.relatorioVem());
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
						System.out.println("Insira o endreco:");
						String endereco = in.nextLine();
						System.out.println("Insira o telefone:");
						String telefone = in.nextLine();
						empresa = new EmpresaVem(nome,cnpj,endereco,telefone);
						try {
							sistema.cadastrarEmpresa(empresa);
						} catch (EmpresaJaCadastradaException e) {
							System.out.println(e);							
						} catch (RepositorioEmpresaCheioException e) {
							System.out.println(e);
						}
					
						
					}else if(opEmpresa.equals("2")) {
						System.out.println("Insira o cnpj da empresa que voce deseja alterar:");
						System.out.println("(Insira 0 caso deseje voltar:)");
						String cnpj =  in.nextLine();
						while(!cnpj.equals("0")) {
								try {
									empresa = sistema.procurarEmpresa(cnpj);
									String opAtualizarVem;
									System.out.println("--------------------------------------------------------------------------------------");
									System.out.println("1 - Alterar nome");			
									System.out.println("2 - Alterar endereco");			
									System.out.println("3 - Alterar telefone");
									System.out.println("--------------------------------------------------------------------------------------");
									opAtualizarVem = in.nextLine();
									if(opAtualizarVem.equals("1") || opAtualizarVem.equals("2") || opAtualizarVem.equals("3")) {
										if(opAtualizarVem.equals("1")) {
											System.out.println("Insira o novo nome da empresa:");
											empresa.setNomeEmpresa(in.nextLine());
										}else if(opAtualizarVem.equals("2")) {
											System.out.println("Insira o novo endereco da empresa:");
											empresa.setEndereco(in.nextLine());
										}else {
											System.out.println("Insira o novo telefone da empresa:");
											empresa.setFone(in.nextLine());
										}
										System.out.println("Alteracao realizada com sucesso!!!");
										cnpj = "0";
									}
								} catch (EmpresaNaoEncontradaException e) {
									System.out.println(e);
									System.out.println("Insira o cnpj novamente:");
									System.out.println("(Insira 0 caso deseje voltar:)");
								}
						}
						
						
					}else if(opEmpresa.equals("3")) {
						//implementando excluir
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
