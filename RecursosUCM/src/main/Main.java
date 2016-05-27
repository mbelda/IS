package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controller.ControllerImp;
import model.material.Classroom;
import model.material.Fecha;
import model.material.Laboratory;
import model.material.Material;
import model.users.User;
import view.View;

public class Main {
	
	private static List<User> users;
	private static List<Material> materials;
	private static List<Laboratory> labs;
	private static List<Classroom> classrooms;
	
	private static void initUsers(){
		users = new ArrayList<User>();
		users.add(new User("Majo", "abc", true));
		users.add(new User("Alvaro", "def", false));
		users.add(new User("Luis", "ghi", true));
		users.add(new User("David", "jkl", false));
		users.add(new User("Juan", "mno", true));
		users.add(new User("Javi", "pqr", false));
	}
	
	private static void iniMaterials() {
		materials = new ArrayList<Material>();
		materials.add(new Material("Computer1"));
		materials.add(new Material("Computer2"));
		materials.add(new Material("Computer3"));
		materials.add(new Material("Computer4"));
		materials.add(new Material("Computer5"));
		materials.add(new Material("Computer6"));
	}
	
	private static void iniLabs() {
		labs = new ArrayList<Laboratory> ();
		HashMap <Fecha, Boolean> a = inicializeMap();
		HashMap <Fecha, Boolean> b = inicializeMap();
		HashMap <Fecha, Boolean> c = inicializeMap();
		HashMap <Fecha, Boolean> d = inicializeMap();
		HashMap <Fecha, Boolean> e = inicializeMap();
		
		
		labs.add(new Laboratory("A", 25, a));
		labs.add(new Laboratory("B", 20, b));
		labs.add(new Laboratory("C", 25, c));
		labs.add(new Laboratory("D", 24, d));
		labs.add(new Laboratory("E", 23, e));
		
	}
	
	private static void iniClassrooms() {
		classrooms = new ArrayList<Classroom> ();
		HashMap <Fecha, Boolean> a = inicializeMap();
		HashMap <Fecha, Boolean> b = inicializeMap();
		HashMap <Fecha, Boolean> c = inicializeMap();
		HashMap <Fecha, Boolean> d = inicializeMap();
		HashMap <Fecha, Boolean> e = inicializeMap();
				
		classrooms.add(new Classroom("A", 25, a));
		classrooms.add(new Classroom("B", 20, b));
		classrooms.add(new Classroom("C", 25, c));
		classrooms.add(new Classroom("D", 24, d));
		classrooms.add(new Classroom("E", 23, e));
		
	}
	
	public static void main(String[] args) {
		initUsers();
		iniMaterials();
		iniLabs();
		iniClassrooms();
		
		ControllerImp controller = new ControllerImp(users, materials, labs, classrooms);
		new View(controller);
	}
	
	
	private static HashMap <Fecha, Boolean> inicializeMap() {
		HashMap <Fecha, Boolean> m = new HashMap<Fecha, Boolean>();
		for (int i = 1; i < 3; i++) {
			for (int j = 9; j < 18; j++) {
				m.put(new Fecha(2016, 6, i, j), false);
			}
		}
	
		return m;
	}
}
