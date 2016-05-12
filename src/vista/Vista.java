package vista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Administrador;
import model.Fecha;
import model.Pair;
import model.Usuario;

public class Vista {

	private JFrame ventana;
	private Usuario user;
	
	public Vista(){
		ventana = new JFrame();
		ventana.setSize(600,600);
		ventana.setResizable(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	public void login(){
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
		pass.setBorder(BorderFactory.createTitledBorder("Contraseña"));
		
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
		
		if(resultado.getFirst()){
			user = resultado.getSecond();
			menu();
			/*TODO si tiene penalizaciones decirle hasta cuando con un jDialog*/
		}
		else{
			/*TODO mostrar error con un jDialog*/
			login();
		}
	}

	private void menu() {
		if(user instanceof Administrador){ menuAdmin();}
		else{
			/*menuUser no hace ventana.getContentPane().removeAll();
			 * pq se le llama desde menuAdmin para reutilizar codigo*/
			ventana.getContentPane().removeAll();
			menuUser();
			
		}
	}

	private void menuAdmin() {
		ventana.getContentPane().removeAll();
		// TODO mostrar opciones de admin
		menuUser();
	}

	private Pair<Boolean, Usuario> datosCorrectos(String usuario, String pass) {
		// TODO hablar con la BBDD para ver si es usuario o admin
		/*creo que esto que se duvuelve en vez de un Usuario es un DAO*/
		return new Pair<Boolean, Usuario>(false, null);
	}

	private void menuUser() {
		/*TODO algunas opciones*/
		JButton ext = new JButton();

		ext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {ext();}

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
			public void mouseClicked(MouseEvent e) {ext(id.getText());}

		});
		
		idPanel.setBorder(BorderFactory.createTitledBorder("Identificador del objeto a extraer"));
		idPanel.add(id);
		ventana.add(idPanel);
		
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
