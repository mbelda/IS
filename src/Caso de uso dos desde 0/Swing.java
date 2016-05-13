import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Swing {

	private Controller control;
	private JButton jbPenalizar;

	private void initBotonPenalizar() {
		jbPenalizar = new JButton("Penalizar");
		jbPenalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame p = new JFrame("Penalizar");
				JPanel panel = new JPanel();
				JTextField jtf = new JTextField();

				panel.add(jtf);
				p.add(panel);
				p.setVisible(true);

				Fecha f = null;
				String detalles = "";
				String causa = "";

				// Aqui deberia haber elementos en la vista para
				// introducir una penalizacion(fecha, detalles, causa).

				jtf.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Usuario u = control.getUsuario(jtf.getText());
						if (u != null) {
							control.penalizar(u, new Penalizacion(f, detalles,
									causa));
						}
						p.dispose();
					}

				});
			}

		});
	}
}
