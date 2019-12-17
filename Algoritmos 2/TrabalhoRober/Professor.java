
public class Professor extends Usuario {
	private String setor;

	public Professor() {
		super();
		
	}

	public Professor(int matricula, String nome, String endereco, String dataIngresso, String setor) {
		super(matricula, nome, endereco, dataIngresso);
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	@Override
	public String toString() {
		return super.toString() + "<" + setor + ">";
	}

}
