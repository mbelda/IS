package controller;

import java.util.List;
import java.util.Scanner;

import data.DAOMaterial;
import data.users.DAOUsers;
import data.users.DAOUsersMemento;
import model.material.Material;
import model.users.User;

public class Controller {

	private DAOUsers daoUsers;
	private Scanner in;
	private DAOMaterial daoMaterial;
	
	public Controller(List<User> users, List<Material> materials) {
		this.daoUsers = new DAOUsers(users);
		this.daoMaterial = new DAOMaterial(materials);
		this.in = new Scanner(System.in);
	}

	public User login(String id, String password) {
		User user;
		DAOUsersMemento daoUsersMemento = null;
		if (daoUsers.exists(id)) {
			daoUsersMemento = daoUsers.requestMemento();
			daoUsers.restoreToMemento(daoUsersMemento);
			user = daoUsers.getUserOfLastIndexLooked();
			if (user.getPassword().equals(password)) {
				System.out.println("login correct");
				return user;
			} else {
				System.err.println("incorrect password");
				return null;
			}
		} else {
			System.err.println("username not found");
			return null;
		}
	}

	public void returnMaterial() {
		String id;
		System.out.println("Nombre del usuario: ");
		id = in.next();
		while(!daoUsers.exists(id)){
			System.err.println("username not found");
			System.out.println("Nombre del usuario: ");
			id = in.next();
		}
		DAOUsersMemento daoUsersMemento = daoUsers.requestMemento();
		daoUsers.restoreToMemento(daoUsersMemento);
		User user = daoUsers.getUserOfLastIndexLooked();
		//chequear si el usuario tiene elementos prestados
	}

	public void extractMaterial() {
		User user = getExistentUser();
		
		if(!user.isPenalizated() && !user.hasAllMaterials()){
			Material mat = getExistentMaterial();
			if(!mat.isBorrowed()){
				user.addBorrowedMaterial(mat);
				mat.setBorrowed(true);
				/*TODO memento del material*/
			} else {
				System.err.println(mat.getId() + " it's allready borrowed.");
			}
			
		} else {
			System.err.println(user.getId() + " has reached the maximum materials"
				+ " he can borrow.");
		}
	}
	
	/**
	 * Le pregunta al usuario un id de material hasta que le da uno existente
	 */
	private Material getExistentMaterial(){
		String idMat;
		System.out.println("Nombre del usuario: ");
		idMat = in.next();
		while(!daoMaterial.exists(idMat)){
			System.err.println("username not found");
			System.out.println("Nombre del usuario: ");
			idMat = in.next();
		}
		return daoMaterial.getMaterial(idMat);	
	}
	
	/**
	 * Le pregunta al usuario un id de usuario hasta que le da uno existente
	 */
	private User getExistentUser(){
		String idUsu;
		System.out.println("Nombre del usuario: ");
		idUsu = in.next();
		while(!daoUsers.exists(idUsu)){
			System.err.println("username not found");
			System.out.println("Nombre del usuario: ");
			idUsu = in.next();
		}
		return daoUsers.get(idUsu);
	}
}
