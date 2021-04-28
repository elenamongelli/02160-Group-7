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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//TO DO: error messages
//		control if input if correct

public class FindClientInfo implements ActionListener, KeyListener {
	
	private static JFrame frame;
	private static GridBagConstraints gbc;
	
	private static JLabel labelTopInformation;
	
	private static JLabel clientNameLabel;
	private static JTextField clientNameText;
	private static String clientNameString;
	
	private static JLabel emailLabel;
	private static JTextField emailText;
	private static String emailString;
	
	private static JButton buttonFind;
	
	public static void main(String[] args) {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(new Dimension(450,500));
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setSize(new Dimension(450,500));
		panel.setBackground(Color.DARK_GRAY);
		
		gbc = new GridBagConstraints();
		
		labelTopInformation = new JLabel("Please fill all text fields");
		labelTopInformation.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		panel.add(labelTopInformation, gbc);
		
		clientNameLabel = new JLabel("Client Name");
		clientNameLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 5, 0);
		panel.add(clientNameLabel, gbc);
		
		clientNameText = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 15, 0);
		panel.add(clientNameText, gbc);
				
		emailLabel = new JLabel("Email address");
		emailLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 5, 0);
		panel.add(emailLabel, gbc);
		
		emailText = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 15, 0);
		panel.add(emailText, gbc);
					
		buttonFind = new JButton("Find");
		buttonFind.addActionListener(new FindClientInfo());
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(15, 65, 0, 65);
		panel.add(buttonFind, gbc);
		
		frame.add(panel);
		frame.setLocation(CompanyLogin.getButtonFindClientInfo().getLocationOnScreen());
		frame.setVisible(true);
	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		setclientName(clientNameText.getText());
		setemailName(emailText.getText());
		
		if (clientNameString.equals("Oscar")) {
			frame.setVisible(false);
			ContainerClientPage.main(null);
		}
		
//		System.out.println(clientNameText.getText());
//		System.out.println(emailText.getText());
	}
	
	public static void setclientName(String clientNameString) {
		FindClientInfo.clientNameString = clientNameString;
	}
	
	private void setemailName(String emailString) {
		FindClientInfo.emailString = emailString;		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public static String getEmailString() {
		return emailString;
	}


	public static void setEmailString(String emailString) {
		FindClientInfo.emailString = emailString;
	}
	
}

