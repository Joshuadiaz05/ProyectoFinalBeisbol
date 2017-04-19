package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logical.Equipos;
import logical.LigaBeisbol;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TablaPosiciones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static JTable table_1;
	private static JTable table_2;
	private static JTable table_3;
	static Object[] fila;
	static Object[] fila2;
	static Object[] fila3;
	static Object[] fila4;
	private static DefaultTableModel tablemodel;
	private static DefaultTableModel tablemodel2;
	private static DefaultTableModel tablemodel3;
	private static DefaultTableModel tablemodel4;
	public static Equipos inde;
	public static String nombreEquipo = "";

	/**
	 * Create the dialog.
	 */
	public TablaPosiciones() {
		setTitle("Tabla de posiciones");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 929, 652);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Listado de Equipos");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 11, 245, 47);
		contentPanel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 904, 2);
		contentPanel.add(separator);
		
		JPanel norte = new JPanel();
		norte.setBounds(10, 94, 447, 217);
		contentPanel.add(norte);
		norte.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 447, 217);
		norte.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				nombreEquipo = (String) table.getModel().getValueAt(index, 0);
				inde = LigaBeisbol.getInstance().BuscarPorNombre(nombreEquipo);
				EquipoCaracteristicas ve = new EquipoCaracteristicas();
				ve.setVisible(true);
			}
		});

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		String[] columnsheaders = {"Equipo", "G", "P", "PCT"};
		tablemodel = new DefaultTableModel();
		tablemodel.setColumnIdentifiers(columnsheaders);
		table.setModel(tablemodel);
		
		JLabel lblDivisinEste = new JLabel("Divisi\u00F3n Norte");
		lblDivisinEste.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDivisinEste.setBounds(171, 69, 125, 19);
		contentPanel.add(lblDivisinEste);
		
		JPanel sur = new JPanel();
		sur.setBounds(467, 94, 447, 217);
		contentPanel.add(sur);
		sur.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 447, 217);
		sur.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				nombreEquipo = (String) table_1.getModel().getValueAt(index, 0);
				inde = LigaBeisbol.getInstance().BuscarPorNombre(nombreEquipo);
				EquipoCaracteristicas ve = new EquipoCaracteristicas();
				ve.setVisible(true);
			}
		});
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_1);
		String[] columnsheaders2 = {"Equipo", "G", "P", "PCT"};
		tablemodel2 = new DefaultTableModel();
		tablemodel2.setColumnIdentifiers(columnsheaders2);
		table_1.setModel(tablemodel2);
		
		JLabel lblDivisinSur = new JLabel("Divisi\u00F3n Sur");
		lblDivisinSur.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDivisinSur.setBounds(644, 69, 93, 19);
		contentPanel.add(lblDivisinSur);
		
		JPanel oeste = new JPanel();
		oeste.setLayout(null);
		oeste.setBounds(10, 351, 447, 217);
		contentPanel.add(oeste);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 447, 217);
		oeste.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_2.getSelectedRow();
				nombreEquipo = (String) table_2.getModel().getValueAt(index, 0);
				inde = LigaBeisbol.getInstance().BuscarPorNombre(nombreEquipo);
				EquipoCaracteristicas ve = new EquipoCaracteristicas();
				ve.setVisible(true);
			}
		});
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(table_2);
		String[] columnsheaders3 = {"Equipo", "G", "P", "PCT"};
		tablemodel3 = new DefaultTableModel();
		tablemodel3.setColumnIdentifiers(columnsheaders3);
		table_2.setModel(tablemodel3);
			
		JPanel este = new JPanel();
		este.setLayout(null);
		este.setBounds(467, 351, 447, 217);
		contentPanel.add(este);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 447, 217);
		este.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(table_3);
		String[] columnsheaders4 = {"Equipo", "G", "P", "PCT"};
		tablemodel4 = new DefaultTableModel();
		tablemodel4.setColumnIdentifiers(columnsheaders4);
		table_3.setModel(tablemodel4);
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_3.getSelectedRow();
				nombreEquipo = (String) table_3.getModel().getValueAt(index, 0);
				inde = LigaBeisbol.getInstance().BuscarPorNombre(nombreEquipo);
				EquipoCaracteristicas ve = new EquipoCaracteristicas();
				ve.setVisible(true);
			}
		});
		
		JLabel lblDivisinOeste = new JLabel("Divisi\u00F3n Oeste");
		lblDivisinOeste.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDivisinOeste.setBounds(171, 322, 125, 19);
		contentPanel.add(lblDivisinOeste);
		
		JLabel lblDivisinEste_1 = new JLabel("Divisi\u00F3n Este");
		lblDivisinEste_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDivisinEste_1.setBounds(628, 326, 125, 19);
		contentPanel.add(lblDivisinEste_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarPosicionNorte();
		cargarPosicionSur();
		cargarPosicionOeste();
		cargarPosicionEste();
	}
	static void cargarPosicionNorte(){
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		fila = new Object[tablemodel.getColumnCount()];
		for (Equipos team : LigaBeisbol.getInstance().getEquipo()) {
			if(team.getRegion().equalsIgnoreCase("Norte")){
				fila[0] = team.getNombre();
				fila[1] = team.getJg();
				fila[2] = team.getJp();
				NumberFormat formatter = new DecimalFormat(".000###%");
				double ptc = 0;
				try {
					ptc = team.getJg()/team.getJj();
				} catch (ArithmeticException e) {
					
				}
				fila[3] = formatter.format(ptc/1000);
				tablemodel.addRow(fila);
			}
		}
	}
	static void cargarPosicionSur(){
		tablemodel2.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_1.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table_1.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table_1.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table_1.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(250);
		fila2 = new Object[tablemodel2.getColumnCount()];
		for (Equipos team : LigaBeisbol.getInstance().getEquipo()) {
			if(team.getRegion().equalsIgnoreCase("Sur")){
				fila2[0] = team.getNombre();
				fila2[1] = team.getJg();
				fila2[2] = team.getJp();
				NumberFormat formatter = new DecimalFormat(".000###%");
				double ptc = 0;
				System.out.println(team.getJg() + " " + team.getJj());
				try {
					ptc = team.getJg()/team.getJj();
				} catch (ArithmeticException e) {
					
				}
				fila2[3] = formatter.format(ptc/100);
				tablemodel2.addRow(fila2);
			}
		}
	}
	static void cargarPosicionOeste(){
		tablemodel3.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_2.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table_2.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table_2.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table_2.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(250);
		fila3 = new Object[tablemodel3.getColumnCount()];
		for (Equipos team : LigaBeisbol.getInstance().getEquipo()) {
			if(team.getRegion().equalsIgnoreCase("Oeste")){
				fila3[0] = team.getNombre();
				fila3[1] = team.getJg();
				fila3[2] = team.getJp();
				NumberFormat formatter = new DecimalFormat(".000###%");
				double ptc = 0;
				try {
					ptc = team.getJg()/team.getJg()+team.getJp();
				} catch (ArithmeticException e) {
					
				}
				fila3[3] = formatter.format(ptc/100);
				tablemodel3.addRow(fila3);
			}
		}
	}
	static void cargarPosicionEste(){
		tablemodel4.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_3.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table_3.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table_3.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table_3.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table_3.getColumnModel().getColumn(0).setPreferredWidth(250);
		fila4 = new Object[tablemodel4.getColumnCount()];
		for (Equipos team : LigaBeisbol.getInstance().getEquipo()) {
			if(team.getRegion().equalsIgnoreCase("Este")){
				fila4[0] = team.getNombre();
				fila4[1] = team.getJg();
				fila4[2] = team.getJp();
				NumberFormat formatter = new DecimalFormat(".000###%");
				double ptc = 0;
				try {
					ptc = team.getJg()/team.getJg()+team.getJp();
				} catch (ArithmeticException e) {
					
				}
				fila4[3] = formatter.format(ptc/100);
				tablemodel4.addRow(fila4);
			}
		}
	}
}
