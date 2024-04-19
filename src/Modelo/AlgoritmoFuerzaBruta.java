package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class AlgoritmoFuerzaBruta {
	
	Negocio _negocio;
	Grafo _grafo;
	Set <Integer> _actual;
	List<Set<Integer>> conjuntosManzanas;
	Set <Integer> manzanasAsignadas;
	List<Censista> _censistas;
	
	
	int _manzanasPorIteracion;
	boolean _solucionOptima = false;
	
	private static final int MANZANASMAXIMAS = 3;
	
	public AlgoritmoFuerzaBruta (Negocio negocio)
	{	
		_negocio = negocio;
		
		conjuntosManzanas = new ArrayList<Set<Integer>>();
		manzanasAsignadas = new HashSet<Integer>();
		
	}
	
	
	public void generarSubconjuntos() {
		
		_actual = new HashSet <Integer>();
		
		generarDesde(0);
	}
	
	
 	private void generarDesde (int vertice) {
 		
 		_grafo = _negocio.getGrafo();
 		
		if(vertice == _grafo.tamano()) {  
			
			if(_actual.size() >= 1)
				conjuntosManzanas.add(clonar(_actual));
			
		} else {
			
			_actual.add(vertice);
			generarDesde(vertice + 1);
			_actual.remove(vertice);
			generarDesde(vertice + 1);
		}
	}
 	
	
 	public void asignarManzanas() {
				
 		int cont=0;
 		
 		while (_solucionOptima == false)
 		{
			_censistas= _negocio.getCensistas();
			
			manzanasAsignadas = new HashSet<Integer>();
			
			_manzanasPorIteracion = 0;
			
			for ( Censista c : _censistas)
				c.borrarAsignacionDeManzanas();
			
			for (Censista censista : _censistas) {
				asignarManzanas(censista);
			}
			
			
			
			boolean todosTienen3Manzanas = true;
			if( _manzanasPorIteracion == _grafo.tamano())
			{
				if(_grafo.tamano() % 3 == 0)
				{
					
					for(Censista c : _censistas)
					{
						if(c.getManzanasAsignadas() != 0 && c.getManzanasAsignadas() != 3) todosTienen3Manzanas = false;
					}
				}
				else {
					
					int resto = _grafo.tamano() % 3;
					
					int otraMalaSolucion=0;
					for(Censista c : _censistas)
					{
						if(c.getManzanasAsignadas() != 0 && c.getManzanasAsignadas() != 3 && c.getManzanasAsignadas() != resto) todosTienen3Manzanas = false;
						if(c.getManzanasAsignadas() == resto) otraMalaSolucion++; 
					}
					if(otraMalaSolucion>1) todosTienen3Manzanas= false;
				}
			}
			else
				todosTienen3Manzanas= false;
			
			if(todosTienen3Manzanas) _solucionOptima = true;
			
			cont++;
			
			System.out.println(cont);
			
 		}
	}

	
	private void asignarManzanas (Censista censista) {
			
		List<Set<Integer>> listaManzanas = manzanasDisponibles();
		
		Collections.shuffle(listaManzanas);
		
		listaManzanas = ordenarColeccion(listaManzanas);
	
		boolean yaLeAsigneManzanas = false;
		
		for (Set<Integer> manzanas : listaManzanas) 
		{
			
			boolean siEstaLibreParaAsignar = true;
			
			for(Integer manzana : manzanas)
			{
				if (manzanasAsignadas.contains(manzana))
					siEstaLibreParaAsignar = false;		
			}
			
			if( siEstaLibreParaAsignar == true && yaLeAsigneManzanas == false && (manzanas.size() + censista.getManzanasAsignadas() <= 3))
			{
				for ( Integer manzana : manzanas)
				{
					censista.cargarManzana(manzana);
					manzanasAsignadas.add(manzana);
					_manzanasPorIteracion++;
				}
				
				yaLeAsigneManzanas = true;
				
				//Actualizo la lista de manzanas
				listaManzanas = manzanasDisponibles();	
				
				Collections.shuffle(listaManzanas);
				
				listaManzanas = ordenarColeccion(listaManzanas);
				
			}
		}
	}
	
	
	protected List<Set<Integer>> manzanasDisponibles() {    // elige subconj donde todas las manzanas están disponibles, son vecinas y tiene 3 elementos
		
		List<Set<Integer>> ret = new ArrayList<Set<Integer>>();
		
		for (Set<Integer> manzanas : conjuntosManzanas) {
			if (!estanAsignadas(manzanas) && sonVecinas(manzanas) && manzanas.size() <= MANZANASMAXIMAS) {
				ret.add(manzanas);
			}
		} 
		
		return ret;
	}
	
	
	protected boolean sonVecinas (Set <Integer> conjunto) 
	{
		if (conjunto.size() > 1)
		{
			for(Integer i: conjunto)
			{
				boolean ret = false;
				
				for(Integer j: conjunto)
				{
					if( i != j && _grafo.existeArista(i, j))
						ret = true;
				}
				
				if(ret == false) return false;
			}
		}
		return true;	
	}
		
	
	private boolean estanAsignadas (Set<Integer> manzanas) { 
		
		for (Integer manzana : manzanas) {
				if (estaAsignada(manzana))
						return true;
		}
		
		return false;
	}
	
	
	private boolean estaAsignada (int manzana) {
			return manzanasAsignadas.contains(manzana);
	}
	
	
	private List<Set<Integer>> ordenarColeccion(List<Set<Integer>> c)
	{
		int max= 3;
		
		ArrayList<Set<Integer>> ret = new ArrayList<Set<Integer>>();
		
		while(max != 0)
		{
			for (Set<Integer> m : c) 
			{
				if(m.size() == max)
					ret.add(m);
			}
			
			max--;
		}
		
		return ret;
	}
	
	
	private Set<Integer> clonar(Set<Integer> conjunto) {
		
		Set<Integer> ret= new HashSet<Integer>(conjunto);
		
		return ret;
	}
	
}
