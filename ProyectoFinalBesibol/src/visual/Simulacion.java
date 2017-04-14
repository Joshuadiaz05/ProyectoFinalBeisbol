package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import logical.Equipos;
import logical.Jugadores;
import logical.LigaBeisbol;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Simulacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int CLoc, CVis, CLocJ, CVisJ, HLoc, HVis, HLocJ, HVisJ;
	private JTextField textloccarreras;
	private JTextField textlochit;
	private JTextField textField_2;
	private JTextField textviscarreras;
	private JTextField textvishit;
	private JTextField textField_5;
	private JSpinner CLoc1, CLoc2, CLoc3, CLoc4, CLoc5, CLoc6, CLoc7, CLoc8, CLoc9;
	private JSpinner CVis1, CVis2, CVis3, CVis4, CVis5, CVis6, CVis7, CVis8, CVis9;
	private JSpinner TBv1, TBv2, TBv3, TBv4, TBv5, TBv6, TBv7, TBv8, TBv9;
	private JSpinner TBh1, TBh2, TBh3, TBh4, TBh5, TBh6, TBh7, TBh8, TBh9;
	private JSpinner HLocJ1, HLocJ2, HLocJ3, HLocJ4, HLocJ5, HLocJ6, HLocJ7, HLocJ8, HLocJ9;
	private JSpinner TBLocJ1, TBLocJ2, TBLocJ3, TBLocJ4, TBLocJ5, TBLocJ6, TBLocJ7, TBLocJ8, TBLocJ9;
	private JButton btnEquipoLocal;
	private JPanel panel_11;
	private JButton btnCancelar;
	private JButton btnFinalizarPartido;
	private JButton button_1;
	private JLabel lblFinalizarPartido;
	private JLabel lblImprimir;
	private JLabel lblSalir;
	private JSeparator separator_2;
	private JLabel labelPosiciones;
	private int carrerasTotal = 0;
	private int carreras1, carreras2;

	public Simulacion(String local, String visita) {
		setTitle(" Simulacion");
		setBounds(100, 100, 858, 826);
		Equipos equipolocal = LigaBeisbol.getInstance().BuscarPorNombre(local);
		Equipos equipovisita = LigaBeisbol.getInstance().BuscarPorNombre(visita);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 822, 704);
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("    1        2       3       4        5        6       7        8       9");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(144, 483, 506, 22);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 508, 805, 180);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(15, 16, 625, 72);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(15, 25, 74, 28);
		panel_2.add(lblLocal);
		lblLocal.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

		CLoc1 = new JSpinner();
		CLoc1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc1.getValue().toString()) + Integer.valueOf(CLoc2.getValue().toString())
						+ Integer.valueOf(CLoc3.getValue().toString()) + Integer.valueOf(CLoc4.getValue().toString())
						+ Integer.valueOf(CLoc5.getValue().toString()) + Integer.valueOf(CLoc6.getValue().toString())
						+ Integer.valueOf(CLoc7.getValue().toString()) + Integer.valueOf(CLoc8.getValue().toString())
						+ Integer.valueOf(CLoc9.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc1.setBounds(131, 20, 44, 39);
		panel_2.add(CLoc1);

		CLoc2 = new JSpinner();
		CLoc2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc1.getValue().toString()) + Integer.valueOf(CLoc2.getValue().toString())
						+ Integer.valueOf(CLoc3.getValue().toString()) + Integer.valueOf(CLoc4.getValue().toString())
						+ Integer.valueOf(CLoc5.getValue().toString()) + Integer.valueOf(CLoc6.getValue().toString())
						+ Integer.valueOf(CLoc7.getValue().toString()) + Integer.valueOf(CLoc8.getValue().toString())
						+ Integer.valueOf(CLoc9.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc2.setBounds(186, 20, 44, 39);
		panel_2.add(CLoc2);

		CLoc3 = new JSpinner();
		CLoc3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc1.getValue().toString()) + Integer.valueOf(CLoc2.getValue().toString())
						+ Integer.valueOf(CLoc3.getValue().toString()) + Integer.valueOf(CLoc4.getValue().toString())
						+ Integer.valueOf(CLoc5.getValue().toString()) + Integer.valueOf(CLoc6.getValue().toString())
						+ Integer.valueOf(CLoc7.getValue().toString()) + Integer.valueOf(CLoc8.getValue().toString())
						+ Integer.valueOf(CLoc9.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc3.setBounds(241, 20, 44, 39);
		panel_2.add(CLoc3);

		CLoc4 = new JSpinner();
		CLoc4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc1.getValue().toString()) + Integer.valueOf(CLoc2.getValue().toString())
						+ Integer.valueOf(CLoc3.getValue().toString()) + Integer.valueOf(CLoc4.getValue().toString())
						+ Integer.valueOf(CLoc5.getValue().toString()) + Integer.valueOf(CLoc6.getValue().toString())
						+ Integer.valueOf(CLoc7.getValue().toString()) + Integer.valueOf(CLoc8.getValue().toString())
						+ Integer.valueOf(CLoc9.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc4.setBounds(296, 20, 44, 39);
		panel_2.add(CLoc4);

		CLoc5 = new JSpinner();
		CLoc5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc1.getValue().toString()) + Integer.valueOf(CLoc2.getValue().toString())
						+ Integer.valueOf(CLoc3.getValue().toString()) + Integer.valueOf(CLoc4.getValue().toString())
						+ Integer.valueOf(CLoc5.getValue().toString()) + Integer.valueOf(CLoc6.getValue().toString())
						+ Integer.valueOf(CLoc7.getValue().toString()) + Integer.valueOf(CLoc8.getValue().toString())
						+ Integer.valueOf(CLoc9.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc5.setBounds(350, 20, 44, 39);
		panel_2.add(CLoc5);

		CLoc6 = new JSpinner();
		CLoc6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc1.getValue().toString()) + Integer.valueOf(CLoc2.getValue().toString())
						+ Integer.valueOf(CLoc3.getValue().toString()) + Integer.valueOf(CLoc4.getValue().toString())
						+ Integer.valueOf(CLoc5.getValue().toString()) + Integer.valueOf(CLoc6.getValue().toString())
						+ Integer.valueOf(CLoc7.getValue().toString()) + Integer.valueOf(CLoc8.getValue().toString())
						+ Integer.valueOf(CLoc9.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc6.setBounds(406, 20, 44, 39);
		panel_2.add(CLoc6);

		CLoc7 = new JSpinner();
		CLoc7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc1.getValue().toString()) + Integer.valueOf(CLoc2.getValue().toString())
						+ Integer.valueOf(CLoc3.getValue().toString()) + Integer.valueOf(CLoc4.getValue().toString())
						+ Integer.valueOf(CLoc5.getValue().toString()) + Integer.valueOf(CLoc6.getValue().toString())
						+ Integer.valueOf(CLoc7.getValue().toString()) + Integer.valueOf(CLoc8.getValue().toString())
						+ Integer.valueOf(CLoc9.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc7.setBounds(462, 20, 44, 39);
		panel_2.add(CLoc7);

		JSpinner CLoc8 = new JSpinner();
		CLoc8.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc1.getValue().toString()) + Integer.valueOf(CLoc2.getValue().toString())
						+ Integer.valueOf(CLoc3.getValue().toString()) + Integer.valueOf(CLoc4.getValue().toString())
						+ Integer.valueOf(CLoc5.getValue().toString()) + Integer.valueOf(CLoc6.getValue().toString())
						+ Integer.valueOf(CLoc7.getValue().toString()) + Integer.valueOf(CLoc8.getValue().toString())
						+ Integer.valueOf(CLoc9.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc8.setBounds(518, 20, 44, 39);
		panel_2.add(CLoc8);

		JSpinner CLoc9 = new JSpinner();
		CLoc9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc1.getValue().toString()) + Integer.valueOf(CLoc2.getValue().toString())
						+ Integer.valueOf(CLoc3.getValue().toString()) + Integer.valueOf(CLoc4.getValue().toString())
						+ Integer.valueOf(CLoc5.getValue().toString()) + Integer.valueOf(CLoc6.getValue().toString())
						+ Integer.valueOf(CLoc7.getValue().toString()) + Integer.valueOf(CLoc8.getValue().toString())
						+ Integer.valueOf(CLoc9.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc9.setBounds(572, 20, 44, 39);
		panel_2.add(CLoc9);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(15, 92, 625, 72);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblVisitantes = new JLabel("Visitantes");
		lblVisitantes.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblVisitantes.setBounds(15, 28, 105, 28);
		panel_3.add(lblVisitantes);

		CVis1 = new JSpinner();
		CVis1.setBounds(130, 17, 44, 39);
		panel_3.add(CVis1);

		CVis2 = new JSpinner();
		CVis2.setBounds(185, 17, 44, 39);
		panel_3.add(CVis2);

		CVis3 = new JSpinner();
		CVis3.setBounds(240, 17, 44, 39);
		panel_3.add(CVis3);

		CVis4 = new JSpinner();
		CVis4.setBounds(295, 17, 44, 39);
		panel_3.add(CVis4);

		CVis5 = new JSpinner();
		CVis5.setBounds(349, 17, 44, 39);
		panel_3.add(CVis5);

		CVis6 = new JSpinner();
		CVis6.setBounds(405, 17, 44, 39);
		panel_3.add(CVis6);

		CVis7 = new JSpinner();
		CVis7.setBounds(461, 17, 44, 39);
		panel_3.add(CVis7);

		CVis8 = new JSpinner();
		CVis8.setBounds(517, 17, 44, 39);
		panel_3.add(CVis8);

		CVis9 = new JSpinner();
		CVis9.setBounds(571, 17, 44, 39);
		panel_3.add(CVis9);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(645, 16, 142, 148);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		textloccarreras = new JTextField();
		textloccarreras.setBounds(6, 17, 42, 45);
		panel_4.add(textloccarreras);
		textloccarreras.setColumns(10);

		textlochit = new JTextField();
		textlochit.setColumns(10);
		textlochit.setBounds(50, 17, 42, 45);
		panel_4.add(textlochit);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 17, 42, 45);
		panel_4.add(textField_2);

		textviscarreras = new JTextField();
		textviscarreras.setColumns(10);
		textviscarreras.setBounds(6, 95, 42, 45);
		panel_4.add(textviscarreras);

		textvishit = new JTextField();
		textvishit.setColumns(10);
		textvishit.setBounds(50, 95, 42, 45);
		panel_4.add(textvishit);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(94, 95, 42, 45);
		panel_4.add(textField_5);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 74, 130, 2);
		panel_4.add(separator);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBounds(10, 11, 269, 433);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 40, 113, 388);
		panel_5.add(panel_7);
		panel_7.setLayout(null);

		Jugadores pitcher = equipolocal.buscarJugadorbyposicion("Pitcher");
		JLabel lblJugador_5 = new JLabel();
		if (pitcher == null) {
			lblJugador_5.setText("Pitcher");
		} else {
			lblJugador_5.setText("" + pitcher.getNombre() + " " + pitcher.getApellido());
		}
		lblJugador_5.setBounds(6, 358, 119, 20);
		panel_7.add(lblJugador_5);

		Jugadores centerfield = equipolocal.buscarJugadorbyposicion("Center fielder");
		JLabel lblJugador_2 = new JLabel();
		if (centerfield == null) {
			lblJugador_2.setText("Center Fielder");
		} else {
			lblJugador_2.setText("" + centerfield.getNombre() + " " + centerfield.getApellido());
		}
		lblJugador_2.setBounds(6, 315, 119, 20);
		panel_7.add(lblJugador_2);

		Jugadores leftfield = equipolocal.buscarJugadorbyposicion("Left fielder");
		JLabel lblJugador = new JLabel();
		if (leftfield == null) {
			lblJugador.setText("Left Fielder");
		} else {
			lblJugador.setText("" + leftfield.getNombre() + " " + leftfield.getApellido());
		}
		lblJugador.setBounds(6, 274, 119, 20);
		panel_7.add(lblJugador);

		Jugadores rigthfield = equipolocal.buscarJugadorbyposicion("Rigth fielder");
		JLabel label_11 = new JLabel();
		if (rigthfield == null) {
			label_11.setText("Rigth Fielder");
		} else {
			label_11.setText("" + rigthfield.getNombre() + " " + rigthfield.getApellido());
		}
		label_11.setBounds(6, 234, 119, 20);
		panel_7.add(label_11);

		Jugadores shortstop = equipolocal.buscarJugadorbyposicion("Short stop");
		JLabel label_12 = new JLabel();
		if (shortstop == null) {
			label_12.setText("Short Stop");
		} else {
			label_12.setText("" + shortstop.getNombre() + " " + shortstop.getApellido());
		}
		label_12.setBounds(6, 193, 101, 20);
		panel_7.add(label_12);

		Jugadores TerceraBase = equipolocal.buscarJugadorbyposicion("Tercera base");
		JLabel label_13 = new JLabel();
		if (TerceraBase == null) {
			label_13.setText("Tercera Base");
		} else {
			label_13.setText("" + TerceraBase.getNombre() + " " + TerceraBase.getApellido());
		}
		label_13.setBounds(6, 154, 119, 20);
		panel_7.add(label_13);

		Jugadores segundabase = equipolocal.buscarJugadorbyposicion("Segunda base");
		JLabel label_14 = new JLabel();
		if (segundabase == null) {
			label_14.setText("Segunda Base");
		} else {
			label_14.setText("" + segundabase.getNombre() + " " + segundabase.getApellido());
		}
		label_14.setBounds(6, 111, 119, 20);
		panel_7.add(label_14);

		Jugadores primerabase = equipolocal.buscarJugadorbyposicion("Primera base");
		JLabel label_15 = new JLabel();
		if (primerabase == null) {
			label_15.setText("Primera Base");
		} else {
			label_15.setText("" + primerabase.getNombre() + " " + primerabase.getApellido());
		}
		label_15.setBounds(6, 72, 119, 20);
		panel_7.add(label_15);

		Jugadores catcher = equipolocal.buscarJugadorbyposicion("Catcher");
		JLabel labeljugador1 = new JLabel();
		if (catcher == null) {
			labeljugador1.setText("Catcher");
		} else {
			labeljugador1.setText("" + catcher.getNombre() + " " + catcher.getApellido());
		}
		labeljugador1.setBounds(6, 32, 119, 20);
		panel_7.add(labeljugador1);

		JLabel lblJugadores = new JLabel("Jugadores Locales");
		lblJugadores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJugadores.setBounds(3, 6, 122, 20);
		panel_7.add(lblJugadores);

		separator_2 = new JSeparator();
		separator_2.setBounds(3, 25, 104, 2);
		panel_7.add(separator_2);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(133, 40, 126, 388);
		panel_5.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblTbHHr = new JLabel("    TB               H    ");
		lblTbHHr.setBounds(10, 6, 106, 20);
		panel_8.add(lblTbHHr);
		lblTbHHr.setFont(new Font("Tahoma", Font.BOLD, 11));

		JSpinner TBLocJ1 = new JSpinner();
		TBLocJ1.setBounds(10, 26, 36, 32);
		panel_8.add(TBLocJ1);

		HLocJ1 = new JSpinner();
		HLocJ1.setBounds(69, 26, 36, 32);
		panel_8.add(HLocJ1);

		HLocJ9 = new JSpinner();
		HLocJ9.setBounds(69, 352, 36, 32);
		panel_8.add(HLocJ9);

		HLocJ2 = new JSpinner();
		HLocJ2.setBounds(69, 66, 36, 32);
		panel_8.add(HLocJ2);

		HLocJ3 = new JSpinner();
		HLocJ3.setBounds(69, 106, 36, 32);
		panel_8.add(HLocJ3);

		HLocJ4 = new JSpinner();
		HLocJ4.setBounds(69, 145, 36, 32);
		panel_8.add(HLocJ4);

		HLocJ5 = new JSpinner();
		HLocJ5.setBounds(69, 185, 36, 32);
		panel_8.add(HLocJ5);

		HLocJ6 = new JSpinner();
		HLocJ6.setBounds(69, 226, 36, 32);
		panel_8.add(HLocJ6);

		HLocJ7 = new JSpinner();
		HLocJ7.setBounds(69, 268, 36, 32);
		panel_8.add(HLocJ7);

		HLocJ8 = new JSpinner();
		HLocJ8.setBounds(69, 310, 36, 32);
		panel_8.add(HLocJ8);

		TBLocJ9 = new JSpinner();
		TBLocJ9.setBounds(10, 352, 36, 32);
		panel_8.add(TBLocJ9);

		TBLocJ4 = new JSpinner();
		TBLocJ4.setBounds(10, 145, 36, 32);
		panel_8.add(TBLocJ4);

		TBLocJ6 = new JSpinner();
		TBLocJ6.setBounds(10, 226, 36, 32);
		panel_8.add(TBLocJ6);

		TBLocJ5 = new JSpinner();
		TBLocJ5.setBounds(10, 185, 36, 32);
		panel_8.add(TBLocJ5);

		TBLocJ3 = new JSpinner();
		TBLocJ3.setBounds(10, 106, 36, 32);
		panel_8.add(TBLocJ3);

		TBLocJ2 = new JSpinner();
		TBLocJ2.setBounds(10, 66, 36, 32);
		panel_8.add(TBLocJ2);

		TBLocJ8 = new JSpinner();
		TBLocJ8.setBounds(10, 310, 36, 32);
		panel_8.add(TBLocJ8);

		TBLocJ7 = new JSpinner();
		TBLocJ7.setBounds(10, 268, 36, 32);
		panel_8.add(TBLocJ7);

		btnEquipoLocal = new JButton("" + equipolocal.getNombre());
		btnEquipoLocal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEquipoLocal.setBounds(66, 6, 171, 30);
		panel_5.add(btnEquipoLocal);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setLayout(null);
		panel_6.setBounds(517, 11, 269, 433);
		panel.add(panel_6);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setLayout(null);
		panel_9.setBounds(10, 40, 113, 388);
		panel_6.add(panel_9);

		Jugadores pitcherv = equipovisita.buscarJugadorbyposicion("Pitcher");
		JLabel label_4 = new JLabel();
		if (pitcherv == null) {
			label_4.setText("Pitcher");
		} else {
			label_4.setText("" + pitcherv.getNombre() + " " + pitcherv.getApellido());
		}
		label_4.setBounds(6, 358, 119, 20);
		panel_9.add(label_4);

		Jugadores centerfieldv = equipovisita.buscarJugadorbyposicion("Center fielder");
		JLabel label_5 = new JLabel();
		if (centerfieldv == null) {
			label_5.setText("Center Fielder");
		} else {
			label_5.setText("" + centerfieldv.getNombre() + " " + centerfieldv.getApellido());
		}
		label_5.setBounds(6, 315, 119, 20);
		panel_9.add(label_5);

		Jugadores leftfieldv = equipovisita.buscarJugadorbyposicion("Left fielder");
		JLabel label_6 = new JLabel();
		if (leftfieldv == null) {
			label_6.setText("Left Fielder");
		} else {
			label_6.setText("" + leftfieldv.getNombre() + " " + leftfieldv.getApellido());
		}
		label_6.setBounds(6, 274, 119, 20);
		panel_9.add(label_6);

		Jugadores rigthfieldv = equipovisita.buscarJugadorbyposicion("Rigth fielder");
		JLabel label_7 = new JLabel();
		if (rigthfieldv == null) {
			label_7.setText("Rigth Fielder");
		} else {
			label_7.setText("" + rigthfieldv.getNombre() + " " + rigthfieldv.getApellido());
		}
		label_7.setBounds(6, 234, 119, 20);
		panel_9.add(label_7);

		Jugadores shortstopv = equipovisita.buscarJugadorbyposicion("Short stop");
		JLabel label_8 = new JLabel();
		if (shortstopv == null) {
			label_8.setText("Short Stop");
		} else {
			label_8.setText("" + shortstopv.getNombre() + " " + shortstopv.getApellido());
		}
		label_8.setBounds(6, 193, 119, 20);
		panel_9.add(label_8);

		Jugadores tercerabasev = equipovisita.buscarJugadorbyposicion("Tercera base");
		JLabel label_9 = new JLabel();
		if (tercerabasev == null) {
			label_9.setText("Tercera Base");
		} else {
			label_9.setText("" + tercerabasev.getNombre() + " " + tercerabasev.getApellido());
		}
		label_9.setBounds(6, 154, 119, 20);
		panel_9.add(label_9);

		Jugadores segundabasev = equipovisita.buscarJugadorbyposicion("Segunda base");
		JLabel label_10 = new JLabel();
		if (segundabasev == null) {
			label_10.setText("Segunda Base");
		} else {
			label_10.setText("" + segundabasev.getNombre() + " " + segundabasev.getApellido());
		}
		label_10.setBounds(6, 111, 119, 20);
		panel_9.add(label_10);

		Jugadores primerabasev = equipovisita.buscarJugadorbyposicion("Primera base");
		JLabel label_17 = new JLabel();
		if (primerabasev == null) {
			label_17.setText("Primera Base");
		} else {
			label_17.setText("" + primerabasev.getNombre() + " " + primerabasev.getApellido());
		}
		label_17.setBounds(6, 72, 119, 20);
		panel_9.add(label_17);

		Jugadores catcherv = equipovisita.buscarJugadorbyposicion("Catcher");
		JLabel label_18 = new JLabel();
		if (catcherv == null) {
			label_18.setText("Catcher");
		} else {
			label_18.setText("" + catcherv.getNombre() + " " + catcherv.getApellido());
		}
		label_18.setBounds(6, 32, 119, 20);
		panel_9.add(label_18);

		JLabel lblJugadoresVisitantes = new JLabel("Jugadores Visita");
		lblJugadoresVisitantes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJugadoresVisitantes.setBounds(3, 6, 106, 20);
		panel_9.add(lblJugadoresVisitantes);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(4, 25, 104, 2);
		panel_9.add(separator_1);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setLayout(null);
		panel_10.setBounds(133, 40, 126, 388);
		panel_6.add(panel_10);

		JLabel label_20 = new JLabel("    TB               H    ");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_20.setBounds(10, 6, 106, 20);
		panel_10.add(label_20);

		TBv1 = new JSpinner();
		TBv1.setBounds(10, 26, 36, 32);
		panel_10.add(TBv1);

		TBh1 = new JSpinner();
		TBh1.setBounds(69, 26, 36, 32);
		panel_10.add(TBh1);

		TBh9 = new JSpinner();
		TBh9.setBounds(69, 352, 36, 32);
		panel_10.add(TBh9);

		TBh2 = new JSpinner();
		TBh2.setBounds(69, 66, 36, 32);
		panel_10.add(TBh2);

		TBh3 = new JSpinner();
		TBh3.setBounds(69, 106, 36, 32);
		panel_10.add(TBh3);

		TBh4 = new JSpinner();
		TBh4.setBounds(69, 145, 36, 32);
		panel_10.add(TBh4);

		TBh5 = new JSpinner();
		TBh5.setBounds(69, 185, 36, 32);
		panel_10.add(TBh5);

		TBh6 = new JSpinner();
		TBh6.setBounds(69, 226, 36, 32);
		panel_10.add(TBh6);

		TBh7 = new JSpinner();
		TBh7.setBounds(69, 268, 36, 32);
		panel_10.add(TBh7);

		TBh8 = new JSpinner();
		TBh8.setBounds(69, 310, 36, 32);
		panel_10.add(TBh8);

		TBv9 = new JSpinner();
		TBv9.setBounds(10, 352, 36, 32);
		panel_10.add(TBv9);

		TBv4 = new JSpinner();
		TBv4.setBounds(10, 145, 36, 32);
		panel_10.add(TBv4);

		TBv6 = new JSpinner();
		TBv6.setBounds(10, 226, 36, 32);
		panel_10.add(TBv6);

		TBv5 = new JSpinner();
		TBv5.setBounds(10, 185, 36, 32);
		panel_10.add(TBv5);

		TBv3 = new JSpinner();
		TBv3.setBounds(10, 106, 36, 32);
		panel_10.add(TBv3);

		TBv2 = new JSpinner();
		TBv2.setBounds(10, 66, 36, 32);
		panel_10.add(TBv2);

		TBv8 = new JSpinner();
		TBv8.setBounds(10, 310, 36, 32);
		panel_10.add(TBv8);

		TBv7 = new JSpinner();
		TBv7.setBounds(10, 268, 36, 32);
		panel_10.add(TBv7);

		JButton btnEquipoVisitante = new JButton("" + equipovisita.getNombre());
		btnEquipoVisitante.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEquipoVisitante.setBounds(40, 6, 182, 30);
		panel_6.add(btnEquipoVisitante);

		JLabel label_1 = new JLabel("C");
		label_1.setBounds(672, 484, 17, 20);
		panel.add(label_1);
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

		JLabel label_2 = new JLabel("H");
		label_2.setBounds(717, 484, 17, 20);
		panel.add(label_2);
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

		JLabel lblE = new JLabel("E");
		lblE.setBounds(760, 484, 17, 20);
		panel.add(lblE);
		lblE.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

		labelPosiciones = new JLabel("");
		labelPosiciones.setBounds(289, 152, 218, 180);
		panel.add(labelPosiciones);
		labelPosiciones.setIcon(new ImageIcon("img/campoposicion.png"));

		panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(0, 734, 842, 53);
		contentPanel.add(panel_11);
		panel_11.setLayout(null);

		btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon("img/saliend.png"));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblSalir.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSalir.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnCancelar.setBounds(770, 6, 50, 40);
		panel_11.add(btnCancelar);

		btnFinalizarPartido = new JButton("");
		btnFinalizarPartido.setIcon(new ImageIcon("img/finish.png"));
		btnFinalizarPartido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblFinalizarPartido.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFinalizarPartido.setVisible(false);
			}
		});
		btnFinalizarPartido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnFinalizarPartido.setBounds(670, 6, 90, 40);
		panel_11.add(btnFinalizarPartido);

		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("img/impres.png"));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblImprimir.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblImprimir.setVisible(true);
			}
		});
		button_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		button_1.setBounds(570, 6, 90, 40);
		panel_11.add(button_1);

		lblFinalizarPartido = new JLabel("Finalizar Partido");
		lblFinalizarPartido.setVisible(false);
		lblFinalizarPartido.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblFinalizarPartido.setBounds(650, 719, 111, 14);
		contentPanel.add(lblFinalizarPartido);

		lblImprimir = new JLabel("Imprimir");
		lblImprimir.setVisible(false);
		lblImprimir.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblImprimir.setBounds(570, 719, 62, 14);
		contentPanel.add(lblImprimir);

		lblSalir = new JLabel("Salir");
		lblSalir.setVisible(false);
		lblSalir.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblSalir.setBounds(770, 719, 46, 14);
		contentPanel.add(lblSalir);
	}
}
