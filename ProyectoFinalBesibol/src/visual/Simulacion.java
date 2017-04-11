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

public class Simulacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int CLoc, CVis, CLocJ, CVisJ, HLoc, HVis,HLocJ,HVisJ;
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
		setBounds(100, 100, 808, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.setBounds(10, 11, 777, 396);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblEquipoLocal = new JLabel("Equipo Local");
		lblEquipoLocal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEquipoLocal.setBounds(130, 11, 124, 20);
		panel.add(lblEquipoLocal);
		
		JLabel lblEquipoVisitante = new JLabel("Equipo Visitante");
		lblEquipoVisitante.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEquipoVisitante.setBounds(530, 11, 169, 20);
		panel.add(lblEquipoVisitante);
		
		JLabel label_5 = new JLabel("Jugador 1");
		label_5.setBounds(437, 72, 59, 20);
		panel.add(label_5);
		
		JLabel lblJugador_9 = new JLabel("Jugador 2");
		lblJugador_9.setBounds(437, 103, 59, 20);
		panel.add(lblJugador_9);
		
		JLabel lblJugador_10 = new JLabel("Jugador 3");
		lblJugador_10.setBounds(437, 134, 59, 20);
		panel.add(lblJugador_10);
		
		JLabel lblJugador_4 = new JLabel("Jugador 4");
		lblJugador_4.setBounds(437, 165, 59, 20);
		panel.add(lblJugador_4);
		
		JLabel lblJugador_6 = new JLabel("Jugador 5");
		lblJugador_6.setBounds(437, 196, 59, 20);
		panel.add(lblJugador_6);
		
		JLabel lblJugador_8 = new JLabel("Jugador 6");
		lblJugador_8.setBounds(437, 227, 59, 20);
		panel.add(lblJugador_8);
		
		JLabel lblCHTb = new JLabel("  C       H      TB");
		lblCHTb.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCHTb.setBounds(499, 42, 87, 20);
		panel.add(lblCHTb);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocal.setBounds(10, 295, 46, 14);
		panel.add(lblLocal);
		
		JLabel lblNewLabel = new JLabel("Visitante");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 339, 66, 14);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("    1         2         3         4         5         6         7         8         9            Total");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(153, 262, 604, 22);
		panel.add(label);
		
		JSpinner TBVisJ6 = new JSpinner();
		TBVisJ6.setBounds(557, 227, 29, 20);
		panel.add(TBVisJ6);
		
		JSpinner HVisJ6 = new JSpinner();
		HVisJ6.setBounds(529, 227, 29, 20);
		panel.add(HVisJ6);
		
		JSpinner CVisJ6 = new JSpinner();
		CVisJ6.setBounds(499, 227, 29, 20);
		panel.add(CVisJ6);
		
		JSpinner TBVisJ5 = new JSpinner();
		TBVisJ5.setBounds(557, 193, 29, 20);
		panel.add(TBVisJ5);
		
		JSpinner HVisJ5 = new JSpinner();
		HVisJ5.setBounds(529, 193, 29, 20);
		panel.add(HVisJ5);
		
		JSpinner CVisJ5 = new JSpinner();
		CVisJ5.setBounds(499, 193, 29, 20);
		panel.add(CVisJ5);
		
		JSpinner CVisJ4 = new JSpinner();
		CVisJ4.setBounds(499, 163, 29, 20);
		panel.add(CVisJ4);
		
		JSpinner HVisJ4 = new JSpinner();
		HVisJ4.setBounds(529, 163, 29, 20);
		panel.add(HVisJ4);
		
		JSpinner TBVisJ4 = new JSpinner();
		TBVisJ4.setBounds(557, 163, 29, 20);
		panel.add(TBVisJ4);
		
		JSpinner TBVisJ3 = new JSpinner();
		TBVisJ3.setBounds(557, 132, 29, 20);
		panel.add(TBVisJ3);
		
		JSpinner HVisJ3 = new JSpinner();
		HVisJ3.setBounds(529, 132, 29, 20);
		panel.add(HVisJ3);
		
		JSpinner CVisJ3 = new JSpinner();
		CVisJ3.setBounds(499, 132, 29, 20);
		panel.add(CVisJ3);
		
		JSpinner CVisJ2 = new JSpinner();
		CVisJ2.setBounds(499, 101, 29, 20);
		panel.add(CVisJ2);
		
		JSpinner CVisJ1 = new JSpinner();
		CVisJ1.setBounds(499, 74, 29, 20);
		panel.add(CVisJ1);
		
		JSpinner HVisJ1 = new JSpinner();
		HVisJ1.setBounds(529, 74, 29, 20);
		panel.add(HVisJ1);
		
		JSpinner TBVisJ1 = new JSpinner();
		TBVisJ1.setBounds(557, 74, 29, 20);
		panel.add(TBVisJ1);
		
		JSpinner TBVisJ2 = new JSpinner();
		TBVisJ2.setBounds(557, 101, 29, 20);
		panel.add(TBVisJ2);
		
		JSpinner HVisJ2 = new JSpinner();
		HVisJ2.setBounds(529, 101, 29, 20);
		panel.add(HVisJ2);
		
		JSpinner CLoc1 = new JSpinner();
		CLoc1.setBounds(163, 295, 29, 20);
		panel.add(CLoc1);
		
		JSpinner CLoc2 = new JSpinner();
		CLoc2.setBounds(219, 295, 29, 20);
		panel.add(CLoc2);
		
		JSpinner CLoc3 = new JSpinner();
		CLoc3.setBounds(276, 295, 29, 20);
		panel.add(CLoc3);
		
		JSpinner CLoc4 = new JSpinner();
		CLoc4.setBounds(335, 295, 29, 20);
		panel.add(CLoc4);
		
		JSpinner CLoc5 = new JSpinner();
		CLoc5.setBounds(392, 295, 29, 20);
		panel.add(CLoc5);
		
		JSpinner CLoc6 = new JSpinner();
		CLoc6.setBounds(447, 294, 29, 20);
		panel.add(CLoc6);
		
		JSpinner CLoc7 = new JSpinner();
		CLoc7.setBounds(499, 295, 29, 20);
		panel.add(CLoc7);
		
		JSpinner CLoc8 = new JSpinner();
		CLoc8.setBounds(557, 295, 29, 20);
		panel.add(CLoc8);
		
		JSpinner CLoc9 = new JSpinner();
		CLoc9.setBounds(608, 294, 29, 20);
		panel.add(CLoc9);
		
		JLabel lblNewLabel_1 = new JLabel("C");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(130, 295, 18, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(130, 318, 18, 20);
		panel.add(lblNewLabel_2);
		
		JSpinner HLoc1 = new JSpinner();
		HLoc1.setBounds(163, 317, 29, 20);
		panel.add(HLoc1);
		
		JSpinner HLoc2 = new JSpinner();
		HLoc2.setBounds(219, 317, 29, 20);
		panel.add(HLoc2);
		
		JSpinner HLoc3 = new JSpinner();
		HLoc3.setBounds(276, 317, 29, 20);
		panel.add(HLoc3);
		
		JSpinner HLoc4 = new JSpinner();
		HLoc4.setBounds(335, 317, 29, 20);
		panel.add(HLoc4);
		
		JSpinner HLoc5 = new JSpinner();
		HLoc5.setBounds(392, 317, 29, 20);
		panel.add(HLoc5);
		
		JSpinner HLoc6 = new JSpinner();
		HLoc6.setBounds(447, 316, 29, 20);
		panel.add(HLoc6);
		
		JSpinner HLoc7 = new JSpinner();
		HLoc7.setBounds(499, 317, 29, 20);
		panel.add(HLoc7);
		
		JSpinner HLoc8 = new JSpinner();
		HLoc8.setBounds(557, 317, 29, 20);
		panel.add(HLoc8);
		
		JSpinner HLoc9 = new JSpinner();
		HLoc9.setBounds(608, 316, 29, 20);
		panel.add(HLoc9);
		
		JSpinner HVis9 = new JSpinner();
		HVis9.setBounds(608, 364, 29, 20);
		panel.add(HVis9);
		
		JSpinner CVis9 = new JSpinner();
		CVis9.setBounds(608, 342, 29, 20);
		panel.add(CVis9);
		
		JSpinner CVis8 = new JSpinner();
		CVis8.setBounds(557, 343, 29, 20);
		panel.add(CVis8);
		
		JSpinner HVis8 = new JSpinner();
		HVis8.setBounds(557, 365, 29, 20);
		panel.add(HVis8);
		
		JSpinner HVis7 = new JSpinner();
		HVis7.setBounds(499, 365, 29, 20);
		panel.add(HVis7);
		
		JSpinner CVis7 = new JSpinner();
		CVis7.setBounds(499, 343, 29, 20);
		panel.add(CVis7);
		
		JSpinner CVis6 = new JSpinner();
		CVis6.setBounds(447, 342, 29, 20);
		panel.add(CVis6);
		
		JSpinner HVis6 = new JSpinner();
		HVis6.setBounds(447, 364, 29, 20);
		panel.add(HVis6);
		
		JSpinner HVis5 = new JSpinner();
		HVis5.setBounds(392, 365, 29, 20);
		panel.add(HVis5);
		
		JSpinner CVis5 = new JSpinner();
		CVis5.setBounds(392, 343, 29, 20);
		panel.add(CVis5);
		
		JSpinner CVis4 = new JSpinner();
		CVis4.setBounds(335, 343, 29, 20);
		panel.add(CVis4);
		
		JSpinner HVis4 = new JSpinner();
		HVis4.setBounds(335, 365, 29, 20);
		panel.add(HVis4);
		
		JSpinner HVis3 = new JSpinner();
		HVis3.setBounds(276, 365, 29, 20);
		panel.add(HVis3);
		
		JSpinner CVis3 = new JSpinner();
		CVis3.setBounds(276, 343, 29, 20);
		panel.add(CVis3);
		
		JSpinner CVis2 = new JSpinner();
		CVis2.setBounds(219, 343, 29, 20);
		panel.add(CVis2);
		
		JSpinner CVis1 = new JSpinner();
		CVis1.setBounds(163, 343, 29, 20);
		panel.add(CVis1);
		
		JSpinner HVis1 = new JSpinner();
		HVis1.setBounds(163, 365, 29, 20);
		panel.add(HVis1);
		
		JSpinner HVis2 = new JSpinner();
		HVis2.setBounds(219, 365, 29, 20);
		panel.add(HVis2);
		
		JLabel label_1 = new JLabel("C");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(130, 343, 17, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("H");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(130, 366, 17, 20);
		panel.add(label_2);
		
		JSpinner TBVisJ12 = new JSpinner();
		TBVisJ12.setBounds(728, 227, 29, 20);
		panel.add(TBVisJ12);
		
		JSpinner HVisJ12 = new JSpinner();
		HVisJ12.setBounds(700, 227, 29, 20);
		panel.add(HVisJ12);
		
		JSpinner CVisJ12 = new JSpinner();
		CVisJ12.setBounds(670, 227, 29, 20);
		panel.add(CVisJ12);
		
		JLabel lblJugador_15 = new JLabel("Jugador 12");
		lblJugador_15.setBounds(608, 227, 59, 20);
		panel.add(lblJugador_15);
		
		JLabel lblJugador_14 = new JLabel("Jugador 11");
		lblJugador_14.setBounds(608, 196, 59, 20);
		panel.add(lblJugador_14);
		
		JSpinner CVisJ11 = new JSpinner();
		CVisJ11.setBounds(670, 193, 29, 20);
		panel.add(CVisJ11);
		
		JSpinner HVisJ11 = new JSpinner();
		HVisJ11.setBounds(700, 193, 29, 20);
		panel.add(HVisJ11);
		
		JSpinner TBVisJ11 = new JSpinner();
		TBVisJ11.setBounds(728, 193, 29, 20);
		panel.add(TBVisJ11);
		
		JSpinner TBVisJ10 = new JSpinner();
		TBVisJ10.setBounds(728, 163, 29, 20);
		panel.add(TBVisJ10);
		
		JSpinner HVisJ10 = new JSpinner();
		HVisJ10.setBounds(700, 163, 29, 20);
		panel.add(HVisJ10);
		
		JSpinner CVisJ10 = new JSpinner();
		CVisJ10.setBounds(670, 163, 29, 20);
		panel.add(CVisJ10);
		
		JLabel lblJugador_12 = new JLabel("Jugador 10");
		lblJugador_12.setBounds(608, 165, 59, 20);
		panel.add(lblJugador_12);
		
		JLabel lblJugador_7 = new JLabel("Jugador 9");
		lblJugador_7.setBounds(608, 134, 59, 20);
		panel.add(lblJugador_7);
		
		JSpinner CVisJ9 = new JSpinner();
		CVisJ9.setBounds(670, 132, 29, 20);
		panel.add(CVisJ9);
		
		JSpinner HVisJ9 = new JSpinner();
		HVisJ9.setBounds(700, 132, 29, 20);
		panel.add(HVisJ9);
		
		JSpinner TBVisJ9 = new JSpinner();
		TBVisJ9.setBounds(728, 132, 29, 20);
		panel.add(TBVisJ9);
		
		JSpinner TBVisJ8 = new JSpinner();
		TBVisJ8.setBounds(728, 101, 29, 20);
		panel.add(TBVisJ8);
		
		JSpinner HVisJ8 = new JSpinner();
		HVisJ8.setBounds(700, 101, 29, 20);
		panel.add(HVisJ8);
		
		JSpinner CVisJ8 = new JSpinner();
		CVisJ8.setBounds(670, 101, 29, 20);
		panel.add(CVisJ8);
		
		JLabel lblJugador_3 = new JLabel("Jugador 8");
		lblJugador_3.setBounds(608, 103, 59, 20);
		panel.add(lblJugador_3);
		
		JLabel lblJugador_1 = new JLabel("Jugador 7");
		lblJugador_1.setBounds(608, 72, 59, 20);
		panel.add(lblJugador_1);
		
		JSpinner CVisJ7 = new JSpinner();
		CVisJ7.setBounds(670, 74, 29, 20);
		panel.add(CVisJ7);
		
		JSpinner HVisJ7 = new JSpinner();
		HVisJ7.setBounds(700, 74, 29, 20);
		panel.add(HVisJ7);
		
		JSpinner TBVisJ7 = new JSpinner();
		TBVisJ7.setBounds(728, 74, 29, 20);
		panel.add(TBVisJ7);
		
		JLabel label_10 = new JLabel("  C       H      TB");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(670, 42, 87, 20);
		panel.add(label_10);
		
		JSpinner TBLocJ6 = new JSpinner();
		TBLocJ6.setBounds(130, 227, 29, 20);
		panel.add(TBLocJ6);
		
		JSpinner HLocJ6 = new JSpinner();
		HLocJ6.setBounds(102, 227, 29, 20);
		panel.add(HLocJ6);
		
		JSpinner CLocJ6 = new JSpinner();
		CLocJ6.setBounds(72, 227, 29, 20);
		panel.add(CLocJ6);
		
		JLabel label_11 = new JLabel("Jugador 6");
		label_11.setBounds(10, 227, 59, 20);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Jugador 5");
		label_12.setBounds(10, 196, 59, 20);
		panel.add(label_12);
		
		JSpinner CLocJ5 = new JSpinner();
		CLocJ5.setBounds(72, 193, 29, 20);
		panel.add(CLocJ5);
		
		JSpinner HLocJ5 = new JSpinner();
		HLocJ5.setBounds(102, 193, 29, 20);
		panel.add(HLocJ5);
		
		JSpinner TBLocJ5 = new JSpinner();
		TBLocJ5.setBounds(130, 193, 29, 20);
		panel.add(TBLocJ5);
		
		JSpinner TBLocJ4 = new JSpinner();
		TBLocJ4.setBounds(130, 163, 29, 20);
		panel.add(TBLocJ4);
		
		JSpinner HLocJ4 = new JSpinner();
		HLocJ4.setBounds(102, 163, 29, 20);
		panel.add(HLocJ4);
		
		JSpinner CLocJ4 = new JSpinner();
		CLocJ4.setBounds(72, 163, 29, 20);
		panel.add(CLocJ4);
		
		JLabel label_13 = new JLabel("Jugador 4");
		label_13.setBounds(10, 165, 59, 20);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("Jugador 3");
		label_14.setBounds(10, 134, 59, 20);
		panel.add(label_14);
		
		JSpinner CLocJ3 = new JSpinner();
		CLocJ3.setBounds(72, 132, 29, 20);
		panel.add(CLocJ3);
		
		JSpinner HLocJ3 = new JSpinner();
		HLocJ3.setBounds(102, 132, 29, 20);
		panel.add(HLocJ3);
		
		JSpinner TBLocJ3 = new JSpinner();
		TBLocJ3.setBounds(130, 132, 29, 20);
		panel.add(TBLocJ3);
		
		JSpinner TBLocJ2 = new JSpinner();
		TBLocJ2.setBounds(130, 101, 29, 20);
		panel.add(TBLocJ2);
		
		JSpinner HLocJ2 = new JSpinner();
		HLocJ2.setBounds(102, 101, 29, 20);
		panel.add(HLocJ2);
		
		JSpinner CLocJ2 = new JSpinner();
		CLocJ2.setBounds(72, 101, 29, 20);
		panel.add(CLocJ2);
		
		JLabel label_15 = new JLabel("Jugador 2");
		label_15.setBounds(10, 103, 59, 20);
		panel.add(label_15);
		
		JLabel label_16 = new JLabel("Jugador 1");
		label_16.setBounds(10, 72, 59, 20);
		panel.add(label_16);
		
		JSpinner CLocJ1 = new JSpinner();
		CLocJ1.setBounds(72, 74, 29, 20);
		panel.add(CLocJ1);
		
		JSpinner HLocJ1 = new JSpinner();
		HLocJ1.setBounds(102, 74, 29, 20);
		panel.add(HLocJ1);
		
		JSpinner TBLocJ1 = new JSpinner();
		TBLocJ1.setBounds(130, 74, 29, 20);
		panel.add(TBLocJ1);
		
		JLabel label_17 = new JLabel("  C       H      TB");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_17.setBounds(72, 42, 87, 20);
		panel.add(label_17);
		
		JSpinner TBLocJ12 = new JSpinner();
		TBLocJ12.setBounds(315, 227, 29, 20);
		panel.add(TBLocJ12);
		
		JSpinner HLocJ12 = new JSpinner();
		HLocJ12.setBounds(287, 227, 29, 20);
		panel.add(HLocJ12);
		
		JSpinner CLocJ12 = new JSpinner();
		CLocJ12.setBounds(257, 227, 29, 20);
		panel.add(CLocJ12);
		
		JLabel lblJugador_16 = new JLabel("Jugador 12");
		lblJugador_16.setBounds(195, 227, 59, 20);
		panel.add(lblJugador_16);
		
		JLabel lblJugador_13 = new JLabel("Jugador 11");
		lblJugador_13.setBounds(195, 196, 59, 20);
		panel.add(lblJugador_13);
		
		JSpinner CLocJ11 = new JSpinner();
		CLocJ11.setBounds(257, 193, 29, 20);
		panel.add(CLocJ11);
		
		JSpinner HLocJ11 = new JSpinner();
		HLocJ11.setBounds(287, 193, 29, 20);
		panel.add(HLocJ11);
		
		JSpinner TBLocJ11 = new JSpinner();
		TBLocJ11.setBounds(315, 193, 29, 20);
		panel.add(TBLocJ11);
		
		JSpinner TBLocJ10 = new JSpinner();
		TBLocJ10.setBounds(315, 163, 29, 20);
		panel.add(TBLocJ10);
		
		JSpinner HLocJ10 = new JSpinner();
		HLocJ10.setBounds(287, 163, 29, 20);
		panel.add(HLocJ10);
		
		JSpinner CLocJ10 = new JSpinner();
		CLocJ10.setBounds(257, 163, 29, 20);
		panel.add(CLocJ10);
		
		JLabel lblJugador_11 = new JLabel("Jugador 10");
		lblJugador_11.setBounds(195, 165, 59, 20);
		panel.add(lblJugador_11);
		
		JLabel lblJugador_5 = new JLabel("Jugador 9");
		lblJugador_5.setBounds(195, 134, 59, 20);
		panel.add(lblJugador_5);
		
		JSpinner CLocJ9 = new JSpinner();
		CLocJ9.setBounds(257, 132, 29, 20);
		panel.add(CLocJ9);
		
		JSpinner HLocJ9 = new JSpinner();
		HLocJ9.setBounds(287, 132, 29, 20);
		panel.add(HLocJ9);
		
		JSpinner TBLocJ9 = new JSpinner();
		TBLocJ9.setBounds(315, 132, 29, 20);
		panel.add(TBLocJ9);
		
		JSpinner TBLocJ8 = new JSpinner();
		TBLocJ8.setBounds(315, 101, 29, 20);
		panel.add(TBLocJ8);
		
		JSpinner HLocJ8 = new JSpinner();
		HLocJ8.setBounds(287, 101, 29, 20);
		panel.add(HLocJ8);
		
		JSpinner CLocJ8 = new JSpinner();
		CLocJ8.setBounds(257, 101, 29, 20);
		panel.add(CLocJ8);
		
		JLabel lblJugador_2 = new JLabel("Jugador 8");
		lblJugador_2.setBounds(195, 103, 59, 20);
		panel.add(lblJugador_2);
		
		JLabel lblJugador = new JLabel("Jugador 7");
		lblJugador.setBounds(195, 72, 59, 20);
		panel.add(lblJugador);
		
		JSpinner CLocJ7 = new JSpinner();
		CLocJ7.setBounds(257, 74, 29, 20);
		panel.add(CLocJ7);
		
		JSpinner HLocJ7 = new JSpinner();
		HLocJ7.setBounds(287, 74, 29, 20);
		panel.add(HLocJ7);
		
		JSpinner TBLocJ7 = new JSpinner();
		TBLocJ7.setBounds(315, 74, 29, 20);
		panel.add(TBLocJ7);
		
		JLabel label_24 = new JLabel("  C       H      TB");
		label_24.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_24.setBounds(257, 42, 87, 20);
		panel.add(label_24);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
