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
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import application.controller.ClientsManagementController;
import application.model.Session;
import application.model.facades.AdminApp;
import application.utils.GridBagLayoutUtils;

public class ClientsManagementView extends JFrame {

	private static final long serialVersionUID = 989075282041187452L;
	private ClientsManagementController controller;
	private JTable tblClients;
	private JLabel lblSession;
	private NewClientView newClientView;
	private ClientInfoView clientInfoView;
	private JTextField txtFilter;
	private TableRowSorter<AdminApp> sorter;

	public ClientsManagementView(ClientsManagementController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Inventory Manager");
		setPreferredSize(new Dimension(800, 600));

		// buttons
		JButton btnRegister = new JButton("Register new client");

		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newClientView = new NewClientView();
			}
		});

		JButton btnGet = new JButton("Get client information");

		btnGet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clientInfoView = new ClientInfoView(controller);
			}
		});

		// toolbar
		lblSession = new JLabel();
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
			
		JToolBar toolbar = new JToolBar();
				
		toolbar.add(btnRegister);
		toolbar.add(btnGet);
		toolbar.add(Box.createHorizontalGlue());
	
		JLabel lblFilter = new JLabel();
		lblFilter.setText("Filter by company name or email:");
		txtFilter = new JTextField(15);
		toolbar.add(lblFilter);
		toolbar.add(txtFilter);
		
		toolbar.add(lblSession);
	
		add(toolbar, BorderLayout.NORTH);
				
		// table
		tblClients = new JTable();
		//tblClients.setAutoCreateRowSorter(true);

		sorter = new TableRowSorter<AdminApp>(AdminApp.getInstance());
		tblClients.setRowSorter(sorter);
		
		tblClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		txtFilter.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter();
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter();
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter();
			}
		});

		add(new JScrollPane(tblClients), BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void newFilter() {
		RowFilter<AdminApp, Object> rf = null;
		
		// If current expression doesn't parse, don't update.
		try {	
			rf = RowFilter.regexFilter("(?i)" + txtFilter.getText(), 0, 1); // Filter by company name or email
		} catch (java.util.regex.PatternSyntaxException exception) {
			return;
		}
		sorter.setRowFilter(rf);
	}
	

	public void setTableModel(TableModel model) {
		tblClients.setModel(AdminApp.getInstance());
	}

	public void setSession(Session sessionModel) {
		lblSession.setText("<html>" + sessionModel.getUsername() + " <i>(" + sessionModel.getRole() + ")</i></html>");
	}
}
