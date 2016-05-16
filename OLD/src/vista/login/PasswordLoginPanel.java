package vista.login;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PasswordLoginPanel extends JPanel{
	private JTextArea passwordArea;
	
	public PasswordLoginPanel(){
		super(new FlowLayout());
		passwordArea = new JTextArea();
		this.add(passwordArea);
	}
	
	public String getPassword(){
		return this.passwordArea.getText();
	}
}
