import java.util.Scanner;

public class Breno {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int cont = 3;
		int vetor[] = new int[cont];
		
		for(int i = 0; i < vetor.length; ++i)
		{
			System.out.print((i+1) + " VALOR: ");
			vetor[i] = input.nextInt();
		}
		
		for(int c = vetor.length -1; c > 0; c--)
		{
			System.out.println(vetor[c]);
		}
		
	}

}