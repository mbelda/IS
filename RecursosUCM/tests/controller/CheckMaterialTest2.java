package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.material.Material;
import model.users.User;

import org.junit.Before;
import org.junit.Test;

public class CheckMaterialTest2 {

	private static List<User> users;
	private static List<Material> materials;
	private static Controller controller;

	private static void initMaterial() {
		materials = new ArrayList<Material>();

		materials.add(new Material("Computer1"));
		materials.add(new Material("Computer2"));
		materials.add(new Material("Computer3"));
		materials.add(new Material("Computer4"));
		materials.add(new Material("Computer5"));
		materials.add(new Material("Computer6"));
		materials.add(new Material("Computer7"));
		materials.add(new Material("Computer8"));
	}

	/* default users in the system */
	private static void initUsers() {
		users = new ArrayList<User>();

		users.add(new User("Majo", "abc", true));
		users.add(new User("Alvaro", "def", false));
		users.add(new User("Luis", "ghi", true));
		users.add(new User("David", "jkl", false));
		users.add(new User("Juan", "mno", true));
		users.add(new User("Javi", "pqr", false));

		for (int i = 0; i < users.size(); i++) {
			if(i < users.size()-2){
				users.get(i).addBorrowedMaterial(materials.get(i));
			} else {
				users.get(i).addBorrowedMaterial(materials.get(i));
				users.get(i).addBorrowedMaterial(materials.get(i+2));
			}
		}
	}
/*
	@Before
	public void prepareData() {
		initMaterial();
		initUsers();

		controller = new Controller(users, materials, null, null);
	}
	@Test
	public void test() {
		for (int i = 0; i < users.size(); i++) {
			int test = controller.checkMaterial(users.get(i)).size();
			if(i < users.size()-2){
				assertEquals(test, 1);
			}
			else assertEquals(test, 2);
		}
	}*/

}
