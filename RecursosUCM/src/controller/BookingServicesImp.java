package controller;

import java.util.List;
import java.util.Scanner;

import data.DAOClassroom;
import data.DAOLaboratory;
import model.material.Classroom;
import model.material.Fecha;
import model.material.Laboratory;

public class BookingServicesImp implements BookingServices{

	private ControllerImp ctrl;
	private Scanner in;
	
	public BookingServicesImp(ControllerImp ctrl) {
		this.ctrl = ctrl;
		this.in = new Scanner(System.in);
	}
	
	@Override
	public void reservarClassroom(DAOClassroom daoClass) {
		ctrl.notifyMessage("Choose the date and hour at which you want to book the classroom (YYYY/MM/DD/HH)");
		String fecha = in.nextLine();
		Fecha f = ctrl.stringToFecha(fecha);
		List<Classroom> classRoomsAvailables = daoClass.AvaibleList(f);
		if (classRoomsAvailables.size() > 0) {
			displayClassrooms(classRoomsAvailables);
			int n = Integer.parseInt(in.next());
			Classroom c = classRoomsAvailables.get(n);
			c.reservar(f);
			ctrl.notifyMessage("Aula reservada!! \n");
		} else {
			ctrl.notifyError("No existen clases disponibles para la fecha introducida");
		}
	}
	
	private void displayClassrooms(List<Classroom> l) {
		int i = 0;
		for (Classroom c : l) {
			ctrl.notifyMessage(i + "| ID Clase: " + c.getId()
					+ "| Capacidad Clase:  " + c.getCapacidad() + "\n");
			i++;
		}
		ctrl.notifyMessage("Introduce el numero de aula que quiere reservar ");
	}


	@Override
	public void reservarLaboratory(DAOLaboratory daoLab) {
		ctrl.notifyMessage("Choose the date and hour at which you want to book the classroom (YYYY/MM/DD/HH)");
		String fecha = in.nextLine();
		Fecha f = ctrl.stringToFecha(fecha);

		List<Laboratory> LaboratoriesAvailables = daoLab.AvaibleList(f);

		if (LaboratoriesAvailables.size() > 0) {
			displayLabs(LaboratoriesAvailables);
			int n = Integer.parseInt(in.next());
			Laboratory c = LaboratoriesAvailables.get(n);
			c.reservar(f);
			ctrl.notifyMessage("Aula reservada!! \n");
		} else {
			ctrl.notifyError("No existen laboratorios disponibles para la fecha introducida");
		}
	}
	
	private void displayLabs(List<Laboratory> l) {
		int i = 0;
		for (Laboratory c : l) {
			ctrl.notifyMessage(i + "| ID Laboratorio: " + c.getId()
					+ "| Capacidad Laboratorio:  " + c.getCapacidad() + "\n");
			i++;
		}
		ctrl.notifyMessage("Introduce el numero de laboratorio que quiere reservar ");
	}



}
