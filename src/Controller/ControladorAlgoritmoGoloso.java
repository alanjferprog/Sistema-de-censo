package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Modelo.AlgoritmoGoloso;
import Modelo.Censista;
import Modelo.Negocio;
import Vista.Marco;

public class ControladorAlgoritmoGoloso extends MouseAdapter
{
	AlgoritmoGoloso algGoloso;
	Marco _marco;
	Negocio _negocio;
	JLabel labelResult;
	JLabel labelFoto;
	
	
	public ControladorAlgoritmoGoloso(Marco marco, Negocio negocio)
	{
		_marco = marco;	
		_negocio = negocio;
		algGoloso = new AlgoritmoGoloso(negocio);
	}
	
	
	public void mouseClicked(MouseEvent e) 
	{
		algGoloso.AsignarManzanas();

		muestroInformacionEnPantalla();
		
	}


	private void muestroInformacionEnPantalla() {
		
		StringBuilder res= new StringBuilder();
		
		res.append("Solucion con algoritmo goloso:\n");
		
		for(Censista censista : _negocio.getCensistas()) {
			res.append(censista.mostrarInfo());
		}
			_marco.getInfo().setText(res.toString());
			
			apagadoYprendidoDeBotones();
	}


	private void apagadoYprendidoDeBotones() {
		_marco.getBotonDetalle().setVisible(true);
		_marco.getBotonMapa().setVisible(true);
		_marco.getLabelSeleccion().setVisible(false);
	}
}

	
		
	

