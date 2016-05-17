package controller;

import java.util.List;
import java.util.Scanner;

import data.DAOClassroom;
import data.DAOLaboratory;
import data.DAOMaterial;
import data.users.DAOUsers;
import data.users.DAOUsersMemento;
import model.material.Classroom;
import model.material.Fecha;
import model.material.Laboratory;
import model.material.Material;
import model.penalization.Penalization;
import model.users.User;

public class Controller {

	private DAOUsers daoUsers;
	private Scanner in;
	private DAOMaterial daoMaterial;
	private DAOClassroom daoClass;
	private DAOLaboratory daoLab;

	public Controller(List<User> users, List<Material> materials,
			List<Laboratory> labs, List<Classroom> classroom) {
		this.daoUsers = new DAOUsers(users);
		this.daoMaterial = new DAOMaterial(materials);
		this.daoClass = new DAOClassroom(classroom);
		this.daoLab = new DAOLaboratory(labs);
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
		while (!daoUsers.exists(id)) {
			System.err.println("username not found");
			System.out.println("Nombre del usuario: ");
			id = in.next();
		}
		DAOUsersMemento daoUsersMemento = daoUsers.requestMemento();
		daoUsers.restoreToMemento(daoUsersMemento);
		User user = daoUsers.getUserOfLastIndexLooked();
		if (user.hasBorrowedMaterials()) {
			System.out.println("ID del material a devolver: ");
			String idMaterial = in.next();
			while (!user.hasMaterial(idMaterial)) {
				System.err.println("material not found");
				System.out.println("ID del material a devolver: ");
				idMaterial = in.next();
			}
			user.deleteLastIndexLookedBorrowedMaterial();
			daoMaterial.getMaterial(idMaterial).setBorrowed(false);
			System.out.println("everything is ok...");
		} else {
			System.err.println("El usuario no se corresponde con el material");
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
					System.out.println("everything is ok...");
					/* TODO memento del material */
				} else {
					System.err
							.println(mat.getId() + " it's allready borrowed.");
				}
			} else {
				System.err.println(user.getId()
						+ " has reached the maximum materials"
						+ " he can borrow.");
			}
		} else {
			System.err.println(user.getId() + " is penalized.");
		}
	}

	public void penalize() {
		String id;
		User u;
		Fecha f;
		String details;
		String cause;
		Penalization p;

		System.out.println("Id del usuario a penalizar: ");
		id = in.next();
		while (!daoUsers.exists(id)) {
			System.err.println("Usuario no encontrado" + '\n'
					+ "Id del usuario a penalizar: ");
			id = in.next();
		}
		u = daoUsers.get(id);

		if (!u.isPenalized()) {
			f = stringToFecha(in.next());

			System.out.println("Detalles de la penalizacion: ");
			details = in.next();
			System.out.println("Causa de la penalizacion");
			cause = in.next();

			p = new Penalization(f, details, cause);
			u.setPenalization(p);
		} else {
			System.out.println("Error, el usuario ya esta penalizado");
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
				System.out.println("everything is ok...");
				return true;
				/* TODO memento del material */
			} else {
				System.err.println(material.getId()
						+ " it's allready borrowed.");
				return false;
			}

		} else {
			System.err.println(user.getId()
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
				System.out.println("everything is ok...");
				return true;
				/* TODO memento del material */
			} else {
				System.err.println(material.getId()
						+ " it's allready borrowed.");
				return false;
			}

		} else {
			System.err.println(user.getId()
					+ " has reached the maximum materials" + " he can borrow.");
			return false;
		}
	}

	public void reservarClassroom() {
		System.out
				.print("Choose the date and hour at which you want to book the classroom (YYYY/MM/DD/HH)");
		String fecha = in.nextLine();
		Fecha f = stringToFecha(fecha);
		List<Classroom> classRoomsAvailables = daoClass.AvaibleList(f);
		if (classRoomsAvailables.size() > 0) {
			displayClassrooms(classRoomsAvailables);
			int n = Integer.parseInt(in.next());
			Classroom c = classRoomsAvailables.get(n);
			c.reservar(f);
			System.out.println("Aula reservada!! \n");
		} else {
			System.err
					.println("No existen clases disponibles para la fecha introducida");
		}
	}

	public void reservarLaboratory() {
		System.out
				.print("Choose the date and hour at which you want to book the classroom (YYYY/MM/DD/HH)");
		String fecha = in.nextLine();
		Fecha f = stringToFecha(fecha);

		List<Laboratory> LaboratoriesAvailables = daoLab.AvaibleList(f);

		if (LaboratoriesAvailables.size() > 0) {
			displayLabs(LaboratoriesAvailables);
			int n = Integer.parseInt(in.next());
			Laboratory c = LaboratoriesAvailables.get(n);
			c.reservar(f);
			System.out.println("Aula reservada!! \n");
		} else {
			System.err
					.println("No existen laboratorios disponibles para la fecha introducida");
		}
	}

	/**
	 * Le pregunta al usuario un id de material hasta que le da uno existente
	 */
	private Material getExistentMaterial() {
		String idMat;
		System.out.println("Nombre del usuario: ");
		idMat = in.next();
		while (!daoMaterial.exists(idMat)) {
			System.err.println("material not found");
			System.out.println("ID del material: ");
			idMat = in.next();
		}
		return daoMaterial.getMaterial(idMat);
	}

	/**
	 * Le pregunta al usuario un id de usuario hasta que le da uno existente
	 */
	private User getExistentUser() {
		String idUsu;
		System.out.println("Nombre del usuario: ");
		idUsu = in.next();
		while (!daoUsers.exists(idUsu)) {
			System.err.println("username not found");
			System.out.println("Nombre del usuario: ");
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
			System.out.println(i + "| ID Laboratorio: " + c.getId()
					+ "| Capacidad Laboratorio:  " + c.getCapacidad() + "\n");
			i++;
		}

		System.out
				.print("Introduce el numero de laboratorio que quiere reservar \n");
	}

	private void displayClassrooms(List<Classroom> l) {
		int i = 0;
		for (Classroom c : l) {
			System.out.println(i + "| ID Clase: " + c.getId()
					+ "| Capacidad Clase:  " + c.getCapacidad() + "\n");
			i++;
		}

		System.out.print("Introduce el numero de aula que quiere reservar \n");
	}

}
