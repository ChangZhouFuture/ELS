package presentation.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import presentation.documentsui.TranCenArrivalOrderui.TranCenArrivalOrderListui;
import presentation.documentsui.TranCenArrivalOrderui.TranCenArrivalOrderui;
import presentation.documentsui.TranCenLoadingListui.TransferCenterLoadingListListui;
import presentation.documentsui.TranCenLoadingListui.TransferCenterLoadingListui;
import presentation.documentsui.TransferOrderui.TransferOrderListui;
import presentation.documentsui.TransferOrderui.TransferOrderui;
import presentation.reuse.Skip;
import presentation.userui.TranCenClerkui;

public class TranCenClerkController {
	JPanel mainPanel = new JPanel();
	JPanel childPanel;
	TranCenClerkui tranCenClerkui;
	TranCenArrivalOrderListui tranCenArrivalOrderListui;
	TransferOrderListui transferOrderListui;
	TransferCenterLoadingListListui transferCenterLoadingListListui;
	TranCenArrivalOrderui tranCenArrivalOrderui;
	TransferOrderui transferOrderui;
	TransferCenterLoadingListui transferCenterLoadingListui;
	
	public TranCenClerkController(){
		tranCenClerkui = new TranCenClerkui();
		transferOrderListui = new TransferOrderListui();
		transferOrderListui.setLocation(0, 0);
		mainPanel.setLayout(null);
		mainPanel.setBounds(184,30,616,496);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(transferOrderListui);
		JLayeredPane layeredPane = tranCenClerkui.getLayeredPane();
		layeredPane.add(mainPanel,0);
		inTranCenClerkui();
		inTranCenArrivalOrderListui();
	}
	public void inTranCenClerkui() {
		tranCenClerkui.tranCenArraivalOrderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tranCenArrivalOrderListui= new TranCenArrivalOrderListui();
				childPanel = tranCenArrivalOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTranCenArrivalOrderListui();
			}
		});
		tranCenClerkui.trensferOrderManage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transferOrderListui= new TransferOrderListui();
				childPanel = transferOrderListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTransferOrderListui();
			}
		});
		tranCenClerkui.transferCenterLoadingList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transferCenterLoadingListListui= new TransferCenterLoadingListListui();
				childPanel = transferCenterLoadingListListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTransferCenterLoadingListListui();
			}
		});
	}
	public void inTranCenArrivalOrderListui() {
		tranCenArrivalOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tranCenArrivalOrderui= new TranCenArrivalOrderui();
				childPanel = tranCenArrivalOrderui;
				Skip.skip(mainPanel,childPanel);
				inTranCenArrivalOrderui();
			}	
		});
	}
	public void inTranCenArrivalOrderui(){
		
	}
	public void inTransferOrderListui(){
		transferOrderListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transferOrderui= new TransferOrderui();
				childPanel = transferOrderui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTransferOrderui();
			}	
		});
	}
	public void inTransferOrderui(){
		
	}
	public void inTransferCenterLoadingListListui(){
		transferCenterLoadingListListui.add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transferCenterLoadingListui= new TransferCenterLoadingListui();
				childPanel = transferCenterLoadingListui;
				childPanel.setLocation(0,0);
				Skip.skip(mainPanel,childPanel);
				inTransferOrderui();
			}	
		});
	}
	public void inTransferCenterLoadingListui(){
		
	}
	public static void main(String[] args) {
		TranCenClerkController tranCenClerkController = new TranCenClerkController();
	}
}
