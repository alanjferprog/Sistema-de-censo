package Vista;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

import Controller.ControladorAgregarCensistas;
import Controller.ControladorAlgoritmoFuerzaBruta;
import Controller.ControladorAlgoritmoGoloso;
import Controller.ControladorCrearRadio;
import Controller.ControladorDetalleCensistas;
import Controller.ControladorMapa;
//import Controller.ControladorAlgoritmoFuerzaBruta;
import Modelo.Negocio;

@SuppressWarnings("serial")
public class Marco extends JFrame{

	private JFrame frame;
	private JButton agregarCensistas;
	private JButton configurarRadio;
	private JTextArea info;
	private Negocio _negocio;

	private JLabel labelSeleccion;
	private JButton botonMapa;
	private JButton botonFuerzaBruta;
	private JButton botonDetalle;



	/**
	 * Create the application.
	 */
	public Marco() 
	{	
		_negocio = new Negocio(); 
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
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//BOTON AGREGAR CENSISTAS
		agregarCensistas = new JButton("Agregar censistas");
		agregarCensistas.setBounds(52, 20, 160, 35);
		agregarCensistas.addMouseListener(new ControladorAgregarCensistas(this) );
		frame.getContentPane().add(agregarCensistas);
		
		//BOTON DETALLE
		botonDetalle = new JButton("Ver Detalle");
		botonDetalle.setBounds(38, 422, 200, 35);
		botonDetalle.addMouseListener(new ControladorDetalleCensistas(this));
		frame.getContentPane().add(botonDetalle);
		botonDetalle.setVisible(false);
		
		
		//BOTON CONFIGURAR RADIO
		configurarRadio = new JButton("Configurar radio censal");
		configurarRadio.setBounds(243, 20, 200, 35);
		configurarRadio.addMouseListener(new ControladorCrearRadio(_negocio) );
		frame.getContentPane().add(configurarRadio);

		
		labelSeleccion = new JLabel("Seleccione el algoritmo para obtener la solucion");
		labelSeleccion.setBounds(104, 359, 313, 16);
		frame.getContentPane().add(labelSeleccion);
		
		//BOTON ALG GOLOSO
		JButton asignarCensistas = new JButton("Algoritmo goloso");
		asignarCensistas.setBounds(38, 387, 200, 35);
		asignarCensistas.addMouseListener(new ControladorAlgoritmoGoloso(this, _negocio));
		frame.getContentPane().add(asignarCensistas);	
		
		//BOTON FUERZA BRUTA
		JButton botonFuerzaBruta = new JButton("Fuerza Bruta");
		botonFuerzaBruta.setBounds(274, 387, 193, 35);
		botonFuerzaBruta.addMouseListener(new ControladorAlgoritmoFuerzaBruta(this));
		frame.getContentPane().add(botonFuerzaBruta);
		
		//BOTON MAPA
		botonMapa = new JButton("Ver Mapa");
		botonMapa.setBounds(274, 422, 193, 35);
		botonMapa.addMouseListener(new ControladorMapa(_negocio));
		frame.getContentPane().add(botonMapa);
		botonMapa.setVisible(false);
		
		info= new JTextArea();
		info.setLineWrap(true);
		info.setEditable(false);
		info.setBackground(Color.WHITE);
		info.setBounds(38, 61, 430, 292);
		
		ScrollPane infoScroll= new ScrollPane();
		infoScroll.add(info);
		infoScroll.setBackground(Color.WHITE);
		infoScroll.setBounds(38, 61, 430, 292);
		frame.getContentPane().add(infoScroll);
		

	}
			

	public JButton getAgregarCensistas() {
		return agregarCensistas;
	}

	public JButton getConfigurarRadio() {
		return configurarRadio;
	}

	public JButton getAsignarCensistas() {
		return agregarCensistas;
	}

	public JTextArea getInfo() {
		return info;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JButton getBotonDetalle() {
		return botonDetalle;
	}

	public JButton getBotonMapa() {
		return botonMapa;
	}
	public JButton getBotonFuerzaBruta() {
		return botonFuerzaBruta;
	}

	public JLabel getLabelSeleccion() {
		return labelSeleccion;
	}
	
	public Negocio getNegocio() {
		return _negocio;
	}
	
	
}
