package view;

import java.awt.EventQueue;
import java.util.List;

import commands.*;
import model.material.Material;
import controller.Controller;
import model.users.User;
import view.admin.AdminViewPanel.ExtractMaterialButtonListener;
import view.admin.AdminViewPanel.PenalizeButtonListener;
import view.admin.AdminViewPanel.ReserveClassroomButtonListener;
import view.admin.AdminViewPanel.ReserveLaboratoryButtonListener;
import view.admin.AdminViewPanel.ReturnMaterialButtonListener;
import view.login.LoginPanel.LoginButtonListener;
import view.normal.CheckMaterialPanel.CheckMaterialButtonListener;

public class View implements ControllerObserver {

	private User user = null;
	private GUI gui;
	Controller controller;
	private List<Command> cmds;

	public View(Controller controller) {
		this.controller = controller;
		gui = new GUI(getLoginButtonListener());
		cmds.add(new PenalizeCommand());
		cmds.add(new ExtractMaterialCommand());
		cmds.add(new ReturnMaterialCommand());
		cmds.add(new ReservarClassroomCommand());
		cmds.add(new ReservarLaboratoryCommand());
		
		/*Nos suscribimos alos eventos del controlador*/
		controller.addObserver(this);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				gui.setVisible(true);
			}
		});
	}

	private LoginButtonListener getLoginButtonListener() {
		return new LoginButtonListener() {
			public void loginButtonClicked() {
				user = controller.login(gui.getUsername(), gui.getPassword());
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
				reserveClassroomButtonListener,
				reserveLaboratoryButtonListener, checkMaterialButtonListener);
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
				List<Material> material = controller.checkMaterial(user);
				System.out.println("----Material Prestado----");
				if (material.size() != 0) {
					for (int i = 0; i < material.size(); i++) {
						System.out.println((i + 1) + ". " + material.get(i));
					}
				} else
					System.out.println("Nada prestado");
				System.out.println("-------------------------");
			}
		};
	}

	private PenalizeButtonListener getPenalizeButtonListener() {
		return new PenalizeButtonListener() {
			public void penalizeButtonClicked() {
				cmds.get(0).execute(controller);
			}
		};
	}

	private ExtractMaterialButtonListener getExtractMaterialButtonListener() {
		return new ExtractMaterialButtonListener() {
			public void extractMaterialButtonClicked() {
				cmds.get(1).execute(controller);
				System.out.println("material extraido...");
			}
		};
	}

	private ReturnMaterialButtonListener getReturnMaterialButtonListener() {
		return new ReturnMaterialButtonListener() {
			public void returnMaterialButtonClicked() {
				cmds.get(2).execute(controller);
			}
		};
	}

	private ReserveClassroomButtonListener getReserveClassroomButtonListener() {
		return new ReserveClassroomButtonListener() {
			public void reserveClassroomButtonClicked() {
				cmds.get(3).execute(controller);
			}
		};
	}

	private ReserveLaboratoryButtonListener getReserveLaboratoryButtonListener() {
		return new ReserveLaboratoryButtonListener() {
			public void reserveLaboratoryButtonClicked() {
				cmds.get(4).execute(controller);
			}
		};
	}
	
	@Override
	public void onPrintingMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void onPrintingErrorMessage(String message) {
		System.err.println(message);
	}
}