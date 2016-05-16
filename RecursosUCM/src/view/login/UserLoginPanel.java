package view.login;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class UserLoginPanel extends JPanel {

	private JTextArea usernameArea;
	private static final String PANEL_NAME_TEXT = "Username";
	
	public UserLoginPanel() {
		super(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), PANEL_NAME_TEXT));
		usernameArea = new JTextArea();
		this.add(usernameArea, BorderLayout.CENTER);
	}
	
	public String getUsername(){
		return this.usernameArea.getText();
	}
	
}
