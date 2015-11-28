package businesslogicservice.userManagementblservice;

import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;
import vo.userVO.UserVO;

public interface UserManagementblservice {
    public JavaBean1 add(UserVO vo);
    
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage modify(UserVO vo);
    
    public JavaBean1 inquire(String Id);
}
