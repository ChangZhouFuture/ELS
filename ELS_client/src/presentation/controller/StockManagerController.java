package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import presentation.reuse.Skip;
import presentation.stockui.OutBoundOrderui.OutBoundOrderListui;
import presentation.stockui.OutBoundOrderui.OutBoundOrderui;
import presentation.stockui.StorageListui.StorageListListui;
import presentation.stockui.stockui.StockCheckui;
import presentation.stockui.stockui.StockCountui;
import presentation.userManagementui.UserInfoui;
import presentation.userManagementui.UserListui;
import presentation.userui.Administratorui;
import presentation.userui.StockManagerui;

public class StockManagerController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	StockManagerui stockManagerui;
	OutBoundOrderListui outBoundOrderListui;
	StorageListListui storageListListui;
	StockCheckui stockCheckui;
	StockCountui stockCountui;
	OutBoundOrderui outBoundOrderui;
	
	public StockManagerController(){
		stockManagerui = new StockManagerui();
		outBoundOrderListui = new OutBoundOrderListui();
		outBoundOrderListui.setLocation(0,0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(outBoundOrderListui);
		JLayeredPane layeredPane = stockManagerui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inStockManagerui();
		inOutBoundOrderListui();
	}
	public void inStockManagerui() {
		stockManagerui.outBoundManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				outBoundOrderListui= new OutBoundOrderListui();
				childPanel = outBoundOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inOutBoundOrderListui();
			}
		});
		stockManagerui.storageManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				storageListListui = new StorageListListui();
				childPanel = storageListListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		stockManagerui.stockCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stockCheckui = new StockCheckui();
				childPanel = stockCheckui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
		stockManagerui.stockCount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stockCountui = new StockCountui();
				childPanel = stockCountui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
			}
		});
	}
	public void inOutBoundOrderListui() {
		
	}
	public static void main(String[] args) {
		StockManagerController stockManagerController = new StockManagerController();
	}
}
