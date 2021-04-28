package OldGUI_Victor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompanyLogin implements ActionListener {
	
	
	private static JFrame frame;
	private static GridBagConstraints gbc;
	private static JLabel labelUserName;
	private static JButton buttonRegisterClients;
	private static JButton buttonFindClientInfo;
	private static JButton buttonLogout;
	
	public static void main(String[] args) {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setSize(new Dimension(900,600));
		panel.setBackground(Color.DARK_GRAY);
		
		gbc = new GridBagConstraints();
						
		String userName = LoginPage.getUserName();
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		labelUserName = new JLabel("User: " + userName);
		labelUserName.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 50, 0);
		panel.add(labelUserName, gbc);

		
		setButtonRegisterClients(new JButton("Register new client"));
		buttonRegisterClients = getButtonRegisterClients();
		buttonRegisterClients.addActionListener(new CompanyLogin());
		buttonRegisterClients.setPreferredSize(new Dimension(150, 40));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 60, 0, 60);
		panel.add(buttonRegisterClients, gbc);
		
		setButtonFindClientInfo(new JButton("Find client information"));	
		buttonFindClientInfo = getButtonFindClientInfo();
		buttonFindClientInfo.addActionListener(new CompanyLogin());
		buttonFindClientInfo.setPreferredSize(new Dimension(150, 40));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 60, 0, 60);
		panel.add(buttonFindClientInfo, gbc);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.addActionListener(new CompanyLogin());
		buttonLogout.setPreferredSize(new Dimension(160, 30));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(50, 200, 0, 200);
		panel.add(buttonLogout, gbc);
			
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Logout") {
			frame.setVisible(false);
			LoginPage.main(null);
		} else if (e.getActionCommand() == "Register new client") {
			RegisterNewClient.main(null);
		} else if (e.getActionCommand() == "Find client information") {
			System.out.println("bb");
			FindClientInfo.main(null);
		}		
	}

	public static JButton getButtonRegisterClients() {
		return buttonRegisterClients;
	}
	public static void setButtonRegisterClients(JButton buttonRegisterClients) {
		CompanyLogin.buttonRegisterClients = buttonRegisterClients;
	}
	
	public static JButton getButtonFindClientInfo() {
		return buttonFindClientInfo;
	}
	public static void setButtonFindClientInfo(JButton buttonFindClientInfo) {
		CompanyLogin.buttonFindClientInfo = buttonFindClientInfo;
	}
}
