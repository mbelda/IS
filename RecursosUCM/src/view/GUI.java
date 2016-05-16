package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.users.User;
import view.admin.AdminViewPanel;
import view.admin.AdminViewPanel.ExtractMaterialButtonListener;
import view.admin.AdminViewPanel.PenalizeButtonListener;
import view.admin.AdminViewPanel.ReserveClassroomButtonListener;
import view.admin.AdminViewPanel.ReserveLaboratoryButtonListener;
import view.admin.AdminViewPanel.ReturnMaterialButtonListener;
import view.login.LoginPanel;
import view.login.LoginPanel.LoginButtonListener;
import view.normal.CheckMaterialPanel;
import view.normal.CheckMaterialPanel.CheckMaterialButtonListener;

/**
 * Clase que representa la ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {
	private static final String WINDOW_TITLE = "Recursos UCM";
	private LoginPanel loginPanel;
	private CheckMaterialPanel checkMaterialPanel;
	private AdminViewPanel adminViewPanel;

	/**
	 * Al inicio, la ventana construye la vista de login.
	 */
	public GUI(LoginButtonListener loginButtonListener) {
		super(WINDOW_TITLE);
		this.setLayout(new BorderLayout());
		this.loginPanel = new LoginPanel(loginButtonListener);
		this.add(loginPanel, BorderLayout.NORTH);
		this.setResizable(true);
		this.setSize(850, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String getUsername() {
		return this.loginPanel.getUsername();
	}

	public String getPassword() {
		return this.loginPanel.getPassword();
	}

	public void setAdminView(User user,
			PenalizeButtonListener penalizeButtonListener,
			ExtractMaterialButtonListener extractMaterialButtonListener,
			ReturnMaterialButtonListener returnMaterialButtonListener,
			ReserveClassroomButtonListener reserveClassroomButtonListener,
			ReserveLaboratoryButtonListener reserveLaboratoryButtonListener,
			CheckMaterialButtonListener checkMaterialButtonListener) {
		this.remove(loginPanel);
		this.checkMaterialPanel = new CheckMaterialPanel(user,
				checkMaterialButtonListener);
		this.adminViewPanel = new AdminViewPanel(user, penalizeButtonListener,
				extractMaterialButtonListener, returnMaterialButtonListener,
				reserveClassroomButtonListener, reserveLaboratoryButtonListener,
				checkMaterialButtonListener);
		this.add(adminViewPanel, BorderLayout.NORTH);
		refresh();
	}

	public void setNormalView(
			CheckMaterialButtonListener checkMaterialButtonListener,
			User user) {
		this.remove(loginPanel);
		this.checkMaterialPanel = new CheckMaterialPanel(user,
				checkMaterialButtonListener);
		this.add(checkMaterialPanel, BorderLayout.NORTH);
		refresh();
	}

	private void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
		this.repaint();
	}
}
