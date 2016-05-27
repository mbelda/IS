package data;

import java.util.ArrayList;
import java.util.List;

import model.material.Classroom;
import model.material.Fecha;

public class DAOClassroom {
	
	private static DAOClassroom theDaoClass;
	private List<Classroom> classrooms;
	
	private DAOClassroom(List <Classroom> l ) {
		classrooms = l;
	}
	
	public List<Classroom> AvaibleList(Fecha fecha){
		List<Classroom> list = new ArrayList<Classroom>();
		
		for (int i = 0; i < classrooms.size(); i++) {
			if (!classrooms.get(i).reservada(fecha)){
				list.add(classrooms.get(i));
			}
				
		}
		return list;
	}
	
	public static DAOClassroom getDaoClassroom (List <Classroom> l) {
		if ( theDaoClass == null) {
			 theDaoClass = new  DAOClassroom(l);
		}
		return  theDaoClass;
	}
	

}
