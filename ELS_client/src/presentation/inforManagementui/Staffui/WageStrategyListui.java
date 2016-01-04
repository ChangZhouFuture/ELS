package presentation.inforManagementui.Staffui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import bean.JavaBean1;
import businesslogic.inforManagementbl.StaffInfor;
import businesslogicservice.inforManagementblservice.StaffInforblservice;
import presentation.reuse.Images;
import state.PayType;
import state.Position;
import vo.inforManagementVO.SalaryStrategyVO;

public class WageStrategyListui extends JPanel{
	public JLabel sheetLabel;
	public JTable table;
	public DefaultTableModel tableModel;
	public JTable modifyTable;
	public JButton modify;
	public JButton makeModify;
	public DefaultTableCellRenderer r;
	TableColumn tableColumn;
	JComboBox cbx;
	TableColumn modifyTableColumn;
	TableCellEditor tce;
	JScrollPane scrollPane;
	JScrollPane modifyScrollPane;
	JavaBean1 javaBean1;
	StaffInforblservice staffInforblservice;
	SalaryStrategyVO salaryStrategyVO;
	Position position;
	PayType payTypeType;
	
	public WageStrategyListui(){
		sheetLabel=new JLabel();
		modify=new JButton();
		makeModify=new JButton();
		cbx= new JComboBox();  
		cbx.addItem("按月");  
		cbx.addItem("按次");
		String[] columnNames = {"职位","付薪方式","基本工资","提成百分比"}; //列名
		String [][]tableVales={}; //数据
		tableModel = new DefaultTableModel(tableVales,columnNames);
		r=new DefaultTableCellRenderer();
		table=new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				 return false;
		    }
		};
		
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class,r);
		
		tableColumn = table.getColumn("付薪方式");
		tableColumn.setCellEditor(new DefaultCellEditor(cbx));
		
		this.setLayout(null);
		Font font1=new Font("TimesRoman",Font.BOLD,18);
		Font font2=new Font("TimesRoman",Font.PLAIN,15);
		Font font3=new Font("TimesRoman",Font.PLAIN,18);
		
		sheetLabel.setBounds(0,0,616,30);
		sheetLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		sheetLabel.setBackground(Color.WHITE);
		sheetLabel.setFont(font1);
		sheetLabel.setIcon(Images.SHEET_IMAGE);
		sheetLabel.setText("工资策略管理");
		
		makeTable();
		table.setRowHeight(24);
		table.setBackground(Color.WHITE);
		table.setShowVerticalLines(true);
		table.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setSize(550,217);
		scrollPane.setLocation(30,100);
		scrollPane.setViewportView(table);
		
		modifyTable=new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				if(column==0){
				 return false;
				}else return true;
		    }
		};
		
		modifyTableColumn = modifyTable.getColumn("付薪方式");
		DefaultCellEditor cellEditor=new DefaultCellEditor(cbx);
		modifyTableColumn.setCellEditor(cellEditor);
		cbx.setVisible(true);
		modifyTable.setDefaultRenderer(Object.class,r);
		modifyTable.setRowHeight(24);
		modifyTable.setBackground(Color.WHITE);
		modifyTable.setShowVerticalLines(true);
		modifyTable.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		
		modify.setBounds(30,50,70,24);
		modify.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		modify.setBackground(Color.WHITE);
		modify.setText("修改");
		modify.setFont(font2);
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				makeModify.setVisible(true);
				scrollPane.getViewport().add(modifyTable);
				repaint();
			}
		});
		
		makeModify.setBounds(30,420,100,24);
		makeModify.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		makeModify.setBackground(Color.WHITE);
		makeModify.setText("确认修改");
		makeModify.setFont(font2);
		makeModify.setVisible(false);
		makeModify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<SalaryStrategyVO> arrayList=new ArrayList<SalaryStrategyVO>();
				for(int i=0;i<8;i++){
					salaryStrategyVO=new SalaryStrategyVO();
					switch(String.valueOf(tableModel.getValueAt(i,0))){
					case "快递员":position=Position.Courier;break;
				    case "营业厅业务员":position=Position.BusiHallClerk;break;
				    case "中转中心业务员":position=Position.TranCenClerk;break;
				    case "库存管理人员":position=Position.StockManager;break;
				    case "财务人员":position=Position.Accountant2;break;
				    case "高级财务人员":position=Position.Accountant1;break;
				    case "管理员":position=Position.Administrator;break;
				    case "司机":position=Position.Driver;break;
				    default:break;
					}
					switch(String.valueOf(tableModel.getValueAt(i,1))){
				    case "按月":payTypeType=PayType.BYMONTH;break;
				    case "按次":payTypeType=PayType.BYTIME;break;
				    default:break;
				    }
					salaryStrategyVO.setPosition(position);
					salaryStrategyVO.setPayType(payTypeType);
					salaryStrategyVO.setPayAmount(Double.valueOf(String.valueOf(tableModel.getValueAt(i,2))));
					salaryStrategyVO.setPercentage(String.valueOf(tableModel.getValueAt(i,3)));
					arrayList.add(salaryStrategyVO);
				}
				staffInforblservice=new StaffInfor();
				staffInforblservice.modifySalaryStrategy(arrayList);
				makeModify.setVisible(false);
				scrollPane.getViewport().add(table);
				makeTable();
			}
		});
		
		this.add(sheetLabel);
		this.add(modify);
		this.add(makeModify);
		this.add(scrollPane);
		
		setLocation(184,30);
		this.setSize(616,496);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	}
	public void makeTable(){
		javaBean1=staffInforblservice.inquireSalaryStrategy();
		ArrayList<SalaryStrategyVO> arrayList=(ArrayList<SalaryStrategyVO>)javaBean1.getObject();
		String payType="";
		String positionType="";
		for(int i=0;i<8;i++){
		    switch(arrayList.get(i).getPayType()){
		    case BYMONTH:payType="按月";break;
		    case BYTIME:payType="按次";break;
		    default:break;
		    }
		    switch(arrayList.get(i).getPosition()){
		    case Courier:positionType="快递员";break;
		    case BusiHallClerk:positionType="营业厅业务员";break;
		    case TranCenClerk:positionType="中转中心业务员";break;
		    case StockManager:positionType="库存管理人员";break;
		    case Accountant2:positionType="财务人员";break;
		    case Accountant1:positionType="高级财务人员";break;
		    case Administrator:positionType="管理员";break;
		    case Driver:positionType="司机";break;
		    }
		    String[] line={positionType,payType,String.valueOf(arrayList.get(i).getPayAmount()),
					String.valueOf(arrayList.get(i).getPercentage())};
		    tableModel.addRow(line);
		}
	}
}
