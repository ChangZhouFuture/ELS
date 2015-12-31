package presentation.stockui.StorageListui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import bean.JavaBean1;
import businesslogic.stockbl.StorageList;
import businesslogicservice.stockblservice.StorageListblservice;
import presentation.reuse.ParentDocuments;
import vo.stockVO.StorageListVO;

public class StorageListui extends ParentDocuments{
	public JLabel storageList;
	public JLabel orderId;
	public JTextField orderIdField;
	public JLabel destination;
	public JTextField destinationField;
	public JLabel areaNum;
	public JTextField areaNumField;
	public JLabel rowNum;
	public JTextField rowNumField;
	public JLabel frameNum;
	public JTextField frameNumField;
	public JLabel positionNum;
	public JTextField positionNumField;
	StorageListblservice storageListblservice;
	JavaBean1 javaBean1;
	public StorageListVO storageListVO;
	
	public StorageListui(){
		storageList=new JLabel();
		orderId=new JLabel();
		orderIdField=new JTextField();
		destination=new JLabel();
		destinationField=new JTextField();
		areaNum=new JLabel();
		areaNumField=new JTextField();
		rowNum=new JLabel();
		rowNumField=new JTextField();
		frameNum=new JLabel();
		frameNumField=new JTextField();
		positionNum=new JLabel();
		positionNumField=new JTextField();
		storageListVO=new StorageListVO();
		
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		storageList.setBounds(218,10,180,30);
		storageList.setText("入库单信息");
		storageList.setHorizontalAlignment(SwingConstants.CENTER);
		storageList.setFont(font1);
		storageList.setBackground(Color.WHITE);
		
		orderId.setBounds(40,50,100,24);
		orderId.setText("快递编号：");
		orderId.setFont(font2);
		orderId.setBackground(Color.WHITE);
		
		orderIdField.setBounds(140,52,150,20);
		
		destination.setBounds(40,80,100,24);
		destination.setText("目的地：");
		destination.setFont(font2);
		destination.setBackground(Color.WHITE);
		
		destinationField.setBounds(140,82,150,20);
		
		areaNum.setBounds(40,110,100,24);
		areaNum.setText("区号：");
		areaNum.setFont(font2);
		areaNum.setBackground(Color.WHITE);
		
		areaNumField.setBounds(140,112,150,20);
		
		rowNum.setBounds(40,140,100,24);
		rowNum.setText("排号：");
		rowNum.setFont(font2);
		rowNum.setBackground(Color.WHITE);
		
		rowNumField.setBounds(140,142,150,20);
		
		frameNum.setBounds(40,170,100,24);
		frameNum.setText("架号：");
		frameNum.setFont(font2);
		frameNum.setBackground(Color.WHITE);
		
		frameNumField.setBounds(140,172,150,20);
		
		positionNum.setBounds(40,200,100,24);
		positionNum.setText("位号：");
		positionNum.setFont(font2);
		positionNum.setBackground(Color.WHITE);
		
		positionNumField.setBounds(140,202,150,20);
		
		makeOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(1);
				refresh();
				approState.setText("未审批");
				storageListblservice=new StorageList();
				storageListVO.setDestination(destinationField.getText());
				storageListVO.setOrderID(orderIdField.getText());
				storageListVO.setAreaNum(areaNumField.getText());
				storageListVO.setRowNum(rowNumField.getText());
				storageListVO.setFrameNum(frameNumField.getText());
				storageListVO.setPositionNum(positionNumField.getText());
				javaBean1=storageListblservice.add(storageListVO);
				storageListVO=(StorageListVO)javaBean1.getObject();
				docmID.setText(storageListVO.getId());
				docmDate.setText(storageListVO.getInDate());
			}
		});
		
		modifyOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				storageListblservice=new StorageList();
				storageListVO.setDestination(destinationField.getText());
				storageListVO.setOrderID(orderIdField.getText());
				storageListVO.setAreaNum(areaNumField.getText());
				storageListVO.setRowNum(rowNumField.getText());
				storageListVO.setFrameNum(frameNumField.getText());
				storageListVO.setPositionNum(positionNumField.getText());
				javaBean1=storageListblservice.modify(storageListVO);
				storageListVO=(StorageListVO)javaBean1.getObject();
			}
		});
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifying();
			}
		});
		
		this.add(storageList);
		this.add(orderId);
		this.add(orderIdField);
		this.add(destination);
		this.add(destinationField);
		this.add(areaNum);
		this.add(areaNumField);
		this.add(rowNum);
		this.add(rowNumField);
		this.add(frameNum);
		this.add(frameNumField);
		this.add(positionNum);
		this.add(positionNumField);
	}
	public void refresh() {
		orderIdField.setEditable(false);
		destinationField.setEditable(false);
		areaNumField.setEditable(false);
		rowNumField.setEditable(false);
		frameNumField.setEditable(false);
		positionNumField.setEditable(false);
		
		destinationField.setBackground(Color.white);
		areaNumField.setBackground(Color.white);
		orderIdField.setBackground(Color.white);
		rowNumField.setBackground(Color.white);
		frameNumField.setBackground(Color.white);
		positionNumField.setBackground(Color.white);
		
		destinationField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		areaNumField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		rowNumField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		frameNumField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		positionNumField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		modify.setVisible(true);
		delete.setVisible(true);
		makeOrder.setVisible(false);
		modifyOrder.setVisible(false);
	}
	public void modifying() {
		orderIdField.setEditable(true);
		destinationField.setVisible(true);
		areaNumField.setVisible(true);
		rowNumField.setVisible(true);
		frameNumField.setVisible(true);
		positionNumField.setVisible(true);
		modifyOrder.setVisible(true);
		
		destinationField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		areaNumField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		orderIdField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		rowNumField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		frameNumField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		positionNumField.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
}
