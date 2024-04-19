package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class Negocio {
	private Grafo _miGrafo;
	//Datos necesarios para al asignar manzanas
	private int _cantManzanasHoriz;
	private int _cantManzanasVert;
	
	private ArrayList<Censista> _misCensistas = new ArrayList<Censista>();
	
	
	public Negocio () 
	{
		_cantManzanasVert= 0;
		_cantManzanasHoriz= 0;
	}

	public void leerArchivo(File f)
	{
		FileReader entrada;
		
		try {
			entrada = new FileReader(f);
			BufferedReader mibuffer= new BufferedReader(entrada);
			String linea="";
			
			String[] informacion_De_Cada_Linea;
			linea= mibuffer.readLine();
			while ( linea != null)
			{
				informacion_De_Cada_Linea = linea.split(";");
				String nombre = null;
				String apellido = null;
				int edad = 0;
				int cont=0;
				for (String s : informacion_De_Cada_Linea)
				{
					if(cont==0) nombre =s;
					else if (cont==1) apellido = s;
					else edad = Integer.parseInt(s);
					cont++;
				}
				Censista c = new Censista(nombre, apellido, edad);
				agregarCensista(c);
				linea= mibuffer.readLine();
			}
			
			
			mibuffer.close();
			JOptionPane.showMessageDialog(null, "Censistas cargados correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private ArrayList<Censista> clonar(ArrayList<Censista> conjunto) {
		
		ArrayList<Censista> ret= new ArrayList<Censista>(conjunto);
		
		return ret;
	}
	
	
	//GETTERS AND SETTERS
	public void setCantManzanasHoriz(int m) {
		_cantManzanasHoriz = m;
	}

	
	public void setCantManzanasVert(int n) {
		_cantManzanasVert = n;
	}
	
	
	public int getCantManzanasHoriz() {
		return _cantManzanasHoriz;
	}

	
	public int getCantManzanasVert() {
		return _cantManzanasVert;
	}

	
	public void setGrafo(Grafo miGrafo) {
		_miGrafo = miGrafo;
	}
	
	
	public Grafo getGrafo() {
		return _miGrafo;
	}
	
	
	public void agregarCensista(Censista c)
	{
		_misCensistas.add(c);
	}
	
	
	public ArrayList<Censista> getCensistas()
	{
		 return clonar(_misCensistas);
	}
}
