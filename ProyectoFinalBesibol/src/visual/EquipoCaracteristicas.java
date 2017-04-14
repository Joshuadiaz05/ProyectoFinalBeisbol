package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logical.Equipos;
import logical.Jugadores;
import logical.LigaBeisbol;
import logical.Partido;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
	private static String jugador;
	private static JLabel lbFoto;
	private static JTabbedPane tabbedPane;
	private static JLabel lbNombreJugador;
	private static JSeparator separator_1;
	private static JLabel lbEligeUnJugador;
	private static JLabel lbNumero;
	private static JLabel lbPos;
	private static JLabel lbZurdoODiestro;
	private static JLabel lblFechaDeNacimiento;
	private static JLabel lblFecha;
	private static JLabel lblLugarDeNacimiento;
	private static JLabel lbLugar;
	private static JLabel lblUniversidad;
	private static JLabel lbUni;
	private static JSeparator separator_2;
	private JLabel lblAgregarJugador;
	private JLabel lblFormarEquipo;
	private JLabel lblJugadorLesionado;
	private static JTable tablecalendario;
	private static DefaultTableModel tablemodelcalendario;
	static Object[] fila3;
	Equipos aux = LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo);
	private JButton button;
	/**
	 * Create the dialog.
	 */
	public EquipoCaracteristicas() {
		setTitle("Equipo - " + aux.getNombre());
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 1187, 640);
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
		separator.setBounds(12, 66, 988, 2);
		contentPanel.add(separator);
		
		JPanel panel_jugadores = new JPanel();
		panel_jugadores.setBounds(706, 79, 465, 233);
		contentPanel.add(panel_jugadores);
		panel_jugadores.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 465, 233);
		panel_jugadores.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				jugador = (String)table.getModel().getValueAt(index, 0);
				tabbedPane.setSelectedIndex(3);
				cargarJugadoresLesionadoPorEquipo();
				cargarJugador(jugador);
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
		panel_jugadores_lesionados.setBounds(706, 321, 465, 246);
		contentPanel.add(panel_jugadores_lesionados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 465, 246);
		panel_jugadores_lesionados.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				jugador = (String)table_1.getModel().getValueAt(index, 0);
				tabbedPane.setSelectedIndex(3);
				cargarJugadoresPorEquipo();
				cargarJugador(jugador);
			}
		});
		scrollPane_1.setViewportView(table_1);
		String[] columnsheaders2 = {"Jugadores lesionados"};
		tablemodel2 = new DefaultTableModel();
		tablemodel2.setColumnIdentifiers(columnsheaders2);
		table_1.setModel(tablemodel2);
		
		JPanel tab = new JPanel();
		tab.setBounds(22, 79, 674, 488);
		contentPanel.add(tab);
		tab.setLayout(null);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		tabbedPane.setBounds(0, 0, 664, 488);
		tab.add(tabbedPane);
		JPanel panel_1=new JPanel();
		
		JLabel et_p1=new JLabel("Estas en el panel 1");
		panel_1.add(et_p1);
		tabbedPane.addTab("Promedio", panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Estadisticas", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Calendario", null, panel_3, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Jugador", null, panel, null);
		tabbedPane.setSelectedIndex(0);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel(){
	        @Override
	        protected void paintComponent(Graphics grphcs) {
	            super.paintComponent(grphcs);
	            Graphics2D g2d = (Graphics2D) grphcs;
	            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                    RenderingHints.VALUE_ANTIALIAS_ON);
	            GradientPaint gp = new GradientPaint(0, 0,
	                    getBackground().brighter().brighter(), 0, getHeight(),
	                    getBackground().darker().darker());
	            g2d.setPaint(gp);
	            g2d.fillRect(0, 0, getWidth(), getHeight()); 

	        }

	    };
		panel_4.setBounds(10, 11, 639, 185);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		lbFoto = new JLabel("");
		lbFoto.setBounds(0, 35, 202, 150);
		panel_4.add(lbFoto);
		
		lbNombreJugador = new JLabel(" ");
		lbNombreJugador.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lbNombreJugador.setBounds(212, 11, 202, 31);
		panel_4.add(lbNombreJugador);
		
		separator_1 = new JSeparator();
		separator_1.setVisible(false);
		separator_1.setBounds(212, 45, 252, 2);
		panel_4.add(separator_1);
		
		lbNumero = new JLabel("#13");
		lbNumero.setVisible(false);
		lbNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbNumero.setBounds(212, 53, 46, 14);
		panel_4.add(lbNumero);
		
		lbPos = new JLabel("3B");
		lbPos.setVisible(false);
		lbPos.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbPos.setBounds(248, 53, 46, 14);
		panel_4.add(lbPos);
		
		separator_2 = new JSeparator();
		separator_2.setVisible(false);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(275, 53, 8, 14);
		panel_4.add(separator_2);
		
		lbZurdoODiestro = new JLabel("Batea: D, Lanza: D");
		lbZurdoODiestro.setVisible(false);
		lbZurdoODiestro.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbZurdoODiestro.setBounds(287, 53, 151, 14);
		panel_4.add(lbZurdoODiestro);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento: ");
		lblFechaDeNacimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblFechaDeNacimiento.setVisible(false);
		lblFechaDeNacimiento.setBounds(212, 75, 179, 14);
		panel_4.add(lblFechaDeNacimiento);
		
		lblFecha = new JLabel("6 de julio de 1992");
		lblFecha.setVisible(false);
		lblFecha.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblFecha.setBounds(385, 75, 244, 14);
		panel_4.add(lblFecha);
		
		lblLugarDeNacimiento = new JLabel("Lugar de Nacimiento: ");
		lblLugarDeNacimiento.setVisible(false);
		lblLugarDeNacimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblLugarDeNacimiento.setBounds(212, 97, 169, 19);
		panel_4.add(lblLugarDeNacimiento);
		
		lbLugar = new JLabel("Miami, Estados Unidos");
		lbLugar.setVisible(false);
		lbLugar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbLugar.setBounds(385, 97, 244, 19);
		panel_4.add(lbLugar);
		
		lblUniversidad = new JLabel("Universidad: ");
		lblUniversidad.setVisible(false);
		lblUniversidad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblUniversidad.setBounds(212, 122, 99, 19);
		panel_4.add(lblUniversidad);
		
		lbUni = new JLabel("Ninguna");
		lbUni.setVisible(false);
		lbUni.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbUni.setBounds(311, 122, 253, 19);
		panel_4.add(lbUni);
		
		lbEligeUnJugador = new JLabel(" Elige un jugador");
		lbEligeUnJugador.setBounds(148, 47, 307, 91);
		panel_4.add(lbEligeUnJugador);
		lbEligeUnJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lbEligeUnJugador.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		lbEligeUnJugador.setEnabled(false);
		
		button = new JButton("");
		if(aux.getJugador().size()>0){
			button.setVisible(true);
		}else{
			button.setVisible(false);
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jugadores jug = aux.buscarJugadorbynombre(jugador);
				RegistrarJugador reg = new RegistrarJugador(false, true, jug);
				reg.setVisible(true);
			}
		});
		button.setBounds(419, 11, 41, 33);
		panel_4.add(button);
		
		JButton btnFormarEquipo = new JButton(""); 
		btnFormarEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFormarEquipo.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFormarEquipo.setVisible(false);
			}
		});
		btnFormarEquipo.setIcon(new ImageIcon("img/formarequipo.png"));
		btnFormarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PosicionCampo pc = new PosicionCampo();
				pc.setVisible(true);
			}
		});
		btnFormarEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnFormarEquipo.setBounds(952, 22, 48, 40);
		contentPanel.add(btnFormarEquipo);
		
		JButton btnAgregarJugador = new JButton(""); 
		btnAgregarJugador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAgregarJugador.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAgregarJugador.setVisible(false);
			}
		});
		btnAgregarJugador.setIcon(new ImageIcon("img/agregarjug.png"));
		btnAgregarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarJugador regjug = new RegistrarJugador(false, false, null);
				regjug.setVisible(true);
			}
		});
		btnAgregarJugador.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnAgregarJugador.setBounds(894, 22, 48, 40);
		contentPanel.add(btnAgregarJugador);
		
		JButton btnJugadorLesionado = new JButton(""); 
		btnJugadorLesionado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblJugadorLesionado.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblJugadorLesionado.setVisible(false);
			}
		});
		btnJugadorLesionado.setIcon(new ImageIcon("img/jugadorlesion.png"));
		btnJugadorLesionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lesiones lesion = new Lesiones(aux);
				lesion.setVisible(true);
			}
		});
		btnJugadorLesionado.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnJugadorLesionado.setBounds(836, 22, 48, 40);
		contentPanel.add(btnJugadorLesionado);
		panel_3.setLayout(null);
		
		
		//tabla calendario
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 5, 639, 439);
		panel_3.add(scrollPane2);
		
		tablecalendario = new JTable();
		scrollPane2.setViewportView(tablecalendario);
		
		String[] columnsHeade = {"Equipo Local", " Equipo Visita", " Estadio", " Fecha", " Hora"};
		tablemodelcalendario = new DefaultTableModel();
		tablemodelcalendario.setColumnIdentifiers(columnsHeade);
		tablecalendario.setModel(tablemodelcalendario);
		
		lblAgregarJugador = new JLabel("Agregar Jugador");
		lblAgregarJugador.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblAgregarJugador.setVisible(false);
		lblAgregarJugador.setBounds(820, 0, 108, 20);
		contentPanel.add(lblAgregarJugador);
		
		lblFormarEquipo = new JLabel("Formar Equipo");
		lblFormarEquipo.setVisible(false);
		lblFormarEquipo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblFormarEquipo.setBounds(894, 0, 108, 20);
		contentPanel.add(lblFormarEquipo);
		
		lblJugadorLesionado = new JLabel("Jugador Lesionado");
		lblJugadorLesionado.setVisible(false);
		lblJugadorLesionado.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblJugadorLesionado.setBounds(764, 0, 108, 20);
		contentPanel.add(lblJugadorLesionado);
		
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
		cargarpartidos();
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
	
	public void cargarpartidos(){
		tablemodelcalendario.setRowCount(0);
		fila3 = new Object[tablemodelcalendario.getColumnCount()];
		for (Partido partidos : LigaBeisbol.getInstance().getPartido()) {
			if(aux.getNombre().equalsIgnoreCase(partidos.getEquipoCasa()) || aux.getNombre().equalsIgnoreCase(partidos.getEquipoVisita())){
				fila3[0] = partidos.getEquipoCasa();
				fila3[1] = partidos.getEquipoVisita();
				fila3[2] = partidos.getEstadio();
				fila3[3] = partidos.getFecha();
				fila3[4] = partidos.getHora();
				tablemodelcalendario.addRow(fila3);
			}
		}
	}
	
	public static void cargarJugador(String mijugador){
		lbEligeUnJugador.setVisible(false);
		lbNumero.setVisible(true);
		lbPos.setVisible(true);
		lbZurdoODiestro.setVisible(true);
		lblFechaDeNacimiento.setVisible(true);
		lblFecha.setVisible(true);
		lblLugarDeNacimiento.setVisible(true);
		lblFechaDeNacimiento.setVisible(true);
		lbLugar.setVisible(true);
		lblUniversidad.setVisible(true);
		lbUni.setVisible(true);
		separator_1.setVisible(true);
		for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
			if(aux.getNombre().equalsIgnoreCase(mijugador)){
				lbNombreJugador.setText(aux.getNombre() + " " + aux.getApellido());
				String route = "jugadores/" + aux.getNombre()+".png";
				ImageIcon imagee = new ImageIcon(route);
				lbFoto.setIcon(imagee);
				lbNumero.setText("#" + aux.getNumero());
				if(aux.getPosicion().equalsIgnoreCase("Primera base")){
					lbPos.setText("1B");
				}else if(aux.getPosicion().equalsIgnoreCase("Segunda base")){
					lbPos.setText("2B");
				}else if(aux.getPosicion().equalsIgnoreCase("Tercera base")){
					lbPos.setText("3B");
				}
				//lbZurdoODiestro.setText("");
				lbLugar.setText(aux.getLugarciudadNacimiento());
				LocalDate localDate=LocalDate.of(aux.getFechanacimiento().getYear(),aux.getFechanacimiento().getMonthValue(),aux.getFechanacimiento().getDayOfMonth());
				Locale spanishLocale=new Locale("es", "ES");
			    String dateInSpanish=localDate.format(DateTimeFormatter.ofPattern("dd MMMM, yyyy",spanishLocale));
			    lblFecha.setText(dateInSpanish+ " (Edad: " +Math.abs(aux.getFechanacimiento().getYear()-LocalDate.now().getYear())+ ")");
			    lbUni.setText(aux.getUniversidad());
			}
		}
		
	}
}
