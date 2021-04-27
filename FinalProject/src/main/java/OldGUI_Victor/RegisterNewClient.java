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
import javax.swing.JTextField;


public class RegisterNewClient implements ActionListener {
	
	private static JFrame frame;
	private static GridBagConstraints gbc;
	
	private static JLabel labelTopInformation;

	private static JLabel clientNameLabel;
	private static JTextField clientNameText;
	public static String clientNameString;
	
	private static JLabel addressLabel;
	private static JTextField addressText;
	public static String addressString;
	
	private static JLabel referencePersonLabel;
	private static JTextField referencePersonText;
	public static String referencePersonString;
	
	private static JLabel emailLabel;
	private static JTextField emailText;
	public static String emailString;
	
	private static JButton buttonRegister;
	
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
		
		addressLabel = new JLabel("Address");
		addressLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 5, 0);
		panel.add(addressLabel, gbc);
		
		addressText = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 15, 0);
		panel.add(addressText, gbc);
		
		referencePersonLabel = new JLabel("Reference Person");
		referencePersonLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(0, 0, 5, 0);
		panel.add(referencePersonLabel, gbc);
		
		referencePersonText = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 15, 0);
		panel.add(referencePersonText, gbc);
		
		emailLabel = new JLabel("Email Adress");
		emailLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.insets = new Insets(0, 0, 5, 0);
		panel.add(emailLabel, gbc);
		
		emailText = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 15, 0);
		panel.add(emailText, gbc);
					
		buttonRegister = new JButton("Register");
		buttonRegister.addActionListener(new RegisterNewClient());
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.insets = new Insets(15, 65, 0, 65);
		panel.add(buttonRegister, gbc);
		
		frame.add(panel);
		frame.setLocation(CompanyLogin.getButtonRegisterClients().getLocationOnScreen());
		frame.setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		setclientName(clientNameText.getText());
		setaddressName(addressText.getText());
		setreferencePersonName(referencePersonText.getText());
		setemailName(emailText.getText());
		
//		System.out.println(clientNameText.getText());
//		System.out.println(adressText.getText());
//		System.out.println(referencePersonText.getText());
//		System.out.println(emailText.getText());
	}

	public static void setclientName(String clientNameString) {
		RegisterNewClient.clientNameString = clientNameString;
	}
	
	private void setaddressName(String addressString) {
		RegisterNewClient.addressString = addressString;		
	}

	private void setreferencePersonName(String referencePersonString) {
		RegisterNewClient.referencePersonString = referencePersonString;
	}
	
	private void setemailName(String emailString) {
		RegisterNewClient.emailString = emailString;		
	}
	
	
	
}
