//<matrÝcula>;<nome>;<enderešo>;<data-ingresso>
package pacote;



public class Usuario {
	private int matricula;
	private String nome;
	private String endereco;
	private String dataIngresso;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int matricula, String nome, String endereco, String dataIngresso) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.dataIngresso = dataIngresso;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(String dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	@Override
	public String toString() {
		return matricula + ";" + nome + ";" + endereco + ";" + dataIngresso + ";";
	}	

}
