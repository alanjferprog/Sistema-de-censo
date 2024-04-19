package Modelo;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class AlgoritmoGoloso {
	
	Negocio _negocio;
	Grafo _grafo;

	JMapViewer _mapa;

	private int _bajeEnElGrafico;
	private boolean _termineDeAsignarManzanas = false;
	private final int MANZANASMAXIMAS = 3;
	ArrayList<Censista> _censistas;

	
	public AlgoritmoGoloso (Negocio negocio) 
	{
		_negocio = negocio;
		
	}
	
	public void AsignarManzanas() 
	{
		_censistas =  _negocio.getCensistas();
		
		for ( Censista c : _censistas)
			c.borrarAsignacionDeManzanas();
		
		_grafo = _negocio.getGrafo();
		
		int manzanaActual = 0;
		int ancho = _negocio.getCantManzanasHoriz();
		_bajeEnElGrafico = 1; //ME PERMITE MOVERME IZQ-DER DER-IZQ
	
		for (Censista censista : _censistas)
		{	
			while (censista.getManzanasAsignadas() < MANZANASMAXIMAS && !_termineDeAsignarManzanas)
			{
				asignarManzanas(censista, manzanaActual); 
				if(!_termineDeAsignarManzanas)
				{
					if( censista.getManzanasAsignadas() < MANZANASMAXIMAS)
					{
						if (_grafo.existeArista(manzanaActual, manzanaActual + _bajeEnElGrafico))
						{
							manzanaActual += _bajeEnElGrafico;
						}
						else //LLEGUE AL LIMITE HORIZONTALMENTE
						{
							manzanaActual+= ancho;
							switchIzqDer(_bajeEnElGrafico);	
						}
					}
					else
					{
						if (_grafo.existeArista(manzanaActual, manzanaActual + _bajeEnElGrafico))
						{
							manzanaActual += _bajeEnElGrafico;
						}
						else 
						{
							manzanaActual+= ancho;
							switchIzqDer(_bajeEnElGrafico);
						}
					}
				}
			}
		}
}

private void asignarManzanas(Censista censista, int laManzana) {
	
	if (laManzana >= _grafo.tamano())
		_termineDeAsignarManzanas = true;
	else
		censista.cargarManzana(laManzana);
}

//CUANDO ASIGNO MANZANAS HACIA ABAJO EL SENTIDO CAMBIA HORIZONTALMENTE
private void switchIzqDer(int n)
{
	if ( n == 1)
		_bajeEnElGrafico = -1;
	else
		_bajeEnElGrafico = 1;
}
	
	

}
