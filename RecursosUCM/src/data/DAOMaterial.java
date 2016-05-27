package data;

import java.util.List;

import model.material.Material;

public class DAOMaterial {
	private static DAOMaterial theDAOMaterial;
	private List<Material> materials;

	private DAOMaterial(List<Material> materials) {
		this.materials = materials;
	}

	public boolean exists(String idMat) {
		for (int i = 0; i < materials.size(); i++) {
			if (materials.get(i).getId().equals(idMat))
				return true;
		}
		return false;
	}
	
	public Material getMaterial(String mat){
			for (int i = 0; i < materials.size(); i++) {
				if (materials.get(i).getId().equals(mat))
					return materials.get(i);
			}
			return null;
	}
	
	public static DAOMaterial getDaoMaterial (List <Material> l) {
		if ( theDAOMaterial == null) {
			theDAOMaterial = new  DAOMaterial(l);
		}
		return  theDAOMaterial;
	}
}
