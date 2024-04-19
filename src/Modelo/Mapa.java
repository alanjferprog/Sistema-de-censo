package Modelo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;



public class Mapa {

	private JFrame frame;
	private JPanel panelMapa;
	private JMapViewer mapa;
	private JButton volver;

	private int _totalManzanas;
	private int _manzanasHorizontales;
	private int _manzanaActual;
			
	public void inicializar(int totalManzanas, int manzanasHorizontales) 
	{
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Radio censal");
		
		
		panelMapa = new JPanel();
		panelMapa.setBounds(12, 12, 304, 200);
		frame.add(panelMapa);
		
		
		_totalManzanas = totalManzanas;
		_manzanasHorizontales = manzanasHorizontales;
		
		crearMapa();
		
		panelMapa.add(mapa);
		frame.setVisible(true);
		
		JButton botonVolver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		volver.setBounds(217, 130, 117, 29);
		frame.getContentPane().add(volver);
	}
	
	private void crearMapa() 
	{
		
		mapa= new JMapViewer();
		
		ArrayList<Coordinate> coordenadasParaPolygon = new ArrayList<Coordinate>();
		ArrayList<Coordinate> coordenadas = new ArrayList<Coordinate>();
		
		double sumacoor= 0.0009; //Diferencia de espacio entre manzanas para graficar
		int contadorHorizontal=0;
		
		//COORDENADAS INICIALES DE LAS MANZANAS
		double coorY= -34.5439;
		double coorX= -58.7070;
			
		_manzanaActual = 0;
		Coordinate ultimaCoordenada = null;
		
		coordenadasParaPolygon.add(new Coordinate(coorY, coorX));
		
		for(int cont =0; cont < _totalManzanas; cont++)
		{
			
			if(contadorHorizontal < _manzanasHorizontales)
			{
				
				if (_manzanaActual == _manzanasHorizontales -1)
					coordenadasParaPolygon.add(new Coordinate(coorY, coorX));
				
				if(_manzanaActual == _totalManzanas -1)
					coordenadasParaPolygon.add(new Coordinate(coorY, coorX));
				
				crearYAgregarCoordenada(coordenadas, coorY, coorX);
				
		
				contadorHorizontal++;
				coorX = coorX + sumacoor;
				coorY = coorY + sumacoor;
			}
			else 
			{
				//VUELVO ALA POS DE LA PRIMER MANZANA
				coorY= coorY - _manzanasHorizontales * sumacoor;
				coorX= coorX - _manzanasHorizontales * sumacoor;
				
				//AVANZO A LA MANZA DE ABAJO
				coorY = coorY - sumacoor;
				coorX = coorX + 0.0011;
				
				contadorHorizontal = 1;
				
				crearYAgregarCoordenada(coordenadas, coorY, coorX);
				
				//POLYGON CODE
				if( _manzanaActual == _totalManzanas - (_manzanasHorizontales -1))
					ultimaCoordenada = new Coordinate(coorY, coorX);
				
				//AVANZO A LA SIG MANZANA
				coorX = coorX + sumacoor;
				coorY = coorY + sumacoor;
			}
		}
		
		coordenadasParaPolygon.add(ultimaCoordenada);
		
		agregarCoordeandasAlMapa(coordenadas);
		
		asignarCoordenadaVistaEnMapa();
		
		crearPolygon(coordenadasParaPolygon);
	}

	private void crearPolygon(ArrayList<Coordinate> coordenadasParaPolygon) {
		MapPolygon poligon =  new MapPolygonImpl(coordenadasParaPolygon);
		mapa.addMapPolygon(poligon);
		
	}

	private void asignarCoordenadaVistaEnMapa() {
		Coordinate coordenada = new Coordinate(-34.5455, -58.7070);
		mapa.setDisplayPosition(coordenada, 14);
	}

	private void agregarCoordeandasAlMapa(ArrayList<Coordinate> coordenadas) {
		int cont= 0;
		for( Coordinate c : coordenadas)
		{
			MapMarker marker1 = new MapMarkerDot(""+cont++, c);
			marker1.getStyle().setBackColor(Color.blue);
			marker1.getStyle().setColor(Color.blue);
			mapa.addMapMarker(marker1);			
		}
	}


	private void crearYAgregarCoordenada(ArrayList<Coordinate> coordenadas, double coorX, double coorY) {
		Coordinate coordenada = new Coordinate(coorX, coorY);
		coordenadas.add(coordenada);
		
		_manzanaActual ++;
	}
	
	
	
	public JMapViewer dameMapa()
	{
		return mapa;
	}

}
