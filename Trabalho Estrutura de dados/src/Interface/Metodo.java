package Interface;

public class Metodo {
	
	//Coloca um padding a esquerda das Strings
	public static String padLeft(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append(' ');
	    }
	    sb.append(inputString);
	 
	    return sb.toString();
	}//padLeft
	
	
	//Limpa tela
	public static void LimpaTela() {
		for (int i = 0; i < 8; i++) {
			System.out.print("\n\n\n\n\n");
		}
	}//LimpaTela

}//classe Metodo
