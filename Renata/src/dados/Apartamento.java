package dados;

public class Apartamento {
	private long codigo;
	private long m2;			//Bloco / Andar / Num. Ap.
	private long numQuartos;
	private long proprietario;
	
	
	//Construtores
	public Apartamento() {
		super();
		this.codigo = 0;
		this.m2 = 0;
		this.numQuartos = 0;
		this.proprietario = 0;
	}
	
	public Apartamento(long codigo, long m2, long numQuartos, long proprietario) {
		super();
		this.codigo = codigo;
		this.m2 = m2;
		this.numQuartos = numQuartos;
		this.proprietario = proprietario;
	}


	//Get - Set
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getM2() {
		return m2;
	}
	public void setM2(int m2) {
		this.m2 = m2;
	}
	public long getNumQuartos() {
		return numQuartos;
	}
	public void setNumQuartos(int numQuartos) {
		this.numQuartos = numQuartos;
	}
	public long getProprietario() {
		return proprietario;
	}
	public void setProprietario(long proprietario) {
		this.proprietario = proprietario;
	}


	//toString
	@Override
	public String toString() {
		//return "Codigo: " + codigo + "\nM2: " + m2 + "\nN�mero de quartos: " + numQuartos + "\nPropriet�rio: " + proprietario;
		return codigo + ";" + m2 + ";" + numQuartos + ";" + proprietario;
	}
	
}
