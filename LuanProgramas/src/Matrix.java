import java.util.Iterator;
import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scan = new Scanner (System.in);
		final int lin = 3;
		final int col = 3;
		
		// instanciar matriz
		
		String [][] nome = new String [lin][col];
		String [][] tel = new String [lin][col];

		
		// preencher matriz
		for (int i = 0; i < lin; i++) {
			for (int j = 0; j < col; j++) {

				System.out.println("Digite o nome: " );
				nome[i][j] = scan.next().toLowerCase();
				System.out.println("Digite o telefone: " );
				tel[i][j] = scan.next();
			}	
						
		}
		
		// pesquisar na matriz
		
		
		int x=0,y=0;
		boolean achou = false;
		String teste;
		
		System.out.println("Digite um elemento para ser procurado na matriz: ");
		teste = scan.next().toLowerCase();

		
		for (int i = 0; i < lin && !achou; i++) {
			for (int j = 0; j < col && !achou; j++) {
				if (nome[i][j].equals(teste)) {
					achou = true;
					x=i;
					y=j;
					
				}
		
			}
			
						
		}
		
		if(achou) {
			System.out.println("Nome: "+nome[x][y]+"\nTelefone: "+tel[x][y]);
			
		}else {
			System.out.println("Nome "+x+" nao foi encontrado na agenda ");

		}
		
		

		
		
		
		
		
		
	}

}
