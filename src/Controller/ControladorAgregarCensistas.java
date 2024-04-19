package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Vista.FormCensista;
import Vista.Marco;

public class ControladorAgregarCensistas extends MouseAdapter
{
	private Marco _miMarco;
	private FormCensista _formCensista;
	
	public ControladorAgregarCensistas(Marco marco)
	{
		_miMarco = marco;
	}

	public void mouseClicked(MouseEvent e) 
	{	
		_formCensista = new FormCensista(_miMarco);
		_miMarco.setVisible(true);
		_formCensista.setVisible(true);	
	}

	
	
}
