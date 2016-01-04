package presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import bean.JavaBean1;
import businesslogic.inforManagementbl.BankAccountInfor;
import businesslogicservice.inforManagementblservice.BankAccountInforblservice;
import presentation.inforManagementui.BankAccountui.BankAccountListui;
import presentation.inforManagementui.BankAccountui.BankAccountui;
import presentation.reuse.EMSDialog;
import presentation.reuse.Skip;
import state.ResultMessage;
import vo.inforManagementVO.BankAccountVO;

public class Accountant1Controller extends Accountant2Controller{
	BankAccountListui bankAccountListui;
	BankAccountInforblservice bankAccountInforblservice;
	BankAccountVO bankAccountVO;
	
	public Accountant1Controller(){
		accountantui.bankAccount.setVisible(true);
		inAccountant1ui();
	}
	public void inAccountant1ui() {
		accountantui.bankAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bankAccountListui = new BankAccountListui();
				childPanel = bankAccountListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inBankAccountListui();
			}
		});
	}
	public void inBankAccountListui(){
		bankAccountListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bankAccountui=new BankAccountui();
				childPanel=bankAccountui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inBankAccountui();
			}
		});
		bankAccountListui.table.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent evt) {
               if (evt.getClickCount() == 2) {
               	String id=(String)bankAccountListui.tableModel.
               			getValueAt(bankAccountListui.table.getSelectedRow(),1);
               	try {
               		bankAccountInforblservice=new BankAccountInfor();
               		javaBean1=new JavaBean1();
   					javaBean1=bankAccountInforblservice.inquire(id);
   					bankAccountVO=(BankAccountVO)javaBean1.getObject();
   					bankAccountui=findBankAccount(bankAccountVO);
   					childPanel = bankAccountui;
   					Skip.skip(mainPanel,childPanel);
   					inBankAccountui();
   				} catch (Exception e2) {
   					e2.printStackTrace();
   				}
               }
            }
       });
	}
	public BankAccountui findBankAccount(BankAccountVO bankAccountVO){
		bankAccountui=new BankAccountui();
		bankAccountui.bankAccountVO=bankAccountVO;
		bankAccountui.refresh();
		bankAccountui.nameField.setText(bankAccountVO.getName());
		bankAccountui.moneyField.setText(String.valueOf(bankAccountVO.getAmount()));
		bankAccountui.approState.setText(bankAccountVO.getUseState().toString());
		return bankAccountui;
	}
	public void inBankAccountui(){
		bankAccountui.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EMSDialog d=new EMSDialog();
				int n = d.showDialog(accountantui, "х╥хои╬ЁЩ?",30);  
		        if (n == 1) { 
				    String deleteId=bankAccountui.docmID.getText();
				    ArrayList<String> deletearray=new ArrayList<String>();;
				    deletearray.add(deleteId);
				    bankAccountInforblservice=new BankAccountInfor();
				    bankAccountInforblservice.deleteMany(deletearray);
				    bankAccountListui = new BankAccountListui();
				    childPanel = bankAccountListui;
				    Skip.skip(mainPanel,childPanel);
				    inBankAccountListui();
		        }
			}
		});
	}
	public static void main(String[] args) {
		Accountant1Controller accountant1Controller = new Accountant1Controller();
	}
}
