package Inicio;

import java.util.Scanner;

import Interface.*;
import Dados.*;

public class Inicio {
	public static Scanner input = new Scanner(System.in);
	
	//main
	public static void main(String[] args) {
		Arvore ArvApart = new Arvore();
		Proprietario proprietario;
		Apartamento apartamento;
		char valor;
		Item no;
		long valorConsulta = 0, m2 = 0, vagasCarro = 0, numQuartos = 0, cpf = 0, varNum;
		String codigo = "", nome, telefone = "", email;
		boolean codValido = false;
		
 
		//Nós de teste
		ArvApart.inserir(new Item(new Apartamento(523, 90, 1, 1, new Proprietario(53567577433L, "Bryann", "567577433", "bryann@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(513, 90, 2, 2, new Proprietario(69437977607L, "Luan", "694797607", "luan@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(543, 90, 1, 4, new Proprietario(46569753037L, "Richard", "465697037", "Richard@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(553, 90, 2, 3, new Proprietario(16028739758L, "Jordhan", "112458941", "jordhan@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(562, 90, 1, 3, new Proprietario(11246583941L, "Lucas", "731224723", "Lucas@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(574, 90, 2, 3, new Proprietario(46458621540L, "Estevão", "464586140", "Estevão@gmail.com"))));		
		
		ArvApart.inserir(new Item(new Apartamento(401, 120, 1, 1, new Proprietario(68086621774L, "Mario", "680866174", "mario@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(411, 120, 2, 2, new Proprietario(77455479549L, "Ricardo", "774547949", "ricardo@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(412, 130, 3, 4, new Proprietario(16028738113L, "Otavio", "592482697", "otavio@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(416, 100, 2, 3, new Proprietario(59294826597L, "Bruna", "268131590", "bruna@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(471, 98, 2, 3, new Proprietario(23794332830L, "Carlos", "237942830", "carlos@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(489, 73, 2, 3, new Proprietario(02311431412L, "Daniel", "021143412", "daniel@gmail.com"))));	
		
		ArvApart.inserir(new Item(new Apartamento(301, 120, 1, 1, new Proprietario(61222224887L, "João", "612222487", "joao@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(311, 120, 2, 2, new Proprietario(51236321073L, "Betina", "512332173", "betina@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(312, 130, 3, 4, new Proprietario(28358370512L, "Danilo", "283583052", "danilo@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(316, 100, 2, 3, new Proprietario(58929517820L, "Felipe", "589297820", "felipe@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(371, 98, 2, 3, new Proprietario(23242350804L, "Marco", "232423804", "marco@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(389, 73, 2, 3, new Proprietario(59882131387L, "Hederson", "598213137", "hederson@gmail.com"))));
		
		ArvApart.inserir(new Item(new Apartamento(623, 80, 1, 1, new Proprietario(53567577433L, "Bryann", "536757743", "bryann@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(613, 97, 2, 2, new Proprietario(69437977607L, "Luan", "693797707", "luan@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(643, 160, 1, 4, new Proprietario(46569753037L, "Richard", "456975037", "Richard@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(653, 203, 2, 3, new Proprietario(11246583941L, "Jordhan", "112658941", "jordhan@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(662, 42, 1, 3, new Proprietario(73122647273L, "Lucas", "731264773", "Lucas@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(674, 95, 2, 3, new Proprietario(46458621540L, "Estevão", "464562150", "Estevão@gmail.com"))));		
		
		ArvApart.inserir(new Item(new Apartamento(701, 100, 1, 1, new Proprietario(68086621774L, "Mario", "680621774", "mario@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(711, 137, 2, 2, new Proprietario(77455479549L, "Ricardo", "745549549", "ricardo@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(712, 87, 3, 4, new Proprietario(59294826597L, "Otavio", "594826597", "otavio@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(716, 98, 2, 3, new Proprietario(26813158910L, "Bruna", "268131910", "bruna@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(771, 98, 2, 3, new Proprietario(23794332830L, "Carlos", "237942830", "carlos@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(789, 75, 2, 3, new Proprietario(02311431412L, "Daniel", "023111412", "daniel@gmail.com"))));	
		
		ArvApart.inserir(new Item(new Apartamento(101, 120, 1, 1, new Proprietario(61222224887L, "João", "612224887", "joao@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(211, 120, 2, 2, new Proprietario(51236321073L, "Betina", "516321073", "betina@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(312, 130, 3, 4, new Proprietario(28358370512L, "Danilo", "258370512", "danilo@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(416, 100, 2, 3, new Proprietario(58929517820L, "Felipe", "589517820", "felipe@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(571, 98, 2, 3, new Proprietario(23242350804L, "Marco", "078774960", "marco@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(689, 73, 2, 3, new Proprietario(59882131387L, "Hederson", "592131387", "hederson@gmail.com"))));
		
		ArvApart.inserir(new Item(new Apartamento(307, 120, 1, 1, new Proprietario(61222224887L, "João", "612224887", "joao@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(317, 120, 2, 2, new Proprietario(51236321073L, "Betina", "512321073", "betina@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(358, 130, 3, 4, new Proprietario(16028738113L, "Danilo", "283583512", "danilo@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(319, 100, 2, 3, new Proprietario(28358370512L, "Felipe", "589297820", "felipe@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(376, 98, 2, 3, new Proprietario(23242350804L, "Marco", "078707960", "marco@gmail.com"))));
		ArvApart.inserir(new Item(new Apartamento(389, 73, 2, 3, new Proprietario(59882131387L, "Hederson", "598831387", "hederson@gmail.com"))));
		
		
		//Menu
		do {
			Tela.TelaInicio();
			valor = input.next().charAt(0);
			
			switch (valor) {
				//Inserir
				case '1':
					
					do {
						//Bloco
						do {
							try {
								Tela.TelaInserir();
								System.out.print("BLOCO: ");
								varNum = Long.parseLong(String.valueOf(input.next().charAt(0)));
								codigo = String.valueOf(varNum);
							} catch (Exception e) {
								varNum = 0;
							}
						} while(varNum < 1 || varNum > 9);
						
						
						//Andar
						do {
							try {
								Tela.TelaInserir();
								System.out.print("ANDAR: ");
								varNum = Long.parseLong(String.valueOf(input.next().charAt(0)));
								codigo = codigo + String.valueOf(varNum);
							} catch (Exception e) {
								varNum = 0;
							}
						} while(varNum < 0 || varNum > 9);
						
						
						//Num. Ap.
						do {
							try {
								Tela.TelaInserir();
								System.out.print("NÚMERO DO AP.: ");
								varNum = Long.parseLong(String.valueOf(input.next().charAt(0)));
								codigo = codigo + String.valueOf(varNum);
							} catch (Exception e) {
								varNum = 0;
							}
						} while(varNum < 1 || varNum > 9);


						//Verifica se o código gerado já existe
						if (ArvApart.pesquisar(Long.parseLong(codigo), ArvApart.getRaiz()) != null) {
							Metodo.LimpaTela();
							System.out.println("O código do apto. é formado pelo número do bloco, do andar e do apto.");
							System.out.println("Exemplo: Bloco 1, 2º andar, apto. 7 = Código 127.\n\n\n");
							System.out.println("O código informado já existe no sistema. Selecione outro.");
							System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
							input.next();
							codValido = false;
						}
						else {
							codValido = true;
						}

						
					} while (!codValido);
					
					
					//M²
					do {
						try {
							Tela.TelaInserir();
							System.out.print("M²: ");
							varNum = input.nextLong();
							m2 = varNum;
						} catch (Exception e) {
							varNum = 0;
						}
					} while(varNum < 10 || varNum > 20000);
					
					
					//Vagas carro
					do {
						try {
							Tela.TelaInserir();
							System.out.print("VAGAS DE ESTACIONAMENTO: ");
							varNum = input.nextLong();
							vagasCarro = varNum;
						} catch (Exception e) {
							varNum = 0;
						}
					} while(varNum < 0 || varNum > 9);
					
					
					//Número de quartos
					do {
						try {
							Tela.TelaInserir();
							System.out.print("NÚMERO DE QUARTOS: ");
							varNum = input.nextLong();
							numQuartos = varNum;
						} catch (Exception e) {
							varNum = 0;
						}
					} while(varNum < 1 || varNum > 9);
					
					
					//Cpf
					do {
						try {
							Tela.TelaInserir();
							System.out.print("CPF: ");
							varNum = input.nextLong();
							cpf = varNum;
						} catch (Exception e) {
							varNum = 0;
						}
					} while(String.valueOf(varNum).length() != 11);
					
					
					//Nome
					Tela.TelaInserir();
					System.out.print("NOME: ");
					nome = input.next();


					//Telefone
					do {
						try {
							Tela.TelaInserir();
							System.out.print("TELEFONE: ");
							varNum = input.nextLong();	//garante que o valor é numérico
							telefone = String.valueOf(varNum); //salva como String
						} catch (Exception e) {
							varNum = 0;
							input.next();
						}
					} while(telefone.length() < 8);
					
					
					//E-mail
					Tela.TelaInserir();
					System.out.print("E-MAIL: ");
					email = input.next();

					
					//Cria o no e insere na árvore
					proprietario = new Proprietario(cpf, nome,telefone, email);
					apartamento = new Apartamento(Long.parseLong(codigo), m2, vagasCarro, numQuartos, proprietario);
					no = new Item(apartamento); 
					ArvApart.inserir(no);
					

					Metodo.LimpaTela();
					System.out.println("CADASTRO REALIZADO COM SUCESSO.");
					System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
					input.next();

					
					valor = '0';
				break;
				
				
				//Alterar
				case '2':

					try {
						NoArv noApto;
						
						Tela.TelaConsultaApartBusca();
						valorConsulta = Long.parseLong(String.valueOf(input.next()));

						//Valida se o código foi escrito corretamente
						if (valorConsulta >= 101 && valorConsulta <= 999) {
							
							//Busca o nó do apartamento
							noApto = ArvApart.pesquisar(valorConsulta, ArvApart.getRaiz());
							
							if (noApto != null) {

								//M²
								do {
									try {
										Tela.TelaAlterar();
										System.out.println("ATUAL: " + noApto.getInfo().getChave().getM2());
										System.out.print("M²: ");
										varNum = input.nextLong();
										m2 = varNum;
									} catch (Exception e) {
										varNum = 0;
									}
								} while(varNum < 10 || varNum > 20000);


								//Vagas carro
								do {
									try {
										Tela.TelaAlterar();
										System.out.println("ATUAL: " + noApto.getInfo().getChave().getVagasCarro());
										System.out.print("VAGAS DE ESTACIONAMENTO: ");
										varNum = input.nextLong();
										vagasCarro = varNum;
									} catch (Exception e) {
										varNum = 0;
									}
								} while(varNum < 0 || varNum > 9);


								//Número de quartos
								do {
									try {
										Tela.TelaAlterar();
										System.out.println("ATUAL: " + noApto.getInfo().getChave().getNumQuartos());
										System.out.print("NÚMERO DE QUARTOS: ");
										varNum = input.nextLong();
										numQuartos = varNum;
									} catch (Exception e) {
										varNum = 0;
									}
								} while(varNum < 1 || varNum > 9);
								
								
								//CPF
								do {
									try {
										Tela.TelaAlterar();
										System.out.println("ATUAL: " + noApto.getInfo().getChave().getProprietario().getCPF());
										System.out.print("CPF: ");
										varNum = input.nextLong();
										cpf = varNum;
									} catch (Exception e) {
										varNum = 0;
									}
								} while(String.valueOf(varNum).length() != 11);


								//Nome
								Tela.TelaAlterar();
								System.out.println("ATUAL: " + noApto.getInfo().getChave().getProprietario().getNome());
								System.out.print("NOME: ");
								nome = input.next();


								//Telefone
								do {
									try {
										Tela.TelaAlterar();
										System.out.println("ATUAL: " + noApto.getInfo().getChave().getProprietario().getTelefone());
										System.out.print("TELEFONE: ");
										varNum = input.nextLong();	//garante que o valor é numérico
										telefone = String.valueOf(varNum); //salva como String
									} catch (Exception e) {
										varNum = 0;
										input.next();
									}
								} while(telefone.length() < 8);


								//E-mail
								Tela.TelaAlterar();
								System.out.println("ATUAL: " + noApto.getInfo().getChave().getProprietario().getEmail());
								System.out.print("E-MAIL: ");
								email = input.next();
								


								//ALTERA OS VALORES DO NÓ
								//Apartamento
								noApto.getInfo().getChave().setM2(m2);
								noApto.getInfo().getChave().setVagasCarro(vagasCarro);
								noApto.getInfo().getChave().setNumQuartos(numQuartos);
								
								//Proprietário
								noApto.getInfo().getChave().getProprietario().setCPF(cpf);
								noApto.getInfo().getChave().getProprietario().setNome(nome);
								noApto.getInfo().getChave().getProprietario().setEmail(email);
								noApto.getInfo().getChave().getProprietario().setTelefone(telefone);
								
								
								Metodo.LimpaTela();
								System.out.println("ATUALIZAÇÃO REALIZADA COM SUCESSO.");
								
							} //Verifica se o nó existe
							else  {
								Metodo.LimpaTela();
								System.out.println("O código do apartamento não foi cadastrado.");
							}
						
						}
						else {
							Metodo.LimpaTela();
							System.out.println("O código do apartamento é inválido.");
						}
						
						
						System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
						input.next();

					} catch (Exception e) {
						Metodo.LimpaTela();
						System.out.println("O número do bloco tem que ser numérico.");
						System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
						input.next();
					}
					
					valorConsulta = 0;

					
					valor = '0';
				break;
				
				
				//Remover
				case '3':
					long valorRemove;

					try {
						Tela.TelaRemover();
						valorRemove = Long.parseLong(input.next());
						
						Metodo.LimpaTela();
						if (ArvApart.remover(valorRemove)) {
							System.out.println("APARTAMENTO REMOVIDO COM SUCESSO!");
						}
						else {
							System.out.println("O APARTAMENTO INFORMADO NÃO FOI CADASTRADO.");
						}
						
						System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
						input.next();
						
						
					} catch(Exception e) {
						Metodo.LimpaTela();
						System.out.println("O código do apartamento tem que ser numérico.");
						System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
						input.next();
					}
					
				break;
		
				
				//Pesquisar
				case '4':
					Item tabela[];
					
					do {
						Tela.TelaPesquisar();
						valor = input.next().charAt(0);
						
						switch(valor) {
							//Mostrar tudo
							case '1':
								Tela.TelaMostrarTudo();
								Tela.TelaTabelaCabecalho();

								for(Item i : ArvApart.CamPreFixado()) {
									System.out.println(i.getChave().toString());
								}
								
								System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
								input.next();
							break;
							
							
							//CONSULTA CPF
							case '2':

								try {
									Tela.TelaConsultarCPF();
									valorConsulta = Long.parseLong(input.next());
									
									System.out.println("\n");
									Tela.TelaTabelaCabecalho();
									
									tabela = ArvApart.ConsultaCPF(valorConsulta);
									
									for(int i = 0; i < tabela.length && tabela[i] != null; i++) {
										System.out.println(tabela[i].getChave().toString());
									}
									
									System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
									input.next();
	
								} catch (Exception e) {
									Metodo.LimpaTela();
									System.out.println("O CPF tem que ser numérico.");
									System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
									input.next();
								}
								
								valorConsulta = 0;
							break;
							
							
							//Consulta bloco
							case '3':

								try {
									Tela.TelaConsultaBloco();
									valorConsulta = Long.parseLong(String.valueOf(input.next().charAt(0)));
									
									if (valorConsulta >= 1 && valorConsulta <= 9) {
										System.out.println("\n");
										Tela.TelaTabelaCabecalho();

										tabela = ArvApart.ConsultaBloco(valorConsulta);
										
										for(int i = 0; i < tabela.length && tabela[i] != null; i++) {
											System.out.println(tabela[i].getChave().toString());
										}
									
									}
									else {
										Metodo.LimpaTela();
										System.out.println("O código do bloco é inválido.");
									}
									
									System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
									input.next();
	
								} catch (Exception e) {
									Metodo.LimpaTela();
									System.out.println("O número do bloco tem que ser numérico.");
									System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
									input.next();
								}
								
								valorConsulta = 0;
							break;
							
							
							//Consulta Apartamento
							case '4':
								try {
									NoArv noApto;

									Tela.TelaConsultaApartBusca();
									valorConsulta = Long.parseLong(String.valueOf(input.next()));
									
									//Valida se o código foi escrito corretamente
									if (valorConsulta >= 101 && valorConsulta <= 999) {
										
										noApto = ArvApart.pesquisar(valorConsulta, ArvApart.getRaiz());
										
										if (noApto != null) {
											Tela.TelaConsultaApart(noApto.getInfo());
										}
										else  {
											Metodo.LimpaTela();
											System.out.println("O código do apartamento não foi cadastrado.");
										}
									
									}
									else {
										Metodo.LimpaTela();
										System.out.println("O código do apartamento é inválido.");
									}
									
									
									System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
									input.next();
	
								} catch (Exception e) {
									Metodo.LimpaTela();
									System.out.println("O número do bloco tem que ser numérico.");
									System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
									input.next();
								}
								
								valorConsulta = 0;
							break;
	
						}//switch menu pesquisar
						
					} while (valor != '5');

					valor = '0';
					
				break;


				//Sobre
				case '5':
					Tela.TelaSobre();
					
					System.out.println("\n\n\nDigite qualquer caractere e pressione ENTER para voltar...");
					input.next();
					
				break;

				
				//Sobre
				case '6':
					Tela.TelaSair();
				break;

			}//switch menu principal
		
		
		} while (valor != '6');
		
		
		input.close();
		
		
	}//main
	

}//classe início































