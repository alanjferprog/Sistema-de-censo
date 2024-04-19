package Modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AlgoritmoFuerzaBrutaTest {
	Grafo _grafo;
	AlgoritmoFuerzaBruta _alg;
	Negocio _negocio;
	
	
	
	@Test
	public void manzanasVecinasTest() 
	{
		AlgoritmoFuerzaBruta tst = inicializarParaManzanasVecinas();
		
		tst.generarSubconjuntos();
		
		Set<Integer> conjunto = crearConjuntoVecino();
		
		assertTrue(tst.sonVecinas(conjunto));
	}
	
	
	@Test
	public void manzanasNOVecinasTest() 
	{
		AlgoritmoFuerzaBruta tst = inicializarParaManzanasVecinas();
		
		tst.generarSubconjuntos();
		
		Set<Integer> conjunto2 = crearConjuntoNoVecino();
	
		assertFalse(tst.sonVecinas(conjunto2));
	}
	
	
	@Test
	public void manzanasDisponiblesTest() 
	{
		AlgoritmoFuerzaBruta alg = inicializarParaManzanasDisponibles();
		
		alg.generarSubconjuntos();
		
		List<Set<Integer>> obtenidos = alg.manzanasDisponibles();
		
		List<Set<Integer>> esperados = generarEsperados();
		
		iguales(esperados, obtenidos);
	}

	
	@Test
	public void asignarManzanasTest() 
	{
		List<Censista> censistas = inicializarAsignarManzanas();
		
		assertEquals(censistas.get(0).getManzanasAsignadas(), 3);
		assertEquals(censistas.get(1).getManzanasAsignadas(), 1);
	}
	
	
	private AlgoritmoFuerzaBruta inicializarParaManzanasVecinas() 
	{
		Negocio n = new Negocio();
		Grafo g = new Grafo(9);
		g.crearGrafoCenso(3, 3);
		n.setGrafo(g);
		AlgoritmoFuerzaBruta tst = new AlgoritmoFuerzaBruta(n);
		return tst;
	}
	
	
	private AlgoritmoFuerzaBruta inicializarParaManzanasDisponibles()
	{
		Negocio n = new Negocio();
		Grafo g = new Grafo(4);
		g.crearGrafoCenso(2, 2);
		n.setGrafo(g);
		AlgoritmoFuerzaBruta alg = new AlgoritmoFuerzaBruta(n);
		return alg;
	}


	private List<Censista> inicializarAsignarManzanas() 
	{
		Negocio n = new Negocio();
		Grafo g = new Grafo(4);
		g.crearGrafoCenso(2, 2);
		n.setGrafo(g);
		AlgoritmoFuerzaBruta alg = new AlgoritmoFuerzaBruta(n);
		n.agregarCensista(new Censista("a", "f", 25));
		n.agregarCensista(new Censista("c", "m", 22));
		alg.generarSubconjuntos();
		alg.asignarManzanas();
		List<Censista> censistas = n.getCensistas();
		return censistas;
	}
	
	
	public static void iguales(List<Set<Integer>> esperados, List<Set<Integer>> obtenidos) 
	{
		assertEquals(esperados.size(), obtenidos.size());
		for(Set<Integer> conj: esperados)
				assertTrue(obtenidos.contains(conj));
			
	}
	
	
	private Set<Integer> crearConjuntoNoVecino() {
		Set <Integer> conjunto = new HashSet<Integer>();
		conjunto.add(2);
		conjunto.add(3);
		conjunto.add(6);
		
		return conjunto;
	}
	

	private Set<Integer> crearConjuntoVecino() {
		Set <Integer> conjunto = new HashSet<Integer>();
		conjunto.add(5);
		conjunto.add(8);
		conjunto.add(7);
		return conjunto;
	}
	
	
	private List<Set<Integer>> generarEsperados() 
	{
		List<Set<Integer>> esperados = new ArrayList<Set<Integer>>();
		
		Set<Integer> c1= new HashSet<Integer>();
		c1.add(0);
		c1.add(1);
		c1.add(2);
		Set<Integer> c2= new HashSet<Integer>();
		c2.add(3);
		c2.add(1);
		c2.add(2);
		Set<Integer> c3= new HashSet<Integer>();
		c3.add(0);
		c3.add(1);
		c3.add(3);
		Set<Integer> c4= new HashSet<Integer>();
		c4.add(3);
		c4.add(0);
		c4.add(2);
		Set<Integer> c5= new HashSet<Integer>();
		c5.add(0);
		c5.add(1);
		Set<Integer> c6= new HashSet<Integer>();
		c6.add(3);
		c6.add(2);
		Set<Integer> c7= new HashSet<Integer>();
		c7.add(0);
		c7.add(2);
		Set<Integer> c8= new HashSet<Integer>();
		c8.add(3);
		c8.add(1);
		Set<Integer> c9= new HashSet<Integer>();
		c9.add(0);
		Set<Integer> c10= new HashSet<Integer>();
		c10.add(1);
		Set<Integer> c11= new HashSet<Integer>();
		c11.add(2);
		Set<Integer> c12= new HashSet<Integer>();
		c12.add(3);
		
		esperados.add(c1);
		esperados.add(c2);
		esperados.add(c3);
		esperados.add(c4);
		esperados.add(c5);
		esperados.add(c6);
		esperados.add(c7);
		esperados.add(c8);
		esperados.add(c9);
		esperados.add(c10);
		esperados.add(c11);
		esperados.add(c12);
		
		return esperados;
	}
}
