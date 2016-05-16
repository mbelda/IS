package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.material.Material;
import model.users.User;

public class LoginTest2 {
	private static List<User> users;
	private static List<Material> materials = null;
	private static List<User> fakeUsers;
	private static Controller controller;

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

		fakeUsers.add(new User("Majo", "dfsdfdsf", true));
		fakeUsers.add(new User("Alvaro", "nbvdsf", false));
		fakeUsers.add(new User("fgbvnvbfg", "abc", false));
		fakeUsers.add(new User("bnbndfgdfg", "ksdkfhkshf", true));
	}

	@Before
	public void prepareData() {
		initUsers();
		controller = new Controller(users, materials);
	}

	@Test
	public void test() {
		for (int i = 0; i < fakeUsers.size(); i++) {
			assertNull(controller.login(fakeUsers.get(i).getId(),
					fakeUsers.get(i).getPassword()));
		}
	}

}
