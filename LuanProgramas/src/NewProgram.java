import java.util.Scanner;

public class NewProgram {

	public static void main(String[] args) {
		
		//Variaveis
		final int tam=5;
		int multT[] = new int[tam];
		int media=0,soma=0,mult=0;
		char exit='s';
		Scanner scan = new Scanner(System.in) ;
		
		
		//Inicia loop
		while(exit=='s') {
			
				//Escrever no vetor X numeros
				for (int i=0;i<tam;i++) {
					
				System.out.println("Digite o "+(i+1)+" do vetor: ");
				multT[i] = scan.nextInt();
				
				}
				
				//Fazer a soma dos numeros multiplos de 3
				for (int i=0;i<tam;i++) {
					
				if (multT[i]%3==0) {
					soma += multT[i];
					mult += 1;
				}
				}
				
				//Verifica se tem multiplos de 3
				if (soma!=0) {
					
				media = soma/mult;
				
				System.out.println("A media dos numeros multiplos de 3 é: "+media);
				
				}else {
					System.out.println("Neste vetor nao possuem multiplos de 3 ");
					
				}
				
				//Pergunta se quer continuar e muda o char para minusculo sempre
				System.out.println("\nDeseja cadastrar mais numeros? S/N");
				exit = scan.next().toLowerCase().charAt(0);	
				System.out.println("-----------------------------------------------------");

				
			
		
		
					}
		
		System.out.println("Fim do programa!!!!");

		
		
		
		
	}
}