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
import javax.swing.JTextArea;
import java.io.*;
import java.awt.Color;
public class InformePartidos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;

	/**
	 * Create the dialog.
	 */
	public InformePartidos() {
		setTitle("Informe del partido");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 919, 570);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInformes = new JLabel("Informes del partido");
		lblInformes.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		lblInformes.setBounds(10, 11, 393, 47);
		contentPanel.add(lblInformes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 893, 2);
		contentPanel.add(separator);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		try {
			cargar();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textArea.setBounds(10, 69, 893, 418);
		contentPanel.add(textArea);
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
	}
	private void cargar() throws FileNotFoundException{
		FileReader reader = new FileReader("informePartido.txt");
		BufferedReader br = new BufferedReader(reader);
		try {
			textArea.read(br, null);
			br.close();
			textArea.requestFocus();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
