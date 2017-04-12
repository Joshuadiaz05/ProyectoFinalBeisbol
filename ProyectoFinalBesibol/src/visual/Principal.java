package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import logical.LigaBeisbol;
import logical.Partido;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class Principal extends JFrame {

	private Dimension dim;
	private static LigaBeisbol liga;
	private static DefaultTableModel tablemodel;
	static Object fila[];
	private static JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// BusinessBlackSteelSkin
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
					Principal frame = new Principal(liga);
					frame.pack();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal(final LigaBeisbol liga) {
		setTitle("Liga de Beisbol");
		getContentPane().setLayout(null);
		setBounds(100, 100, 1920, 1080);

		LigaBeisbol.getInstance().cargarArchivo(liga);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1920, 21);
		getContentPane().add(menuBar);

		JMenu mnEquipos = new JMenu("Equipos");
		mnEquipos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnEquipos);

		JMenuItem mntmCrearEquipo = new JMenuItem("Crear Equipo");
		mntmCrearEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarEquipo reg = new RegistrarEquipo();
				reg.setVisible(true);
			}
		});
		mnEquipos.add(mntmCrearEquipo);

		JMenuItem mntmVerListado = new JMenuItem("Ver Listado");
		mntmVerListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoEquipo listado = new ListadoEquipo();
				listado.setVisible(true);
			}
		});
		mnEquipos.add(mntmVerListado);

		JMenuItem mntmPosicionesEnEl = new JMenuItem("Posiciones en el Campo");
		mntmPosicionesEnEl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		JMenuItem menuItem = new JMenuItem("Tabla de Posiciones");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaPosiciones tp = new TablaPosiciones();
				tp.setVisible(true);
			}
		});
		mnEquipos.add(menuItem);
		mnEquipos.add(mntmPosicionesEnEl);

		JMenu mnJugadores = new JMenu("Jugadores");
		mnJugadores.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnJugadores);

		JMenuItem mntmRegistrarJugador = new JMenuItem("Registrar Jugador");
		mntmRegistrarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarJugador regjug = new RegistrarJugador(null);
				regjug.setVisible(true);
			}
		});
		mnJugadores.add(mntmRegistrarJugador);

		JMenuItem mntmMostrarJugadores = new JMenuItem("Mostrar Jugadores");
		mntmMostrarJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerJugadores ver = new VerJugadores();
				ver.setVisible(true);
			}
		});
		mnJugadores.add(mntmMostrarJugadores);

		JMenuItem menuItem_1 = new JMenuItem("Ver Estadisticas");
		mnJugadores.add(menuItem_1);

		JMenu mnPartidos = new JMenu("Partidos");
		mnPartidos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnPartidos);

		JMenuItem mntmCrearEvento = new JMenuItem("Crear Evento");
		mntmCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPartido regpar = new RegistrarPartido();
				regpar.setVisible(true);
			}
		});
		mnPartidos.add(mntmCrearEvento);

		JMenuItem mntmVerAgenda = new JMenuItem("Ver Agenda");
		mntmVerAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoEventos partidos = new ListadoEventos();
				partidos.setVisible(true);
			}
		});
		mnPartidos.add(mntmVerAgenda);

		JMenu mnLesiones = new JMenu("Lesiones");
		mnLesiones.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnLesiones);

		JMenuItem mntmJugadorLesionado = new JMenuItem("Jugador Lesionado");
		mntmJugadorLesionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnLesiones.add(mntmJugadorLesionado);

		JMenuItem mntmSustituirJugadoresLesionados = new JMenuItem("Sustituir Jugadores Lesionados");
		mnLesiones.add(mntmSustituirJugadoresLesionados);

		JMenu mnSimulacin = new JMenu("Simulaci\u00F3n");
		mnSimulacin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnSimulacin);

		JMenuItem mntmIniciarPartido = new JMenuItem("Iniciar Partido");
		mntmIniciarPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Simulacion simular = new Simulacion();
				simular.setVisible(true);
			}
		});
		mnSimulacin.add(mntmIniciarPartido);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 32, 605, 429);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 580, 317);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String[] columnsHeaders = {"Equipo Local", " Equipo Visita", " Estadio", " Fecha", " Hora"};
		tablemodel = new DefaultTableModel();
		tablemodel.setColumnIdentifiers(columnsHeaders);
		table.setModel(tablemodel);
		
		JLabel lblPartidosDeHoy = new JLabel("Partidos De Hoy");
		lblPartidosDeHoy.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblPartidosDeHoy.setBounds(10, 21, 213, 37);
		panel.add(lblPartidosDeHoy);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(11, 55, 197, 2);
		panel.add(separator);
		
		JButton btnNewButton = new JButton("Jugar Partido");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(449, 390, 141, 23);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBounds(217, 16, 56, 41);
		panel.add(label);
		
		cargar();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				LigaBeisbol.getInstance().guardarArchivo(LigaBeisbol.getInstance());
				e.getWindow().dispose();
			}
		});
	}
	
	public void cargar(){
		tablemodel.setRowCount(0);
		fila = new Object[tablemodel.getColumnCount()];
		for (Partido aux : LigaBeisbol.getInstance().getPartido()) {
			fila[0] = aux.getEquipoCasa();
			fila[1] = aux.getEquipoVisita();
			fila[2] = aux.getEstadio();
			fila[3] = aux.getFecha();
			fila[4] = aux.getHora();
			tablemodel.addRow(fila);
		}
	}
}
