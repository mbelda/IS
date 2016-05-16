package vista;

import java.awt.EventQueue;

import vista.login.LoginPanel.LoginButtonListener;

public class Vista {
	private GUI gui;

	public Vista() {
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
				//cosas con el controlador.
			}
		};
	}
}