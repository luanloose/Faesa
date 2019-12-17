package pacote;
import java.util.Scanner;
import dados.Item;
import dados.Apartamento;


public class Principal {
	
	static Scanner scan =new Scanner(System.in);

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		long cod;
		long m2;
		long nQ;
		long prop;

		
		
		Item [] vetor= new Item[10];
		char opcao;
		do {
			System.out.println("Escolha uma Opção:\n" +
					"1. Inserir Nó na árvore\n"+
					"2. Localizar Nó na árvore\n"+
					"3. Excluir Nó da árvore\n" +
					"4. Exibir árvore ordenada\n" +
					"5. Sair");
			opcao = scan.next().charAt(0);
			switch (opcao){
			case '1':
				System.out.println("Inserir o codigo do ap\n"+
						"Digite um valor");
				cod = scan.nextLong();
				
				System.out.println("Inserir o m2: ");
				m2 = scan.nextLong();
				
				System.out.println("Inserir o numero de quarto: ");
				nQ = scan.nextLong();
				
				System.out.println("Inserir cod proprietario: ");
				prop = scan.nextLong();
				
				
				
				
				if (arvore.inserir(new Item(new Apartamento(cod,m2,nQ,prop)))){
					System.out.println("inserção efetuada com sucesso");
				}else{
					System.out.println("inserção não efetuada, "+
							"valor já existe");
				}
				break;
			case '2':
				if (arvore.eVazia()){
					System.out.println("Árvore está vazia");
				}else{
					System.out.println("Localizar um valor\n"+
							"Digite o valor");
					cod = scan.nextLong();
					if (arvore.pesquisar(cod)){
						System.out.println("o "+cod+" foi"+
								" encontrado");
					}else{
						System.out.println("o valor não foi"+
								" encontrado na arvore");
					}
				}
				break;
			case '3':
				if (arvore.eVazia()){
					System.out.println("Arvore está vazia");
				}else {
					System.out.println("Excluir um elemento da"+
							" lista\nDigite um valor");
					cod = scan.nextInt();
					if (arvore.remover(cod)){
						System.out.println("remoção efetuada");
					}else{
						System.out.println("remoção não"+
								" efetuada, valor não encontrado");
					}
				}	
				break;
			case '4':
				if (arvore.eVazia()){
					System.out.println("A árvore está vazia");
				}else{
					arvore.prefixado(this.raiz);
					String msg=" ";
					for (int i=0; i<arvore.getQuantNos();i++){
						msg+= vetor[i].getChave()+" ";
					}
					System.out.println("Exibir a árvore: "+ msg);
				}	
				break;
			case '5':
				System.out.println("fim do programa");
				break;
			default: 
				System.out.println("opção inválida, tente novamente");
			}
		} while (opcao!='5');
		System.exit(0);
	}
}
