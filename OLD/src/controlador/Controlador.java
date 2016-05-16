package controlador;

public class Controlador {

	/*private Usuario usuarioIniciado;
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
		}
		else{
			if(resultado.getSecond() == null){
			}
			else{
			}
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
		return daoUsers.existsUser(id) ? daoUsers.getUser(id) : null;
	}*/

}
