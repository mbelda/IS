package view;

import java.awt.EventQueue;

import controller.Controller;
import model.users.User;
import view.admin.AdminViewPanel.ExtractMaterialButtonListener;
import view.admin.AdminViewPanel.PenalizeButtonListener;
import view.admin.AdminViewPanel.ReserveClassroomButtonListener;
import view.admin.AdminViewPanel.ReserveLaboratoryButtonListener;
import view.admin.AdminViewPanel.ReturnMaterialButtonListener;
import view.login.LoginPanel.LoginButtonListener;
import view.normal.CheckMaterialPanel.CheckMaterialButtonListener;

public class View {
	private GUI gui;
	Controller controller;

	public View(Controller controller) {
		this.controller = controller;
		gui = new GUI(getLoginButtonListener());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				gui.setVisible(true);
			}
		});
	}

	private LoginButtonListener getLoginButtonListener() {
		return new LoginButtonListener() {
			public void loginButtonClicked() {
				User user = controller.login(gui.getUsername(),
						gui.getPassword());
				if (user != null) {
					if (user.isAdmin()) {
						setAdminView(user, getPenalizeButtonListener(),
								getExtractMaterialButtonListener(),
								getReturnMaterialButtonListener(),
								getReserveClassroomButtonListener(),
								getReserveLaboratoryButtonListener(),
								getCheckMaterialButtonListener());
					} else {
						setNormalView(user, getCheckMaterialButtonListener());
					}
				}
			}
		};
	}

	private void setAdminView(User user,
			PenalizeButtonListener penalizeButtonListener,
			ExtractMaterialButtonListener extractMaterialButtonListener,
			ReturnMaterialButtonListener returnMaterialButtonListener,
			ReserveClassroomButtonListener reserveClassroomButtonListener,
			ReserveLaboratoryButtonListener reserveLaboratoryButtonListener,
			CheckMaterialButtonListener checkMaterialButtonListener) {
		gui.setAdminView(user, penalizeButtonListener,
				extractMaterialButtonListener, returnMaterialButtonListener,
				reserveClassroomButtonListener, reserveLaboratoryButtonListener,
				checkMaterialButtonListener);
	}

	private void setNormalView(User user,
			CheckMaterialButtonListener checkMaterialButtonListener) {
		gui.setNormalView(checkMaterialButtonListener, user);
	}

	/*
	 * Para seguir el MVC debemos interactuar con el controlador en todos los
	 * listener
	 */

	private CheckMaterialButtonListener getCheckMaterialButtonListener() {
		return new CheckMaterialButtonListener() {
			public void materialButtonClicked() {
				System.out.println("lista de material...");
			}
		};
	}

	private PenalizeButtonListener getPenalizeButtonListener() {
		return new PenalizeButtonListener() {
			public void penalizeButtonClicked() {
				System.out.println("penalizado!!");
			}
		};
	}

	private ExtractMaterialButtonListener getExtractMaterialButtonListener() {
		return new ExtractMaterialButtonListener() {
			public void extractMaterialButtonClicked() {
				controller.extractMaterial();
			}
		};
	}

	private ReturnMaterialButtonListener getReturnMaterialButtonListener() {
		return new ReturnMaterialButtonListener() {
			public void returnMaterialButtonClicked() {
				controller.returnMaterial();
			}
		};
	}

	private ReserveClassroomButtonListener getReserveClassroomButtonListener() {
		return new ReserveClassroomButtonListener() {
			public void reserveClassroomButtonClicked() {
				System.out.println("Aula reservada!!");
			}
		};
	}

	private ReserveLaboratoryButtonListener getReserveLaboratoryButtonListener() {
		return new ReserveLaboratoryButtonListener() {
			public void reserveLaboratoryButtonClicked() {
				System.out.println("Lab reservado!!");
			}
		};
	}
}