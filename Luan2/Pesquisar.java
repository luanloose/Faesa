package crud;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

 import modelo.Cantor;
 
public class Pesquisar {
	
	static StringBuffer buffer = new StringBuffer();
	static BufferedReader entrada;

	// Consulta geral de cadastros
	public static void pesquisaGeral() {
		try {
			String arquivo = CriarDatabase.criarDatabase();
			String listarRegistro = null;
			
			entrada = new BufferedReader(new FileReader(arquivo));
			 
			String linhas = "";
		
			int start = -1;
			
			// Monta o cabecalho da tabela
			listarRegistro = "<html>"
						+ "<table border '1' solid=\"#fff\">"
						+ "<tr>"
						+ "<th>Nome</th>"
						+ "<th>Nome artistico</th>"
						+ "<th>Idade</th>"
						+ "<th>Origem</th>"
						+ "<th>Genero musical"
						+ "</tr>";
			
			while( (linhas = entrada.readLine()) != null ) {
				buffer.append(linhas + "\n");

				start = buffer.indexOf(linhas);
				
				if( start > -1 ) {					
					int ultimo = buffer.indexOf(":", start);
					// Nome completo
					String nomeCompleto = buffer.substring(start, ultimo);

					int primeiro = ultimo + 1;
					ultimo = buffer.indexOf(":", primeiro);

					// Nome artistisco
					String nomeArtistico = buffer.substring(primeiro, ultimo);

					primeiro = ultimo + 1;
					ultimo = buffer.indexOf(":", primeiro);

					// Idade
					int idade = Integer.parseInt(buffer.substring(primeiro, ultimo));

					primeiro = ultimo + 1;
					ultimo = buffer.indexOf(":", primeiro);

					// Origem    
					String origem = buffer.substring(primeiro, ultimo);

					primeiro = ultimo + 1;
					int fim = buffer.indexOf("\n", primeiro);

					// Genero Musical    
					String generoMusical = buffer.substring(primeiro, fim);
					
					listarRegistro += "<tr>";

					listarRegistro += "<td width=\"100px\" align=\"left\">" + nomeCompleto  + "</td>";
					listarRegistro += "<td width=\"100px\" align=\"left\">" + nomeArtistico  + "</td>";
					listarRegistro += "<td width=\"100px\" align=\"left\">" + idade  + "</td>";
					listarRegistro += "<td width=\"100px\" align=\"left\">" + origem  + "</td>";
					listarRegistro += "<td width=\"100px\" align=\"left\">" + generoMusical  + "</td>";
					
					listarRegistro += "</tr>";
				}
				
			} 
			
			JOptionPane.showMessageDialog(null, listarRegistro);
	
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	
	public static void pesquisar() {

		try{
			String nomeCompleto;
			String nomeArtistico;
			String origem;
			String generoMusical;
			int idade;

			String arquivo = CriarDatabase.criarDatabase();

			entrada = new BufferedReader(new FileReader(arquivo));

			nomeCompleto = JOptionPane.showInputDialog("Nome do cantor:").toUpperCase();

			String linha = null;
			
			while( (linha = entrada.readLine()) != null ) {
				buffer.append(linha + "\n");
			}

			int inicio = -1;

			inicio = buffer.indexOf(nomeCompleto);

			if ( inicio > -1 ) {               
				// Nome
				int ultimo = buffer.indexOf(":", inicio);      
				nomeCompleto = buffer.substring(inicio, ultimo);

				int primeiro = ultimo + 1;
				ultimo = buffer.indexOf(":", primeiro);

				// Nome artistisco
				nomeArtistico = buffer.substring(primeiro, ultimo);

				primeiro = ultimo + 1;
				ultimo = buffer.indexOf(":", primeiro);

				// Idade
				idade = Integer.parseInt(buffer.substring(primeiro, ultimo));

				primeiro = ultimo + 1;
				ultimo = buffer.indexOf(":", primeiro);

				// Origem    
				origem = buffer.substring(primeiro, ultimo);

				primeiro = ultimo + 1;
				int fim = buffer.indexOf("\n", primeiro);

				// Genero Musical    
				generoMusical = buffer.substring(primeiro, fim);

				String listarRegistro = "";
				
				// Monta o cabecalho da tabela
				listarRegistro = "<html>"
							+ "<table border '1' solid=\"#fff\">"
							+ "<tr>"
							+ "<th>Nome</th>"
							+ "<th>Conhecido por</th>"
							+ "<th>Idade</th>"
							+ "<th>Origem</th>"
							+ "<th>Genero musical"
							+ "</tr>";
				
				listarRegistro += "<tr>";

				listarRegistro += "<td width=\"100px\" align=\"left\">" + nomeCompleto  + "</td>";
				listarRegistro += "<td width=\"100px\" align=\"left\">" + nomeArtistico  + "</td>";
				listarRegistro += "<td width=\"100px\" align=\"left\">" + idade  + "</td>";
				listarRegistro += "<td width=\"100px\" align=\"left\">" + origem  + "</td>";
				listarRegistro += "<td width=\"100px\" align=\"left\">" + generoMusical  + "</td>";
				
				listarRegistro += "</tr>";

				JOptionPane.showMessageDialog(null, listarRegistro, "Resultado da pesquisa", JOptionPane.PLAIN_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "Registro nao encontrado", "Pesquisar cantor", 
						JOptionPane.INFORMATION_MESSAGE);
			}

			entrada.close ();

		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo de dados!\n\n" + ex.getMessage(), "Pesquisar cantor", JOptionPane.ERROR_MESSAGE);
		}

	}

}