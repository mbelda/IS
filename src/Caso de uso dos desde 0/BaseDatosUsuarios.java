import java.util.ArrayList;
import java.util.List;

public class BaseDatosUsuarios {

	private List<Usuario> listaUsuarios;

	public BaseDatosUsuarios() {
		listaUsuarios = new ArrayList<Usuario>();
	}

	public Usuario getUsuario(String id) {
		for (Usuario u : listaUsuarios) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}
}
