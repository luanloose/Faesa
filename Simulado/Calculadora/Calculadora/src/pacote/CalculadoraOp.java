package pacote;

import javax.management.RuntimeErrorException;

public class CalculadoraOp {
	private static StringBuffer operando = new StringBuffer();
	private static StringBuffer expressao = new StringBuffer();
	private static String operacao;
	private static String digito;
	private static String resultado;
	private static String erro = "";

	private static void coletaOperando() {
		operando.append(digito);
		expressao.append(digito);
	}

	public static void coletaOperando(String digito) {
		setDigito(digito);
		CalculadoraOp.coletaOperando();
	}

	private static void montaExpressao() {
		expressao.append(operacao);
		operando = new StringBuffer("");
	}

	public static void montaExpressao(String digito) {
		setOperacao(digito);
		CalculadoraOp.montaExpressao();
	}

	public static void apagaTudo() {
		setOperacao(null);
		setDigito(null);
		operando = new StringBuffer("");
		expressao = new StringBuffer("");
	}

	public static void ObterSomas() {
		setErro("");
		String expr = expressao.toString()
				.replaceAll("\\+-", "-")
				.replaceAll("-\\+", "-")
				.replaceAll("\\+\\+", "+")
				.replaceAll("--", "+");
		String[] termos = expr.split("\\+");
		double[] somando = new double[termos.length];

		for (int i = 0; i < somando.length; i++) {
			try {
				double d = Double.parseDouble(termos[i]);
				somando[i] = d;
			} catch (Exception e) {
				somando[i] = ObterSubtracao(termos[i]);
			}
		}
		double soma = 0;
		for (double d : somando) {
			soma += d;
		}
		resultado = "" + soma;
		apagaTudo();
		montaExpressao(resultado);
	}

	public static double ObterSubtracao(String expressaoTexto) {
		boolean resto = expressaoTexto.startsWith("-");
		if (resto) {
			expressaoTexto = expressaoTexto.substring(1);
		}
		String[] termos = expressaoTexto.split("-");
		double[] op = new double[termos.length];
		for (int i = 0; i < op.length; i++) {
			try {
				double d = Double.parseDouble(termos[i]);
				op[i] = d;
			} catch (Exception e) {
				op[i] = ObterMultiplicacoes(termos[i]);
			}
		}
		double resultado = 0;
		for (double d : op) {
			if (resto) {
				resultado -= d;
			} else {
				resultado += d;
				resto = true;
			}
		}
		return resultado;
	}

	public static double ObterMultiplicacoes(String expressaoTexto) {
		String[] termos = expressaoTexto.split("x");
		double[] fatores = new double[termos.length];
		for (int i = 0; i < fatores.length; i++) {
			try {
				double d = Double.parseDouble(termos[i]);
				fatores[i] = d;
			} catch (Exception e) {
				fatores[i] = ObterDivisoes(termos[i]);
			}
		}
		double produto = 1;
		for (double d : fatores) {
			produto *= d;
		}
		return produto;
	}

	public static double ObterDivisoes(String expressaoTexto) {
		String[] termos = expressaoTexto.split("/");
		double[] op = new double[termos.length];
		for (int i = 0; i < op.length; i++) {
			try {
				double d = Double.parseDouble(termos[i]);
				op[i] = d;
			} catch (Exception e) {
				System.out.println("Erro em: " + termos[i]);
				e.printStackTrace();
				throw new RuntimeException("Ocorreu um erro");
			}
		}
		double resultado = 0;
		boolean dividir = false;
		for (double d : op) {
			if (dividir) {
				if (d == 0) {
					try {
						Integer.parseInt(expressao.substring(expressao.indexOf(operacao) + 1, expressao.length()));
					} catch (NumberFormatException nfe) {
						erro = "infinity";
						System.out.println("infinity");
						return 0;
					}
					erro = "Erro de divis�o por 0";
					System.out.println("Erro de divis�o por 0");
					return 0;
				}
				resultado /= d;
			} else {
				resultado = d;
				dividir = true;
			}
		}
		return resultado;
	}

	

	public static void potencia() {
		setErro("");
		Double v1 = Double.valueOf(expressao.substring(0, expressao.indexOf(operacao)));
		Double v2 = Double.valueOf(expressao.substring(expressao.indexOf(operacao) + 1, expressao.length()));

		double result = Math.pow(v1, v2);
		resultado = "" + result;
		
		apagaTudo();
		montaExpressao(resultado);
	}

	public static void log() {
		setErro("");
		Double v1 = Double.valueOf(expressao.substring(0, expressao.indexOf(operacao)));
		Double v2 = Double.valueOf(expressao.substring(expressao.indexOf(operacao) + 1, expressao.length()));

		double result = Math.log(v1) / Math.log(v2);
		resultado = "" + result;
		apagaTudo();
		montaExpressao(resultado);
	}

	public static void raiz() {
		setErro("");
		Double v1 = Double.valueOf(expressao.substring(0, expressao.indexOf(operacao)));
		Double v2 = Double.valueOf(expressao.substring(expressao.indexOf(operacao) + 1, expressao.length()));

		if (v1 <= 0) {
			resultado = "Erro: radical negativo";
			return;
		}
		if (v2 == 0) {
			resultado = "Erro: radicando nulo";
			return;
		}
		double result = Math.pow(v1, 1 / v2);
		resultado = "" + result;
		apagaTudo();
		montaExpressao(resultado);
	}

	public static void efetuaCalculo() {
		Double v1 = Double.valueOf(expressao.substring(0, expressao.indexOf(operacao)));
		Double v2 = Double.valueOf(expressao.substring(expressao.indexOf(operacao) + 1, expressao.length()));
		double result = 0;
		switch (operacao) {
		case "+":
			result = v1 + v2;
			resultado = "" + result;
			break;
		case "-":
			result = v1 - v2;
			resultado = "" + result;
			break;
		case "x":
			result = v1 * v2;
			resultado = "" + result;
			break;
		case "/":

			if (v2 == 0) {
				try {
					Integer.parseInt(expressao.substring(expressao.indexOf(operacao) + 1, expressao.length()));
				} catch (NumberFormatException nfe) {
					resultado = "infinity";
					break;
				}
				resultado = "Erro de divis�o por 0";
				break;
			}

			result = v1 / v2;
			resultado = "" + result;
			break;
		case "L":
			result = Math.log(v1) / Math.log(v2);
			resultado = "" + result;
			break;
		case "^":
			result = Math.pow(v1, v2);
			resultado = "" + result;
			break;
		case "R":
			if (v1 <= 0) {
				resultado = "Erro: radical negativo";
				break;
			}
			if (v2 == 0) {
				resultado = "Erro: radicando nulo";
				break;
			}
			result = Math.pow(v1, 1 / v2);
			resultado = "" + result;
			break;
		default:
			break;
		}
		expressao = new StringBuffer("");
		operando = new StringBuffer(String.valueOf(resultado));
		expressao.append(operando);
		// apagaTudo();
	}

	public static StringBuffer getOperando() {
		return operando;
	}

	public static void setOperando(StringBuffer operando) {
		CalculadoraOp.operando = operando;
	}

	public static StringBuffer getExpressao() {
		return expressao;
	}

	public static void setExpressao(StringBuffer expressao) {
		CalculadoraOp.expressao = expressao;
	}

	public static String getOperacao() {
		return operacao;
	}

	public static void setOperacao(String operacao) {
		CalculadoraOp.operacao = operacao;
	}

	public static String getDigito() {
		return digito;
	}

	public static void setDigito(String digito) {
		CalculadoraOp.digito = digito;
	}

	public static String getResultado() {
		return resultado;
	}

	public static void setResultado(String resultado) {
		CalculadoraOp.resultado = resultado;
	}

	public static String getErro() {
		return erro;
	}

	public static void setErro(String erro) {
		CalculadoraOp.erro = erro;
	}

}
