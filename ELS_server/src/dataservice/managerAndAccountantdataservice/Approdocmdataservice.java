package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import state.ResultMessage;


/**
 * �ýӿ��ṩ����������ص����ݲ㷽��
 * @author zt
 *
 */
public interface Approdocmdataservice extends Remote{
	/**
	 * 
	 * ǰ����������Ϊ������Ѿ����
	 * �����������־û������漰��������������
	 */
	public ResultMessage updateApproState(String documentsType,ArrayList<String> 
	IDList) throws RemoteException;

}
