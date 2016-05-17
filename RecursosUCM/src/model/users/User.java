package model.users;

import java.util.ArrayList;
import java.util.List;

import model.material.Material;

public class User {

	/* TODO Aqui podriamos aplicar un proxy de proteccion para la contraseņa */
	private String id;
	private String password;
	protected boolean isAdmin;
	private List<Material> borrowedMaterials;
	private boolean isPenalizated;
	private static final int MAX_MATERIALS = 10;
	private int lastIndexLooked;

	public User(String id, String password, boolean isAdmin) {
		this.id = id;
		this.password = password;
		this.isAdmin = isAdmin;
		isPenalizated = false;
		this.borrowedMaterials = new ArrayList<Material>();
		this.lastIndexLooked = 0;
	}

	public List<Material> getBorrowedMaterials() {
		return borrowedMaterials; 
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

	public boolean isPenalizated() {
		return isPenalizated;
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

	@Deprecated
	/**
	 * DO NOT TOUCH
	 */
	public void setPenalizedDebugMode(boolean penalized) {
		this.isPenalizated = penalized;
	}

	@Deprecated
	/**
	 * DO NOT TOUCH
	 */
	public boolean hasAllMaterialsDebugMode() {
		return true;
	}
}
