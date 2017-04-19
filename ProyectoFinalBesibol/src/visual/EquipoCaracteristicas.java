package visual;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.sun.prism.Image;

import jdk.nashorn.internal.scripts.JO;
import logical.Equipos;
import logical.Jugadores;
import logical.LigaBeisbol;
import logical.Partido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ScrollPaneConstants;

public class EquipoCaracteristicas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	static Object[] fila;
	private static DefaultTableModel tablemodel;
	private static JTable table_1;
	static Object[] fila2;
	private static DefaultTableModel tablemodel2;
	private static JTable table_4;
	private static DefaultTableModel tablemodel4;
	static Object[] fila4;
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
	private static JLabel lbFoto_equipo;
	private static JSeparator separator_2;
	private JLabel lblAgregarJugador;
	private JLabel lblFormarEquipo;
	private JLabel lblJugadorLesionado;
	private static JTable tablecalendario;
	private static DefaultTableModel tablemodelcalendario;
	static Object[] fila3;
	Equipos aux = LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo);
	private static JButton button;
	private JTable table_2;
	private static JPanel panel_6;
	private static JPanel panel_5;
	private static JLabel lblNewLabel;
	private JPanel panel_8;
	private JLabel lblNewLabel_1;
	private JButton button_1;
	private JLabel lblQuitarLesion;
	private JPanel panel;
	private static JLabel lblNombreEquipo, lblEquipo;
	private static JLabel lbManager, lbAgnoEquipo, lbRegion, lbEstadioo;
	private static JLabel promedio;
	private static JLabel slg;
	private JLabel lblPromedioDeSlg;

	/**
	 * Create the dialog.
	 */
	public EquipoCaracteristicas() {
		setTitle("Equipo - " + aux.getNombre());
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 1213, 710);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		lblEquipo = new JLabel(aux.getNombre());
		lblEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblEquipo.setBounds(152, 45, 393, 47);
		contentPanel.add(lblEquipo);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 93, 1159, 2);
		contentPanel.add(separator);

		JPanel panel_jugadores = new JPanel();
		panel_jugadores.setBounds(706, 100, 465, 233);
		contentPanel.add(panel_jugadores);
		panel_jugadores.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 465, 233);
		panel_jugadores.add(scrollPane);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				jugador = (String) table.getModel().getValueAt(index, 0);
				tabbedPane.setSelectedIndex(3);
				cargarJugadoresLesionadoPorEquipo();
				cargarJugador(jugador);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		String[] columnsheaders = { "Jugadores activos" };
		tablemodel = new DefaultTableModel();
		tablemodel.setColumnIdentifiers(columnsheaders);
		table.setModel(tablemodel);

		JPanel panel_jugadores_lesionados = new JPanel();
		panel_jugadores_lesionados.setLayout(null);
		panel_jugadores_lesionados.setBounds(706, 342, 465, 246);
		contentPanel.add(panel_jugadores_lesionados);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 465, 246);
		panel_jugadores_lesionados.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setColumnSelectionAllowed(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				jugador = (String) table_1.getModel().getValueAt(index, 0);
				tabbedPane.setSelectedIndex(3);
				cargarJugadoresPorEquipo();
				cargarJugador(jugador);
				int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas ver la información de la lesión?", "Alerta", JOptionPane.INFORMATION_MESSAGE);
				if(resp==JOptionPane.OK_OPTION){
					MostrarLesion m = new MostrarLesion(LigaBeisbol.getInstance().buscarjugador(jugador));
					m.setVisible(true);
					
				}
				button_1.setEnabled(true);
			}
		});
		scrollPane_1.setViewportView(table_1);
		String[] columnsheaders2 = { "Jugadores lesionados" };
		tablemodel2 = new DefaultTableModel();
		tablemodel2.setColumnIdentifiers(columnsheaders2);
		table_1.setModel(tablemodel2);

		JPanel tab = new JPanel();
		tab.setBounds(22, 100, 674, 488);
		contentPanel.add(tab);
		tab.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setEnabledAt(3, false);
			}
			});
		tabbedPane.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		tabbedPane.setBounds(0, 0, 664, 488);
		tab.add(tabbedPane);
		JPanel panelPromedio = new JPanel();
		panelPromedio.setLayout(null);
		JLabel et_p1 = new JLabel("Promedio de Bateo");
		et_p1.setBounds(192, 30, 275, 44);
		et_p1.setFont(new Font("Times New Roman", Font.BOLD, 33));
		panelPromedio.add(et_p1);
		tabbedPane.addTab("Promedio", panelPromedio);
		
		promedio = new JLabel("");
		promedio.setHorizontalAlignment(SwingConstants.CENTER);
		promedio.setFont(new Font("Tw Cen MT", Font.PLAIN, 98));
		promedio.setBounds(131, 68, 396, 159);
		panelPromedio.add(promedio);
		
		slg = new JLabel();
		slg.setHorizontalAlignment(SwingConstants.CENTER);
		slg.setFont(new Font("Tw Cen MT", Font.PLAIN, 98));
		slg.setBounds(141, 281, 396, 159);
		panelPromedio.add(slg);
		
		lblPromedioDeSlg = new JLabel("Porcentaje de Slugging");
		lblPromedioDeSlg.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblPromedioDeSlg.setBounds(162, 243, 335, 44);
		panelPromedio.add(lblPromedioDeSlg);

		JPanel panelCalendario = new JPanel();
		tabbedPane.addTab("Calendario", null, panelCalendario, null);

		panel = new JPanel();
		tabbedPane.setSelectedIndex(0);
		panel.setLayout(null);

		JPanel panel_4 = new JPanel() {
			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint(0, 0, getBackground().brighter().brighter(), 0, getHeight(),
						getBackground().darker().darker());
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}

		};
		panel_4.setBounds(0, 0, 659, 185);
		panel.add(panel_4);
		panel_4.setLayout(null);

		panel_6 = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		panel_6.setOpaque(false);
		panel_6.setVisible(false);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_6.setBackground(new Color(0, 0, 0, 10));
		panel_6.setBounds(2, 30, 205, 155);
		panel_4.add(panel_6);

		lbFoto = new JLabel("");
		panel_6.add(lbFoto);

		lbNombreJugador = new JLabel(" ");
		lbNombreJugador.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lbNombreJugador.setBounds(212, 11, 352, 31);
		panel_4.add(lbNombreJugador);

		separator_1 = new JSeparator();
		separator_1.setVisible(false);
		separator_1.setBounds(212, 45, 417, 2);
		panel_4.add(separator_1);

		lbNumero = new JLabel("#13");
		lbNumero.setVisible(false);
		lbNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbNumero.setBounds(212, 53, 42, 14);
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
		lbUni.setBounds(311, 122, 318, 19);
		panel_4.add(lbUni);

		lbEligeUnJugador = new JLabel(" Elige un jugador");
		lbEligeUnJugador.setBounds(148, 47, 307, 91);
		panel_4.add(lbEligeUnJugador);
		lbEligeUnJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lbEligeUnJugador.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
		lbEligeUnJugador.setEnabled(false);

		button = new JButton("");
		ImageIcon eee = new ImageIcon("img/ediit.png");
		button.setIcon(eee);
		if (aux.getJugador().size() > 0) {
			button.setVisible(true);
		} else {
			button.setVisible(false);
		}
		button.setVisible(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarJugador reg = new RegistrarJugador(false, true, jugador);
				reg.setVisible(true);
			}
		});
		button.setBounds(577, 11, 41, 33);
		panel_4.add(button);

		panel_5 = new JPanel();
		panel_5.setVisible(false);
		panel_5.setBorder(
				new TitledBorder(null, "Est\u00E1distica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 196, 639, 69);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(10, 22, 619, 37);
		panel_5.add(scrollPane_2);

		table_4 = new JTable();
		scrollPane_2.setViewportView(table_4);
		String[] columndsheaders = {"AB", "C", "H", "2B", "3B", "HR", "RBI", "BB", "PROM"};
		tablemodel4 = new DefaultTableModel();
		tablemodel4.setColumnIdentifiers(columndsheaders);
		table_4.setModel(tablemodel4);
		panelCalendario.setLayout(null);

		// tabla calendario
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 5, 639, 439);
		panelCalendario.add(scrollPane2);

		tablecalendario = new JTable();
		tablecalendario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane2.setViewportView(tablecalendario);

		String[] columnsHeade = { "Equipo Local", " Equipo Visita", " Estadio", " Fecha", " Hora", "Finalizado" };
		tablemodelcalendario = new DefaultTableModel();
		tablemodelcalendario.setColumnIdentifiers(columnsHeade);
		tablecalendario.setModel(tablemodelcalendario);
		
		JPanel panelinfo = new JPanel();
		tabbedPane.addTab("Informacion", null, panelinfo, null);
		tabbedPane.addTab("Jugador", null, panel, null);
		tabbedPane.setEnabledAt(3, false);
		panelinfo.setLayout(null);
		ImageIcon imagee = new ImageIcon("equipos/" + aux.getNombre() + ".png");
		
		JPanel panel_3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint(0, 0, getBackground().brighter().brighter(), 0, getHeight(),
						getBackground().darker().darker());
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}

		};
		panel_3.setBounds(0, 0, 659, 199);
		panelinfo.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblA = new JLabel("Manager:");
		lblA.setBounds(140, 60, 90, 19);
		panel_3.add(lblA);
		lblA.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		lbManager = new JLabel("");
		lbManager.setBounds(220, 60, 137, 19);
		panel_3.add(lbManager);
		lbManager.setText(aux.getManager());
		lbManager.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("A\u00F1o de Creacion: ");
		label_2.setBounds(140, 113, 137, 19);
		panel_3.add(label_2);
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		lbAgnoEquipo = new JLabel("");
		lbAgnoEquipo.setBounds(278, 113, 105, 19);
		panel_3.add(lbAgnoEquipo);
		lbAgnoEquipo.setText(aux.getAgnocreacion());
		lbAgnoEquipo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		JLabel lblEstadio = new JLabel("Estadio: ");
		lblEstadio.setBounds(392, 60, 73, 19);
		panel_3.add(lblEstadio);
		lblEstadio.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		lbEstadioo = new JLabel();
		lbEstadioo.setBounds(461, 60, 150, 19);
		panel_3.add(lbEstadioo);
		lbEstadioo.setText(aux.getEstadio());
		lbEstadioo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		JLabel lblRegion = new JLabel("Regi\u00F3n: ");
		lblRegion.setBounds(393, 113, 73, 19);
		panel_3.add(lblRegion);
		lblRegion.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		lbRegion = new JLabel();
		lbRegion.setBounds(461, 113, 150, 19);
		panel_3.add(lbRegion);
		lbRegion.setText(aux.getRegion());
		lbRegion.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		lblNombreEquipo = new JLabel("");
		lblNombreEquipo.setBounds(140, 17, 399, 35);
		panel_3.add(lblNombreEquipo);
		lblNombreEquipo.setText(aux.getNombre());
		lblNombreEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(140, 47, 509, 2);
		panel_3.add(separator_3);
		
		JButton btnModificar = new JButton("");
		btnModificar.setBounds(549, 11, 45, 34);
		panel_3.add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarEquipo reg = new RegistrarEquipo(true, aux);
				reg.setVisible(true);
			}
		});
		btnModificar.setIcon(new ImageIcon("img/ediit.png"));
		
		JPanel panel_1 = new JPanel() {
		    public void paintComponent(Graphics g) {
		        g.setColor(Color.white);
		        g.drawArc(0, 0, 118, 110, 0, 360); 
		    }
		};
		panel_1.setBounds(10, 17, 120, 115);
		panel_1.setBackground(new Color(0, 0, 0, 0));
		panel_3.add(panel_1);
		panel_1.setLayout(null);
		
		lbFoto_equipo = new JLabel("");
		lbFoto_equipo.setBounds(0, 0, 120, 115);
		lbFoto_equipo.setIcon(imagee);
		lbFoto_equipo.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lbFoto_equipo);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este equipo: " + aux.getNombre() + "?", null, JOptionPane.INFORMATION_MESSAGE);
				if(resp==JOptionPane.OK_OPTION){
					String nombre = aux.getNombre();
					aux.getJugador().clear();
					LigaBeisbol.getInstance().getEquipo().remove(aux);
					JOptionPane.showMessageDialog(null, "El equipo " + nombre + " Equipo eliminado", null, JOptionPane.INFORMATION_MESSAGE);
					TablaPosiciones.cargarPosicionEste();
					TablaPosiciones.cargarPosicionNorte();
					TablaPosiciones.cargarPosicionOeste();
					TablaPosiciones.cargarPosicionSur();
					dispose();
				}
			}
		});
		ImageIcon ee = new ImageIcon("img/borraequipo.png");
		button_2.setIcon(ee);
		button_2.setBounds(604, 11, 45, 34);
		panel_3.add(button_2);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(22, 8, 120, 83);
		contentPanel.add(panel_7);

		lblNewLabel = new JLabel("");
		ImageIcon image = new ImageIcon("equipos/" + TablaPosiciones.nombreEquipo + ".png");
		lblNewLabel.setIcon(image);
		panel_7.add(lblNewLabel);

		panel_8 = new JPanel();
		panel_8.setBounds(858, 1, 325, 95);
		contentPanel.add(panel_8);
		panel_8.setLayout(null);

		lblJugadorLesionado = new JLabel("Jugador Lesionado");
		lblJugadorLesionado.setBounds(33, 22, 108, 20);
		panel_8.add(lblJugadorLesionado);
		lblJugadorLesionado.setVisible(false);
		lblJugadorLesionado.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));

		JButton btnJugadorLesionado = new JButton("");
		btnJugadorLesionado.setBounds(67, 50, 48, 40);
		panel_8.add(btnJugadorLesionado);
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
				cargarJugadoresPorEquipo();
				cargarJugadoresLesionadoPorEquipo();
			}
		});
		btnJugadorLesionado.setFont(new Font("Trebuchet MS", Font.BOLD, 16));

		JButton btnAgregarJugador = new JButton("");
		btnAgregarJugador.setBounds(183, 50, 48, 40);
		panel_8.add(btnAgregarJugador);
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

		lblAgregarJugador = new JLabel("Agregar Jugador");
		lblAgregarJugador.setBounds(172, 22, 108, 20);
		panel_8.add(lblAgregarJugador);
		lblAgregarJugador.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));

		JButton btnFormarEquipo = new JButton("");
		btnFormarEquipo.setBounds(241, 50, 48, 40);
		panel_8.add(btnFormarEquipo);
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

		lblFormarEquipo = new JLabel("Formar Equipo");
		lblFormarEquipo.setBounds(236, 22, 108, 20);
		panel_8.add(lblFormarEquipo);
		lblFormarEquipo.setVisible(false);
		lblFormarEquipo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));

		JButton EliminarJugador = new JButton("");
		EliminarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int answer = JOptionPane.showConfirmDialog(null,
						"¿Seguro que Desea Eliminar el Jugador?", null,
						JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					aux.eliminarJugador(jugador);
					tabbedPane.setEnabledAt(3, false);
					cargarJugadoresPorEquipo();
					cargarJugadoresLesionadoPorEquipo();
					tabbedPane.setSelectedIndex(0);
				}
			}
		});
		EliminarJugador.setIcon(new ImageIcon("img/ellmjug.png"));
		EliminarJugador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_1.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setVisible(false);
			}
		});
		EliminarJugador.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		EliminarJugador.setBounds(125, 50, 48, 40);
		panel_8.add(EliminarJugador);

		lblNewLabel_1 = new JLabel("Eliminar Jugador");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(105, 25, 126, 14);
		panel_8.add(lblNewLabel_1);
		
		button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aux.quitarLesion(jugador, false, false, null);
				JOptionPane.showMessageDialog(null, "Al jugador " + jugador +" se le ha retirado la Lesión!", null,
						JOptionPane.INFORMATION_MESSAGE, null);
				cargarJugadoresPorEquipo();
				cargarJugadoresLesionadoPorEquipo();
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuitarLesion.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblQuitarLesion.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon("img/jugadorRecuperado.png"));
		button_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_1.setBounds(8, 50, 48, 40);
		panel_8.add(button_1);
		
		if(aux.getJugador().size()==0){
			promedio.setText("");
		}else{
			NumberFormat formatter = new DecimalFormat(".000###");
			promedio.setText(""+formatter.format((double)aux.promedioBateoEquipo()/100));
		}
		
		if(aux.getJugador().size()==0){
			slg.setText("");
		}else{
			NumberFormat formatter = new DecimalFormat(".000###");
			slg.setText(""+formatter.format((double)aux.porcenajeSLGequipo()/100));
		}
		
		lblQuitarLesion = new JLabel("Quitar Lesion");
		lblQuitarLesion.setVisible(false);
		lblQuitarLesion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblQuitarLesion.setBounds(10, 25, 85, 14);
		panel_8.add(lblQuitarLesion);
		lblAgregarJugador.setVisible(false);

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
		cargarJugadoresPorEquipo();
		cargarJugadoresLesionadoPorEquipo();
		cargarpartidos();
	}

	public static void cargarJugadoresPorEquipo() {
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Jugadores e : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
			if (!e.isLesion()) {
				fila[0] = e.getNombre();
				tablemodel.addRow(fila);
				//e.getNombre() + " " + e.getApellido() + " - " + e.getPosicion();
			}
		}
	}

	public static void cargarJugadoresLesionadoPorEquipo() {
		tablemodel2.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_1.getColumnModel().getColumn(0).setCellRenderer(tcr);
		fila2 = new Object[tablemodel2.getColumnCount()];
		for (Jugadores e : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
			if (e.isLesion() == true) {
				fila2[0] = e.getNombre();
				tablemodel2.addRow(fila2);
			}
		}
	}

	public void cargarpartidos() {
		tablemodelcalendario.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tablecalendario.getColumnModel().getColumn(0).setCellRenderer(tcr);
		tablecalendario.getColumnModel().getColumn(1).setCellRenderer(tcr);
		tablecalendario.getColumnModel().getColumn(2).setCellRenderer(tcr);
		tablecalendario.getColumnModel().getColumn(3).setCellRenderer(tcr);
		tablecalendario.getColumnModel().getColumn(4).setCellRenderer(tcr);
		tablecalendario.getColumnModel().getColumn(5).setCellRenderer(tcr);
		fila3 = new Object[tablemodelcalendario.getColumnCount()];
		for (Partido partidos : LigaBeisbol.getInstance().getPartido()) {
			if (aux.getNombre().equalsIgnoreCase(partidos.getEquipoCasa())
					|| aux.getNombre().equalsIgnoreCase(partidos.getEquipoVisita())) {
				fila3[0] = partidos.getEquipoCasa();
				fila3[1] = partidos.getEquipoVisita();
				fila3[2] = partidos.getEstadio();
				fila3[3] = partidos.getFecha();
				fila3[4] = partidos.getHora();
				if (partidos.getCarrerasCasa() == 0 && partidos.getCarrerasVisita() == 0) {
					fila3[5] = "-";
				} else {
					fila3[5] = "" + partidos.getCarrerasCasa() + " - " + partidos.getCarrerasVisita();
				}
				tablemodelcalendario.addRow(fila3);
			}
		}
	}

	
	public static void cargarJugador(String mijugador) {
		lbEligeUnJugador.setVisible(false);
		button.setVisible(true);
		panel_5.setVisible(true);
		panel_6.setVisible(true);
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
			if (aux.getNombre().equalsIgnoreCase(mijugador)) {
				lbNombreJugador.setText(aux.getNombre() + " " + aux.getApellido());
				File file = new File("jugadores/" + aux.getNombre() + ".png");
				if (file.exists()) {
					String route = "jugadores/" + aux.getNombre() + ".png";
					ImageIcon imagee = new ImageIcon(route);
					lbFoto.setIcon(imagee);
				} else {
					ImageIcon image = new ImageIcon("img/player_blank.png");
					lbFoto.setIcon(image);
				}
				lbNumero.setText("#" + aux.getNumero());
				String pos = "";
				if (aux.getPosicion().equalsIgnoreCase("Primera base")) {
					pos = "1B";
				} else if (aux.getPosicion().equalsIgnoreCase("Segunda base")) {
					pos = "2B";
				} else if (aux.getPosicion().equalsIgnoreCase("Tercera base")) {
					pos = "3B";
				} else if (aux.getPosicion().equalsIgnoreCase("Pitcher")) {
					pos = "P";
				} else if (aux.getPosicion().equalsIgnoreCase("Catcher")) {
					pos = "C";
				} else if (aux.getPosicion().equalsIgnoreCase("Short stop")) {
					pos = "SS";
				} else if (aux.getPosicion().equalsIgnoreCase("Left fielder")) {
					pos = "LF";
				} else if (aux.getPosicion().equalsIgnoreCase("Center fielder")) {
					pos = "CF";
				} else if (aux.getPosicion().equalsIgnoreCase("Right fielder")) {
					pos = "RF";
				} else if (aux.getPosicion().equalsIgnoreCase("Bateador designado")) {
					pos = "BD";
				}
				lbPos.setText(pos);
				// lbZurdoODiestro.setText("");
				lbLugar.setText(aux.getLugarciudadNacimiento());
				LocalDate localDate = LocalDate.of(aux.getFechanacimiento().getYear(),
						aux.getFechanacimiento().getMonthValue(), aux.getFechanacimiento().getDayOfMonth());
				Locale spanishLocale = new Locale("es", "ES");
				String dia = localDate.format(DateTimeFormatter.ofPattern("dd", spanishLocale));
				String mes = localDate.format(DateTimeFormatter.ofPattern("MMMM", spanishLocale));
				String agno = localDate.format(DateTimeFormatter.ofPattern("yyyy", spanishLocale));
				lblFecha.setText(dia + " de " + mes + " de " + agno + " (Edad: "
						+ Math.abs(aux.getFechanacimiento().getYear() - LocalDate.now().getYear()) + ")");
				lbUni.setText(aux.getUniversidad());
				cargarEstadisticas(mijugador);
				Equipos e = LigaBeisbol.getInstance().BuscarPorNombre(aux.getEquipo());
				if(e.getJugador().size()==0){
					promedio.setText("");
				}else{
					NumberFormat formatter = new DecimalFormat(".000###");
					promedio.setText(""+formatter.format((double)e.promedioBateoEquipo()/100));
				}
				
				if(e.getJugador().size()==0){
					slg.setText("");
				}else{
					NumberFormat formatter = new DecimalFormat(".000###");
					slg.setText(""+formatter.format((double)e.porcenajeSLGequipo()/100));
				}
			}
		}
		
	}

	public static void cargarEstadisticas(String mijugador) {
		tablemodel4.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_4.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table_4.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table_4.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table_4.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table_4.getColumnModel().getColumn(4).setCellRenderer(tcr);
		table_4.getColumnModel().getColumn(5).setCellRenderer(tcr);
		table_4.getColumnModel().getColumn(6).setCellRenderer(tcr);
		table_4.getColumnModel().getColumn(7).setCellRenderer(tcr);
		table_4.getColumnModel().getColumn(8).setCellRenderer(tcr);
		table_4.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(5).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(6).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(7).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(8).setPreferredWidth(100);
		fila4 = new Object[tablemodel4.getColumnCount()];
		for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
			if (aux.getNombre().equalsIgnoreCase(mijugador)) {
				fila4[0] = aux.getEstadistica().getTurnosjugados();
				fila4[1] = aux.getEstadistica().getCarreraAnotadas();
				fila4[2] = aux.getEstadistica().getHits();
				fila4[3] = aux.getEstadistica().getDobles();
				fila4[4] = aux.getEstadistica().getTriples();
				fila4[5] = aux.getEstadistica().getHomeruns();
				fila4[6] = aux.getEstadistica().getRBI();
				fila4[7] = aux.getEstadistica().getBasebola();
				fila4[8] = aux.getEstadistica().obtenerPromedioBateo();
				tablemodel4.addRow(fila4);
			}
		}
	}
	public static void cargar(Equipos e){
		ImageIcon icon = new ImageIcon(RegistrarEquipo.route2);
		lbFoto_equipo.setIcon(icon);
		lblNewLabel.setIcon(icon);
		lblEquipo.setText(e.getNombre());
		lblNombreEquipo.setText(e.getNombre());
		lbManager.setText(e.getManager());
		lbRegion.setText(e.getRegion());
		lbAgnoEquipo.setText(e.getAgnocreacion());
		if(e.getJugador().size()==0){
			promedio.setText("");
		}else{
			NumberFormat formatter = new DecimalFormat(".000###");
			promedio.setText(""+formatter.format((double)e.promedioBateoEquipo()/100));
		}
		
		if(e.getJugador().size()==0){
			slg.setText("");
		}else{
			NumberFormat formatter = new DecimalFormat(".000###");
			slg.setText(""+formatter.format((double)e.porcenajeSLGequipo()/100));
		}
	}
}