package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import Modelo.Grafo;
import Modelo.Mapa;
import Modelo.Negocio;
import Modelo.Mapa;

public class ControladorCrearRadio extends MouseAdapter
{
	Negocio _negocio;
	
	public ControladorCrearRadio(Negocio negocio)
	{
		_negocio = negocio;
	}
	
	//PIDE ANCHO Y ALTO DEL GRAFO Y LO CREA
	public void mouseClicked(MouseEvent e) 
	{
		
		try {
			
			int m = Integer.parseInt(JOptionPane.showInputDialog("De cuantas manzanas de ancho estamos hablando ?"));
			_negocio.setCantManzanasHoriz(m);
			
			int n = Integer.parseInt(JOptionPane.showInputDialog("De cuantas manzanas de alto estamos hablando ?"));
			_negocio.setCantManzanasVert(n);
			
			Grafo grafo= new Grafo(m * n);
			
			grafo.crearGrafoCenso(m, n);
			
			_negocio.setGrafo(grafo);
			
			
			
			
		}catch (Exception ex) {
			}
		
		
		
		
	}
}
