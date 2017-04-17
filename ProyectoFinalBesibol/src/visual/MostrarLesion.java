package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import java.io.*;

import logical.Jugadores;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public MostrarLesion(Jugadores jugador) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 835, 451);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel() {
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
		panel.setBounds(10, 22, 809, 166);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JPanel panel_1 = new JPanel(){
			    protected void paintComponent(Graphics g)
			    {
			        g.setColor( getBackground() );
			        g.fillRect(0, 0, getWidth(), getHeight());
			        super.paintComponent(g);
			    }
			};
			panel_1.setOpaque(false);
			panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_1.setBackground(new Color(0, 0, 0, 10));
			panel_1.setBounds(10, 11, 205, 155);
			panel.add(panel_1);
			{	
				JLabel lbFoto = new JLabel("");
				File file = new File("jugadores/" + jugador.getNombre() + ".png");
				if(!file.exists()){
					ImageIcon image = new ImageIcon("img/player_blank.png");
					lbFoto.setIcon(image);
				} else {
					ImageIcon image = new ImageIcon("jugadores/" + jugador.getNombre() + ".png");
					lbFoto.setIcon(image);
				}
				lbFoto.setHorizontalAlignment(SwingConstants.CENTER);
				panel_1.add(lbFoto);
			}
		}
		{
			JLabel lblFechaDeLa = new JLabel("Fecha de la lesion:");
			lblFechaDeLa.setBounds(225, 46, 141, 24);
			panel.add(lblFechaDeLa);
			lblFechaDeLa.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		}
		{
			JLabel label = new JLabel(jugador.getLesiones().getFechalesion());
			label.setBounds(369, 46, 149, 24);
			panel.add(label);
			label.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		}
		{
			JLabel lblTipoDeLesin = new JLabel("Tipo de lesi\u00F3n:");
			lblTipoDeLesin.setBounds(225, 80, 112, 24);
			panel.add(lblTipoDeLesin);
			lblTipoDeLesin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		}
		{
			JLabel label = new JLabel(jugador.getLesiones().getTipoLesion());
			label.setBounds(342, 81, 285, 24);
			panel.add(label);
			label.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		}
		{
			JLabel label = new JLabel(jugador.getNombre() + " " + jugador.getApellido());
			label.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
			label.setBounds(225, 8, 332, 31);
			panel.add(label);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(225, 40, 574, 2);
		panel.add(separator);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(740, 8, 59, 33);
		panel.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setBounds(10, 232, 809, 89);
		textArea.setText(jugador.getLesiones().getComentario());
		contentPanel.add(textArea);
		{
			JLabel lblNewLabel = new JLabel("Informaci\u00F3n de la lesion: ");
			lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblNewLabel.setBounds(318, 199, 193, 32);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
