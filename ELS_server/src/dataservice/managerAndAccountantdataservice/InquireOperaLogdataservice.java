package dataservice.managerAndAccountantdataservice;

import po.utilityPO.OperaLogPO;

/**
 * 该类处理有关查询操作日志的数据
 * @author zt
 *
 */
public interface InquireOperaLogdataservice {
	/**
	 * 前置条件：查询的操作日志在数据库中
	 * 后置条件：将某人员某天日志返回给逻辑层
	 * @param id
	 * @param date
	 * @return
	 */
     public OperaLogPO inquireA(String id,String date);
     
     /**
 	 * 前置条件：查询的操作日志在数据库中
 	 * 后置条件：将某人员日志列表返回给逻辑层
 	 * @param id
 	 * @return
 	 */
     public OperaLogPO inquireB(String id);
     
     /**
 	 * 前置条件：查询的操作日志在数据库中
 	 * 后置条件：将某天日志列表返回给逻辑层
 	 * @param date
 	 * @return
 	 */
     public OperaLogPO inquireC(String date);
     
}
