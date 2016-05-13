package controlador;

import model.Alumno;
import model.Pair;
import model.Penalizacion;
import model.Usuario;
import vista.Vista;

public class Controlador {

	private Usuario usuarioIniciado;
	private Vista vista;
	private DAOUsers daoUsers;
	Usuario user;
	
	public void start() {
		vista = new Vista();
		vista.login();
	}
	
	public void login(String usuario, String pass) {
		
		Pair<Boolean, Usuario> resultado = datosCorrectos(usuario, pass);
		
		if(resultado.getFirst()){
			user = resultado.getSecond();
			vista.menu();
			/*TODO si tiene penalizaciones decirle hasta cuando con un jDialog*/
		}
		else{
			if(resultado.getSecond() == null){
				//Usuario no existe
			}
			else{
				//Pass incorrect
			}
			/*TODO mostrar error con un jDialog*/
			//vista.login();
		}
	}
	
	private Pair<Boolean, Usuario> datosCorrectos(String id, String pass) {
		if(daoUsers.existsUser(id)){
			Usuario user = daoUsers.getUser(id);
			if(pass.equals(user.getPass()))
				return new Pair<Boolean, Usuario>(true, daoUsers.getUser(id));
			else return new Pair<Boolean, Usuario>(false, daoUsers.getUser(id));
		}else{
			return new Pair<Boolean, Usuario>(false, null);
		}
	}

	public void penalizar(Alumno alumno, Penalizacion penalizacion) {
		usuarioIniciado.penalizar(alumno, penalizacion);
	}

	public Usuario getUsuario(String id) {
		// TODO Auto-generated method stub
		return daoUsers.existsUser(id) ? daoUsers.getUser(id) : null;
	}

}
