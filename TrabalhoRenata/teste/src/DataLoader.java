
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DataLoader{
	
	/////////////////////////////////////////////////////////////////
	// Atributos
	/////////////////////////////////////////////////////////////////
	
	private static String[]   header;
	private static Object[][] data;
	private static Object[][] dataOrdenadoMunicipio;
	private static Object[][] dataOrdenadoMunicipioPopulacao;
	private static String     path = "/Users/luanloose/Documents/TrabalhoRenata/teste/src/teste/dados.txt";
	//private static double     totalPopulacao;
	//private static double     mediaPopulacao;
	//private static double     desvioPadraoPopulacao;

	static{
		convertData(SuporteArquivo.leArquivo(path));
		convertDataMunicipio(SuporteArquivo.leArquivo(path));
		convertDataMunicipioPopulacao(SuporteArquivo.leArquivo(path));
		convertHeader(SuporteArquivo.getHeader()); 
		calculaMediaEdesvioPadraoBrasil();
		calculaMediasEdesviosPadroesPorRegiao();
		municipiosPorEstado();
		numeroMunicipiosSudeste();
		municipiosRepetidos();
		//teste();
	}
	
	
	/////////////////////////////////////////////////////////////////
	// Getters
	/////////////////////////////////////////////////////////////////
	
	public static String[] getHeader() {
		return header;
	}
	
	public static Object[][] getData() {
		return data;
	}
	
	public static Object[][] getDataOrdenadoMunicipio() {
		return dataOrdenadoMunicipio;
	}
	
	public static Object[][] getDataOrdenadoMunicipioPopulacao() {
		return dataOrdenadoMunicipioPopulacao;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// Setters
	/////////////////////////////////////////////////////////////////	
	
	private static void setHeader(String[] header) {
		DataLoader.header = header;
	}
	
	//private static void setData(Object[][] data) {
	//	DataLoader.data = data;
	//}

	
	/////////////////////////////////////////////////////////////////
	// convertHeader
	/////////////////////////////////////////////////////////////////
	
	private static void convertHeader(String header) {
		setHeader(new String[5]);
		StringTokenizer st = new StringTokenizer(header, "*");
		int i = 0;
		while (st.hasMoreTokens()){
			DataLoader.header[i++] = st.nextToken();
		}
	}
	
	
	/////////////////////////////////////////////////////////////////
	// convertData
	/////////////////////////////////////////////////////////////////
	
	private static void convertData(List<Municipio>municipios){
		data = new String[municipios.size()][6];
		int i = 0;
		for (Municipio municipio: municipios) {
			data[i]    = new String[6];
			data[i][0] = municipio.getSiglaUF();
			data[i][1] = municipio.getCodUF();
			data[i][2] = municipio.getCodMun();
			data[i][3] = municipio.getMunicipio();
			data[i][4] = municipio.getPopulacao(); 
			data[i][5] = municipio.getRegiao(); 		
			i++;
		}
	}
	
	private static void convertDataMunicipio(List<Municipio>municipios) {
		MunicipioComparator comp = new MunicipioComparator();
		municipios.sort(comp);
		dataOrdenadoMunicipio = new String[municipios.size()][6];
		int i = 0;
		for (Municipio municipio: municipios) {
			dataOrdenadoMunicipio[i]    = new String[6];
			dataOrdenadoMunicipio[i][0] = municipio.getSiglaUF();
			dataOrdenadoMunicipio[i][1] = municipio.getCodUF();
			dataOrdenadoMunicipio[i][2] = municipio.getCodMun();
			dataOrdenadoMunicipio[i][3] = municipio.getMunicipio();
			dataOrdenadoMunicipio[i][4] = municipio.getPopulacao(); 
			dataOrdenadoMunicipio[i][5] = municipio.getRegiao(); 		
			i++;
		}
	}
	
	private static void convertDataMunicipioPopulacao(List<Municipio>municipios) {
		MunicipioPopulacaoComparator comp = new MunicipioPopulacaoComparator();
		municipios.sort(comp);
		dataOrdenadoMunicipioPopulacao = new String[municipios.size()][6];
		int i = 0;
		for (Municipio municipio: municipios) {
			dataOrdenadoMunicipioPopulacao[i]    = new String[6];
			dataOrdenadoMunicipioPopulacao[i][0] = municipio.getSiglaUF();
			dataOrdenadoMunicipioPopulacao[i][1] = municipio.getCodUF();
			dataOrdenadoMunicipioPopulacao[i][2] = municipio.getCodMun();
			dataOrdenadoMunicipioPopulacao[i][3] = municipio.getMunicipio();
			dataOrdenadoMunicipioPopulacao[i][4] = municipio.getPopulacao(); 
			dataOrdenadoMunicipioPopulacao[i][5] = municipio.getRegiao(); 		
			i++;
		}
	}

	
	/////////////////////////////////////////////////////////////////
	// cálculosBrasil
	/////////////////////////////////////////////////////////////////
	
	private static void calculaMediaEdesvioPadraoBrasil() {
		double[] populacao= new double [data.length];
		String aux = "";
		for (int i = 0; i < data.length; i++) {
			aux = data[i][4].toString().replace(".", "");
			populacao[i] = Double.parseDouble(aux);
		}
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("Média populacional dos municípios do Brasil:         " 
		                   + String.format("%.2f", calculaMedia(populacao)));
		System.out.println("Desvio padrão populacional dos municípios do Brasil: " 
		                   + String.format("%.2f", desvioPadrao(populacao)));
		System.out.println("------------------------------------------------------------------\n\n");
	}
	
	
	/////////////////////////////////////////////////////////////////
	// cálculosRegião
	/////////////////////////////////////////////////////////////////
	
	private static void calculaMediasEdesviosPadroesPorRegiao() {
		
		double[] populacaoSU;
		double[] populacaoSD;
		double[] populacaoCE;
		double[] populacaoNO;
		double[] populacaoND;
		
		int contadorSU = 0;
		int contadorSD = 0;
		int contadorCE = 0;
		int contadorNO = 0;
		int contadorND = 0;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i][5].equals("SUL")) {
				contadorSU++;
			} else if (data[i][5].equals("SUDESTE")) {
				contadorSD++;
			} else if (data[i][5].equals("CENTRO-OESTE")) {
				contadorCE++;
			} else if (data[i][5].equals("NORTE")) {
				contadorNO++;
			} else if (data[i][5].equals("NORDESTE")) {
				contadorND++;
			}
		}
		
		populacaoSU = new double[contadorSU];
		populacaoSD = new double[contadorSD];
		populacaoCE = new double[contadorCE];
		populacaoNO = new double[contadorNO];
		populacaoND = new double[contadorND];
		
		String aux = "";
		contadorSU = 0;
		contadorSD = 0;
		contadorCE = 0;
		contadorNO = 0;
		contadorND = 0;
		for (int i = 0; i < data.length; i++) {
			
			if (data[i][5].equals("CENTRO-OESTE")) {
				aux = data[i][4].toString().replace(".", "");
				populacaoCE[contadorCE] = Double.parseDouble(aux);
				contadorCE++;
				
			} else if (data[i][5].equals("SUL")) {
				aux = data[i][4].toString().replace(".", "");
				populacaoSU[contadorSU] = Double.parseDouble(aux);
				contadorSU++;
				
			} else if (data[i][5].equals("SUDESTE")) {
				aux = data[i][4].toString().replace(".", "");
				populacaoSD[contadorSD] = Double.parseDouble(aux);
				contadorSD++;
				
			} else if (data[i][5].equals("NORDESTE")) {
				aux = data[i][4].toString().replace(".", "");
				populacaoND[contadorND] = Double.parseDouble(aux);
				contadorND++;
				
			} else if (data[i][5].equals("NORTE")) {
				aux = data[i][4].toString().replace(".", "");
				populacaoNO[contadorNO] = Double.parseDouble(aux);
				contadorNO++;
			}
		
		}
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Média populacional dos municípios do Centro-Oeste:         " 
		                   + String.format("%.2f", calculaMedia(populacaoCE)));
		System.out.println("Desvio padrão populacional dos municípios do Centro-Oeste: "
		                   + String.format("%.2f", desvioPadrao(populacaoCE)));
		System.out.println();
		
		System.out.println("Média populacional dos municípios do Nordeste:         "
		                   + String.format("%.2f", calculaMedia(populacaoND)));
		System.out.println("Desvio padrão populacional dos municípios do Nordeste: "
		                   + String.format("%.2f", desvioPadrao(populacaoND)));
		System.out.println();
		
		System.out.println("Média populacional dos municípios do Norte:         "
		                   + String.format("%.2f", calculaMedia(populacaoNO)));
		System.out.println("Desvio padrão populacional dos municípios do Norte: "
		                   + String.format("%.2f", desvioPadrao(populacaoNO)));
		System.out.println();
		
		System.out.println("Média populacional dos municípios do Sudeste:         " 
		                   + String.format("%.2f", calculaMedia(populacaoSD)));
		System.out.println("Desvio padrão populacional dos municípios do Sudeste: "
		                   + String.format("%.2f", desvioPadrao(populacaoSD)));
		System.out.println();
		
		System.out.println("Média populacional dos municípios do Sul:         "
		                   + String.format("%.2f", calculaMedia(populacaoSU)));
		System.out.println("Desvio padrão populacional dos municípios do Sul: "
		                   + String.format("%.2f", desvioPadrao(populacaoSU)));
		System.out.println("------------------------------------------------------------\n\n");
	}
	
	
	/////////////////////////////////////////////////////////////////
	// municipiosPorEstado
	/////////////////////////////////////////////////////////////////	
	private static void municipiosPorEstado() {
		
		int[] numeroMunicipios = new int[27];
		
		for (int i = 0; i < numeroMunicipios.length; i++) {
			numeroMunicipios[i] = 0;
		}
		
		// Região sul
		int RS = 0;
		int SC = 1;
		int PR = 2;
		
		// Região sudeste
		int SP = 3;
		int RJ = 4;
		int MG = 5;
		int ES = 6;
		
		// Região centro-oeste
		int MT = 7;
		int MS = 8;
		int GO = 9;
		int DF = 10;
		
		// Região nordeste
		int BA = 11;
		int SE = 12;
		int AL = 13;
		int PE = 14;
		int PB = 15;
		int RN = 16;
		int CE = 17;
		int PI = 18;
		int MA = 19;
		
		// Região norte
		int TO = 20;
		int PA = 21;
		int AP = 22;
		int RO = 23;
		int AM = 24;
		int RR = 25;
		int AC = 26;
		
		for (int i = 0; i < data.length; i++) {
			
			switch (data[i][0].toString()) {
			case "AC":
				numeroMunicipios[AC]++;
				break;
			case "RR":
				numeroMunicipios[RR]++;
				break;
			case "AM":
				numeroMunicipios[AM]++;
				break;
			case "RO":
				numeroMunicipios[RO]++;
				break;
			case "AP":
				numeroMunicipios[AP]++;
				break;
			case "PA":
				numeroMunicipios[PA]++;
				break;
			case "TO":
				numeroMunicipios[TO]++;
				break;
			case "MA":
				numeroMunicipios[MA]++;
				break;
			case "PI":
				numeroMunicipios[PI]++;
				break;
			case "CE":
				numeroMunicipios[CE]++;
				break;
			case "RN":
				numeroMunicipios[RN]++;
				break;
			case "PB":
				numeroMunicipios[PB]++;
				break;
			case "PE":
				numeroMunicipios[PE]++;
				break;
			case "AL":
				numeroMunicipios[AL]++;
				break;
			case "SE":
				numeroMunicipios[SE]++;
				break;
			case "BA":
				numeroMunicipios[BA]++;
				break;
			case "DF":
				numeroMunicipios[DF]++;
				break;
			case "GO":
				numeroMunicipios[GO]++;
				break;
			case "MS":
				numeroMunicipios[MS]++;
				break;
			case "MT":
				numeroMunicipios[MT]++;
				break;
			case "ES":
				numeroMunicipios[ES]++;
				break;
			case "MG":
				numeroMunicipios[MG]++;
				break;
			case "RJ":
				numeroMunicipios[RJ]++;
				break;
			case "SP":
				numeroMunicipios[SP]++;
				break;
			case "PR":
				numeroMunicipios[PR]++;
				break;
			case "SC":
				numeroMunicipios[SC]++;
				break;
			case "RS":
				numeroMunicipios[RS]++;
				break;
			default:
				break;
			}
		}
		System.out.println("--------------------------------");
		System.out.println("Número de municípios por estado:");
		System.out.println("--------------------------------");
		System.out.println("Estados da Região Sul:");
		System.out.println("   RS: " + numeroMunicipios[RS]);
		System.out.println("   SC: " + numeroMunicipios[SC]);
		System.out.println("   PR: " + numeroMunicipios[PR]);
		System.out.println("Estados da Região Sudeste:");
		System.out.println("   SP: " + numeroMunicipios[SP]);
		System.out.println("   RJ: " + numeroMunicipios[RJ]);
		System.out.println("   MG: " + numeroMunicipios[MG]);
		System.out.println("   ES: " + numeroMunicipios[ES]);
		System.out.println("Estados da Região Centro-Oeste:");
		System.out.println("   MT: " + numeroMunicipios[MT]);
		System.out.println("   MS: " + numeroMunicipios[MS]);
		System.out.println("   GO: " + numeroMunicipios[GO]);
		System.out.println("   DF: " + numeroMunicipios[DF]);
		System.out.println("Estados da Região Nordeste:");
		System.out.println("   BA: " + numeroMunicipios[BA]);
		System.out.println("   SE: " + numeroMunicipios[SE]);
		System.out.println("   AL: " + numeroMunicipios[AL]);
		System.out.println("   PE: " + numeroMunicipios[PE]);
		System.out.println("   PB: " + numeroMunicipios[PB]);
		System.out.println("   RN: " + numeroMunicipios[RN]);
		System.out.println("   CE: " + numeroMunicipios[CE]);
		System.out.println("   PI: " + numeroMunicipios[PI]);
		System.out.println("   MA: " + numeroMunicipios[MA]);
		System.out.println("Estados da Região Norte:");
		System.out.println("   TO: " + numeroMunicipios[TO]);
		System.out.println("   PA: " + numeroMunicipios[PA]);
		System.out.println("   AP: " + numeroMunicipios[AP]);
		System.out.println("   RO: " + numeroMunicipios[RO]);
		System.out.println("   AM: " + numeroMunicipios[AM]);
		System.out.println("   RR: " + numeroMunicipios[RR]);
		System.out.println("   AC: " + numeroMunicipios[AC]);
		System.out.println("--------------------------------\n\n");
	}
	
	
	/////////////////////////////////////////////////////////////////
	// numeroMunicipiosSudeste
	/////////////////////////////////////////////////////////////////	
	
	private static void numeroMunicipiosSudeste() {
		
		int[] numeroMunicipios = new int[4];
		
		for (int i = 0; i < numeroMunicipios.length; i++) {
			numeroMunicipios[i] = 0;
		}
		
		// Região sudeste
		int SP = 0;
		int RJ = 1;
		int MG = 2;
		int ES = 3;
		
		for (int i = 0; i < data.length; i++) {
			
			switch (data[i][0].toString()) {
			case "SP":
				numeroMunicipios[SP]++;
				break;
			case "RJ":
				numeroMunicipios[RJ]++;
				break;
			case "MG":
				numeroMunicipios[MG]++;
				break;
			case "ES":
				numeroMunicipios[ES]++;
				break;
			}
		}
		
		System.out.println("--------------------------------------");
		System.out.println("Total de municípios da Região Sudeste:");
		System.out.println("--------------------------------------");
		System.out.println("   ES: " + numeroMunicipios[3]);
		System.out.println("   MG: " + numeroMunicipios[2]);
		System.out.println("   RJ: " + numeroMunicipios[1]);
		System.out.println("   SP: " + numeroMunicipios[0]);
		System.out.println("");
		System.out.println("TOTAL: " + (numeroMunicipios[0]+numeroMunicipios[1]+numeroMunicipios[2]+numeroMunicipios[3]));
		System.out.println("--------------------------------------\n\n");
	}
	
	
	/////////////////////////////////////////////////////////////////
	// calculaMedia
	/////////////////////////////////////////////////////////////////	
	
	private static double calculaMedia(double[] populacao) {
		
		double totalPopulacao = 0;
		
		for (int i = 0; i < populacao.length; i++) {
			totalPopulacao += populacao[i];
		}
		
		double media = totalPopulacao/populacao.length;
		
		return media;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// variancia
	/////////////////////////////////////////////////////////////////
	
	public static double variancia(double[] populacao) {
		
		double result;
		
		if (populacao.length == 1) {
			return 0.0;
		} else {
			double mediaAritimetica = calculaMedia(populacao);
			double somatorio = 0;
			for (int i = 0; i < populacao.length; i++) {
				result = populacao[i] - mediaAritimetica;
				somatorio = somatorio + result * result;
			}
			
			double variancia = somatorio / (populacao.length - 1);
			return variancia;

		}
	}	
	
	
	/////////////////////////////////////////////////////////////////
	// desvioPadrao
	/////////////////////////////////////////////////////////////////	
	
	public static double desvioPadrao(double[] populacao) {	
			return Math.sqrt(variancia(populacao));
	}
	
	
	/////////////////////////////////////////////////////////////////
	// municipiosRepetidos
	/////////////////////////////////////////////////////////////////
	public static void municipiosRepetidos(){
		
		String[] nomesMunicipios = new String[data.length];
		//String aux = "";
		for (int i = 0; i < data.length; i++) {
			nomesMunicipios[i] = data[i][3].toString();
		}
			
		Map<String,Integer> mapPalavras = new HashMap<String,Integer>();
		
		for (int i = 0; i < nomesMunicipios.length; i++) {
			String nome = nomesMunicipios[i];
			
			Integer freq = mapPalavras.get(nome);
			if (freq != null) {
				mapPalavras.put(nome, freq+1);
			} else {
				mapPalavras.put(nome, 1);
			}
		}
		
		List<Municipio>municipiosRepetidos = new ArrayList<Municipio>();
		for (Map.Entry<String, Integer> entry : mapPalavras.entrySet()) {
			if (entry.getValue() > 1) {
				Municipio mRep = new Municipio(entry.getKey(), entry.getValue().toString());
				municipiosRepetidos.add(mRep);
			}
	     }
		
		MunicipiosRepetidosComparator comp = new MunicipiosRepetidosComparator();
		municipiosRepetidos.sort(comp);
		
		System.out.println("--------------------------------------------------");
		System.out.println("Nomes de municípios repetidos:");
		System.out.println("--------------------------------------------------");
		for (Municipio m: municipiosRepetidos) {
			System.out.println(m.getMunicipio() + ": " + m.getPopulacao());
		}
		System.out.println("--------------------------------------------------\n\n");
	}
	
//	public static void teste() {
//		List<Municipio>municipiosRepetidos = new ArrayList<Municipio>();
//		MunicipioPopulacaoComparator comp = new MunicipioPopulacaoComparator();
//		for (int i = 0; i < data.length; i++) {
//			Municipio mRep = new Municipio(data[i][3].toString(), data[i][4].toString().replace(".", ""));
//			municipiosRepetidos.add(mRep);
//		}
//		municipiosRepetidos.sort(comp);
//		for (Municipio m: municipiosRepetidos) {
//			System.out.println(m.getMunicipio() + ": " + m.getPopulacao());
//		}
//	}

}
