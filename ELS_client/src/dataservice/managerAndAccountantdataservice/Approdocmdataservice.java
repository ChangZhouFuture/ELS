package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import state.DocumentsType;
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
	public ResultMessage updateApproState(DocumentsType documentsType,ArrayList<String> 
	IDList) throws RemoteException;

}
