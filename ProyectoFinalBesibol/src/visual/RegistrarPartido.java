package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPartido dialog = new RegistrarPartido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPartido() {
		setTitle("Registrar Partido");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 206);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnFecha = new JTextPane();
		txtpnFecha.setBackground(SystemColor.control);
		txtpnFecha.setText("Fecha");
		txtpnFecha.setBounds(10, 11, 40, 20);
		panel.add(txtpnFecha);
		
		JTextPane txtpnEquipoLocal = new JTextPane();
		txtpnEquipoLocal.setBackground(SystemColor.control);
		txtpnEquipoLocal.setText("Equipos");
		txtpnEquipoLocal.setBounds(10, 42, 79, 20);
		panel.add(txtpnEquipoLocal);
		
		JTextPane txtpnLocal = new JTextPane();
		txtpnLocal.setBackground(SystemColor.control);
		txtpnLocal.setText("Local");
		txtpnLocal.setBounds(10, 73, 40, 20);
		panel.add(txtpnLocal);
		
		JTextPane txtpnVisitante = new JTextPane();
		txtpnVisitante.setBackground(SystemColor.control);
		txtpnVisitante.setText("Visitante");
		txtpnVisitante.setBounds(199, 73, 48, 20);
		panel.add(txtpnVisitante);
		
		Choice Local = new Choice();
		Local.setBackground(SystemColor.textHighlightText);
		Local.setBounds(10, 99, 166, 20);
		panel.add(Local);
		
		Choice Visitante = new Choice();
		Visitante.setBackground(SystemColor.textHighlightText);
		Visitante.setBounds(199, 99, 166, 20);
		panel.add(Visitante);
		
		JTextPane txtpnEstadio = new JTextPane();
		txtpnEstadio.setBackground(SystemColor.control);
		txtpnEstadio.setText("Estadio");
		txtpnEstadio.setBounds(10, 136, 84, 20);
		panel.add(txtpnEstadio);
		
		Choice Estadio = new Choice();
		Estadio.setBackground(SystemColor.textHighlightText);
		Estadio.setBounds(10, 162, 166, 20);
		panel.add(Estadio);
		
		JTextPane txtpnHora = new JTextPane();
		txtpnHora.setBackground(SystemColor.control);
		txtpnHora.setText("Hora");
		txtpnHora.setBounds(199, 11, 34, 20);
		panel.add(txtpnHora);
		
		JSpinner Hora = new JSpinner();
		Hora.setModel(new SpinnerListModel(new String[] {"8:00 Am", "9:00 Am", "10:00 Am", "11:00 Am", "12:00 Pm", "1:00 Pm", "2:00 Pm", "3:00 Pm", "4:00 Pm", "5:00 Pm", "6:00 Pm", "7:00 Pm", "8:00 Pm", "9:00 Pm", "10:00 Pm"}));
		Hora.setBounds(243, 11, 67, 20);
		panel.add(Hora);
		
		JSpinner Fecha = new JSpinner();
		Fecha.setBounds(54, 11, 122, 20);
		panel.add(Fecha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
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
