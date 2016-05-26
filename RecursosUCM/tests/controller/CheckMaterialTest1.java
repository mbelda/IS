package controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import model.users.User;

import org.junit.Before;
import org.junit.Test;

public class CheckMaterialTest1 {

	private static List<User> users;
	private static ControllerImp controller;

	/* default users in the system */
	private static void initUsers() {
		users = new ArrayList<User>();

		users.add(new User("Majo", "abc", true));
		users.add(new User("Alvaro", "def", false));
		users.add(new User("Luis", "ghi", true));
		users.add(new User("David", "jkl", false));
		users.add(new User("Juan", "mno", true));
		users.add(new User("Javi", "pqr", false));
	}

	@Before
	public void prepareData() {
		initUsers();
		controller = new ControllerImp(users, null, null, null);
	}

	@Test
	public void test() {
		for(int i = 0; i < users.size(); i++) {
			int test = controller.checkMaterial(users.get(i)).size();
			assertEquals(test, 0);
		}
	}

}