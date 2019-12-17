package pacote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Arquivos {

	// Escrever usuarios

	public void escreve(String arquivo, Usuario usuario) {

		String nomeArq = "planilhas\\" + arquivo + ".csv";

		FileWriter arq;
		try {
			arq = new FileWriter(nomeArq, true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(usuario.toString());
			arq.close();

			System.out.println("\nOs dados do arquio " + nomeArq + " foram gravados com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void escreve(String arquivo, String[][] vet) {

		String nomeArq = "planilhas\\" + arquivo + ".csv";

		FileWriter arq;
		try {
			arq = new FileWriter(nomeArq, true);
			PrintWriter gravarArq = new PrintWriter(arq);

			for (int i = 0; i < vet.length; i++) {
				for (int j = 0; j < vet[0].length; j++) {
					gravarArq.print(vet[i][j]);

				}
				gravarArq.println("");
			}

			arq.close();

			System.out.println("\nOs dados do arquio " + nomeArq + " foram gravados com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void escreveTeste(String arquivo, String item) {

		String nomeArq = "planilhas\\" + arquivo + ".csv";

		FileWriter arq;
		try {
			arq = new FileWriter(nomeArq, true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(item.toString());
			arq.close();

			System.out.println("\nOs dados do arquio " + nomeArq + " foram gravados com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Escrever itens
	public void escreve(String arquivo, Item item) {

		String nomeArq = "planilhas\\" + arquivo + ".csv";

		FileWriter arq;
		try {
			arq = new FileWriter(nomeArq, true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(item.toString());
			arq.close();

			System.out.println("\nOs dados do arquio " + nomeArq + " foram gravados com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ler(String arquivo) {

		String nomeArq = "planilhas\\" + arquivo + ".csv";

		System.out.printf("\nConte�do do arquivo texto:\n");
		try {
			FileReader arq = new FileReader(nomeArq);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // l� a primeira linha
			while (linha != null) {
				System.out.printf("%s\n", linha);

				linha = lerArq.readLine(); // l� da segunda at� a �ltima linha
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();
	}

	// --------------------------------------------------------------------------------------------------------------------

	// Escrever emprestimo

	public void escreve(String arquivo, Emprestimo emprestimo) {

		String nomeArq = "planilhas\\" + arquivo + ".csv";

		FileWriter arq;
		try {
			arq = new FileWriter(nomeArq, true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(emprestimo.toString());
			arq.close();

			System.out.println("\nOs dados do arquio " + nomeArq + " foram gravados com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Escrever itens

	public void escreve(String arquivo, ItemEmprestimo item) {

		String nomeArq = "planilhas\\" + arquivo + ".csv";

		FileWriter arq;
		try {
			arq = new FileWriter(nomeArq, true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(item.toString());
			arq.close();

			System.out.println("\nOs dados do arquio " + nomeArq + " foram gravados com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// --------------------------------------------------------------------------------------------------------------------

	public void lerAluno(String nome) {

		String arquivoCSV = "planilhas\\" + nome + ".csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = " ";
		String csvDivisorL = ";";

		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s\n", "Matricula", "Nome", "Endere�o", "Curso",
					"Data de Ingresso", "Multa");

			while ((linha = br.readLine()) != null) {

				String[] aluno = linha.split(csvDivisor);
				String[] aluno2 = linha.split(csvDivisorL);

				String alunoMatriz[][] = new String[aluno.length][aluno2.length];

				for (int i = 0; i < aluno.length; i++) {

					for (int j = 0; j < aluno2.length; j++) {

						alunoMatriz[i][j] = aluno2[j];
						System.out.printf("%-12s", alunoMatriz[i][j]);
					}
					System.out.println();

				}

			}
			System.out.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void lerFuncionario(String nome) {

		String arquivoCSV = "planilhas\\" + nome + ".csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = " ";
		String csvDivisorL = ";";

		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n", "Matricula", "Nome", "Endere�o",
					"Data de Ingresso", "Setor", "Login", "Senha");

			while ((linha = br.readLine()) != null) {

				// public Funcionario(int matricula, String nome, String endereco, String
				// dataIngresso, String setor, String login, String senha) {

				String[] funcionario = linha.split(csvDivisor);
				String[] funcionario2 = linha.split(csvDivisorL);

				String funcMatriz[][] = new String[funcionario.length][funcionario2.length];

				for (int i = 0; i < funcionario.length; i++) {

					for (int j = 0; j < funcionario2.length; j++) {

						funcMatriz[i][j] = funcionario2[j];
						System.out.printf("%-12s", funcMatriz[i][j]);
					}
					System.out.println();

				}

			}
			System.out.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void lerLivro(String nome) {

		String arquivoCSV = "planilhas\\" + nome + ".csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = " ";
		String csvDivisorL = ";";

		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n", "Codigo", "Autor", "Titulo", "ISSN", "Tipo",
					"Editora", "Data de publicao");

			while ((linha = br.readLine()) != null) {

				// public Livro(int codigo, String autor, String titulo, String issn, char tipo,
				// String editora, int dataPublicacao) {

				String[] funcionario = linha.split(csvDivisor);
				String[] funcionario2 = linha.split(csvDivisorL);

				String funcMatriz[][] = new String[funcionario.length][funcionario2.length];

				for (int i = 0; i < funcionario.length; i++) {

					for (int j = 0; j < funcionario2.length; j++) {

						funcMatriz[i][j] = funcionario2[j];
						System.out.printf("%-12s", funcMatriz[i][j]);
					}
					System.out.println();

				}

			}
			System.out.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void lerEmprestimo(String nome) {

		String arquivoCSV = "planilhas\\" + nome + ".csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = " ";
		String csvDivisorL = ";";

		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			System.out.printf("%-12s%-12s%-12s%-12s%-12s\n", "Codigo", "Matricula Cliente", "Matricula Funcionario",
					"Data Emprestimo", "Data Devolucao");

			while ((linha = br.readLine()) != null) {

				// public Emprestimo(int codigo, int matriculaCliente, int matriculaFuncionario,
				// String dataEmprestimo,String dataDevolucao)

				String[] funcionario = linha.split(csvDivisor);
				String[] funcionario2 = linha.split(csvDivisorL);

				String funcMatriz[][] = new String[funcionario.length][funcionario2.length];

				for (int i = 0; i < funcionario.length; i++) {

					for (int j = 0; j < funcionario2.length; j++) {

						funcMatriz[i][j] = funcionario2[j];
						System.out.printf("%-12s", funcMatriz[i][j]);
					}
					System.out.println();

				}

			}
			System.out.println();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// --------------------------------------------------------------------------------------------------------------------

	public void lerDevolucao(String alunoC, String emprestimoC, int codE, int codA, int data) {

		String arquivoCSV = "planilhas\\" + alunoC + ".csv";
		String arquivo2CSV = "planilhas\\" + emprestimoC + ".csv";
		BufferedReader br = null;
		BufferedReader br2 = null;
		String linha = "";
		String linha2 = "";
		String csvDivisor = " ";
		String csvDivisorL = ";";
		String texto = "";

		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			br2 = new BufferedReader(new FileReader(arquivo2CSV));

			while ((linha = br.readLine()) != null) {

				String[] aluno = linha.split(csvDivisor);
				String[] aluno2 = linha.split(csvDivisorL);

				String alunoMatriz[][] = new String[aluno.length][aluno2.length];

				for (int i = 0; i < aluno.length; i++) {

					for (int j = 0; j < aluno2.length; j++) {

						alunoMatriz[i][j] = aluno2[j];
					}

				}

				for (int i = 0; i < aluno.length; i++) {

					if (alunoMatriz[i][0].equals(Integer.toString(codA))) {

						alunoMatriz[i][5] = Double.toString(0.5 * data);
					}
				}

			}
			System.out.println();


			while ((linha2 = br2.readLine()) != null) {

				String[] emprestimo = linha2.split(csvDivisor);
				String[] emprestimo2 = linha2.split(csvDivisorL);
				String[][] empresMatriz = new String[emprestimo.length][emprestimo2.length];

				// preencher matriz
				for (int i = 0; i < emprestimo.length; i++) {

					for (int j = 0; j < emprestimo2.length; j++) {

						empresMatriz[i][j] = emprestimo2[j];
					}
				}

				// mudar para devolvido
				for (int i = 0; i < emprestimo.length; i++) {

					if (empresMatriz[i][0].equals(Integer.toString(codE))) {

						empresMatriz[i][5] = "devolvido ";
					}
				} // fim do for

				// colocar ; de volta
				for (int i = 0; i < emprestimo.length; i++) {

					for (int j = 0; j < emprestimo2.length; j++) {

						if (j == 0) {
							texto = texto + emprestimo2[j];
						} else {
							if (j > 0 && j < (emprestimo2.length)) {

								texto = texto + ";" + empresMatriz[i][j];

							}
						}
					} // fim do for J
										
				} // fim do for i

				System.out.println(texto);

				for (int i = 0; i < empresMatriz.length; i++) {
					for (int j = 0; j < empresMatriz[0].length; j++) {
						System.out.print(empresMatriz[i][j]);
					}
					System.out.println();
				}

				// escreve no txt


			} // fim do while
			
			escreveTeste("emprestimo",texto);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
