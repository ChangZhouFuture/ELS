package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderui;
import presentation.inforManagementui.Staffui.StaffListui;
import presentation.inforManagementui.agencyui.AgencyListui;
import presentation.managerAndAccountantui.Approdocmui.DocmListui;
import presentation.managerAndAccountantui.Operalogui.OperalogListui;
import presentation.managerAndAccountantui.StatisAnalyui.StatisAnalyListui;
import presentation.reuse.Skip;
import presentation.userManagementui.UserInfoui;
import presentation.userui.GeneralManagerui;

public class GeneralManagerController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	GeneralManagerui generalManagerui;
	AgencyListui agencyListui;
	StaffListui staffListui;
	StatisAnalyListui statisAnalyListui;
	OperalogListui operalogListui;
	DocmListui docmListui;
	
	public GeneralManagerController(){
		generalManagerui = new GeneralManagerui();
		agencyListui = new AgencyListui();
		agencyListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(agencyListui);
		JLayeredPane layeredPane = generalManagerui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inAdministratorui();
	}
	public void inAdministratorui() {
		generalManagerui.agencyManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				agencyListui = new AgencyListui();
				childPanel = agencyListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		generalManagerui.stuffManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				staffListui = new StaffListui();
				childPanel = staffListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		generalManagerui.statisAnaly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				statisAnalyListui = new StatisAnalyListui();
				childPanel = statisAnalyListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		generalManagerui.approdocm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				docmListui = new DocmListui();
				childPanel = docmListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});generalManagerui.operalog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operalogListui = new OperalogListui();
				childPanel = operalogListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
	}
	public static void main(String[] args) {
		GeneralManagerController generalManagerController = new GeneralManagerController();
	}
}
