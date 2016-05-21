package controller;

import java.util.List;

import data.users.DAOUsers;
import model.material.Material;
import model.users.User;
import view.login.LoginMemento;

public interface UserServices {
	
	User login(String id, String password, DAOUsers daoUsers, LoginMemento loginMemento);
	public void penalize();
	public List<Material> checkMaterial(User user);

}
