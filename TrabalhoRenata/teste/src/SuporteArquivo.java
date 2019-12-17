
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SuporteArquivo {
	private static String header = "Sigla*Cód. UF.*Cod. Mun.*Município*População";

	public static List<Municipio> leArquivo(String arq){

		File f = new File(arq);
		
		Scanner sc = null;
		
		List<Municipio>municipios = new ArrayList<Municipio>();
		
		//System.out.println("Existe? "+f.exists()+"  \n"+f.getAbsolutePath());
		
		String regiao = "";

		try {
			sc = new Scanner(f);
			
			while (sc.hasNextLine()){
				String linha = sc.nextLine();

				StringTokenizer st = new StringTokenizer(linha, "*");	
				
				while (st.hasMoreElements()) {
					
					String siglaUF = st.nextToken();
					String codUF = st.nextToken();
					String codMun = st.nextToken();
					String municipio = st.nextToken();
					String populacao = st.nextToken();
		
					switch (siglaUF) {
					case "ES":
					case "MG":
					case "RJ":
					case "SP":
						regiao = "SUDESTE";
						break;
						
					case "AC":
					case "AM":
					case "AP":
					case "PA":
					case "RR":
					case "RO":
					case "TO":
						regiao = "NORTE";
						break;
						
					case "MA":
					case "PI":
					case "CE":
					case "RN":
					case "PB":
					case "PE":
					case "AL":
					case "SE":
					case "BA":

						regiao = "NORDESTE";
						break;
						
					case "DF":
					case "MT":
					case "MS":
					case "GO":
						regiao = "CENTRO-OESTE";
						break;
					
					case "PR":
					case "SC":
					case "RS":
						regiao = "SUL";
						break;
				
					default:
						break;
					}
					
					Municipio m = new Municipio(siglaUF, 
							codUF, codMun, 
							municipio, populacao, regiao);

					//System.out.println(m.toString());
					municipios.add(m);
					regiao = "";
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return municipios;
		
	}
	
	public static void imprimeArq(List<Municipio>municipios){
		System.out.printf("\n%-10s%-10s%10s%50s%10s","Sigla", "Cód. UF.", 
				                   "Cod. Mun.", "Município", "População");
		for (Municipio municipio : municipios) {
			System.out.printf("\n%-10s%-10s%10s%50s%10s",
					municipio.getSiglaUF(),
					municipio.getCodUF(),
					municipio.getCodMun(),
					municipio.getMunicipio(),
					municipio.getPopulacao());
		}
	}
	
	public static String getHeader() {
		return header;
	}	
}

