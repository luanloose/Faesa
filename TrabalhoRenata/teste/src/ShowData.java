
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("unused")
public class ShowData implements ListSelectionListener, ActionListener, WindowListener{

	private JFrame frmNavegaoProduto;
	private JTable table;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JLabel l1;
	private JLabel l0;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JTextField tf0;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JScrollPane scrollPane;
	//private TableModel tableModel;
	
	@SuppressWarnings("unused")
	private int linhaSel;
	private JButton btnFBW;
	private JButton btnSBW;
	private JButton btnSFW;
	private JButton btnFFW;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowData window = new ShowData();
					window.frmNavegaoProduto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowData() {
		initialize();
	}

	private void initialize() {
		frmNavegaoProduto = new JFrame();
		frmNavegaoProduto.setTitle("Navega\u00E7\u00E3o - Produto");
		frmNavegaoProduto.setSize(new Dimension(450, 470));
		frmNavegaoProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNavegaoProduto.setLocationRelativeTo(null);
		frmNavegaoProduto.addWindowListener(this);

		mainPanel = new JPanel();
		frmNavegaoProduto.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		// config. campos texto
		topPanel = new JPanel();
		topPanel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		topPanel.setBorder(new TitledBorder(null, "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		topPanel.setBounds(0, 0, 434, 170);
		mainPanel.add(topPanel);
		GridBagLayout gbl_topPanel = new GridBagLayout();
		gbl_topPanel.columnWidths = new int[] {95, 280};
		gbl_topPanel.rowHeights = new int[] {23, 23, 23, 23, 23};
		gbl_topPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_topPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		topPanel.setLayout(gbl_topPanel);
		
		l0 = new JLabel("Bobina:");
		GridBagConstraints gbc_l0 = new GridBagConstraints();
		gbc_l0.fill = GridBagConstraints.BOTH;
		gbc_l0.insets = new Insets(0, 0, 5, 5);
		gbc_l0.gridx = 0;
		gbc_l0.gridy = 0;
		topPanel.add(l0, gbc_l0);
		
		tf0 = new JTextField();
		GridBagConstraints gbc_tf0 = new GridBagConstraints();
		gbc_tf0.anchor = GridBagConstraints.NORTH;
		gbc_tf0.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf0.insets = new Insets(0, 0, 5, 0);
		gbc_tf0.gridx = 1;
		gbc_tf0.gridy = 0;
		topPanel.add(tf0, gbc_tf0);
		tf0.setColumns(10);
		l1 = new JLabel("Cliente:");
		GridBagConstraints gbc_l1 = new GridBagConstraints();
		gbc_l1.fill = GridBagConstraints.BOTH;
		gbc_l1.insets = new Insets(0, 0, 5, 5);
		gbc_l1.gridx = 0;
		gbc_l1.gridy = 1;
		topPanel.add(l1, gbc_l1);
		
		tf1 = new JTextField();
		GridBagConstraints gbc_tf1 = new GridBagConstraints();
		gbc_tf1.anchor = GridBagConstraints.NORTH;
		gbc_tf1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf1.insets = new Insets(0, 0, 5, 0);
		gbc_tf1.gridx = 1;
		gbc_tf1.gridy = 1;
		topPanel.add(tf1, gbc_tf1);
		tf1.setColumns(10);
		l2 = new JLabel("Thickness:");
		GridBagConstraints gbc_l2 = new GridBagConstraints();
		gbc_l2.fill = GridBagConstraints.BOTH;
		gbc_l2.insets = new Insets(0, 0, 5, 5);
		gbc_l2.gridx = 0;
		gbc_l2.gridy = 2;
		topPanel.add(l2, gbc_l2);
		
		tf2 = new JTextField();
		GridBagConstraints gbc_tf2 = new GridBagConstraints();
		gbc_tf2.anchor = GridBagConstraints.NORTH;
		gbc_tf2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf2.insets = new Insets(0, 0, 5, 0);
		gbc_tf2.gridx = 1;
		gbc_tf2.gridy = 2;
		topPanel.add(tf2, gbc_tf2);
		tf2.setColumns(10);
		l3 = new JLabel("Lenght:");
		GridBagConstraints gbc_l3 = new GridBagConstraints();
		gbc_l3.fill = GridBagConstraints.BOTH;
		gbc_l3.insets = new Insets(0, 0, 5, 5);
		gbc_l3.gridx = 0;
		gbc_l3.gridy = 3;
		topPanel.add(l3, gbc_l3);
		
		tf3 = new JTextField();
		GridBagConstraints gbc_tf3 = new GridBagConstraints();
		gbc_tf3.anchor = GridBagConstraints.NORTH;
		gbc_tf3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf3.insets = new Insets(0, 0, 5, 0);
		gbc_tf3.gridx = 1;
		gbc_tf3.gridy = 3;
		topPanel.add(tf3, gbc_tf3);
		tf3.setColumns(10);
		l4 = new JLabel("Atrib:");
		GridBagConstraints gbc_l4 = new GridBagConstraints();
		gbc_l4.fill = GridBagConstraints.BOTH;
		gbc_l4.insets = new Insets(0, 0, 0, 5);
		gbc_l4.gridx = 0;
		gbc_l4.gridy = 4;
		topPanel.add(l4, gbc_l4);
		
		tf4 = new JTextField();
		GridBagConstraints gbc_tf4 = new GridBagConstraints();
		gbc_tf4.fill = GridBagConstraints.BOTH;
		gbc_tf4.gridx = 1;
		gbc_tf4.gridy = 4;
		topPanel.add(tf4, gbc_tf4);
		tf4.setColumns(10);

		// config. bot�es
		JPanel middlePanel = new JPanel();
		middlePanel.setBounds(0, 171, 434, 40);
		mainPanel.add(middlePanel);
		
		btnFBW = new JButton("<<");
		btnFBW.addActionListener(this);
		middlePanel.add(btnFBW);
		
		btnSBW = new JButton("<");
		btnSBW.addActionListener(this);
		middlePanel.add(btnSBW);
		
		btnSFW = new JButton(">");
		btnSFW.addActionListener(this);
		middlePanel.add(btnSFW);
		
		btnFFW = new JButton(">>");
		btnFFW.addActionListener(this);
		middlePanel.add(btnFFW);

		// config tabela
//		tableModel = new TableModel();
//		table = new JTable(tableModel);
//		table.setFillsViewportHeight(true);
//		table.getSelectionModel().addListSelectionListener(this);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 211, 434, 220);
		mainPanel.add(scrollPane);
		scrollPane.setViewportView(table);
//		configTableColumns();
	}

	@SuppressWarnings("unused")
	private void configTableColumns(){
		//		// BOBINA
		//		DefaultTableCellRenderer cr_0 = new DefaultTableCellRenderer();
		//		cr_0.setHorizontalAlignment(JLabel.CENTER);
		//		table.getColumnModel().getColumn(0).setCellRenderer(cr_0);
		//		
		//		// CLIENTE
		//		DefaultTableCellRenderer cr_1 = new DefaultTableCellRenderer();
		//		cr_1.setHorizontalAlignment(JLabel.CENTER);
		//		table.getColumnModel().getColumn(1).setCellRenderer(cr_1);
		//		
		//		// THICKNESS
		//		DefaultTableCellRenderer cr_2 = new DefaultTableCellRenderer();
		//		cr_2.setHorizontalAlignment(JLabel.RIGHT);
		//		table.getColumnModel().getColumn(2).setCellRenderer(cr_2);
		//		
		//		// LENGHT
		//		DefaultTableCellRenderer cr_3 = new DefaultTableCellRenderer();
		//		cr_3.setHorizontalAlignment(JLabel.RIGHT);
		//		table.getColumnModel().getColumn(3).setCellRenderer(cr_3);
		//		
		//		// ATRIB
		//		DefaultTableCellRenderer cr_4 = new DefaultTableCellRenderer();
		//		cr_4.setHorizontalAlignment(JLabel.CENTER);
		//		table.getColumnModel().getColumn(4).setCellRenderer(cr_4);

		// centralizar tudo
//		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
//		cr.setHorizontalAlignment(JLabel.CENTER);
//		table.setDefaultRenderer(String.class, cr);
	}

	@Override
	public void valueChanged(ListSelectionEvent g0) {
//		// l� valores da linha selecionada
//		String [] rData = (String[]) tableModel.getRowData(table.getSelectedRow());
//		System.out.println("\nvalueChanged(): "+rData[0]+", "+rData[1]+", "+rData[2]+", "+rData[3]+", "+rData[4]);
//		// preenche formul�rio com valores da linha selecionada
//		tf0.setText(rData[0]);
//		tf1.setText(rData[1]);
//		tf2.setText(rData[2]);
//		tf3.setText(rData[3]);
//		tf4.setText(rData[4]);
//		// habilita/desabilita navega��o
//		linhaSel = table.getSelectedRow();
//		habilitaNavegacao();
//		System.out.println("valueChanged(), selectedRow: "+ linhaSel+" habilitou navega��o");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == btnFFW){
//			linhaSel = table.getRowCount()-1;
//			table.requestFocus();
//			table.changeSelection(linhaSel, 0, false, false);
//		}
//		if (e.getSource() == btnSFW){
//			linhaSel++;
//			table.requestFocus();
//			table.changeSelection(linhaSel, 0, false, false);
//		}
//		if (e.getSource() == btnSBW){
//			linhaSel--;
//			table.requestFocus();
//			table.changeSelection(linhaSel, 0, false, false);
//		}
//		if (e.getSource() == btnFBW){
//			linhaSel = 0;
//			table.requestFocus();
//			table.changeSelection(linhaSel, 0, false, false);
//		}
	}
	// carrega o formul�rio com os valores da primeira linha da tabela
	@Override
	public void windowActivated(WindowEvent arg0) {
//		// obtem a primeira linha da tabela
//		String [] rData = (String[]) tableModel.getRowData(0);
//		System.out.println("\nwindowActivated(): "+rData[0]+", "+rData[1]+", "+rData[2]+", "+rData[3]+", "+rData[4]);
//		// carrega os campos do formul�rio
//		tf0.setText(rData[0]);
//		tf1.setText(rData[1]);
//		tf2.setText(rData[2]);
//		tf3.setText(rData[3]);
//		tf4.setText(rData[4]);
//		// seleciona a primeira linha da tabela
//		linhaSel = 0;
//		table.setRowSelectionInterval(0, 0);
//		// posiciona o foco na primeira c�lula da tabela
//		table.requestFocus();
//		table.changeSelection(linhaSel, 0, false, false);
//		// habilita navega��o
//		habilitaNavegacao();
//		System.out.println("windowActivated(): habilitou navega��o:)");
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
	
	@SuppressWarnings("unused")
	private void habilitaNavegacao(){
//		System.out.println("habilitaNavegacao(): linhaSel: "+linhaSel+ " table.getRowCount(): "+table.getRowCount());	
//		if (linhaSel == 0){
//			System.out.println("INI--->linhaSel: "+linhaSel);
//			btnSBW.setEnabled(false);
//			btnFBW.setEnabled(false);
//			btnSFW.setEnabled(true);
//			btnFFW.setEnabled(true);
//		}else if(linhaSel == table.getRowCount()-1){
//			System.out.println("FIM--->linhaSel: "+linhaSel);
//			btnSBW.setEnabled(true);
//			btnFBW.setEnabled(true);
//			btnSFW.setEnabled(false);
//			btnFFW.setEnabled(false);
//		}
//		else{
//			System.out.println("MEIO--->linhaSel: "+linhaSel);
//			btnSBW.setEnabled(true);
//			btnFBW.setEnabled(true);
//			btnSFW.setEnabled(true);
//			btnFFW.setEnabled(true);
//		}		
	}
}
