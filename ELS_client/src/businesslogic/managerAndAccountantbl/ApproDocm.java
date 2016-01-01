package businesslogic.managerAndAccountantbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.managerAndAccountantdataservice.Approdocmdataservice;
import dataservice.utilitydataservice.ParentDocumentsdataservice;
import state.DocumentsType;
import state.ResultMessage;
import RMI.RMIHelper;
import bean.JavaBean1;
import businesslogicservice.managerAndAccountantblservice.ApproDocmblservice;

public class ApproDocm implements ApproDocmblservice{
	private Approdocmdataservice approdocmdataservice;
	private ParentDocumentsdataservice dataservice;
	private ResultMessage resultMessage;
	private JavaBean1 javaBean1;
	
	public ApproDocm() {
		try {
			approdocmdataservice = RMIHelper.getApprodocmdataservice();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public JavaBean1 inquireA(String id, DocumentsType documentType) {
		whichDataService(documentType);
		try {
			javaBean1 = dataservice.findA(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return javaBean1;
	}

	@Override
	public JavaBean1 inquireB(DocumentsType documentsType, String date) {
		whichDataService(documentsType);
		try {
			javaBean1 = dataservice.findB(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//暂时不处理把PO转换成VO
		return javaBean1;
	}

	@Override
	public ResultMessage approveDocuments(ArrayList<String> IDList,
			DocumentsType documentsType) {
		try {
			resultMessage = approdocmdataservice.updateApproState(documentsType, IDList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//不需要在这里用switch-case判断documentsType，业务逻辑层不管表名
		return resultMessage;
	}
	
	public void whichDataService(DocumentsType documentsType) {
		switch (documentsType) {
		case Order:
			try {
				dataservice = RMIHelper.getOrderDataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case BusiHallArrivalOrder:
			try {
				dataservice = RMIHelper.getBusiHallArrivalOrderdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case BusiHallLoadingList:
			try {
				dataservice = RMIHelper.getBuinessHallLoadingListdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case DeliveryOrder:
			try {
				dataservice = RMIHelper.getDeliveryOrderdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case PaymentOrder:
			try {
				dataservice = RMIHelper.getPaymentOrderdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case ReceivablesOrder:
			try {
				dataservice = RMIHelper.getReceivablesOrderdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case TranCenArrivalOrder:
			try {
				dataservice = RMIHelper.getTranCenArrivalOrderdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case TranCenLoadingList:
			try {
				dataservice = RMIHelper.getTransferCenterLoadingListdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case TransferOrder:
			try {
				dataservice = RMIHelper.getTransferOrderdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case OutBoundOrder:
			try {
				dataservice = RMIHelper.getOutBoundOrderdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case StorageList:
			try {
				dataservice = RMIHelper.getStorageListdataservice();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("1512240001");
		RMIHelper.init();
		ApproDocm approDocm = new ApproDocm();
		approDocm.approveDocuments(arrayList, DocumentsType.Order);
	}
}
