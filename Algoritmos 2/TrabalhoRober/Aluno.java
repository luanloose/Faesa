
public class Aluno extends Usuario{
	private String curso;
	private double multa;
	
	public Aluno() {
		super();
		
	}

	public Aluno(int matricula, String nome, String endereco, String dataIngresso, String curso, double multa) {
		super(matricula, nome, endereco, dataIngresso);
		this.curso = curso;
		this.multa = multa;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	@Override
	public String toString() {
		return super.toString() + "<" + curso + ">;<" + multa + ">";
	}

}
