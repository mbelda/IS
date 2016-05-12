public class Controller {

	private Usuario usuarioIniciado;
	private BaseDatosUsuarios bbdd;

	public Controller(Usuario u, BaseDatosUsuarios bbdd) {
		usuarioIniciado = u;
		this.bbdd = bbdd;
	}

	public void loginUsuario() {
	}

	public void logOutUsuario() {
	}

	public void mostrarMenu() {
	}

	public void penalizar(Usuario usuario, Penalizacion penalizacion) {
		usuarioIniciado.penalizar(usuario, penalizacion);
	}

	public Usuario getUsuario(String id) {
		// TODO Auto-generated method stub
		return bbdd.getUsuario(id);
	}
}
