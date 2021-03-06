package controller;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.DAOMaterial;
import data.users.DAOUsers;
import model.material.Material;
import model.users.User;

public class ExtractMaterialTest4 {

	private static List<User> users;
	private static List<Material> materials = null;
	private static List<User> fakeUsers;
	private static List<Material> fakeMaterial;
	private static ControllerImp controller;
	private static MaterialServicesImp materialServices;

	private static void initMaterial() {
		materials = new ArrayList<Material>();
		fakeMaterial = new ArrayList<Material>();

		materials.add(new Material("Computer1"));
		materials.add(new Material("Computer2"));
		materials.add(new Material("Computer3"));
		materials.add(new Material("Computer4"));
		materials.add(new Material("Computer5"));
		materials.add(new Material("Computer6"));

		fakeMaterial.add(new Material("Computer1"));
		fakeMaterial.add(new Material("Computer2"));
		fakeMaterial.add(new Material("Computer3"));
		fakeMaterial.add(new Material("Computer4"));
	}

	/* default users in the system */
	private static void initUsers() {
		users = new ArrayList<User>();
		fakeUsers = new ArrayList<User>();

		users.add(new User("Majo", "abc", true));
		users.add(new User("Alvaro", "def", false));
		users.add(new User("Luis", "ghi", true));
		users.add(new User("David", "jkl", false));
		users.add(new User("Juan", "mno", true));
		users.add(new User("Javi", "pqr", false));

		fakeUsers.add(new User("Majo", "abc", true));
		fakeUsers.add(new User("Alvaro", "def", false));
		fakeUsers.add(new User("Javi", "pqr", false));
		fakeUsers.add(new User("Juan", "mno", true));
	}

	@Before
	public void prepareData() {
		initUsers();
		initMaterial();
		controller = new ControllerImp(users, materials, null, null);
		materialServices = new MaterialServicesImp(controller);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		for (int i = 0; i < fakeMaterial.size(); i++) {
			fakeMaterial.get(i).setBorrowed(true);
			boolean test = materialServices.extractMaterialDebugMode1(
					fakeUsers.get(i), fakeMaterial.get(i),
					DAOUsers.getDaoUsers(users),
					DAOMaterial.getDaoMaterial(materials));
			assertFalse(test);

		}
	}

}