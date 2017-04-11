package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import logical.Equipos;
import logical.LigaBeisbol;
import logical.Partido;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListadoEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tablemodel;
	static Object fila[];
	private static JTable table;
	/**
	 * Create the dialog.
	 */
	public ListadoEventos() {
		setBounds(100, 100, 687, 455);
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
		fila = new Object[tablemodel.getColumnCount()];
		for (Partido aux : LigaBeisbol.getInstance().getPartido()) {
			fila[0] = aux.getEquipoCasa();
			fila[1] = aux.getEquipoVisita();
			fila[2] = aux.getEstadio();
			fila[3] = aux.getFecha();
			fila[4] = aux.getHora();
			tablemodel.addRow(fila);
		}
	}
}
