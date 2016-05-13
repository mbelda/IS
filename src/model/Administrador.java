package model;

public class Administrador extends Usuario {

	public Administrador(String id) {
		super(id, true);
	}

	@Override
	public void penalizar(Alumno alumno, Penalizacion penalizacion) {
		alumno.setPenalizacion(penalizacion);
	}
}
