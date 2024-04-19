package Modelo;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Modelo.AlgoritmoGoloso;
import Modelo.Censista;
import Modelo.Grafo;
import Modelo.Negocio;

public class AlgoritmoGolosoTest {
	Grafo grafo;
	static ArrayList<Censista> censistas = new ArrayList<Censista>();
	private File foto = new File("/imagenes/fotoPerfil.jpg");
	Negocio negocio = new Negocio();
	AlgoritmoGoloso goloso = new AlgoritmoGoloso(negocio);
	
	
	@Before
	public void inicializar() {
	Censista censista1 = new Censista ("Juan", "Perez", 20, foto);
	Censista censista2 = new Censista ("Jose", "Garcia", 30, foto);
	Censista censista3 = new Censista ("Maria", "Gonzalez", 40, foto);
	censistas.add(censista1);
	censistas.add(censista2);
	censistas.add(censista3);
	grafo = new Grafo(16);
	grafo.crearGrafoCenso(4, 4);
	}
	
	@Test
	public void asignarManzanasTest () {
		goloso.AsignarManzanas();
	}
	
}
