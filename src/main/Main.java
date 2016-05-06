package main;

import controlador.Controlador;

public class Main {

	public static void main(String[] args) {
		start();
	}
	
	private static void start(){
		Controlador c = new Controlador();
		c.start();
	}
	
}
