package dados;

public class Proprietario {
	private long codigo;
	private String nome;
	private String telefone;
	private String email;


	//Construtores
	public Proprietario() {
		super();
		this.codigo = 0;
		this.nome = "";
		this.telefone = "";
		this.email = "";
	}
	
	public Proprietario(long codigo, String nome, String telefone, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}


	//Get - Set
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	//toString
	@Override
	public String toString() {
		//return "Código: " + codigo + "\nNome: " + nome + "\nTelefone: " + telefone + "\nE-mail: " + email;
		return codigo + ";" + nome + ";" + telefone + ";" + email;
	}

}
