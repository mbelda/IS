package model;

public abstract class Usuario {

	protected String id;
	protected boolean esAdmin;

	public Usuario(String id, boolean esAdmin) {
		this.id = id;
		this.esAdmin = esAdmin;
	}

	public abstract void penalizar(Alumno usuario, Penalizacion penalizacion);
	

	public boolean getEsAdmin() {
		return this.esAdmin;
	}

	public String getId() {
		return this.id;
	}

}
