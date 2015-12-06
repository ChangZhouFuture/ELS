package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import presentation.reuse.Skip;
import presentation.userManagementui.UserInfoui;
import presentation.userManagementui.UserListui;
import presentation.userui.Administratorui;

public class AdministratorController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	Administratorui administratorui;
	UserListui userListui;
	UserInfoui userInfoui;
	
	public AdministratorController(){
		administratorui = new Administratorui();
		userListui = new UserListui();
		userListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(userListui);
		JLayeredPane layeredPane = administratorui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inAdministratorui();
		inUserListui();
	}
	public void inAdministratorui() {
		administratorui.userManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userListui = new UserListui();
				childPanel = userListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inUserListui();
			}
		});
	}
	public void inUserListui() {
		
	}
	public static void main(String[] args) {
		AdministratorController administratorController = new AdministratorController();
	}
}
