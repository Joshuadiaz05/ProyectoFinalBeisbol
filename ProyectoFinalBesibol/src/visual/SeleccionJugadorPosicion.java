package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.LigaBeisbol;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionJugadorPosicion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String nombrejugador;

	public SeleccionJugadorPosicion(String posicion) {
		nombrejugador = posicion;
		setBounds(100, 100, 402, 274);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		ArrayList<String> jugadores = new ArrayList<String>();
		for (int i = 0; i < LigaBeisbol.getInstance().getEquipo().get(0).getJugador().size(); i++) {
			jugadores.add(LigaBeisbol.getInstance().getEquipo().get(0).getJugador().get(i).getNombre()+" "+LigaBeisbol.getInstance().getEquipo().get(0).getJugador().get(i).getApellido());
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 366, 175);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblHjh = new JLabel("Posici\u00F3n de "+posicion);
		lblHjh.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblHjh.setBounds(10, 11, 345, 39);
		panel.add(lblHjh);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 345, 2);
		panel.add(separator);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJugador.setBounds(10, 76, 92, 17);
		panel.add(lblJugador);
		
		JComboBox cBjugadores = new JComboBox(jugadores.toArray());
		cBjugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombrejugador = cBjugadores.getSelectedItem().toString();
			}
		});
		cBjugadores.setBounds(10, 108, 241, 20);
		panel.add(cBjugadores);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public String getNombrejugador() {
		return nombrejugador;
	}

	public void setNombrejugador(String nombrejugador) {
		this.nombrejugador = nombrejugador;
	}
}
