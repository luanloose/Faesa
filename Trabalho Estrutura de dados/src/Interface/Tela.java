package Interface;

import Dados.Item;

public class Tela {

	//Tela inicial
	public static void TelaInicio() {
		Metodo.LimpaTela();
		System.out.print(
				"JBL SYSTEM - GESTAO DE CONDOMINIO" +
				"\n=================================\n"+
				"\n1. INSERIR APARTAMENTO" +
				"\n2. ALTERAR APARTAMENTO" +
				"\n3. REMOVER APARTAMENTO" +
				"\n4. PESQUISAR" +
				"\n5. SOBRE" +
				"\n6. SAIR" +
				"\n\n> "
				);
		
	}//TelaInicio
	
	
	//Tela remover apartamento
	public static void TelaRemover() {
		Metodo.LimpaTela();
		System.out.print(
				"JBL SYSTEM - GESTAO DE CONDOMINIO" +
				"\n=================================\n"+
				"\n\n\n\n" +
				"\nCODIGO DO APARTAMENTO: "
				);
		
	}
	
	
	//Tela inserir
	public static void TelaInserir() {
		Metodo.LimpaTela();
		System.out.print("JBL SYSTEM - CADASTRAR APARTAMENTO\n==================================\n");
		System.out.println("\n\n\n\n");
	}
	
	
	//Tela alterar
	public static void TelaAlterar() {
		Metodo.LimpaTela();
		System.out.print("JBL SYSTEM - ALTERAR APARTAMENTO\n==================================\n");
		System.out.println("\n\n");
	}

	
	//Cabe�alho tabela
	public static void TelaTabelaCabecalho() {

		System.out.println(
				Metodo.padLeft("CODIGO", 7) +
				Metodo.padLeft("M2", 7) +
				Metodo.padLeft("VAGAS CARRO", 13) +
				Metodo.padLeft("NUM. QUARTOS", 14) +
				Metodo.padLeft("CPF", 13) +
				Metodo.padLeft("NOME", 40) +
				Metodo.padLeft("TELEFONE", 14) +
				Metodo.padLeft("E-MAIL", 35)
				);
		
		System.out.println(
				Metodo.padLeft("------", 7) +
				Metodo.padLeft("--", 7) +
				Metodo.padLeft("-----------", 13) +
				Metodo.padLeft("-----------", 14) +
				Metodo.padLeft("---", 13) +
				Metodo.padLeft("----", 40) +
				Metodo.padLeft("--------", 14) +
				Metodo.padLeft("------", 35)
				);

	}
	
	
	//Tela mostrar tudo
	public static void TelaPesquisar() {
		Metodo.LimpaTela();
		System.out.print(
				"JBL SYSTEM - PESQUISAR" +
				"\n=================================\n\n"+
				"\n1. MOSTRAR TUDO" +
				"\n2. CONSULTAR CPF" +
				"\n3. CONSULTAR BLOCO" +
				"\n4. CONSULTAR APARTAMENTO" +
				"\n5. VOLTAR" +
				"\n\n\n> "
				);
	}	
	
	
	//Tela mostrar tudo
	public static void TelaMostrarTudo() {
		Metodo.LimpaTela();
		System.out.print("JBL SYSTEM - MOSTRAR TUDO\n=========================\n\n\n");

	}
	
	
	//Tela consultar CPF
	public static void TelaConsultarCPF() {
		Metodo.LimpaTela();
		System.out.print("JBL SYSTEM - CONSULTAR CPF\n==================================\n");
		System.out.print("\n\nCPF: ");
	}
	
	
	//Tela consultar bloco
	public static void TelaConsultaBloco() {
		Metodo.LimpaTela();
		System.out.print("JBL SYSTEM - CONSULTAR BLOCO\n==================================\n");
		System.out.print("\n\n\n\nBLOCO(1-9): ");
	}
	
	
	//Tela consultar Apto - busca
	public static void TelaConsultaApartBusca() {
		Metodo.LimpaTela();
		System.out.print("JBL SYSTEM - CONSULTAR APARTAMENTO\n==================================\n");
		System.out.print("\n\n\n\nCODIGO. DO APARTAMENTO(101-999): ");
	}
	
	
	//Tela consultar Apto - resultado
	public static void TelaConsultaApart(Item Apto) {
		Metodo.LimpaTela();
		System.out.print(
				"JBL SYSTEM - CONSULTAR APARTAMENTO\n==================================\n" +
				"\n   APARTAMENTO" +
				"\n       Num. Apto.:  " + Apto.getChave().getCodigo() +
				"\n       M2:          " + Apto.getChave().getM2() +
				"\n       Num. Vagas:  " + Apto.getChave().getVagasCarro() +
				"\n       Quartos:     " + Apto.getChave().getNumQuartos() +
				"\n" +
				"\n   PROPRIETARIO" +
				"\n       CPF:         " + Apto.getChave().getProprietario().getCPF() +
				"\n       Nome:        " + Apto.getChave().getProprietario().getNome() +
				"\n       E-mail:      " + Apto.getChave().getProprietario().getEmail() +
				"\n       Telefone:    " + Apto.getChave().getProprietario().getTelefone()
				);
		
	}
	
	
	
	
	//Tela Sobre
	public static void TelaSobre() {
		Metodo.LimpaTela();
		System.out.print("JBL SYSTEM - GESTAO DE CONDOMINIO\n==================================\n\n\n");
		
		System.out.println("    PROFESSORES");
		System.out.println("        Daniel Barbosa de Oliveira - Matematica Discreta");
		System.out.println("        Renata Lima Laranja Leite - Estruturas de Dados");
		System.out.print("\n\n");
		
		System.out.println("    INTEGRANTES");
		System.out.println("        Luan Loose - Ciencia da Computacao");
		System.out.println("        Jordhan Honorato Felix - Ciancia da Computacao");
		System.out.println("        Bryann Henrique de O. Brandao - Sistemas de Informacao");
		System.out.print("\n\n");
		
		System.out.println("    PROPOSITO DO TRABALHO");
		System.out.println("        Aplicar os conhecimentos adquiridos nas materias de Matematica Discreta"); 
		System.out.println("        e Estruturas de Dados em uma ferramenta computacional.\n");
		System.out.println("        Esta aplicacao apresenta um sistema de gestao de apartamentos de um condominio,");
		System.out.println("        onde toda a informacao e armazenada em uma arvore binaria de busca.");
	}
	
	
	//Tela consultar CPF
	public static void TelaSair() {
		Metodo.LimpaTela();
		System.out.print("JBL SYSTEM\n==================================\n");
		System.out.print("\n\n\n\nPROGRAMA ENCERRADO");
	}

}//classe Tela






























