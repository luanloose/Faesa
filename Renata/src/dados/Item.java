package dados;


public class Item {
	
	private Apartamento chave;
	
	
	// aqui podem ser declarados outros atributos conforme sua necessidade.
	//Construtor de objetos da classe Item

	public Item(Apartamento ch) {
		this.chave = ch;
	}

	//Modifica o valor do atributo chave
	public void setChave (Apartamento ch){
		this.chave = ch;
	}
		
	//Faz a leitura do valor do atributo chave
	public Apartamento getChave (){
		return this.chave;
	}
	
}
