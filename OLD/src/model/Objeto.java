package model;

/**
 * Esta clase ser� la clase originadora del patr�n memento.
 */
public class Objeto {

	/* Este atributo representar� el estado que el memento guardar�. */
	private String ultimoPrestado;
	
	
	
	private String id;
	private Fecha fechaDevolucion;
	private boolean prestado;

	public String getId() {
		return this.id;
	}

	public void setPrestado(boolean p) {
		this.prestado = p;
	}
	
	/*
	public ObjetoMemento createObjetoMemento(){
		
	}*/
}
