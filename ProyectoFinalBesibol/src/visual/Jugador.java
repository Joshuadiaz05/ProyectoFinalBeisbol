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
import java.time.LocalDate;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class Jugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tdf_search;
	private static JTable table;
	static Object[] fila;
	private static DefaultTableModel tablemodel;
	private JComboBox comboBox;
	private JComboBox cbx_posicion; 
	private JComboBox cbx_pais;
	private Equipos equipo = LigaBeisbol.getInstance().BuscarPorNombre(VerJugadores.nombreEquipo);
	
	/**
	 * Create the dialog.
	 */
	public Jugador(boolean si) {
		if(si==true){
			setTitle("Mostrar jugador - " + equipo.getNombre());
			setBounds(100, 100, 900, 570);
		} else {
			setTitle("Mostrar jugador");
			setBounds(100, 100, 900, 623);
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
				panel_buscar.setBounds(10, 1, 870, 58);
				contentPanel.add(panel_buscar);
				panel_buscar.setLayout(null);
				{
						JLabel lblNewLabel = new JLabel(equipo.getNombre() + " - Plantel completo");
						lblNewLabel.setBounds(10, 1, 520, 55);
						panel_buscar.add(lblNewLabel);
						lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
				}
				{
					JSeparator separator = new JSeparator();
					separator.setBounds(0, 53, 870, 2);
					panel_buscar.add(separator);
				}
			}
		} else {
			{
				JLabel lblNewLabel = new JLabel("MLB Jugadores");
				lblNewLabel.setBounds(10, 1, 520, 40);
				contentPanel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
				{
					JSeparator separator = new JSeparator();
					separator.setBounds(10, 40, 870, 2);
					contentPanel.add(separator);
				}
		}
			{
				JPanel panel_buscar = new JPanel();
				panel_buscar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_buscar.setBounds(10, 50, 870, 65);
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
					tdf_search = new JTextField();
					tdf_search.setColumns(10);
					tdf_search.setBounds(278, 12, 520, 32);
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
					button.setBounds(815, 12, 43, 32);
					panel_buscar.add(button);
				}
				
				cbx_posicion = new JComboBox();
				cbx_posicion.setModel(new DefaultComboBoxModel(new String[] {"Pitcher", "Catcher", "Primera base", "Segunda base", "Tercera base", "Short stop", "Left fielder", "Center fielder", "Right fielder", "Bateador designado"}));
				cbx_posicion.setSelectedIndex(0);
				cbx_posicion.setVisible(false);
				cbx_posicion.setBounds(278, 12, 520, 32);
				panel_buscar.add(cbx_posicion);
				{
					cbx_pais = new JComboBox();
					cbx_pais.setModel(new DefaultComboBoxModel(new String[] {"Afganist\u00E1n", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiy\u00E1n", "Bahamas", "Banglad\u00E9s", "Barbados", "Bar\u00E9in", "B\u00E9lgica", "Belice", "Ben\u00EDn", "Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brun\u00E9i", "Bulgaria", "Burkina Faso", "Burundi", "But\u00E1n", "Cabo Verde", "Camboya", "Camer\u00FAn", "Canad\u00E1", "Catar", "Chad", "Chile", "China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos \u00C1rabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "Espa\u00F1a", "Estados Unidos", "Estonia", "Etiop\u00EDa", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gab\u00F3n", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea ecuatorial", "Guinea-Bis\u00E1u", "Hait\u00ED", "Honduras", "Hungr\u00EDa", "India", "Indonesia", "Irak", "Ir\u00E1n", "Irlanda", "Islandia", "Islas Marshall", "Islas Salom\u00F3n", "Israel", "Italia", "Jamaica", "Jap\u00F3n", "Jordania", "Kazajist\u00E1n", "Kenia", "Kirguist\u00E1n", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "L\u00EDbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Madagascar", "Malasia", "Malaui", "Maldivas", "Mal\u00ED", "Malta", "Marruecos", "Mauricio", "Mauritania", "M\u00E9xico", "Micronesia", "Moldavia", "M\u00F3naco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "N\u00EDger", "Nigeria", "Noruega", "Nueva Zelanda", "Om\u00E1n", "Pa\u00EDses Bajos", "Pakist\u00E1n", "Palaos", "Panam\u00E1", "Pap\u00FAa Nueva Guinea", "Paraguay", "Per\u00FA", "Polonia", "Portugal", "Reino Unido", "Rep\u00FAblica Centroafricana", "Rep\u00FAblica Checa", "Rep\u00FAblica de Macedonia", "Rep\u00FAblica del Congo", "Rep\u00FAblica Democr\u00E1tica del Congo", "Rep\u00FAblica Dominicana", "Rep\u00FAblica Sudafricana", "Ruanda", "Ruman\u00EDa", "Rusia", "Samoa", "San Crist\u00F3bal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Luc\u00EDa", "Santo Tom\u00E9 y Pr\u00EDncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sud\u00E1n", "Sud\u00E1n del Sur", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikist\u00E1n", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "T\u00FAnez", "Turkmenist\u00E1n", "Turqu\u00EDa", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekist\u00E1n", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue"}));
					cbx_pais.setSelectedIndex(0);
					cbx_pais.setBounds(278, 12, 520, 32);
					cbx_pais.setVisible(false);
					panel_buscar.add(cbx_pais);
				}
			}
		}
		if(si==true){
			{
				JPanel panel_tabla = new JPanel();
				panel_tabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_tabla.setBounds(10, 65, 870, 434);
				contentPanel.add(panel_tabla);
				panel_tabla.setLayout(null);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 21, 850, 402);
					panel_tabla.add(scrollPane);
					{
						table = new JTable();
						scrollPane.setViewportView(table);
						String[] columnsheaders = { "#", "Nombre" , "Equipo", "Posición", "Edad", "Lugar de Nacimiento" };
						tablemodel = new DefaultTableModel();
						tablemodel.setColumnIdentifiers(columnsheaders);
						table.setModel(tablemodel);
					}
				}
			}
		} else {
			{
				JPanel panel_tabla = new JPanel();
				panel_tabla.setBorder(new TitledBorder(null, "MLB B\u00FAsqueda de Jugadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_tabla.setBounds(10, 126, 870, 434);
				contentPanel.add(panel_tabla);
				panel_tabla.setLayout(null);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 21, 850, 402);
					panel_tabla.add(scrollPane);
					{
						table = new JTable();
						scrollPane.setViewportView(table);
						String[] columnsheaders = { "#", "Nombre" , "Equipo", "Posición", "Edad", "Lugar de Nacimiento" };
						tablemodel = new DefaultTableModel();
						tablemodel.setColumnIdentifiers(columnsheaders);
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
					fila[1] = e.getApellido() + ", " + e.getNombre();
					fila[2] = e.getEquipo();
					fila[3] = e.getPosicion();
					long date = Math.abs(e.getFechanacimiento().getYear() - LocalDate.now().getYear());
					fila[4] = date;
					fila[5] = e.getLugarciudadNacimiento();
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
					fila[1] = e.getApellido() + ", " + e.getNombre();
					fila[2] = e.getEquipo();
					fila[3] = e.getPosicion();
					long date = Math.abs(e.getFechanacimiento().getYear() - LocalDate.now().getYear());
					fila[4] = date;
					fila[5] = e.getLugarciudadNacimiento();
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
					fila[1] = e.getApellido() + ", " + e.getNombre();
					fila[2] = e.getEquipo();
					fila[3] = e.getPosicion();
					long date = Math.abs(e.getFechanacimiento().getYear() - LocalDate.now().getYear());
					fila[4] = date;
					fila[5] = e.getLugarciudadNacimiento();
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
				fila[1] = e.getApellido() + ", " + e.getNombre();
				fila[2] = equipo.getNombre();
				fila[3] = e.getPosicion();
				long date = Math.abs(e.getFechanacimiento().getYear() - LocalDate.now().getYear());
				fila[4] = date;
				fila[5] = e.getLugarciudadNacimiento() + ", " + e.getLugarpaisNacimiento();
				tablemodel.addRow(fila);
		}
	}
}
