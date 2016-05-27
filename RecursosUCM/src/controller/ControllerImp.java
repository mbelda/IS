package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.DAOClassroom;
import data.DAOLaboratory;
import data.DAOMaterial;
import data.users.DAOUsers;
import model.material.Classroom;
import model.material.Fecha;
import model.material.Laboratory;
import model.material.Material;
import model.users.User;
import view.ControllerObserver;
import view.Observable;
import view.login.LoginMemento;

public class ControllerImp implements Controller, Observable<ControllerObserver>{

	private List<ControllerObserver> controllerObserverList;
	private DAOUsers daoUsers;
	private Scanner in;
	private DAOMaterial daoMaterial;
	private DAOClassroom daoClass;
	private DAOLaboratory daoLab;
	private LoginMemento loginMemento;
	
	private UserServicesImp usi;
	private MaterialServicesImp msi;
	private BookingServicesImp bsi;
	
	public ControllerImp(List<User> users, List<Material> materials,
			List<Laboratory> labs, List<Classroom> classroom) {
		this.daoUsers = DAOUsers.getDaoUsers(users);
		this.daoMaterial = DAOMaterial.getDaoMaterial(materials);
		this.daoClass = DAOClassroom.getDaoClassroom(classroom);
		this.daoLab = DAOLaboratory.getDaoLaboratory(labs);
		this.in = new Scanner(System.in);
		
		this.usi = new UserServicesImp(this);
		this.msi = new MaterialServicesImp(this);
		this.bsi = new BookingServicesImp(this);
		this.controllerObserverList = new ArrayList<>();
	}
	
	@Override
	public User login(String id, String password) {
		return usi.login(id, password, daoUsers, loginMemento);
	}

	public void notifyMessage(String msg) {
		for (int i = 0; i < this.controllerObserverList.size(); i++) {
			this.controllerObserverList.get(i).onPrintingMessage(msg);
		}
	}

	public void notifyError(String msg) {
		for (int i = 0; i < this.controllerObserverList.size(); i++) {
			this.controllerObserverList.get(i).onPrintingErrorMessage(msg);
		}
	}
	
	@Override
	public void returnMaterial() {
		msi.returnMaterial(daoUsers, daoMaterial);
	}

	@Override
	public void extractMaterial() {
		msi.extractMaterial();
	}

	@Override
	public void penalize() {
		usi.penalize();
	}

	@Override
	public List<Material> checkMaterial(User user) {
		return user.getBorrowedMaterials();
	}

	@Override
	public void reservarClassroom() {
		bsi.reservarClassroom(daoClass);
	}

	@Override
	public void reservarLaboratory() {
		bsi.reservarLaboratory(daoLab);
	}

	@Override
	public Material getExistentMaterial() {
		String idMat;
		this.notifyMessage("ID del material: ");
		idMat = in.next();
		while (!daoMaterial.exists(idMat)) {
			this.notifyError("material not found");
			this.notifyMessage("ID del material: ");
			idMat = in.next();
		}
		return daoMaterial.getMaterial(idMat);
	}

	@Override
	public User getExistentUser() {
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

	@Override
	public Fecha stringToFecha(String s) {
		String split = "/";
		String datos[] = s.split(split);
		Fecha f = new Fecha(Integer.parseInt(datos[0]),
				Integer.parseInt(datos[1]), Integer.parseInt(datos[2]),
				Integer.parseInt(datos[3]));

		return f;
	}

	@Override
	public void notifyLoginRefresh(LoginMemento loginMemento) {
		for (int i = 0; i < this.controllerObserverList.size(); i++) {
			this.controllerObserverList.get(i).refreshLogin(loginMemento);
		}
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


}
