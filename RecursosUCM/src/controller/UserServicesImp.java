package controller;

import java.util.List;
import java.util.Scanner;

import data.users.DAOUsers;
import data.users.DAOUsersMemento;
import model.material.Fecha;
import model.material.Material;
import model.penalization.Penalization;
import model.users.User;
import view.login.LoginMemento;

public class UserServicesImp implements UserServices{

	private ControllerImp ctrl;
	private Scanner in;
	
	public UserServicesImp(ControllerImp ctrl){
		this.ctrl = ctrl;
		this.in = new Scanner(System.in);
	}
	
	@Override
	public User login(String id, String password, DAOUsers daoUsers, LoginMemento loginMemento) {
		User user;
		DAOUsersMemento daoUsersMemento = null;
		if (daoUsers.exists(id)) {
			daoUsersMemento = daoUsers.requestMemento();
			daoUsers.restoreToMemento(daoUsersMemento);
			user = daoUsers.getUserOfLastIndexLooked();

			/* creamos un loginMemento en cuanto insertamos un usuario de verdad */
			loginMemento = new LoginMemento(user.getId());
			/*Siempre que se incurre en un fallo del login se vuelve al ultimo
			 * usuario valido que se puso*/
			if (user.getPassword().equals(password)) {
				ctrl.notifyMessage("login correct");
				return user;
			} else {
				ctrl.notifyError("incorrect password");
				ctrl.notifyLoginRefresh(loginMemento);
				return null;
			}
		} else {
			ctrl.notifyError("username not found");
			ctrl.notifyLoginRefresh(loginMemento);
			return null;
		}
	}

	@Override
	public void penalize() {
		User u = ctrl.getExistentUser();
		Fecha f;
		String details;
		String cause;
		Penalization p;

		if (!u.isPenalized()) {
			f = ctrl.stringToFecha(in.next());

			ctrl.notifyMessage("Detalles de la penalizacion: ");
			details = in.next();
			ctrl.notifyMessage("Causa de la penalizacion");
			cause = in.next();

			p = new Penalization(f, details, cause);
			u.setPenalization(p);
		} else {
			ctrl.notifyMessage("Error, el usuario ya esta penalizado");
		}
	}

	@Override
	public List<Material> checkMaterial(User user) {
		return user.getBorrowedMaterials();
	}

}
