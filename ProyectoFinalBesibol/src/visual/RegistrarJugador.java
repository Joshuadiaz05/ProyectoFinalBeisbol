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
import javax.swing.border.EtchedBorder;

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
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

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
	private JComboBox cbBatea;
	private JComboBox cbLanza;
	private JCheckBox chckbxNewCheckBox;
	private JSpinner spinrbi;
	private JSpinner spinhr;
	private JSpinner spinab;
	private JSpinner spinbb; 
	private JSpinner spin2b;
	private JSpinner spin3b;
	private JSpinner spinc;
	private JSpinner spinh;
	private JTextField textEquipo;
	private String equipotext = "";
	private Equipos miEquipos;
	
	public RegistrarJugador(boolean fromprincipal, boolean modificacion, String jugador) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imag/baseball.png"));
		if(modificacion==true){
			setTitle("Modificar Jugador");
		}else{
			setTitle("Registrar Jugador");
		}
		setBounds(100, 100, 761, 568);
		//setBounds(100, 100, 761, 453);
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
			textnombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			textnombre.setBounds(10, 78, 245, 32);
			panel.add(textnombre);
			textnombre.setColumns(10);

			JLabel lblApellidos = new JLabel("Apellidos");
			lblApellidos.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblApellidos.setBounds(265, 59, 71, 18);
			panel.add(lblApellidos);

			textapellido = new JTextField();
			textapellido.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
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
			cBpais.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			cBpais.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Estados Unidos", "Rep\u00FAblica Dominicana", "Afganist\u00E1n", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiy\u00E1n", "Bahamas", "Banglad\u00E9s", "Barbados", "Bar\u00E9in", "B\u00E9lgica", "Belice", "Ben\u00EDn", "Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brun\u00E9i", "Bulgaria", "Burkina Faso", "Burundi", "But\u00E1n", "Cabo Verde", "Camboya", "Camer\u00FAn", "Canad\u00E1", "Catar", "Chad", "Chile", "China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos \u00C1rabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "Espa\u00F1a", "Estonia", "Etiop\u00EDa", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gab\u00F3n", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea ecuatorial", "Guinea-Bis\u00E1u", "Hait\u00ED", "Honduras", "Hungr\u00EDa", "India", "Indonesia", "Irak", "Ir\u00E1n", "Irlanda", "Islandia", "Islas Marshall", "Islas Salom\u00F3n", "Israel", "Italia", "Jamaica", "Jap\u00F3n", "Jordania", "Kazajist\u00E1n", "Kenia", "Kirguist\u00E1n", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "L\u00EDbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas", "Mal\u00ED", "Malta", "Marruecos", "Mauricio", "Mauritania", "M\u00E9xico", "Micronesia", "Moldavia", "M\u00F3naco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "N\u00EDger", "Nigeria", "Noruega", "Nueva Zelanda", "Om\u00E1n", "Pa\u00EDses Bajos", "Pakist\u00E1n", "Palaos", "Panam\u00E1", "Pap\u00FAa Nueva Guinea", "Paraguay", "Per\u00FA", "Polonia", "Portugal", "Reino Unido", "Rep\u00FAblica Centroafricana", "Rep\u00FAblica Checa", "Rep\u00FAblica de Macedonia", "Rep\u00FAblica del Congo", "Rep\u00FAblica Democr\u00E1tica del Congo", "Rep\u00FAblica Sudafricana", "Ruanda", "Ruman\u00EDa", "Rusia", "Samoa", "San Crist\u00F3bal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Luc\u00EDa", "Santo Tom\u00E9 y Pr\u00EDncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sud\u00E1n", "Sud\u00E1n del Sur", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikist\u00E1n", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "T\u00FAnez", "Turkmenist\u00E1n", "Turqu\u00EDa", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekist\u00E1n", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue"}));
			cBpais.setSelectedIndex(0);
			cBpais.setBounds(265, 146, 245, 32);
			panel.add(cBpais);

			JLabel lblCiudad = new JLabel("Lugar de Nacimiento");
			lblCiudad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblCiudad.setBounds(10, 197, 166, 18);
			panel.add(lblCiudad);

			textlugarnacimiento = new JTextField();
			textlugarnacimiento.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			textlugarnacimiento.setBounds(10, 216, 245, 32);
			panel.add(textlugarnacimiento);
			textlugarnacimiento.setColumns(10);

			JLabel lblPeso = new JLabel("Peso");
			lblPeso.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblPeso.setBounds(10, 326, 49, 32);
			panel.add(lblPeso);

			spinnerpeso = new JSpinner();
			spinnerpeso.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			spinnerpeso.setModel(new SpinnerNumberModel(new Integer(80), new Integer(40), null, new Integer(1)));
			spinnerpeso.setBounds(52, 326, 71, 32);
			panel.add(spinnerpeso);

			JLabel lblAltura = new JLabel("Altura");
			lblAltura.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblAltura.setBounds(180, 326, 63, 32);
			panel.add(lblAltura);

			spinneraltura = new JSpinner();
			spinneraltura.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			spinneraltura.setModel(new SpinnerNumberModel(new Integer(170), new Integer(100), null, new Integer(1)));
			spinneraltura.setBounds(232, 326, 71, 32);
			panel.add(spinneraltura);

			JLabel lblPosicin = new JLabel("Posici\u00F3n");
			lblPosicin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblPosicin.setBounds(10, 259, 119, 18);
			panel.add(lblPosicin);

			cBposicion = new JComboBox();
			cBposicion.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			cBposicion.setModel(new DefaultComboBoxModel(new String[] {"Pitcher", "Catcher", "Primera base", "Segunda base", "Tercera base", "Short stop", "Left fielder", "Center fielder", "Right fielder"}));
			cBposicion.setSelectedIndex(0);
			cBposicion.setBounds(10, 278, 245, 32);
			panel.add(cBposicion);

			JLabel lblUniversidad = new JLabel("Universidad");
			lblUniversidad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblUniversidad.setBounds(265, 259, 144, 18);
			panel.add(lblUniversidad);

			textUniversidad = new JTextField();
			textUniversidad.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			textUniversidad.setColumns(10);
			textUniversidad.setBounds(265, 278, 245, 32);
			panel.add(textUniversidad);

			JLabel lblEquipo = new JLabel("Equipo");
			lblEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblEquipo.setBounds(525, 259, 63, 18);
			panel.add(lblEquipo);
			
			if(fromprincipal==false){
				miEquipos = LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo);
			}
			
			ArrayList<String> equipos = new ArrayList<String>();
			for (Equipos e : LigaBeisbol.getInstance().getEquipo()) {
				equipos.add(e.getNombre());
			}
			if(fromprincipal==true){
			cBEquipo = new JComboBox(equipos.toArray());
			cBEquipo.setBounds(525, 278, 195, 32);
			cBEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			panel.add(cBEquipo);
			}else{
				textEquipo = new JTextField(miEquipos.getNombre());
				textEquipo.setEditable(false);
				textEquipo.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
				textEquipo.setBounds(520, 278, 206, 32);
				panel.add(textEquipo);
				textEquipo.setColumns(10);
			}
			JLabel lblNumero = new JLabel("Numero");
			lblNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblNumero.setBounds(358, 326, 63, 32);
			panel.add(lblNumero);
			
			spinnernumero = new JSpinner();
			spinnernumero.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			spinnernumero.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
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
					if(textnombre.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "Tienes que poner el nombre antes de guardar una foto." , "Error:", JOptionPane.ERROR_MESSAGE);
					}else{
						BufferedImage image;
						JFileChooser chooser = new JFileChooser();
						chooser.showOpenDialog(null);
						File f = chooser.getSelectedFile();
						String route2 = "";
						try {
							route2 = f.getAbsolutePath();
						} catch (NullPointerException e2) {
							
						}
						try {
							image = ImageIO.read(f);
							String route = "jugadores/" + textnombre .getText() +".png";
							ImageIO.write(image, "png",new File(route));
							ImageIcon imagee = new ImageIcon(route2);
							lbFoto.setIcon(null);
							lbFoto.setIcon(imagee);
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}catch (IllegalArgumentException e2) {
							JOptionPane.showMessageDialog(null, "Debes escoger una foto." , "Error:", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			btnSubirFoto.setBounds(615, 221, 105, 23);
			panel.add(btnSubirFoto);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_1.setBounds(518, 59, 205, 155);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			lbFoto = new JLabel("");
			ImageIcon image = new ImageIcon("img/player_blank.png");
			lbFoto.setIcon(image);
			lbFoto.setHorizontalAlignment(SwingConstants.CENTER);
			
			lbFoto.setBounds(0, 2, 202, 150);
			panel_1.add(lbFoto);
			
			JLabel lblRegistrarJugador = new JLabel("Registrar Jugador");
			if(modificacion==true){
				lblRegistrarJugador.setText("Modificar Jugador");
			}else{
				lblRegistrarJugador.setText("Registrar Jugador");
			}
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
			cBdia.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			cBdia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cBdia.setSelectedIndex(0);
			cBdia.setBounds(32, 146, 43, 32);
			panel.add(cBdia);
			
			cBmes = new JComboBox();
			cBmes.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			cBmes.setModel(new DefaultComboBoxModel(new String[] {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Agos", "Sept", "Oct", "Nov", "Dic"}));
			cBmes.setSelectedIndex(0);
			cBmes.setBounds(101, 146, 56, 32);
			panel.add(cBmes);
			
			JLabel lblMes = new JLabel("Mes");
			lblMes.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
			lblMes.setBounds(77, 146, 25, 32);
			panel.add(lblMes);
			
			JLabel lblAo = new JLabel("A\u00F1o");
			lblAo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
			lblAo.setBounds(160, 146, 25, 32);
			panel.add(lblAo);
			
			ArrayList<Integer> agno = new ArrayList<Integer>();
			for(int i = 1900; i <= Calendar.getInstance().get(Calendar.YEAR); i++){
				agno.add(i);
			}
			cBagno = new JComboBox(agno.toArray());
			cBagno.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			long date = Math.abs(LocalDate.now().getYear() - 1900);
			cBagno.setSelectedIndex((int) date);
			cBagno.setBounds(185, 146, 72, 32);
			panel.add(cBagno);
			
			JLabel label = new JLabel("#");
			label.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			label.setBounds(502, 326, 22, 32);
			panel.add(label);
			
			chckbxNewCheckBox = new JCheckBox("Titular");
			chckbxNewCheckBox.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			chckbxNewCheckBox.setBounds(575, 326, 89, 32);
			panel.add(chckbxNewCheckBox);
			
			JLabel labelicon = new JLabel("");
			labelicon.setIcon(new ImageIcon("img/iconoregist.png"));
			labelicon.setBounds(240, 11, 43, 34);
			panel.add(labelicon);
			
			JLabel lblNewLabel_1 = new JLabel("Ir a Todos los Eventos");
			lblNewLabel_1.setVisible(false);
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			lblNewLabel_1.setBounds(290, 0, 144, 14);
			panel.add(lblNewLabel_1);
			
			cbBatea = new JComboBox();
			cbBatea.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Izquierda", "Derecha"}));
			cbBatea.setSelectedIndex(0);
			cbBatea.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			cbBatea.setBounds(265, 216, 121, 32);
			panel.add(cbBatea);
			
			cbLanza = new JComboBox();
			cbLanza.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Izquierda", "Derecha"}));
			cbLanza.setSelectedIndex(0);
			cbLanza.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
			cbLanza.setBounds(396, 216, 114, 32);
			panel.add(cbLanza);
			
			JLabel label_1 = new JLabel("Batea");
			label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			label_1.setBounds(265, 197, 71, 18);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("Lanza");
			label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			label_2.setBounds(396, 197, 71, 18);
			panel.add(label_2);
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
		lblPromedio.setBounds(10, 55, 27, 14);
		panel.add(lblPromedio);
		
		spinab = new JSpinner();
		spinab.setBounds(30, 46, 47, 32);
		panel.add(spinab);
		
		JLabel lblH = new JLabel("H");
		lblH.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblH.setBounds(105, 55, 15, 14);
		panel.add(lblH);
		
		spinh = new JSpinner();
		spinh.setBounds(117, 46, 47, 32);
		panel.add(spinh);
		
		JLabel lblb = new JLabel("2B");
		lblb.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblb.setBounds(191, 55, 17, 14);
		panel.add(lblb);
		
		spin2b = new JSpinner();
		spin2b.setBounds(213, 47, 47, 31);
		panel.add(spin2b);
		
		JLabel lblb_1 = new JLabel("3B");
		lblb_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblb_1.setBounds(285, 55, 17, 14);
		panel.add(lblb_1);
		
		spin3b = new JSpinner();
		spin3b.setBounds(305, 46, 47, 32);
		panel.add(spin3b);
		
		JLabel lblHr = new JLabel("HR");
		lblHr.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblHr.setBounds(376, 55, 17, 14);
		panel.add(lblHr);
		
		spinhr = new JSpinner();
		spinhr.setBounds(396, 46, 47, 32);
		panel.add(spinhr);
		
		JLabel lblBb = new JLabel("BB");
		lblBb.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblBb.setBounds(469, 55, 17, 14);
		panel.add(lblBb);
		
		spinbb = new JSpinner();
		spinbb.setBounds(489, 46, 47, 32);
		panel.add(spinbb);
		
		spinc = new JSpinner();
		spinc.setBounds(575, 46, 47, 32);
		panel.add(spinc);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblC.setBounds(565, 55, 15, 14);
		panel.add(lblC);
		
		JLabel lblRbi = new JLabel("RBI");
		lblRbi.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblRbi.setBounds(648, 55, 27, 14);
		panel.add(lblRbi);
		
		spinrbi = new JSpinner();
		spinrbi.setBounds(674, 46, 47, 32);
		panel.add(spinrbi);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(fromprincipal==true){
							miEquipos = LigaBeisbol.getInstance().BuscarPorNombre(cBEquipo.getSelectedItem().toString());
						} else {
							miEquipos = LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo);
						}
						if(modificacion==false){
							if(textnombre.getText().equalsIgnoreCase("") || textapellido.getText().equalsIgnoreCase("") || cBpais.getSelectedIndex()==0 ||textlugarnacimiento.getText().equalsIgnoreCase("") || textUniversidad.getText().equalsIgnoreCase("")){
								JOptionPane.showMessageDialog(null, "Por favor! Complete todos los Campos", null,
										JOptionPane.WARNING_MESSAGE, null);
							}else{
														
								String nom = textnombre.getText();
								String apell = textapellido.getText();
								String ciudad = textlugarnacimiento.getText();
								String univ = textUniversidad.getText();
								int numero = Integer.parseInt(spinnernumero.getValue().toString());
								double peso = Integer.parseInt(spinnerpeso.getValue().toString());
								String batea = cbBatea.getSelectedItem().toString();
								String lanza = cbLanza.getSelectedItem().toString();
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
								Jugadores nuevojugador = new Jugadores(numero, nom, apell, peso, batea, lanza, posicion, altura, date, ciudad, pais, univ, miEquipos.getNombre(), titular);
								LigaBeisbol.getInstance().insertarJugador(nuevojugador);
								miEquipos.getJugador().add(nuevojugador);
								int bb = Integer.parseInt(spinbb.getValue().toString());
								int trb = Integer.parseInt(spin3b.getValue().toString());
								int dob  = Integer.parseInt(spin2b.getValue().toString());
								int h = Integer.parseInt(spinh.getValue().toString());
								int hr = Integer.parseInt(spinhr.getValue().toString());
								int c = Integer.parseInt(spinc.getValue().toString());
								int ab = Integer.parseInt(spinab.getValue().toString());								int rbi = Integer.parseInt(spinrbi.getValue().toString());
								Estadisticas estadisticas = new Estadisticas(h, dob, trb, hr, bb, ab, c, rbi);
								nuevojugador.setEstadistica(estadisticas);	
								JOptionPane.showMessageDialog(null, "El jugador " + nom +" se ha registrado sasctifactoriamente!", null,
										JOptionPane.INFORMATION_MESSAGE, null);
								if(fromprincipal==true){
									clean(true);
								} else {
									clean(false);
									EquipoCaracteristicas.cargarJugadoresLesionadoPorEquipo();
									EquipoCaracteristicas.cargarJugadoresPorEquipo();
								}
								
							}
						} else {
							String nom = textnombre.getText();
							String apell = textapellido.getText();
							String ciudad = textlugarnacimiento.getText();
							String univ = textUniversidad.getText();
							int numero = Integer.parseInt(spinnernumero.getValue().toString());
							double peso = Integer.parseInt(spinnerpeso.getValue().toString());
							String batea = cbBatea.getSelectedItem().toString();
							String lanza = cbLanza.getSelectedItem().toString();
							double altura = Double.valueOf(spinneraltura.getValue().toString());
							String posicion = cBposicion.getSelectedItem().toString();
							String pais = cBpais.getSelectedItem().toString();
							int dia = cBdia.getSelectedIndex();
							int mes = cBmes.getSelectedIndex();
							String agno = cBagno.getSelectedItem().toString();
							LocalDate date = LocalDate.of(Integer.valueOf(agno), mes+1, dia+1);
							boolean titular = false;
							if(fromprincipal==false){
								Jugadores j = LigaBeisbol.getInstance().buscarjugador(nom);
								j.setApellido(apell);
								j.setLugarciudadNacimiento(ciudad);
								j.setUniversidad(univ);
								j.setNumero(numero);
								j.setPeso(peso);
								j.setBatea(batea);
								j.setLanza(lanza);
								j.setAltura(altura);
								j.setPosicion(posicion);
								j.setLugarpaisNacimiento(pais);
								j.setTitular(titular);
								j.setFechanacimiento(date);
								int bb = Integer.parseInt(spinbb.getValue().toString());
								int trb = Integer.parseInt(spin3b.getValue().toString());
								int dob  = Integer.parseInt(spin2b.getValue().toString());
								int h = Integer.parseInt(spinh.getValue().toString());
								int hr = Integer.parseInt(spinhr.getValue().toString());
								int c = Integer.parseInt(spinc.getValue().toString());
								int ab = Integer.parseInt(spinab.getValue().toString());
								int rbi = Integer.parseInt(spinrbi.getValue().toString());
								Estadisticas estadisticas = new Estadisticas(h, dob, trb, hr, bb, ab, c, rbi);
								j.setEstadistica(estadisticas);	
								JOptionPane.showMessageDialog(null, "El jugador " + nom +" se ha modificado sasctifactoriamente!", null,
										JOptionPane.INFORMATION_MESSAGE, null);
								EquipoCaracteristicas.cargarJugadoresPorEquipo();
								EquipoCaracteristicas.cargarJugadoresLesionadoPorEquipo();
								EquipoCaracteristicas.cargarJugador(nom);
								EquipoCaracteristicas.cargarEstadisticas(nom);
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
		if(modificacion==true){
			modificar(jugador);
		}
	}
	
	public void clean(boolean update){
		textnombre.setText("");
		textapellido.setText("");
		textlugarnacimiento.setText("");
		textUniversidad.setText("");
		spinnernumero.setValue(0);
		spinnerpeso.setValue(80);
		cbBatea.setSelectedIndex(0);
		cbLanza.setSelectedIndex(0);
		spinneraltura.setValue(170);
		cBposicion.setSelectedIndex(0);
		cBpais.setSelectedIndex(0);
		lbFoto.setIcon(null);
		if(update==true){
			cBEquipo.setSelectedItem(0);
		}
		ImageIcon image = new ImageIcon("img/player_blank.png");
		lbFoto.setIcon(image);
		spinab.setValue(0);
		spin2b.setValue(0);
		spin3b.setValue(0);
		spinbb.setValue(0);
		spinc.setValue(0);
		spinh.setValue(0);
		spinhr.setValue(0);
		spinrbi.setValue(0);
	}
	
	public void modificar(String mijugador){
		for (Jugadores aux : LigaBeisbol.getInstance().BuscarPorNombre(TablaPosiciones.nombreEquipo).getJugador()) {
			if (aux.getNombre().equalsIgnoreCase(mijugador)) {
				File file = new File("jugadores/" + aux.getNombre() + ".png");
				if(!file.exists()){
					ImageIcon image = new ImageIcon("img/player_blank.png");
					lbFoto.setIcon(image);
				} else {
					ImageIcon image = new ImageIcon("jugadores/" + aux.getNombre() + ".png");
					lbFoto.setIcon(image);
				}
				textnombre.setEnabled(false);
				textnombre.setText(aux.getNombre());
				textapellido.setText(aux.getApellido());
				textlugarnacimiento.setText(aux.getLugarciudadNacimiento());
				textUniversidad.setText(aux.getUniversidad());
				spinnernumero.setValue(aux.getNumero());
				cBdia.setSelectedItem(aux.getFechanacimiento().getDayOfMonth());
				cBmes.setSelectedItem(aux.getFechanacimiento().getMonthValue());
				cBagno.setSelectedItem(aux.getFechanacimiento().getYear());
				double d = aux.getPeso();
				int i = (int) d;
				spinnerpeso.setValue(i);
				double d2 = aux.getAltura();
				int i2 = (int) d2;
				cbBatea.setSelectedItem(aux.getBatea());
				cbLanza.setSelectedItem(aux.getLanza());
				spinneraltura.setValue(i2);
				cBposicion.setSelectedItem(aux.getPosicion());
				cBpais.setSelectedItem(aux.getLugarpaisNacimiento());
				spinbb.setValue(aux.getEstadistica().getBasebola());
				spin3b.setValue(aux.getEstadistica().getTriples());;
				spin2b.setValue(aux.getEstadistica().getDobles());
				spinh.setValue(aux.getEstadistica().getHits());;
				spinhr.setValue(aux.getEstadistica().getHomeruns());;
				spinc.setValue(aux.getEstadistica().getCarreraAnotadas());
				spinab.setValue(aux.getEstadistica().getTurnosjugados());
				spinrbi.setValue(aux.getEstadistica().getRBI());
			}
		}
	}
}