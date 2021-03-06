package data;

import java.util.ArrayList;
import java.util.List;

import model.material.Fecha;
import model.material.Laboratory;

public class DAOLaboratory {
	
	private static DAOLaboratory theDaoLab;
	private List<Laboratory> labs;
	
	private DAOLaboratory(List <Laboratory> l ) {
		labs = l;
	}
	
	public List<Laboratory> AvaibleList(Fecha fecha){
		List<Laboratory> list = new ArrayList<Laboratory> ();
		
		for (int i = 0; i < labs.size(); i++) {
			if (!labs.get(i).reservado(fecha)){
				list.add(labs.get(i));
			}
				
		}
		
		return list;
	}
	
	public static DAOLaboratory getDaoLaboratory (List <Laboratory> l) {
		if ( theDaoLab == null) {
			theDaoLab = new DAOLaboratory(l);
		}
		return  theDaoLab;
	}

}