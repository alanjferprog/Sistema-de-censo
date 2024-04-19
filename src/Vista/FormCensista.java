
package Vista;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.ControladorDatosCensista;

import Modelo.Negocio;


import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FormCensista extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private File archivo = new File("/imagenes/fotoPerfil.jpg");
	private Marco _marco;
	private JTextField nombreInput;
	private JTextField apellidoInput;
	private JTextField edadInput;
	JLabel labelFoto = new JLabel("Foto");;
	private ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/fotoPerfil.jpg")); 
	
	public FormCensista(Marco marco) {
		_marco = marco;
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
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel titulo = new JLabel("Datos del censista");
		titulo.setBounds(44, 25, 239, 28);
		frame.getContentPane().add(titulo);
		
		//NOMBRE
		JLabel nombreLabel = new JLabel("Nombre");
		nombreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nombreLabel.setBounds(44, 59, 129, 35);
		frame.getContentPane().add(nombreLabel);
			
		nombreInput = new JTextField();
		nombreInput.setBounds(39, 88, 209, 35);
		frame.getContentPane().add(nombreInput);
		nombreInput.setColumns(10);
		
		//APELLIDO
		JLabel apellidoLabel = new JLabel("Apellido");
		apellidoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		apellidoLabel.setBounds(44, 135, 129, 35);
		frame.getContentPane().add(apellidoLabel);
		
		apellidoInput = new JTextField();
		apellidoInput.setColumns(10);
		apellidoInput.setBounds(39, 170, 209, 35);
		frame.getContentPane().add(apellidoInput);
		
		//EDAD
		JLabel edadLabel = new JLabel("Edad");
		edadLabel.setHorizontalAlignment(SwingConstants.LEFT);
		edadLabel.setBounds(44, 217, 129, 35);
		frame.getContentPane().add(edadLabel);
		
		edadInput = new JTextField();
		edadInput.setColumns(10);
		edadInput.setBounds(39, 254, 209, 35);
		frame.getContentPane().add(edadInput);
		
		//FOTO
		labelFoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelFoto.setBorder(BorderFactory.createLineBorder(Color.black));
		labelFoto.setBounds(317, 97, 130, 130);
		fotoInicial();
		frame.getContentPane().add(labelFoto);
	
		JButton botonFoto = new JButton("Agregar foto");   //ver carga de foto
		botonFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado;
				CargaFoto ventana = new CargaFoto();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("", "jpeg", "png", "jpg");
				ventana.getFotoChooser().setFileFilter(filter);
				resultado = ventana.getFotoChooser().showOpenDialog(frame);
				if (JFileChooser.APPROVE_OPTION == resultado) {
					archivo = ventana.getFotoChooser().getSelectedFile();
					 try{
			                ImageIcon icon = new ImageIcon(archivo.toString());
			                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
			                labelFoto.setIcon( icono );
			        } catch (Exception ex){
			                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
			        }
				}
				
			}
		});
		botonFoto.setBounds(327, 239, 117, 29);
		frame.getContentPane().add(botonFoto);
		
		//BOTON AGREGAR CENSISTAS
		JButton butonAgregar = new JButton("Agregar datos");
		butonAgregar.addMouseListener(new ControladorDatosCensista(this, _marco.getNegocio()));
		butonAgregar.setBounds(49, 310, 160, 35);
		frame.getContentPane().add(butonAgregar);
		
		//BOTON CARGAR ARCHIVO
		JButton cargarArchivo = new JButton("Cargar Archivo");
		cargarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado;
				CargaArchivo ventana = new CargaArchivo();
				ventana.getFileChooser();
				resultado = ventana.getFileChooser().showOpenDialog(frame);
				if (JFileChooser.APPROVE_OPTION == resultado) {
					archivo = ventana.getFileChooser().getSelectedFile();
					_marco.getNegocio().leerArchivo(archivo);
				}
				
				
			}
		});
		cargarArchivo.setBounds(286, 310, 150, 35);
		frame.getContentPane().add(cargarArchivo);
		
		//BOTON VOLVER
		JButton volverButton = new JButton("Volver");
		volverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				_marco.setVisible(true);
			}
		});
		volverButton.setBounds(180, 390, 160, 35);
		frame.getContentPane().add(volverButton);
		
		
	}

	public JTextField getNombreInput() {
		return nombreInput;
	}

	public JTextField getApellidoInput() {
		return apellidoInput;
	}

	public JTextField getEdadInput() {
		return edadInput;
	}
	
	public File getArchivo () {
		return archivo;
	}
	
	public JLabel getLabelFoto () {
		return labelFoto;
	}
	
	public void fotoInicial () {
		labelFoto.setIcon(img);
	}
	
	public ImageIcon getImg() {
		return img;
	}

	
}
		