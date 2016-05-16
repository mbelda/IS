package main;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import model.users.User;
import view.View;

public class Main {
	
	private static List<User> users;
	
	private static void initUsers(){
		users = new ArrayList<User>();
		users.add(new User("Majo", "abc", true));
		users.add(new User("Alvaro", "def", false));
		users.add(new User("Luis", "ghi", true));
		users.add(new User("David", "jkl", false));
		users.add(new User("Juan", "mno", true));
		users.add(new User("Javi", "pqr", false));
	}
	
	public static void main(String[] args) {
		initUsers();
		Controller controller = new Controller(users);
		View vista = new View(controller);
	}
}
