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
import logical.Jugadores;
import logical.LigaBeisbol;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EquipoCaracteristicas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	static Object[] fila;
	private static DefaultTableModel tablemodel;
	private static JTable table_1;
	static Object[] fila2;
	private static DefaultTableModel tablemodel2;

	/**
	 * Create the dialog.
	 */
	public EquipoCaracteristicas() {
		Equipos aux = LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo);
		setTitle("Equipo - " + aux.getNombre());
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 1012, 640);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JLabel lblEquipo = new JLabel(aux.getNombre());
		lblEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblEquipo.setBounds(12, 11, 245, 47);
		contentPanel.add(lblEquipo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 66, 984, 2);
		contentPanel.add(separator);
		
		JPanel panel_jugadores = new JPanel();
		panel_jugadores.setBounds(531, 79, 465, 233);
		contentPanel.add(panel_jugadores);
		panel_jugadores.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 465, 233);
		panel_jugadores.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		String[] columnsheaders = {"Jugadores activos"};
		tablemodel = new DefaultTableModel();
		tablemodel.setColumnIdentifiers(columnsheaders);
		table.setModel(tablemodel);
		
		JPanel panel_jugadores_lesionados = new JPanel();
		panel_jugadores_lesionados.setLayout(null);
		panel_jugadores_lesionados.setBounds(531, 321, 465, 246);
		contentPanel.add(panel_jugadores_lesionados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 465, 246);
		panel_jugadores_lesionados.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		String[] columnsheaders2 = {"Jugadores lesionados"};
		tablemodel2 = new DefaultTableModel();
		tablemodel2.setColumnIdentifiers(columnsheaders2);
		table_1.setModel(tablemodel2);
		
		JPanel tab = new JPanel();
		tab.setBounds(22, 79, 499, 488);
		contentPanel.add(tab);
		tab.setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		tabbedPane.setBounds(0, 0, 499, 488);
		tab.add(tabbedPane);
		JPanel panel_1=new JPanel();
		
		JLabel et_p1=new JLabel("Estas en el panel 1");
		panel_1.add(et_p1);
		tabbedPane.addTab("Promedio", panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Estadisticas", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Calendario", null, panel_3, null);
		
		JButton btnProximosJuegos = new JButton("Proximos juegos");
		btnProximosJuegos.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnProximosJuegos.setBounds(829, 26, 167, 32);
		contentPanel.add(btnProximosJuegos);
		
		JButton btnFormarEquipo = new JButton("Formar Equipo");
		btnFormarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PosicionCampo pc = new PosicionCampo();
				pc.setVisible(true);
			}
		});
		btnFormarEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnFormarEquipo.setBounds(652, 26, 167, 32);
		contentPanel.add(btnFormarEquipo);
		
		JButton btnAgregarJugador = new JButton("Agregar Jugador");
		btnAgregarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarJugador regjug = new RegistrarJugador(aux);
				regjug.setVisible(true);
			}
		});
		btnAgregarJugador.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnAgregarJugador.setBounds(475, 26, 167, 32);
		contentPanel.add(btnAgregarJugador);
		
		JButton btnJugadorLesionado = new JButton("Jugador Lesionado");
		btnJugadorLesionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lesiones lesion = new Lesiones(aux);
				lesion.setVisible(true);
			}
		});
		btnJugadorLesionado.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnJugadorLesionado.setBounds(282, 26, 190, 32);
		contentPanel.add(btnJugadorLesionado);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarJugadoresPorEquipo();
		cargarJugadoresLesionadoPorEquipo();
	}
	public static void cargarJugadoresPorEquipo(){
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Jugadores e : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
			if(!e.isLesion()){
				fila[0] = e.getNombre();
				tablemodel.addRow(fila);
			}
		}
	}
	public static void cargarJugadoresLesionadoPorEquipo(){
		tablemodel2.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_1.getColumnModel().getColumn(0).setCellRenderer(tcr);
		fila2 = new Object[tablemodel2.getColumnCount()];
		for (Jugadores e : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
			if(e.isLesion()==true){
				fila2[0] = e.getNombre();
				tablemodel2.addRow(fila2);
			}
		}
	}
}
