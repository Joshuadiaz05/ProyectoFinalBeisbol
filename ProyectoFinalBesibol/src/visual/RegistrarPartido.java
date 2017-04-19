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
import java.util.Locale;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import logical.LigaBeisbol;
import logical.Partido;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class RegistrarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JDateChooser dateChooser;
	private String nomlocal;
	private String nomvisita;
	private JComboBox cBvisita;
	private JComboBox cBoxHora, cBlocal;
	
	public RegistrarPartido(boolean update, Partido miPartido) {
		setResizable(false);
		setModal(true);
		setTitle("Registrar Partido");
		setBounds(100, 100, 534, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 511, 350);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 95, 231, 32);
		panel.add(dateChooser);
		
		ArrayList<String> equipLocal = new ArrayList<String>();
		equipLocal.add("<Seleccione Equipo>");
		for (int index = 0; index < LigaBeisbol.getInstance().getEquipo().size(); index++) {			
			equipLocal.add("" + LigaBeisbol.getInstance().getEquipo().get(index).getNombre());
		}
		
		cBlocal = new JComboBox(equipLocal.toArray());
		cBlocal.setSelectedIndex(0);
		cBlocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nomlocal = cBlocal.getSelectedItem().toString();
					textField.setText(LigaBeisbol.getInstance().BuscarPorNombre(nomlocal).getEstadio());
					cBvisita.setEnabled(true);
					cBvisita.removeAllItems();
					for (String aux : equipLocal) {
						if(nomlocal!=aux){
							cBvisita.addItem(aux);
						}
					}
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "Selecciona el equipo correctamente", "Error", JOptionPane.WARNING_MESSAGE);
					cBlocal.setSelectedIndex(1);
				}
			}
		});
		cBlocal.setBounds(10, 176, 231, 32);
		panel.add(cBlocal);
			
		ArrayList<String> equipVisita = new ArrayList<String>();
		equipVisita.add("<Seleccione Equipo>");
		cBvisita = new JComboBox(equipVisita.toArray());
		cBvisita.setSelectedIndex(0);
		cBvisita.setEnabled(false);
		cBvisita.setBounds(270, 176, 231, 32);
		panel.add(cBvisita);
		
		JLabel lblEquipoLocal = new JLabel("Equipo Local");
		lblEquipoLocal.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEquipoLocal.setBounds(77, 151, 97, 25);
		panel.add(lblEquipoLocal);
		
		JLabel lblEquipoVisita = new JLabel("Equipo Visita");
		lblEquipoVisita.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEquipoVisita.setBounds(334, 151, 103, 25);
		panel.add(lblEquipoVisita);
		
		JLabel lblEstadio = new JLabel("Estadio");
		lblEstadio.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEstadio.setBounds(225, 239, 60, 25);
		panel.add(lblEstadio);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(140, 266, 231, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFechaDePartido = new JLabel("Fecha de Partido");
		lblFechaDePartido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblFechaDePartido.setBounds(61, 71, 128, 25);
		panel.add(lblFechaDePartido);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblHorario.setBounds(352, 71, 66, 25);
		panel.add(lblHorario);
		
		cBoxHora = new JComboBox();
		cBoxHora.setModel(new DefaultComboBoxModel(new String[] {"8:00 Am", "9:00 Am", "10:00 Am", "11:00 Am", "12:00 Pm", "1:00 Pm", "2:00 Pm", "3:00 Pm", "4:00 Pm", "5:00 Pm", "6:00 Pm", "7:00 Pm", "8:00 Pm", "9:00 Pm", "10:00 Pm"}));
		cBoxHora.setSelectedIndex(0);
		cBoxHora.setBounds(270, 95, 231, 32);
		panel.add(cBoxHora);
		
		JLabel lblRegistrarPartido = new JLabel("Registrar Partido");
		lblRegistrarPartido.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblRegistrarPartido.setBounds(10, 11, 231, 49);
		panel.add(lblRegistrarPartido);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 491, 2);
		panel.add(separator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/resgistrarpartido.png"));
		label.setBounds(225, 19, 37, 30);
		panel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(update==false){
							Date fecha = dateChooser.getDate();
							Locale spanishLocale = new Locale("es", "ES");
							DateFormat df = new SimpleDateFormat("dd MMMM yyyy", spanishLocale);
							String reportDate = df.format(fecha);
							String horario = cBoxHora.getSelectedItem().toString();
							String local = cBlocal.getSelectedItem().toString();
							String visita = cBvisita.getSelectedItem().toString();
							String estadio = textField.getText();
							
							if(cBlocal.getSelectedIndex()==0 || cBvisita.getSelectedIndex()==0 || dateChooser.getDate()==null){
								JOptionPane.showMessageDialog(null, "No dejes los espacios en blancos" , "Error", JOptionPane.WARNING_MESSAGE);
							} else if(LigaBeisbol.getInstance().verificarEquipoPartido(local, reportDate)==true || LigaBeisbol.getInstance().verificarEquipoPartido(visita, reportDate)==true){
								JOptionPane.showMessageDialog(null, "Uno de los equipos ya tiene partido para la fecha seleccionada", "Error", JOptionPane.WARNING_MESSAGE);
							}else{
								if(LigaBeisbol.getInstance().buscarPartidoBoolean(local, visita, reportDate)==true){
									JOptionPane.showMessageDialog(null, "Ya existe un evento con ambos equipo programado", "Error", JOptionPane.WARNING_MESSAGE);
								}else{
									Partido partido = new Partido(reportDate, local, visita, estadio, horario);
									LigaBeisbol.getInstance().insertarPartido(partido);
									Principal.cargar(); 
									dispose();
								}
							}
						}else{
							Date fecha = dateChooser.getDate();
							Locale spanishLocale = new Locale("es", "ES");
							DateFormat df = new SimpleDateFormat("dd MMMM yyyy", spanishLocale);
							String reportDate = df.format(fecha);
							String horario = cBoxHora.getSelectedItem().toString();
							String local = cBlocal.getSelectedItem().toString();
							String visita = cBvisita.getSelectedItem().toString();
							String estadio = textField.getText();
							if(cBlocal.getSelectedIndex()==0 || cBvisita.getSelectedIndex()==0 || dateChooser.getDate()==null){
								JOptionPane.showMessageDialog(null, "No dejes los espacios en blancos" , "Error", JOptionPane.WARNING_MESSAGE);
							}else if(LigaBeisbol.getInstance().verificarEquipoPartido(local, reportDate)==true || LigaBeisbol.getInstance().verificarEquipoPartido(visita, reportDate)==true){
								JOptionPane.showMessageDialog(null, "Uno de los equipos ya tiene partido para la fecha seleccionada", "Error", JOptionPane.WARNING_MESSAGE);
							}else{
								if(LigaBeisbol.getInstance().buscarPartidoBoolean(local, visita, reportDate)==true){
									JOptionPane.showMessageDialog(null, "Ya existe un evento con ambos equipo programado", "Error", JOptionPane.WARNING_MESSAGE);
								}else{
									miPartido.setEquipoCasa(local);
									miPartido.setEquipoVisita(visita);
									miPartido.setEstadio(estadio);
									miPartido.setFecha(reportDate);
									miPartido.setHora(horario);
									JOptionPane.showMessageDialog(null, "El partido se ha modificado correctamente", "Modificado", JOptionPane.INFORMATION_MESSAGE);
									ListadoEventos.cargar();
									Principal.cargar();
									dispose();
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if(update==true){
			cargarModificar(miPartido);
		}
	}
	
	public void cargarModificar(Partido partido){
		cBoxHora.setSelectedItem(partido.getHora());
		cBlocal.setSelectedItem(partido.getEquipoCasa());
		cBvisita.setSelectedItem(partido.getEquipoVisita());
		textField.setText(partido.getEstadio());
	}
}
