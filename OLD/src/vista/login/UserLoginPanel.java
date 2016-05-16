package vista.login;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class UserLoginPanel extends JPanel {

	private JTextArea usernameArea;

	public UserLoginPanel() {
		super(new FlowLayout());
		usernameArea = new JTextArea();
		this.add(usernameArea);
	}
	
	public String getUsername(){
		return this.usernameArea.getText();
	}
	
}
