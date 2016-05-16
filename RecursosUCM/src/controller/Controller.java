package controller;

import java.util.List;
import java.util.Scanner;

import data.users.DAOUsers;
import data.users.DAOUsersMemento;
import model.users.User;

public class Controller {

	private DAOUsers daoUsers;
	private Scanner in;
	
	public Controller(List<User> users) {
		this.daoUsers = new DAOUsers(users);
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
}
