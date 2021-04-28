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

public class ClientLogin implements ActionListener {
	
	
	private static JFrame frame;
	private static GridBagConstraints gbc;
	private static JLabel labelUserName;
	private static JButton buttonRegisterContainer;
	private static JButton buttonUpdateInfo;
	private static JButton buttonAddViewer;
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
		
		labelUserName = new JLabel("User: " + userName);
		labelUserName.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 50, 0);
		panel.add(labelUserName, gbc);
		
		setButtonRegisterContainer(new JButton("Register new client"));
		buttonRegisterContainer = getButtonRegisterContainer();
		buttonRegisterContainer.addActionListener(new ClientLogin());
		buttonRegisterContainer.setPreferredSize(new Dimension(150, 40));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 60, 0, 60);
		panel.add(buttonRegisterContainer, gbc);
		
		setButtonUpdateInfo(new JButton("Update information"));
		buttonUpdateInfo = getButtonUpdateInfo();
		buttonUpdateInfo.addActionListener(new ClientLogin());
		buttonUpdateInfo.setPreferredSize(new Dimension(150, 40));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 60, 0, 60);
		panel.add(buttonUpdateInfo, gbc);
		
		setButtonAddViewer(new JButton("Add viewer"));
		buttonAddViewer = getButtonAddViewer();
		buttonAddViewer.addActionListener(new ClientLogin());
		buttonAddViewer.setPreferredSize(new Dimension(150, 40));
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 60, 0, 60);
		panel.add(buttonAddViewer, gbc);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.addActionListener(new ClientLogin());
		buttonLogout.setPreferredSize(new Dimension(160, 30));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
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
		}		
	}
	public static JButton getButtonRegisterContainer() {
		return buttonRegisterContainer;
	}
	public static void setButtonRegisterContainer(JButton buttonRegisterContainer) {
		ClientLogin.buttonRegisterContainer = buttonRegisterContainer;
	}
	
	public static JButton getButtonUpdateInfo() {
		return buttonUpdateInfo;
	}
	public static void setButtonUpdateInfo(JButton buttonUpdateInfo) {
		ClientLogin.buttonUpdateInfo = buttonUpdateInfo;
	}
	
	public static JButton getButtonAddViewer() {
		return buttonAddViewer;
	}
	public static void setButtonAddViewer(JButton buttonAddViewer) {
		ClientLogin.buttonAddViewer = buttonAddViewer;
	}
}
