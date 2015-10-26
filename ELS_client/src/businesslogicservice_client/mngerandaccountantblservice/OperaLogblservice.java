package businesslogicservice_client.mngerandaccountantblservice;

import vo_client.OperaLogVO;
import vo_client.lineitemVO.OperaLoglineitemVO;
/**
 * 
 * @author zt
 * 该类处理查询操作日志相关的业务逻辑
 */
public interface OperaLogblservice {
	/**
	 * 前置条件：启动一个查询日志回合
	 * 后置条件：通过id，日期查询某人员某天日志
	 * @param id
	 * @param date
	 * @return
	 */
     public OperaLogVO inquireA(String id,String date);
     
     /**
 	 * 前置条件：启动一个查询日志回合
 	 * 后置条件：通过id查询某人员的日志
 	 * @param id
 	 * @return
 	 */
     public OperaLoglineitemVO inquireB(String id);
     
     /**
 	 * 前置条件：启动一个查询日志回合
 	 * 后置条件：通过日期查询某天日志
 	 * @param date
 	 * @return
 	 */
     public OperaLoglineitemVO inquireC(String date);
}
