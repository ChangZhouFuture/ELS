package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bean.JavaBean1;
import businesslogic.orderbl.Order;
import businesslogic.userManagementbl.UserManagement;
import businesslogicservice.userManagementblservice.UserManagementblservice;
import presentation.orderui.OrderListui;
import presentation.reuse.EMSDialog;
import presentation.reuse.Skip;
import presentation.userManagementui.UserInfoui;
import presentation.userManagementui.UserListui;
import presentation.userui.Administratorui;
import state.ResultMessage;
import vo.orderVO.OrderVO;
import vo.userVO.UserVO;

public class AdministratorController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	Administratorui administratorui;
	UserListui userListui;
	UserInfoui userInfoui;
	UserVO userVO;
	UserManagementblservice userManagementblservice;
	JavaBean1 javaBean1;
	
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
	public void inUserListui(){
		userListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userInfoui = new UserInfoui();
				childPanel = userInfoui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inUserInfoui();
			}
		});
		userListui.idFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userManagementblservice=new UserManagement();
           		javaBean1=new JavaBean1();
					javaBean1=userManagementblservice.inquireA(userListui.idField.getText());
					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
						EMSDialog d=new EMSDialog();
						int n = d.showDialog(administratorui,"订单不存在",30);
					}
					userVO=(UserVO)javaBean1.getObject();
					userInfoui=findUser(userVO);
					childPanel = userInfoui;
					Skip.skip(mainPanel,childPanel);
					inUserInfoui();
			}
		});
		userListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	String id=(String)userListui.tableModel.
               			getValueAt(userListui.table.getSelectedRow(),1);
               	try {
               		userManagementblservice=new UserManagement();
               		javaBean1=new JavaBean1();
   					javaBean1=userManagementblservice.inquireA(id);
   					userVO=(UserVO)javaBean1.getObject();
   					userInfoui=findUser(userVO);
   					childPanel = userInfoui;
   					Skip.skip(mainPanel,childPanel);
   					inUserInfoui();
   				} catch (Exception e2) {
   				}
               }
            }
       });
	}
	public UserInfoui findUser(UserVO userVO){
		userInfoui=new UserInfoui();
		userInfoui.refresh();
		userInfoui.userVO=userVO;
		userInfoui.nameField.setText(userVO.getName());
		userInfoui.passwordField.setText(userVO.getPassword());
		userInfoui.birthDateField.setText(userVO.getBirthDate());
		userInfoui.identyNumField.setText(userVO.getIdentyNum());
		userInfoui.phoneField.setText(userVO.getPhone());
		userInfoui.cityField.setText(userVO.getCity());
		userInfoui.regionField.setText(userVO.getRegion());
		userInfoui.agencyIDField.setText(userVO.getAgencyID());
		switch(userVO.getGender()){
		case MALE:userInfoui.sexType.setSelectedIndex(0);break;
		case FEMALE:userInfoui.sexType.setSelectedIndex(1);break;
		default:break;
		}
		switch(userVO.getPosition()){
		case Courier:userInfoui.positionSeleted.setSelectedIndex(0);break;
		case BusiHallClerk:userInfoui.positionSeleted.setSelectedIndex(1);break;
		case TranCenClerk:userInfoui.positionSeleted.setSelectedIndex(2);break;
		case StockManager:userInfoui.positionSeleted.setSelectedIndex(3);break;
		case Accountant2:userInfoui.positionSeleted.setSelectedIndex(4);break;
		case Accountant1:userInfoui.positionSeleted.setSelectedIndex(5);break;
		case GeneralManager:userInfoui.positionSeleted.setSelectedIndex(6);break;
		case Administrator:userInfoui.positionSeleted.setSelectedIndex(7);break;
		default:break;
		}
		userInfoui.docmID.setText(userVO.getId());
		return userInfoui;
	}
	public void inUserInfoui() {
		userInfoui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EMSDialog d=new EMSDialog();
				int n = d.showDialog(administratorui, "确认删除?",30);  
		        if (n == 1) {
				    String deleteId=userInfoui.docmID.getText();
				    ArrayList<String> deletearray=new ArrayList<String>();;
				    deletearray.add(deleteId);
				    userManagementblservice=new UserManagement();
				    userManagementblservice.deleteMany(deletearray);
				    userListui = new UserListui();
				    childPanel = userListui;
				    Skip.skip(mainPanel,childPanel);
				    inUserListui();
		        }else if(n==0){
		        }
			}
		});
	}
	public static void main(String[] args) {
		AdministratorController administratorController = new AdministratorController();
	}
}
