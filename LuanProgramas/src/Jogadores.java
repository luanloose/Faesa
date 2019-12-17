import java.util.Scanner;

public class Jogadores {
	public static void main(String[] args) {

		// Inicio do trabalho
		System.out.println("\n");
		System.out.println("Trabalho de Algoritimo I\nProfessora: Renata Leite"
				+ "\nIntegrantes do grupo: Guilherme, Isaac, Luan" + "\nTema: Jogadores de games");
		System.out.println("\n\n-------------------------------------------------------------\n\n");

		// Variaveis auxiliares
		Scanner scan = new Scanner(System.in);
		int jogo = 0;
		int player1 = 0;
		int player2 = 0;
		int partida = 1;
		int exit = 1;
		int win = 0;
		int op = 0;
		String busca = "";
		String nome = "";
		boolean invalido = false;


		// Instanciar constantes

		final int lin = 5; // Jogador
		final int col = 5; // Jogo

		// Instanciar vetores e matriz
		String[] nomePlayer = new String[lin];
		String[] nomeJogos = new String[lin];
		int[] ganhou = new int[lin];
		int[][] resultado = new int[lin][col];
		
		System.out.println("------------ BEM VINDO AO E-CHAMPIONSHIP MANAGER -----------\n\n");

		System.out.println("Para iniciar preencha o nome dos 5 jogadores\nOBS: Limite de 5 caracteres");

		// Preenche vetor jogadores com teste para saber se ja tem cadastrado
		for (int i = 0; i < nomePlayer.length; i++) {
			
			System.out.println("\nDigite o nome do "+(i+1)+"º player e aperte ENTER\n");
			nome = scan.next();
			
			for (int j = 0; j < lin; j++) {
				
				if (nomePlayer[j] == null) {
					
					j = lin;
					
				} else { if (nomePlayer[j].toLowerCase().equals(nome.toLowerCase())) {
						
						invalido = true;
						j = lin;
					
					}
						
				} // Fim condicional
				
			} // Fim loop 2
				
			
			if (nome.length() <= 5 && invalido == false) { //testa o limite de caracteres
				
				nomePlayer[i] = nome;

				
			} else { if(invalido == false) {
				
				System.out.println("\nLimite de caracteres alcancado, repita a operacao.\n");
				i -= 1;
				
			} else {
				
				System.out.println("\nJogador já cadastrado, repita a operacao.\n");
				i -= 1;
				invalido = false;
				
				} 
					
			} // Fim condicional
			
		} // Fim do loop 1
		
		
		System.out.println("Jogadores cadastrados com sucesso!\n"
				+ "Continue preenchendo o nome dos 5 jogos do evento.");
		
		// Preenche vetor de jogos com teste para saber se ja tem cadastrado
		for (int i = 0; i < nomeJogos.length; i++) {
			
			System.out.println("\n\nDigite o nome do "+(i+1)+"º jogo e aperte ENTER");
			nome = scan.next();
			
			for (int j = 0; j < lin; j++) {
				
				if (nomeJogos[j] == null) {
					
					nomeJogos[i] = nome;
					j = lin;
					
				}else { if (nomeJogos[j].toLowerCase().equals(nome.toLowerCase())) {
						
					System.out.println("\n\nJogo já cadastrado, repita a operacao.\n");
					j = lin;
					i -= 1;

						
					}
						
				}
				
			} // Fim do loop 2
				
		} // Fim do loop 1
		
		System.out.println("Jogos cadastrados com sucesso!\n");
		

		System.out.println("----------------- MENU DO EVENTO ----------------\n\n");

		// Menu do evento
		do {

			System.out.printf("Escolha uma opcao de 1 a 6 e aperte ENTER: \n1 - Definir partida (Player X Player)"
					+ "\n2 - Definir Pontuacao da %dº partida\n3 - Resultado parcial geral\n4 - Alterar resultado"
					+ "\n5 - Pesquisar pontos por jogo ou jogador\n6 - Sair do programa e mostrar resultado final \n\n",
					partida);

			op = scan.nextInt();

			System.out.println("\n\n------------------------------------------------------------\n\n");

			if (op <= 0 || op > 6) { // Se cair aqui quer dizer q o usuario digitou algo invalido

				System.out.println("ESCOLHA INVALIDA, DIGITE NOVAMENTE!! \n");
				System.out.println("\n\n------------------------------------------------------------\n\n");

			} else {

				switch (op) {

				case 1:
					// Saber qual jogo sera jogado
					System.out.println("Qual jogo será jogado?\nEscolha de 1 a 5 e aperte ENTER ");

					for (int i = 0; i < lin; i++) {

						System.out.println(" " + (i + 1) + " - " + nomeJogos[i]);

					}

					jogo = scan.nextInt();

					// Definir partida
					System.out.println(
							"\nQuais os jogadores que vão enfrentar-se? \nEscolha de 1 à 5 e " + "aperte 'ENTER' ");

					for (int i = 0; i < lin; i++) {

						System.out.println(" " + (i + 1) + " - " + nomePlayer[i]);

					}

					if (jogo > 5 || jogo <= 0) {

						System.out.println("Escolha invalida!!! VOLTANDO AO MENU PRINCIPAL!!!");
						System.out.println("\n\n------------------------------------------------------------\n\n");
						break;

					}

					player1 = scan.nextInt(); // Define nome do jogador 1

					System.out.println("\nEscolha o proximo Jogador de 1 a 5 e aperte ENTER: ");

					player2 = scan.nextInt(); // Define o nome do jogador 2

					System.out.println(" ");

					System.out.println("Partida " + partida + " Jogo: " + nomeJogos[jogo - 1]);

					System.out.println(nomePlayer[player1 - 1] + " X " + nomePlayer[player2 - 1]);

					// Verificar se os dados sao validos
					if (player1 > 5 || player2 > 5 || player1 == player2 || player1 <= 0 || player2 <= 0) {

						System.out.println("Escolha invalida!!! VOLTANDO AO MENU PRINCIPAL!!!");
						System.out.println("\n\n------------------------------------------------------------\n\n");
						break;

					}

					System.out.println("------------------------------------------------------------\n\n");

					break;

				case 2:

					// Verifica se a partida ja foi definida
					if (player1 != 0 || player2 != 0) {

						System.out.println("----------------- PARTIDA " + partida + " -------------------"); // Partida
																												// correspondente

						System.out.println("\nJOGO " + nomeJogos[jogo - 1]);

						System.out.println("\nPLAYER 1        PLAYER 2");

						System.out.println(
								"\n" + nomePlayer[player1 - 1] + "     X     " + nomePlayer[player2 - 1] + "\n");

						// Mostra os pontos
						System.out.println("Esquema de pontuação: vitoria conta 3 pontos  / derrota conta 0 pontos\n");

						System.out.println("------------------------------------------------------------\n\n");

						// Escreve na partida correspondente o resultado do jogo

						System.out.println();

						System.out.println("Quem venceu ?\nPlayer 1 " + nomePlayer[player1 - 1] + " ou " + "Player 2 "
								+ nomePlayer[player2 - 1] + " ?\nEscolha 1 ou 2 e aperte ENTER");

						win = scan.nextInt();

						// Verifica quem ganhou e coloca altomaticamente o valor e checa validez da
						// informacao
						if (win == 1) {

							resultado[player1 - 1][jogo - 1] += 3;

						} else {
							if (win == 2) {

								resultado[player2 - 1][jogo - 1] += 3;

							} else {

								System.out.println("\nEscolha inválida!!! VOLTANDO AO MENU PRINCIPAL!!!");
								System.out.println("------------------------------------------------------------\n\n");

								break;

							}

						}

						partida += 1; // Somar a partida para mostrar a proxima
						System.out.println("------------------------------------------------------------\n\n");

						break;

					} else {

						System.out.println("Vc ainda nao definiu a partida!!! VOLTANDO AO MENU PRINCIPAL\n\n");

						System.out.println("------------------------------------------------------------\n\n");

						break;

					} // Fim do condicional

				case 3:

					System.out.println("Pontuacão parcial do evento\n");
					System.out.print("\t");

					for (int i = 0; i < lin; i++) {

						System.out.print(nomeJogos[i] + "  ");

					}

					System.out.println("");

					for (int i = 0; i < lin; i++) { // Exibe matriz completa com os registros atuais

						System.out.print(nomePlayer[i] + "\t");

						for (int j = 0; j < col; j++) {

							System.out.print(resultado[i][j] + "\t");

						}

						System.out.println(" ");

					} // Fim do loop

					System.out.println("------------------------------------------------------------\n\n");

					break;

				case 4:

					// Exibir os jogos para definir novos pontos
					System.out.println(
							"Escolha um jogo da lista (de 1 à 5) para definir nova pontuacao e aperte ENTER: ");

					for (int i = 0; i < lin; i++) {

						System.out.println(" " + (i + 1) + " - " + nomeJogos[i]);

					}

					jogo = scan.nextInt();

					// Exibir jogadores para efetuar a troca de pontuacao
					System.out
							.println("Qual jogador sera trocada a pontuacão? \nEscolha de 1 à 5 e " + "aperte 'ENTER' ");

					for (int i = 0; i < lin; i++) {

						System.out.println(" " + (i + 1) + " - " + nomePlayer[i]);

					}

					player1 = scan.nextInt(); // Define nome do jogador para trocar pontos

					System.out.println("Quantas partidas o " + nomePlayer[player1 - 1] + " ganhou no jogo "
							+ nomeJogos[jogo - 1] + "?" + "\nDigite o numero de partidas vencidas e aperte ENTER\n"
									+ "Caso o jogador tenha sido desclassificado no jogo "+nomeJogos[jogo - 1]+""
											+ " digite ZERO e aperte ENTER");

					win = scan.nextInt() * 3;

					if (win < 0) {

						System.out.println("ERRO, PONTUACÃO INVALIDA!!!");

					} else {

						resultado[player1 - 1][jogo - 1] = win;

						System.out.println("\nNova Pontuação \nPlayer " + nomePlayer[player1 - 1] + "" + ", jogo "
								+ nomeJogos[jogo - 1] + "\nNova pontuação: " + resultado[player1 - 1][jogo - 1]
								+ " pontos\n\n"); // Mostra a pontucao nova

						System.out.println("PONTUÇÃO ATUALIZADA COM SUCESSO!!!\n");

					}

					System.out.println("------------------------------------------------------------\n\n");

					break;

				case 5:

					System.out.print("\nDigite o nome do player ou o jogo para saber a pontuacão"
							+ "e a quantidade de partidas vencidas, depois aperte ENTER: \n");

					busca = scan.next().toLowerCase();

					System.out.print("\n");

					for (int i = 0; i < lin; i++) { // Exibe matriz completa com os registros atuais

						if (nomePlayer[i].toLowerCase().equals(busca)) {

							System.out.print(nomePlayer[i] + " teve os seguintes pontos: \n");

							for (int j = 0; j < col; j++) {

								System.out.print(nomeJogos[j] + ": " + resultado[i][j] + "   ");


							}

							// Mostra a quantidade parcial de partidas vencidas pelo jogador pesquisado
							System.out.print("\n" + nomePlayer[i] + " ganhou: " + ganhou[i] / 3 + " partidas ");

							i = lin;

						} else {
							if (nomeJogos[i].toLowerCase().equals(busca)) {

								System.out.print(nomeJogos[i] + " teve os seguintes pontos dos jogadores: \n");

								for (int j = 0; j < col; j++) {

									System.out.print(nomePlayer[j] + ": " + resultado[j][i] + "   ");

								}

								i = lin;

							} else {
								if (i == lin - 1) {

									System.out.print(
											"Player ou jogo selecionado nao existe no nosso sistema!!!\nVOLTANDO AO MENU PRINCIPAL!!!");
									System.out.println(
											"------------------------------------------------------------\n\n");

								}

							}

						} // Fim dos condicionais

					} // Fim do loop

					System.out.print("\n\n\n");
					System.out.println("------------------------------------------------------------\n\n");

					break;

				case 6:

					exit = 0;
					System.out.println("------------------------------------------------------------\n\n");

					break;

				}

			} // Fim do teste para saber se o op eh valido

		} while (exit != 0);

		// Mostra resultado final do jogo
		System.out.println("Resultado final do evento de cada jogador\n");

		System.out.print("\t");

		for (int i = 0; i < lin; i++) { // Exibe nome dos jogos em linha reta para desenhar a tabela

			System.out.print(nomeJogos[i] + "  ");

		}

		System.out.println("");

		for (int i = 0; i < lin; i++) { // Exibe matriz completa com os registros atuais

			System.out.print(nomePlayer[i] + "\t");

			for (int j = 0; j < col; j++) {

				System.out.print(resultado[i][j] + "\t");
				ganhou[i] += resultado[i][j];

			}

			System.out.println(" ");

		} // Fim do loop
			System.out.println(" ");

		// Ver quem ganhou o evento
		// Reaproveitar variaveis que tem nome sugestivo ao uso
		win = ganhou[0];
		jogo = 0;

		for (int i = 1; i < lin; i++) {

			if (ganhou[i] > win) {

				win = ganhou[i];

				jogo = i;

			}

		} // Fim do loop

		System.out.println(" ");

		// Verificar se a variavel win tem pontos, se nao tiver ninguem ganhou
		if (win != 0) {

			System.out.println("O vencedor do torneiro é " + nomePlayer[jogo] + " com o total de " + ganhou[jogo] + ""
					+ " no placar geral\nPARABENS\n!!!");

		} else {

			System.out.println("Por incrível que pareça ninguém ganhou!!!!!\n\n\n");

		} // Fim do condicional

		System.out.println("\nFIM DO PROGRAMA");

	} // Fim do metodo main

} // Fim da classe Jogadores
