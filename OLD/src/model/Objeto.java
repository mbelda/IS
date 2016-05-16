package model;

/**
 * Esta clase será la clase originadora del patrón memento.
 */
public class Objeto {

	/* Este atributo representará el estado que el memento guardará. */
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
