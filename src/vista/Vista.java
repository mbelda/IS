package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;

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
	
	public void reservarLab(){
		JPanel panel = new JPanel(new FlowLayout());
		JComboBox labs = new JComboBox();
		
		String add;
		foreach(Laboratorio lab in ListaLaboratorios){
			add = lab.getId() + " (" + lab.getCapacidad().toString() + ")";
			labs.addItem(add);
		}
		labs.addActionListener((ActionListener) this);
		panel.add(labs);
		
		JComboBox dias = new JComboBox();
		
		for(int i = 0; i < 5; i++){
			add = listaDias(currentDayIndex + i);//El currentDayIndex va a guardar el día en el que estamos dentro de la lista
												 //Suponemos que listaDias contendrá los días lectivos
			dias.addItem(add);
		}
		dias.addActionListener((ActionListener) this);
		panel.add(dias);//Este va a ser el de los días
		
		String [] horasLista = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", 
						  "17:00", "18:00", "19:00", "20:00", "21:00"};
		
		JComboBox horas = new JComboBox(horasLista);
		
		
		/*for(int i = 0; i < 14; i++){//La cantidad de horas desde las 9:00 hasta las 22:00
			//No se me ocurre cómo hacerlo. La idea es coger el día que esté seleccionado y si la hora que toque para 
			//ese día para la correspondiente vuelta del for está libre entonces la añadimos a la ComboBox
		}*/
		horas.addActionListener((ActionListener)this);
		panel.add(horas);
		
		JButton set = new JButton("Set");
		set.addActionListener((ActionListener) this);
		set.setActionCommand("set");
		panel.add(set);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener((ActionListener) this);
		cancel.setActionCommand("cancel");
		panel.add(cancel);
		
		final JDialog frame = new JDialog(this.ventana, "Reservar Laboratorio", true);
		frame.getContentPane().add(panel);//Ahora me queda crear ese JPanel
		frame.pack();
		frame.setVisible(true);
		
		//Me queda también hacer las funciones que hagan las cosas correspondientes a los clics
	}
	
	public void actionPerformed(ActionEvent e){
		if("set".equals(e.getActionCommand())){//Lo que hacemos si hemos dado a reservar
			
		} else if("cancel".equals(e.getActionCommand())){
			frame.dispose();
		}
	}
	
}
