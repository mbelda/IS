package controlador;

import vista.Vista;

public class Controlador {

	private Vista vista;
	
	public void start() {
		vista = new Vista();
		vista.login();
	}

}
