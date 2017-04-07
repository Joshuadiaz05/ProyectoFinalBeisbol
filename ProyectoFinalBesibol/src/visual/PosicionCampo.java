package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Equipos;
import logical.Jugadores;
import logical.LigaBeisbol;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;

public class PosicionCampo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSegundaBase;
	private String seleccionarjugador;
	private String nombre = "";
	private String apellido = "";

	public PosicionCampo() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 794, 800);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnCenterField = new JButton("C.F");
		btnCenterField.setBounds(386, 165, 46, 28);
		contentPanel.add(btnCenterField);
		
		JLabel lblCenterField = new JLabel("Center Field");
		lblCenterField.setHorizontalAlignment(SwingConstants.CENTER);
		lblCenterField.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCenterField.setBounds(330, 196, 159, 20);
		contentPanel.add(lblCenterField);
		
		JLabel lblRigthfield = new JLabel("Rigth Field");
		lblRigthfield.setHorizontalAlignment(SwingConstants.CENTER);
		lblRigthfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRigthfield.setBounds(541, 244, 159, 20);
		contentPanel.add(lblRigthfield);
		
		JButton btnRf = new JButton("R.F");
		btnRf.setBounds(597, 214, 46, 28);
		contentPanel.add(btnRf);
		
		JButton btnLf = new JButton("L.F");
		btnLf.setBounds(193, 213, 46, 28);
		contentPanel.add(btnLf);
		
		JLabel lblLefthField = new JLabel("Lefth Field");
		lblLefthField.setHorizontalAlignment(SwingConstants.CENTER);
		lblLefthField.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLefthField.setBounds(124, 244, 184, 20);
		contentPanel.add(lblLefthField);
		
		JButton btnTb = new JButton("T.B");
		btnTb.setBounds(248, 489, 39, 28);
		contentPanel.add(btnTb);
		
		JLabel lblTerceraBase = new JLabel("Tercera Base");
		lblTerceraBase.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerceraBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTerceraBase.setBounds(191, 470, 153, 20);
		contentPanel.add(lblTerceraBase);
		
		lblSegundaBase = new JLabel("Segunda Base");
		lblSegundaBase.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundaBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSegundaBase.setBounds(323, 370, 172, 20);
		contentPanel.add(lblSegundaBase);
		
		JButton btnSb = new JButton("S.B");
		btnSb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Segunda base")) {
						jugadores.add(aux.getNombre().toString());
					}
				}
				String[] jugadoresArr = new String[jugadores.size()];
				jugadoresArr = jugadores.toArray(jugadoresArr);
				seleccionarjugador = (String) JOptionPane.showInputDialog(null, 
				        "Seleccione un jugador",
				        "Seleccionar Jugador",
				        JOptionPane.QUESTION_MESSAGE, 
				        null, 
				        jugadoresArr,
				        jugadoresArr[0]);
					lblSegundaBase.setText(seleccionarjugador);
			}
		});
		btnSb.setBounds(386, 335, 46, 28);
		contentPanel.add(btnSb);
		
		JLabel lblPrimeraBase = new JLabel("Primera Base");
		lblPrimeraBase.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimeraBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrimeraBase.setBounds(439, 470, 205, 20);
		contentPanel.add(lblPrimeraBase);
		
		JButton btnPb = new JButton("P.B");
		btnPb.setBounds(522, 489, 39, 28);
		contentPanel.add(btnPb);
		
		JLabel lblPitcher = new JLabel("Pitcher");
		lblPitcher.setHorizontalAlignment(SwingConstants.CENTER);
		lblPitcher.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPitcher.setBounds(315, 515, 178, 20);
		contentPanel.add(lblPitcher);
		
		JButton btnPitcher = new JButton("Pitcher");
		btnPitcher.setBounds(376, 489, 56, 28);
		contentPanel.add(btnPitcher);
		
		JLabel lblCatcher = new JLabel("Catcher");
		lblCatcher.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatcher.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCatcher.setBounds(303, 610, 196, 20);
		contentPanel.add(lblCatcher);
		
		JButton btnCatcher = new JButton("C");
		btnCatcher.setBounds(384, 638, 35, 28);
		contentPanel.add(btnCatcher);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 784, 728);
		contentPanel.add(label);
		label.setIcon(new ImageIcon("img/CampoBeis.jpg"));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							if(aux.getPosicion().equalsIgnoreCase("Segunda base")){
								if(aux.isTitular()==true){
									aux.setTitular(false);
								}
								if(aux.getNombre().equalsIgnoreCase(seleccionarjugador)){
									aux.setTitular(true);
								}
							}
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarJugadorLabel();
	}
	public void cargarJugadorLabel(){
		Equipos aux = LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo);
		for (Jugadores j : aux.getJugador()) {
			if(j.getPosicion().equalsIgnoreCase("Segunda base")){
				if(j.isTitular()==true){
					lblSegundaBase.setText(j.getNombre().toString() + " " + j.getApellido().toString());
				}
			}
		}
	}
}
