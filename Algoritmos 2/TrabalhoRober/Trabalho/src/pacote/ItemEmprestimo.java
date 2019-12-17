package pacote;

public class ItemEmprestimo {

	private int coditem;
	private int codLivro;
	private int codPeriodico;
	private int codEmprestimo;
	private String dataDevol;
	
	
	
	
	public ItemEmprestimo(int coditem, int codLivro, int codPeriodico, int codEmprestimo, String dataDevol) {
		super();
		this.coditem = coditem;
		this.codLivro = codLivro;
		this.codPeriodico = codPeriodico;
		this.codEmprestimo = codEmprestimo;
		this.dataDevol = dataDevol;
	}
	

	
	public int getCoditem() {
		return coditem;
	}
	public void setCoditem(int coditem) {
		this.coditem = coditem;
	}
	public int getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}
	public int getCodPeriodico() {
		return codPeriodico;
	}
	public void setCodPeriodico(int codPeriodico) {
		this.codPeriodico = codPeriodico;
	}
	public int getCodEmprestimo() {
		return codEmprestimo;
	}
	public void setCodEmprestimo(int codEmprestimo) {
		this.codEmprestimo = codEmprestimo;
	}
	public String getDataDevol() {
		return dataDevol;
	}
	public void setDataDevol(String datadevol) {
		this.dataDevol = datadevol;
	}
	
	public String toString() {
		return coditem + ";" + codEmprestimo  + ";" + codLivro + ";" + codPeriodico + ";" + dataDevol + " ";
	}

	
}