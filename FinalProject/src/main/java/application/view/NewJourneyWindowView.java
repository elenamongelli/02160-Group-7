package application.view;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import application.model.facades.JourneyApp;
import application.utils.GridBagLayoutUtils;

public class NewJourneyWindowView extends JFrame {
	private JButton btnsubmit;
	private JTextField txtUser;
	private JTextField txtOrigin;
	private JTextField txtDestination;
	private JTextField txtContent;
	
	JourneyApp journeyApp = JourneyApp.getInstance();
	
	private void initGUI() {
		setResizable(false);
		setTitle("New journey");
		setLayout(new GridBagLayout());
		
		txtUser = new JTextField(15);
		txtOrigin = new JTextField(15);
		txtDestination = new JTextField(15);
		txtContent = new JTextField(15);
		btnsubmit = new JButton("Submit");
		
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				journeyApp.newJourney(txtUser.getText(), txtOrigin.getText(), txtDestination.getText(), txtContent.getText());
			}
		});
		
		add(new JLabel("User:"), GridBagLayoutUtils.constraint(0, 0, 5));
		add(txtUser, GridBagLayoutUtils.constraint(1, 0, 5));
		add(new JLabel("Origin:"), GridBagLayoutUtils.constraint(0, 1, 5));
		add(txtOrigin, GridBagLayoutUtils.constraint(1, 1, 5));
		add(new JLabel("Destination:"), GridBagLayoutUtils.constraint(0, 1, 5));
		add(txtDestination, GridBagLayoutUtils.constraint(1, 1, 5));
		add(new JLabel("Destination:"), GridBagLayoutUtils.constraint(0, 1, 5));
		add(txtContent, GridBagLayoutUtils.constraint(1, 1, 5));
		add(btnsubmit, GridBagLayoutUtils.constraint(1, 2, 5));
		
		pack();
		setLocationRelativeTo(null);
	}
	
}
