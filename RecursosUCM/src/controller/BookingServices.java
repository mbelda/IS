package controller;

import data.DAOClassroom;
import data.DAOLaboratory;

public interface BookingServices {
	
	public void reservarClassroom(DAOClassroom daoClass);
	public void reservarLaboratory(DAOLaboratory daoLab);

}
