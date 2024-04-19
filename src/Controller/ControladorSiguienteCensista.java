package Controller;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Modelo.Censista;
import Modelo.Negocio;
import Vista.DetalleCensista;
import Vista.FormCensista;
import Vista.Marco;

public class ControladorSiguienteCensista extends MouseAdapter{

	private static int cont = 0;
	private DetalleCensista detalle;
	private Marco _marco;
	private ArrayList <Censista> _censistas; 
	
	public ControladorSiguienteCensista(Marco marco)
	{
		_marco = marco;
		
		_censistas = null;	
	}

	
	//PREGUNTA POR LOS CENSISTAS Y LOS GUARDA
	public void mouseClicked(MouseEvent e) {
						
		_censistas = _marco.getNegocio().getCensistas();
		
		cont++;
		if(cont < _censistas.size()) {
			detalle = new DetalleCensista(_marco);
			detalle.getDetalle().setText(_censistas.get(cont).mostrarManzanas());
			JLabel labelFoto = detalle.getLabelFoto();
			if(_censistas.get(0).getImagen() != null) 
			{
				ImageIcon icon = new ImageIcon(_censistas.get(0).getImagen().toString());
		        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
		        labelFoto.setIcon(icono);
			}
		}
	}


	public static void setCont(int cont) {
		ControladorSiguienteCensista.cont = cont;
	}
	
}