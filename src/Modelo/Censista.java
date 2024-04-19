package Modelo;

import java.io.File;
import java.util.ArrayList;


public class Censista {
	private  static Integer _id = 0;
	private String _identificacion;
	private String _nombre;
	private String _apellido;
	private int _edad;
	private ArrayList<Integer> _misManzanas;
	private File _imagen;
	

	public Censista(String nombre, String apellido, int edad, File imagen) 
	{
		_misManzanas = new ArrayList<Integer>();
		_nombre = nombre;
		_apellido = apellido;
		_edad = edad;
		_id++;
		_identificacion = _id.toString();
		_imagen = imagen;
	}
	
	public Censista(String nombre, String apellido, int edad) 
	{
		_misManzanas = new ArrayList<Integer>();
		_nombre = nombre;
		_apellido = apellido;
		_edad = edad;
		_id++;
		_identificacion = _id.toString();
	}
	
	public String toString()
	{
		return "Censista nº: " + _identificacion + "\nnombre: " + _nombre +  "\napellido: " + _apellido + "\nedad: " + _edad + "\nurl" + _imagen.getPath() + "\n";
	}
	
	public void cargarManzana(int m) 
	{
		_misManzanas.add(m);
	}
	
	public int getManzanasAsignadas() 
	{
		return _misManzanas.size();
	}


	public void printManzanas() {
		String m= "";
		for (Integer manzana : _misManzanas)
			m += manzana + " ";
		System.out.println ("Censista numero "+ _identificacion + ":\nmanzanas asignadas: [ " + m + "]");
	}
	
	public String mostrarInfo() {
		String m= "";
		for (Integer manzana : _misManzanas)
			m += manzana + " ";
		return "Censista numero "+ _identificacion + ":\nmanzanas asignadas: [ " + m + "]\n\n";
	}
	
	public String mostrarManzanas() {
		String m= "";
		for (Integer manzana : _misManzanas)
			m += manzana + " ";
		return "\n Censista numero "+ _identificacion + ":\n" + _nombre + " " + _apellido + "\nedad: " + _edad + ""
				+ "\nManzanas asignadas: [" + m + "]\n";
	}
	
	public File getImagen () {
		return _imagen;
	}

	public void borrarAsignacionDeManzanas() 
	{
		_misManzanas = new ArrayList<Integer>();
	}
	
//	private ArrayList<Integer> clonar(ArrayList<Integer> _misManzanas) 
//	{
//		
//		ArrayList<Integer> ret= new ArrayList<Integer>(_misManzanas);
//		
//		return ret;
//	}
//	
//	public ArrayList<Integer> getmisManzanas()
//	{
//		return clonar(_misManzanas);
//	}
	
	
}
