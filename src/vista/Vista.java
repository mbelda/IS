package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.Controlador;
import model.Administrador;
import model.Alumno;
import model.Aula;
import model.Fecha;
import model.Laboratorio;
import model.Pair;
import model.Penalizacion;
import model.Usuario;

public class Vista {

	private JFrame ventana;
	private Usuario user;
	private Controlador control;

	public Vista() {
		ventana = new JFrame();
		ventana.setSize(600, 600);
		ventana.setResizable(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void login() {
		ventana.getContentPane().removeAll();
		ventana.setLayout(new GridLayout());
		JLabel usuario = new JLabel();
		JLabel pass = new JLabel();
		JButton login = new JButton();

		JTextArea user = new JTextArea();
		usuario.add(user);
		usuario.setBorder(BorderFactory.createTitledBorder("Usuario"));

		JTextArea passw = new JTextArea();
		pass.add(passw);
		pass.setBorder(BorderFactory.createTitledBorder("Contrase�a"));

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login(user.getText(), passw.getText());
			}
		});

		ventana.add(usuario);
		ventana.add(pass);
		ventana.add(login);

	}

	private void login(String usuario, String pass) {

		Pair<Boolean, Usuario> resultado = datosCorrectos(usuario, pass);

		if (resultado.getFirst()) {
			user = resultado.getSecond();
			menu();
			/* TODO si tiene penalizaciones decirle hasta cuando con un jDialog */
		} else {
			/* TODO mostrar error con un jDialog */
			login();
		}
	}

	public void reservarLab() {
		JPanel panel = new JPanel(new FlowLayout());
		JComboBox labs = new JComboBox();

		String add;
		for (Laboratorio lab : ListaLaboratorios) {
			// Como accedemos a la lista de laboratorios
			if (lab.getPair().getSecond()) {
				add = lab.getId() + " (" + lab.getCapacidad() + ")";
				labs.addItem(add);
			}
		}
		panel.add(labs);

		JComboBox dias = new JComboBox();
		Calendar date = Calendar.getInstance();
		for (int i = 0; i < 5; i++) {
			@SuppressWarnings("deprecation")
			int dia = date.get(Calendar.DAY_OF_MONTH) + i;
			dias.addItem(dia);
		}
		panel.add(dias);// Este va a ser el de los d�as

		JComboBox horas = new JComboBox();
		String[] horasLista = { "09:00", "10:00", "11:00", "12:00", "13:00",
				"14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00",
				"21:00" };

		/*
		 * for(int i = 0; i < 14; i++){//La cantidad de horas desde las 9:00
		 * hasta las 22:00 //No se me ocurre c�mo hacerlo. La idea es coger el
		 * d�a que est� seleccionado y si la hora que toque para //ese d�a para
		 * la correspondiente vuelta del for est� libre entonces la a�adimos a
		 * la ComboBox }
		 */

		JButton set = new JButton("Set");

		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Laboratorio lab = (Laboratorio) labs.getSelectedItem();
				String fecha = (String) horas.getSelectedItem();

				/*
				 * Preguntar al usuario que confirme con un Jdialog con una
				 * funcion externa que llevara el boton okey, y boton de
				 * cancelar JButton cancel = new JButton("Cancel");
				 * cancel.addActionListener(new ActionListener(){ public void
				 * actionPerformed (ActionEvent e) {
				 * 
				 * panel.add(cancel);
				 */

				/*
				 * Llamar al controlador para que reserve el aula con los datos
				 * de las combo box;
				 */
			}

		});

		panel.add(set);

		final JDialog frame = new JDialog(this.ventana, "Reservar Laboratorio",
				true);
		frame.getContentPane().add(panel);// Ahora me queda crear ese JPanel
		frame.pack();
		frame.setVisible(true);

		// Me queda tambi�n hacer las funciones que hagan las cosas
		// correspondientes a los clics
	}

	public void reservarAula() {
		JPanel panel = new JPanel(new FlowLayout());
		JComboBox aulas = new JComboBox();

		String add;
		for (Laboratorio aula : ListaAulas) {
			// Como accedemos a la lista de laboratorios
			if (aula.getPair().getSecond()) {
				add = aula.getId() + " (" + aula.getCapacidad() + ")";
				aulas.addItem(add);
			}
		}
		panel.add(aulas);

		JComboBox dias = new JComboBox();
		Calendar date = Calendar.getInstance();
		for (int i = 0; i < 5; i++) {
			int dia = date.get(Calendar.DAY_OF_MONTH) + i;
			dias.addItem(dia);
		}
		panel.add(dias);// Este va a ser el de los d�as

		JComboBox horas = new JComboBox();
		String[] horasLista = { "09:00", "10:00", "11:00", "12:00", "13:00",
				"14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00",
				"21:00" };

		/*
		 * for(int i = 0; i < 14; i++){//La cantidad de horas desde las 9:00
		 * hasta las 22:00 //No se me ocurre c�mo hacerlo. La idea es coger el
		 * d�a que est� seleccionado y si la hora que toque para //ese d�a para
		 * la correspondiente vuelta del for est� libre entonces la a�adimos a
		 * la ComboBox }
		 */

		JButton set = new JButton("Set");

		set.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Aula aula = (Aula) aulas.getSelectedItem();
				String fecha = (String) horas.getSelectedItem();

				/*
				 * Preguntar al usuario que confirme con un Jdialog con una
				 * funcion externa que llevara el boton okey, y boton de
				 * cancelar JButton cancel = new JButton("Cancel");
				 * cancel.addActionListener(new ActionListener(){ public void
				 * actionPerformed (ActionEvent e) {
				 * 
				 * panel.add(cancel);
				 */

				/*
				 * Llamar al controlador para que reserve el aula con los datos
				 * de las combo box;
				 */
			}

		});

		panel.add(set);

		final JDialog frame = new JDialog(this.ventana, "Reservar Aula", true);
		frame.getContentPane().add(panel);// Ahora me queda crear ese JPanel
		frame.pack();
		frame.setVisible(true);

		// Me queda tambi�n hacer las funciones que hagan las cosas
		// correspondientes a los clics
	}

	private void menu() {
		if (user instanceof Administrador) {
			menuAdmin();
		} else {
			/*
			 * menuUser no hace ventana.getContentPane().removeAll(); pq se le
			 * llama desde menuAdmin para reutilizar codigo
			 */
			ventana.getContentPane().removeAll();
			menuUser();

		}
	}

	private void menuAdmin() {
		ventana.getContentPane().removeAll();
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
						Usuario u = control.getUsuario(jtf.getText());
						if (u != null && u instanceof Alumno) {
							control.penalizar((Alumno) u, new Penalizacion(f,
									detalles, causa));
						}
						p.dispose();
					}

				});
			}

		});

		menuUser();
	}

	private Pair<Boolean, Usuario> datosCorrectos(String usuario, String pass) {
		// TODO hablar con la BBDD para ver si es usuario o admin
		/* creo que esto que se duvuelve en vez de un Usuario es un DAO */
		return new Pair<Boolean, Usuario>(false, null);
	}

	private void menuUser() {
		/* TODO algunas opciones */
		JButton ext = new JButton();

		ext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ext();
			}

		});

		ventana.add(ext);
	}

	private void ext() {
		ventana.getContentPane().removeAll();

		JPanel idPanel = new JPanel();
		JTextArea id = new JTextArea();
		JButton ext = new JButton();

		ext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ext(id.getText());
			}

		});

		idPanel.setBorder(BorderFactory
				.createTitledBorder("Identificador del objeto a extraer"));
		idPanel.add(id);
		ventana.add(idPanel);

	}

	protected void ext(String id) {
		if (existeId(id)) {
			if (objetoDisponible(id)) {
				if (!penalizado()) {
					if (!maxObjetosPrestados()) {
						/* TODO Marcar en la BBDD como prestado */
						Fecha dev = fechaDeDevolucion();
						JOptionPane
								.showMessageDialog(
										new JFrame(),
										"El pr�stamo se ha efectuado correctamente"
												+ '\n'
												+ "Tiene que devolver el objeto en la siguiente fecha: "
												+ dev + ".");
					} else {
						JOptionPane
								.showMessageDialog(new JFrame(),
										"Ha alcanzado el m�ximo de objetos simult�neamente prestados.");
						menu();
					}
				} else {
					JOptionPane.showMessageDialog(
							new JFrame(),
							"Est� penalizado hasta la siguiente fecha: "
									+ user.getEndPenalization() + ".");
					menu();
				}
			} else {
				JOptionPane.showMessageDialog(new JFrame(),
						"El objeto no est� disponible.");
				menu();
			}
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "El objeto no existe.");
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
		/*
		 * TODO Comunicarse con la BBDD para ver si el usuario ha alcanzado el
		 * limite de objetos permitido
		 */
		return false;
	}

}
