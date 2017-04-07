package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logical.LigaBeisbol;
import logical.Equipos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstadisticaEquipos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	static Object[] fila;
	private static DefaultTableModel tableModel;
	private String nombreHotel;
	private static LigaBeisbol Equipos;
	private int index;

	public EstadisticaEquipos() {
		setModal(true);
		setTitle("Listado de Hoteles");
		setResizable(false);
		setModal(true);	
		setBounds(100, 100, 473, 310);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 437, 213);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 34, 417, 168);
			panel.add(scrollPane);

			String[] columnsHeaders = { "Nombres", "Provincia", "Estrellas", "Cantidad Habitaciones" };
			tableModel = new DefaultTableModel();
			tableModel.setColumnIdentifiers(columnsHeaders);

			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (table.getSelectedRow() >= 0) {
						
						index = table.getSelectedRow();
						nombreHotel = (String) table.getModel().getValueAt(index, 0);
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(tableModel);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarHoteles();
	}

	public static void cargarHoteles() {
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		fila = new Object[tableModel.getColumnCount()];
		for (int i = 0; i < LigaBeisbol.getInstance().getEquipo().size(); i++) {
			//fila[0] = LigaBeisbol.getInstance().getHotel().get(i).getNombre();
			//fila[1] = Controladora.getInstance().getHotel().get(i).getProvincia();
			//fila[2] = Controladora.getInstance().getHotel().get(i).getEstrellas();
			//fila[3] = Controladora.getInstance().getHotel().get(i).getCantDoble()
				//	+ Controladora.getInstance().getHotel().get(i).getCantSimple()
					//+ Controladora.getInstance().getHotel().get(i).getCantSuite();

			tableModel.addRow(fila);
		}
	}
}
