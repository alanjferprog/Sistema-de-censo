package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Grafo;


public class GrafoTest {
	Grafo grafo = new Grafo(12);
	
	@Test
	public void cantAristasTest() {
		grafo.crearGrafoCenso(4, 3);
		assertEquals(17, grafo.dameCantidadAristas());
	}
	@Test
	public void agregarAristaTest() {
		grafo.agregarArista(2, 5);
		assertTrue(grafo.existeArista(2, 5));
		grafo.removerArista(2, 5);
	}
	@Test
	public void tamanoTest() {
		int tamano = grafo.tamano();
		assertEquals(tamano, 12);
	}
	@Test
	public void aristaInexistenteTest() {
		assertFalse(grafo.existeArista(3, 4));
	}
	@Test
	public void aristaExistenteHorizontal() {
		assertTrue(grafo.existeArista(0, 1));
	}
	@Test
	public void aristaExistenteVertical() {
		assertTrue(grafo.existeArista(0, 4));
	}
	

	

}
