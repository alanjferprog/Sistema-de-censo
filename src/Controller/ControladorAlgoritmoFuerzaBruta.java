package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Modelo.AlgoritmoFuerzaBruta;
import Modelo.Censista;
import Vista.Marco;

public class ControladorAlgoritmoFuerzaBruta extends MouseAdapter{
	AlgoritmoFuerzaBruta _algFuerzaBruta;
	Marco _marco;
	
	public ControladorAlgoritmoFuerzaBruta(Marco marco)
	{
		_algFuerzaBruta = new AlgoritmoFuerzaBruta(marco.getNegocio());
		_marco = marco;
	}
	
	public void mouseClicked(MouseEvent e) 
	{
		
		_algFuerzaBruta.generarSubconjuntos();
		
		_algFuerzaBruta.asignarManzanas();
		
		muestroInformacionEnPantalla();
	}
	
	private void muestroInformacionEnPantalla() {
		
		StringBuilder res= new StringBuilder();
		
		res.append("Solucion con algoritmo de fuerza bruta:\n");
		
		for(Censista censista : _marco.getNegocio().getCensistas()) {
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
