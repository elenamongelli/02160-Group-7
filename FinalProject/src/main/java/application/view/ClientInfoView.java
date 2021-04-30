package application.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import application.controller.ContainerHistoryController;
import application.controller.ClientsManagementController;
import application.model.Session;
import application.utils.GridBagLayoutUtils;

public class ClientInfoView extends JFrame {

	private static final long serialVersionUID = 1L;

	private ClientsManagementController controller;

	public ClientInfoView(ClientsManagementController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {				
		setTitle("Find client information");
		setSize(400, 400);
		setResizable(false);
		setLayout(new GridBagLayout());
		
		JTextField clientNameField = new JTextField(10);
		JTextField emailField = new JTextField(10);			
		JButton btnSubmit = new JButton("Submit");
		
		add(new JLabel("Name:"), GridBagLayoutUtils.constraint(0, 0, 3));
		add(clientNameField, GridBagLayoutUtils.constraint(1, 0, 3));
	
		add(new JLabel("Email:"), GridBagLayoutUtils.constraint(0, 1, 3));
		add(emailField, GridBagLayoutUtils.constraint(1, 1, 3));
		
		add(btnSubmit,GridBagLayoutUtils.constraint(1, 2, 3));		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Add arguments
				controller.manageClientContainers(clientNameField.getText());
				setVisible(false);
			}
		});
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
