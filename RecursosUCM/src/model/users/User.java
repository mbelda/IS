package model.users;

import java.util.ArrayList;
import java.util.List;

import model.material.Material;
import model.penalization.Penalization;

public class User {

	/* TODO Aqui podriamos aplicar un proxy de proteccion para la contraseña */
	private String id;
	private String password;
	protected boolean isAdmin;
	private List<Material> borrowedMaterials;
	private static final int MAX_MATERIALS = 10;
	private int lastIndexLooked;
	private Penalization penalization;

	public User(String id, String password, boolean isAdmin) {
		this.id = id;
		this.password = password;
		this.isAdmin = isAdmin;
		penalization = null;
		this.borrowedMaterials = new ArrayList<Material>();
		this.lastIndexLooked = 0;
	}

	public boolean hasBorrowedMaterials() {
		return !borrowedMaterials.isEmpty();
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

	public void deleteLastIndexLookedBorrowedMaterial() {
		this.borrowedMaterials.remove(lastIndexLooked);
	}

	public void addBorrowedMaterial(Material mat) {
		borrowedMaterials.add(mat);
	}

	public boolean isPenalized() {
		return this.penalization != null;
	}

	public boolean hasMaterial(String idMaterial) {
		for (int i = 0; i < borrowedMaterials.size(); i++) {
			this.lastIndexLooked = i;
			if (borrowedMaterials.get(i).getId().equals(idMaterial))
				return true;
		}
		return false;
	}

	/**
	 * Devuelve si ha alcanzado el maximo de materiales disponibles Si es admin
	 * no tiene maximo
	 */
	public boolean hasAllMaterials() {
		if (this.isAdmin())
			return false;
		else
			return !(borrowedMaterials.size() < MAX_MATERIALS);
	}

	public void setPenalization(Penalization p) {
		this.penalization = p;
	}
}
