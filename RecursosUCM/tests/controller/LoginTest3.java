package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.material.Material;
import model.users.User;

public class LoginTest3 {
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

		fakeUsers.add(new User("Majo", "abc", true));
		fakeUsers.add(new User("Alvaro", "def", false));
		fakeUsers.add(new User("Luis", "ghi", true));
		fakeUsers.add(new User("David", "jkl", false));
		fakeUsers.add(new User("Juan", "mno", true));
		fakeUsers.add(new User("Javi", "pqr", false));
	}

	@Before
	public void prepareData() {
		initUsers();
		controller = new Controller(users, materials, null, null);
	}

	@Test
	public void test() {
		for (int i = 0; i < fakeUsers.size(); i++) {
			assertEquals(
					controller.login(fakeUsers.get(i).getId(),
							fakeUsers.get(i).getPassword()),
					controller.login(users.get(i).getId(),
							users.get(i).getPassword()));
		}
	}
}
