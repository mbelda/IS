package controller;

import java.util.List;

import model.material.Classroom;
import model.material.Fecha;
import model.material.Laboratory;
import model.material.Material;
import model.users.User;
import view.login.LoginMemento;

public interface Controller {
	
	public User login(String id, String password);

	public void returnMaterial();

	public void extractMaterial();

	public void penalize();

	public List<Material> checkMaterial(User user);

	public void reservarClassroom();

	public void reservarLaboratory();

	/**
	 * Le pregunta al usuario un id de material hasta que le da uno existente
	 */
	Material getExistentMaterial();
	/**
	 * Le pregunta al usuario un id de usuario hasta que le da uno existente
	 */
	User getExistentUser();

	Fecha stringToFecha(String s);

	void notifyMessage(String msg);
	
	void notifyError(String msg);

	void notifyLoginRefresh(LoginMemento loginMemento);

}
