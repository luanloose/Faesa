import java.util.*;


public class Aula2804 {

	public static void main(String[] args) {
		double fat=0,total=1;
		Scanner scan = new Scanner(System.in) ;
		System.out.println("Digite um valor: ");
		fat = scan.nextDouble();
		
		for(double i=fat;i>0 && i!=0;i--) {
			
			total = total * i;
			
			System.out.println(total);
		}

	}

}
