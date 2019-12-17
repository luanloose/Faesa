package pacote;


public class Livro extends Item {
	private String editora;
	private int dataPublicacao;
	
	public Livro() {
		super();
	}

	public Livro(int codigo, String autor, String titulo, String issn, char tipo, String editora, int dataPublicacao) {
		super(codigo, autor, titulo, issn, tipo);
		this.editora = editora;
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(int dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	@Override
	public String toString() {
		return super.toString() + editora + ";" + dataPublicacao + " ";
	}
	
}
