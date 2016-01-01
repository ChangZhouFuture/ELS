package businesslogicservice.inforManagementblservice;

import state.Position;
import state.ResultMessage;
import vo.inforManagementVO.SalaryStrategyVO;
import bean.JavaBean1;

public interface StaffInforblservice {
    public JavaBean1 inquireA(String Id);
    
    public JavaBean1 inquireB(Position position);
    
    public JavaBean1 inquireSalaryStrategy();
    	
    public ResultMessage modifySalaryStrategy(SalaryStrategyVO salaryStrategyVO);
    
}
