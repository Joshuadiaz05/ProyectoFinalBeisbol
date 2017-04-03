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

public class Principal extends JFrame {

	private Dimension dim;
	private static LigaBeisbol liga;

	/**
	 * Launch the application.
	 */
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
		setBounds(100, 100, 1366, 768);

		LigaBeisbol.getInstance().cargarArchivo(liga);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1366, 21);
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
				PosicionCampo posicion = new PosicionCampo();
				posicion.setVisible(true);
			}
		});
		mnEquipos.add(mntmPosicionesEnEl);

		JMenu mnJugadores = new JMenu("Jugadores");
		mnJugadores.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnJugadores);

		JMenuItem mntmRegistrarJugador = new JMenuItem("Registrar Jugador");
		mntmRegistrarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarJugador regjug = new RegistrarJugador();
				regjug.setVisible(true);
			}
		});
		mnJugadores.add(mntmRegistrarJugador);

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
		mnPartidos.add(mntmVerAgenda);

		JMenu mnLesiones = new JMenu("Lesiones");
		mnLesiones.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnLesiones);

		JMenuItem mntmJugadorLesionado = new JMenuItem("Jugador Lesionado");
		mntmJugadorLesionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lesiones lesion = new  Lesiones();
						lesion.setVisible(true);
			}
		});
		mnLesiones.add(mntmJugadorLesionado);

		JMenuItem mntmSustituirJugadoresLesionados = new JMenuItem("Sustituir Jugadores Lesionados");
		mnLesiones.add(mntmSustituirJugadoresLesionados);

		JMenu mnSimulacin = new JMenu("Simulaci\u00F3n");
		mnSimulacin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnSimulacin);

		JMenuItem mntmIniciarPartido = new JMenuItem("Iniciar Partido");
		mnSimulacin.add(mntmIniciarPartido);

		JMenu mnEstadisticas = new JMenu("Estadisticas");
		menuBar.add(mnEstadisticas);

		JMenuItem mntmVerEstadisticas = new JMenuItem("Ver Estadisticas");
		mnEstadisticas.add(mntmVerEstadisticas);

		JMenu mnPosiciones = new JMenu("Posiciones");
		menuBar.add(mnPosiciones);

		JMenuItem mntmTablaDePosiciones = new JMenuItem("Tabla de Posiciones");
		mnPosiciones.add(mntmTablaDePosiciones);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 32, 437, 316);
		getContentPane().add(panel);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				LigaBeisbol.getInstance().guardarArchivo(LigaBeisbol.getInstance());
				;
				e.getWindow().dispose();
			}
		});
	}
}
