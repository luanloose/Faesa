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
			int op = 0;
			String busca = "";
	
			// instanciar constantes
	
			final int lin = 5; //jogador
			final int col = 5; //jogo
 
			// Instanciar vetores e matriz
			String [] nomePlayer = {"xLuan","Guigo","Breno","Isaac", "Cloud"};
			String [] nomeJogos = {"Fifa","League of Leg","Overwatch","Rainbow Six", "Fortinite"};
			int [] ganhou = new int[lin];
			int [][] resultado = new int [lin][col]; // 
			

			//Menu do evento
			do {
			
				System.out.printf("Escolha uma opcao de 1 a 6 e aperte ENTER: \n1 - Definir partida (Player X Player)\n2 - Definir Pontuacao da %dº partida\n"
						+ "3 - Resultado parcial geral\n4 - Alterar resultado\n5 - Pesquisar pontos por jogo ou jogador"
						+ "\n6 - Sair do programa e mostrar resultado final \n\n",partida);
				op = scan.nextInt();
				
				
				System.out.println("------------------------------------------------\n\n");


			switch(op) {
			
			case 1:
				// Saber qual jogo sera jogado
				System.out.println("Qual jogo sera jogado?\nEscolha de 1 a 5 e aperte ENTER " );
				for (int i = 0; i < lin; i++) {
					System.out.println(" "+(i+1)+" - "+nomeJogos[i] );
	
				}
				jogo = scan.nextInt();
				
				// Definir partida
				System.out.println("\nQuais os jogadores que irao se enfrentar? \nEscolha de 1 a 5 e "
						+ "aperte ENTER " );
				for (int i = 0; i < lin; i++) {
					System.out.println(" "+(i+1)+" - "+nomePlayer[i] );
	
				}
				player1 = scan.nextInt(); // define nome do jogador 1
				
				System.out.println("\nEscolha o proximo Jogador de 1 a 5 e aperte ENTER: ");

				
				player2 = scan.nextInt(); // define o nome do jogador 2
				
				System.out.println(" ");
				System.out.println("Partida "+partida+" Jogo: "+nomeJogos[jogo-1]);
				System.out.println(nomePlayer[player1-1]+" X "+nomePlayer[player2-1]);

				
				//verificar se os dados sao validos
				if (jogo > 5 || player1 > 5 || player2 > 5 || player1==player2) {
					
					System.out.println("Escolha invalida!!! SAINDO DO PROGRAMA!!!");
					exit=0;
					
				}
				
				System.out.println("------------------------------------------------\n\n");

				
				break;
			
			case 2:
				
				if(player1 != 0 || player2 != 0 ) {
					
				System.out.println("----------------- PARTIDA "+partida+" -------------------");  //partida correspondente
				
				System.out.println("\nJOGO "+nomeJogos[jogo-1]);
				
				System.out.println("\nPLAYER 1        PLAYER 2");

				
				System.out.println("\n"+nomePlayer[player1-1]+"     X     "+nomePlayer[player2-1]+"\n");

				
				// mostra os pontos
				System.out.println("Esquema de pontuação: vitoria 3  / derrota 0\n");
				
				System.out.println("------------------------------------------------\n\n");

	
				// escreve na partida correspondente o resultado do jogo
				
				
				System.out.println();
				
				System.out.println("Quem venceu ?\nPlayer 1 "+nomePlayer[player1-1]+" ou "
						+ "Player 2 "+nomePlayer[player2-1]+" ?\nEscolha 1 ou 2 e aperte ENTER" );
				win = scan.nextInt();
				
				
				//verifica quem ganhou e coloca altomaticamente o valor e checa validez da informacao
				if (win == 1) {
					
					resultado[player1-1][jogo-1] += 3;
					
				}else { if (win == 2 ) {
					
					resultado[player2-1][jogo-1] += 3;

					
				}else {
					
					System.out.println("Escolha invalida!!! SAINDO DO PROGRAMA!!!");
					exit=0;
					
				}
	
				}
				
				partida += 1; // somar a partida para mostrar a proxima
				System.out.println("------------------------------------------------\n\n");
				break;
				
				}else {
					
					System.out.println("Vc ainda nao definiu a partida!!!\n\n");
					
					System.out.println("------------------------------------------------\n\n");

					break;
				
				}
					
			case 3:
				
				System.out.println("Resultado parcial do evento\n");

				System.out.print("             ");
				
				for(int i = 0 ; i < lin ; i++) {
					
				System.out.print(nomeJogos[i]+"  ");
				
				}
				
				System.out.println("");

				
				
				for (int i = 0; i < lin; i++) {  //exibe matriz completa com os registros atuais
					
					System.out.print(nomePlayer[i]+"          ");
					
					for (int j = 0; j < col; j++) {

						System.out.print(resultado[i][j]+"          ");
							
					}				
					System.out.println(" ");					
				}		
				
				System.out.println("------------------------------------------------\n\n");
				break;
				
			case 4:
				// Exibir os jogos para definir novos pontos
				System.out.println("Escolha um jogo da lista (de 1 a 5) para definir nova pontuacao e aperte ENTER: " );
				for (int i = 0; i < lin; i++) {
					System.out.println(" "+(i+1)+" - "+nomeJogos[i] );
	
				}
				jogo = scan.nextInt();
				
				// exibir jogadores para efetuar a troca de pontuacao
				System.out.println("Qual jogador sera trocada a pontuacao? \nEscolha de 1 a 5 e "
						+ "aperte ENTER " );
				for (int i = 0; i < lin; i++) {
					System.out.println(" "+(i+1)+" - "+nomePlayer[i] );
	
				}
				player1 = scan.nextInt(); // define nome do jogador para trocar pontos
				
				System.out.println("Qual a nova pontuacao do "+nomePlayer[player1-1]+" no jogo "+nomeJogos[jogo-1] + "?\nDigite a nova pontuacão e "
						+ "aperte ENTER ");
				resultado[player1-1][jogo-1]=scan.nextInt();
				
				System.out.println("------------------------------------------------\n\n");
				break;

			case 5:

				System.out.print("\nDigite o nome do player ou jogo para saber a pontuacao e aperte ENTER: \n");
				busca = scan.next().toLowerCase();
				System.out.print("\n");

				for (int i = 0; i < lin; i++) {  //exibe matriz completa com os registros atuais
					
					if (nomePlayer[i].toLowerCase().equals(busca)) {
						
						System.out.print(nomePlayer[i]+" teve os seguintes pontos: \n");
						
						for (int j = 0; j < col; j++) {

							System.out.print(nomeJogos[j]+": "+resultado[i][j]+"   ");
								
						}
						
						i = lin;
						
					}else { if(nomeJogos[i].toLowerCase().equals(busca)) {
						
						System.out.print(nomeJogos[i]+" teve os seguintes pontos dos jogadores: \n");
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
				System.out.println("------------------------------------------------\n\n");
				break;

			case 6:
				exit=0;
				System.out.println("------------------------------------------------\n\n");

				break;
					
			}
			
			if (op <= 0 || op > 6 ) {
				
				System.out.println("Escolha invalida, digite novamente!! \n");

			}

			
			
			}while(exit!=0);
			
			// Preencher resultado final do jogo
			System.out.println("Resultado final do evento de cada jogador\n");
			
			System.out.print("             ");

		
			for(int i = 0 ; i < lin ; i++) {
				
				System.out.print(nomeJogos[i]+"  ");
				
				}
				
				System.out.println("");

				
				
				for (int i = 0; i < lin; i++) {  //exibe matriz completa com os registros atuais
					
					System.out.print(nomePlayer[i]+"          ");
					
					for (int j = 0; j < col; j++) {

						System.out.print(resultado[i][j]+"          ");
						ganhou[i] += resultado[i][j];
							
					}				
					System.out.println(" ");					
				}		
			
			//ver quem ganhou o evento
			//reaproveitar variaveis que tem nome sugestivo ao uso
			win = ganhou[0]; 
			jogo=0;
			
			for (int i = 1; i < lin; i++) {
				
				if(ganhou[i]>win) {
					
					win=ganhou[i];
					jogo=i;
					
				}
	
			}
			System.out.println(" ");

			//verificar se a variavel win tem pontos, se nao tiver ninguem ganhou
			if(win!=0) {
				
				System.out.println("O vencedor do torneiro eh "+nomePlayer[jogo]+" com o total de "+ganhou[jogo]+""
						+ " no placar geral");
				
			}else {
				
				System.out.println("Por incrivel que pareça ninguem ganhou!!!!!");
				
			}			
					
	}
	
}
