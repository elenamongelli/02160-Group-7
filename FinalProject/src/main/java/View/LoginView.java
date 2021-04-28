package View;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.LoginController;
import Utilities.LayoutUtils;

public class LoginView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel userLabelName;
	private JTextField userTextName;
	private JButton buttonLogin;
	private LoginController controller;
	
	public LoginView(LoginController controller) {
		this.controller = controller;
		openGUI();
	}

	private void openGUI() {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(900, 600));
		frame.setTitle("Login");
		frame.setLayout(new GridBagLayout());
		
		userLabelName = new JLabel("Username");

		userTextName = new JTextField(15);
		userTextName.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if (keyChar == KeyEvent.VK_ENTER) {
					controller.checkUserName(userTextName.getText());	
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {	
			}
			@Override
			public void keyReleased(KeyEvent e) {	
			}
		});
		buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.checkUserName(userTextName.getText());		
			}	
		});
		
		frame.add(userLabelName, LayoutUtils.constraint(0, 0, 5, "left"));
		frame.add(userTextName, LayoutUtils.constraint(0, 1, 5, null));
		frame.add(buttonLogin, LayoutUtils.constraint(0, 2, 5, null));
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		
	}
	
	public void WrongLogin() {
		JOptionPane.showMessageDialog(null, controller, "Login error", JOptionPane.ERROR_MESSAGE);
	}

}
