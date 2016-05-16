package model.users;

import java.util.ArrayList;
import java.util.List;

import model.material.Material;

public class User {

	/* Aqui podriamos aplicar un proxy de proteccion para la contraseña */
	private String id;
	private String password;
	protected boolean isAdmin;
	private List<Material> borrowedMaterials;

	public User(String id, String password, boolean isAdmin) {
		this.id = id;
		this.password = password;
		this.isAdmin = isAdmin;
		/*
		 * En un mundo real habría que acceder a una base de datos para poder
		 * hacer esto.
		 */
		this.borrowedMaterials = new ArrayList<Material>();
	}

	public String getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}
}
