package application.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JLabel lblClientName;
	private JLabel lblSession;

	public ClientContainersJourneysView(ClientContainersJourneysController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
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

		lblClientName = new JLabel();
		lblClientName.setHorizontalAlignment(SwingConstants.RIGHT);

		lblSession = new JLabel();
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);

		JToolBar toolbar = new JToolBar();
		toolbar.add(btnExpand);
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(lblClientName);
		
		JLabel lblInfo = new JLabel();
		lblInfo.setText(", Double click on a cell to edit value");
		toolbar.add(lblInfo);
		
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

		tblClientContainersJourneys.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) {
					int rowIndex = tblClientContainersJourneys.getSelectedRow();
					int colIndex = tblClientContainersJourneys.getSelectedColumn();
					String newValue = JOptionPane.showInputDialog("Please insert new value:");
					controller.updateField(newValue,rowIndex,colIndex);
				}
			}
		});

		pack();
		setLocationRelativeTo(null);
	}

	public void setTableModel(TableModel model, String clientName) {
		tblClientContainersJourneys.setModel(model);
		lblClientName.setText("<html> Client " + clientName + "</i></html>");
	}

	public void setSession(Session sessionModel) {
		lblSession.setText("<html>" + sessionModel.getUsername() + " <i>(" + sessionModel.getRole() + ")</i></html>");
	}
}
