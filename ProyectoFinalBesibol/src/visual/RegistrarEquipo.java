package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.border.EtchedBorder;
import logical.Equipos;
import logical.LigaBeisbol;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class RegistrarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tdfNombre;
	private JTextField tdfManager;
	private JTextField tdfEstadio;
	private JComboBox cbxRegion;
	private JComboBox cbxAgno;
	private JLabel lbFoto;
	public static String route2;

	/**
	 * Create the dialog.
	 */
	public RegistrarEquipo(boolean update, Equipos equipo) {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 530, 354);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		if(update==false){
			lblNewLabel.setText("Registrar Equipo");
		}else{
			lblNewLabel.setText("Modificar Equipo");
		}
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 11, 207, 37);
		contentPanel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 59, 503, 2);
		contentPanel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 72, 73, 19);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblAoDeCreacin = new JLabel("A\u00F1o de creaci\u00F3n:");
		lblAoDeCreacin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblAoDeCreacin.setBounds(10, 207, 131, 19);
		contentPanel.add(lblAoDeCreacin);
		
		JLabel lblManager = new JLabel("Manager:");
		lblManager.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblManager.setBounds(10, 118, 73, 19);
		contentPanel.add(lblManager);
		
		JLabel lblEstadio = new JLabel("Estadio:");
		lblEstadio.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEstadio.setBounds(10, 249, 73, 19);
		contentPanel.add(lblEstadio);
		
		tdfNombre = new JTextField();
		tdfNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		tdfNombre.setBounds(149, 65, 187, 32);
		contentPanel.add(tdfNombre);
		tdfNombre.setColumns(10);
		
		
		ArrayList<String> years_tmp = new ArrayList<String>();
		years_tmp.add("<Seleccione>");
        for(int years = 1900 ; years<=Calendar.getInstance().get(Calendar.YEAR);years++){
        	years_tmp.add(years+"");
       }
		cbxAgno = new JComboBox(years_tmp.toArray());
		cbxAgno.setSelectedIndex(0);
		cbxAgno.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		cbxAgno.setBounds(149, 201, 141, 32);
		contentPanel.add(cbxAgno);
		
		tdfManager = new JTextField();
		tdfManager.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		tdfManager.setColumns(10);
		tdfManager.setBounds(149, 111, 187, 32);
		contentPanel.add(tdfManager);
		
		tdfEstadio = new JTextField();
		tdfEstadio.setBounds(149, 244, 141, 32);
		contentPanel.add(tdfEstadio);
		tdfEstadio.setColumns(10);
		
		JLabel lblRegion = new JLabel("Regi\u00F3n:");
		lblRegion.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblRegion.setBounds(10, 165, 73, 19);
		contentPanel.add(lblRegion);
		
		cbxRegion = new JComboBox();
		cbxRegion.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cbxRegion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Norte", "Este", "Oeste", "Sur"}));
		cbxRegion.setSelectedIndex(0);
		cbxRegion.setBounds(149, 158, 187, 32);
		contentPanel.add(cbxRegion);
		
		JPanel panel = new JPanel() {
		    protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};
		panel.setOpaque(false);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(0, 0, 0, 10));
		panel.setBounds(393, 65, 120, 90);
		contentPanel.add(panel);
		
		lbFoto = new JLabel("");
		panel.add(lbFoto);
		
		JButton btnNewButton = new JButton("Subir Foto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tdfNombre.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Tienes que poner el nombre antes de guardar una foto." , "Error:", JOptionPane.ERROR_MESSAGE);
				}else{
					BufferedImage image;
					JFileChooser chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					File f = chooser.getSelectedFile();
					route2 = "";
					try {
						route2 = f.getAbsolutePath();
					} catch (NullPointerException e2) {
						
					}
					try {
						image = ImageIO.read(f);
						String route = "equipos/" + tdfNombre .getText() +".png";
						ImageIO.write(image, "png",new File(route));
						ImageIcon imagee = new ImageIcon(route2);
						lbFoto.setIcon(null);
						lbFoto.setIcon(imagee);
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}catch (IllegalArgumentException e2) {
						JOptionPane.showMessageDialog(null, "Debes escoger una foto." , "Error:", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnNewButton.setBounds(394, 158, 119, 32);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(update==false){
							String nombre = tdfNombre.getText();
							String manager = tdfManager.getText();
							String agno = cbxAgno.getSelectedItem().toString();
							String nombreEstadio = tdfEstadio.getText();
							String region = cbxRegion.getSelectedItem().toString();
							
							if(nombre.equalsIgnoreCase("")|| manager.equalsIgnoreCase("")|| cbxAgno.getSelectedIndex()==0 || cbxRegion.getSelectedIndex()==0){
								JOptionPane.showMessageDialog(null, "No dejes los espacios en blancos" , "Error", JOptionPane.WARNING_MESSAGE);
							} else {
								Equipos miEquipo = new Equipos(nombre, agno, manager, region, nombreEstadio);
								LigaBeisbol.getInstance().insertarEquipo(miEquipo);
								JOptionPane.showMessageDialog(null, "El equipo " + nombre + " se registró correctamente", "Registrado", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
						}else{
							String nombre = tdfNombre.getText();
							String manager = tdfManager.getText();
							String agno = cbxAgno.getSelectedItem().toString();
							String nombreEstadio = tdfEstadio.getText();
							String region = cbxRegion.getSelectedItem().toString();
							if(nombre.equalsIgnoreCase("")|| manager.equalsIgnoreCase("")|| cbxAgno.getSelectedIndex()==0 || cbxRegion.getSelectedIndex()==0){
								JOptionPane.showMessageDialog(null, "No dejes los espacios en blancos" , "Error", JOptionPane.WARNING_MESSAGE);
							} else {
								equipo.setNombre(nombre);
								equipo.setManager(manager);
								equipo.setAgnocreacion(agno);
								equipo.setEstadio(nombreEstadio);
								equipo.setRegion(region);
								JOptionPane.showMessageDialog(null, "El equipo " + nombre + " se ha modificado correctamente", "Modificado", JOptionPane.INFORMATION_MESSAGE);
								EquipoCaracteristicas.cargar(equipo);
								TablaPosiciones.cargarPosicionOeste();
								TablaPosiciones.cargarPosicionNorte();
								TablaPosiciones.cargarPosicionSur();
								TablaPosiciones.cargarPosicionEste();
								dispose();
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if(update == true){
			cargarModificacion(equipo);
		}
	}
	
	public void clean(){
		tdfNombre.setText("");
		tdfManager.setText("");
		cbxAgno.setSelectedIndex(0);
		tdfEstadio.setText("");
		cbxRegion.setSelectedIndex(0);
	}
	
	public void cargarModificacion(Equipos equipo){
		tdfNombre.setText(equipo.getNombre());
		tdfManager.setText(equipo.getManager());
		tdfEstadio.setText(equipo.getEstadio());
		cbxRegion.setSelectedItem(equipo.getRegion());
		cbxAgno.setSelectedItem(equipo.getAgnocreacion());
		ImageIcon image = new ImageIcon("equipos/" + equipo.getNombre() + ".png");
		lbFoto.setIcon(image);
	}
}
