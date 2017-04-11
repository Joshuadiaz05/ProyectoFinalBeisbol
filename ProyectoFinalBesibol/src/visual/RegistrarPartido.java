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
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import logical.LigaBeisbol;
import logical.Partido;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class RegistrarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JDateChooser dateChooser;
	private JSpinner Hora;
	private String nomlocal;
	private String nomvisita;
	private JComboBox cBvisita;
	
	public RegistrarPartido() {
		setResizable(false);
		setModal(true);
		setTitle("Registrar Partido");
		setBounds(100, 100, 534, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 511, 279);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		Hora = new JSpinner();
		Hora.setModel(new SpinnerListModel(new String[] {"8:00 Am", "9:00 Am", "10:00 Am", "11:00 Am", "12:00 Pm", "1:00 Pm", "2:00 Pm", "3:00 Pm", "4:00 Pm", "5:00 Pm", "6:00 Pm", "7:00 Pm", "8:00 Pm", "9:00 Pm", "10:00 Pm"}));
		Hora.setBounds(270, 54, 231, 32);
		panel.add(Hora);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 54, 231, 32);
		panel.add(dateChooser);
		
		ArrayList<String> equipLocal = new ArrayList<String>();
		equipLocal.add("<Seleccione Equipo>");
		for (int index = 0; index < LigaBeisbol.getInstance().getEquipo().size(); index++) {			
			equipLocal.add("" + LigaBeisbol.getInstance().getEquipo().get(index).getNombre());
		}
		
		JComboBox cBlocal = new JComboBox(equipLocal.toArray());
		cBlocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomlocal = cBlocal.getSelectedItem().toString();
				System.out.println(""+nomlocal);
				textField.setText(""+LigaBeisbol.getInstance().BuscarPorNombre(nomlocal).getEstadio());
				cBvisita.setEnabled(true);
			}
		});
		cBlocal.setBounds(10, 135, 231, 32);
		panel.add(cBlocal);
			
		ArrayList<String> equipVisita = new ArrayList<String>();
		equipVisita.add("<Seleccione Equipo>");
		for (int index = 0; index < LigaBeisbol.getInstance().getEquipo().size(); index++) {
			equipVisita.add("" + LigaBeisbol.getInstance().getEquipo().get(index).getNombre());

		}
		
		cBvisita = new JComboBox(equipVisita.toArray());
		cBvisita.setEnabled(false);
		cBvisita.setBounds(270, 135, 231, 32);
		panel.add(cBvisita);
		
		JLabel lblEquipoLocal = new JLabel("Equipo Local");
		lblEquipoLocal.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEquipoLocal.setBounds(77, 110, 97, 25);
		panel.add(lblEquipoLocal);
		
		JLabel lblEquipoVisita = new JLabel("Equipo Visita");
		lblEquipoVisita.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEquipoVisita.setBounds(334, 110, 103, 25);
		panel.add(lblEquipoVisita);
		
		JLabel lblEstadio = new JLabel("Estadio");
		lblEstadio.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEstadio.setBounds(225, 198, 60, 25);
		panel.add(lblEstadio);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(140, 225, 231, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFechaDePartido = new JLabel("Fecha de Partido");
		lblFechaDePartido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblFechaDePartido.setBounds(61, 30, 128, 25);
		panel.add(lblFechaDePartido);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblHorario.setBounds(352, 30, 66, 25);
		panel.add(lblHorario);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Date fecha = dateChooser.getDate();
						String horario = Hora.getName();
						String local = cBlocal.getSelectedItem().toString();
						String visita = cBvisita.getSelectedItem().toString();
						String estadio = textField.getText();
						Partido partido = new Partido(fecha, local, visita, estadio, horario);
						LigaBeisbol.getInstance().insertarPartido(partido);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
