package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import Modelo.Censista;
import Modelo.Negocio;
import Vista.FormCensista;

public class ControladorDatosCensista extends MouseAdapter
{
	private FormCensista _formCensista;
	
	Negocio _negocio;
	
	public ControladorDatosCensista(FormCensista formCensista, Negocio negocio)
	{
		_formCensista = formCensista;
		_negocio = negocio;
	}

	
	//PREGUNTA POR LOS CENSISTAS Y LOS GUARDA
	public void mouseClicked(MouseEvent e) {
		
		String nombre = _formCensista.getNombreInput().getText();
		String apellido = _formCensista.getApellidoInput().getText();
		String edadStr = _formCensista.getEdadInput().getText();
		int edad = Integer.parseInt(edadStr);
		
		//CHEQUEA LA INFORMACION RECIBIDA
		if(nombre.length() < 1 || apellido.length() < 1) 
			JOptionPane.showMessageDialog(null, "Ingrese la informacion correspondiente a cada campo");
		else 
		{	
			Censista nuevoCensista = new Censista(nombre, apellido, edad, _formCensista.getArchivo());
			
			_negocio.agregarCensista(nuevoCensista);
			
		}
		
		

		seteoDeCampos();

	}


	private void seteoDeCampos() {
		_formCensista.getNombreInput().setText("");
		_formCensista.getApellidoInput().setText("");
		_formCensista.getEdadInput().setText("");
		_formCensista.fotoInicial();
	}
}