package view.admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.users.User;
import view.normal.CheckMaterialPanel;
import view.normal.CheckMaterialPanel.CheckMaterialButtonListener;

@SuppressWarnings("serial")
public class AdminViewPanel extends JPanel {
	
	private static final String PANEL_NAME = "'s view";
	private static final String PENALIZE_TEXT = "Penalizar";
	private static final String EXTRACT_TEXT = "Extraer";
	private static final String RETURN_TEXT = "Devolver";
	private static final String RESERVE_CLASS_TEXT = "Reservar Aula";
	private static final String RESERVE_LAB_TEXT = "Reservar Laboratorio";

	private JButton penalize;
	private JButton extractMaterial;
	private JButton returnMaterial;
	private JButton reserveClassroom;
	private JButton reserveLaboratory;
	private CheckMaterialPanel checkMaterialPanel;

	public interface PenalizeButtonListener {
		void penalizeButtonClicked();
	}

	public interface ExtractMaterialButtonListener {
		void extractMaterialButtonClicked();
	}

	public interface ReturnMaterialButtonListener {
		void returnMaterialButtonClicked();
	}

	public interface ReserveClassroomButtonListener {
		void reserveClassroomButtonClicked();
	}

	public interface ReserveLaboratoryButtonListener {
		void reserveLaboratoryButtonClicked();
	}

	public AdminViewPanel(User user,
			PenalizeButtonListener penalizeButtonListener,
			ExtractMaterialButtonListener extractMaterialButtonListener,
			ReturnMaterialButtonListener returnMaterialButtonListener,
			ReserveClassroomButtonListener reserveClassroomButtonListener,
			ReserveLaboratoryButtonListener reserveLaboratoryButtonListener,
			CheckMaterialButtonListener checkMaterialButtonListener) {

		super(new GridLayout(6, 1));
		
		this.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(),
				user.getId() + PANEL_NAME));
		
		this.penalize = new JButton(PENALIZE_TEXT);
		this.extractMaterial = new JButton(EXTRACT_TEXT);
		this.returnMaterial = new JButton(RETURN_TEXT);
		this.reserveClassroom = new JButton(RESERVE_CLASS_TEXT);
		this.reserveLaboratory = new JButton(RESERVE_LAB_TEXT);

		this.checkMaterialPanel = new CheckMaterialPanel(user, checkMaterialButtonListener);

		this.penalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				penalizeButtonListener.penalizeButtonClicked();
			}
		});

		this.extractMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				extractMaterialButtonListener.extractMaterialButtonClicked();
			}
		});

		this.returnMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnMaterialButtonListener.returnMaterialButtonClicked();
			}
		});

		this.reserveClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserveClassroomButtonListener.reserveClassroomButtonClicked();
			}
		});

		this.reserveLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserveLaboratoryButtonListener
						.reserveLaboratoryButtonClicked();
			}
		});

		this.add(penalize);
		this.add(extractMaterial);
		this.add(returnMaterial);
		this.add(reserveClassroom);
		this.add(reserveLaboratory);
		this.add(checkMaterialPanel);
	}
}
