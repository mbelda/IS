package controller;

import data.DAOMaterial;
import data.users.DAOUsers;
import data.users.DAOUsersMemento;
import model.material.Material;
import model.users.User;

public class MaterialServicesImp implements MaterialServices {

	private ControllerImp ctrl;
	
	public MaterialServicesImp(ControllerImp ctrl) {
		this.ctrl = ctrl;
	}
	
	@Override
	public void returnMaterial(DAOUsers daoUsers, DAOMaterial daoMaterial) {
		User user = ctrl.getExistentUser();
		DAOUsersMemento daoUsersMemento = daoUsers.requestMemento();
		daoUsers.restoreToMemento(daoUsersMemento);
		if (user.hasBorrowedMaterials()) {
			Material mat = ctrl.getExistentMaterial();
			user.deleteLastIndexLookedBorrowedMaterial();
			daoMaterial.getMaterial(mat.getId()).setBorrowed(false);
			ctrl.notifyMessage("everything is ok...");
		} else {
			ctrl.notifyError("El usuario no se corresponde con el material");
		}
	}

	@Override
	public void extractMaterial() {
		User user = ctrl.getExistentUser();
		if (!user.isPenalized()) {
			if (!user.hasAllMaterials()) {
				Material mat = ctrl.getExistentMaterial();
				if (!mat.isBorrowed()) {
					user.addBorrowedMaterial(mat);
					mat.setBorrowed(true);
					ctrl.notifyMessage("everything is ok...");
				} else {
					ctrl.notifyError(mat.getId() + " it's allready borrowed.");
				}
			} else {
				ctrl.notifyError(user.getId()
						+ " has reached the maximum materials"
						+ " he can borrow.");
			}
		} else {
			ctrl.notifyError(user.getId() + " is penalized.");
		}
	}
	
	@Deprecated
	/**
	 * ONLY USE FOR AUTOMATIC JUNIT TESTS DO NOT TOUCH!!!
	 * @param user
	 * @param material
	 * @return
	 */
	public boolean extractMaterialDebugMode1(User user, Material material,
			DAOUsers daoUsers, DAOMaterial daoMaterial) {

		if (daoUsers.exists(user.getId()) && !user.isPenalized()
				&& !user.hasAllMaterials()) {
			if (daoMaterial.exists(material.getId()) && !material.isBorrowed()) {
				user.addBorrowedMaterial(material);
				material.setBorrowed(true);
				ctrl.notifyMessage("everything is ok...");
				return true;
			} else {
				ctrl.notifyMessage(material.getId()
						+ " it's allready borrowed.");
				return false;
			}

		} else {
			ctrl.notifyError(user.getId()
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
	public boolean extractMaterialDebugMode2(User user, Material material,
			DAOUsers daoUsers, DAOMaterial daoMaterial) {

		if (daoUsers.exists(user.getId()) && !user.isPenalized()
				&& !user.hasAllMaterialsDebugMode()) {
			if (daoMaterial.exists(material.getId()) && !material.isBorrowed()) {
				user.addBorrowedMaterial(material);
				material.setBorrowed(true);
				ctrl.notifyMessage("everything is ok...");
				return true;
			} else {
				ctrl.notifyError(material.getId() + " it's allready borrowed.");
				return false;
			}

		} else {
			ctrl.notifyError(user.getId()
					+ " has reached the maximum materials" + " he can borrow.");
			return false;
		}
	}


}
