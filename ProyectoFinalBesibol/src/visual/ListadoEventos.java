package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

public class ListadoEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tablemodel;
	static Object fila[];
	private static JTable table;
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
			
			String[] columnsHeaders = {"Equipo Local", " Equipo Visita", " Estadio", " Fecha", " Hora"};
			tablemodel = new DefaultTableModel();
			tablemodel.setColumnIdentifiers(columnsHeaders);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(tablemodel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnImprimir = new JButton("Imprimir");
			btnImprimir.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			buttonPane.add(btnImprimir);
			
			JButton btnNewButton = new JButton("Ver Detalles");
			btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			buttonPane.add(btnNewButton);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				//okButton.setActionCommand("");
				buttonPane.add(okButton);
				//getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargar();
	}
	
	public void cargar(){
		tablemodel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table.getColumnModel().getColumn(4).setCellRenderer(tcr);
		fila = new Object[tablemodel.getColumnCount()];
		for (Partido aux : LigaBeisbol.getInstance().getPartido()) {
			fila[0] = aux.getEquipoCasa();
			fila[1] = aux.getEquipoVisita();
			fila[2] = aux.getEstadio();
			Date fecha = new Date(aux.getFecha().getYear(), aux.getFecha().getMonth(), aux.getFecha().getDate());
			LocalDate localfecha = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Locale spanishLocale = new Locale("es", "ES");
			String fechaString = localfecha.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", spanishLocale));
			fila[3] = fechaString;
			fila[4] = aux.getHora();
			tablemodel.addRow(fila);
		}
	}
}
