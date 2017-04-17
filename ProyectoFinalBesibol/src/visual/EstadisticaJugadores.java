package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import logical.Equipos;
import logical.Estadisticas;
import logical.Jugadores;
import logical.LigaBeisbol;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;

public class EstadisticaJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	static Object[] fila;
	private static DefaultTableModel tablemodel;
	private static JLabel lbFoto;


	public EstadisticaJugadores() {
		Jugadores aux = ListadoJugadores.jugador;
		setTitle("Jugador: " + ListadoJugadores.jugador.getNombre() + " " + ListadoJugadores.jugador.getApellido());
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 793, 382);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel(){
	        @Override
	        protected void paintComponent(Graphics grphcs) {
	            super.paintComponent(grphcs);
	            Graphics2D g2d = (Graphics2D) grphcs;
	            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                    RenderingHints.VALUE_ANTIALIAS_ON);
	            GradientPaint gp = new GradientPaint(0, 0,
	                    getBackground().brighter().brighter(), 0, getHeight(),
	                    getBackground().darker().darker());
	            g2d.setPaint(gp);
	            g2d.fillRect(0, 0, getWidth(), getHeight()); 

	        }

	    };
		panel.setBounds(10, 59, 766, 177);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel(){
		    protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};
		panel_2.setOpaque(false); // background of parent will be painted first
		panel_2.setBackground( new Color(0, 0, 0, 10) );
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 22, 205, 155);
		panel.add(panel_2);
		
		lbFoto = new JLabel("");
		ImageIcon image = new ImageIcon("img/player_blank.png");
		lbFoto.setIcon(image);
		lbFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lbFoto.setBounds(0, 2, 202, 150);
		panel_2.add(lbFoto);
		
		JLabel lbNombre = new JLabel(ListadoJugadores.jugador.getNombre() + " " + ListadoJugadores.jugador.getApellido());
		lbNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lbNombre.setBounds(225, 22, 352, 31);
		panel.add(lbNombre);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(225, 53, 531, 2);
		panel.add(separator_1);
		
		JLabel lbNumero = new JLabel("#" + ListadoJugadores.jugador.getNumero());
		lbNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbNumero.setBounds(225, 60, 42, 14);
		panel.add(lbNumero);
		String pos = "";
		//"Pitcher", "Catcher", "Primera base", "Segunda base", "Tercera base", "Short stop", "Left fielder", "Center fielder", "Right fielder"
		if(aux.getPosicion().equalsIgnoreCase("Primera base")){
			pos = "1B";
		}else if(aux.getPosicion().equalsIgnoreCase("Segunda base")){
			pos = "2B";
		}else if(aux.getPosicion().equalsIgnoreCase("Tercera base")){
			pos = "3B";
		}else if(aux.getPosicion().equalsIgnoreCase("Pitcher")){
			pos = "P";
		}else if(aux.getPosicion().equalsIgnoreCase("Catcher")){
			pos = "C";
		}else if(aux.getPosicion().equalsIgnoreCase("Short stop")){
			pos = "SS";
		}else if(aux.getPosicion().equalsIgnoreCase("Left fielder")){
			pos = "LF";
		}else if(aux.getPosicion().equalsIgnoreCase("Center fielder")){
			pos = "CF";
		}else if(aux.getPosicion().equalsIgnoreCase("Right fielder")){
			pos = "RF";
		}
		JLabel lbPos = new JLabel(pos);
		lbPos.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbPos.setBounds(250, 60, 25, 14);
		panel.add(lbPos);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(260, 60, 8, 14);
		panel.add(separator_2);

		JLabel lbZurdoODiestro = new JLabel("Batea:");
		lbZurdoODiestro.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbZurdoODiestro.setBounds(270, 60, 54, 14);
		panel.add(lbZurdoODiestro);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento: ");
		lblFechaDeNacimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblFechaDeNacimiento.setBounds(225, 83, 179, 14);
		panel.add(lblFechaDeNacimiento);
		
		LocalDate localDate = LocalDate.of(ListadoJugadores.jugador.getFechanacimiento().getYear(),	ListadoJugadores.jugador.getFechanacimiento().getMonthValue(), ListadoJugadores.jugador.getFechanacimiento().getDayOfMonth());
		Locale spanishLocale = new Locale("es", "ES");
		String dia = localDate.format(DateTimeFormatter.ofPattern("dd", spanishLocale));
		String mes = localDate.format(DateTimeFormatter.ofPattern("MMMM", spanishLocale));
		String agno = localDate.format(DateTimeFormatter.ofPattern("yyyy", spanishLocale));
		JLabel lblFecha = new JLabel(dia + " de " + mes + " de " + agno + " (Edad: " + Math.abs(ListadoJugadores.jugador.getFechanacimiento().getYear() - LocalDate.now().getYear()) + ")");
		lblFecha.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblFecha.setBounds(401, 83, 355, 14);
		panel.add(lblFecha);

		JLabel lblLugarDeNacimiento = new JLabel("Lugar de Nacimiento: ");
		lblLugarDeNacimiento.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblLugarDeNacimiento.setBounds(225, 105, 169, 19);
		panel.add(lblLugarDeNacimiento);

		JLabel lbLugar = new JLabel(ListadoJugadores.jugador.getLugarciudadNacimiento() + ", " + ListadoJugadores.jugador.getLugarpaisNacimiento());
		lbLugar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbLugar.setBounds(401, 105, 355, 19);
		panel.add(lbLugar);

		JLabel lblUniversidad = new JLabel("Universidad: ");
		lblUniversidad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblUniversidad.setBounds(225, 130, 99, 19);
		panel.add(lblUniversidad);

		JLabel lbUni = new JLabel(ListadoJugadores.jugador.getUniversidad());
		lbUni.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbUni.setBounds(327, 130, 429, 19);
		panel.add(lbUni);
		
		JLabel lbBatea = new JLabel("I");
		if(aux.getBatea().equalsIgnoreCase("Izquierda")){
			lbBatea.setText("I");
		}else if(aux.getBatea().equalsIgnoreCase("Derecha")){
			lbBatea.setText("D");
		}
		lbBatea.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbBatea.setBounds(325, 60, 14, 14);
		panel.add(lbBatea);
		
		JLabel lbLanza = new JLabel("Lanza:");
		lbLanza.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbLanza.setBounds(334, 60, 54, 14);
		panel.add(lbLanza);
		
		JLabel lbLanzaa = new JLabel("D");
		if(aux.getLanza().equalsIgnoreCase("Izquierda")){
			lbLanzaa.setText("I");
		}else if(aux.getLanza().equalsIgnoreCase("Derecha")){
			lbLanzaa.setText("D");
		}
		lbLanzaa.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lbLanzaa.setBounds(390, 60, 14, 14);
		panel.add(lbLanzaa);
		
		JLabel lblNewLabel = new JLabel("Jugador MLB");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 0, 767, 48);
		contentPanel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 766, 2);
		contentPanel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Estadistica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 247, 766, 69);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 22, 746, 37);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String[] columndsheaders = {"AB", "C", "H", "2B", "3B", "HR", "RBI", "BB"}; 
		tablemodel = new DefaultTableModel();
		tablemodel.setColumnIdentifiers(columndsheaders);
		table.setModel(tablemodel);
		{
			JPanel buttonPane = new JPanel();
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
		cargarEstadisticas();
	}
	public static void cargarEstadisticas(){
		File file = new File("jugadores/" + ListadoJugadores.jugador.getNombre() + ".png");
		if(file.exists()){
			ImageIcon image = new ImageIcon("jugadores/" + ListadoJugadores.jugador.getNombre() + ".png");
			lbFoto.setIcon(image);
		} else {
			ImageIcon image = new ImageIcon("img/player_blank.png");
			lbFoto.setIcon(image);
		}
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table.getColumnModel().getColumn(4).setCellRenderer(tcr);
		table.getColumnModel().getColumn(5).setCellRenderer(tcr);
		table.getColumnModel().getColumn(6).setCellRenderer(tcr);
		table.getColumnModel().getColumn(7).setCellRenderer(tcr);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		fila = new Object[tablemodel.getColumnCount()];
		fila[0] = ListadoJugadores.jugador.getEstadistica().getTurnosjugados();
		fila[1] = ListadoJugadores.jugador.getEstadistica().getCarreraAnotadas();
		fila[2] = ListadoJugadores.jugador.getEstadistica().getHits();
		fila[3] = ListadoJugadores.jugador.getEstadistica().getDobles();
		fila[4] = ListadoJugadores.jugador.getEstadistica().getTriples();
		fila[5] = ListadoJugadores.jugador.getEstadistica().getHomeruns();
		fila[6] = ListadoJugadores.jugador.getEstadistica().getRBI();
		fila[7] = ListadoJugadores.jugador.getEstadistica().getBasebola();
		tablemodel.addRow(fila);
	}
}
