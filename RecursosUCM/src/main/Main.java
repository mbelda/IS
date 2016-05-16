package main;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import model.material.Material;
import model.users.User;
import view.View;

public class Main {
	
	/*MEMENTO PARA LOGIN
	 * FACTORIA ABSTRACTA CON SINGLETON PARA DAOS*/
	
	private static List<User> users;
	private static List<Material> materials;
	
	private static void initUsers(){
		users = new ArrayList<User>();
		users.add(new User("Majo", "abc", true));
		users.add(new User("Alvaro", "def", false));
		users.add(new User("Luis", "ghi", true));
		users.add(new User("David", "jkl", false));
		users.add(new User("Juan", "mno", true));
		users.add(new User("Javi", "pqr", false));
	}
	
	private static void initMaterials() {
		materials = new ArrayList<Material>();
		materials.add(new Material("Computer1"));
		materials.add(new Material("Computer2"));
		materials.add(new Material("Computer3"));
		materials.add(new Material("Computer4"));
		materials.add(new Material("Computer5"));
		materials.add(new Material("Computer6"));
	}
	
	public static void main(String[] args) {
		initUsers();
		initMaterials();
		Controller controller = new Controller(users, materials);
		View vista = new View(controller);
	}
}
