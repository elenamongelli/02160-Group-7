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
import application.model.Session;
import application.utils.GridBagLayoutUtils;

public class NewContainerHistoryView extends JFrame {

	private static final long serialVersionUID = 1L;

	private ContainerHistoryController controller;

	public NewContainerHistoryView(ContainerHistoryController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {				
		setTitle("Register container history");
		setSize(400, 400);
		setResizable(false);
		setLayout(new GridBagLayout());
		
		JTextField journeyIDField = new JTextField(10);
		JTextField dateField = new JTextField(10);
		JTextField positionField = new JTextField(10);
		JTextField temperatureField = new JTextField(10);
		JTextField humidityField = new JTextField(10);
		JTextField pressureField = new JTextField(10);				
		JButton btnSubmit = new JButton("Submit");
		
		add(new JLabel("journeyID:"), GridBagLayoutUtils.constraint(0, 0, 7));
		add(journeyIDField, GridBagLayoutUtils.constraint(1, 0, 7));
	
		add(new JLabel("date:"), GridBagLayoutUtils.constraint(0, 1, 7));
		add(dateField, GridBagLayoutUtils.constraint(1, 1, 7));
	
		add(new JLabel("position:"), GridBagLayoutUtils.constraint(0, 2, 7));
		add(positionField, GridBagLayoutUtils.constraint(1, 2, 7));
	
		add(new JLabel("temperature:"), GridBagLayoutUtils.constraint(0, 3, 7));
		add(temperatureField, GridBagLayoutUtils.constraint(1, 3, 7));
	
		add(new JLabel("humidity:"), GridBagLayoutUtils.constraint(0, 4, 7));
		add(humidityField, GridBagLayoutUtils.constraint(1, 4, 7));
	
		add(new JLabel("pressure:"), GridBagLayoutUtils.constraint(0, 5, 7));
		add(pressureField, GridBagLayoutUtils.constraint(1, 5, 7));
	
		add(btnSubmit,GridBagLayoutUtils.constraint(1, 6, 7));		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addHistoryRowController(journeyIDField.getText(), dateField.getText(), 
						positionField.getText(), temperatureField.getText(), humidityField.getText(), pressureField.getText());
				setVisible(false);
			}
		});
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
