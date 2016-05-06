package vista;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Vista {

	JFrame ventana;
	
	public Vista(){
		ventana = new JFrame();
		ventana.setSize(600,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

	public void login(){
		ventana.setLayout(new GridLayout());
		JLabel usuario = new JLabel();
		JLabel pass = new JLabel();
		//acabar el login
		ventana.add(usuario);
	}
	
}
