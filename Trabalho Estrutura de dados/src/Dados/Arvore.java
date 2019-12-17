package Dados;

public class Arvore {
	private NoArv raiz;
	private int quantNos;

	
	//Construtor
	public Arvore(){
		this.quantNos=0;
		this.raiz = null;
	}

	
	//Metodos
	public boolean eVazia (){
		return (this.raiz == null);
	}
	public NoArv getRaiz(){
		return this.raiz;
	}
	public int getQuantNos(){
		return this.quantNos;
	}


	//PESQUISAR
	public boolean pesquisar(long chave){
		if (pesquisar (chave, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}

	public NoArv pesquisar(long chave, NoArv no){
		if (no != null){
			if (chave < no.getInfo().getChave().getCodigo()){
				no = pesquisar (chave, no.getEsq());
			}else{
				if (chave > no.getInfo().getChave().getCodigo()){
					no = pesquisar (chave, no.getDir());
				}
			}
		}
		return no;
	}
	
	
	//INSERIR
	public boolean inserir(Item elem){
		if (pesquisar(elem.getChave().getCodigo())){
			return false;
		}else{
			this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}

	public NoArv inserir(Item elem, NoArv no){
		if (no == null){
			NoArv novo = new NoArv(elem);
			return novo;
		}else {
			if (elem.getChave().getCodigo() < no.getInfo().getChave().getCodigo()){
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}

	
	//REMOVER
	public boolean remover (long chave) {
		if (pesquisar (chave, this.raiz) != null) {
			this.raiz = remover(chave, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}

	public NoArv remover (long chave, NoArv arv) {
		if (chave < arv.getInfo().getChave().getCodigo()){
			arv.setEsq(remover (chave, arv.getEsq()));
		}else{
			if (chave > arv.getInfo().getChave().getCodigo()){
				arv.setDir(remover (chave, arv.getDir()));
			}else{
				if (arv.getDir()== null){
					return arv.getEsq();
				}else{
					if (arv.getEsq() == null){ 
						return arv.getDir();
					}else{
						arv.setEsq(Arrumar (arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}


	//ORGANIZA OS NÓS DA ARVORE
	private NoArv Arrumar (NoArv arv, NoArv maior){
		if (maior.getDir() != null){
			maior.setDir(Arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}


	//CAMINHANDO PELA ARVORE
	//CAMINHO IN-ORDEM
	public Item [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}

	private Item [] FazCamCentral (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}

	//CAMINHO PRÉ-ORDEM
	public Item [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}

	private Item [] FazCamPreFixado (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}

	//CAMINHO PÓS-ORDEM
	public Item [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}

	private Item [] FazCamPosFixado (NoArv arv, Item[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}
	
	//BUSCAS EESPECIFICAS
	//MOSTRA TODOS OS APTOS. DE UM MESMO CPF EM IN-ORDEM
	public Item [] ConsultaCPF (long cpf){
		int n[] = new int[1];
		n[0] = 0;
		Item [] vet = new Item[this.quantNos];
		return (FazConsultaCPF (this.raiz, vet, n, cpf));
	}

	private Item [] FazConsultaCPF (NoArv no, Item vet[], int n[], long cpf){
		if (no != null) {
			vet = FazConsultaCPF(no.getEsq(),vet,n, cpf);
			if (cpf == no.getInfo().getChave().getProprietario().getCPF()) {
				vet[n[0]] = no.getInfo();
				n[0]++;
			}
			vet = FazConsultaCPF(no.getDir(),vet,n, cpf);
		}
		return vet;
	}
	
	//MOSTRA TODOS OS APTOS. DO MESMO BLOCO EM IN-ORDEM	
	public Item [] ConsultaBloco (long bloco){
		int n[] = new int[1];
		n[0] = 0;
		Item [] vet = new Item[this.quantNos];
		return (FazConsultaBloco (this.raiz, vet, n, bloco));
	}

	private Item [] FazConsultaBloco (NoArv no, Item vet[], int n[], long bloco){
		if (no != null) {
			vet = FazConsultaBloco(no.getEsq(),vet,n, bloco);
			if (bloco == (long)(no.getInfo().getChave().getCodigo()/100)) {
				vet[n[0]] = no.getInfo();
				n[0]++;
			}
			vet = FazConsultaBloco(no.getDir(),vet,n, bloco);
		}
		return vet;
	}
	
}//Classe













