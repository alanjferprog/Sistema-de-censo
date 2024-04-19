
package Vista;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
import Controller.ControladorSiguienteCensista;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DetalleCensista extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Marco _marco;
	JLabel labelFoto = new JLabel("Foto");;
	private ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/fotoPerfil.jpg")); 
	private JTextArea detalle;
	private ControladorSiguienteCensista _controladorSiguienteCensista;
	
	public DetalleCensista(Marco marco) {
		_marco = marco;
		
		_controladorSiguienteCensista = new ControladorSiguienteCensista(_marco);
		initialize();
	}
	
	public void initialize()
	{
		
		frame = new JFrame();
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});
		frame.setVisible(true);
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		detalle = new JTextArea("");
		detalle.setOpaque(true);
		detalle.setBackground(Color.WHITE);
		detalle.setBounds(30, 27, 201, 91);
		frame.getContentPane().add(detalle);
		
		//---BOTON siguiente-------------------------
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.addMouseListener(_controladorSiguienteCensista);
		botonSiguiente.setBounds(73, 130, 117, 29);
		frame.getContentPane().add(botonSiguiente);
		
		labelFoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelFoto.setBorder(BorderFactory.createLineBorder(Color.black));
		labelFoto.setBounds(271, 17, 95, 101);
		fotoInicial();
		frame.getContentPane().add(labelFoto);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				_marco.setVisible(true);
			}
		});
		botonVolver.setBounds(217, 130, 117, 29);
		frame.getContentPane().add(botonVolver);
		
		JLabel titulo = new JLabel("Detalle de censistas asignados:");
		titulo.setBounds(30, 6, 201, 12);
		frame.getContentPane().add(titulo);

	}

	public void fotoInicial () {
		labelFoto.setIcon(img);
	}

	public JTextArea getDetalle() {
		return detalle;
	}

	public JLabel getLabelFoto() {
		return labelFoto;
	}
	
	
}
