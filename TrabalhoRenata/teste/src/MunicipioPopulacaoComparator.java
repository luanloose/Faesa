import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class MunicipioPopulacaoComparator implements Comparator<Municipio>{
	Collator coll = Collator.getInstance(new Locale("pt", "BR"));
	
	@Override
	public int compare(Municipio m0, Municipio m1) {
		int compNome = coll.compare(m0.getMunicipio(), m1.getMunicipio());
		if (compNome != 0) {
			return compNome;
		}
		
		int compPopulacao = ((int) (Integer.parseInt(m0.getPopulacao().replace(".", "")) - Integer.parseInt(m1.getPopulacao().replace(".", ""))));
		return compPopulacao;
	}
	
}
