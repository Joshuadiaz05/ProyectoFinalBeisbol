package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logical.Equipos;
import logical.Jugadores;
import logical.LigaBeisbol;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VerJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Java2sAutoTextField tdf_search;
	private static JTable table;
	private static JTable table_1;
	private static JTable table_2;
	private static JTable table_3;
	static Object[] fila;
	static Object[] fila2;
	static Object[] fila3;
	static Object[] fila4;
	private static DefaultTableModel tablemodel;
	private static DefaultTableModel tablemodel2;
	private static DefaultTableModel tablemodel3;
	private static DefaultTableModel tablemodel4;
	public static Equipos inde;
	public static String nombreEquipo = "";
	private JComboBox cbx_posicion;
	private JComboBox cbx_pais;
	private JComboBox cbx_opt;
	public static String apellido = "";
	public static String pais = "";
	public static String posicion = "";
	public static boolean apel = false;
	public static boolean country = false;
	public static boolean pos = false;
	/**
	 * Create the dialog.
	 */
	public VerJugadores() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 903, 863);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("MLB Jugadores");
			lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
			lblNewLabel.setBounds(10, 11, 193, 45);
			contentPanel.add(lblNewLabel);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 877, 2);
		contentPanel.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(10, 66, 877, 82);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblBuscarPor = new JLabel("Buscar por: ");
		lblBuscarPor.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblBuscarPor.setBounds(10, 29, 93, 23);
		panel.add(lblBuscarPor);
		
		cbx_opt = new JComboBox();
		cbx_opt.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cbx_opt.setModel(new DefaultComboBoxModel(new String[] {"Apellidos", "Posici\u00F3n", "Pa\u00EDs"}));
		cbx_opt.setSelectedIndex(0);
		cbx_opt.addActionListener(new ActionListener() {
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
		cbx_opt.setBounds(108, 24, 159, 32);
		panel.add(cbx_opt);
		
		ArrayList<String> jugadores_apellidos = new ArrayList<String>();
		jugadores_apellidos.add("");
		for (Jugadores aux : LigaBeisbol.getInstance().getJugador()) {
			jugadores_apellidos.add(aux.getApellido());
		}
		//StringSearchable searchable = new StringSearchable(jugadores_apellidos);
		//AutocompleteJComboBox combo = new AutocompleteJComboBox(searchable);
		tdf_search = new Java2sAutoTextField(jugadores_apellidos);
		tdf_search.setBounds(278, 24, 536, 32);
		panel.add(tdf_search);
		tdf_search.setColumns(10);
		
		JButton btnGo = new JButton("Ir");
		btnGo.setActionCommand("OK");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbx_opt.getSelectedIndex()==0){
					apellido = tdf_search.getText();
					apel = true;
					ListadoJugadores j = new ListadoJugadores(false);
					j.setVisible(true);
				}
				if(cbx_opt.getSelectedIndex()==1){
					posicion = cbx_posicion.getSelectedItem().toString();
					pos = true;
					ListadoJugadores j = new ListadoJugadores(false);
					j.setVisible(true);
				}
				if(cbx_opt.getSelectedIndex()==2){
					pais = cbx_pais.getSelectedItem().toString();
					country = true;
					ListadoJugadores j = new ListadoJugadores(false);
					j.setVisible(true);
				}
			}
		});
		btnGo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnGo.setBounds(824, 24, 43, 32);
		panel.add(btnGo);
		getRootPane().setDefaultButton(btnGo);
		
		cbx_posicion = new JComboBox();
		cbx_posicion.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cbx_posicion.setVisible(false);
		cbx_posicion.setModel(new DefaultComboBoxModel(new String[] {"Pitcher", "Catcher", "Primera base", "Segunda base", "Tercera base", "Short stop", "Left fielder", "Center fielder", "Right fielder", "Bateador designado"}));
		cbx_posicion.setBounds(278, 24, 536, 32);
		panel.add(cbx_posicion);
		
		cbx_pais = new JComboBox();
		cbx_pais.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cbx_pais.setVisible(false);
		cbx_pais.setModel(new DefaultComboBoxModel(new String[] {"Afganist\u00E1n ", "Akrotiri ", "Albania ", "Alemania ", "Andorra ", "Angola ", "Anguila ", "Ant\u00E1rtida ", "Antigua y Barbuda ", "Antillas Neerlandesas ", "Arabia Saud\u00ED ", "Arctic Ocean ", "Argelia ", "Argentina ", "Armenia ", "Aruba ", "Ashmore andCartier Islands ", "Atlantic Ocean ", "Australia ", "Austria ", "Azerbaiy\u00E1n ", "Bahamas ", "Bahr\u00E1in ", "Bangladesh ", "Barbados ", "B\u00E9lgica ", "Belice ", "Ben\u00EDn ", "Bermudas ", "Bielorrusia ", "Birmania Myanmar ", "Bolivia ", "Bosnia y Hercegovina ", "Botsuana ", "Brasil ", "Brun\u00E9i ", "Bulgaria ", "Burkina Faso ", "Burundi ", "But\u00E1n ", "Cabo Verde ", "Camboya ", "Camer\u00FAn ", "Canad\u00E1 ", "Chad ", "Chile ", "China ", "Chipre ", "Clipperton Island ", "Colombia ", "Comoras ", "Congo ", "Coral Sea Islands ", "Corea del Norte ", "Corea del Sur ", "Costa de Marfil ", "Costa Rica ", "Croacia ", "Cuba ", "Dhekelia ", "Dinamarca ", "Dominica ", "Ecuador ", "Egipto ", "El Salvador ", "El Vaticano ", "Emiratos \u00C1rabes Unidos ", "Eritrea ", "Eslovaquia ", "Eslovenia ", "Espa\u00F1a ", "Estados Unidos ", "Estonia ", "Etiop\u00EDa ", "Filipinas ", "Finlandia ", "Fiyi ", "Francia ", "Gab\u00F3n ", "Gambia ", "Gaza Strip ", "Georgia ", "Ghana ", "Gibraltar ", "Granada ", "Grecia ", "Groenlandia ", "Guam ", "Guatemala ", "Guernsey ", "Guinea ", "Guinea Ecuatorial ", "Guinea-Bissau ", "Guyana ", "Hait\u00ED ", "Honduras ", "Hong Kong ", "Hungr\u00EDa ", "India ", "Indian Ocean ", "Indonesia ", "Ir\u00E1n ", "Iraq ", "Irlanda ", "Isla Bouvet ", "Isla Christmas ", "Isla Norfolk ", "Islandia ", "Islas Caim\u00E1n ", "Islas Cocos ", "Islas Cook ", "Islas Feroe ", "Islas Georgia del Sur y Sandwich del Sur ", "Islas Heard y McDonald ", "Islas Malvinas ", "Islas Marianas del Norte ", "IslasMarshall ", "Islas Pitcairn ", "Islas Salom\u00F3n ", "Islas Turcas y Caicos ", "Islas V\u00EDrgenes Americanas ", "Islas V\u00EDrgenes Brit\u00E1nicas ", "Israel ", "Italia ", "Jamaica ", "Jan Mayen ", "Jap\u00F3n ", "Jersey ", "Jordania ", "Kazajist\u00E1n ", "Kenia ", "Kirguizist\u00E1n ", "Kiribati ", "Kuwait ", "Laos ", "Lesoto ", "Letonia ", "L\u00EDbano ", "Liberia ", "Libia ", "Liechtenstein ", "Lituania ", "Luxemburgo ", "Macao ", "Macedonia ", "Madagascar ", "Malasia ", "Malaui ", "Maldivas ", "Mal\u00ED ", "Malta ", "Man, Isle of ", "Marruecos ", "Mauricio ", "Mauritania ", "Mayotte ", "M\u00E9xico ", "Micronesia ", "Moldavia ", "M\u00F3naco ", "Mongolia ", "Montserrat ", "Mozambique ", "Namibia ", "Nauru ", "Navassa Island ", "Nepal ", "Nicaragua ", "N\u00EDger ", "Nigeria ", "Niue ", "Noruega ", "Nueva Caledonia ", "Nueva Zelanda ", "Om\u00E1n ", "Pacific Ocean ", "Pa\u00EDses Bajos ", "Pakist\u00E1n ", "Palaos ", "Panam\u00E1 ", "Pap\u00FAa-Nueva Guinea ", "Paracel Islands ", "Paraguay ", "Per\u00FA ", "Polinesia Francesa ", "Polonia ", "Portugal ", "Puerto Rico ", "Qatar ", "Reino Unido ", "Rep\u00FAblica Centroafricana ", "Rep\u00FAblica Checa ", "Rep\u00FAblica Democr\u00E1tica del Congo ", "Rep\u00FAblica Dominicana ", "Ruanda ", "Rumania ", "Rusia ", "S\u00E1hara Occidental ", "Samoa ", "Samoa Americana ", "San Crist\u00F3bal y Nieves ", "San Marino ", "San Pedro y Miquel\u00F3n ", "San Vicente y las Granadinas ", "Santa Helena ", "Santa Luc\u00EDa ", "Santo Tom\u00E9 y Pr\u00EDncipe ", "Senegal ", "Seychelles ", "Sierra Leona ", "Singapur ", "Siria ", "Somalia ", "Southern Ocean ", "Spratly Islands ", "Sri Lanka ", "Suazilandia ", "Sud\u00E1frica ", "Sud\u00E1n ", "Suecia ", "Suiza ", "Surinam ", "Svalbard y Jan Mayen ", "Tailandia ", "Taiw\u00E1n ", "Tanzania ", "Tayikist\u00E1n ", "TerritorioBrit\u00E1nicodel Oc\u00E9ano Indico ", "Territorios Australes Franceses ", "Timor Oriental ", "Togo ", "Tokelau ", "Tonga ", "Trinidad y Tobago ", "T\u00FAnez ", "Turkmenist\u00E1n ", "Turqu\u00EDa ", "Tuvalu ", "Ucrania ", "Uganda ", "Uni\u00F3n Europea ", "Uruguay ", "Uzbekist\u00E1n ", "Vanuatu ", "Venezuela ", "Vietnam ", "Wake Island ", "Wallis y Futuna ", "West Bank ", "World ", "Yemen ", "Yibuti ", "Zambia ", "Zimbabue "}));
		cbx_pais.setBounds(278, 24, 536, 32);
		panel.add(cbx_pais);
		
		JPanel region_norte = new JPanel();
		region_norte.setBorder(null);
		region_norte.setBackground(SystemColor.inactiveCaptionBorder);
		region_norte.setBounds(10, 166, 432, 298);
		contentPanel.add(region_norte);
		region_norte.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 432, 298);
		region_norte.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				nombreEquipo = (String) table.getModel().getValueAt(index, 0);
				inde = LigaBeisbol.getInstance().BuscarPorNombre(nombreEquipo);
				ListadoJugadores j = new ListadoJugadores(true);
				j.setVisible(true);
			}
		});
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		String[] columnheardes = { "Región Norte" };
		tablemodel = new DefaultTableModel();
		tablemodel.setColumnIdentifiers(columnheardes);
		table.setModel(tablemodel);
		
		JPanel region_sur = new JPanel();
		region_sur.setBorder(null);
		region_sur.setBackground(SystemColor.inactiveCaptionBorder);
		region_sur.setBounds(452, 166, 432, 298);
		contentPanel.add(region_sur);
		region_sur.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 432, 298);
		region_sur.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				nombreEquipo = (String) table_1.getModel().getValueAt(index, 0);
				inde = LigaBeisbol.getInstance().BuscarPorNombre(nombreEquipo);
				ListadoJugadores j = new ListadoJugadores(true);
				j.setVisible(true);
			}
		});
		table_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_1);
		String[] columnheardes1 = { "Región Sur" };
		tablemodel2 = new DefaultTableModel();
		tablemodel2.setColumnIdentifiers(columnheardes1);
		table_1.setModel(tablemodel2);
		
		JPanel region_oeste = new JPanel();
		region_oeste.setBorder(null);
		region_oeste.setBackground(SystemColor.inactiveCaptionBorder);
		region_oeste.setBounds(10, 482, 432, 298);
		contentPanel.add(region_oeste);
		region_oeste.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 432, 298);
		region_oeste.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_2.getSelectedRow();
				nombreEquipo = (String) table_2.getModel().getValueAt(index, 0);
				inde = LigaBeisbol.getInstance().BuscarPorNombre(nombreEquipo);
				ListadoJugadores j = new ListadoJugadores(true);
				j.setVisible(true);
			}
		});
		table_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(table_2);
		String[] columnheardes2 = { "Región Este" };
		tablemodel3 = new DefaultTableModel();
		tablemodel3.setColumnIdentifiers(columnheardes2);
		table_2.setModel(tablemodel3);
		
		JPanel region_este = new JPanel();
		region_este.setBackground(SystemColor.inactiveCaptionBorder);
		region_este.setBounds(452, 482, 432, 298);
		contentPanel.add(region_este);
		region_este.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 432, 298);
		region_este.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_3.getSelectedRow();
				nombreEquipo = (String) table_3.getModel().getValueAt(index, 0);
				inde = LigaBeisbol.getInstance().BuscarPorNombre(nombreEquipo);
				ListadoJugadores j = new ListadoJugadores(true);
				j.setVisible(true);
			}
		});
		table_3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(table_3);
		String[] columnheardes3 = { "Región Oeste" };
		tablemodel4 = new DefaultTableModel();
		tablemodel4.setColumnIdentifiers(columnheardes3);
		table_3.setModel(tablemodel4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarPosicionNorte();
		cargarPosicionSur();
		cargarPosicionOeste();
		cargarPosicionEste();
		
	}
	
	private static void cargarPosicionNorte(){
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Equipos team : LigaBeisbol.getInstance().getEquipo()) {
			if(team.getRegion().equalsIgnoreCase("Norte")){
				fila[0] = team.getNombre();
				tablemodel.addRow(fila);
			}
		}
	}
	private static void cargarPosicionSur(){
		tablemodel2.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_1.getColumnModel().getColumn(0).setCellRenderer(tcr);
		fila2 = new Object[tablemodel2.getColumnCount()];
		for (Equipos team : LigaBeisbol.getInstance().getEquipo()) {
			if(team.getRegion().equalsIgnoreCase("Sur")){
				fila2[0] = team.getNombre();
				tablemodel2.addRow(fila2);
			}
		}
	}
	private static void cargarPosicionOeste(){
		tablemodel3.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_2.getColumnModel().getColumn(0).setCellRenderer(tcr);
		fila3 = new Object[tablemodel3.getColumnCount()];
		for (Equipos team : LigaBeisbol.getInstance().getEquipo()) {
			if(team.getRegion().equalsIgnoreCase("Oeste")){
				fila3[0] = team.getNombre();
				tablemodel3.addRow(fila3);
			}
		}
	}
	private static void cargarPosicionEste(){
		tablemodel4.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_3.getColumnModel().getColumn(0).setCellRenderer(tcr);
		fila4 = new Object[tablemodel4.getColumnCount()];
		for (Equipos team : LigaBeisbol.getInstance().getEquipo()) {
			if(team.getRegion().equalsIgnoreCase("Este")){
				fila4[0] = team.getNombre();
				tablemodel4.addRow(fila4);
			}
		}
	}
}
