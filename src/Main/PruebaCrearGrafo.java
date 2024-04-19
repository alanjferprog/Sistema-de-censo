package Main;

import Modelo.Grafo;

public class PruebaCrearGrafo {
	
	public static void main(String[] args)
	{
		Grafo g = new Grafo(20);
		
		g.crearGrafoCenso(5, 4);
		
		//g.mostrarGrafo();
	}
}
