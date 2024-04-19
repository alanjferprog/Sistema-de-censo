package Modelo;

import java.util.ArrayList;
import java.util.HashSet;

public class Grafo {
	
	private ArrayList <HashSet<Integer>> _vertices;
	private int _numeroDeAristas;
	
//==============================================================================	
	public Grafo(int n)
	{
		_vertices = new ArrayList <HashSet< Integer >>();
		
		for (int i=0; i<n; ++i) {
			_vertices.add(new HashSet <Integer>());
		}
	}
//==============================================================================
	
	public void agregarArista (int i, int j) 
	{			
		if (i != j) 
		{
			_vertices.get(i).add(j);
			_vertices.get(j).add(i);
			_numeroDeAristas++;
		}
	}
	
	public void removerArista (int i, int j) {
		if (i != j) 
		{
			_vertices.get(i).remove(j);
			_vertices.get(j).remove(i);
			_numeroDeAristas--;
		}
	}
	
	public int tamano() {
		return _vertices.size();
	}
	
	
	public boolean existeArista(int i, int j)
	{  
		return _vertices.get(i).contains(j);
	}
	
	
	public int dameCantidadAristas()
	{
		return _numeroDeAristas;
	}
	
	
	public void crearGrafoCenso(int m, int n) {
		// Grafo 5 x 4  m=5, n=4
					// (0) o - (1)  o - (2) o - (3) o - (4) o 
					//     |        |       |		|		|
					// (5) o - (6)  o - (7) o - (8) o - (9) o
					//     |        |       |		|		|
					// (10)o - (11) o - (12)o - (13)o - (14)o
					//     |        |       |		|		|
					// (15)o - (16)o  - (17)o - (18)o - (19)o
		
		int cont = 0;
		
		for (int i = 0; i< this.tamano(); i++)
		{
			//Primero hay que revisar que no sea un vertice de la ultima linea.
			//En este ejemplo los vertices menores a 15
			if( i < this.tamano()- m)
			{
				//Conecto el vertice con el de abajo del mismo.
				//Por ej el vertice 0 conecta con 5. Esta conexion siempre se da diferencia M
				agregarArista(i, (i + m) );
			}
			
			//Voy creando aristas de izq a derecha. Las conexiones se dan m-1. (en grafo de 0 a 4)
			cont ++;
			
			if (cont <= m-1)
			{
				agregarArista(i, (i + 1) );
			}
			else
			{
				cont = 0; 
			}
		}
		
	}
	
	public void printGrafo () 
	{
		for (int i = 0; i< this.tamano(); i++) {
			if (existeArista(i, i + 1)) {
				System.out.print(i + "---");
			} else {
				System.out.println(i + "");
			}
			
		}
	}

	
	public static void main(String[] args) 
	{
		Grafo grafoPrueba = new Grafo(12);
		grafoPrueba.crearGrafoCenso(4, 3);
		grafoPrueba.printGrafo();
		}

}
