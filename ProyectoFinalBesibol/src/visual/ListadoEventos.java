package visual;

import java.awt.BorderLayout;

import java.io.*;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logical.Equipos;
import logical.LigaBeisbol;
import logical.Partido;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tablemodel;
	static Object fila[];
	private static JTable table;
	private JButton btnEliminar, modificar;
	private Partido miPartido;
	/**
	 * Create the dialog.
	 */
	public ListadoEventos() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 687, 455);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblListadoDeEquipos = new JLabel("Listado de Partidos");
			lblListadoDeEquipos.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
			lblListadoDeEquipos.setBounds(20, 11, 240, 37);
			contentPanel.add(lblListadoDeEquipos);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 59, 641, 2);
		contentPanel.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(20, 73, 641, 299);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 621, 277);
			panel.add(scrollPane);
			
			String[] columnsHeaders = {"Equipo Local", " Equipo Visita", " Estadio", " Fecha", " Hora", "Finalizado"};
			tablemodel = new DefaultTableModel();
			tablemodel.setColumnIdentifiers(columnsHeaders);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int ind = table.getSelectedRow();
					String local = (String) table.getModel().getValueAt(ind, 0);
					String visita = (String) table.getModel().getValueAt(ind, 1);
					String fecha = (String) table.getModel().getValueAt(ind, 3);
					miPartido = LigaBeisbol.getInstance().buscarPartido(local, visita, fecha);
					btnEliminar.setEnabled(true);
					if(miPartido.getCarrerasCasa()==0 && miPartido.getCarrerasVisita()==0){ 
						modificar.setEnabled(true);
					}else{ 
						modificar.setEnabled(false);
					}
					
				}
			});
			scrollPane.setViewportView(table);
			table.setModel(tablemodel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnImprimir = new JButton("Imprimir");
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InformePartidos i = new InformePartidos();
					i.setVisible(true);
				}
			});
			btnImprimir.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			buttonPane.add(btnImprimir);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LigaBeisbol.getInstance().eliminarPartido(miPartido);
					ListadoEventos.cargar();
					Principal.cargar();
				}
			});
			
			JButton btnGenerarPartidos = new JButton("Generar partidos");
			btnGenerarPartidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Principal.liga();
					ListadoEventos.cargar();
					Principal.cargar();
				}
			});
			btnGenerarPartidos.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			buttonPane.add(btnGenerarPartidos);
			btnEliminar.setEnabled(false);
			//ImageIcon btnEliminar = new ImageIcon(location);
			//btnEliminar.setSelectedIcon(arg0);
			btnEliminar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			buttonPane.add(btnEliminar);
			
			modificar = new JButton("Modificar");
			modificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					RegistrarPartido reg = new RegistrarPartido(true, miPartido);
					reg.setVisible(true);
				}
			});
			modificar.setEnabled(false);
			modificar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			buttonPane.add(modificar);
			{
				JButton okButton = new JButton("Cerrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				//okButton.setActionCommand("");
				buttonPane.add(okButton);
				//getRootPane().setDefaultButton(okButton);
			}
		}
		generarTexto();
		cargar();
	}
	
	public static void cargar(){
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table.getColumnModel().getColumn(4).setCellRenderer(tcr);
		table.getColumnModel().getColumn(5).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Partido aux : LigaBeisbol.getInstance().getPartido()) {
			fila[0] = aux.getEquipoCasa();
			fila[1] = aux.getEquipoVisita();
			fila[2] = aux.getEstadio();
			fila[3] = aux.getFecha();
			fila[4] = aux.getHora();
			if(aux.getCarrerasCasa()==0 && aux.getCarrerasVisita()==0){
				fila[5] = "-";
			}else{
				fila[5] = ""+aux.getCarrerasCasa()+" - "+aux.getCarrerasVisita();
			}
			tablemodel.addRow(fila);
		}
	}
	public static void generarTexto(){
		try {
			String separador = System.getProperty("line.separator");
			try {
				String name = "informePartido.txt";
				File file = new File(name);
				Writer writer = new BufferedWriter(new FileWriter(file));
				writer.write(separador+"+---------------------------------------------------------------------------------------------------------------------------------+");
				writer.write(separador+"|  Equipo Local              Equipo Visitante          Estadio               Fecha               Hora                Finalizado   |");
				for (Partido aux : LigaBeisbol.getInstance().getPartido()) {
					String vacio;
					if (aux.getCarrerasCasa() == 0 && aux.getCarrerasVisita() == 0) {
						vacio =  "-";
					} else {
						vacio = aux.getCarrerasCasa() + " - " + aux.getCarrerasVisita();
					}
					writer.write(separador+"|    "+ padRight(aux.getEquipoCasa(), 28) +  padRight(aux.getEquipoVisita(), 23) + padRight(aux.getEstadio(), 16) + padRight(aux.getFecha(), 11) +  "           " + padRight(aux.getHora(), 23) +  padRight(vacio, 11) + "|");
				}
				writer.write(separador+"+---------------------------------------------------------------------------------------------------------------------------------+");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NullPointerException e) {
			System.out.println("Error: no hay jugadores y no se pudo crear el archivo txt");
		}
	}
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}

	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}
}