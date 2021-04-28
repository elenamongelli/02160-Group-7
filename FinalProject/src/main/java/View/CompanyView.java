package View;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.CompanyController;

public class CompanyView extends JFrame {

	private static final long serialVersionUID = 1L;
	private CompanyController controller;

	public CompanyView(CompanyController controller) {
		this.controller = controller;
		openGUICompany();
		
	}

	private void openGUICompany() {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(900, 600));
		frame.setTitle("Company page");
		frame.setLayout(new GridBagLayout());
		
		JButton btnRegisterClient = new JButton("Register new client");
		btnRegisterClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.popupRegisterClient();
			}
		});
		JButton btnFindInfo = new JButton("Find client information");
		btnFindInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.popupFindInfo();
			}
		});
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.logout();
			}
		});
		
		
	}


}
