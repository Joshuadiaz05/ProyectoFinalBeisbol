package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.border.TitledBorder;

public class Lesiones extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Lesiones dialog = new Lesiones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Lesiones() {
		setTitle("Lesiones");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./Imag/crutches-293962_960_720.png"));
		setBounds(100, 100, 592, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 556, 263);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblEquipo = new JLabel("Equipo");
				lblEquipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblEquipo.setBounds(10, 22, 58, 17);
				panel.add(lblEquipo);
			}
			{
				JComboBox cBequipo = new JComboBox();
				cBequipo.setBounds(78, 21, 181, 20);
				panel.add(cBequipo);
			}
			{
				JLabel lblJugador = new JLabel("Jugador");
				lblJugador.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblJugador.setBounds(297, 23, 58, 17);
				panel.add(lblJugador);
			}
			{
				JComboBox cBjugador = new JComboBox();
				cBjugador.setBounds(365, 21, 181, 20);
				panel.add(cBjugador);
			}
			{
				JLabel lblFecha = new JLabel("Fecha");
				lblFecha.setFont(new Font("Times New Roman", Font.BOLD, 14));
				lblFecha.setBounds(10, 75, 58, 17);
				panel.add(lblFecha);
			}

			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(78, 73, 181, 20);
			panel.add(dateChooser);

			JLabel lblTipo = new JLabel("Tipo");
			lblTipo.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblTipo.setBounds(297, 75, 64, 17);
			panel.add(lblTipo);

			JComboBox cBtipo = new JComboBox();
			cBtipo.setBounds(365, 74, 181, 20);
			panel.add(cBtipo);

			JLabel lblComentario = new JLabel("Observaci\u00F3n");
			lblComentario.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblComentario.setBounds(244, 122, 84, 17);
			panel.add(lblComentario);

			JTextArea textArea = new JTextArea();
			textArea.setBounds(10, 150, 536, 98);
			panel.add(textArea);

			JEditorPane editorPane = new JEditorPane();
			editorPane.setBounds(85, 150, 397, 98);
			panel.add(editorPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
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
