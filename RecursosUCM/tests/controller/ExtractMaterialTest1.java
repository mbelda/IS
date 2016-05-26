package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.DAOMaterial;
import data.users.DAOUsers;
import model.material.Material;
import model.users.User;

public class ExtractMaterialTest1 {

	private static List<User> users;
	private static List<Material> materials = null;
	private static List<User> fakeUsers;
	private static List<Material> fakeMaterial;
	private static ControllerImp controller;
	private static MaterialServicesImp materialServices;
	private static DAOUsers daoUsers;
	private static DAOMaterial daoMaterial;

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

		fakeMaterial.add(new Material("zomputer1"));

		fakeMaterial.add(new Material("zomputer2"));
		fakeMaterial.add(new Material("zomputer3"));

		daoMaterial = DAOMaterial.getDaoMaterial(materials);
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

		/* Buenos usuarios con buenos materiales */
		fakeUsers.add(new User("Majo", "abc", true));
		fakeUsers.add(new User("Alvaro", "def", false));

		/* mal usuario buen material */
		fakeUsers.add(new User("fgbvnvbfg", "abc", false));
		/* mal usuario mal material */
		fakeUsers.add(new User("bnbndfgdfg", "ksdkfhkshf", true));

		/* buen usuario mal material */
		fakeUsers.add(new User("Javi", "pqr", false));
		fakeUsers.add(new User("Juan", "mno", true));

		daoUsers = DAOUsers.getDaoUsers(users);
	}

	@Before
	public void prepareData() {
		initUsers();
		initMaterial();
		controller = new ControllerImp(users, materials, null, null);
		materialServices = new MaterialServicesImp(controller);
	}

	@Test
	public void test() {
		for (int i = 0; i < fakeMaterial.size(); i++) {
			@SuppressWarnings("deprecation")
			boolean test = materialServices.extractMaterialDebugMode1(
					fakeUsers.get(i), fakeMaterial.get(i), daoUsers,
					daoMaterial);
			if (i <= 1)
				assertTrue(test);
			else
				assertFalse(test);

		}
	}

}
