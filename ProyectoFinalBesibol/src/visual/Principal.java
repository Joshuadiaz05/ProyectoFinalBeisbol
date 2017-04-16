package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import logical.Equipos;
import logical.LigaBeisbol;
import logical.Partido;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.io.File;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dimension dim;
	private static LigaBeisbol liga;
	private static DefaultTableModel tablemodel;
	static Object fila[];
	private static JTable table;
	private JButton btnNewButton;
	private String local = null;
	private String visita = null;
	private JLabel lblNewLabel_1;
	private int ind;
	private Partido miPartido = null;
	private ArrayList<Integer> posicion = new ArrayList<>();
	File f = new File("./Archivo.dat");

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
				RegistrarEquipo reg = new RegistrarEquipo(false, null);
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

		JMenuItem menuItem = new JMenuItem("Tabla de Posiciones");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaPosiciones tp = new TablaPosiciones();
				tp.setVisible(true);
			}
		});
		mnEquipos.add(menuItem);

		JMenu mnJugadores = new JMenu("Jugadores");
		mnJugadores.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnJugadores);

		JMenuItem mntmRegistrarJugador = new JMenuItem("Registrar Jugador");
		mntmRegistrarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LigaBeisbol.getInstance().getEquipo().size() == 0) {
					JOptionPane.showMessageDialog(null, "No hay equipos disponibles", "Error",
							JOptionPane.WARNING_MESSAGE);
				} else {
					RegistrarJugador regjug = new RegistrarJugador(true, false, null);
					regjug.setVisible(true);
				}

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

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 32, 766, 429);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 746, 317);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ind = table.getSelectedRow();
				local = (String) table.getModel().getValueAt(ind, 0);
				visita = (String) table.getModel().getValueAt(ind, 1);
				String fecha = (String) table.getModel().getValueAt(ind, 3);
				Locale spanishLocale = new Locale("es", "ES");
				DateFormat format = new SimpleDateFormat("dd MMMM yyyy", spanishLocale);
				Date date = null;
				try {
					date = format.parse(fecha);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				miPartido = LigaBeisbol.getInstance().buscarPartido(local, visita, date);
				btnNewButton.setEnabled(true);

			}
		});
		scrollPane.setViewportView(table);

		String[] columnsHeaders = { "Equipo Local", " Equipo Visita", " Estadio", " Fecha", " Hora", "Finalizado" };
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

		lblNewLabel_1 = new JLabel("Ir a Todos los Eventos");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(200, 2, 144, 14);
		panel.add(lblNewLabel_1);

		btnNewButton = new JButton("Jugar Partido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (miPartido.getCarrerasCasa() == 0 && miPartido.getCarrerasVisita() == 0) {
					if (verificarEquiposLlenos(local, visita) == true) {
						Simulacion simular = new Simulacion(local, visita, miPartido);
						simular.setVisible(true);
					} else {
						int answer = JOptionPane.showConfirmDialog(null,
								"Las posiciones de uno o ambos equipos no están cubiertas\n¿Desea Verificar?", null,
								JOptionPane.YES_NO_OPTION);
						if (answer == JOptionPane.YES_OPTION) {
							TablaPosiciones equip = new TablaPosiciones();
							equip.setVisible(true);
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "El Partido ya está Finalizado", "Error",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(615, 392, 141, 23);
		panel.add(btnNewButton);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoEventos lista = new ListadoEventos();
				lista.setVisible(true);
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_1.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("img/iconcalendar.png"));
		button.setBounds(217, 18, 50, 40);
		panel.add(button);

		cargar();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				LigaBeisbol.getInstance().guardarArchivo(LigaBeisbol.getInstance());
				e.getWindow().dispose();
			}
		});
		ordenar();
	}

	public static void cargar() {
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table.getColumnModel().getColumn(4).setCellRenderer(tcr);
		table.getColumnModel().getColumn(5).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Partido aux : LigaBeisbol.getInstance().getPartido()) {
			Date input = new Date(aux.getFecha().getYear(), aux.getFecha().getMonth(), aux.getFecha().getDate());
			LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (LocalDate.now().equals(date)) {
				fila[0] = aux.getEquipoCasa();
				fila[1] = aux.getEquipoVisita();
				fila[2] = aux.getEstadio();
				Date fecha = new Date(aux.getFecha().getYear(), aux.getFecha().getMonth(), aux.getFecha().getDate());
				LocalDate localfecha = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				Locale spanishLocale = new Locale("es", "ES");
				String fechaString = localfecha.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", spanishLocale));
				fila[3] = fechaString;
				fila[4] = aux.getHora();
				if (aux.getCarrerasCasa() == 0 && aux.getCarrerasVisita() == 0) {
					fila[5] = "-";
				} else {
					fila[5] = "" + aux.getCarrerasCasa() + " - " + aux.getCarrerasVisita();
				}
				tablemodel.addRow(fila);
			}
		}
	}

	public boolean verificarEquiposLlenos(String local, String visita) {
		Equipos equipolocal = LigaBeisbol.getInstance().BuscarPorNombre(local);
		Equipos equipovisita = LigaBeisbol.getInstance().BuscarPorNombre(visita);
		boolean confirmar = true;
		int i = 0;
		while (i < equipolocal.getJugador().size() && confirmar == false) {
			if (equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Primera base")
					|| equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Segunda base")
					|| equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Tercera base")
					|| equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Short stop")
					|| equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Right fielder")
					|| equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Left fielder")
					|| equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Center fielder")
					|| equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Catcher")
					|| equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Pitcher")
					|| equipolocal.getJugador().get(i).getPosicion().equalsIgnoreCase("Bateador designado")
					){
				confirmar = true;
			}else{
				confirmar = true;
			}
			i++;
		}
		return confirmar;
	}
	public static void ordenar(){
		Collections.sort(LigaBeisbol.getInstance().getEquipo(), new Comparator<Equipos>() {
			public int compare(Equipos o1, Equipos o2) {
				return new Integer(o2.getJg()).compareTo(o1.getJg());
			}
		});
	}
}
