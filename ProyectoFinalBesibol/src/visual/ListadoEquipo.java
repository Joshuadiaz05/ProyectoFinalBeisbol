package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import logical.Equipos;
import logical.LigaBeisbol;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class ListadoEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tablemodel;
	static Object fila[];
	private static JTable table;
	/**
	 * Create the dialog.
	 */
	public ListadoEquipo() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 687, 455);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblListadoDeEquipos = new JLabel("Listado de Equipos");
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
			
			String[] columnsHeaders = {"Nombre", " Año de creacion", " Manager", "Region", "Estadio"}; 
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
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						try {
							File file = new File("ListadoEquipos.txt");
							if (!file.exists()) {
								file.createNewFile();
							}
							String separador = System.getProperty("line.separator");
							FileWriter fw = new FileWriter(file.getAbsoluteFile());
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(
									"\n		    <<<<<<<<<<<Lista de Equipos>>>>>>>>>>>   \r\n");
							bw.write(
									"\r\n ------------------------------------------------------------------------------------------------------------------------\r\n");
							bw.write("Nombre               Año de Creación            Entranador             Region            Estadio \r\n");
							bw.write(
									"-------------------------------------------------------------------------------------------------------------------------\r\n");
							for (int i = 0; i < tablemodel.getRowCount(); i++) {

								for (int j = 0; j < tablemodel.getColumnCount(); j++) {
									bw.write(table.getModel().getValueAt(i, j) + "               ");
								}

								bw.write("\r\n");
							}
							bw.write(
									"-------------------------------------------------------------------------------------------------------------------------\r\n");
							bw.close();
							fw.close();
							JOptionPane.showMessageDialog(null, "Lista de Equipos impresa!");

						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
			});
			btnImprimir.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			buttonPane.add(btnImprimir);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargar();
		Principal.ordenar();
	}
	
	public void cargar(){
		tablemodel.setRowCount(0);
		fila = new Object[tablemodel.getColumnCount()];
		for (Equipos aux : LigaBeisbol.getInstance().getEquipo()) {
			fila[0] = aux.getNombre();
			fila[1] = aux.getAgnocreacion();
			fila[2] = aux.getManager();
			fila[3] = aux.getRegion();
			fila[4] = aux.getEstadio();
			tablemodel.addRow(fila);
		}
	}
	
}
