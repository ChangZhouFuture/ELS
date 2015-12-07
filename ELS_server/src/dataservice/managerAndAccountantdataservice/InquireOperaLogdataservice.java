package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import bean.JavaBean1;

/**
 * 该类处理有关查询操作日志的数据
 * @author zt
 *
 */
public interface InquireOperaLogdataservice extends Remote{
	
     public JavaBean1 inquire(String date) throws RemoteException;
     
}
