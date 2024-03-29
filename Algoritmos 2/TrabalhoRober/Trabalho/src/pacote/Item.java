package pacote;


public class Item {
	private int codigo;
	private String autor;
	private String titulo;
	private String issn;
	private char tipo;
	
	public Item() {
		super();
	}

	public Item(int codigo, String autor, String titulo, String issn, char tipo) {
		super();
		this.codigo = codigo;
		this.autor = autor;
		this.titulo = titulo;
		this.issn = issn;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return codigo + ";" + autor + ";" + titulo + ";" + issn + ";" + tipo + ";";
	}

}
