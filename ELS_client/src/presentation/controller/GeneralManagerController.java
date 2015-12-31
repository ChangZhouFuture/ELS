package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import bean.JavaBean1;
import businesslogic.documentsbl.PaymentOrder;
import businesslogic.documentsbl.ReceivablesOrder;
import businesslogic.inforManagementbl.StaffInfor;
import businesslogic.userManagementbl.UserManagement;
import businesslogicservice.documentsblservice.PaymentOrderblservice;
import businesslogicservice.documentsblservice.ReceivablesOrderblservice;
import businesslogicservice.inforManagementblservice.StaffInforblservice;
import presentation.documentsui.PaymentOrderui.PaymentOrderui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderui;
import presentation.inforManagementui.Staffui.StaffListui;
import presentation.inforManagementui.Staffui.WageStrategyListui;
import presentation.inforManagementui.agencyui.AgencyListui;
import presentation.managerAndAccountantui.Approdocmui.DocmListui;
import presentation.managerAndAccountantui.Operalogui.OperalogListui;
import presentation.managerAndAccountantui.StatisAnalyui.StatisAnalyListui;
import presentation.reuse.EMSDialog;
import presentation.reuse.Skip;
import presentation.userManagementui.UserInfoui;
import presentation.userui.GeneralManagerui;
import state.ResultMessage;
import vo.documentsVO.PaymentOrderVO;
import vo.documentsVO.ReceivablesOrderVO;
import vo.inforManagementVO.SalaryStrategyVO;
import vo.userVO.UserVO;

public class GeneralManagerController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	GeneralManagerui generalManagerui;
	AgencyListui agencyListui;
	StaffListui staffListui;
	StatisAnalyListui statisAnalyListui;
	OperalogListui operalogListui;
	DocmListui docmListui;
	WageStrategyListui wageStrategyListui;
	ReceivablesOrderui receivablesOrderui;
	PaymentOrderui paymentOrderui;
	UserInfoui userInfoui;
	PaymentOrderblservice paymentOrderblservice;
	ReceivablesOrderblservice receivablesOrderblservice;
	StaffInforblservice staffInforblservice;
	PaymentOrderVO paymentOrderVO;
	ReceivablesOrderVO receivablesOrderVO;
	UserVO userVO;
	JavaBean1 javaBean1;
	
	public GeneralManagerController(){
		generalManagerui = new GeneralManagerui();
		docmListui = new DocmListui();
		docmListui.setLocation(0, 0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(docmListui);
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
				Skip.skip(mainPanel,childPanel);
			}
		});
		generalManagerui.wageStrategy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				wageStrategyListui=new WageStrategyListui();
				childPanel=wageStrategyListui;
				Skip.skip(mainPanel,childPanel);
			}
		});
		
	}
	public void inStatisAnalyListui(){
		statisAnalyListui.receivablesOrderTable.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent evt) {
	            if (evt.getClickCount() == 2) {
	               	String id=(String)statisAnalyListui.receivablesOrderTableModel.
	               			getValueAt(statisAnalyListui.receivablesOrderTable.getSelectedRow(),1);
	                receivablesOrderblservice=new ReceivablesOrder();
				    javaBean1=new JavaBean1();
				    javaBean1=receivablesOrderblservice.inquireA(id);
				    receivablesOrderVO=(ReceivablesOrderVO)javaBean1.getObject();
				    receivablesOrderui=finReceivablesOrder(receivablesOrderVO);
				    childPanel = receivablesOrderui;
				    Skip.skip(mainPanel,childPanel);
	            }
	       }
		});
		statisAnalyListui.paymentOrderTable.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	    String id=(String)statisAnalyListui.paymentOrderTableModel.
               			getValueAt(statisAnalyListui.paymentOrderTable.getSelectedRow(),1);
               	    paymentOrderblservice=new PaymentOrder();
               	    javaBean1=new JavaBean1();
   				    javaBean1=paymentOrderblservice.inquireA(id);
   					paymentOrderVO=(PaymentOrderVO)javaBean1.getObject();
   					paymentOrderui=findPaymentOrderinStatisAnalyListui(paymentOrderVO);
   					childPanel = paymentOrderui;
   					Skip.skip(mainPanel,childPanel);
                }
			}
       });
	}
	public PaymentOrderui findPaymentOrderinStatisAnalyListui(PaymentOrderVO paymentOrderVO){
		paymentOrderui=new PaymentOrderui();
		paymentOrderui.refresh();
		paymentOrderui.modify.setVisible(false);
		paymentOrderui.delete.setVisible(false);
		paymentOrderui.paymentMoneyField.setText(String.valueOf(paymentOrderVO.getAmount()));
		paymentOrderui.paymentPersonField.setText(paymentOrderVO.getPayer());
		paymentOrderui.paymentIdField.setText(paymentOrderVO.getBankAccount());
		switch(paymentOrderVO.getEntry()){
		case "运费（按次计算）":paymentOrderui.payType.setSelectedIndex(0);break;
		case "奖励（一次性）":paymentOrderui.payType.setSelectedIndex(1);break;
		case "人员工资（按月统计）":paymentOrderui.payType.setSelectedIndex(2);break;
		case "租金（按年收）":paymentOrderui.payType.setSelectedIndex(3);break;
		default:break;
		}
		paymentOrderui.remarksArea.setText(paymentOrderVO.getEntry());
		switch(paymentOrderVO.getApproState()){
		case Approve:paymentOrderui.approState.setText("已审批");break;
		case NotApprove:paymentOrderui.approState.setText("未审批");break;
			default:break;
		}
		paymentOrderui.docmID.setText(paymentOrderVO.getID());
		paymentOrderui.docmDate.setText(paymentOrderVO.getDate());
		return paymentOrderui;
	}
	public ReceivablesOrderui finReceivablesOrder(ReceivablesOrderVO receivablesOrderVO){
		receivablesOrderui=new ReceivablesOrderui();
		receivablesOrderui.refresh();
		receivablesOrderui.modify.setVisible(false);
		receivablesOrderui.delete.setVisible(false);
		receivablesOrderui.moneyField.setText(String.valueOf(receivablesOrderVO.getAmount()));
		receivablesOrderui.courierId.setText(receivablesOrderVO.getCourier());
		ArrayList<String> idList=new ArrayList<String>();
		idList=receivablesOrderVO.getOrderIDs();
		for(int i=0;i<idList.size();i++){
			receivablesOrderblservice=new ReceivablesOrder();
			receivablesOrderui.orderlineitemVO=receivablesOrderblservice.addOrder(idList.get(i));
			String[] oneRow={"",receivablesOrderui.orderlineitemVO.getId(),
					receivablesOrderui.orderlineitemVO.getSenderAdd(),
					receivablesOrderui.orderlineitemVO.getAddresseeAdd(),
					receivablesOrderui.orderlineitemVO.getExpressType().toString(),
					receivablesOrderui.orderlineitemVO.getGenerateDate()};
			receivablesOrderui.tableModel.addRow(oneRow);
		}
		switch(receivablesOrderVO.getApproState()){
		case Approve:receivablesOrderui.approState.setText("已审批");break;
		case NotApprove:receivablesOrderui.approState.setText("未审批");break;
			default:break;
		}
		receivablesOrderui.docmID.setText(receivablesOrderVO.getID());
		return receivablesOrderui;
	}
	public void inStaffListui(){
		staffListui.idFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				staffInforblservice=new StaffInfor();
           		javaBean1=new JavaBean1();
					javaBean1=staffInforblservice.inquireA(staffListui.idField.getText());
					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
						EMSDialog d=new EMSDialog();
						int n = d.showDialog(generalManagerui,"人员不存在",30);
					}
					userVO=(UserVO)javaBean1.getObject();
					userInfoui=findUser(userVO);
					childPanel = userInfoui;
					Skip.skip(mainPanel,childPanel);
			}
		});
		staffListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	String id=(String)staffListui.tableModel.
               			getValueAt(staffListui.table.getSelectedRow(),1);
               	try {
               		staffInforblservice=new StaffInfor();
               		javaBean1=new JavaBean1();
   					javaBean1=staffInforblservice.inquireA(id);
   					userVO=(UserVO)javaBean1.getObject();
   					userInfoui=findUser(userVO);
   					childPanel = userInfoui;
   					Skip.skip(mainPanel,childPanel);
   				} catch (Exception e2) {
   				}
               }
            }
       });
	}
	public UserInfoui findUser(UserVO userVO){
		userInfoui=new UserInfoui();
		userInfoui.refresh();
		userInfoui.delete.setVisible(false);
		userInfoui.modify.setVisible(false);
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
	public static void main(String[] args) {
		GeneralManagerController generalManagerController = new GeneralManagerController();
	}
}
