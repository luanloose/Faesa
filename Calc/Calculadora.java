import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Calculadora implements ActionListener, KeyListener {

	private JFrame frame;
	private JTextField textField_Display;
	private JButton btn_ExcluirTudo;
	private JButton btn_Apaga1;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_div;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_Mult;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_Menos;
	private JButton btn_Ponto;
	private JButton btn_0;
	private JButton btn_Igual;
	private JButton btn_Mais;
	private JButton btn_Radiciacao;
	private JButton btn_Potencia;
	private JButton btn_Negacao;
	private JButton btn_Logaritmo;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//					UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//					// for Mac
//					System.setProperty("apple.laf.useScreenMenuBar", "true");
//					System.setProperty("com.apple.mrj.application.apple.nemu.about.name", "Calculadora");
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Calculadora window = new Calculadora();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int R = 50;
		int G = 50;
		int B = 50;
		frame = new JFrame();
		frame.setSize(new Dimension(305, 364));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculadora");
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		// frame.setSize(297, 351);

		textField_Display = new JTextField();
		textField_Display.setBounds(0, 0, 289, 65);
		panel.add(textField_Display);
		textField_Display.setColumns(10);
		textField_Display.addKeyListener(this);
//		textField_Display.setFocusable(true);
		textField_Display.setBorder(new LineBorder(Color.gray, 0));
		textField_Display.setBackground(new Color(90, 90, 90));
		textField_Display.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		textField_Display.setForeground(Color.WHITE);
		textField_Display.setHorizontalAlignment(SwingConstants.RIGHT);

		JPanel panel_Excluir = new JPanel();
		panel_Excluir.setBounds(0, 66, 293, 51);
		panel.add(panel_Excluir);
		panel_Excluir.setBorder(new LineBorder(Color.white, 0));
		panel_Excluir.setLayout(new GridLayout(0, 2, 0, 0));

		// label = new JLabel("");
		// panel_Excluir.add(label);

		btn_ExcluirTudo = new JButton("E");
		btn_ExcluirTudo.setForeground(Color.WHITE);
		panel_Excluir.add(btn_ExcluirTudo);

		btn_Apaga1 = new JButton("\u21e6");
		btn_Apaga1.setForeground(Color.WHITE);
		panel_Excluir.add(btn_Apaga1);

		JPanel panel_Teclado = new JPanel();
		panel_Teclado.setBounds(0, 117, 293, 207);
		panel.add(panel_Teclado);
		panel_Teclado.setLayout(new GridLayout(0, 5, 0, 0));
		panel_Teclado.setBorder(new LineBorder(new Color(90, 90, 90), 1));

		btn_Radiciacao = new JButton("R");
		btn_Radiciacao.setForeground(Color.WHITE);
		panel_Teclado.add(btn_Radiciacao);

		btn_7 = new JButton("7");
		btn_7.setBackground(Color.WHITE);
		btn_7.setForeground(Color.WHITE);
		panel_Teclado.add(btn_7);

		btn_8 = new JButton("8");
		btn_8.setForeground(Color.WHITE);
		panel_Teclado.add(btn_8);

		btn_9 = new JButton("9");
		btn_9.setForeground(Color.WHITE);
		panel_Teclado.add(btn_9);

		btn_div = new JButton("/");
		btn_div.setForeground(Color.WHITE);
		panel_Teclado.add(btn_div);

		btn_Potencia = new JButton("^");
		btn_Potencia.setForeground(Color.WHITE);
		panel_Teclado.add(btn_Potencia);

		btn_4 = new JButton("4");
		btn_4.setForeground(Color.WHITE);
		panel_Teclado.add(btn_4);

		btn_5 = new JButton("5");
		btn_5.setForeground(Color.WHITE);
		panel_Teclado.add(btn_5);

		btn_6 = new JButton("6");
		btn_6.setForeground(Color.WHITE);
		panel_Teclado.add(btn_6);

		btn_Mult = new JButton("X");
		btn_Mult.setForeground(Color.WHITE);
		panel_Teclado.add(btn_Mult);

		btn_Negacao = new JButton("!");
		btn_Negacao.setForeground(Color.WHITE);
		panel_Teclado.add(btn_Negacao);

		btn_1 = new JButton("1");
		btn_1.setForeground(Color.WHITE);
		panel_Teclado.add(btn_1);

		btn_2 = new JButton("2");
		btn_2.setForeground(Color.WHITE);
		panel_Teclado.add(btn_2);

		btn_3 = new JButton("3");
		btn_3.setForeground(Color.WHITE);
		panel_Teclado.add(btn_3);

		btn_Menos = new JButton(" -");
		btn_Menos.setForeground(Color.WHITE);
		panel_Teclado.add(btn_Menos);

		btn_Logaritmo = new JButton("L");
		btn_Logaritmo.setForeground(Color.WHITE);
		panel_Teclado.add(btn_Logaritmo);

		btn_Ponto = new JButton(".");
		btn_Ponto.setForeground(Color.WHITE);
		panel_Teclado.add(btn_Ponto);

		btn_0 = new JButton("0");
		btn_0.setForeground(Color.WHITE);
		panel_Teclado.add(btn_0);

		btn_Igual = new JButton("=");
		btn_Igual.setForeground(Color.WHITE);
		panel_Teclado.add(btn_Igual);

		btn_Mais = new JButton("+");
		btn_Mais.setForeground(Color.WHITE);
		panel_Teclado.add(btn_Mais);

		for (Component c : panel_Teclado.getComponents()) {
			System.out.println(" --->>> [" + ((JButton) c).getText() + "]");
			((JButton) c).setBackground(new Color(50, 50, 50));
			((JButton) c).setBorder(new LineBorder(new Color(90, 90, 90), 1));
			((JButton) c).addActionListener(this);
			((JButton) c).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));

		}

		panel_Excluir.setBackground(new Color(90, 90, 90));
		panel_Excluir.setBorder(new LineBorder(new Color(90, 90, 90), 0));

		panel.setBackground((new Color(90, 90, 90)));
		panel.setBorder(new LineBorder(new Color(65, 65, 65), 0));
		for (Component c : panel_Excluir.getComponents()) {
			System.out.println(" --->>> [" + ((JButton) c).getText() + "]");
			((JButton) c).setBackground(new Color(65, 65, 65));
			((JButton) c).setBorder(new LineBorder(new Color(90, 90, 90), 1));
			((JButton) c).addActionListener(this);
			((JButton) c).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		}

		// btn_7.setBorder(new LineBorder(new Color(R, G, B)));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = ((JButton) e.getSource()).getText();
		switch (key) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			// concatenar os valores digitados
			CalculadoraOp.coletaOperando(key);
			/*
			 * System.out.println("-> " + key); System.out.println("-> digito:    " +
			 * CalculadoraOp.getDigito()); System.out.println("-> operando:  " +
			 * CalculadoraOp.getOperando()); System.out.println("-> expressao: " +
			 * CalculadoraOp.getExpressao()); System.out.println("-> opera��o: " +
			 * CalculadoraOp.getOperacao());
			 */
			textField_Display.setText(CalculadoraOp.getExpressao().toString());
			break;
		case "!":
			String novaExpressao;
			novaExpressao = CalculadoraOp.getExpressao().toString().replaceAll("\\+", "-").replaceAll(" -", "+");
			CalculadoraOp.apagaTudo();
			CalculadoraOp.montaExpressao(novaExpressao);
			textField_Display.setText(CalculadoraOp.getExpressao().toString());
			break;
		case "/":
		case " -":
		case "X":
		case "+":
		case "L":
		case "^":
		case "R":
			// salvar operando (numero digitado)
			// comecar outro operando
			CalculadoraOp.montaExpressao(key);
			// System.out.println("-> expressao: " + CalculadoraOp.getExpressao());
			textField_Display.setText(CalculadoraOp.getExpressao().toString());
			System.out.println("-> " + key);
			break;
		case "=":
			// realizar calculo
			if (CalculadoraOp.getOperacao().toString().equals("^")) {
				CalculadoraOp.potencia();
			} else if (CalculadoraOp.getOperacao().toString().equals("L")) {
				CalculadoraOp.log();
			} else if (CalculadoraOp.getOperacao().toString().equals("R")) {
				CalculadoraOp.raiz();
			} else {
				CalculadoraOp.ObterSomas();
			}
			if (!CalculadoraOp.getErro().isEmpty()) {
				textField_Display.setText(CalculadoraOp.getErro().toString());
			} else {
				textField_Display.setText(CalculadoraOp.getResultado().toString());
			}
			// CalculadoraOp.efetuaCalculo();
			// CalculadoraOp.apagaTudo();
			break;
		case ".":
			CalculadoraOp.coletaOperando(key);
			/*
			 * System.out.println("-> " + key); System.out.println("-> digito:    " +
			 * CalculadoraOp.getDigito()); System.out.println("-> operando:  " +
			 * CalculadoraOp.getOperando()); System.out.println("-> expressao: " +
			 * CalculadoraOp.getExpressao());
			 **/
			textField_Display.setText(CalculadoraOp.getExpressao().toString());
			break;
		case "E":
			System.out.println("limpar tudo");
			textField_Display.setText("");
			CalculadoraOp.apagaTudo();
			/*
			 * System.out.println("-> digito:    " + CalculadoraOp.getDigito());
			 * System.out.println("-> operando:  " + CalculadoraOp.getOperando());
			 * System.out.println("-> expressao: " + CalculadoraOp.getExpressao());
			 */
			break;
		case "\u21e6":
			textField_Display
					.setText(textField_Display.getText().substring(0, (textField_Display.getText().length() - 1)));
			CalculadoraOp.apagaTudo();
			CalculadoraOp.montaExpressao(textField_Display.getText());
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String key = String.valueOf(e.getKeyChar());
		switch (key) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			CalculadoraOp.coletaOperando(key);
			// textField_Display.setText(CalculadoraOp.getExpressao().toString());
			System.out.println("-> " + key);
			break;
		case "/":
		case "-":
		case "X":
		case "+":
		case "R":
		case "L":
		case "^":
			CalculadoraOp.montaExpressao(key);
			// textField_Display.setText(CalculadoraOp.getExpressao().toString());
			break;
		case "!":
			String novaExpressao;
			novaExpressao = CalculadoraOp.getExpressao().toString().replaceAll("\\+", "-").replaceAll(" -", "+");
			CalculadoraOp.apagaTudo();
			CalculadoraOp.montaExpressao(novaExpressao);
			// textField_Display.setText(CalculadoraOp.getExpressao().toString());

			break;
		case "=":
			if (CalculadoraOp.getOperacao().toString().equals("^")) {
				CalculadoraOp.potencia();
			} else if (CalculadoraOp.getOperacao().toString().equals("L")) {
				CalculadoraOp.log();
			} else if (CalculadoraOp.getOperacao().toString().equals("R")) {
				CalculadoraOp.raiz();
			} else {
				CalculadoraOp.ObterSomas();
			}
			if (!CalculadoraOp.getErro().isEmpty()) {
				textField_Display.setText(CalculadoraOp.getErro().toString());
			} else {
				textField_Display.setText(CalculadoraOp.getResultado().toString());
			}

			break;
		case ".":
			CalculadoraOp.coletaOperando(key);

			break;
		case "E":
			textField_Display.setText("");
			CalculadoraOp.apagaTudo();
			// System.out.println("Limpar Tudo");
			break;
		case "\u21e6":
			textField_Display
					.setText(textField_Display.getText().substring(0, (textField_Display.getText().length() - 1)));
			CalculadoraOp.apagaTudo();
			CalculadoraOp.montaExpressao(textField_Display.getText());
		default:
			e.consume();
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
