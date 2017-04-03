package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PosicionCampo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public PosicionCampo() {
		setBounds(100, 100, 800, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnCenterField = new JButton("C.F");
		btnCenterField.setBounds(386, 165, 46, 28);
		contentPanel.add(btnCenterField);
		
		JLabel lblCenterField = new JLabel("Center Field");
		lblCenterField.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCenterField.setBounds(378, 196, 97, 20);
		contentPanel.add(lblCenterField);
		
		JLabel lblRigthfield = new JLabel("Rigth Field");
		lblRigthfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRigthfield.setBounds(598, 244, 80, 20);
		contentPanel.add(lblRigthfield);
		
		JButton btnRf = new JButton("R.F");
		btnRf.setBounds(597, 214, 46, 28);
		contentPanel.add(btnRf);
		
		JButton btnLf = new JButton("L.F");
		btnLf.setBounds(193, 213, 46, 28);
		contentPanel.add(btnLf);
		
		JLabel lblLefthField = new JLabel("Lefth Field");
		lblLefthField.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLefthField.setBounds(193, 244, 80, 20);
		contentPanel.add(lblLefthField);
		
		JButton btnTb = new JButton("T.B");
		btnTb.setBounds(234, 489, 39, 28);
		contentPanel.add(btnTb);
		
		JLabel lblTerceraBase = new JLabel("Tercera Base");
		lblTerceraBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTerceraBase.setBounds(234, 470, 80, 20);
		contentPanel.add(lblTerceraBase);
		
		JLabel lblSegundaBase = new JLabel("Segunda Base");
		lblSegundaBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSegundaBase.setBounds(367, 366, 97, 20);
		contentPanel.add(lblSegundaBase);
		
		JButton btnSb = new JButton("S.B");
		btnSb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeleccionJugadorPosicion jugpos = new SeleccionJugadorPosicion("Segunda Base");
				jugpos.setVisible(true);
				lblSegundaBase.setText(""+jugpos.getNombrejugador());
			}
		});
		btnSb.setBounds(386, 335, 46, 28);
		contentPanel.add(btnSb);
		
		JLabel lblPrimeraBase = new JLabel("Primera Base");
		lblPrimeraBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrimeraBase.setBounds(495, 470, 80, 20);
		contentPanel.add(lblPrimeraBase);
		
		JButton btnPb = new JButton("P.B");
		btnPb.setBounds(542, 489, 39, 28);
		contentPanel.add(btnPb);
		
		JLabel lblPitcher = new JLabel("Pitcher");
		lblPitcher.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPitcher.setBounds(380, 515, 97, 20);
		contentPanel.add(lblPitcher);
		
		JButton btnPitcher = new JButton("Pitcher");
		btnPitcher.setBounds(376, 489, 56, 28);
		contentPanel.add(btnPitcher);
		
		JLabel lblCatcher = new JLabel("Catcher");
		lblCatcher.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCatcher.setBounds(380, 610, 97, 20);
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
	}
}
