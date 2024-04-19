package Vista;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class CargaArchivo extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JFileChooser fileChooser;
	



	/**
	 * Create the application.
	 */
	public CargaArchivo() {
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
		
		fileChooser = new JFileChooser();
		fileChooser.setBounds(6, -11, 488, 421);
		frame.getContentPane().add(fileChooser);
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}
	
	
}
