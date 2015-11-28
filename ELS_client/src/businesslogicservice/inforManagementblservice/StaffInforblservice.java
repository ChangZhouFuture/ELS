package businesslogicservice.inforManagementblservice;

import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;
import vo.inforManagementVO.StaffVO;

public interface StaffInforblservice {
    public JavaBean1 add(StaffVO vo);
    
    public JavaBean1 inquire(String Id);
    
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage modify(StaffVO vo);
}
