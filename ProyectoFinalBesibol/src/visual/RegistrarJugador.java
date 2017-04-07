package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import com.toedter.calendar.JDateChooser;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import logical.Equipos;
import logical.Jugadores;
import logical.LigaBeisbol;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class RegistrarJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnombre;
	private JTextField textapellido;
	private JTextField textlugarnacimiento;
	private JTextField textUniversidad;
	private JSpinner spinneraltura;
	private JSpinner spinnerpeso;
	private JSpinner spinnernumero;
	private JComboBox cBposicion;
	private JComboBox cBpais;
	private JComboBox cBEquipo;
	private JDateChooser dateChooser;
	
	public RegistrarJugador() {
		setTitle("Registrar Jugador");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imag/baseball.png"));
		setBounds(100, 100, 540, 442);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ArrayList<String> equipos = new ArrayList<String>();
			for (int i = 0; i < LigaBeisbol.getInstance().getEquipo().size(); i++) {
				equipos.add(LigaBeisbol.getInstance().getEquipo().get(i).getNombre());
			}
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 504, 348);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblNombre = new JLabel("Nombres");
			lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblNombre.setBounds(10, 11, 71, 18);
			panel.add(lblNombre);

			textnombre = new JTextField();
			textnombre.setBounds(10, 34, 225, 20);
			panel.add(textnombre);
			textnombre.setColumns(10);

			JLabel lblApellidos = new JLabel("Apellidos");
			lblApellidos.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblApellidos.setBounds(270, 11, 71, 18);
			panel.add(lblApellidos);

			textapellido = new JTextField();
			textapellido.setColumns(10);
			textapellido.setBounds(270, 34, 225, 20);
			panel.add(textapellido);

			JLabel lblFechaDeNaciomiento = new JLabel("Fecha de Nacimiento");
			lblFechaDeNaciomiento.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblFechaDeNaciomiento.setBounds(10, 69, 166, 18);
			panel.add(lblFechaDeNaciomiento);

			dateChooser = new JDateChooser();
			dateChooser.setBounds(10, 94, 225, 20);
			panel.add(dateChooser);

			JLabel lblPas = new JLabel("Pa\u00EDs");
			lblPas.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblPas.setBounds(270, 69, 71, 18);
			panel.add(lblPas);

			cBpais = new JComboBox();
			cBpais.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Afganist\u00E1n", "Albania",
					"Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina",
					"Armenia", "Australia", "Austria", "Azerbaiy\u00E1n", "Bahamas", "Banglad\u00E9s", "Barbados",
					"Bar\u00E9in", "B\u00E9lgica", "Belice", "Ben\u00EDn", "Bielorrusia", "Birmania", "Bolivia",
					"Bosnia y Herzegovina", "Botsuana", "Brasil", "Brun\u00E9i", "Bulgaria", "Burkina Faso", "Burundi",
					"But\u00E1n", "Cabo Verde", "Camboya", "Camer\u00FAn", "Canad\u00E1", "Catar", "Chad", "Chile",
					"China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur",
					"Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto",
					"El Salvador", "Emiratos \u00C1rabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "Espa\u00F1a",
					"Estados Unidos", "Estonia", "Etiop\u00EDa", "Filipinas", "Finlandia", "Fiyi", "Francia",
					"Gab\u00F3n", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea",
					"Guinea ecuatorial", "Guinea-Bis\u00E1u", "Hait\u00ED", "Honduras", "Hungr\u00EDa", "India",
					"Indonesia", "Irak", "Ir\u00E1n", "Irlanda", "Islandia", "Islas Marshall", "Islas Salom\u00F3n",
					"Israel", "Italia", "Jamaica", "Jap\u00F3n", "Jordania", "Kazajist\u00E1n", "Kenia",
					"Kirguist\u00E1n", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "L\u00EDbano", "Liberia",
					"Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas",
					"Mal\u00ED", "Malta", "Marruecos", "Mauricio", "Mauritania", "M\u00E9xico", "Micronesia",
					"Moldavia", "M\u00F3naco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal",
					"Nicaragua", "N\u00EDger", "Nigeria", "Noruega", "Nueva Zelanda", "Om\u00E1n", "Pa\u00EDses Bajos",
					"Pakist\u00E1n", "Palaos", "Panam\u00E1", "Pap\u00FAa Nueva Guinea", "Paraguay", "Per\u00FA",
					"Polonia", "Portugal", "Reino Unido", "Rep\u00FAblica Centroafricana", "Rep\u00FAblica Checa",
					"Rep\u00FAblica de Macedonia", "Rep\u00FAblica del Congo",
					"Rep\u00FAblica Democr\u00E1tica del Congo", "Rep\u00FAblica Dominicana",
					"Rep\u00FAblica Sudafricana", "Ruanda", "Ruman\u00EDa", "Rusia", "Samoa",
					"San Crist\u00F3bal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Luc\u00EDa",
					"Santo Tom\u00E9 y Pr\u00EDncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur",
					"Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sud\u00E1n", "Sud\u00E1n del Sur", "Suecia",
					"Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikist\u00E1n", "Timor Oriental", "Togo", "Tonga",
					"Trinidad y Tobago", "T\u00FAnez", "Turkmenist\u00E1n", "Turqu\u00EDa", "Tuvalu", "Ucrania",
					"Uganda", "Uruguay", "Uzbekist\u00E1n", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti",
					"Zambia", "Zimbabue" }));
			cBpais.setSelectedIndex(0);
			cBpais.setBounds(270, 94, 225, 20);
			panel.add(cBpais);

			JLabel lblCiudad = new JLabel("Lugar de Nacimiento");
			lblCiudad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblCiudad.setBounds(10, 126, 166, 18);
			panel.add(lblCiudad);

			textlugarnacimiento = new JTextField();
			textlugarnacimiento.setBounds(10, 151, 485, 20);
			panel.add(textlugarnacimiento);
			textlugarnacimiento.setColumns(10);

			JLabel lblPeso = new JLabel("Peso");
			lblPeso.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblPeso.setBounds(10, 246, 71, 18);
			panel.add(lblPeso);

			spinnerpeso = new JSpinner();
			spinnerpeso.setModel(new SpinnerNumberModel(new Integer(130), new Integer(1), null, new Integer(1)));
			spinnerpeso.setBounds(66, 247, 71, 20);
			panel.add(spinnerpeso);

			JLabel lblAltura = new JLabel("Altura");
			lblAltura.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblAltura.setBounds(180, 247, 63, 18);
			panel.add(lblAltura);

			spinneraltura = new JSpinner();
			spinneraltura.setModel(new SpinnerNumberModel(new Integer(170), null, null, new Integer(1)));
			spinneraltura.setBounds(244, 247, 71, 20);
			panel.add(spinneraltura);

			JLabel lblPosicin = new JLabel("Posici\u00F3n");
			lblPosicin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblPosicin.setBounds(10, 188, 119, 18);
			panel.add(lblPosicin);

			cBposicion = new JComboBox();
			cBposicion.setModel(new DefaultComboBoxModel(
					new String[] { "Pitcher", "Catcher", "Primera base", "Segunda base", "Tercera base", "Short stop",
							"Left fielder", "Center fielder", "Right fielder", "Bateador designado" }));
			cBposicion.setSelectedIndex(0);
			cBposicion.setBounds(10, 212, 232, 20);
			panel.add(cBposicion);

			JLabel lblUniversidad = new JLabel("Universidad");
			lblUniversidad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblUniversidad.setBounds(270, 188, 144, 18);
			panel.add(lblUniversidad);

			textUniversidad = new JTextField();
			textUniversidad.setColumns(10);
			textUniversidad.setBounds(270, 212, 225, 20);
			panel.add(textUniversidad);

			JLabel lblEquipo = new JLabel("Equipo");
			lblEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblEquipo.setBounds(10, 283, 63, 18);
			panel.add(lblEquipo);

			cBEquipo = new JComboBox(equipos.toArray());
			cBEquipo.setBounds(10, 312, 485, 20);
			panel.add(cBEquipo);
			
			JLabel lblNumero = new JLabel("Numero");
			lblNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblNumero.setBounds(351, 246, 63, 18);
			panel.add(lblNumero);
			
			spinnernumero = new JSpinner();
			spinnernumero.setBounds(423, 247, 72, 20);
			panel.add(spinnernumero);
			
			JLabel lblLb = new JLabel("Kg");
			lblLb.setBounds(140, 250, 22, 14);
			panel.add(lblLb);
			
			JLabel lblCm = new JLabel("Cm");
			lblCm.setBounds(319, 250, 22, 14);
			panel.add(lblCm);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textnombre.getText().equalsIgnoreCase("") || textapellido.getText().equalsIgnoreCase("") || textlugarnacimiento.getText().equalsIgnoreCase("") || textUniversidad.getText().equalsIgnoreCase("")){
							JOptionPane.showMessageDialog(null, "Por favor! Complete todos los Campos", null,
									JOptionPane.WARNING_MESSAGE, null);
						}else{
							String nom = textnombre.getText();
							String apell = textapellido.getText();
							String ciudad = textlugarnacimiento.getText();
							String univ = textUniversidad.getText();
							int numero = Integer.parseInt(spinnernumero.getValue().toString());
							double peso = Integer.parseInt(spinnerpeso.getValue().toString());
							double altura = Integer.parseInt(spinneraltura.getValue().toString());
							String posicion = cBposicion.getSelectedItem().toString();
							String pais = cBpais.getSelectedItem().toString();
							String equipotext =  cBEquipo.getSelectedItem().toString();
							Equipos equipo = LigaBeisbol.getInstance().BuscarPorNombre(equipotext);
							Date fechanacimiento = dateChooser.getDate();
							Jugadores nuevojugador = new Jugadores(numero, nom, apell, peso, posicion, altura, fechanacimiento, ciudad, pais, univ, equipotext);
							equipo.agregarjugador(nuevojugador);
							LigaBeisbol.getInstance().insertarJugador(nuevojugador);
							JOptionPane.showMessageDialog(null, "El jugador " + nom +" se ha registrado sasctifactoriamente!", null,
									JOptionPane.INFORMATION_MESSAGE, null);
							clean();
						}
						
					}
				});
				okButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
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
				cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void clean(){
		textnombre.setText("");
		textapellido.setText("");
		textlugarnacimiento.setText("");
		textUniversidad.setText("");
		spinnernumero.setValue(1);
		spinnerpeso.setValue(1);
		spinneraltura.setValue(120);
		cBposicion.setSelectedItem(0);
		cBpais.setSelectedItem(0);
		cBEquipo.setSelectedItem(0);
	}
}
