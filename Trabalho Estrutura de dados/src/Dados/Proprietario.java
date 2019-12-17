package Dados;

import Interface.Metodo;

public class Proprietario {
	private long cpf;
	private String nome;
	private String telefone;
	private String email;


	//Construtores
	public Proprietario(long cpf, String nome, String telefone, String email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}


	//Get - Set
	public long getCPF() {
		return cpf;
	}

	public void setCPF(long cpf) {
		this.cpf = cpf;
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
	
	
	//Retorna os dados em forma de vetor
	public String[] GetDados() {
		String dados[] = new String[3];
		
		dados[0] = String.valueOf(this.cpf);
		dados[1] = this.nome;
		dados[2] = this.email;
		dados[3] = this.telefone;
		
		return dados;
	}
	

	//toString
	@Override
	public String toString() {
		return Metodo.padLeft(String.valueOf(cpf), 13) + Metodo.padLeft(nome, 40) + Metodo.padLeft(telefone, 14) + Metodo.padLeft(email, 35);
	}

}




























