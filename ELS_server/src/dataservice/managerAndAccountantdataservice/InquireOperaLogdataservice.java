package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;

import bean.JavaBean1;
import po.utilityPO.OperaLogPO;

/**
 * ���ദ���йز�ѯ������־������
 * @author zt
 *
 */
public interface InquireOperaLogdataservice extends Remote{
	
     public JavaBean1 inquire(String date);
     
}
