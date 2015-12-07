package businesslogicservice.inforManagementblservice;

import po.userPO.UserPO;
import state.ResultMessage;
import bean.JavaBean1;

public interface StaffInforblservice {
    public JavaBean1 inquireA(String Id);
    
    public JavaBean1 inquireB(String position);
    
    public ResultMessage modifySalaryStrategy(UserPO userPO);
}
