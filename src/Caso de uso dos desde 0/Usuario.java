public abstract class Usuario {

	private String id;
	private boolean esAdmin;
	private Penalizacion penalizacion;

	public Usuario(String id, boolean esAdmin, Penalizacion penalizacion) {
		this.id = id;
		this.esAdmin = esAdmin;
		this.penalizacion = penalizacion;
	}

	public void penalizar(Usuario usuario, Penalizacion penalizacion) {
		if (esAdmin) {
			if (!usuario.esAdmin) {
				usuario.setPenalizacion(penalizacion);
			}
		}
	}

	public boolean getEsAdmin() {
		return this.esAdmin;
	}

	private void setPenalizacion(Penalizacion penalizacion) {
		this.penalizacion = penalizacion;
	}

	public String getId() {
		return this.id;
	}

}
