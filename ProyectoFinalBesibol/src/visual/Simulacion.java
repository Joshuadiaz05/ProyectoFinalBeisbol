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
import javax.swing.JOptionPane;

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
import logical.Partido;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Simulacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int CLoc, CVis, CLocJ, CVisJ, HLoc, HVis, HLocJ, HVisJ;
	private JTextField textloccarreras;
	private JTextField textlochit;
	private JTextField textField_2;
	private JTextField textviscarreras;
	private JTextField textvishit;
	private JTextField textField_5;
	private JSpinner CLoc1, CLoc2, CLoc3, CLoc4, CLoc5, CLoc6, CLoc7, spinner, spinner_1;
	private JSpinner CVis1, CVis2, CVis3, CVis4, CVis5, CVis6, CVis7, CVis8, CVis9;
	private JSpinner TBv1, TBv2, TBv3, TBv4, TBv5, TBv6, TBv7, TBv8, TBv9; //Turnos al bate Visitantes
	private JSpinner TBh1, TBh2, TBh3, TBh4, TBh5, TBh6, TBh7, TBh8, TBh9; //Hits al bate visitantes
	private JSpinner HLocJ1, HLocJ2, HLocJ3, HLocJ4, HLocJ5, HLocJ6, HLocJ7, HLocJ8, HLocJ9; //Spinner Hits Local
	private JSpinner TBLocJ1, TBLocJ2, TBLocJ3, TBLocJ4, TBLocJ5, TBLocJ6, TBLocJ7, TBLocJ8, TBLocJ9; //Spinner Turnos al Bate Local
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
	private int CarrerasTotalV = 0;
	private int totallocalhit = 0;
	private int totalvisitahit = 0;
	private JLabel label_tb_H, lblJugadoresVisitantes, Jv1, Jv2, Jv3, Jv4, Jv5, Jv6, Jv7, Jv8, Jv9, fechaV; //nombres de los visitantes
	private JLabel fechaL, JL1, JL2, JL3, JL4, JL5, JL6, JL7, JL8, JL9, lblJugadores, label_tb_HLocal; //nombres de los locales
	private Jugadores leftfield, primerabase, segundabase, TerceraBase, catcher, shortstop, centerfield, rigthfield, bateadesignado; //Jugadores Locales
	private Jugadores leftfieldv, primerabasev, segundabasev, tercerabasev, catcherv, shortstopv, centerfieldv, rigthfieldv, bateadesignadov; //Jugadores Visitantes
	private int tlcatcher, tlpb, tlsb, tltb, tlss, tllf, tlrf, tlcf, tlbd; //Guardan los turnos al bate de los Locales
	private int hlcatcher, hlpb, hlsb, hltb, hlss, hllf, hlrf, hlcf, hlbd; //Guardan los Hits de los Locales
	private int tvcatcher, tvpb, tvsb, tvtb, tvss, tvlf, tvrf, tvcf, tvbd; //Guardan turnos al bate de los Visitantes
	private int hvcatcher, hvpb, hvsb, hvtb, hvss, hvlf, hvrf, hvcf, hvbd; //Guardan Hits de los Visitantes
	private JLabel Centerv;
	private JLabel Rigthv;
	private JLabel Lefthv;
	private JLabel SBv;
	private JLabel TBv;
	private JLabel PBv;
	private JLabel CTHv;
	private JLabel SSv;
	private JLabel lblEnDefensa;
	
	public Simulacion(String local, String visita, Partido partido) {
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
		CLoc1.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		CLoc1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc2.getValue().toString()) + Integer.valueOf(CLoc3.getValue().toString())
						+ Integer.valueOf(CLoc4.getValue().toString()) + Integer.valueOf(CLoc5.getValue().toString())
						+ Integer.valueOf(CLoc6.getValue().toString()) + Integer.valueOf(CLoc7.getValue().toString())
						+ Integer.valueOf(spinner.getValue().toString()) + Integer.valueOf(spinner_1.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc1.setBounds(131, 20, 44, 39);
		panel_2.add(CLoc1);

		CLoc2 = new JSpinner();
		CLoc2.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		CLoc2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc2.getValue().toString()) + Integer.valueOf(CLoc3.getValue().toString())
						+ Integer.valueOf(CLoc4.getValue().toString()) + Integer.valueOf(CLoc5.getValue().toString())
						+ Integer.valueOf(CLoc6.getValue().toString()) + Integer.valueOf(CLoc7.getValue().toString())
						+ Integer.valueOf(spinner.getValue().toString()) + Integer.valueOf(spinner_1.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc2.setBounds(186, 20, 44, 39);
		panel_2.add(CLoc2);

		CLoc3 = new JSpinner();
		CLoc3.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		CLoc3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc2.getValue().toString()) + Integer.valueOf(CLoc3.getValue().toString())
						+ Integer.valueOf(CLoc4.getValue().toString()) + Integer.valueOf(CLoc5.getValue().toString())
						+ Integer.valueOf(CLoc6.getValue().toString()) + Integer.valueOf(CLoc7.getValue().toString())
						+ Integer.valueOf(spinner.getValue().toString()) + Integer.valueOf(spinner_1.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc3.setBounds(241, 20, 44, 39);
		panel_2.add(CLoc3);

		CLoc4 = new JSpinner();
		CLoc4.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		CLoc4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc2.getValue().toString()) + Integer.valueOf(CLoc3.getValue().toString())
						+ Integer.valueOf(CLoc4.getValue().toString()) + Integer.valueOf(CLoc5.getValue().toString())
						+ Integer.valueOf(CLoc6.getValue().toString()) + Integer.valueOf(CLoc7.getValue().toString())
						+ Integer.valueOf(spinner.getValue().toString()) + Integer.valueOf(spinner_1.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc4.setBounds(296, 20, 44, 39);
		panel_2.add(CLoc4);

		CLoc5 = new JSpinner();
		CLoc5.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		CLoc5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc2.getValue().toString()) + Integer.valueOf(CLoc3.getValue().toString())
						+ Integer.valueOf(CLoc4.getValue().toString()) + Integer.valueOf(CLoc5.getValue().toString())
						+ Integer.valueOf(CLoc6.getValue().toString()) + Integer.valueOf(CLoc7.getValue().toString())
						+ Integer.valueOf(spinner.getValue().toString()) + Integer.valueOf(spinner_1.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc5.setBounds(350, 20, 44, 39);
		panel_2.add(CLoc5);

		CLoc6 = new JSpinner();
		CLoc6.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		CLoc6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc2.getValue().toString()) + Integer.valueOf(CLoc3.getValue().toString())
						+ Integer.valueOf(CLoc4.getValue().toString()) + Integer.valueOf(CLoc5.getValue().toString())
						+ Integer.valueOf(CLoc6.getValue().toString()) + Integer.valueOf(CLoc7.getValue().toString())
						+ Integer.valueOf(spinner.getValue().toString()) + Integer.valueOf(spinner_1.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc6.setBounds(406, 20, 44, 39);
		panel_2.add(CLoc6);

		CLoc7 = new JSpinner();
		CLoc7.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		CLoc7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc2.getValue().toString()) + Integer.valueOf(CLoc3.getValue().toString())
						+ Integer.valueOf(CLoc4.getValue().toString()) + Integer.valueOf(CLoc5.getValue().toString())
						+ Integer.valueOf(CLoc6.getValue().toString()) + Integer.valueOf(CLoc7.getValue().toString())
						+ Integer.valueOf(spinner.getValue().toString()) + Integer.valueOf(spinner_1.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		CLoc7.setBounds(462, 20, 44, 39);
		panel_2.add(CLoc7);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc2.getValue().toString()) + Integer.valueOf(CLoc3.getValue().toString())
						+ Integer.valueOf(CLoc4.getValue().toString()) + Integer.valueOf(CLoc5.getValue().toString())
						+ Integer.valueOf(CLoc6.getValue().toString()) + Integer.valueOf(CLoc7.getValue().toString())
						+ Integer.valueOf(spinner.getValue().toString()) + Integer.valueOf(spinner_1.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		spinner.setBounds(518, 20, 44, 39);
		panel_2.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				carrerasTotal = Integer.valueOf(CLoc1.getValue().toString())
						+ Integer.valueOf(CLoc2.getValue().toString()) + Integer.valueOf(CLoc3.getValue().toString())
						+ Integer.valueOf(CLoc4.getValue().toString()) + Integer.valueOf(CLoc5.getValue().toString())
						+ Integer.valueOf(CLoc6.getValue().toString()) + Integer.valueOf(CLoc7.getValue().toString())
						+ Integer.valueOf(spinner.getValue().toString()) + Integer.valueOf(spinner_1.getValue().toString());
				textloccarreras.setText("" + carrerasTotal);
			}
		});
		spinner_1.setBounds(572, 20, 44, 39);
		panel_2.add(spinner_1);

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
		CVis1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		CVis1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CarrerasTotalV = Integer.valueOf(CVis1.getValue().toString()) + Integer.valueOf(CVis2.getValue().toString())
					+ Integer.valueOf(CVis3.getValue().toString()) + Integer.valueOf(CVis4.getValue().toString())
					+ Integer.valueOf(CVis5.getValue().toString()) + Integer.valueOf(CVis6.getValue().toString())
					+ Integer.valueOf(CVis7.getValue().toString()) + Integer.valueOf(CVis8.getValue().toString())
					+ Integer.valueOf(CVis9.getValue().toString());
				textviscarreras.setText("" + CarrerasTotalV);
			}
		});
		CVis1.setBounds(130, 17, 44, 39);
		panel_3.add(CVis1);

		CVis2 = new JSpinner();
		CVis2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		CVis2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CarrerasTotalV = Integer.valueOf(CVis1.getValue().toString()) + Integer.valueOf(CVis2.getValue().toString())
				+ Integer.valueOf(CVis3.getValue().toString()) + Integer.valueOf(CVis4.getValue().toString())
				+ Integer.valueOf(CVis5.getValue().toString()) + Integer.valueOf(CVis6.getValue().toString())
				+ Integer.valueOf(CVis7.getValue().toString()) + Integer.valueOf(CVis8.getValue().toString())
				+ Integer.valueOf(CVis9.getValue().toString());
			textviscarreras.setText("" + CarrerasTotalV);
			}
		});
		CVis2.setBounds(185, 17, 44, 39);
		panel_3.add(CVis2);

		CVis3 = new JSpinner();
		CVis3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		CVis3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CarrerasTotalV = Integer.valueOf(CVis1.getValue().toString()) + Integer.valueOf(CVis2.getValue().toString())
				+ Integer.valueOf(CVis3.getValue().toString()) + Integer.valueOf(CVis4.getValue().toString())
				+ Integer.valueOf(CVis5.getValue().toString()) + Integer.valueOf(CVis6.getValue().toString())
				+ Integer.valueOf(CVis7.getValue().toString()) + Integer.valueOf(CVis8.getValue().toString())
				+ Integer.valueOf(CVis9.getValue().toString());
			textviscarreras.setText("" + CarrerasTotalV);
			}
		});
		CVis3.setBounds(240, 17, 44, 39);
		panel_3.add(CVis3);

		CVis4 = new JSpinner();
		CVis4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CarrerasTotalV = Integer.valueOf(CVis1.getValue().toString()) + Integer.valueOf(CVis2.getValue().toString())
				+ Integer.valueOf(CVis3.getValue().toString()) + Integer.valueOf(CVis4.getValue().toString())
				+ Integer.valueOf(CVis5.getValue().toString()) + Integer.valueOf(CVis6.getValue().toString())
				+ Integer.valueOf(CVis7.getValue().toString()) + Integer.valueOf(CVis8.getValue().toString())
				+ Integer.valueOf(CVis9.getValue().toString());
			textviscarreras.setText("" + CarrerasTotalV);
			}
		});
		CVis4.setBounds(295, 17, 44, 39);
		panel_3.add(CVis4);

		CVis5 = new JSpinner();
		CVis5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		CVis5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CarrerasTotalV = Integer.valueOf(CVis1.getValue().toString()) + Integer.valueOf(CVis2.getValue().toString())
				+ Integer.valueOf(CVis3.getValue().toString()) + Integer.valueOf(CVis4.getValue().toString())
				+ Integer.valueOf(CVis5.getValue().toString()) + Integer.valueOf(CVis6.getValue().toString())
				+ Integer.valueOf(CVis7.getValue().toString()) + Integer.valueOf(CVis8.getValue().toString())
				+ Integer.valueOf(CVis9.getValue().toString());
			textviscarreras.setText("" + CarrerasTotalV);
			}
		});
		CVis5.setBounds(349, 17, 44, 39);
		panel_3.add(CVis5);

		CVis6 = new JSpinner();
		CVis6.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		CVis6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CarrerasTotalV = Integer.valueOf(CVis1.getValue().toString()) + Integer.valueOf(CVis2.getValue().toString())
				+ Integer.valueOf(CVis3.getValue().toString()) + Integer.valueOf(CVis4.getValue().toString())
				+ Integer.valueOf(CVis5.getValue().toString()) + Integer.valueOf(CVis6.getValue().toString())
				+ Integer.valueOf(CVis7.getValue().toString()) + Integer.valueOf(CVis8.getValue().toString())
				+ Integer.valueOf(CVis9.getValue().toString());
			textviscarreras.setText("" + CarrerasTotalV);
			}
		});
		CVis6.setBounds(405, 17, 44, 39);
		panel_3.add(CVis6);

		CVis7 = new JSpinner();
		CVis7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		CVis7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CarrerasTotalV = Integer.valueOf(CVis1.getValue().toString()) + Integer.valueOf(CVis2.getValue().toString())
				+ Integer.valueOf(CVis3.getValue().toString()) + Integer.valueOf(CVis4.getValue().toString())
				+ Integer.valueOf(CVis5.getValue().toString()) + Integer.valueOf(CVis6.getValue().toString())
				+ Integer.valueOf(CVis7.getValue().toString()) + Integer.valueOf(CVis8.getValue().toString())
				+ Integer.valueOf(CVis9.getValue().toString());
			textviscarreras.setText("" + CarrerasTotalV);
			}
		});
		CVis7.setBounds(461, 17, 44, 39);
		panel_3.add(CVis7);

		CVis8 = new JSpinner();
		CVis8.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		CVis8.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CarrerasTotalV = Integer.valueOf(CVis1.getValue().toString()) + Integer.valueOf(CVis2.getValue().toString())
				+ Integer.valueOf(CVis3.getValue().toString()) + Integer.valueOf(CVis4.getValue().toString())
				+ Integer.valueOf(CVis5.getValue().toString()) + Integer.valueOf(CVis6.getValue().toString())
				+ Integer.valueOf(CVis7.getValue().toString()) + Integer.valueOf(CVis8.getValue().toString())
				+ Integer.valueOf(CVis9.getValue().toString());
			textviscarreras.setText("" + CarrerasTotalV);
			}
		});
		CVis8.setBounds(517, 17, 44, 39);
		panel_3.add(CVis8);

		CVis9 = new JSpinner();
		CVis9.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		CVis9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CarrerasTotalV = Integer.valueOf(CVis1.getValue().toString()) + Integer.valueOf(CVis2.getValue().toString())
				+ Integer.valueOf(CVis3.getValue().toString()) + Integer.valueOf(CVis4.getValue().toString())
				+ Integer.valueOf(CVis5.getValue().toString()) + Integer.valueOf(CVis6.getValue().toString())
				+ Integer.valueOf(CVis7.getValue().toString()) + Integer.valueOf(CVis8.getValue().toString())
				+ Integer.valueOf(CVis9.getValue().toString());
			textviscarreras.setText("" + CarrerasTotalV);
			}
		});
		CVis9.setBounds(571, 17, 44, 39);
		panel_3.add(CVis9);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(645, 16, 142, 148);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		textloccarreras = new JTextField();
		textloccarreras.setText("0");
		textloccarreras.setHorizontalAlignment(SwingConstants.CENTER);
		textloccarreras.setBounds(6, 17, 42, 45);
		panel_4.add(textloccarreras);
		textloccarreras.setColumns(10);

		textlochit = new JTextField();
		textlochit.setText("0");
		textlochit.setHorizontalAlignment(SwingConstants.CENTER);
		textlochit.setColumns(10);
		textlochit.setBounds(50, 17, 42, 45);
		panel_4.add(textlochit);

		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(94, 17, 42, 45);
		panel_4.add(textField_2);

		textviscarreras = new JTextField();
		textviscarreras.setText("0");
		textviscarreras.setHorizontalAlignment(SwingConstants.CENTER);
		textviscarreras.setColumns(10);
		textviscarreras.setBounds(6, 95, 42, 45);
		panel_4.add(textviscarreras);

		textvishit = new JTextField();
		textvishit.setText("0");
		textvishit.setHorizontalAlignment(SwingConstants.CENTER);
		textvishit.setColumns(10);
		textvishit.setBounds(50, 95, 42, 45);
		panel_4.add(textvishit);

		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
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

		bateadesignado = equipolocal.buscarJugadorbyposicion("Bateador designado");
		JL9 = new JLabel();
		if (bateadesignado == null) {
			JL9.setText("Bateador Designado");
		} else {
			JL9.setText("" + bateadesignado.getNombre() + " " + bateadesignado.getApellido());
		}
		JL9.setBounds(6, 358, 119, 20);
		panel_7.add(JL9);

		centerfield = equipolocal.buscarJugadorbyposicion("Center fielder");
		JL8 = new JLabel();
		if (centerfield == null) {
			JL8.setText("Center Fielder");
		} else {
			JL8.setText("" + centerfield.getNombre() + " " + centerfield.getApellido());
		}
		JL8.setBounds(6, 315, 119, 20);
		panel_7.add(JL8);

		leftfield = equipolocal.buscarJugadorbyposicion("Left fielder");
		JL7 = new JLabel();
		if (leftfield == null) {
			JL7.setText("Left Fielder");
		} else {
			JL7.setText("" + leftfield.getNombre() + " " + leftfield.getApellido());
		}
		JL7.setBounds(6, 274, 119, 20);
		panel_7.add(JL7);

		rigthfield = equipolocal.buscarJugadorbyposicion("Rigth fielder");
		JL6 = new JLabel();
		if (rigthfield == null) {
			JL6.setText("Rigth Fielder");
		} else {
			JL6.setText("" + rigthfield.getNombre() + " " + rigthfield.getApellido());
		}
		JL6.setBounds(6, 234, 119, 20);
		panel_7.add(JL6);

		shortstop = equipolocal.buscarJugadorbyposicion("Short stop");
		JL5 = new JLabel();
		if (shortstop == null) {
			JL5.setText("Short Stop");
		} else {
			JL5.setText("" + shortstop.getNombre() + " " + shortstop.getApellido());
		}
		JL5.setBounds(6, 193, 101, 20);
		panel_7.add(JL5);

		TerceraBase = equipolocal.buscarJugadorbyposicion("Tercera base");
		JL4 = new JLabel();
		if (TerceraBase == null) {
			JL4.setText("Tercera Base");
		} else {
			JL4.setText("" + TerceraBase.getNombre() + " " + TerceraBase.getApellido());
		}
		JL4.setBounds(6, 154, 119, 20);
		panel_7.add(JL4);

		segundabase = equipolocal.buscarJugadorbyposicion("Segunda base");
		JL3 = new JLabel();
		if (segundabase == null) {
			JL3.setText("Segunda Base");
		} else {
			JL3.setText("" + segundabase.getNombre() + " " + segundabase.getApellido());
		}
		JL3.setBounds(6, 111, 119, 20);
		panel_7.add(JL3);

		primerabase = equipolocal.buscarJugadorbyposicion("Primera base");
		JL2 = new JLabel();
		if (primerabase == null) {
			JL2.setText("Primera Base");
		} else {
			JL2.setText("" + primerabase.getNombre() + " " + primerabase.getApellido());
		}
		JL2.setBounds(6, 72, 119, 20);
		panel_7.add(JL2);

		catcher = equipolocal.buscarJugadorbyposicion("Catcher");
		JL1 = new JLabel();
		if (catcher == null) {
			JL1.setText("Catcher");
		} else {
			JL1.setText("" + catcher.getNombre() + " " + catcher.getApellido());
		}
		JL1.setBounds(6, 32, 119, 20);
		panel_7.add(JL1);

		lblJugadores = new JLabel("Jugadores Locales");
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

		label_tb_HLocal = new JLabel("    TB               H    ");
		label_tb_HLocal.setBounds(10, 6, 106, 20);
		panel_8.add(label_tb_HLocal);
		label_tb_HLocal.setFont(new Font("Tahoma", Font.BOLD, 11));

		TBLocJ1 = new JSpinner();
		TBLocJ1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBLocJ1.setBounds(10, 26, 36, 32);
		panel_8.add(TBLocJ1);

		HLocJ1 = new JSpinner();
		HLocJ1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		HLocJ1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(HLocJ1.getValue().toString()) + Integer.valueOf(HLocJ2.getValue().toString())
				+ Integer.valueOf(HLocJ3.getValue().toString()) + Integer.valueOf(HLocJ4.getValue().toString())
				+ Integer.valueOf(HLocJ5.getValue().toString()) + Integer.valueOf(HLocJ6.getValue().toString())
				+ Integer.valueOf(HLocJ7.getValue().toString()) + Integer.valueOf(HLocJ8.getValue().toString())
				+ Integer.valueOf(HLocJ9.getValue().toString());
				textlochit.setText("" + totalvisitahit);
			}
		});
		HLocJ1.setBounds(69, 26, 36, 32);
		panel_8.add(HLocJ1);

		HLocJ9 = new JSpinner();
		HLocJ9.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		HLocJ9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totallocalhit = Integer.valueOf(HLocJ1.getValue().toString()) + Integer.valueOf(HLocJ2.getValue().toString())
				+ Integer.valueOf(HLocJ3.getValue().toString()) + Integer.valueOf(HLocJ4.getValue().toString())
				+ Integer.valueOf(HLocJ5.getValue().toString()) + Integer.valueOf(HLocJ6.getValue().toString())
				+ Integer.valueOf(HLocJ7.getValue().toString()) + Integer.valueOf(HLocJ8.getValue().toString())
				+ Integer.valueOf(HLocJ9.getValue().toString());
				textlochit.setText("" + totallocalhit);
			}
		});
		HLocJ9.setBounds(69, 352, 36, 32);
		panel_8.add(HLocJ9);

		HLocJ2 = new JSpinner();
		HLocJ2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		HLocJ2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totallocalhit = Integer.valueOf(HLocJ1.getValue().toString()) + Integer.valueOf(HLocJ2.getValue().toString())
				+ Integer.valueOf(HLocJ3.getValue().toString()) + Integer.valueOf(HLocJ4.getValue().toString())
				+ Integer.valueOf(HLocJ5.getValue().toString()) + Integer.valueOf(HLocJ6.getValue().toString())
				+ Integer.valueOf(HLocJ7.getValue().toString()) + Integer.valueOf(HLocJ8.getValue().toString())
				+ Integer.valueOf(HLocJ9.getValue().toString());
				textlochit.setText("" + totallocalhit);
			}
		});
		HLocJ2.setBounds(69, 66, 36, 32);
		panel_8.add(HLocJ2);

		HLocJ3 = new JSpinner();
		HLocJ3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		HLocJ3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totallocalhit = Integer.valueOf(HLocJ1.getValue().toString()) + Integer.valueOf(HLocJ2.getValue().toString())
				+ Integer.valueOf(HLocJ3.getValue().toString()) + Integer.valueOf(HLocJ4.getValue().toString())
				+ Integer.valueOf(HLocJ5.getValue().toString()) + Integer.valueOf(HLocJ6.getValue().toString())
				+ Integer.valueOf(HLocJ7.getValue().toString()) + Integer.valueOf(HLocJ8.getValue().toString())
				+ Integer.valueOf(HLocJ9.getValue().toString());
				textlochit.setText("" + totallocalhit);
			}
		});
		HLocJ3.setBounds(69, 106, 36, 32);
		panel_8.add(HLocJ3);

		HLocJ4 = new JSpinner();
		HLocJ4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		HLocJ4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totallocalhit = Integer.valueOf(HLocJ1.getValue().toString()) + Integer.valueOf(HLocJ2.getValue().toString())
				+ Integer.valueOf(HLocJ3.getValue().toString()) + Integer.valueOf(HLocJ4.getValue().toString())
				+ Integer.valueOf(HLocJ5.getValue().toString()) + Integer.valueOf(HLocJ6.getValue().toString())
				+ Integer.valueOf(HLocJ7.getValue().toString()) + Integer.valueOf(HLocJ8.getValue().toString())
				+ Integer.valueOf(HLocJ9.getValue().toString());
				textlochit.setText("" + totallocalhit);
			}
		});
		HLocJ4.setBounds(69, 145, 36, 32);
		panel_8.add(HLocJ4);

		HLocJ5 = new JSpinner();
		HLocJ5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		HLocJ5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totallocalhit = Integer.valueOf(HLocJ1.getValue().toString()) + Integer.valueOf(HLocJ2.getValue().toString())
				+ Integer.valueOf(HLocJ3.getValue().toString()) + Integer.valueOf(HLocJ4.getValue().toString())
				+ Integer.valueOf(HLocJ5.getValue().toString()) + Integer.valueOf(HLocJ6.getValue().toString())
				+ Integer.valueOf(HLocJ7.getValue().toString()) + Integer.valueOf(HLocJ8.getValue().toString())
				+ Integer.valueOf(HLocJ9.getValue().toString());
				textlochit.setText("" + totallocalhit);
			}
		});
		HLocJ5.setBounds(69, 185, 36, 32);
		panel_8.add(HLocJ5);

		HLocJ6 = new JSpinner();
		HLocJ6.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		HLocJ6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totallocalhit = Integer.valueOf(HLocJ1.getValue().toString()) + Integer.valueOf(HLocJ2.getValue().toString())
				+ Integer.valueOf(HLocJ3.getValue().toString()) + Integer.valueOf(HLocJ4.getValue().toString())
				+ Integer.valueOf(HLocJ5.getValue().toString()) + Integer.valueOf(HLocJ6.getValue().toString())
				+ Integer.valueOf(HLocJ7.getValue().toString()) + Integer.valueOf(HLocJ8.getValue().toString())
				+ Integer.valueOf(HLocJ9.getValue().toString());
				textlochit.setText("" + totallocalhit);
			}
		});
		HLocJ6.setBounds(69, 226, 36, 32);
		panel_8.add(HLocJ6);

		HLocJ7 = new JSpinner();
		HLocJ7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		HLocJ7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totallocalhit = Integer.valueOf(HLocJ1.getValue().toString()) + Integer.valueOf(HLocJ2.getValue().toString())
				+ Integer.valueOf(HLocJ3.getValue().toString()) + Integer.valueOf(HLocJ4.getValue().toString())
				+ Integer.valueOf(HLocJ5.getValue().toString()) + Integer.valueOf(HLocJ6.getValue().toString())
				+ Integer.valueOf(HLocJ7.getValue().toString()) + Integer.valueOf(HLocJ8.getValue().toString())
				+ Integer.valueOf(HLocJ9.getValue().toString());
				textlochit.setText("" + totallocalhit);
			}
		});
		HLocJ7.setBounds(69, 268, 36, 32);
		panel_8.add(HLocJ7);

		HLocJ8 = new JSpinner();
		HLocJ8.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		HLocJ8.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totallocalhit = Integer.valueOf(HLocJ1.getValue().toString()) + Integer.valueOf(HLocJ2.getValue().toString())
				+ Integer.valueOf(HLocJ3.getValue().toString()) + Integer.valueOf(HLocJ4.getValue().toString())
				+ Integer.valueOf(HLocJ5.getValue().toString()) + Integer.valueOf(HLocJ6.getValue().toString())
				+ Integer.valueOf(HLocJ7.getValue().toString()) + Integer.valueOf(HLocJ8.getValue().toString())
				+ Integer.valueOf(HLocJ9.getValue().toString());
				textlochit.setText("" + totallocalhit);
			}
		});
		HLocJ8.setBounds(69, 310, 36, 32);
		panel_8.add(HLocJ8);

		TBLocJ9 = new JSpinner();
		TBLocJ9.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBLocJ9.setBounds(10, 352, 36, 32);
		panel_8.add(TBLocJ9);

		TBLocJ4 = new JSpinner();
		TBLocJ4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBLocJ4.setBounds(10, 145, 36, 32);
		panel_8.add(TBLocJ4);

		TBLocJ6 = new JSpinner();
		TBLocJ6.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBLocJ6.setBounds(10, 226, 36, 32);
		panel_8.add(TBLocJ6);

		TBLocJ5 = new JSpinner();
		TBLocJ5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBLocJ5.setBounds(10, 185, 36, 32);
		panel_8.add(TBLocJ5);

		TBLocJ3 = new JSpinner();
		TBLocJ3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBLocJ3.setBounds(10, 106, 36, 32);
		panel_8.add(TBLocJ3);

		TBLocJ2 = new JSpinner();
		TBLocJ2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBLocJ2.setBounds(10, 66, 36, 32);
		panel_8.add(TBLocJ2);

		TBLocJ8 = new JSpinner();
		TBLocJ8.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBLocJ8.setBounds(10, 310, 36, 32);
		panel_8.add(TBLocJ8);

		TBLocJ7 = new JSpinner();
		TBLocJ7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBLocJ7.setBounds(10, 268, 36, 32);
		panel_8.add(TBLocJ7);

		btnEquipoLocal = new JButton("" + equipolocal.getNombre());
		btnEquipoLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deshabilitarVisita(equipovisita);
				habilitarLocal();
			}
		});
		btnEquipoLocal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEquipoLocal.setBounds(55, 6, 171, 30);
		panel_5.add(btnEquipoLocal);
		
		fechaL = new JLabel("");
		fechaL.setIcon(new ImageIcon("img/flechita.png"));
		fechaL.setBounds(10, 9, 43, 23);
		panel_5.add(fechaL);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setLayout(null);
		panel_6.setBounds(543, 11, 269, 433);
		panel.add(panel_6);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setLayout(null);
		panel_9.setBounds(10, 40, 113, 388);
		panel_6.add(panel_9);

		bateadesignadov = equipovisita.buscarJugadorbyposicion("Bateador designado");
		Jv9 = new JLabel();
		Jv9.setEnabled(false);
		if (bateadesignadov == null) {
			Jv9.setText("Bateador Designado");
		} else {
			Jv9.setText("" + bateadesignadov.getNombre() + " " + bateadesignadov.getApellido());
		}
		Jv9.setBounds(6, 358, 119, 20);
		panel_9.add(Jv9);

		centerfieldv = equipovisita.buscarJugadorbyposicion("Center fielder");
		Jv8 = new JLabel();
		Jv8.setEnabled(false);
		if (centerfieldv == null) {
			Jv8.setText("Center Fielder");
		} else {
			Jv8.setText("" + centerfieldv.getNombre() + " " + centerfieldv.getApellido());
		}
		Jv8.setBounds(6, 315, 119, 20);
		panel_9.add(Jv8);

		leftfieldv = equipovisita.buscarJugadorbyposicion("Left fielder");
		Jv7 = new JLabel();
		Jv7.setEnabled(false);
		if (leftfieldv == null) {
			Jv7.setText("Left Fielder");
		} else {
			Jv7.setText("" + leftfieldv.getNombre() + " " + leftfieldv.getApellido());
		}
		Jv7.setBounds(6, 274, 119, 20);
		panel_9.add(Jv7);

		rigthfieldv = equipovisita.buscarJugadorbyposicion("Rigth fielder");
		Jv6 = new JLabel();
		Jv6.setEnabled(false);
		if (rigthfieldv == null) {
			Jv6.setText("Rigth Fielder");
		} else {
			Jv6.setText("" + rigthfieldv.getNombre() + " " + rigthfieldv.getApellido());
		}
		Jv6.setBounds(6, 234, 119, 20);
		panel_9.add(Jv6);

		shortstopv = equipovisita.buscarJugadorbyposicion("Short stop");
		Jv5 = new JLabel();
		Jv5.setEnabled(false);
		if (shortstopv == null) {
			Jv5.setText("Short Stop");
		} else {
			Jv5.setText("" + shortstopv.getNombre() + " " + shortstopv.getApellido());
		}
		Jv5.setBounds(6, 193, 119, 20);
		panel_9.add(Jv5);

		tercerabasev = equipovisita.buscarJugadorbyposicion("Tercera base");
		Jv4 = new JLabel();
		Jv4.setEnabled(false);
		if (tercerabasev == null) {
			Jv4.setText("Tercera Base");
		} else {
			Jv4.setText("" + tercerabasev.getNombre() + " " + tercerabasev.getApellido());
		}
		Jv4.setBounds(6, 154, 119, 20);
		panel_9.add(Jv4);

		segundabasev = equipovisita.buscarJugadorbyposicion("Segunda base");
		Jv3 = new JLabel();
		Jv3.setEnabled(false);
		if (segundabasev == null) {
			Jv3.setText("Segunda Base");
		} else {
			Jv3.setText("" + segundabasev.getNombre() + " " + segundabasev.getApellido());
		}
		Jv3.setBounds(6, 111, 119, 20);
		panel_9.add(Jv3);

		primerabasev = equipovisita.buscarJugadorbyposicion("Primera base");
		Jv2 = new JLabel();
		Jv2.setEnabled(false);
		if (primerabasev == null) {
			Jv2.setText("Primera Base");
		} else {
			Jv2.setText("" + primerabasev.getNombre() + " " + primerabasev.getApellido());
		}
		Jv2.setBounds(6, 72, 119, 20);
		panel_9.add(Jv2);

		catcherv = equipovisita.buscarJugadorbyposicion("Catcher");
		Jv1 = new JLabel();
		Jv1.setEnabled(false);
		if (catcherv == null) {
			Jv1.setText("Catcher");
		} else {
			Jv1.setText("" + catcherv.getNombre() + " " + catcherv.getApellido());
		}
		Jv1.setBounds(6, 32, 119, 20);
		panel_9.add(Jv1);

		lblJugadoresVisitantes = new JLabel("Jugadores Visita");
		lblJugadoresVisitantes.setEnabled(false);
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

		label_tb_H = new JLabel("    TB               H    ");
		label_tb_H.setEnabled(false);
		label_tb_H.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_tb_H.setBounds(10, 6, 106, 20);
		panel_10.add(label_tb_H);

		TBv1 = new JSpinner();
		TBv1.setEnabled(false);
		TBv1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBv1.setBounds(10, 26, 36, 32);
		panel_10.add(TBv1);

		TBh1 = new JSpinner();
		TBh1.setEnabled(false);
		TBh1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBh1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(TBh1.getValue().toString()) + Integer.valueOf(TBh2.getValue().toString())
				+ Integer.valueOf(TBh3.getValue().toString()) + Integer.valueOf(TBh4.getValue().toString())
				+ Integer.valueOf(TBh5.getValue().toString()) + Integer.valueOf(TBh6.getValue().toString())
				+ Integer.valueOf(TBh7.getValue().toString()) + Integer.valueOf(TBh8.getValue().toString())
				+ Integer.valueOf(TBh9.getValue().toString());
				textvishit.setText("" + totalvisitahit);
			}
		});
		TBh1.setBounds(69, 26, 36, 32);
		panel_10.add(TBh1);

		TBh9 = new JSpinner();
		TBh9.setEnabled(false);
		TBh9.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBh9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(TBh1.getValue().toString()) + Integer.valueOf(TBh2.getValue().toString())
				+ Integer.valueOf(TBh3.getValue().toString()) + Integer.valueOf(TBh4.getValue().toString())
				+ Integer.valueOf(TBh5.getValue().toString()) + Integer.valueOf(TBh6.getValue().toString())
				+ Integer.valueOf(TBh7.getValue().toString()) + Integer.valueOf(TBh8.getValue().toString())
				+ Integer.valueOf(TBh9.getValue().toString());
				textvishit.setText("" + totalvisitahit);
			}
		});
		TBh9.setBounds(69, 352, 36, 32);
		panel_10.add(TBh9);

		TBh2 = new JSpinner();
		TBh2.setEnabled(false);
		TBh2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBh2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(TBh1.getValue().toString()) + Integer.valueOf(TBh2.getValue().toString())
				+ Integer.valueOf(TBh3.getValue().toString()) + Integer.valueOf(TBh4.getValue().toString())
				+ Integer.valueOf(TBh5.getValue().toString()) + Integer.valueOf(TBh6.getValue().toString())
				+ Integer.valueOf(TBh7.getValue().toString()) + Integer.valueOf(TBh8.getValue().toString())
				+ Integer.valueOf(TBh9.getValue().toString());
				textvishit.setText("" + totalvisitahit);
			}
		});
		TBh2.setBounds(69, 66, 36, 32);
		panel_10.add(TBh2);

		TBh3 = new JSpinner();
		TBh3.setEnabled(false);
		TBh3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBh3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(TBh1.getValue().toString()) + Integer.valueOf(TBh2.getValue().toString())
				+ Integer.valueOf(TBh3.getValue().toString()) + Integer.valueOf(TBh4.getValue().toString())
				+ Integer.valueOf(TBh5.getValue().toString()) + Integer.valueOf(TBh6.getValue().toString())
				+ Integer.valueOf(TBh7.getValue().toString()) + Integer.valueOf(TBh8.getValue().toString())
				+ Integer.valueOf(TBh9.getValue().toString());
				textvishit.setText("" + totalvisitahit);
			}
		});
		TBh3.setBounds(69, 106, 36, 32);
		panel_10.add(TBh3);

		TBh4 = new JSpinner();
		TBh4.setEnabled(false);
		TBh4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBh4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(TBh1.getValue().toString()) + Integer.valueOf(TBh2.getValue().toString())
				+ Integer.valueOf(TBh3.getValue().toString()) + Integer.valueOf(TBh4.getValue().toString())
				+ Integer.valueOf(TBh5.getValue().toString()) + Integer.valueOf(TBh6.getValue().toString())
				+ Integer.valueOf(TBh7.getValue().toString()) + Integer.valueOf(TBh8.getValue().toString())
				+ Integer.valueOf(TBh9.getValue().toString());
				textvishit.setText("" + totalvisitahit);
			}
		});
		TBh4.setBounds(69, 145, 36, 32);
		panel_10.add(TBh4);

		TBh5 = new JSpinner();
		TBh5.setEnabled(false);
		TBh5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBh5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(TBh1.getValue().toString()) + Integer.valueOf(TBh2.getValue().toString())
				+ Integer.valueOf(TBh3.getValue().toString()) + Integer.valueOf(TBh4.getValue().toString())
				+ Integer.valueOf(TBh5.getValue().toString()) + Integer.valueOf(TBh6.getValue().toString())
				+ Integer.valueOf(TBh7.getValue().toString()) + Integer.valueOf(TBh8.getValue().toString())
				+ Integer.valueOf(TBh9.getValue().toString());
				textvishit.setText("" + totalvisitahit);
			}
		});
		TBh5.setBounds(69, 185, 36, 32);
		panel_10.add(TBh5);

		TBh6 = new JSpinner();
		TBh6.setEnabled(false);
		TBh6.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBh6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(TBh1.getValue().toString()) + Integer.valueOf(TBh2.getValue().toString())
				+ Integer.valueOf(TBh3.getValue().toString()) + Integer.valueOf(TBh4.getValue().toString())
				+ Integer.valueOf(TBh5.getValue().toString()) + Integer.valueOf(TBh6.getValue().toString())
				+ Integer.valueOf(TBh7.getValue().toString()) + Integer.valueOf(TBh8.getValue().toString())
				+ Integer.valueOf(TBh9.getValue().toString());
				textvishit.setText("" + totalvisitahit);
			}
		});
		TBh6.setBounds(69, 226, 36, 32);
		panel_10.add(TBh6);

		TBh7 = new JSpinner();
		TBh7.setEnabled(false);
		TBh7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBh7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(TBh1.getValue().toString()) + Integer.valueOf(TBh2.getValue().toString())
				+ Integer.valueOf(TBh3.getValue().toString()) + Integer.valueOf(TBh4.getValue().toString())
				+ Integer.valueOf(TBh5.getValue().toString()) + Integer.valueOf(TBh6.getValue().toString())
				+ Integer.valueOf(TBh7.getValue().toString()) + Integer.valueOf(TBh8.getValue().toString())
				+ Integer.valueOf(TBh9.getValue().toString());
				textvishit.setText("" + totalvisitahit);
			}
		});
		TBh7.setBounds(69, 268, 36, 32);
		panel_10.add(TBh7);

		TBh8 = new JSpinner();
		TBh8.setEnabled(false);
		TBh8.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBh8.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totalvisitahit = Integer.valueOf(TBh1.getValue().toString()) + Integer.valueOf(TBh2.getValue().toString())
				+ Integer.valueOf(TBh3.getValue().toString()) + Integer.valueOf(TBh4.getValue().toString())
				+ Integer.valueOf(TBh5.getValue().toString()) + Integer.valueOf(TBh6.getValue().toString())
				+ Integer.valueOf(TBh7.getValue().toString()) + Integer.valueOf(TBh8.getValue().toString())
				+ Integer.valueOf(TBh9.getValue().toString());
				textvishit.setText("" + totalvisitahit);
			}
		});
		TBh8.setBounds(69, 310, 36, 32);
		panel_10.add(TBh8);

		TBv9 = new JSpinner();
		TBv9.setEnabled(false);
		TBv9.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBv9.setBounds(10, 352, 36, 32);
		panel_10.add(TBv9);

		TBv4 = new JSpinner();
		TBv4.setEnabled(false);
		TBv4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBv4.setBounds(10, 145, 36, 32);
		panel_10.add(TBv4);

		TBv6 = new JSpinner();
		TBv6.setEnabled(false);
		TBv6.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBv6.setBounds(10, 226, 36, 32);
		panel_10.add(TBv6);

		TBv5 = new JSpinner();
		TBv5.setEnabled(false);
		TBv5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBv5.setBounds(10, 185, 36, 32);
		panel_10.add(TBv5);

		TBv3 = new JSpinner();
		TBv3.setEnabled(false);
		TBv3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBv3.setBounds(10, 106, 36, 32);
		panel_10.add(TBv3);

		TBv2 = new JSpinner();
		TBv2.setEnabled(false);
		TBv2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBv2.setBounds(10, 66, 36, 32);
		panel_10.add(TBv2);

		TBv8 = new JSpinner();
		TBv8.setEnabled(false);
		TBv8.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBv8.setBounds(10, 310, 36, 32);
		panel_10.add(TBv8);

		TBv7 = new JSpinner();
		TBv7.setEnabled(false);
		TBv7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		TBv7.setBounds(10, 268, 36, 32);
		panel_10.add(TBv7);

		JButton btnEquipoVisitante = new JButton("" + equipovisita.getNombre());
		btnEquipoVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				habilitarVisita();
				deshabilitarLocal(equipolocal);
			}
		});
		btnEquipoVisitante.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEquipoVisitante.setBounds(55, 6, 182, 30);
		panel_6.add(btnEquipoVisitante);
		
		fechaV = new JLabel("");
		fechaV.setVisible(false);
		fechaV.setIcon(new ImageIcon("img/flechita.png"));
		fechaV.setBounds(10, 9, 43, 23);
		panel_6.add(fechaV);

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
		
		Centerv = new JLabel("");
		Centerv.setForeground(new Color(0, 0, 255));
		Centerv.setFont(new Font("Tahoma", Font.BOLD, 12));
		Centerv.setBounds(386, 150, 62, 14);
		panel.add(Centerv);
		
		Rigthv = new JLabel("");
		Rigthv.setForeground(new Color(0, 0, 255));
		Rigthv.setFont(new Font("Tahoma", Font.BOLD, 12));
		Rigthv.setBounds(460, 175, 56, 14);
		panel.add(Rigthv);
		
		Lefthv = new JLabel("");
		Lefthv.setForeground(new Color(0, 0, 255));
		Lefthv.setFont(new Font("Tahoma", Font.BOLD, 12));
		Lefthv.setBounds(302, 168, 81, 14);
		panel.add(Lefthv);
		
		SBv = new JLabel("");
		SBv.setForeground(new Color(0, 0, 255));
		SBv.setFont(new Font("Tahoma", Font.BOLD, 12));
		SBv.setBounds(455, 210, 56, 14);
		panel.add(SBv);
		
		TBv = new JLabel("");
		TBv.setForeground(new Color(0, 0, 255));
		TBv.setFont(new Font("Tahoma", Font.BOLD, 12));
		TBv.setBounds(327, 252, 56, 14);
		panel.add(TBv);
		
		CTHv = new JLabel("");
		CTHv.setForeground(new Color(0, 0, 255));
		CTHv.setFont(new Font("Tahoma", Font.BOLD, 12));
		CTHv.setBounds(385, 305, 56, 14);
		panel.add(CTHv);
		
		PBv = new JLabel("");
		PBv.setForeground(new Color(0, 0, 255));
		PBv.setFont(new Font("Tahoma", Font.BOLD, 12));
		PBv.setBounds(443, 252, 56, 14);
		panel.add(PBv);
		
		SSv = new JLabel("");
		SSv.setForeground(new Color(0, 0, 255));
		SSv.setFont(new Font("Tahoma", Font.BOLD, 12));
		SSv.setBounds(335, 215, 56, 14);
		panel.add(SSv);

		labelPosiciones = new JLabel("");
		labelPosiciones.setBounds(282, 50, 257, 305);
		panel.add(labelPosiciones);
		labelPosiciones.setIcon(new ImageIcon("img/CentroSimulador.png"));
		
		lblEnDefensa = new JLabel("En Defensa: ");
		lblEnDefensa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnDefensa.setForeground(new Color(139, 0, 0));
		lblEnDefensa.setBounds(335, 366, 175, 14);
		panel.add(lblEnDefensa);

		panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBounds(0, 734, 842, 53);
		contentPanel.add(panel_11);
		panel_11.setLayout(null);

		btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
		btnFinalizarPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//recolectarDatos();
				//agregarDatosJugadores();
				partido.setCarrerasCasa(carrerasTotal);
				partido.setCarrerasVisita(CarrerasTotalV);
				if(carrerasTotal>CarrerasTotalV){
					equipolocal.JuegosGanados();
					equipovisita.JuegosPerdidos();
					//JugadoresGanaron(equipolocal);
					//JugadoresPerdieron(equipovisita);
				}else{
					equipolocal.JuegosPerdidos();
					equipovisita.JuegosGanados();
					//JugadoresGanaron(equipovisita);
					//JugadoresPerdieron(equipolocal);
				}
				JOptionPane.showMessageDialog(null, "Casa "+partido.getEquipoCasa()+" "+carrerasTotal+" - Visitantes "+partido.getEquipoVisita()+" "+CarrerasTotalV);
				Principal.cargar();
			}
		});
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
		
		deshabilitarVisita(equipovisita);
	}
	
	public void habilitarVisita(){
		Jv1.setEnabled(true); Jv2.setEnabled(true); Jv3.setEnabled(true); Jv4.setEnabled(true); Jv5.setEnabled(true); 
		Jv6.setEnabled(true);	Jv7.setEnabled(true); Jv8.setEnabled(true); Jv9.setEnabled(true); label_tb_H.setEnabled(true);
		lblJugadoresVisitantes.setEnabled(true);
		fechaV.setVisible(true);
		TBv1.setEnabled(true); TBv2.setEnabled(true); TBv3.setEnabled(true); TBv4.setEnabled(true); TBv5.setEnabled(true);
		TBv6.setEnabled(true); TBv7.setEnabled(true); TBv8.setEnabled(true); TBv9.setEnabled(true);		
		TBh1.setEnabled(true); TBh2.setEnabled(true); TBh3.setEnabled(true); TBh4.setEnabled(true);
		TBh5.setEnabled(true); TBh6.setEnabled(true); TBh7.setEnabled(true); TBh8.setEnabled(true); TBh9.setEnabled(true);
	
	}
	
	public void deshabilitarVisita(Equipos equipo){
		Jv1.setEnabled(false); Jv2.setEnabled(false); Jv3.setEnabled(false); Jv4.setEnabled(false); Jv5.setEnabled(false); 
		Jv6.setEnabled(false);	Jv7.setEnabled(false); Jv8.setEnabled(false); Jv9.setEnabled(false); label_tb_H.setEnabled(false);
		lblJugadoresVisitantes.setEnabled(false); fechaV.setVisible(false);
		TBv1.setEnabled(false); TBv2.setEnabled(false); TBv3.setEnabled(false); TBv4.setEnabled(false); TBv5.setEnabled(false);
		TBv6.setEnabled(false); TBv7.setEnabled(false); TBv8.setEnabled(false); TBv9.setEnabled(false);		
		TBh1.setEnabled(false); TBh2.setEnabled(false); TBh3.setEnabled(false); TBh4.setEnabled(false);
		TBh5.setEnabled(false); TBh6.setEnabled(false); TBh7.setEnabled(false); TBh8.setEnabled(false); TBh9.setEnabled(false);
		
		lblEnDefensa.setText("En Defensa: "+equipo.getNombre());
		if(catcherv!=null){
			CTHv.setText(""+catcherv.getNombre());
		}
		if(shortstopv!=null){
			SSv.setText(""+shortstopv.getNombre());
		}
		if(tercerabasev!=null){
			TBv.setText(""+tercerabasev.getNombre());
		}
		if(primerabasev!=null){
			PBv.setText(""+primerabasev.getNombre());
		}
		if(segundabasev!=null){
			SBv.setText(""+segundabasev.getNombre());
		}
		if(leftfieldv!=null){
			Lefthv.setText(""+leftfieldv.getNombre());
		}
		if(rigthfieldv!=null){
			Rigthv.setText(""+rigthfieldv.getNombre());
		}
		if(centerfieldv!=null){
			Centerv.setText(""+centerfieldv.getNombre());
		}
	}
	
	public void habilitarLocal(){
		fechaL.setVisible(true); JL1.setEnabled(true); JL2.setEnabled(true); JL3.setEnabled(true); JL4.setEnabled(true);
		JL5.setEnabled(true); JL6.setEnabled(true); JL7.setEnabled(true); JL8.setEnabled(true); JL9.setEnabled(true);
		lblJugadores.setEnabled(true); label_tb_HLocal.setEnabled(true);
		TBLocJ1.setEnabled(true); TBLocJ2.setEnabled(true); TBLocJ3.setEnabled(true); TBLocJ4.setEnabled(true);
		TBLocJ5.setEnabled(true); TBLocJ6.setEnabled(true); TBLocJ7.setEnabled(true); TBLocJ8.setEnabled(true); TBLocJ9.setEnabled(true);
		HLocJ1.setEnabled(true); HLocJ2.setEnabled(true); HLocJ3.setEnabled(true); HLocJ4.setEnabled(true); HLocJ5.setEnabled(true);
		HLocJ6.setEnabled(true); HLocJ7.setEnabled(true); HLocJ8.setEnabled(true); HLocJ9.setEnabled(true);
	}
	
	public void deshabilitarLocal(Equipos equipo){
		fechaL.setVisible(false); JL1.setEnabled(false); JL2.setEnabled(false); JL3.setEnabled(false); JL4.setEnabled(false);
		JL5.setEnabled(false); JL6.setEnabled(false); JL7.setEnabled(false); JL8.setEnabled(false); JL9.setEnabled(false);
		lblJugadores.setEnabled(false); label_tb_HLocal.setEnabled(false);
		TBLocJ1.setEnabled(false); TBLocJ2.setEnabled(false); TBLocJ3.setEnabled(false); TBLocJ4.setEnabled(false);
		TBLocJ5.setEnabled(false); TBLocJ6.setEnabled(false); TBLocJ7.setEnabled(false); TBLocJ8.setEnabled(false); TBLocJ9.setEnabled(false);
		HLocJ1.setEnabled(false); HLocJ2.setEnabled(false); HLocJ3.setEnabled(false); HLocJ4.setEnabled(false); HLocJ5.setEnabled(false);
		HLocJ6.setEnabled(false); HLocJ7.setEnabled(false); HLocJ8.setEnabled(false); HLocJ9.setEnabled(false);
	
		lblEnDefensa.setText("En Defensa: "+equipo.getNombre());
		if(catcher!=null){
			CTHv.setText(""+catcher.getNombre());
		}
		if(shortstop!=null){
			SSv.setText(""+shortstop.getNombre());
		}
		if(TerceraBase!=null){
			TBv.setText(""+TerceraBase.getNombre());
		}
		if(primerabase!=null){
			PBv.setText(""+primerabase.getNombre());
		}
		if(segundabase!=null){
			SBv.setText(""+segundabase.getNombre());
		}
		if(leftfield!=null){
			Lefthv.setText(""+leftfield.getNombre());
		}
		if(rigthfield!=null){
			Rigthv.setText(""+rigthfield.getNombre());
		}
		if(centerfield!=null){
			Centerv.setText(""+centerfield.getNombre());
		}
	}
	
	public void recolectarDatos(){
		//turnos al bate  -Locales-
		tlcatcher = Integer.valueOf(TBLocJ1.getValue().toString()); tlpb = Integer.valueOf(TBLocJ2.getValue().toString()); tlsb = Integer.valueOf(TBLocJ3.getValue().toString()); 
		tltb = Integer.valueOf(TBLocJ4.getValue().toString());      tlss = Integer.valueOf(TBLocJ5.getValue().toString()); tlrf = Integer.valueOf(TBLocJ6.getValue().toString()); 
		tllf = Integer.valueOf(TBLocJ7.getValue().toString());      tlcf = Integer.valueOf(TBLocJ8.getValue().toString()); tlbd = Integer.valueOf(TBLocJ9.getValue().toString());
	    //     	-Visitantes-
		tvcatcher = Integer.valueOf(TBv1.getValue().toString());   tvpb = Integer.valueOf(TBv2.getValue().toString()); tvsb = Integer.valueOf(TBv3.getValue().toString()); 
		tvtb = Integer.valueOf(TBv4.getValue().toString());        tvss = Integer.valueOf(TBv5.getValue().toString()); tvrf = Integer.valueOf(TBv6.getValue().toString()); 
		tvlf = Integer.valueOf(TBv7.getValue().toString());        tvcf = Integer.valueOf(TBv8.getValue().toString()); tvbd = Integer.valueOf(TBv9.getValue().toString());
	
		//Hits  -Locales-
		hlcatcher = Integer.valueOf(HLocJ1.getValue().toString());  hlpb = Integer.valueOf(HLocJ2.getValue().toString()); hlsb = Integer.valueOf(HLocJ3.getValue().toString()); 
		hltb = Integer.valueOf(HLocJ4.getValue().toString());       hlss = Integer.valueOf(HLocJ5.getValue().toString()); hlrf = Integer.valueOf(HLocJ6.getValue().toString()); 
		hllf = Integer.valueOf(HLocJ7.getValue().toString());       hlcf = Integer.valueOf(HLocJ8.getValue().toString()); hlbd = Integer.valueOf(HLocJ9.getValue().toString());
			 //-Visitantes-
		hvcatcher = Integer.valueOf(TBh1.getValue().toString());    hvpb = Integer.valueOf(TBh2.getValue().toString()); tvsb = Integer.valueOf(TBh3.getValue().toString()); 
		hvtb = Integer.valueOf(TBh4.getValue().toString());         tvss = Integer.valueOf(TBh5.getValue().toString()); tvrf = Integer.valueOf(TBh6.getValue().toString()); 
		hvlf = Integer.valueOf(TBh7.getValue().toString());         tvcf = Integer.valueOf(TBh8.getValue().toString()); tvbd = Integer.valueOf(TBh9.getValue().toString());
	
	}
	
	public void agregarDatosJugadores(){
		 catcher.getEstadistica().masDatos(tlcatcher, hlcatcher);   primerabase.getEstadistica().masDatos(tvpb, hvpb);    segundabase.getEstadistica().masDatos(tvsb, hlsb);
		 TerceraBase.getEstadistica().masDatos(tltb, hltb);         shortstop.getEstadistica().masDatos(tvss, hvss);      rigthfield.getEstadistica().masDatos(tvrf, hlrf);
		 leftfield.getEstadistica().masDatos(tllf, hllf);           centerfield.getEstadistica().masDatos(tvcf, hvcf);    bateadesignado.getEstadistica().masDatos(tvbd, hlbd);
		 
		 catcherv.getEstadistica().masDatos(tvcatcher, hvcatcher);  primerabasev.getEstadistica().masDatos(tvpb, hvpb);   segundabasev.getEstadistica().masDatos(tvsb, hlsb);
		 tercerabasev.getEstadistica().masDatos(tvtb, hvtb);        shortstopv.getEstadistica().masDatos(tvss, hvss);      rigthfieldv.getEstadistica().masDatos(tvrf, hlrf);
		 leftfieldv.getEstadistica().masDatos(tvlf, hvlf);          centerfieldv.getEstadistica().masDatos(tvcf, hvcf);    bateadesignadov.getEstadistica().masDatos(tvbd, hlbd);		
	}
	
	public void JugadoresGanaron(Equipos equipo){
		int i=0;
		while(i<equipo.getJugador().size()) {
			equipo.getJugador().get(i).getEstadistica().juegoGanado();
		}
	}
	
	public void JugadoresPerdieron(Equipos equipo){
		int i=0;
		while(i<equipo.getJugador().size()) {
			equipo.getJugador().get(i).getEstadistica().juegoPerdido();
		}
	}
}
