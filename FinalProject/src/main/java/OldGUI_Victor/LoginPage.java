package OldGUI_Victor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage implements ActionListener, KeyListener {
	
	private static JLabel userLabelName;
	private static GridBagConstraints gbc;
	private static JTextField userTextName;
	private static JLabel userLabelPW;
	private static JTextField userTextPW;
	private static JButton buttonLogin;
	private static JFrame frame;
	private static String userName;	
	
	public static void main(String[] args) {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setSize(new Dimension(900,600));
		panel.setBackground(Color.DARK_GRAY);
		
		gbc = new GridBagConstraints();
		
		userLabelName = new JLabel("Username");
		userLabelName.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 5, 0);
		panel.add(userLabelName, gbc);
		
		userTextName = new JTextField(15);
		userTextName.addKeyListener(new LoginPage());
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 15, 0);
		panel.add(userTextName, gbc);
		
		userLabelPW = new JLabel("Password");
		userLabelPW.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 5, 0);
		panel.add(userLabelPW, gbc);
		
		userTextPW = new JTextField(15);
		//userTextPW.addKeyListener(new LoginPage());
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 15, 0);
		panel.add(userTextPW, gbc);
		
		buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new LoginPage());
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(10, 25, 0, 25);
		panel.add(buttonLogin, gbc);
		
		
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setUserName(userTextName.getText());
		if (ClientList.isAdmin(userName)) {
			frame.setVisible(false);
			CompanyLogin.main(null);
		} else if (ClientList.isClient(userName)) {
			frame.setVisible(false);
			ClientLogin.main(null);
		} 
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int keyChar = e.getKeyChar();
		if (keyChar == KeyEvent.VK_ENTER) {
			setUserName(userTextName.getText());
			if (ClientList.isAdmin(userName)) {
				frame.setVisible(false);
				CompanyLogin.main(null);
			} else if (ClientList.isClient(userName)) {
				frame.setVisible(false);
				ClientLogin.main(null);
			} 
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {	
	}

	@Override
	public void keyReleased(KeyEvent e) {	
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		LoginPage.userName = userName;
	}



}
