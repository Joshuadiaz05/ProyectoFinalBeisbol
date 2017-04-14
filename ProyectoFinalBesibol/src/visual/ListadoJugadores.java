package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logical.Equipos;
import logical.Jugadores;
import logical.LigaBeisbol;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class ListadoJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tdf_search;
	private static JTable table;
	static Object[] fila;
	private static DefaultTableModel tablemodel;
	private JComboBox comboBox;
	private JComboBox cbx_posicion; 
	private JComboBox cbx_pais;
	private Equipos equipo = LigaBeisbol.getInstance().BuscarPorNombre(VerJugadores.nombreEquipo);
	public static Jugadores jugador;
	
	/**
	 * Create the dialog.
	 */
	public ListadoJugadores(boolean si) {
		if(si==true){
			setTitle("Mostrar jugador - " + equipo.getNombre());
			setBounds(100, 100, 1000, 570);
		} else {
			setTitle("Mostrar jugador");
			setBounds(100, 100, 1000, 623);
		}
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		if(si==true){
			{
				JPanel panel_buscar = new JPanel();
				panel_buscar.setBounds(10, 1, 970, 58);
				contentPanel.add(panel_buscar);
				panel_buscar.setLayout(null);
				{
						JLabel lblNewLabel = new JLabel(equipo.getNombre() + " - Plantel completo");
						lblNewLabel.setBounds(10, 1, 620, 55);
						panel_buscar.add(lblNewLabel);
						lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
				}
				{
					JSeparator separator = new JSeparator();
					separator.setBounds(0, 53, 970, 2);
					panel_buscar.add(separator);
				}
			}
		} else {
			{
				JLabel lblNewLabel = new JLabel("MLB Jugadores");
				lblNewLabel.setBounds(10, 1, 620, 40);
				contentPanel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
				{
					JSeparator separator = new JSeparator();
					separator.setBounds(10, 40, 970, 2);
					contentPanel.add(separator);
				}
		}
			{
				JPanel panel_buscar = new JPanel();
				panel_buscar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_buscar.setBounds(10, 50, 970, 65);
				contentPanel.add(panel_buscar);
				panel_buscar.setLayout(null);
				{
					JLabel label = new JLabel("Buscar por: ");
					label.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
					label.setBounds(10, 18, 93, 23);
					panel_buscar.add(label);
				}
				{
					comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Apellidos", "Posici\u00F3n", "Pa\u00EDs"}));
					comboBox.setSelectedIndex(0);
					comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
					comboBox.setBounds(108, 12, 159, 32);
					comboBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JComboBox comboBox = (JComboBox) e.getSource();
							
							Object selected = comboBox.getSelectedItem();
			                if(selected.toString().equals("Posición")){
			                	cbx_posicion.setSelectedIndex(0);
			                	tdf_search.setVisible(false);
			                	cbx_posicion.setVisible(true);
			                	cbx_pais.setVisible(false);
			                } 	                	
			                else if(selected.toString().equals("Apellidos")){
			                	tdf_search.setText("");
			                	tdf_search.setVisible(true);
			                	cbx_posicion.setVisible(false);
			                	cbx_pais.setVisible(false);
			                }else if(selected.toString().equals("País")){
			                	cbx_pais.setSelectedIndex(0);
			                	tdf_search.setVisible(false);
			                	cbx_posicion.setVisible(false);
			                	cbx_pais.setVisible(true);
			                }
						}
					});
					panel_buscar.add(comboBox);
				}
				{
					ArrayList<String> jugadores_apellidos = new ArrayList<String>();
					jugadores_apellidos.add("");
					for (Jugadores aux : LigaBeisbol.getInstance().getJugador()) {
						jugadores_apellidos.add(aux.getApellido());
					}
					tdf_search = new Java2sAutoTextField(jugadores_apellidos);
					tdf_search.setColumns(10);
					tdf_search.setBounds(278, 12, 620, 32);
					panel_buscar.add(tdf_search);
				}
				{
					JButton button = new JButton("Ir");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(comboBox.getSelectedIndex()==0){
								cargarJugadoresPorEquipoApellido(tdf_search.getText());
							}
							if(comboBox.getSelectedIndex()==1){
								cargarJugadoresPorEquipoPosición(cbx_posicion.getSelectedItem().toString());
							}
							if(comboBox.getSelectedIndex()==2){
								cargarJugadoresPorEquipoPais(cbx_pais.getSelectedItem().toString());
							}
						}
					});
					button.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
					button.setBounds(915, 12, 43, 32);
					panel_buscar.add(button);
				}
				
				cbx_posicion = new JComboBox();
				cbx_posicion.setModel(new DefaultComboBoxModel(new String[] {"Pitcher", "Catcher", "Primera base", "Segunda base", "Tercera base", "Short stop", "Left fielder", "Center fielder", "Right fielder", "Bateador designado"}));
				cbx_posicion.setSelectedIndex(0);
				cbx_posicion.setVisible(false);
				cbx_posicion.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				cbx_posicion.setBounds(278, 12, 620, 32);
				panel_buscar.add(cbx_posicion);
				{
					cbx_pais = new JComboBox();
					cbx_pais.setModel(new DefaultComboBoxModel(new String[] {"Afganist\u00E1n ", "Akrotiri ", "Albania ", "Alemania ", "Andorra ", "Angola ", "Anguila ", "Ant\u00E1rtida ", "Antigua y Barbuda ", "Antillas Neerlandesas ", "Arabia Saud\u00ED ", "Arctic Ocean ", "Argelia ", "Argentina ", "Armenia ", "Aruba ", "Ashmore andCartier Islands ", "Atlantic Ocean ", "Australia ", "Austria ", "Azerbaiy\u00E1n ", "Bahamas ", "Bahr\u00E1in ", "Bangladesh ", "Barbados ", "B\u00E9lgica ", "Belice ", "Ben\u00EDn ", "Bermudas ", "Bielorrusia ", "Birmania Myanmar ", "Bolivia ", "Bosnia y Hercegovina ", "Botsuana ", "Brasil ", "Brun\u00E9i ", "Bulgaria ", "Burkina Faso ", "Burundi ", "But\u00E1n ", "Cabo Verde ", "Camboya ", "Camer\u00FAn ", "Canad\u00E1 ", "Chad ", "Chile ", "China ", "Chipre ", "Clipperton Island ", "Colombia ", "Comoras ", "Congo ", "Coral Sea Islands ", "Corea del Norte ", "Corea del Sur ", "Costa de Marfil ", "Costa Rica ", "Croacia ", "Cuba ", "Dhekelia ", "Dinamarca ", "Dominica ", "Ecuador ", "Egipto ", "El Salvador ", "El Vaticano ", "Emiratos \u00C1rabes Unidos ", "Eritrea ", "Eslovaquia ", "Eslovenia ", "Espa\u00F1a ", "Estados Unidos ", "Estonia ", "Etiop\u00EDa ", "Filipinas ", "Finlandia ", "Fiyi ", "Francia ", "Gab\u00F3n ", "Gambia ", "Gaza Strip ", "Georgia ", "Ghana ", "Gibraltar ", "Granada ", "Grecia ", "Groenlandia ", "Guam ", "Guatemala ", "Guernsey ", "Guinea ", "Guinea Ecuatorial ", "Guinea-Bissau ", "Guyana ", "Hait\u00ED ", "Honduras ", "Hong Kong ", "Hungr\u00EDa ", "India ", "Indian Ocean ", "Indonesia ", "Ir\u00E1n ", "Iraq ", "Irlanda ", "Isla Bouvet ", "Isla Christmas ", "Isla Norfolk ", "Islandia ", "Islas Caim\u00E1n ", "Islas Cocos ", "Islas Cook ", "Islas Feroe ", "Islas Georgia del Sur y Sandwich del Sur ", "Islas Heard y McDonald ", "Islas Malvinas ", "Islas Marianas del Norte ", "IslasMarshall ", "Islas Pitcairn ", "Islas Salom\u00F3n ", "Islas Turcas y Caicos ", "Islas V\u00EDrgenes Americanas ", "Islas V\u00EDrgenes Brit\u00E1nicas ", "Israel ", "Italia ", "Jamaica ", "Jan Mayen ", "Jap\u00F3n ", "Jersey ", "Jordania ", "Kazajist\u00E1n ", "Kenia ", "Kirguizist\u00E1n ", "Kiribati ", "Kuwait ", "Laos ", "Lesoto ", "Letonia ", "L\u00EDbano ", "Liberia ", "Libia ", "Liechtenstein ", "Lituania ", "Luxemburgo ", "Macao ", "Macedonia ", "Madagascar ", "Malasia ", "Malaui ", "Maldivas ", "Mal\u00ED ", "Malta ", "Man, Isle of ", "Marruecos ", "Mauricio ", "Mauritania ", "Mayotte ", "M\u00E9xico ", "Micronesia ", "Moldavia ", "M\u00F3naco ", "Mongolia ", "Montserrat ", "Mozambique ", "Namibia ", "Nauru ", "Navassa Island ", "Nepal ", "Nicaragua ", "N\u00EDger ", "Nigeria ", "Niue ", "Noruega ", "Nueva Caledonia ", "Nueva Zelanda ", "Om\u00E1n ", "Pacific Ocean ", "Pa\u00EDses Bajos ", "Pakist\u00E1n ", "Palaos ", "Panam\u00E1 ", "Pap\u00FAa-Nueva Guinea ", "Paracel Islands ", "Paraguay ", "Per\u00FA ", "Polinesia Francesa ", "Polonia ", "Portugal ", "Puerto Rico ", "Qatar ", "Reino Unido ", "Rep\u00FAblica Centroafricana ", "Rep\u00FAblica Checa ", "Rep\u00FAblica Democr\u00E1tica del Congo ", "Rep\u00FAblica Dominicana ", "Ruanda ", "Rumania ", "Rusia ", "S\u00E1hara Occidental ", "Samoa ", "Samoa Americana ", "San Crist\u00F3bal y Nieves ", "San Marino ", "San Pedro y Miquel\u00F3n ", "San Vicente y las Granadinas ", "Santa Helena ", "Santa Luc\u00EDa ", "Santo Tom\u00E9 y Pr\u00EDncipe ", "Senegal ", "Seychelles ", "Sierra Leona ", "Singapur ", "Siria ", "Somalia ", "Southern Ocean ", "Spratly Islands ", "Sri Lanka ", "Suazilandia ", "Sud\u00E1frica ", "Sud\u00E1n ", "Suecia ", "Suiza ", "Surinam ", "Svalbard y Jan Mayen ", "Tailandia ", "Taiw\u00E1n ", "Tanzania ", "Tayikist\u00E1n ", "TerritorioBrit\u00E1nicodel Oc\u00E9ano Indico ", "Territorios Australes Franceses ", "Timor Oriental ", "Togo ", "Tokelau ", "Tonga ", "Trinidad y Tobago ", "T\u00FAnez ", "Turkmenist\u00E1n ", "Turqu\u00EDa ", "Tuvalu ", "Ucrania ", "Uganda ", "Uni\u00F3n Europea ", "Uruguay ", "Uzbekist\u00E1n ", "Vanuatu ", "Venezuela ", "Vietnam ", "Wake Island ", "Wallis y Futuna ", "West Bank ", "World ", "Yemen ", "Yibuti ", "Zambia ", "Zimbabue "}));
					cbx_pais.setSelectedIndex(0);
					cbx_pais.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
					cbx_pais.setBounds(278, 12, 620, 32);
					cbx_pais.setVisible(false);
					panel_buscar.add(cbx_pais);
				}
			}
		}
		if(si==true){
			{
				JPanel panel_tabla = new JPanel();
				panel_tabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_tabla.setBounds(10, 65, 970, 434);
				contentPanel.add(panel_tabla);
				panel_tabla.setLayout(null);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 21, 950, 402);
					panel_tabla.add(scrollPane);
					{
						table = new JTable();
						scrollPane.setViewportView(table);
						String[] columnsheaders = { "#", "Nombre" , "Apellido", "Equipo", "Posición", "Edad", "Lugar de Nacimiento" };
						tablemodel = new DefaultTableModel();
						tablemodel.setColumnIdentifiers(columnsheaders);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int index = table.getSelectedRow();
								String nombreJugador = (String) table.getModel().getValueAt(index, 1);
								jugador = LigaBeisbol.getInstance().buscarjugador(nombreJugador);
								EstadisticaJugadores estadisticaJugadores = new EstadisticaJugadores();
								estadisticaJugadores.setVisible(true);
							}
						});
						table.setModel(tablemodel);
					}
				}
			}
		} else {
			{
				JPanel panel_tabla = new JPanel();
				panel_tabla.setBorder(new TitledBorder(null, "MLB B\u00FAsqueda de Jugadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_tabla.setBounds(10, 126, 970, 434);
				contentPanel.add(panel_tabla);
				panel_tabla.setLayout(null);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 21, 950, 402);
					panel_tabla.add(scrollPane);
					{
						table = new JTable();
						scrollPane.setViewportView(table);
						String[] columnsheaders = { "#", "Nombre" , "Apellido", "Equipo", "Posición", "Edad", "Lugar de Nacimiento" };
						tablemodel = new DefaultTableModel();
						tablemodel.setColumnIdentifiers(columnsheaders);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int index = table.getSelectedRow();
								String nombreJugador = (String) table.getModel().getValueAt(index, 1);
								jugador = LigaBeisbol.getInstance().buscarjugador(nombreJugador);
								EstadisticaJugadores estadisticaJugadores = new EstadisticaJugadores();
								estadisticaJugadores.setVisible(true);
							}
						});
						table.setModel(tablemodel);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
		if(si==true){
			cargarJugadoresPorEquipo(VerJugadores.inde);
		} else {
			if(VerJugadores.apel == true){
				cargarJugadoresPorEquipoApellido(VerJugadores.apellido);
			}
			if(VerJugadores.pos == true){
				cargarJugadoresPorEquipoPosición(VerJugadores.posicion);
			}
			if(VerJugadores.country == true){
				cargarJugadoresPorEquipoPais(VerJugadores.pais);
			}
		}
		
	}
	
	public static void cargarJugadoresPorEquipoApellido(String apellido){
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Jugadores e : LigaBeisbol.getInstance().getJugador()) {
			if(!e.isLesion()){
				if(e.getApellido().startsWith(apellido) || e.getApellido().endsWith(apellido)){
					fila[0] = e.getNumero();
					fila[1] = e.getNombre();
					fila[2] = e.getApellido();
					fila[3] = e.getEquipo();
					fila[4] = e.getPosicion();
					long date = Math.abs(e.getFechanacimiento().getYear() - LocalDate.now().getYear());
					fila[5] = date;
					fila[6] = e.getLugarciudadNacimiento();
					tablemodel.addRow(fila);
				}
			}
		}
	}
	public static void cargarJugadoresPorEquipoPosición(String posicion){
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Jugadores e : LigaBeisbol.getInstance().getJugador()) {
			if(!e.isLesion()){
				if(e.getPosicion().startsWith(posicion) || e.getPosicion().endsWith(posicion)){
					fila[0] = e.getNumero();
					fila[1] = e.getNombre();
					fila[2] = e.getApellido();
					fila[3] = e.getEquipo();
					fila[4] = e.getPosicion();
					long date = Math.abs(e.getFechanacimiento().getYear() - LocalDate.now().getYear());
					fila[5] = date;
					fila[6] = e.getLugarciudadNacimiento();
					tablemodel.addRow(fila);
				}
			}
		}
	}
	public static void cargarJugadoresPorEquipoPais(String pais){
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Jugadores e : LigaBeisbol.getInstance().getJugador()) {
			if(!e.isLesion()){
				if(e.getLugarpaisNacimiento().startsWith(pais)){
					fila[0] = e.getNumero();
					fila[1] = e.getNombre();
					fila[2] = e.getApellido();
					fila[3] = e.getEquipo();
					fila[4] = e.getPosicion();
					long date = Math.abs(e.getFechanacimiento().getYear() - LocalDate.now().getYear());
					fila[5] = date;
					fila[6] = e.getLugarciudadNacimiento();
					tablemodel.addRow(fila);
				}
			}
		}
	}
	public static void cargarJugadoresPorEquipo(Equipos equipo){
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Jugadores e : equipo.getJugador()) {
				fila[0] = e.getNumero();
				fila[1] = e.getNombre();
				fila[2] = e.getApellido();
				fila[3] = equipo.getNombre();
				fila[4] = e.getPosicion();
				long date = Math.abs(e.getFechanacimiento().getYear() - LocalDate.now().getYear());
				fila[5] = date;
				fila[6] = e.getLugarciudadNacimiento() + ", " + e.getLugarpaisNacimiento();
				tablemodel.addRow(fila);
		}
	}
}
