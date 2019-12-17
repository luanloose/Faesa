
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

public class IBGE implements WindowListener, ListSelectionListener, ActionListener{

	private JFrame     frame;
	private JTextField tfdSigla;
	private JTextField tfdCdEstado;
	private JTextField tfdCodMunic;
	private JTextField tfdNomeMunic;
	private JTextField tfdPopulacao;
	private JTable     table;
	private JButton    btnPrimeiro;
	private JButton    btnAnterior;
	private JButton    btnProximo;
	private JButton    btnUltimo;
	private TableModel tableModel;
	private int        linhaSel;
	private JScrollPane scrollPane; 
	private TableRowSorter<TableModel> sorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IBGE window = new IBGE();
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
	public IBGE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(450, 470));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(this);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Município", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		topPanel.setBounds(0, 0, 434, 170);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblSigla = new JLabel("Sigla:");
		lblSigla.setBounds(10, 20, 86, 14);
		topPanel.add(lblSigla);
		
		JLabel lblCdEstado = new JLabel("Cód. Estado:");
		lblCdEstado.setBounds(10, 50, 86, 14);
		topPanel.add(lblCdEstado);
		
		JLabel lblCdMunic = new JLabel("Cód. Munic.:");
		lblCdMunic.setBounds(10, 80, 86, 14);
		topPanel.add(lblCdMunic);
		
		JLabel lblNomeMunic = new JLabel("Município:");
		lblNomeMunic.setBounds(10, 110, 86, 14);
		topPanel.add(lblNomeMunic);
		
		JLabel lblPopulacao = new JLabel("População:");
		lblPopulacao.setBounds(10, 143, 86, 14);
		topPanel.add(lblPopulacao);
		
		tfdSigla = new JTextField();
		tfdSigla.setBounds(117, 17, 307, 20);
		topPanel.add(tfdSigla);
		tfdSigla.setColumns(10);
		
		tfdCdEstado = new JTextField();
		tfdCdEstado.setBounds(117, 47, 307, 20);
		topPanel.add(tfdCdEstado);
		tfdCdEstado.setColumns(10);
		
		tfdCodMunic = new JTextField();
		tfdCodMunic.setBounds(117, 77, 307, 20);
		topPanel.add(tfdCodMunic);
		tfdCodMunic.setColumns(10);
		
		tfdNomeMunic = new JTextField();
		tfdNomeMunic.setBounds(117, 107, 307, 20);
		topPanel.add(tfdNomeMunic);
		tfdNomeMunic.setColumns(10);
		
		tfdPopulacao = new JTextField();
		tfdPopulacao.setBounds(117, 140, 307, 20);
		topPanel.add(tfdPopulacao);
		tfdPopulacao.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(0, 171, 434, 40);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		btnPrimeiro = new JButton("<<");
		btnPrimeiro.setBounds(112, 8, 49, 23);
		btnPrimeiro.addActionListener(this);
		panel.add(btnPrimeiro);
		
		btnAnterior = new JButton("<");
		btnAnterior.setBounds(171, 8, 49, 23);
		btnAnterior.addActionListener(this);
		panel.add(btnAnterior);
		
		btnProximo = new JButton(">");
		btnProximo.setBounds(230, 8, 49, 23);
		btnProximo.addActionListener(this);
		panel.add(btnProximo);
		
		btnUltimo = new JButton(">>");
		btnUltimo.setBounds(288, 8, 49, 23);
		btnUltimo.addActionListener(this);
		panel.add(btnUltimo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 210, 434, 221);
		mainPanel.add(scrollPane);

		//tableModel = new TableModel();
		//table = new JTable(tableModel);
		//table.setFillsViewportHeight(true);
		//table.getSelectionModel().addListSelectionListener(this);
		//scrollPane.setViewportView(table);
		//configTableColumns();
		inicializaTabela();
	}
	
	private void inicializaTabela() {
		
		tableModel = new TableModel();
		
		table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		
//		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
//		sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
//		sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));		
//		sorter.setSortKeys(sortKeys);
//		sorter.sort();		
		
		sorter = new TableRowSorter<TableModel>((TableModel) table.getModel());
		
//		sorter.setComparator(3, new Comparator<Municipio>() {
//			Collator coll = Collator.getInstance(new Locale("pt", "BR"));
//			public int compare(Municipio m0, Municipio m1) {
//				int compNome = coll.compare(m0.getMunicipio(), m1.getMunicipio());
//				return compNome;
//			}
//		});
		
		sorter.setComparator(3, new Comparator<String>() {
			Collator coll = Collator.getInstance(new Locale("pt", "BR"));
			public int compare(String m0, String m1) {
				int compNome = coll.compare(m0, m1);
				return compNome;
			}
		});
		
		table.setRowSorter(sorter);
		table.setFillsViewportHeight(true);
		table.getSelectionModel().addListSelectionListener(this);
		scrollPane.setViewportView(table);
		configTableColumns();
	}
	
// ================================================ //	
	private void configTableColumns(){
		// sigla
		DefaultTableCellRenderer cr_0 = new DefaultTableCellRenderer();
		cr_0.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cr_0);
		
		// cód uf
		DefaultTableCellRenderer cr_1 = new DefaultTableCellRenderer();
		cr_1.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(1).setCellRenderer(cr_1);
		
		// cód mun
		DefaultTableCellRenderer cr_2 = new DefaultTableCellRenderer();
		cr_2.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(2).setCellRenderer(cr_2);

		// município
		DefaultTableCellRenderer cr_3 = new DefaultTableCellRenderer();
		cr_3.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(3).setCellRenderer(cr_3);
		
		// população
		DefaultTableCellRenderer cr_4 = new DefaultTableCellRenderer();
		cr_4.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(4).setCellRenderer(cr_4);

	}

	@Override
	public void valueChanged(ListSelectionEvent g0) {
		// lê valores da linha selecionada
		String [] rData = (String[]) tableModel.getRowData(table.getSelectedRow());
		
		// preenche formulário com valores da linha selecionada
		tfdSigla.setText(rData[0]);
		tfdCdEstado.setText(rData[1]);
		tfdCodMunic.setText(rData[2]);
		tfdNomeMunic.setText(rData[3]);
		tfdPopulacao.setText(rData[4]);
		
		// habilita/desabilita navegação
		linhaSel = table.getSelectedRow();
		habilitaNavegacao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUltimo){
			linhaSel = table.getRowCount()-1;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnProximo){
			linhaSel++;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnAnterior){
			linhaSel--;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
		if (e.getSource() == btnPrimeiro){
			linhaSel = 0;
			table.requestFocus();
			table.changeSelection(linhaSel, 0, false, false);
		}
	}
	
	// carrega o formulário com os valores da primeira linha da tabela
	@Override
	public void windowActivated(WindowEvent arg0) {
		// obtem a primeira linha da tabela
		String [] rData = (String[]) tableModel.getRowData(0);
		
		// carrega os campos do formulário
		tfdSigla.setText(rData[0]);
		tfdCdEstado.setText(rData[1]);
		tfdCodMunic.setText(rData[2]);
		tfdNomeMunic.setText(rData[3]);
		tfdPopulacao.setText(rData[4]);
		
		// seleciona a primeira linha da tabela
		linhaSel = 0;
		table.setRowSelectionInterval(0, 0);
		
		// posiciona o foco na primeira célula da tabela
		table.requestFocus();
		table.changeSelection(linhaSel, 0, false, false);
		
		// habilita navegação
		habilitaNavegacao();
	}

	private void habilitaNavegacao(){	
		if (linhaSel == 0){
			btnPrimeiro.setEnabled(false);
			btnAnterior.setEnabled(false);
			btnProximo.setEnabled(true);
			btnUltimo.setEnabled(true);
		}else if(linhaSel == table.getRowCount()-1){
			btnPrimeiro.setEnabled(true);
			btnAnterior.setEnabled(true);
			btnProximo.setEnabled(false);
			btnUltimo.setEnabled(false);
		}
		else{
			btnPrimeiro.setEnabled(true);
			btnAnterior.setEnabled(true);
			btnProximo.setEnabled(true);
			btnUltimo.setEnabled(true);
		}		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
