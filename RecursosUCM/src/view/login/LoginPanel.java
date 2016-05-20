package view.login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {

	private static final String LOGIN_TEXT = "Login";
	private UserLoginPanel userLoginPanel;
	private PasswordLoginPanel passwordLoginPanel;
	private JButton loginButton;

	public interface LoginButtonListener {
		public void loginButtonClicked();
	}

	public LoginPanel(LoginButtonListener loginButtonListener) {
		super(new GridLayout(1, 3));
		this.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), LOGIN_TEXT));
		this.userLoginPanel = new UserLoginPanel();
		this.passwordLoginPanel = new PasswordLoginPanel();
		this.loginButton = new JButton(LOGIN_TEXT);

		this.loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				loginButtonListener.loginButtonClicked();
			}
		});

		this.add(userLoginPanel);
		this.add(passwordLoginPanel);
		this.add(loginButton);
	}

	public String getUsername() {
		return this.userLoginPanel.getUsername();
	}

	public String getPassword() {
		return this.passwordLoginPanel.getPassword();
	}

	public void refreshLogin(LoginMemento loginMemento) {
		this.userLoginPanel.refreshUser(loginMemento);
		this.passwordLoginPanel.deletePassword();
	}
	
}
