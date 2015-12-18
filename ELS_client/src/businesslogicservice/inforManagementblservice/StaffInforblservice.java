package businesslogicservice.inforManagementblservice;

import state.ResultMessage;
import vo.inforManagementVO.SalaryStrategyVO;
import bean.JavaBean1;

public interface StaffInforblservice {
    public JavaBean1 inquireA(String Id);
    
    public JavaBean1 inquireB(String position);
    
    public ResultMessage modifySalaryStrategy(SalaryStrategyVO salaryStrategyVO);
}
