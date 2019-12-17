import java.util.Scanner;

public class Novo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int cont=0, tam=10;
		int [] vet = new int[tam];
		
		for (int i = 0; i < tam; i++) {
			System.out.println("Digite um numero: ");
				vet[i] = scan.nextInt();
				cont++;
				
				if(vet[i]==0) {			
					i=tam;
				}		
		}
		
		System.out.println("Quantidade de numeros do vetor: "+cont);
		System.out.println("Numeros digitados: ");
		
		for (int i = 0; i < cont; i++) {
			
			System.out.println(vet[i]);
			
		}
	}
}
