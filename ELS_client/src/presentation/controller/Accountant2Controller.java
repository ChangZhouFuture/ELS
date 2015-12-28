package presentation.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import bean.JavaBean1;
import presentation.documentsui.PaymentOrderui.PaymentOrderListui;
import presentation.documentsui.PaymentOrderui.PaymentOrderui;
import presentation.documentsui.ReceivablesOrderui.ReceivablesOrderui;
import presentation.documentsui.ReceivablesOrderui.SettlementListui;
import presentation.inforManagementui.BankAccountui.BankAccountui;
import presentation.managerAndAccountantui.Operalogui.OperalogListui;
import presentation.managerAndAccountantui.StatisAnalyui.StatisAnalyListui;
import presentation.reuse.Skip;
import presentation.userui.Accountantui1;
import state.ResultMessage;
import vo.documentsVO.PaymentOrderVO;
import vo.documentsVO.ReceivablesOrderVO;
import businesslogic.documentsbl.PaymentOrder;
import businesslogic.documentsbl.ReceivablesOrder;
import businesslogicservice.documentsblservice.PaymentOrderblservice;
import businesslogicservice.documentsblservice.ReceivablesOrderblservice;

public class Accountant2Controller {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	Accountantui1 accountantui;
	SettlementListui settlementListui;
	PaymentOrderListui paymentOrderListui;
	StatisAnalyListui statisAnalyListui;
	OperalogListui operalogListui;
	ReceivablesOrderui receivablesOrderui;
	PaymentOrderui paymentOrderui;
	BankAccountui bankAccountui;
	PaymentOrderblservice paymentOrderblservice;
	ReceivablesOrderblservice receivablesOrderblservice;
	PaymentOrderVO paymentOrderVO;
	ReceivablesOrderVO receivablesOrderVO;
	JavaBean1 javaBean1;
	JButton totalAmount=new JButton();
	JTextField totalAmountField=new JTextField();
	Font font3=new Font("TimesRoman",Font.PLAIN,15);
	
	public Accountant2Controller(){
		accountantui = new Accountantui1();
		accountantui.bankAccount.setVisible(false);
		settlementListui = new SettlementListui();
		settlementListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(settlementListui);
		JLayeredPane layeredPane = accountantui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inAccountant2ui();
		inSettlementListui();
	}
	public void inAccountant2ui() {
		accountantui.receival.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				settlementListui = new SettlementListui();
				childPanel = settlementListui;
				Skip.skip(mainPanel,childPanel);
				inSettlementListui();
			}
		});
		accountantui.payment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentOrderListui = new PaymentOrderListui();
				childPanel = paymentOrderListui;
				Skip.skip(mainPanel,childPanel);
				inPaymentOrderListui();
			}
		});
		accountantui.statisAnaly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				statisAnalyListui = new StatisAnalyListui();
				childPanel = statisAnalyListui;
				Skip.skip(mainPanel,childPanel);
			}
		});
		accountantui.operalog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				operalogListui = new OperalogListui();
				childPanel = operalogListui;
				Skip.skip(mainPanel,childPanel);
			}
		});
	}
	public void inPaymentOrderListui(){
		paymentOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentOrderui=new PaymentOrderui();
				childPanel=paymentOrderui;
				Skip.skip(mainPanel,childPanel);
				inPaymentOrderui();
			}
		});
		paymentOrderListui.idFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentOrderblservice=new PaymentOrder();
					javaBean1=new JavaBean1();
					javaBean1=paymentOrderblservice.inquireA(paymentOrderListui.idField.getText());
					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
						JOptionPane.showMessageDialog(null, "订单不存在", "错误", JOptionPane.ERROR_MESSAGE);
					}
					paymentOrderVO=(PaymentOrderVO)javaBean1.getObject();
					paymentOrderui=findPaymentOrder(paymentOrderVO);
					childPanel = paymentOrderui;
					Skip.skip(mainPanel,childPanel);
					inPaymentOrderui();
			}
		});
		paymentOrderListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                	String id=(String)paymentOrderListui.tableModel.
                			getValueAt(paymentOrderListui.table.getSelectedRow(),1);
                	try {
                		paymentOrderblservice=new PaymentOrder();
                		javaBean1=new JavaBean1();
    					javaBean1=paymentOrderblservice.inquireA(id);
    					if(javaBean1.getResultMessage()==ResultMessage.NotExist){
    						JOptionPane.showMessageDialog(null, "订单不存在", "错误", JOptionPane.ERROR_MESSAGE);
    					}
    					paymentOrderVO=(PaymentOrderVO)javaBean1.getObject();
    					paymentOrderui=findPaymentOrder(paymentOrderVO);
    					childPanel = paymentOrderui;
    					Skip.skip(mainPanel,childPanel);
    					inPaymentOrderui();
    				} catch (Exception e2) {
    					e2.printStackTrace();
    				}
                }
             }
        });
	}
	public PaymentOrderui findPaymentOrder(PaymentOrderVO paymentOrderVO){
		paymentOrderui=new PaymentOrderui();
		paymentOrderui.refresh();
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
		return paymentOrderui;
	}
	public void inPaymentOrderui(){
		paymentOrderui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String deleteId=paymentOrderui.docmID.getText();
				ArrayList<String> deletearray=new ArrayList<String>();
				deletearray.add(deleteId);
				paymentOrderblservice=new PaymentOrder();
				paymentOrderblservice.deleteMany(deletearray);
				paymentOrderListui = new PaymentOrderListui();
				childPanel = paymentOrderListui;
				Skip.skip(mainPanel,childPanel);
				inPaymentOrderListui();
			}
		});
	}
	public void inSettlementListui() {
		settlementListui.table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent evt) {
	            if (evt.getClickCount() == 2) {
	               	String id=(String)settlementListui.tableModel.
	               			getValueAt(settlementListui.table.getSelectedRow(),1);
	            	try {
	            		receivablesOrderblservice=new ReceivablesOrder();
				        javaBean1=new JavaBean1();
				        javaBean1=receivablesOrderblservice.inquireA(id);
				        if(javaBean1.getResultMessage()==ResultMessage.NotExist){
					        JOptionPane.showMessageDialog
					        (null, "单据不存在", "错误", JOptionPane.ERROR_MESSAGE);
				        }
				        receivablesOrderVO=(ReceivablesOrderVO)javaBean1.getObject();
				        receivablesOrderui=finReceivablesOrder(receivablesOrderVO);
				        childPanel = receivablesOrderui;
				        Skip.skip(mainPanel,childPanel);
			        }catch(Exception e2){
			        }
	            }
	       }
		});
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
	public static void main(String[] args) {
		Accountant2Controller accountant2Controller = new Accountant2Controller();
	}
}
