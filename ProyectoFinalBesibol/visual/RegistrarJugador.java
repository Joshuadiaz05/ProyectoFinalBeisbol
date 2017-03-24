package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import com.toedter.calendar.JCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;
import javax.swing.JSpinner;

public class RegistrarJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnombre;
	private JTextField textapellido;
	private JTextField textlugarnacimiento;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarJugador dialog = new RegistrarJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarJugador() {
		setTitle("Registrar Jugador");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imag/baseball.png"));
		setBounds(100, 100, 725, 394);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 689, 304);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblNombre = new JLabel("Nombres");
			lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNombre.setBounds(10, 11, 71, 18);
			panel.add(lblNombre);

			textnombre = new JTextField();
			textnombre.setBounds(91, 10, 232, 20);
			panel.add(textnombre);
			textnombre.setColumns(10);

			JLabel lblApellidos = new JLabel("Apellidos");
			lblApellidos.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblApellidos.setBounds(360, 11, 71, 18);
			panel.add(lblApellidos);

			textapellido = new JTextField();
			textapellido.setColumns(10);
			textapellido.setBounds(441, 10, 232, 20);
			panel.add(textapellido);

			JLabel lblFechaDeNaciomiento = new JLabel("Fecha de Nacimiento");
			lblFechaDeNaciomiento.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblFechaDeNaciomiento.setBounds(10, 65, 147, 18);
			panel.add(lblFechaDeNaciomiento);

			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(167, 64, 156, 20);
			panel.add(dateChooser);

			JLabel lblPas = new JLabel("Pa\u00EDs");
			lblPas.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblPas.setBounds(360, 68, 71, 18);
			panel.add(lblPas);

			JComboBox cBpais = new JComboBox();
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
			cBpais.setBounds(441, 68, 232, 20);
			panel.add(cBpais);

			JLabel lblCiudad = new JLabel("Lugar de Nacimiento");
			lblCiudad.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblCiudad.setBounds(10, 122, 147, 18);
			panel.add(lblCiudad);

			textlugarnacimiento = new JTextField();
			textlugarnacimiento.setBounds(167, 122, 506, 20);
			panel.add(textlugarnacimiento);
			textlugarnacimiento.setColumns(10);

			JLabel lblPeso = new JLabel("Peso");
			lblPeso.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblPeso.setBounds(360, 188, 71, 18);
			panel.add(lblPeso);

			JSpinner spinnerpeso = new JSpinner();
			spinnerpeso.setBounds(441, 188, 63, 20);
			panel.add(spinnerpeso);

			JLabel lblAltura = new JLabel("Altura");
			lblAltura.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblAltura.setBounds(548, 188, 63, 18);
			panel.add(lblAltura);

			JSpinner spinneraltura = new JSpinner();
			spinneraltura.setBounds(610, 188, 63, 20);
			panel.add(spinneraltura);

			JLabel lblPosicin = new JLabel("Posici\u00F3n");
			lblPosicin.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblPosicin.setBounds(10, 191, 119, 18);
			panel.add(lblPosicin);

			JComboBox cBposicion = new JComboBox();
			cBposicion.setModel(new DefaultComboBoxModel(
					new String[] { "Pitcher", "Catcher", "Primera base", "Segunda base", "Tercera base", "Short stop",
							"Left fielder", "Center fielder", "Right fielder", "Bateador designado" }));
			cBposicion.setSelectedIndex(0);
			cBposicion.setBounds(91, 191, 232, 20);
			panel.add(cBposicion);

			JLabel lblUniversidad = new JLabel("Universidad");
			lblUniversidad.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblUniversidad.setBounds(10, 266, 84, 18);
			panel.add(lblUniversidad);

			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(91, 265, 232, 20);
			panel.add(textField);

			JLabel lblEquipo = new JLabel("Equipo");
			lblEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblEquipo.setBounds(360, 269, 63, 18);
			panel.add(lblEquipo);

			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(441, 268, 232, 20);
			panel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
