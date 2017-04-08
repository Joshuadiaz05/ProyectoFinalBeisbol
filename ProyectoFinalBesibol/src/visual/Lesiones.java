package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lesiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cBjugador;
	private JComboBox cBtipo;
	private JComboBox cBequipo;
	private JDateChooser dateChooser;
	private JEditorPane editorPane;

	public Lesiones() {
		setTitle("Lesiones");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imag/crutches-293962_960_720.png"));
		setBounds(100, 100, 412, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 375, 263);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblEquipo = new JLabel("Equipo");
				lblEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblEquipo.setBounds(201, 18, 58, 17);
				panel.add(lblEquipo);
			}
			{
				cBequipo = new JComboBox();
				cBequipo.setEnabled(false);
				cBequipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Equipo>"}));
				for(Equipos aux : LigaBeisbol.getInstance().getEquipo())	{
					cBequipo.addItem(aux.getNombre());
				}
				cBequipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						cBjugador.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Jugador>"}));
						for (Equipos aux : LigaBeisbol.getInstance().getEquipo()){
							for (Jugadores aux2 : aux.getJugador()){
								cBjugador.setEnabled(true);
								if (cBequipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombre())){
									cBjugador.addItem(aux2.getNombre());
									cBjugador.setEnabled(true);
								}
							}
						}
						if (cBequipo.getSelectedIndex()==0)
							cBjugador.setEnabled(false);
					}
				});
				cBequipo.setBounds(201, 39, 154, 20);
				panel.add(cBequipo);
			}
			{
				JLabel lblJugador = new JLabel("Jugador");
				lblJugador.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblJugador.setBounds(10, 82, 58, 17);
				panel.add(lblJugador);
			}
			{
				cBjugador = new JComboBox();
				cBjugador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (cBjugador.getSelectedIndex()!=0){
							dateChooser.setEnabled(true);
							cBtipo.setEnabled(true);
						}
					}
				});
				cBjugador.setEnabled(false);
				cBjugador.setBounds(10, 100, 154, 20);
				panel.add(cBjugador);
			}
			{
				JLabel lblFecha = new JLabel("Fecha");
				lblFecha.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblFecha.setBounds(201, 82, 58, 17);
				panel.add(lblFecha);
			}

			dateChooser = new JDateChooser();
			dateChooser.setEnabled(false);
			dateChooser.setBounds(201, 100, 154, 20);
			panel.add(dateChooser);

			JLabel lblTipo = new JLabel("Tipo");
			lblTipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblTipo.setBounds(10, 142, 64, 17);
			panel.add(lblTipo);

			cBtipo = new JComboBox();
			cBtipo.setEnabled(false);
			cBtipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Esguinces o torceduras de ligamentos y tendones", "Lesiones en la rodilla", "Hinchaz\u00F3n muscular", "Lesiones en el tend\u00F3n de Aquiles", "Dolor a lo largo del hueso de la canilla", "Fracturas", "Dislocaciones"}));
			cBtipo.setBounds(10, 162, 345, 20);
			panel.add(cBtipo);

			JLabel lblComentario = new JLabel("Observaci\u00F3n");
			lblComentario.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblComentario.setBounds(10, 222, 84, 17);
			panel.add(lblComentario);

			editorPane = new JEditorPane();	
			editorPane.setBounds(104, 208, 251, 44);
			panel.add(editorPane);
			{
				JLabel lblRegion = new JLabel("Region");
				lblRegion.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblRegion.setBounds(10, 18, 58, 17);
				panel.add(lblRegion);
			}
			
			JComboBox cBregion = new JComboBox();
			cBregion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cBregion.getSelectedItem().toString().equalsIgnoreCase("Norte")){
						for(Equipos aux : LigaBeisbol.getInstance().getEquipo())	{
								if(aux.getRegion().equalsIgnoreCase("Norte")){
									cBequipo.addItem(aux.getNombre());
								}
							}
					}else if (cBregion.getSelectedItem().toString().equalsIgnoreCase("Sur")){
						for(Equipos aux : LigaBeisbol.getInstance().getEquipo())	{
							if(aux.getRegion().equalsIgnoreCase("Sur")){
								cBequipo.addItem(aux.getNombre());
							}
						}
					}else if (cBregion.getSelectedItem().toString().equalsIgnoreCase("Este")){
						for(Equipos aux : LigaBeisbol.getInstance().getEquipo())	{
							if(aux.getRegion().equalsIgnoreCase("Este")){
								cBequipo.addItem(aux.getNombre());
							}
						}
					}else if (cBregion.getSelectedItem().toString().equalsIgnoreCase("Oeste")){
						for(Equipos aux : LigaBeisbol.getInstance().getEquipo())	{
							if(aux.getRegion().equalsIgnoreCase("Oeste")){
								cBequipo.addItem(aux.getNombre());
							}
						}
					}

					if (cBregion.getSelectedIndex()==0){
						cBequipo.setEnabled(false);
					}else{
						cBequipo.setEnabled(true);
					}
				}
			});
			cBregion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione la Region>", "Norte", "Sur", "Este", "Oeste"}));
			cBregion.setBounds(10, 39, 154, 20);
			panel.add(cBregion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String equipo = cBequipo.getSelectedItem().toString();
						String tipoLesion = cBtipo.getSelectedItem().toString();
						String nombrejugador = cBjugador.getSelectedItem().toString();
						String fechalesion = dateChooser.getDateFormatString();
						String comentario = editorPane.getText();
						logical.Lesiones lesion = new logical.Lesiones(equipo, nombrejugador, fechalesion, tipoLesion, comentario);
						LigaBeisbol.getInstance().buscarjugador(nombrejugador).setLesion(true);
						LigaBeisbol.getInstance().buscarjugador(nombrejugador).setTitular(false);
					}
				});
				okButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
