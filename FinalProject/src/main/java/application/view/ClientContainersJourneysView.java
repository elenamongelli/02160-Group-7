package application.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import application.controller.ClientContainersJourneysController;
import application.model.Session;

public class ClientContainersJourneysView extends JFrame {

	private static final long serialVersionUID = 989075282041187452L;
	private ClientContainersJourneysController controller;
	private JTable tblClientContainersJourneys;
	private JLabel lblSession;
	
	public ClientContainersJourneysView(ClientContainersJourneysController controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Client Containers Journeys");
		setPreferredSize(new Dimension(800, 600));
		
		// buttons		
		JButton btnExpand = new JButton("Expand selected item");
		btnExpand.setEnabled(false);
		btnExpand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.expandItem(tblClientContainersJourneys.getSelectedRow());
			}
		});
		
		// toolbar
		lblSession = new JLabel();
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JToolBar toolbar = new JToolBar();
		toolbar.add(btnExpand);
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(lblSession);
		add(toolbar, BorderLayout.NORTH);
		
		// table
		tblClientContainersJourneys = new JTable();
		tblClientContainersJourneys.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblClientContainersJourneys.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnExpand.setEnabled((tblClientContainersJourneys.getSelectedRow() >= 0));
			}
		});
		add(new JScrollPane(tblClientContainersJourneys), BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public void setTableModel(TableModel model) {
		tblClientContainersJourneys.setModel(model);
	}

	public void setSession(Session sessionModel) {
		lblSession.setText("<html>" + sessionModel.getUsername() + " <i>(" + sessionModel.getRole() + ")</i></html>");
	}
}
