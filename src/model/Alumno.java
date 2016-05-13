package model;

public class Alumno extends Usuario {

	private Penalizacion penalizacion;

	public Alumno(String id) {
		super(id, false);
		this.penalizacion = null;
	}

	@Override
	public void penalizar(Alumno usuario, Penalizacion penalizacion) {
	}

	public void setPenalizacion(Penalizacion penalizacion) {
		this.penalizacion = penalizacion;
	}

	public Fecha getEndPenalizacion() {
		return this.penalizacion.getFin();
	}
}
