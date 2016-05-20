package view.login;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PasswordLoginPanel extends JPanel {
	private JTextArea passwordArea;
	private static final String PANEL_NAME_TEXT = "Password";

	public PasswordLoginPanel() {
		super(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), PANEL_NAME_TEXT));
		passwordArea = new JTextArea();
		this.add(passwordArea, BorderLayout.CENTER);
	}

	public String getPassword() {
		return this.passwordArea.getText();
	}

	public void deletePassword() {
		this.passwordArea.setText("");
	}
}
