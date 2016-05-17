package data;

import java.util.ArrayList;
import java.util.List;

import model.material.Classroom;
import model.material.Fecha;
import model.material.Laboratory;

public class DAOClassroom {
	
	private List<Classroom> classrooms;
	
	public DAOClassroom(List <Classroom> l ) {
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
	

}
