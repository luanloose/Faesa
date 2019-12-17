
public class Periodicos extends Livro {
	private double fatorImpacto;

	public Periodicos() {
		super();
		
	}

	public Periodicos(int codigo, String autor, String titulo, String issn, char tipo, String editora,
			int dataPublicacao, double fatorImpacto) {
		super(codigo, autor, titulo, issn, tipo, editora, dataPublicacao);
		this.fatorImpacto = fatorImpacto;
	}

	public double getFatorImpacto() {
		return fatorImpacto;
	}

	public void setFatorImpacto(double fatorImpacto) {
		this.fatorImpacto = fatorImpacto;
	}

	@Override
	public String toString() {
		return super.toString() + "<" + fatorImpacto + ">";
	}
	
	
	
	

}
