package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Administrador;
import model.Alumno;
import model.Fecha;
import model.Penalizacion;
import model.Usuario;
import controlador.Controlador;

public class Vista extends JFrame{
	
	private Usuario user;
	private Controlador ctrl;
	
	public Vista(){
		this.setSize(600,600);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setVisible(true);
	}

	public void login(){
		this.getContentPane().removeAll();
		this.setLayout(new GridLayout());
		JLabel usuario = new JLabel();
		JLabel pass = new JLabel();
		JButton login = new JButton();
				
		
		JTextArea user = new JTextArea();
		usuario.setBorder(BorderFactory.createTitledBorder("Usuario"));
		user.setEditable(true);
		usuario.add(user);
		
		
		JTextArea passw = new JTextArea(); 
		pass.add(passw);
		pass.setBorder(BorderFactory.createTitledBorder("Contraseña"));
		
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.login(user.getText(), passw.getText());
			}
		});
		
		this.add(usuario);
		this.add(pass);
		this.add(login);
	}
	/*
	public void reservarLab(){
		JPanel panel = new JPanel(new FlowLayout());
		JComboBox labs = new JComboBox();
		
		String add;
		for(Laboratorio lab : ListaLaboratorios){
			//Como accedemos a la lista de laboratorios
			if (lab.getPair().getSecond()) {
			add = lab.getId() + " (" + lab.getCapacidad() + ")";
			labs.addItem(add);
			}
		}
		panel.add(labs);
		
		JComboBox dias = new JComboBox();
		Calendar date = Calendar.getInstance();
		for(int i = 0; i < 5; i++){
			@SuppressWarnings("deprecation")
			int dia = date.get(Calendar.DAY_OF_MONTH) + i;
			dias.addItem(dia);
		}		
		panel.add(dias);//Este va a ser el de los días
		
		JComboBox horas = new JComboBox();
		String [] horasLista = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", 
						  "17:00", "18:00", "19:00", "20:00", "21:00"};
		
	
		
		
		/*for(int i = 0; i < 14; i++){//La cantidad de horas desde las 9:00 hasta las 22:00
			//No se me ocurre cómo hacerlo. La idea es coger el día que esté seleccionado y si la hora que toque para 
			//ese día para la correspondiente vuelta del for está libre entonces la añadimos a la ComboBox
		}
		
		JButton set = new JButton("Set");
		
		set.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				Laboratorio lab = (Laboratorio) labs.getSelectedItem();
				String fecha = (String) horas.getSelectedItem();
				
				/*Preguntar al usuario que confirme con un Jdialog con una funcion externa
				que llevara el boton okey, y boton de cancelar
					JButton cancel = new JButton("Cancel");
					cancel.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e) {
	
					panel.add(cancel); */
		
				/*Llamar al controlador para que reserve el aula con los datos de las combo box;		
			}
				
		});
		
		panel.add(set);
		
		
		
		final JDialog frame = new JDialog(this.ventana, "Reservar Laboratorio", true);
		frame.getContentPane().add(panel);//Ahora me queda crear ese JPanel
		frame.pack();
		frame.setVisible(true);
		
		//Me queda también hacer las funciones que hagan las cosas correspondientes a los clics
	}*/
	/*
	public void reservarAula(){
		JPanel panel = new JPanel(new FlowLayout());
		JComboBox aulas = new JComboBox();
		
		String add;
		for(Laboratorio aula : ListaAulas){
			//Como accedemos a la lista de laboratorios
			if (aula.getPair().getSecond()) {
			add = aula.getId() + " (" + aula.getCapacidad() + ")";
			aulas.addItem(add);
			}
		}
		panel.add(aulas);
		
		JComboBox dias = new JComboBox();
		Calendar date = Calendar.getInstance();
		for(int i = 0; i < 5; i++){
			int dia = date.get(Calendar.DAY_OF_MONTH) + i;
			dias.addItem(dia);
		}		
		panel.add(dias);//Este va a ser el de los días
		
		JComboBox horas = new JComboBox();
		String [] horasLista = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", 
						  "17:00", "18:00", "19:00", "20:00", "21:00"};
		
	
		
		
		/*for(int i = 0; i < 14; i++){//La cantidad de horas desde las 9:00 hasta las 22:00
			//No se me ocurre cómo hacerlo. La idea es coger el día que esté seleccionado y si la hora que toque para 
			//ese día para la correspondiente vuelta del for está libre entonces la añadimos a la ComboBox
		}
		
		JButton set = new JButton("Set");
		
		set.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				Aula aula = (Aula) aulas.getSelectedItem();
				String fecha = (String) horas.getSelectedItem();
				
				/*Preguntar al usuario que confirme con un Jdialog con una funcion externa
				que llevara el boton okey, y boton de cancelar
					JButton cancel = new JButton("Cancel");
					cancel.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e) {
	
					panel.add(cancel); */
		
				/*Llamar al controlador para que reserve el aula con los datos de las combo box;	
			}
				
		});
		
		panel.add(set);
		
		
		
		final JDialog frame = new JDialog(this.ventana, "Reservar Aula", true);
		frame.getContentPane().add(panel);//Ahora me queda crear ese JPanel
		frame.pack();
		frame.setVisible(true);
		
		//Me queda también hacer las funciones que hagan las cosas correspondientes a los clics
	}*/
	
	public void menu() {
		if(user instanceof Administrador){ menuAdmin();}
		else{
			/*menuUser no hace ventana.getContentPane().removeAll();
			 * pq se le llama desde menuAdmin para reutilizar codigo*/
			this.getContentPane().removeAll();
			menuUser();
			
		}
	}

	private void menuAdmin() {
		this.getContentPane().removeAll();
		
		// TODO mostrar opciones de admin
		 // Opcion penalizar
        JButton jbPenalizar;
        jbPenalizar = new JButton("Penalizar");
        jbPenalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JFrame p = new JFrame("Penalizar");
                JPanel panel = new JPanel();
                JTextField jtf = new JTextField();

                // Aqui deberia haber elementos en la vista para
                // introducir una penalizacion(fecha, detalles, causa).

                Fecha f = null;
                String detalles = "";
                String causa = "";

                panel.add(jtf);
                p.add(panel);
                // Add los elementos para penalacion...
                p.setVisible(true);

                jtf.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        Usuario u = ctrl.getUsuario(jtf.getText());
                        if (u != null && u instanceof Alumno) {
                            ctrl.penalizar((Alumno) u, new Penalizacion(f,
                                    detalles, causa));
                        }
                        p.dispose();
                    }

                });
            }
        });

		menuUser();
	}

	private void menuUser() {
		/*TODO algunas opciones*/
		JButton ext = new JButton();

		ext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {ext();}

		});
		
		this.add(ext);
	}

	private void ext() {
		this.getContentPane().removeAll();
		 
		JPanel idPanel = new JPanel();
		JTextArea id = new JTextArea();
		JButton ext = new JButton();

		ext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {ext(id.getText());}

		});
		
		idPanel.setBorder(BorderFactory.createTitledBorder("Identificador del objeto a extraer"));
		idPanel.add(id);
		this.add(idPanel);
		
	}

	protected void ext(String id) {
		if(existeId(id)){
			if(objetoDisponible(id)){
				if( !penalizado()){
					if(!maxObjetosPrestados()){
						/*TODO Marcar en la BBDD como prestado*/
						Fecha dev = fechaDeDevolucion();
						JOptionPane.showMessageDialog(new JFrame(),
							"El préstamo se ha efectuado correctamente" + '\n'
							+ "Tiene que devolver el objeto en la siguiente fecha: " + dev + ".");
					}
					else{
						JOptionPane.showMessageDialog(new JFrame(),
								"Ha alcanzado el máximo de objetos simultáneamente prestados.");
						menu();
					}
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(),
							"Está penalizado hasta la siguiente fecha: "
							+ user.getEndPenalization() + ".");
					menu();
				}
			}
			else{
				JOptionPane.showMessageDialog(new JFrame(),
						"El objeto no está disponible.");
				menu();
			}	
		}
		else{
			JOptionPane.showMessageDialog(new JFrame(),
					"El objeto no existe.");
			menu();
		}
	}

	private Fecha fechaDeDevolucion() {
		return null;
		// TODO fechaDeDevolucion
	}

	private boolean penalizado() {
		// TODO comunicarse con la BBDD para ver si el usuario esta penalizado
		return false;
	}

	private boolean existeId(String id) {
		/* TODO Comunicarse con la BBDD para ver si el objeto existe */
		return false;
	}
	
	private boolean objetoDisponible(String id) {
		/* TODO Comunicarse con la BBDD para ver si el objeto esta disponible */
		return false;
	}
	
	private boolean maxObjetosPrestados() {
		/* TODO Comunicarse con la BBDD para ver si el usuario ha alcanzado
		 * el limite de objetos permitido */
		return false;
	}
	
}
