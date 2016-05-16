package view.normal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.users.User;

@SuppressWarnings("serial")
public class CheckMaterialPanel extends JPanel {

	public interface CheckMaterialButtonListener {
		void materialButtonClicked();
	}

	private JButton checkMaterial;
	private static final String PANEL_NAME = "'s view";
	private static final String CHECK_MATERIAL_TEXT = "Consultar Material";

	public CheckMaterialPanel(User user,
			CheckMaterialButtonListener checkMaterialButtonListener) {
		super(new BorderLayout());

		if (!user.isAdmin()) {
			this.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createEtchedBorder(),
					user.getId() + PANEL_NAME));
		}
		
		this.checkMaterial = new JButton(CHECK_MATERIAL_TEXT);
		this.checkMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkMaterialButtonListener.materialButtonClicked();
			}
		});
		this.add(checkMaterial, BorderLayout.CENTER);
	}
}
