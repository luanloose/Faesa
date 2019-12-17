
public class Municipio {
	
	/////////////////////////////////////////////////////////////////
	// Atributos
	/////////////////////////////////////////////////////////////////

	private String siglaUF;
	private String codUF;
	private String codMun;
	private String municipio;
	private String populacao;
	private String regiao;
	
	
	/////////////////////////////////////////////////////////////////
	// Construtores
	/////////////////////////////////////////////////////////////////

	public Municipio(String siglaUF,   String codUF, 
					 String codMun,    String municipio,
					 String populacao, String regiao) {
		setSiglaUF(siglaUF);
		setCodUF(codUF);
		setCodMun(codMun);
		setMunicipio(municipio);
		setPopulacao(populacao);
		setRegiao(regiao);
	}
	
	public Municipio(String municipio, String populacao) {
		setMunicipio(municipio);
		setPopulacao(populacao);
	}
	
	
	/////////////////////////////////////////////////////////////////
	// Getters
	/////////////////////////////////////////////////////////////////
	
	public String getSiglaUF() {
		return siglaUF;
	}
	
	public String getCodUF() {
		return codUF;
	}
	
	public String getCodMun() {
		return codMun;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public String getRegiao() {
		return regiao;
	}
	
	public String getPopulacao() {
		return populacao;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// Setters
	/////////////////////////////////////////////////////////////////
	
	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}
	
	public void setCodUF(String codUF) {
		this.codUF = codUF;
	}
	
	public void setCodMun(String codMun) {
		this.codMun = codMun;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}
	
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	
	/////////////////////////////////////////////////////////////////
	// toString
	/////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		String retorno = "";
		retorno = "UF:        " + siglaUF   + "\n" + 
				  "Cód. UF:   " + codUF     + "\n" + 
				  "Cód. Mun.: " + codMun    + "\n" + 
				  "Município: " + municipio + "\n" +
				  "População: " + populacao + "\n" +
				  "Região:    " + regiao;
		return retorno;
	}

}
