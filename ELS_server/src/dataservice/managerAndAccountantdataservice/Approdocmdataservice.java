package dataservice.managerAndAccountantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import state.DocumentsType;
import state.ResultMessage;


/**
 * 该接口提供审批单据相关的数据层方法
 * @author zt
 *
 */
public interface Approdocmdataservice extends Remote{
	/**
	 * 
	 * 前置条件：行为或操作已经完成
	 * 后置条件：持久化更新涉及的领域对象的数据
	 */
	public ResultMessage updateApproState(DocumentsType documentsType,ArrayList<String> 
	IDList) throws RemoteException;

}
