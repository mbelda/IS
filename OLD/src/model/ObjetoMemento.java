package model;

public class ObjetoMemento {
	/*
	 * Ver si merece la pena cambiar los modificadores de acceso para
	 * implementar la interfaz estrecha y la interfaz ancha del memento.
	 */

	private String state;

	public ObjetoMemento(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}
}
