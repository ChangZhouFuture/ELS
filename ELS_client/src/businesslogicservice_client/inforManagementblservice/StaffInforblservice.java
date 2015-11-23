package businesslogicservice_client.inforManagementblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo_client.inforManagementVO.StaffVO;

public interface StaffInforblservice {
    public ResultMessage add(StaffVO vo);
    
    public StaffVO inquire(String Id);
    
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage modify(StaffVO vo);
}
