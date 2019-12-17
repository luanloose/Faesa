package Dados;

import Interface.Metodo;

public class Apartamento {
	private long codigo; //Bloco (a)/ Andar (b)/ Num. Ap. (c)  EX: 302 == a | b | c
	private long m2;			
	private long vagasCarro;
	private long numQuartos;
	private Proprietario proprietario;
	
	
	//Construtores	
	public Apartamento(long codigo, long m2, long vagasCarro, long numQuartos, Proprietario proprietario) {
		super();
		this.codigo = codigo;
		this.m2 = m2;
		this.vagasCarro = vagasCarro;
		this.numQuartos = numQuartos;
		this.proprietario = proprietario;
	}


	//Get - Set	
	public long getCodigo() {
		return codigo;
	}
	public long getVagasCarro() {
		return vagasCarro;
	}

	public void setVagasCarro(long vagasCarro) {
		this.vagasCarro = vagasCarro;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getM2() {
		return m2;
	}
	public void setM2(long m2) {
		this.m2 = m2;
	}
	public long getNumQuartos() {
		return numQuartos;
	}
	public void setNumQuartos(long numQuartos) {
		this.numQuartos = numQuartos;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	
	//Retorna os dados em forma de vetor
	public String[] GetDados() {
		String dados[] = new String[7];
		dados[0] = String.valueOf(this.codigo);
		dados[1] = String.valueOf(this.m2);
		dados[2] = String.valueOf(this.vagasCarro);
		dados[3] = String.valueOf(this.numQuartos);
		
		dados[4] = String.valueOf(this.proprietario.getCPF());
		dados[5] = this.proprietario.getNome();
		dados[6] = this.proprietario.getEmail();
		dados[7] = this.proprietario.getTelefone();
		
		return dados;
	}


	//toString
	@Override
	public String toString() {
		return Metodo.padLeft(String.valueOf(codigo), 7) + Metodo.padLeft(String.valueOf(m2), 7) + Metodo.padLeft(String.valueOf(vagasCarro), 13) + Metodo.padLeft(String.valueOf(numQuartos), 14) + proprietario.toString();
	}
	
}


























