package algoritmo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inicio do programa: ");
		Classe1 calc2 = new Classe1(2,3);
		
		//mostra numeros
		System.out.println(calc2.toString());
		
		//soma numeros
		System.out.println("Soma dos 2 numeros: "+calc2.retornaSoma());
		
		//multiplica numeros
		System.out.println("Multiplica�ao dos 2 numeros: "+calc2.retornaMultiplicacao());
		
		Classe2 calc3 = new Classe2(2,3,3);
		
		//soma numeros
		System.out.println("Soma dos 3 numeros: "+calc3.retornaSoma(3));
				
		//multiplica numeros
		System.out.println("Multiplica�ao dos 3 numeros: "+calc3.retornaMultiplicacao(3));

	}

}
