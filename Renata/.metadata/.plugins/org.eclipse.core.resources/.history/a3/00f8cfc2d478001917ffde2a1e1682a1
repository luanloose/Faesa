import java.util.Scanner;

public class Aeroporto {
	static Scanner scan = new Scanner(System.in);
	static ListaDupla recife;
	static ListaDupla fortaleza;
	static ListaDupla joaoPessoa;
	
	public static void main(String[] args) {
			
		int cod = 1;
		String nome;
		int tel;
		int dest;
		int busca;
		int opcao;
		int atual;
		boolean aberto=false;
		
		NoDupla pesqNo = null;
		NoDupla pesqNo2 = null;
		NoDupla pesqNo3 = null;
		
		do {
			
			opcao = menu();
			
		switch (opcao){
		
			case 0:
				
				recife = new ListaDupla();
				fortaleza = new ListaDupla();
				joaoPessoa = new ListaDupla();
				aberto=true;
				
				System.out.println("Voos abertos!!\n");
				
				break;
				
			case 1:
				if(aberto) {
					System.out.println("Digite o nome do passageiro: ");
					nome = scan.next();
					System.out.println("Digite o telefone: ");
					tel = scan.nextInt();
					System.out.println("Qual o destino: \n"
							+ "1 - Recife\n"
							+ "2 - Fortaleza\n"
							+ "3 - Joao Pessoa\n");
					dest = scan.nextInt();
					
					if (dest == 1 ) {
						
						recife.inserirUltimo(new Item(cod,nome,tel,"Recife"));
						
					} else {
						
						if (dest == 2 ) {
							fortaleza.inserirUltimo(new Item(cod,nome,tel,"Fortaleza"));
						} else {
							
							if (dest == 3 ) {
								joaoPessoa.inserirUltimo(new Item(cod,nome,tel,"Joao Pessoa"));
							} else {
								
								System.out.println("Destino Inválido!!\n");
								
							}
						}	
					}
					
					cod++;	
				} else {
					
					System.out.println("Voos de hoje ainda fechados!!\n");

				}
				
				break;
			
			case 2:
				
				if(aberto) {
					
					System.out.println("Digite o codigo do passageiro");
					cod = scan.nextInt();
					
					pesqNo = recife.pesquisarNo(cod);
					pesqNo2 = fortaleza.pesquisarNo(cod);
					pesqNo3 = joaoPessoa.pesquisarNo(cod);

					if ( pesqNo == null && pesqNo2 == null && pesqNo3 == null ) {
						
						System.out.println("o passageiro de codigo"+cod+" nao foi achado na lista");

					} else {
						
						if (pesqNo==null && pesqNo2==null) {
							
							System.out.println("Dados do passageiro:\n "+pesqNo3.getInfo().toString());

							
						} else {
							
							if (pesqNo2==null && pesqNo3==null) {
								
								System.out.println("Dados do passageiro:\n "+pesqNo.getInfo().toString());
								
							} else {
								
								System.out.println("Dados do passageiro:\n "+pesqNo2.getInfo().toString());
							
							}
						}
					}
					
				} else {
					
					System.out.println("Voos de hoje ainda fechados!!\n");

				}
				
				break;

			case 3:
				
				if(aberto) {
					
					System.out.println("Digite o codigo da passagem");
					busca = scan.nextInt();
					
					System.out.println("Qual o destino: \n"
							+ "1 - Recife\n"
							+ "2 - Fortaleza\n"
							+ "3 - Joao Pessoa\n");
					dest = scan.nextInt();
					
					if (dest == 1 ) {
											
						if (recife.removerNo(busca)) {

							System.out.println("remoção efetuada");

							} else {
								System.out.println("remoção não efetuada");
								}
					} else {
						
						if (dest == 2 ) {
							
							if (fortaleza.removerNo(busca)) {

								System.out.println("remoção efetuada");

								} else {
									System.out.println("remoção não efetuada");
									}

						} else {
							
							if (dest == 3 ) {
								
								if (joaoPessoa.removerNo(busca)) {

									System.out.println("remoção efetuada");

									} else {
										System.out.println("remoção não efetuada");
										}
								
							} else {
								
								System.out.println("Destino Inválido!!");
								
							}
						}	
					}
		
				} else {
					
					System.out.println("Voos de hoje ainda fechados!!\n");
					
				}

				break;
			
			case 4:
				
				if(aberto) {
					
					System.out.println("Digite o voo para mostrar os passageiros: \n"
							+ "1 - Recife\n"
							+ "2 - Fortaleza\n"
							+ "3 - Joao Pessoa\n");
					dest = scan.nextInt();
					
					if (dest == 1 ) {
						
						if (recife.getQuantNos() > 0) {
							
							System.out.println("Lista de passageiros\n "+recife.toString());

						} else {
							
							System.out.println("Voo sem passageiros!!\n");
							
						}
						
					} else {
						
						if (dest == 2 ) {
							
							if (fortaleza.getQuantNos() > 0) {
							
								System.out.println("Lista de passageiros\n "+fortaleza.toString());
								
							} else {
								
								System.out.println("Voo sem passageiros!!\n");
		
							}
							
						} else {
							
							if (dest == 3 ) {
								
								if (joaoPessoa.getQuantNos() > 0) {

									System.out.println("Lista de passageiros\n "+joaoPessoa.toString());
									
								} else {
									
									System.out.println("Voo sem passageiros!!\n");

								}
								
							} else {
								
								System.out.println("Voo invalido!!\n\n");
								
							}
						}	
					}
					
				} else {
					
					System.out.println("Voos de hoje ainda fechados!!\n");

				}
				
				break;

			case 5:
				
				if(aberto) {
					
					System.out.println("Digite o codigo do passageiro");
					busca = scan.nextInt();
					
					System.out.println("Qual o voo atual? \n"
							+ "1 - Recife\n"
							+ "2 - Fortaleza\n"
							+ "3 - Joao Pessoa\n");
					atual = scan.nextInt();
					
					if (atual == 1) {
						
						pesqNo = recife.pesquisarNo(busca);
						
						System.out.println("Qual o voo destino? \n"
								+ "1 - Fortaleza\n"
								+ "2 - Joao Pessoa\n");
						
						dest = scan.nextInt();
						if (dest == 1) {
							
							if (recife.removerNo(busca)) {
								
								pesqNo.getInfo().setDest("Fortaleza");
								fortaleza.inserirUltimo(pesqNo.getInfo());
								
								System.out.println("Passageiro transferido com sucesso\n");

								} else {
									
									System.out.println("Houve um problema na transferencia\n");
									
									}
							
						} else {
							
								if (recife.removerNo(busca)) {
									
									pesqNo.getInfo().setDest("Joao Pessoa");
									joaoPessoa.inserirUltimo(pesqNo.getInfo());
								
								System.out.println("Passageiro transferido com sucesso\n");

								} else {
									
									System.out.println("Houve um problema na transferencia\n");
									
									}
						}
						
					} else {
						
						if (atual == 2 ) {
							
							pesqNo = fortaleza.pesquisarNo(busca);
							System.out.println("Qual o voo destino? \n"
									+ "1 - Recife\n"
									+ "2 - Joao Pessoa\n");
							
							dest = scan.nextInt();
							
							if (dest == 1) {
								
								if (fortaleza.removerNo(busca)) {
									
									pesqNo.getInfo().setDest("Recife");
									recife.inserirUltimo(pesqNo.getInfo());
									
									System.out.println("Passageiro transferido com sucesso\n");

									} else {
										
										System.out.println("Houve um problema na transferencia\n");
										
										}
								
							} else {
								
									if (fortaleza.removerNo(busca)) {
										
										pesqNo.getInfo().setDest("Joao Pessoa");
										joaoPessoa.inserirUltimo(pesqNo.getInfo());
									
									System.out.println("Passageiro transferido com sucesso\n");

									} else {
										
										System.out.println("Houve um problema na transferencia\n");
										
										}
							}
								
						} else {
							
							if (atual == 3 ) {
								
								pesqNo = joaoPessoa.pesquisarNo(busca);
								
								System.out.println("Qual o voo destino? \n"
										+ "1 - Recife\n"
										+ "2 - Fortaleza\n");
								
								dest = scan.nextInt();
								if (dest == 1) {
									
									if (joaoPessoa.removerNo(busca)) {
										
										pesqNo.getInfo().setDest("Recife");
										recife.inserirUltimo(pesqNo.getInfo());
										
										System.out.println("Passageiro transferido com sucesso\n");

										} else {
											
											System.out.println("Houve um problema na transferencia\n");
											
											}
									
								} else {
									
										if (joaoPessoa.removerNo(busca)) {
											
											pesqNo.getInfo().setDest("Fortaleza");
											fortaleza.inserirUltimo(pesqNo.getInfo());
										
										System.out.println("Passageiro transferido com sucesso\n");

										} else {
											
											System.out.println("Houve um problema na transferencia\n");
											
											}
								}
								
							} else {
								
								System.out.println("Destino Inválido!!\n");
								
							}
						}	
					}

				} else {
					
					System.out.println("Voos de hoje ainda fechados!!\n");

				}
					
				break;

		}
			} while (opcao >= 0 || opcao >= 5 );
		
		System.out.println("Fim do programa!!\n");


}

	public static int menu(){
		
		System.out.println("Escolha uma Opção:\n"+ 
		"0. Abrir voos\n"+
		"1. Vender passagem\n"+
		"2. Localizar Passageiro\n"+
		"3. Excluir Passageiro\n"+
		"4. Exibir Voo\n"+
		"5. Transferencia de passageiros\n"+
		"9. Sair\n");

		return scan.nextInt();

	}
}