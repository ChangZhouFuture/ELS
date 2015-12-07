package businesslogicservice.managerAndAccountantblservice;

import bean.JavaBean1;
/**
 * 
 * @author zt
 * 该类处理查询操作日志相关的业务逻辑
 */
public interface OperaLogblservice {
     /**
 	 * 前置条件：启动一个查询日志回合
 	 * 后置条件：通过日期查询某天日志
 	 * @param date
 	 * @return
 	 */
     public JavaBean1 inquireOperaLog(String date);
}
