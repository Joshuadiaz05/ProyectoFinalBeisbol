package visual;
 import java.awt.Color;
 import java.awt.Container;
 import java.awt.Font;
 import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import java.util.ArrayList;
 
 import javax.swing.*;
 
 import org.jvnet.substance.SubstanceLookAndFeel;
 
 import logical.LigaBeisbol;
 
 public class SplashScreen extends JWindow {
 
     static boolean isRegistered;
     private static JProgressBar progressBar = new JProgressBar();
     private static SplashScreen execute;
     private static int count;
     private static int count2;
     private static Timer timer1;
     private static Timer time2;
     private static LigaBeisbol liga;
     private JLabel lbCargando;
     private JLabel lbPorcetanje;
 
     public SplashScreen() {
 
         Container container = getContentPane();
         container.setLayout(null);
 
         JPanel panel = new JPanel();
         panel.setBorder(new javax.swing.border.EtchedBorder());
         panel.setBackground(new Color(255, 255, 255));
         panel.setBounds(10, 10, 348, 150);
         panel.setLayout(null);
         container.add(panel);
 
         JLabel lblLigaBesibol = new JLabel("Liga Besibol");
         lblLigaBesibol.setFont(new Font("Verdana", Font.BOLD, 14));
         lblLigaBesibol.setBounds(122, 60, 103, 30);
         panel.add(lblLigaBesibol);
         
         lbPorcetanje = new JLabel("100%");
         lbPorcetanje.setBounds(312, 136, 36, 14);
         panel.add(lbPorcetanje);
         lbPorcetanje.setFont(new Font("Tahoma", Font.BOLD, 11));
         
         lbCargando = new JLabel("");
         lbCargando.setBounds(119, 197, 186, 14);
         getContentPane().add(lbCargando);
         
                 progressBar.setMaximum(100);
                 progressBar.setBounds(55, 180, 250, 15);
                 container.add(progressBar);
         loadProgressBar();
         setSize(370, 215);
         setLocationRelativeTo(null);
         setVisible(true);
     }
 
     private void loadProgressBar() {
    	 ActionListener al1 = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count2++;
			}  
    		 
    	 };
         ActionListener al = new ActionListener() {          
 
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 count++;
                 
                 ArrayList<String> dot = new ArrayList<String>();
                 for (int i = 0; i < 34; i++) {
                 	dot.add(".");
                 	dot.add("..");
                 	dot.add("...");
 				}
                 progressBar.setValue(count);
                 lbCargando.setText("Cargando imágenes"  + dot.get(count2));
                 lbPorcetanje.setText(count + "%");
                 if(count > 50){
                 	lbCargando.setText("Cargando datos"  + dot.get(count2));
                 }
                 if(count > 90){
                  	lbCargando.setText("Abriendo"  + dot.get(count2));
                  }
                 if (count == 100) {
 
                     createFrame();
 
                     execute.setVisible(false);//swapped this around with timer1.stop()
 
                     timer1.stop();
                 }
                 if(count2 == 100){
                	 time2.stop();
                 }
             }
 
             private void createFrame() throws HeadlessException {
             	SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
                 Principal frame = new Principal(liga);
                 frame.pack();
 				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
 				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
 				frame.setLocationRelativeTo(null);
 				frame.setVisible(true);
                 frame.setVisible(true);
             }
         };
         time2 = new Timer(60, al1);
         time2.start();
         timer1 = new Timer(60, al);
         timer1.start();
     }
 
     public static void main(String[] args) {
         execute = new SplashScreen();
     }
 }; 