package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import bean.JavaBean1;

/**
 * ���ദ���йز�ѯ������־������
 * @author zt
 *
 */
public interface InquireOperaLogdataservice extends Remote{
	
     public JavaBean1 inquire(String date) throws RemoteException;
     
}
