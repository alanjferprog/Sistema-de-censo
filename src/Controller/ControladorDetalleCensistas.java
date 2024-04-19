package Controller;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Modelo.Censista;
import Vista.DetalleCensista;
import Vista.Marco;

public class ControladorDetalleCensistas extends MouseAdapter
{
	private DetalleCensista detalle;
	private Marco _marco;
	private ArrayList<Censista> _censistas;
	
	public ControladorDetalleCensistas(Marco marco)
	{
		_marco = marco;
		_censistas = null;
	}

	

	public void mouseClicked(MouseEvent e) {
		
		_censistas = _marco.getNegocio().getCensistas();
		if(_censistas.size() > 0) {
			ControladorSiguienteCensista.setCont(0);
			detalle = new DetalleCensista(_marco);
			detalle.getDetalle().setText(_censistas.get(0).mostrarManzanas());
			JLabel labelFoto = detalle.getLabelFoto();
			if(_censistas.get(0).getImagen() != null) 
			{
				ImageIcon icon = new ImageIcon(_censistas.get(0).getImagen().toString());
		        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
		        labelFoto.setIcon(icono);
			}
			
		}
	}
}