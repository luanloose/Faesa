package Dados;

public class Item {
	private Apartamento chave;

	public Item(Apartamento ch) {
		this.chave = ch;
	}

	public void setChave (Apartamento ch){
		this.chave = ch;
	}

	public Apartamento getChave (){
		return this.chave;
	}
}

