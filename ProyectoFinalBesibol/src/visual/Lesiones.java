package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import logical.Equipos;
import logical.Jugadores;
import logical.LigaBeisbol;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;

public class Lesiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cBjugador;
	private JComboBox cBtipo;
	private JDateChooser dateChooser;
	private JEditorPane editorPane;
	private JTextField textField;

	public Lesiones(Equipos equipo) {
		setTitle("Lesiones");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imag/crutches-293962_960_720.png"));
		setBounds(100, 100, 412, 432);
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 375, 346);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblEquipo = new JLabel("Equipo");
				lblEquipo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				lblEquipo.setBounds(158, 57, 58, 17);
				panel.add(lblEquipo);
			}
			{
				JLabel lblJugador = new JLabel("Jugador");
				lblJugador.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				lblJugador.setBounds(10, 121, 114, 17);
				panel.add(lblJugador);
			}
			{
				
				ArrayList<String> nomJugadores = new ArrayList<String>();
				nomJugadores.add("<Seleccione Jugador>");
		        for(int index = 0; index < equipo.getJugador().size(); index++){
		        	if(equipo.getJugador().get(index).isLesion()==false){
		        		nomJugadores.add(equipo.getJugador().get(index).getNombre());
					}
		       }

				cBjugador = new JComboBox(nomJugadores.toArray());
				cBjugador.setSelectedIndex(0);
				cBjugador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (!cBjugador.getSelectedItem().toString().equalsIgnoreCase("<Seleccione Jugador>")) {
							dateChooser.setEnabled(true);
							cBtipo.setEnabled(true);
						}
					}
				});
				cBjugador.setBounds(10, 142, 164, 32);
				panel.add(cBjugador);
			}
			{
				JLabel lblFecha = new JLabel("Fecha");
				lblFecha.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
				lblFecha.setBounds(201, 121, 58, 17);
				panel.add(lblFecha);
			}

			dateChooser = new JDateChooser();
			dateChooser.setEnabled(false);
			dateChooser.setBounds(201, 142, 164, 32);
			panel.add(dateChooser);

			JLabel lblTipo = new JLabel("Tipo");
			lblTipo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblTipo.setBounds(10, 195, 64, 17);
			panel.add(lblTipo);

			cBtipo = new JComboBox();
			cBtipo.setEnabled(false);
			cBtipo.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>",
					"Esguinces o torceduras de ligamentos y tendones", "Lesiones en la rodilla",
					"Hinchaz\u00F3n muscular", "Lesiones en el tend\u00F3n de Aquiles",
					"Dolor a lo largo del hueso de la canilla", "Fracturas", "Dislocaciones" }));
			cBtipo.setBounds(10, 213, 355, 32);
			panel.add(cBtipo);

			JLabel lblComentario = new JLabel("Observaci\u00F3n");
			lblComentario.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			lblComentario.setBounds(132, 259, 93, 17);
			panel.add(lblComentario);

			editorPane = new JEditorPane();
			editorPane.setForeground(new Color(0, 0, 0));
			editorPane.setBounds(10, 277, 355, 58);
			panel.add(editorPane);
			{
				textField = new JTextField("" + equipo.getNombre());
				textField.setEditable(false);
				textField.setBounds(90, 78, 195, 32);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblLesiones = new JLabel("Lesiones");
				lblLesiones.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
				lblLesiones.setBounds(10, 11, 124, 32);
				panel.add(lblLesiones);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(10, 44, 355, 2);
				panel.add(separator);
			}
			{
				JLabel label = new JLabel(""); 
				label.setIcon(new ImageIcon("img/less.png"));
				label.setBounds(128, 11, 35, 32);
				panel.add(label);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nomequipo = equipo.getNombre();
						String tipoLesion = cBtipo.getSelectedItem().toString();
						String nombrejugador = cBjugador.getSelectedItem().toString();
						Date date = dateChooser.getDate();
						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						String fechalesion = df.format(date);
						String comentario = editorPane.getText();
						logical.Lesiones lesion = new logical.Lesiones(nomequipo, nombrejugador, fechalesion,
								tipoLesion, comentario);
						equipo.agregarLesion(nombrejugador, true, false, lesion);
						EquipoCaracteristicas.cargarJugadoresLesionadoPorEquipo();
						dispose();						
					} 
				});
				okButton.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
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
				cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
