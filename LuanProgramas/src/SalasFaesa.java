import java.util.Scanner;

public class SalasFaesa {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int teste = 0;
		
		System.out.print("Seja bem vindo a Faesa\nDigite o numero da sua sala: ");
		teste = input.nextInt();
		
				
		System.out.print("\nInformações detalhadas sobre sua sala: \n");
		for(int i = 0; i < 3; i++)
		{
			if (i == 0) {
				
				System.out.printf("\nFica na sala "+teste%10);
				
			}else if (i == 1) {
				
				System.out.printf(", no "+teste%10+"º andar");
						
			}else if (i == 2) {
				
				
				System.out.print(", bloco "+teste%10);
				
			}
			teste/=10;

		}
	
	}

}