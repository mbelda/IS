package model.users;

import java.util.ArrayList;
import java.util.List;

import model.material.Material;

public class User {

	/* TODO Aqui podriamos aplicar un proxy de proteccion para la contraseña */
	private String id;
	private String password;
	protected boolean isAdmin;
	private List<Material> borrowedMaterials;
	private boolean isPenalizated;
	private int MAX_MATERIALS = 10;
	
	public User(String id, String password, boolean isAdmin) {
		this.id = id;
		this.password = password;
		this.isAdmin = isAdmin;
		isPenalizated = false;
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
	
	public void addBorrowedMaterial(Material mat){
		borrowedMaterials.add(mat);
	}
	
	public boolean isPenalizated(){return isPenalizated;}
	
	/**
	 * Devuelve si ha alcanzado el maximo de materiales disponibles
	 * Si es admin no tiene maximo
	 * */
	public boolean hasAllMaterials(){
		if(this.isAdmin()) return false;
		else
			return ! (borrowedMaterials.size() < MAX_MATERIALS);
	}
}
