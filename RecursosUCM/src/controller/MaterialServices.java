package controller;

import data.DAOMaterial;
import data.users.DAOUsers;

public interface MaterialServices {
	
	public void returnMaterial(DAOUsers daoUsers, DAOMaterial daoMaterial);
	public void extractMaterial();

}
