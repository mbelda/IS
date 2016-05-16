package vista;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import vista.login.LoginPanel;
import vista.login.LoginPanel.LoginButtonListener;

/**
 * Clase que representa la ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {

	private LoginPanel loginPanel;

	/**
	 * Al inicio, la ventana construye la vista de login.
	 */
	public GUI(LoginButtonListener loginButtonListener) {
		super();
		this.setLayout(new FlowLayout());
		this.loginPanel = new LoginPanel(loginButtonListener);
		this.add(loginPanel);
		this.setResizable(true);
		this.setSize(850, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
