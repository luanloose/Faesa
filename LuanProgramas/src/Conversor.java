import java.util.Scanner;

public class Conversor {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int num = 0,op = 0;
		char[] num2 = null;
		
		
		System.out.print("Qual base vc ira converter: \n"
				+ "1 - Decimal - > Hexadecimal\n2 - Decimal - > Binario\n"
				+ "3 - Decimal - > Octal \n4 - Hexadecimal - > Decimal\n"
				+ "5 - Hexadecimal - > Binário\n6 - Octal- > Decimal\n7 - Octal- > Binario");

		op = scan.nextInt();

		System.out.print("Digite o numero para converter: ");
		
		switch (op){
		
		
		
		case 1:
			
			num = scan.nextInt();
			break;
		
		case 2:
			System.out.print("Digite o numero para converter: ");
			num = scan.nextInt();
			break;
		
		case 3:
			System.out.print("Digite o numero para converter: ");
			num = scan.nextInt();
			break;
			
		case 4:
			break;
		
		case 5:
			break;
			
		case 6:
			System.out.print("Digite o numero para converter: ");
			num = scan.nextInt();
			break;
			
		case 7:
			System.out.print("Digite o numero para converter: ");
			num = scan.nextInt();
			break;
		
		}
		
		/*
		for(int i = 0; i < vetor.length; ++i)
		{
			System.out.print((i+1) + " VALOR: ");
			vetor[i] = input.nextInt();
		}
		
		for(int c = vetor.length -1; c > 0; c--)
		{
			System.out.println(vetor[c]);
		}
		*/
		
		
	}

}
