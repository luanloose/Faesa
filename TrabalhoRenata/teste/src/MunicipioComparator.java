import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;


public class MunicipioComparator implements Comparator<Municipio>{
	Collator coll = Collator.getInstance(new Locale("pt", "BR"));
	
	@Override
	public int compare(Municipio m0, Municipio m1) {
		int compNome = coll.compare(m0.getMunicipio(), m1.getMunicipio());
		return compNome;
	}
	
}
