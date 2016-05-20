package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.material.Classroom;
import model.material.Fecha;
import model.material.Laboratory;
import model.material.Material;
import model.penalization.Penalization;
import model.users.User;
import view.ControllerObserver;
import view.Observable;
import data.DAOClassroom;
import data.DAOLaboratory;
import data.DAOMaterial;
import data.users.DAOUsers;
import data.users.DAOUsersMemento;

public class Controller implements Observable<ControllerObserver> {

	private List<ControllerObserver> controllerObserverList;
	private DAOUsers daoUsers;
	private Scanner in;
	private DAOMaterial daoMaterial;
	private DAOClassroom daoClass;
	private DAOLaboratory daoLab;

	public Controller(List<User> users, List<Material> materials,
			List<Laboratory> labs, List<Classroom> classroom) {
		this.daoUsers = DAOUsers.getDaoUsers(users);
		this.daoMaterial = DAOMaterial.getDaoMaterial(materials);
		this.daoClass = DAOClassroom.getDaoClassroom(classroom);
		this.daoLab = DAOLaboratory.getDaoLaboratory(labs);
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
				this.notifyMessage("login correct");
				return user;
			} else {
				this.notifyError("incorrect password");
				return null;
			}
		} else {
			this.notifyError("username not found");
			return null;
		}
	}

	public void returnMaterial() {
		String id;
		this.notifyMessage("Nombre del usuario: ");
		id = in.next();
		while (!daoUsers.exists(id)) {
			this.notifyError("username not found");
			this.notifyMessage("Nombre del usuario: ");
			id = in.next();
		}
		DAOUsersMemento daoUsersMemento = daoUsers.requestMemento();
		daoUsers.restoreToMemento(daoUsersMemento);
		User user = daoUsers.getUserOfLastIndexLooked();
		if (user.hasBorrowedMaterials()) {
			this.notifyMessage("ID del material a devolver: ");
			String idMaterial = in.next();
			while (!user.hasMaterial(idMaterial)) {
				this.notifyError("material not found");
				this.notifyMessage("ID del material a devolver: ");
				idMaterial = in.next();
			}
			user.deleteLastIndexLookedBorrowedMaterial();
			daoMaterial.getMaterial(idMaterial).setBorrowed(false);
			this.notifyMessage("everything is ok...");
		} else {
			this.notifyError("El usuario no se corresponde con el material");
		}
	}

	public void extractMaterial() {
		User user = getExistentUser();
		if (!user.isPenalized()) {
			if (!user.hasAllMaterials()) {
				Material mat = getExistentMaterial();
				if (!mat.isBorrowed()) {
					user.addBorrowedMaterial(mat);
					mat.setBorrowed(true);
					this.notifyMessage("everything is ok...");
				} else {
					this.notifyError(mat.getId() + " it's allready borrowed.");
				}
			} else {
				this.notifyError(user.getId()
						+ " has reached the maximum materials"
						+ " he can borrow.");
			}
		} else {
			this.notifyError(user.getId() + " is penalized.");
		}
	}

	public void penalize() {
		User u = getExistentUser();
		Fecha f;
		String details;
		String cause;
		Penalization p;

		if (!u.isPenalized()) {
			f = stringToFecha(in.next());
			
			this.notifyMessage("Detalles de la penalizacion: ");
			details = in.next();
			this.notifyMessage("Causa de la penalizacion");
			cause = in.next();

			p = new Penalization(f, details, cause);
			u.setPenalization(p);
		} else {
			this.notifyMessage("Error, el usuario ya esta penalizado");
		}
	}

	public List<Material> checkMaterial(User user) {
		return user.getBorrowedMaterials();
	}

	@Deprecated
	/**
	 * ONLY USE FOR AUTOMATIC JUNIT TESTS DO NOT TOUCH!!!
	 * @param user
	 * @param material
	 * @return
	 */
	public boolean extractMaterialDebugMode1(User user, Material material) {

		if (daoUsers.exists(user.getId()) && !user.isPenalized()
				&& !user.hasAllMaterials()) {
			if (daoMaterial.exists(material.getId()) && !material.isBorrowed()) {
				user.addBorrowedMaterial(material);
				material.setBorrowed(true);
				this.notifyMessage("everything is ok...");
				return true;
			} else {
				this.notifyMessage(material.getId()
						+ " it's allready borrowed.");
				return false;
			}

		} else {
			this.notifyError(user.getId()
					+ " has reached the maximum materials" + " he can borrow.");
			return false;
		}
	}

	@Deprecated
	/**
	 * ONLY USE FOR AUTOMATIC JUNIT TESTS DO NOT TOUCH!!!
	 * @param user
	 * @param material
	 * @return
	 */
	public boolean extractMaterialDebugMode2(User user, Material material) {

		if (daoUsers.exists(user.getId()) && !user.isPenalized()
				&& !user.hasAllMaterialsDebugMode()) {
			if (daoMaterial.exists(material.getId()) && !material.isBorrowed()) {
				user.addBorrowedMaterial(material);
				material.setBorrowed(true);
				this.notifyMessage("everything is ok...");
				return true;
			} else {
				this.notifyError(material.getId()
						+ " it's allready borrowed.");
				return false;
			}

		} else {
			this.notifyError(user.getId()
					+ " has reached the maximum materials" + " he can borrow.");
			return false;
		}
	}

	public void reservarClassroom() {
		this.notifyMessage("Choose the date and hour at which you want to book the classroom (YYYY/MM/DD/HH)");
		String fecha = in.nextLine();
		Fecha f = stringToFecha(fecha);
		List<Classroom> classRoomsAvailables = daoClass.AvaibleList(f);
		if (classRoomsAvailables.size() > 0) {
			displayClassrooms(classRoomsAvailables);
			int n = Integer.parseInt(in.next());
			Classroom c = classRoomsAvailables.get(n);
			c.reservar(f);
			this.notifyMessage("Aula reservada!! \n");
		} else {
			this.notifyError("No existen clases disponibles para la fecha introducida");
		}
	}

	public void reservarLaboratory() {
		this.notifyMessage("Choose the date and hour at which you want to book the classroom (YYYY/MM/DD/HH)");
		String fecha = in.nextLine();
		Fecha f = stringToFecha(fecha);

		List<Laboratory> LaboratoriesAvailables = daoLab.AvaibleList(f);

		if (LaboratoriesAvailables.size() > 0) {
			displayLabs(LaboratoriesAvailables);
			int n = Integer.parseInt(in.next());
			Laboratory c = LaboratoriesAvailables.get(n);
			c.reservar(f);
			this.notifyMessage("Aula reservada!! \n");
		} else {
			this.notifyError("No existen laboratorios disponibles para la fecha introducida");
		}
	}

	/**
	 * Le pregunta al usuario un id de material hasta que le da uno existente
	 */
	private Material getExistentMaterial() {
		String idMat;
		this.notifyMessage("Nombre del usuario: ");
		idMat = in.next();
		while (!daoMaterial.exists(idMat)) {
			this.notifyError("material not found");
			this.notifyMessage("ID del material: ");
			idMat = in.next();
		}
		return daoMaterial.getMaterial(idMat);
	}

	/**
	 * Le pregunta al usuario un id de usuario hasta que le da uno existente
	 */
	private User getExistentUser() {
		String idUsu;
		this.notifyMessage("Nombre del usuario: ");
		idUsu = in.next();
		while (!daoUsers.exists(idUsu)) {
			this.notifyError("username not found");
			this.notifyMessage("Nombre del usuario: ");
			idUsu = in.next();
		}
		return daoUsers.get(idUsu);
	}

	private Fecha stringToFecha(String s) {
		String split = "/";
		String datos[] = s.split(split);
		Fecha f = new Fecha(Integer.parseInt(datos[0]),
				Integer.parseInt(datos[1]), Integer.parseInt(datos[2]),
				Integer.parseInt(datos[3]));

		return f;
	}

	private void displayLabs(List<Laboratory> l) {
		int i = 0;
		for (Laboratory c : l) {
			this.notifyMessage(i + "| ID Laboratorio: " + c.getId()
					+ "| Capacidad Laboratorio:  " + c.getCapacidad() + "\n");
			i++;
		}
		this.notifyMessage("Introduce el numero de laboratorio que quiere reservar ");
	}

	private void displayClassrooms(List<Classroom> l) {
		int i = 0;
		for (Classroom c : l) {
			this.notifyMessage(i + "| ID Clase: " + c.getId()
					+ "| Capacidad Clase:  " + c.getCapacidad() + "\n");
			i++;
		}
		this.notifyMessage("Introduce el numero de aula que quiere reservar ");
	}

	@Override
	public void addObserver(ControllerObserver controllerObserver) {
		if (this.controllerObserverList == null)
			this.controllerObserverList = new ArrayList<ControllerObserver>();
		this.controllerObserverList.add(controllerObserver);
	}

	@Override
	public void removeObserver(ControllerObserver controllerObserver) {
		this.controllerObserverList.remove(controllerObserverList);
	}

	private void notifyMessage(String msg) {
		for (int i = 0; i < this.controllerObserverList.size(); i++) {
			this.controllerObserverList.get(i).onPrintingMessage(msg);
		}
	}

	private void notifyError(String msg) {
		for (int i = 0; i < this.controllerObserverList.size(); i++) {
			this.controllerObserverList.get(i).onPrintingErrorMessage(msg);
		}
	}
}
