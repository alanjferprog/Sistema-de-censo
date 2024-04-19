package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class VentanaInicio extends JFrame
{
	private JPanel _panel;
	private JButton _iniciar = new JButton("INICIAR");
	private ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg")); 
	
	public VentanaInicio() {
		_panel = new JPanel();
		this.setSize(410,410);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("PROGRAMACION 3 - TP del censo"); 
		this.setLocationRelativeTo(null); 
		this.setResizable(false); 
		iniciarComponente();
	
	}
	
	private void iniciarComponente() 
	{
		this.getContentPane().add(_panel); // agregamos el panel a la ventana
		_panel.setLayout(null);
		colocarBotones();
	}
	
	private void colocarBotones() 
	{
		//boton iniciar
		_iniciar.setBounds(128,276,170,40);
		_iniciar.setFont(new Font("arial",Font.BOLD,12));
		_iniciar.setBackground(Color.WHITE);
		_iniciar.addActionListener(accion);
		_panel.add(_iniciar);
		
		//imagen fondo
		JLabel labelFondo = new JLabel("");
		labelFondo.setBounds(5, -86, 500, 560);
		labelFondo.setIcon(img);
		labelFondo.setLayout( new BorderLayout() );
		_panel.add(labelFondo);
	}
	
	
	ActionListener accion= new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
				Marco m = new Marco();
				setVisible(false);
				
			}
		};
}
