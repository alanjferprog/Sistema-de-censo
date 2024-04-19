package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import Modelo.Grafo;
import Modelo.Mapa;
import Modelo.Negocio;
import Modelo.Mapa;

public class ControladorMapa extends MouseAdapter
{
	Negocio _negocio;
	
	public ControladorMapa(Negocio negocio)
	{
		_negocio = negocio;
	}
	
	//PIDE ANCHO Y ALTO DEL GRAFO Y LO CREA
	public void mouseClicked(MouseEvent e) 
	{
		
		try {
			int m = _negocio.getCantManzanasHoriz();
			int n = _negocio.getCantManzanasVert();
			
			Mapa mapa = new Mapa();
			
			mapa.inicializar(m * n, m);
			
			
			
			
		}catch (Exception ex) {
			}
		
		
		
		
	}
}
