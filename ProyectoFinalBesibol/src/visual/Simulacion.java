package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import javax.swing.SwingConstants;

public class Simulacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int CLoc, CVis, CLocJ, CVisJ, HLoc, HVis,HLocJ,HVisJ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	//private JSpinner CLoc1,CLoc2,CLoc3,CLoc4,CLoc5,CLoc6,CLoc7,CLoc8,CLoc9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Simulacion dialog = new Simulacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Simulacion() {
		setTitle(" Simulacion");
		setBounds(100, 100, 1058, 826);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.setBounds(10, 11, 1011, 704);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblEquipoLocal = new JLabel("Equipo Local");
		lblEquipoLocal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEquipoLocal.setBounds(83, 11, 124, 20);
		panel.add(lblEquipoLocal);
		
		JLabel lblEquipoVisitante = new JLabel("Equipo Visitante");
		lblEquipoVisitante.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEquipoVisitante.setBounds(530, 11, 169, 20);
		panel.add(lblEquipoVisitante);
		
		JLabel label = new JLabel("    1         2         3         4         5         6         7         8         9               Total");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(144, 483, 604, 22);
		panel.add(label);
		
		JSpinner TBVisJ6 = new JSpinner();
		TBVisJ6.setBounds(728, 240, 29, 20);
		panel.add(TBVisJ6);
		
		JSpinner HVisJ6 = new JSpinner();
		HVisJ6.setBounds(700, 240, 29, 20);
		panel.add(HVisJ6);
		
		JSpinner CVisJ6 = new JSpinner();
		CVisJ6.setBounds(670, 240, 29, 20);
		panel.add(CVisJ6);
		
		JSpinner TBVisJ5 = new JSpinner();
		TBVisJ5.setBounds(728, 206, 29, 20);
		panel.add(TBVisJ5);
		
		JSpinner HVisJ5 = new JSpinner();
		HVisJ5.setBounds(700, 206, 29, 20);
		panel.add(HVisJ5);
		
		JSpinner CVisJ5 = new JSpinner();
		CVisJ5.setBounds(670, 206, 29, 20);
		panel.add(CVisJ5);
		
		JSpinner CVisJ4 = new JSpinner();
		CVisJ4.setBounds(670, 176, 29, 20);
		panel.add(CVisJ4);
		
		JSpinner HVisJ4 = new JSpinner();
		HVisJ4.setBounds(700, 176, 29, 20);
		panel.add(HVisJ4);
		
		JSpinner TBVisJ4 = new JSpinner();
		TBVisJ4.setBounds(728, 176, 29, 20);
		panel.add(TBVisJ4);
		
		JSpinner TBVisJ3 = new JSpinner();
		TBVisJ3.setBounds(728, 145, 29, 20);
		panel.add(TBVisJ3);
		
		JSpinner HVisJ3 = new JSpinner();
		HVisJ3.setBounds(700, 145, 29, 20);
		panel.add(HVisJ3);
		
		JSpinner CVisJ3 = new JSpinner();
		CVisJ3.setBounds(670, 145, 29, 20);
		panel.add(CVisJ3);
		
		JSpinner CVisJ2 = new JSpinner();
		CVisJ2.setBounds(670, 114, 29, 20);
		panel.add(CVisJ2);
		
		JSpinner CVisJ1 = new JSpinner();
		CVisJ1.setBounds(670, 87, 29, 20);
		panel.add(CVisJ1);
		
		JSpinner HVisJ1 = new JSpinner();
		HVisJ1.setBounds(700, 87, 29, 20);
		panel.add(HVisJ1);
		
		JSpinner TBVisJ1 = new JSpinner();
		TBVisJ1.setBounds(728, 87, 29, 20);
		panel.add(TBVisJ1);
		
		JSpinner TBVisJ2 = new JSpinner();
		TBVisJ2.setBounds(728, 114, 29, 20);
		panel.add(TBVisJ2);
		
		JSpinner HVisJ2 = new JSpinner();
		HVisJ2.setBounds(700, 114, 29, 20);
		panel.add(HVisJ2);
		
		JSpinner TBVisJ12 = new JSpinner();
		TBVisJ12.setBounds(728, 431, 29, 20);
		panel.add(TBVisJ12);
		
		JSpinner HVisJ12 = new JSpinner();
		HVisJ12.setBounds(700, 431, 29, 20);
		panel.add(HVisJ12);
		
		JSpinner CVisJ12 = new JSpinner();
		CVisJ12.setBounds(670, 431, 29, 20);
		panel.add(CVisJ12);
		
		JSpinner CVisJ11 = new JSpinner();
		CVisJ11.setBounds(670, 397, 29, 20);
		panel.add(CVisJ11);
		
		JSpinner HVisJ11 = new JSpinner();
		HVisJ11.setBounds(700, 397, 29, 20);
		panel.add(HVisJ11);
		
		JSpinner TBVisJ11 = new JSpinner();
		TBVisJ11.setBounds(728, 397, 29, 20);
		panel.add(TBVisJ11);
		
		JSpinner TBVisJ10 = new JSpinner();
		TBVisJ10.setBounds(728, 367, 29, 20);
		panel.add(TBVisJ10);
		
		JSpinner HVisJ10 = new JSpinner();
		HVisJ10.setBounds(700, 367, 29, 20);
		panel.add(HVisJ10);
		
		JSpinner CVisJ10 = new JSpinner();
		CVisJ10.setBounds(670, 367, 29, 20);
		panel.add(CVisJ10);
		
		JSpinner CVisJ9 = new JSpinner();
		CVisJ9.setBounds(670, 336, 29, 20);
		panel.add(CVisJ9);
		
		JSpinner HVisJ9 = new JSpinner();
		HVisJ9.setBounds(700, 336, 29, 20);
		panel.add(HVisJ9);
		
		JSpinner TBVisJ9 = new JSpinner();
		TBVisJ9.setBounds(728, 336, 29, 20);
		panel.add(TBVisJ9);
		
		JSpinner TBVisJ8 = new JSpinner();
		TBVisJ8.setBounds(728, 305, 29, 20);
		panel.add(TBVisJ8);
		
		JSpinner HVisJ8 = new JSpinner();
		HVisJ8.setBounds(700, 305, 29, 20);
		panel.add(HVisJ8);
		
		JSpinner CVisJ8 = new JSpinner();
		CVisJ8.setBounds(670, 305, 29, 20);
		panel.add(CVisJ8);
		
		JSpinner CVisJ7 = new JSpinner();
		CVisJ7.setBounds(670, 278, 29, 20);
		panel.add(CVisJ7);
		
		JSpinner HVisJ7 = new JSpinner();
		HVisJ7.setBounds(700, 278, 29, 20);
		panel.add(HVisJ7);
		
		JSpinner TBVisJ7 = new JSpinner();
		TBVisJ7.setBounds(728, 278, 29, 20);
		panel.add(TBVisJ7);
		
		JSpinner TBLocJ6 = new JSpinner();
		TBLocJ6.setBounds(212, 225, 29, 20);
		panel.add(TBLocJ6);
		
		JSpinner HLocJ6 = new JSpinner();
		HLocJ6.setBounds(184, 225, 29, 20);
		panel.add(HLocJ6);
		
		JSpinner CLocJ6 = new JSpinner();
		CLocJ6.setBounds(154, 225, 29, 20);
		panel.add(CLocJ6);
		
		JSpinner CLocJ5 = new JSpinner();
		CLocJ5.setBounds(154, 191, 29, 20);
		panel.add(CLocJ5);
		
		JSpinner HLocJ5 = new JSpinner();
		HLocJ5.setBounds(184, 191, 29, 20);
		panel.add(HLocJ5);
		
		JSpinner TBLocJ5 = new JSpinner();
		TBLocJ5.setBounds(212, 191, 29, 20);
		panel.add(TBLocJ5);
		
		JSpinner TBLocJ4 = new JSpinner();
		TBLocJ4.setBounds(212, 161, 29, 20);
		panel.add(TBLocJ4);
		
		JSpinner HLocJ4 = new JSpinner();
		HLocJ4.setBounds(184, 161, 29, 20);
		panel.add(HLocJ4);
		
		JSpinner CLocJ4 = new JSpinner();
		CLocJ4.setBounds(154, 161, 29, 20);
		panel.add(CLocJ4);
		
		JSpinner CLocJ3 = new JSpinner();
		CLocJ3.setBounds(154, 130, 29, 20);
		panel.add(CLocJ3);
		
		JSpinner HLocJ3 = new JSpinner();
		HLocJ3.setBounds(184, 130, 29, 20);
		panel.add(HLocJ3);
		
		JSpinner TBLocJ3 = new JSpinner();
		TBLocJ3.setBounds(212, 130, 29, 20);
		panel.add(TBLocJ3);
		
		JSpinner TBLocJ2 = new JSpinner();
		TBLocJ2.setBounds(212, 99, 29, 20);
		panel.add(TBLocJ2);
		
		JSpinner HLocJ2 = new JSpinner();
		HLocJ2.setBounds(184, 99, 29, 20);
		panel.add(HLocJ2);
		
		JSpinner CLocJ2 = new JSpinner();
		CLocJ2.setBounds(154, 99, 29, 20);
		panel.add(CLocJ2);
		
		JSpinner CLocJ1 = new JSpinner();
		CLocJ1.setBounds(154, 72, 29, 20);
		panel.add(CLocJ1);
		
		JSpinner HLocJ1 = new JSpinner();
		HLocJ1.setBounds(184, 72, 29, 20);
		panel.add(HLocJ1);
		
		JSpinner TBLocJ1 = new JSpinner();
		TBLocJ1.setBounds(212, 72, 29, 20);
		panel.add(TBLocJ1);
		
		JSpinner TBLocJ12 = new JSpinner();
		TBLocJ12.setBounds(212, 416, 29, 20);
		panel.add(TBLocJ12);
		
		JSpinner HLocJ12 = new JSpinner();
		HLocJ12.setBounds(184, 416, 29, 20);
		panel.add(HLocJ12);
		
		JSpinner CLocJ12 = new JSpinner();
		CLocJ12.setBounds(154, 416, 29, 20);
		panel.add(CLocJ12);
		
		JSpinner CLocJ11 = new JSpinner();
		CLocJ11.setBounds(154, 382, 29, 20);
		panel.add(CLocJ11);
		
		JSpinner HLocJ11 = new JSpinner();
		HLocJ11.setBounds(184, 382, 29, 20);
		panel.add(HLocJ11);
		
		JSpinner TBLocJ11 = new JSpinner();
		TBLocJ11.setBounds(212, 382, 29, 20);
		panel.add(TBLocJ11);
		
		JSpinner TBLocJ10 = new JSpinner();
		TBLocJ10.setBounds(212, 352, 29, 20);
		panel.add(TBLocJ10);
		
		JSpinner HLocJ10 = new JSpinner();
		HLocJ10.setBounds(184, 352, 29, 20);
		panel.add(HLocJ10);
		
		JSpinner CLocJ10 = new JSpinner();
		CLocJ10.setBounds(154, 352, 29, 20);
		panel.add(CLocJ10);
		
		JSpinner CLocJ9 = new JSpinner();
		CLocJ9.setBounds(154, 321, 29, 20);
		panel.add(CLocJ9);
		
		JSpinner HLocJ9 = new JSpinner();
		HLocJ9.setBounds(184, 321, 29, 20);
		panel.add(HLocJ9);
		
		JSpinner TBLocJ9 = new JSpinner();
		TBLocJ9.setBounds(212, 321, 29, 20);
		panel.add(TBLocJ9);
		
		JSpinner TBLocJ8 = new JSpinner();
		TBLocJ8.setBounds(212, 290, 29, 20);
		panel.add(TBLocJ8);
		
		JSpinner HLocJ8 = new JSpinner();
		HLocJ8.setBounds(184, 290, 29, 20);
		panel.add(HLocJ8);
		
		JSpinner CLocJ8 = new JSpinner();
		CLocJ8.setBounds(154, 290, 29, 20);
		panel.add(CLocJ8);
		
		JSpinner CLocJ7 = new JSpinner();
		CLocJ7.setBounds(154, 263, 29, 20);
		panel.add(CLocJ7);
		
		JSpinner HLocJ7 = new JSpinner();
		HLocJ7.setBounds(184, 263, 29, 20);
		panel.add(HLocJ7);
		
		JSpinner TBLocJ7 = new JSpinner();
		TBLocJ7.setBounds(212, 263, 29, 20);
		panel.add(TBLocJ7);
		
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
		lblLocal.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		
		JSpinner CLoc1 = new JSpinner();
		CLoc1.setBounds(131, 20, 44, 39);
		panel_2.add(CLoc1);
		
		JSpinner CLoc2 = new JSpinner();
		CLoc2.setBounds(186, 20, 44, 39);
		panel_2.add(CLoc2);
		
		JSpinner CLoc3 = new JSpinner();
		CLoc3.setBounds(242, 20, 44, 39);
		panel_2.add(CLoc3);
		
		JSpinner CLoc4 = new JSpinner();
		CLoc4.setBounds(295, 20, 44, 39);
		panel_2.add(CLoc4);
		
		JSpinner CLoc5 = new JSpinner();
		CLoc5.setBounds(348, 20, 44, 39);
		panel_2.add(CLoc5);
		
		JSpinner CLoc6 = new JSpinner();
		CLoc6.setBounds(401, 20, 38, 39);
		panel_2.add(CLoc6);
		
		JSpinner CLoc7 = new JSpinner();
		CLoc7.setBounds(454, 20, 38, 39);
		panel_2.add(CLoc7);
		
		JSpinner CLoc8 = new JSpinner();
		CLoc8.setBounds(507, 20, 38, 39);
		panel_2.add(CLoc8);
		
		JSpinner CLoc9 = new JSpinner();
		CLoc9.setBounds(560, 20, 38, 39);
		panel_2.add(CLoc9);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(182, 16, 2, 46);
		panel_2.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(234, 16, 2, 46);
		panel_2.add(separator_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(15, 92, 625, 72);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblVisitantes = new JLabel("Visitantes");
		lblVisitantes.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblVisitantes.setBounds(15, 28, 105, 28);
		panel_3.add(lblVisitantes);
		
		JSpinner CVis2 = new JSpinner();
		CVis2.setBounds(190, 25, 38, 39);
		panel_3.add(CVis2);
		
		JSpinner CVis1 = new JSpinner();
		CVis1.setBounds(137, 22, 38, 39);
		panel_3.add(CVis1);
		
		JSpinner CVis3 = new JSpinner();
		CVis3.setBounds(242, 22, 38, 39);
		panel_3.add(CVis3);
		
		JSpinner CVis4 = new JSpinner();
		CVis4.setBounds(295, 22, 38, 39);
		panel_3.add(CVis4);
		
		JSpinner CVis5 = new JSpinner();
		CVis5.setBounds(348, 22, 38, 39);
		panel_3.add(CVis5);
		
		JSpinner CVis6 = new JSpinner();
		CVis6.setBounds(401, 22, 38, 39);
		panel_3.add(CVis6);
		
		JSpinner CVis7 = new JSpinner();
		CVis7.setBounds(454, 22, 38, 39);
		panel_3.add(CVis7);
		
		JSpinner CVis8 = new JSpinner();
		CVis8.setBounds(507, 22, 38, 39);
		panel_3.add(CVis8);
		
		JSpinner CVis9 = new JSpinner();
		CVis9.setBounds(560, 22, 38, 39);
		panel_3.add(CVis9);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(645, 16, 142, 148);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_1 = new JLabel("C");
		label_1.setBounds(20, 6, 17, 20);
		panel_4.add(label_1);
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("H");
		label_2.setBounds(64, 6, 17, 20);
		panel_4.add(label_2);
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
		JLabel lblE = new JLabel("E");
		lblE.setBounds(106, 6, 17, 20);
		panel_4.add(lblE);
		lblE.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setBounds(6, 28, 42, 45);
		panel_4.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(50, 28, 42, 45);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 28, 42, 45);
		panel_4.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(6, 87, 42, 45);
		panel_4.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(50, 87, 42, 45);
		panel_4.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(94, 87, 42, 45);
		panel_4.add(textField_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 80, 130, 2);
		panel_4.add(separator);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 46, 269, 421);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_11 = new JLabel("Jugador 6");
		label_11.setBounds(15, 183, 119, 20);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("Jugador 5");
		label_12.setBounds(15, 152, 119, 20);
		panel_5.add(label_12);
		
		JLabel label_13 = new JLabel("Jugador 4");
		label_13.setBounds(15, 121, 119, 20);
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("Jugador 3");
		label_14.setBounds(15, 90, 119, 20);
		panel_5.add(label_14);
		
		JLabel label_15 = new JLabel("Jugador 2");
		label_15.setBounds(15, 59, 119, 20);
		panel_5.add(label_15);
		
		JLabel label_16 = new JLabel("Jugador 1");
		label_16.setBounds(15, 28, 119, 20);
		panel_5.add(label_16);
		
		JLabel lblJugador_16 = new JLabel("Jugador 12");
		lblJugador_16.setBounds(15, 374, 119, 20);
		panel_5.add(lblJugador_16);
		
		JLabel lblJugador_13 = new JLabel("Jugador 11");
		lblJugador_13.setBounds(15, 343, 119, 20);
		panel_5.add(lblJugador_13);
		
		JLabel lblJugador_11 = new JLabel("Jugador 10");
		lblJugador_11.setBounds(15, 312, 119, 20);
		panel_5.add(lblJugador_11);
		
		JLabel lblJugador_5 = new JLabel("Jugador 9");
		lblJugador_5.setBounds(15, 281, 119, 20);
		panel_5.add(lblJugador_5);
		
		JLabel lblJugador_2 = new JLabel("Jugador 8");
		lblJugador_2.setBounds(15, 250, 119, 20);
		panel_5.add(lblJugador_2);
		
		JLabel lblJugador = new JLabel("Jugador 7");
		lblJugador.setBounds(15, 219, 119, 20);
		panel_5.add(lblJugador);
		
		JLabel label_17 = new JLabel("  C       H      TB");
		label_17.setBounds(147, 0, 87, 20);
		panel_5.add(label_17);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(491, 47, 277, 415);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_5 = new JLabel("Jugador 1");
		label_5.setBounds(46, 33, 122, 20);
		panel_6.add(label_5);
		
		JLabel lblJugador_9 = new JLabel("Jugador 2");
		lblJugador_9.setBounds(46, 64, 122, 20);
		panel_6.add(lblJugador_9);
		
		JLabel lblJugador_10 = new JLabel("Jugador 3");
		lblJugador_10.setBounds(46, 95, 122, 20);
		panel_6.add(lblJugador_10);
		
		JLabel lblJugador_4 = new JLabel("Jugador 4");
		lblJugador_4.setBounds(46, 126, 122, 20);
		panel_6.add(lblJugador_4);
		
		JLabel lblJugador_6 = new JLabel("Jugador 5");
		lblJugador_6.setBounds(46, 157, 122, 20);
		panel_6.add(lblJugador_6);
		
		JLabel lblJugador_8 = new JLabel("Jugador 6");
		lblJugador_8.setBounds(46, 188, 122, 20);
		panel_6.add(lblJugador_8);
		
		JLabel lblJugador_15 = new JLabel("Jugador 12");
		lblJugador_15.setBounds(46, 379, 122, 20);
		panel_6.add(lblJugador_15);
		
		JLabel lblJugador_14 = new JLabel("Jugador 11");
		lblJugador_14.setBounds(46, 348, 122, 20);
		panel_6.add(lblJugador_14);
		
		JLabel lblJugador_12 = new JLabel("Jugador 10");
		lblJugador_12.setBounds(46, 317, 122, 20);
		panel_6.add(lblJugador_12);
		
		JLabel lblJugador_7 = new JLabel("Jugador 9");
		lblJugador_7.setBounds(46, 286, 122, 20);
		panel_6.add(lblJugador_7);
		
		JLabel lblJugador_3 = new JLabel("Jugador 8");
		lblJugador_3.setBounds(46, 255, 122, 20);
		panel_6.add(lblJugador_3);
		
		JLabel lblJugador_1 = new JLabel("Jugador 7");
		lblJugador_1.setBounds(46, 224, 122, 20);
		panel_6.add(lblJugador_1);
		
		JLabel label_10 = new JLabel("  C       H      TB");
		label_10.setBounds(175, 16, 87, 20);
		panel_6.add(label_10);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CLoc = (int)CLoc1.getValue();
						CLoc += (int)CLoc2.getValue();
						CLoc += (int)CLoc3.getValue();
						CLoc += (int)CLoc4.getValue();
						CLoc += (int)CLoc5.getValue();
						CLoc += (int)CLoc6.getValue();
						CLoc += (int)CLoc7.getValue();
						CLoc += (int)CLoc8.getValue();
						CLoc += (int)CLoc9.getValue();
						CVis = (int)CVis1.getValue();
						CVis += (int)CVis2.getValue();
						CVis += (int)CVis3.getValue();
						CVis += (int)CVis4.getValue();
						CVis += (int)CVis5.getValue();
						CVis += (int)CVis6.getValue();
						CVis += (int)CVis7.getValue();
						CVis += (int)CVis8.getValue();
						CVis += (int)CVis9.getValue();
						
							//CLoc1+CLoc2+CLoc3+CLoc4+CLoc5+CLoc6+CLoc7+CLoc8+CLoc9;
					}
				});
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
	}
}
