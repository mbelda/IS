package controlador;

import model.Alumno;
import model.Penalizacion;
import model.Usuario;
import vista.Vista;

public class Controlador {

	private Usuario usuarioIniciado;
	private DAOUsers daoUsuarios;
	private Vista vista;

	public void start() {
		vista = new Vista();
		vista.login();
		/**/
	}

	public void penalizar(Alumno alumno, Penalizacion penalizacion) {
		usuarioIniciado.penalizar(alumno, penalizacion);
	}

	public Usuario getUsuario(String id) {
		// TODO Auto-generated method stub
		return daoUsuarios.exists(id) ? daoUsuarios.getUsuario(id) : null;
	}

}
