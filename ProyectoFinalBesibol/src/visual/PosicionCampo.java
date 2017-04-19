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
import java.awt.Window.Type;

public class PosicionCampo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblSegundaBase;
	private JLabel lblPitcher;
	private JLabel lblTerceraBase;
	private JLabel lblPrimeraBase;
	private JLabel lblLefthField;
	private JLabel lblCenterField;
	private JLabel lblRigthfield;
	private JLabel lblCatcher;
	private String seleccionarjugador;
	private String seleccionarjugador2;
	private String seleccionarjugador3;
	private String seleccionarjugador4;
	private String seleccionarjugador5;
	private String seleccionarjugador6;
	private String seleccionarjugador7;
	private String seleccionarjugador8;
	private String seleccionarjugador9;
	private JLabel labelshortstop;

	public PosicionCampo() {
		setTitle("Posici\u00F3n en el campo");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 794, 800);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnCenterField = new JButton("C.F");
		btnCenterField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Center fielder") && !aux.isLesion()) {
						jugadores.add(aux.getNombre().toString());
						aux.setTitular(false);
					}
				}
				try {
					String[] jugadoresArr = new String[jugadores.size()];
					jugadoresArr = jugadores.toArray(jugadoresArr);
					seleccionarjugador8 = (String) JOptionPane.showInputDialog(null, 
					        "Seleccione un jugador",
					        "Seleccionar Jugador",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        jugadoresArr,
					        jugadoresArr[0]);
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							try {
								if (seleccionarjugador8.equalsIgnoreCase(aux.getNombre())) {
									lblCenterField.setText(seleccionarjugador8);
									aux.setTitular(true);
								}
							} catch (NullPointerException e1) {
								
							}
							
						}
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "No hay jugadores", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCenterField.setBounds(386, 165, 46, 28);
		contentPanel.add(btnCenterField);
		
		lblCenterField = new JLabel("Center Field");
		lblCenterField.setHorizontalAlignment(SwingConstants.CENTER);
		lblCenterField.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCenterField.setBounds(330, 196, 159, 20);
		contentPanel.add(lblCenterField);
		
		lblRigthfield = new JLabel("Rigth Field");
		lblRigthfield.setHorizontalAlignment(SwingConstants.CENTER);
		lblRigthfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRigthfield.setBounds(541, 244, 159, 20);
		contentPanel.add(lblRigthfield);
		
		JButton btnRf = new JButton("R.F");
		btnRf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Right fielder") && !aux.isLesion()) {
						jugadores.add(aux.getNombre().toString());
						aux.setTitular(false);
					}
				}
				try {
					String[] jugadoresArr = new String[jugadores.size()];
					jugadoresArr = jugadores.toArray(jugadoresArr);
					seleccionarjugador7 = (String) JOptionPane.showInputDialog(null, 
					        "Seleccione un jugador",
					        "Seleccionar Jugador",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        jugadoresArr,
					        jugadoresArr[0]);
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							try {
								if (seleccionarjugador7.equalsIgnoreCase(aux.getNombre())) {
									lblRigthfield.setText(seleccionarjugador7);
									aux.setTitular(true);
								}
							} catch (NullPointerException e1) {
								
							}
							
						}
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "No hay jugadores", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRf.setBounds(597, 214, 46, 28);
		contentPanel.add(btnRf);
		
		JButton btnLf = new JButton("L.F");
		btnLf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Left fielder") && !aux.isLesion()) {
						jugadores.add(aux.getNombre().toString());
						aux.setTitular(false);
					}
				}
				try {
					String[] jugadoresArr = new String[jugadores.size()];
					jugadoresArr = jugadores.toArray(jugadoresArr);
					seleccionarjugador5 = (String) JOptionPane.showInputDialog(null, 
					        "Seleccione un jugador",
					        "Seleccionar Jugador",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        jugadoresArr,
					        jugadoresArr[0]);
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							try {
								if (seleccionarjugador5.equalsIgnoreCase(aux.getNombre())) {
									lblLefthField.setText(seleccionarjugador5);
									aux.setTitular(true);
								}
							} catch (NullPointerException e1) {
								
							}
							
						}
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "No hay jugadores", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLf.setBounds(193, 213, 46, 28);
		contentPanel.add(btnLf);
		
		lblLefthField = new JLabel("Lefth Field");
		lblLefthField.setHorizontalAlignment(SwingConstants.CENTER);
		lblLefthField.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLefthField.setBounds(124, 244, 184, 20);
		contentPanel.add(lblLefthField);
		
		JButton btnTb = new JButton("T.B");
		btnTb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Tercera base") && !aux.isLesion()) {
						jugadores.add(aux.getNombre().toString());
						aux.setTitular(false);
					}
				}
				try {
					String[] jugadoresArr = new String[jugadores.size()];
					jugadoresArr = jugadores.toArray(jugadoresArr);
					seleccionarjugador3 = (String) JOptionPane.showInputDialog(null, 
					        "Seleccione un jugador",
					        "Seleccionar Jugador",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        jugadoresArr,
					        jugadoresArr[0]);
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							try {
								if (seleccionarjugador3.equalsIgnoreCase(aux.getNombre())) {
									lblTerceraBase.setText(seleccionarjugador3);
									aux.setTitular(true);
								}
							} catch (NullPointerException e1) {
								
							}
							
						}
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "No hay jugadores", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnTb.setBounds(248, 489, 39, 28);
		contentPanel.add(btnTb);
		
		lblTerceraBase = new JLabel("Tercera Base");
		lblTerceraBase.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerceraBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTerceraBase.setBounds(191, 470, 153, 20);
		contentPanel.add(lblTerceraBase);
		
		lblSegundaBase = new JLabel("Segunda Base");
		lblSegundaBase.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundaBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSegundaBase.setBounds(439, 399, 172, 20);
		contentPanel.add(lblSegundaBase);
		
		JButton btnSb = new JButton("S.B");
		btnSb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Segunda base") && !aux.isLesion()) {
						jugadores.add(aux.getNombre().toString());
						aux.setTitular(false);
					}
				}
				try {
					String[] jugadoresArr = new String[jugadores.size()];
					jugadoresArr = jugadores.toArray(jugadoresArr);
					seleccionarjugador = (String) JOptionPane.showInputDialog(null, 
					        "Seleccione un jugador",
					        "Seleccionar Jugador",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        jugadoresArr,
					        jugadoresArr[0]);
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							try {
								if (seleccionarjugador.equalsIgnoreCase(aux.getNombre())) {
									lblSegundaBase.setText(seleccionarjugador);
									aux.setTitular(true);
								}
							} catch (NullPointerException e) {
								
							}
							
						}
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "No hay jugadores", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSb.setBounds(502, 368, 46, 28);
		contentPanel.add(btnSb);
		
		lblPrimeraBase = new JLabel("Primera Base");
		lblPrimeraBase.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimeraBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrimeraBase.setBounds(439, 470, 205, 20);
		contentPanel.add(lblPrimeraBase);
		
		JButton btnPb = new JButton("P.B");
		btnPb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Primera base") && !aux.isLesion()) {
						jugadores.add(aux.getNombre().toString());
						aux.setTitular(false);
					}
				}
				try {
					String[] jugadoresArr = new String[jugadores.size()];
					jugadoresArr = jugadores.toArray(jugadoresArr);
					seleccionarjugador4 = (String) JOptionPane.showInputDialog(null, 
					        "Seleccione un jugador",
					        "Seleccionar Jugador",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        jugadoresArr,
					        jugadoresArr[0]);
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							try {
								if (seleccionarjugador4.equalsIgnoreCase(aux.getNombre())) {
									lblPrimeraBase.setText(seleccionarjugador4);
									aux.setTitular(true);
								}
							} catch (NullPointerException e1) {
								
							}
							
						}
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "No hay jugadores", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPb.setBounds(522, 489, 39, 28);
		contentPanel.add(btnPb);
		
		lblPitcher = new JLabel("Pitcher");
		lblPitcher.setHorizontalAlignment(SwingConstants.CENTER);
		lblPitcher.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPitcher.setBounds(315, 515, 178, 20);
		contentPanel.add(lblPitcher);
		
		JButton btnPitcher = new JButton("Pitcher");
		btnPitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Pitcher") && !aux.isLesion()) {
						jugadores.add(aux.getNombre().toString());
						aux.setTitular(false);
					}
				}
				try {
					String[] jugadoresArr = new String[jugadores.size()];
					jugadoresArr = jugadores.toArray(jugadoresArr);
					seleccionarjugador6 = (String) JOptionPane.showInputDialog(null, 
					        "Seleccione un jugador",
					        "Seleccionar Jugador",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        jugadoresArr,
					        jugadoresArr[0]);
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							try {
								if (seleccionarjugador6.equalsIgnoreCase(aux.getNombre())) {
									lblPitcher.setText(seleccionarjugador6);
									aux.setTitular(true);
								}
							} catch (NullPointerException e1) {
								
							}
							
						}
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "No hay jugadores", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPitcher.setBounds(376, 489, 56, 28);
		contentPanel.add(btnPitcher);
		
		lblCatcher = new JLabel("Catcher");
		lblCatcher.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatcher.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCatcher.setBounds(303, 610, 196, 20);
		contentPanel.add(lblCatcher);
		
		JButton btnCatcher = new JButton("C");
		btnCatcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Catcher") && !aux.isLesion()) {
						jugadores.add(aux.getNombre().toString());
						aux.setTitular(false);
					}
				}
				try {
					String[] jugadoresArr = new String[jugadores.size()];
					jugadoresArr = jugadores.toArray(jugadoresArr);
					seleccionarjugador2 = (String) JOptionPane.showInputDialog(null, 
					        "Seleccione un jugador",
					        "Seleccionar Jugador",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        jugadoresArr,
					        jugadoresArr[0]);
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							try {
								if (seleccionarjugador2.equalsIgnoreCase(aux.getNombre())) {
									lblCatcher.setText(seleccionarjugador2);
									aux.setTitular(true);
								}
							} catch (NullPointerException e1) {
								
							}
							
						}
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "No hay jugadores", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCatcher.setBounds(384, 638, 35, 28);
		contentPanel.add(btnCatcher);
		
		JButton btnSS = new JButton("S.S");
		btnSS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> jugadores = new ArrayList<String>();
				for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
					if (aux.getPosicion().equalsIgnoreCase("Short Stop") && !aux.isLesion()) {
						jugadores.add(aux.getNombre().toString());
						aux.setTitular(false);
					}
				}
				try {
					String[] jugadoresArr = new String[jugadores.size()];
					jugadoresArr = jugadores.toArray(jugadoresArr);
					seleccionarjugador = (String) JOptionPane.showInputDialog(null, 
					        "Seleccione un jugador",
					        "Seleccionar Jugador",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        jugadoresArr,
					        jugadoresArr[0]);
						for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
							try {
								if (seleccionarjugador.equalsIgnoreCase(aux.getNombre())) {
									labelshortstop.setText(seleccionarjugador);
									aux.setTitular(true);
								}
							} catch (NullPointerException e) {
								
							}
							
						}
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null, "No hay jugadores", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSS.setBounds(284, 368, 46, 28);
		contentPanel.add(btnSS);
		
		labelshortstop = new JLabel("Short stop");
		labelshortstop.setHorizontalAlignment(SwingConstants.CENTER);
		labelshortstop.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelshortstop.setBounds(220, 400, 172, 20);
		contentPanel.add(labelshortstop);
		
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
				okButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Las posiciones fueron guardados correctamente.", null, JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarJugadorLabel();
	}
	public void cargarJugadorLabel(){
		Equipos aux = LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo);
		for (Jugadores j : aux.getJugador()) {
			if(j.getPosicion().equalsIgnoreCase("Segunda base") && j.isTitular()==true){
				lblSegundaBase.setText(j.getNombre().toString() + " " + j.getApellido().toString());
			}
			if(j.getPosicion().equalsIgnoreCase("Pitcher") && j.isTitular()==true){
				lblPitcher.setText(j.getNombre().toString() + " " + j.getApellido().toString());
			}
			if(j.getPosicion().equalsIgnoreCase("Tercera base") && j.isTitular()==true){
				lblTerceraBase.setText(j.getNombre().toString() + " " + j.getApellido().toString());
			}
			if(j.getPosicion().equalsIgnoreCase("Primera base") && j.isTitular()==true){
				lblPrimeraBase.setText(j.getNombre().toString() + " " + j.getApellido().toString());
			}
			if(j.getPosicion().equalsIgnoreCase("Catcher") && j.isTitular()==true){
				lblCatcher.setText(j.getNombre().toString() + " " + j.getApellido().toString());
			}
			if(j.getPosicion().equalsIgnoreCase("Left fielder") && j.isTitular()==true){
				lblLefthField.setText(j.getNombre().toString() + " " + j.getApellido().toString());
			}
			if(j.getPosicion().equalsIgnoreCase("Right fielder") && j.isTitular()==true){
				lblRigthfield.setText(j.getNombre().toString() + " " + j.getApellido().toString());
			}
			if(j.getPosicion().equalsIgnoreCase("Center fielder") && j.isTitular()==true){
				lblCenterField.setText(j.getNombre().toString() + " " + j.getApellido().toString());
			}if(j.getPosicion().equalsIgnoreCase("Short stop") && j.isTitular()==true){
				labelshortstop.setText(j.getNombre().toString() + " " + j.getApellido().toString());
			}
		}
	}
}
