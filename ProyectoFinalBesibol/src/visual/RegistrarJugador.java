package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import logical.Equipos;
import logical.Estadisticas;
import logical.Jugadores;
import logical.LigaBeisbol;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class RegistrarJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnombre;
	private JTextField textapellido;
	private JTextField textlugarnacimiento;
	private JTextField textUniversidad;
	private JLabel lbFoto;
	private JSpinner spinneraltura;
	private JSpinner spinnerpeso;
	private JSpinner spinnernumero;
	private JComboBox cBposicion;
	private JComboBox cBpais;
	private JComboBox cBEquipo;
	private JComboBox cBagno;
	private JComboBox cBmes;
	private JComboBox cBdia;
	private JCheckBox chckbxNewCheckBox;
	private JRadioButton rdbtnNewRadioButton;
	private JSpinner spinrbi;
	private JSpinner spinhr;
	private JSpinner spinab;
	private JSpinner spinbb; 
	private JSpinner spin2b;
	private JSpinner spin3b;
	private JSpinner spinc;
	private JSpinner spinh;
	private JSpinner spinjj;
	private JTextField textEquipo;
	private String equipotext = "";
	private Equipos miEquipos;
	
	public RegistrarJugador(boolean si) {
		setTitle("Registrar Jugador");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imag/baseball.png"));
		//setBounds(100, 100, 761, 568);
		setBounds(100, 100, 761, 453);
		setLocationRelativeTo(null);
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{		
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 736, 369);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblNombre = new JLabel("Nombres");
			lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblNombre.setBounds(10, 59, 71, 18);
			panel.add(lblNombre);

			textnombre = new JTextField();
			textnombre.setBounds(10, 78, 245, 32);
			panel.add(textnombre);
			textnombre.setColumns(10);

			JLabel lblApellidos = new JLabel("Apellidos");
			lblApellidos.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblApellidos.setBounds(265, 59, 71, 18);
			panel.add(lblApellidos);

			textapellido = new JTextField();
			textapellido.setColumns(10);
			textapellido.setBounds(265, 78, 245, 32);
			panel.add(textapellido);

			JLabel lblFechaDeNaciomiento = new JLabel("Fecha de Nacimiento");
			lblFechaDeNaciomiento.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblFechaDeNaciomiento.setBounds(10, 124, 166, 18);
			panel.add(lblFechaDeNaciomiento);

			JLabel lblPas = new JLabel("Pa\u00EDs");
			lblPas.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblPas.setBounds(265, 124, 71, 18);
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
			cBpais.setBounds(265, 146, 245, 32);
			panel.add(cBpais);

			JLabel lblCiudad = new JLabel("Lugar de Nacimiento");
			lblCiudad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblCiudad.setBounds(10, 197, 166, 18);
			panel.add(lblCiudad);

			textlugarnacimiento = new JTextField();
			textlugarnacimiento.setBounds(10, 216, 500, 32);
			panel.add(textlugarnacimiento);
			textlugarnacimiento.setColumns(10);

			JLabel lblPeso = new JLabel("Peso");
			lblPeso.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblPeso.setBounds(10, 326, 49, 32);
			panel.add(lblPeso);

			spinnerpeso = new JSpinner();
			spinnerpeso.setModel(new SpinnerNumberModel(new Integer(80), new Integer(1), null, new Integer(1)));
			spinnerpeso.setBounds(52, 326, 71, 32);
			panel.add(spinnerpeso);

			JLabel lblAltura = new JLabel("Altura");
			lblAltura.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblAltura.setBounds(180, 326, 63, 32);
			panel.add(lblAltura);

			spinneraltura = new JSpinner();
			spinneraltura.setModel(new SpinnerNumberModel(new Integer(170), null, null, new Integer(1)));
			spinneraltura.setBounds(232, 326, 71, 32);
			panel.add(spinneraltura);

			JLabel lblPosicin = new JLabel("Posici\u00F3n");
			lblPosicin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblPosicin.setBounds(10, 259, 119, 18);
			panel.add(lblPosicin);

			cBposicion = new JComboBox();
			cBposicion.setModel(new DefaultComboBoxModel(
					new String[] { "Pitcher", "Catcher", "Primera base", "Segunda base", "Tercera base", "Short stop",
							"Left fielder", "Center fielder", "Right fielder", "Bateador designado" }));
			cBposicion.setSelectedIndex(0);
			cBposicion.setBounds(10, 278, 245, 32);
			panel.add(cBposicion);

			JLabel lblUniversidad = new JLabel("Universidad");
			lblUniversidad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblUniversidad.setBounds(265, 259, 144, 18);
			panel.add(lblUniversidad);

			textUniversidad = new JTextField();
			textUniversidad.setColumns(10);
			textUniversidad.setBounds(265, 278, 245, 32);
			panel.add(textUniversidad);

			JLabel lblEquipo = new JLabel("Equipo");
			lblEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblEquipo.setBounds(525, 259, 63, 18);
			panel.add(lblEquipo);
			
			if(si==false){
				miEquipos = LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo);
			}
			
			ArrayList<String> equipos = new ArrayList<String>();
			for (Equipos e : LigaBeisbol.getInstance().getEquipo()) {
				equipos.add(e.getNombre());
			}
			if(si==true){
			cBEquipo = new JComboBox(equipos.toArray());
			cBEquipo.setBounds(525, 278, 195, 32);
			panel.add(cBEquipo);
			}else{
				textEquipo = new JTextField(miEquipos.getNombre());
				textEquipo.setEditable(false);
				textEquipo.setBounds(520, 278, 206, 32);
				panel.add(textEquipo);
				textEquipo.setColumns(10);
			}
			JLabel lblNumero = new JLabel("Numero");
			lblNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblNumero.setBounds(358, 326, 63, 32);
			panel.add(lblNumero);
			
			spinnernumero = new JSpinner();
			spinnernumero.setBounds(426, 326, 72, 32);
			panel.add(spinnernumero);
			
			JLabel lblLb = new JLabel("Kg");
			lblLb.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			lblLb.setBounds(126, 326, 22, 32);
			panel.add(lblLb);
			
			JLabel lblCm = new JLabel("Cm");
			lblCm.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			lblCm.setBounds(306, 326, 22, 32);
			panel.add(lblCm);
			
			JButton btnSubirFoto = new JButton("Subir Foto");
			btnSubirFoto.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
			btnSubirFoto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BufferedImage image;
					JFileChooser chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					File f = chooser.getSelectedFile();
					String route2 = f.getAbsolutePath();
					try {
						image = ImageIO.read(f);
						String route = "jugadores/" + textnombre .getText() +".png";
						ImageIO.write(image, "png",new File(route));
						ImageIcon imagee = new ImageIcon(route2);
						lbFoto.setIcon(null);
						lbFoto.setIcon(imagee);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnSubirFoto.setBounds(615, 221, 105, 23);
			panel.add(btnSubirFoto);
			
			lbFoto = new JLabel("");
			lbFoto.setBounds(518, 59, 202, 150);
			panel.add(lbFoto);
			
			JLabel lblRegistrarJugador = new JLabel("Registrar Jugador");
			lblRegistrarJugador.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
			lblRegistrarJugador.setBounds(10, 11, 220, 37);
			panel.add(lblRegistrarJugador);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 46, 716, 2);
			panel.add(separator);
			
			JLabel lblNewLabel = new JLabel("D\u00EDa");
			lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
			lblNewLabel.setBounds(10, 146, 22, 32);
			panel.add(lblNewLabel);
			
			cBdia = new JComboBox();
			cBdia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cBdia.setSelectedIndex(0);
			cBdia.setBounds(32, 151, 43, 23);
			panel.add(cBdia);
			
			cBmes = new JComboBox();
			cBmes.setModel(new DefaultComboBoxModel(new String[] {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Agos", "Sept", "Oct", "Nov", "Dic"}));
			cBmes.setSelectedIndex(0);
			cBmes.setBounds(112, 151, 56, 23);
			panel.add(cBmes);
			
			JLabel lblMes = new JLabel("Mes");
			lblMes.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
			lblMes.setBounds(86, 146, 22, 32);
			panel.add(lblMes);
			
			JLabel lblAo = new JLabel("A\u00F1o");
			lblAo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
			lblAo.setBounds(174, 146, 22, 32);
			panel.add(lblAo);
			
			ArrayList<Integer> agno = new ArrayList<Integer>();
			for(int i = 1900; i <= Calendar.getInstance().get(Calendar.YEAR); i++){
				agno.add(i);
			}
			cBagno = new JComboBox(agno.toArray());
			long date = Math.abs(LocalDate.now().getYear() - 1900);
			cBagno.setSelectedIndex((int) date);
			cBagno.setBounds(199, 151, 56, 23);
			panel.add(cBagno);
			
			JLabel label = new JLabel("#");
			label.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			label.setBounds(502, 326, 22, 32);
			panel.add(label);
			
			chckbxNewCheckBox = new JCheckBox("Titular");
			chckbxNewCheckBox.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			chckbxNewCheckBox.setBounds(522, 326, 89, 32);
			panel.add(chckbxNewCheckBox);
			
			rdbtnNewRadioButton = new JRadioButton("Estad\u00EDsticas");
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rdbtnNewRadioButton.isSelected()){
						setBounds(100, 100, 761, 568);
					}else{
						setBounds(100, 100, 761, 568);
					}
				}
			});
			rdbtnNewRadioButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			rdbtnNewRadioButton.setBounds(607, 326, 123, 32);
			panel.add(rdbtnNewRadioButton);
			
			JLabel labelicon = new JLabel("");
			labelicon.setIcon(new ImageIcon("img/iconoregist.png"));
			labelicon.setBounds(240, 11, 43, 34);
			panel.add(labelicon);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 391, 736, 104);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblEstadsticas = new JLabel("Estad\u00EDsticas");
		lblEstadsticas.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblEstadsticas.setBounds(10, 11, 134, 20);
		panel.add(lblEstadsticas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 29, 128, 2);
		panel.add(separator);
		
		JLabel lblPromedio = new JLabel("AB");
		lblPromedio.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblPromedio.setBounds(94, 55, 27, 14);
		panel.add(lblPromedio);
		
		spinab = new JSpinner();
		spinab.setBounds(114, 52, 47, 20);
		panel.add(spinab);
		
		JLabel lblJj = new JLabel("JJ");
		lblJj.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblJj.setBounds(10, 55, 27, 14);
		panel.add(lblJj);
		
		spinjj = new JSpinner();
		spinjj.setBounds(31, 52, 47, 20);
		panel.add(spinjj);
		
		JLabel lblH = new JLabel("H");
		lblH.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblH.setBounds(174, 55, 15, 14);
		panel.add(lblH);
		
		spinh = new JSpinner();
		spinh.setBounds(186, 52, 47, 20);
		panel.add(spinh);
		
		JLabel lblb = new JLabel("2B");
		lblb.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblb.setBounds(250, 55, 17, 14);
		panel.add(lblb);
		
		spin2b = new JSpinner();
		spin2b.setBounds(272, 52, 47, 20);
		panel.add(spin2b);
		
		JLabel lblb_1 = new JLabel("3B");
		lblb_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblb_1.setBounds(332, 55, 17, 14);
		panel.add(lblb_1);
		
		spin3b = new JSpinner();
		spin3b.setBounds(352, 52, 47, 20);
		panel.add(spin3b);
		
		JLabel lblHr = new JLabel("HR");
		lblHr.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblHr.setBounds(410, 55, 17, 14);
		panel.add(lblHr);
		
		spinhr = new JSpinner();
		spinhr.setBounds(430, 52, 47, 20);
		panel.add(spinhr);
		
		JLabel lblBb = new JLabel("BB");
		lblBb.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblBb.setBounds(492, 55, 17, 14);
		panel.add(lblBb);
		
		spinbb = new JSpinner();
		spinbb.setBounds(512, 52, 47, 20);
		panel.add(spinbb);
		
		spinc = new JSpinner();
		spinc.setBounds(586, 52, 47, 20);
		panel.add(spinc);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblC.setBounds(576, 55, 15, 14);
		panel.add(lblC);
		
		JLabel lblRbi = new JLabel("RBI");
		lblRbi.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblRbi.setBounds(648, 55, 27, 14);
		panel.add(lblRbi);
		
		spinrbi = new JSpinner();
		spinrbi.setBounds(674, 52, 47, 20);
		panel.add(spinrbi);
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
							if(si==true){
								miEquipos = LigaBeisbol.getInstance().BuscarPorNombre(cBEquipo.getSelectedItem().toString());
							} else {
								miEquipos = LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo);
							}
							
							String nom = textnombre.getText();
							String apell = textapellido.getText();
							String ciudad = textlugarnacimiento.getText();
							String univ = textUniversidad.getText();
							int numero = Integer.parseInt(spinnernumero.getValue().toString());
							double peso = Integer.parseInt(spinnerpeso.getValue().toString());
							double altura = Integer.parseInt(spinneraltura.getValue().toString());
							String posicion = cBposicion.getSelectedItem().toString();
							String pais = cBpais.getSelectedItem().toString();
							boolean titular = false;
							if(chckbxNewCheckBox.isSelected()){
								titular = true;
							}
							
							
							int dia = cBdia.getSelectedIndex();
							int mes = cBmes.getSelectedIndex();
							String agno = cBagno.getSelectedItem().toString();
							LocalDate date = LocalDate.of(Integer.valueOf(agno), mes+1, dia+1);
							Jugadores nuevojugador = new Jugadores(numero, nom, apell, peso, posicion, altura, date, ciudad, pais, univ, equipotext, titular);
							miEquipos.agregarjugador(nuevojugador);
							LigaBeisbol.getInstance().insertarJugador(nuevojugador);
							if(rdbtnNewRadioButton.isSelected()){
								int jj = Integer.parseInt(spinjj.getValue().toString());
								int bb = Integer.parseInt(spinbb.getValue().toString());
								int trb = Integer.parseInt(spin3b.getValue().toString());
								int dob  = Integer.parseInt(spin2b.getValue().toString());
								int h = Integer.parseInt(spinh.getValue().toString());
								int hr = Integer.parseInt(spinhr.getValue().toString());
								int c = Integer.parseInt(spinc.getValue().toString());
								int ab = Integer.parseInt(spinab.getValue().toString());
								int rbi = Integer.parseInt(spinrbi.getValue().toString());
								Estadisticas estadisticas = new Estadisticas(jj, h, dob, trb, hr, bb, ab, c, rbi);
								nuevojugador.setEstadistica(estadisticas);	
							}
							JOptionPane.showMessageDialog(null, "El jugador " + nom +" se ha registrado sasctifactoriamente!", null,
									JOptionPane.INFORMATION_MESSAGE, null);
							if(si==true){
								clean(true);
								EquipoCaracteristicas.cargarJugadoresLesionadoPorEquipo();
								EquipoCaracteristicas.cargarJugadoresPorEquipo();
							} else {
								clean(false);
							}
							
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
	
	public void clean(boolean update){
		textnombre.setText("");
		textapellido.setText("");
		textlugarnacimiento.setText("");
		textUniversidad.setText("");
		spinnernumero.setValue(1);
		spinnerpeso.setValue(1);
		spinneraltura.setValue(120);
		cBposicion.setSelectedItem(0);
		cBpais.setSelectedItem(0);
		if(update==true){
			cBEquipo.setSelectedItem(0);
		}
	}
}
