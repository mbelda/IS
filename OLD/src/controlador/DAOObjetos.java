package controlador;

import java.util.List;

import model.Objeto;

public class DAOObjetos {
	private List<Objeto> objetos;

	public boolean existe(String id) {
		for (int i = 0; i < this.objetos.size(); i++) {
			if (id.equals(this.objetos.get(i).getId()))
				return true;
		}
		return false;
	}

	public void setPrestado(String id) {
		for(int i = 0; i < this.objetos.size(); i++) {
			if (id.equals(this.objetos.get(i).getId()))
				this.objetos.get(i).setPrestado(false);
		}
	}
}
