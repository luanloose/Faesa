import java.util.Scanner;


public class Jogadores {
	public static void main(String[] args) {

			//Variaveis auxiliares
			Scanner scan = new Scanner (System.in);
			int jogo = 0;
			int player1 = 0;
			int player2 = 0;
			int partida = 1;
			int exit = 1;
			int win = 0;
			String busca = "";
	
			// instanciar constantes
	
			final int lin = 5; //jogador
			final int col = 5; //jogo
 
			// Instanciar vetores e matriz
			String [] nomePlayer = {"Luan","Guilherme","Breno","Isaac", "Claudinho"};
			String [] nomeJogos = {"Fifa","League of Legends","Overwatch","Rainbow Six", "Fortinite"};
			int [][] resultado = new int [lin][col]; // 
			
			//instanciar a matriz com 0
			for (int i = 0; i < lin; i++) {
				for (int j = 0; j < col; j++) {
					
					resultado[i][j] = 0;			
				}	
			}

			//Menu do evento
			do {
			
				System.out.printf("Escolha uma opcao: \n1 - Definir partida (Player X Player)\n2 - Definir Pontuacao da %dº partida\n"
						+ "4 - Resultado parcial geral\n5 - Alterar resultado\n6 - Pesquisar pontos por jogo ou jogador"
						+ "\n7 - Sair do programa e mostrar resultado final ",partida );
				exit = scan.nextInt();

			switch(exit) {
			
			case 1:
				// Saber qual jogo sera jogado
				System.out.println("Qual jogo sera jogado? " );
				for (int i = 0; i < lin; i++) {
					System.out.println(" "+(i+1)+" - "+nomeJogos[i] );
	
				}
				jogo = scan.nextInt();
				
				// Definir partida
				System.out.println("Quais os jogadores que irao se enfrentar? " );
				for (int i = 0; i < lin; i++) {
					System.out.println(" "+(i+1)+" - "+nomePlayer[i] );
	
				}
				player1 = scan.nextInt(); // defini nome do jogador 1
				player2 = scan.nextInt(); // defini o nome do jogador 2
				
				//verificar se os dados sao validos
				if (jogo > 5 || player1 > 5 || player2 > 5 || player1==player2) {
					
					System.out.println("Escolha invalida!!! SAINDO DO PROGRAMA!!!");
					exit=0;
					
				}
				break;
			
			case 2:
				
				// mostra os pontos
				System.out.println("Esquema de pontuação: vitoria 3  / derrota 0\n");
	
				// escreve na partida correspondente o resultado do jogo
				
				System.out.println("Partida "+partida); //partida correspontende 
				
				System.out.println();
				
				System.out.println("No jogo "+nomeJogos[jogo-1]+"Quem ganhou?\nPlayer 1 "+nomePlayer[player1-1]+" ou "
						+ "Player 2 "+nomePlayer[player2-1]+" ?" );
				win = scan.nextInt();
				
				
				//verifica quem ganhou e coloca altomaticamente o valor e checa validez da informacao
				if (win == 1) {
					
					resultado[player1-1][jogo-1] = 3;
					
				}else { if (win == 2 ) {
					
					resultado[player2-1][jogo-1] = 3;

					
				}else {
					
					System.out.println("Escolha invalida!!! SAINDO DO PROGRAMA!!!");
					exit=0;
					
				}
	
				}
				
				partida += 1; // somar a partida para mostrar a proxima
				break;
					
			case 4:
				
				System.out.println("Resultado parcial do evento");

				System.out.println("\nJogadores");
				
				for (int i = 0; i < lin; i++) {  //exibe matriz completa com os registros atuais
					
					System.out.print(nomePlayer[i]+"    ");
					
					for (int j = 0; j < col; j++) {

						System.out.print(nomeJogos[j]+": "+resultado[i][j]+"   ");
							
					}				
					System.out.println(" ");					
				}		
				break;
				
			case 5:
				// Exibir os jogos para definir novos pontos
				System.out.println("escolha um jogo da lista para definir nova pontuacao: " );
				for (int i = 0; i < lin; i++) {
					System.out.println(" "+(i+1)+" - "+nomeJogos[i] );
	
				}
				jogo = scan.nextInt();
				
				// exibir jogadores para efetuar a troca de pontuacao
				System.out.println("Qual jogador sera trocada a pontuacao? " );
				for (int i = 0; i < lin; i++) {
					System.out.println(" "+(i+1)+" - "+nomePlayer[i] );
	
				}
				player1 = scan.nextInt(); // defini nome do jogador para trocar pontos
				
				System.out.println("Qual a nova pontuacao do "+nomePlayer[player1-1]+" no jogo "+nomeJogos[jogo-1] + "? ");
				resultado[player1-1][jogo-1]=scan.nextInt();
				break;

			case 6:

				System.out.print("\nDigite o nome do player ou jogo para saber a pontuacao: \n");
				busca = scan.next().toLowerCase();
				System.out.print("\n");

				for (int i = 0; i < lin; i++) {  //exibe matriz completa com os registros atuais
					
					if (nomePlayer[i].toLowerCase().equals(busca)) {
						
						System.out.print(nomePlayer[i]+" teve os seguintes pontos: ");
						
						for (int j = 0; j < col; j++) {

							System.out.print(nomeJogos[j]+": "+resultado[i][j]+"   ");
								
						}
						
						i = lin;
						
					}else { if(nomeJogos[i].toLowerCase().equals(busca)) {
						
						System.out.print(nomeJogos[i]+" teve os seguintes pontos dos jogadores: ");
						for (int j = 0; j < col; j++) {

							System.out.print(nomePlayer[j]+": "+resultado[j][i]+"   ");
								
						}
						
						i = lin;

					} else { if(i == lin-1){
						
						System.out.print("Seu player ou jogo nao existe no nosso sistema");
						
							}
						
						}
			
					}
					
				}		
				System.out.print("\n\n\n");
				break;

			case 7:
				exit=0;
				break;
					
			}
			System.out.println(" ");

			}while(exit!=0);
			
			// Preencher resultado final do jogo
			System.out.println("Resultado final do evento de cada jogador");
		
			for (int i = 0; i < lin; i++) {
				
				System.out.print(nomePlayer[i]+"    ");
				
				for (int j = 0; j < col; j++) {
					
					System.out.print(nomeJogos[j]+": "+resultado[i][j]+"   ");
						
				}				
				System.out.println(" ");
				
			}	
			
	}
	
}
