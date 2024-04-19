
package Vista;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;



public class CargaFoto extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JFileChooser fotoChooser;
	



	/**
	 * Create the application.
	 */
	public CargaFoto() {
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize()
	{
		
		frame = new JFrame();
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});
		frame.setVisible(false);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		fotoChooser = new JFileChooser();
		fotoChooser.setBounds(6, -11, 488, 421);
		frame.getContentPane().add(fotoChooser);
	}

	public JFileChooser getFotoChooser() {
		return fotoChooser;
	}
	
	
}