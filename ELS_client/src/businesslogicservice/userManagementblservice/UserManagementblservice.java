package businesslogicservice.userManagementblservice;

import java.util.ArrayList;

import state.ResultMessage;
import vo.userVO.UserVO;

public interface UserManagementblservice {
    public ResultMessage add(UserVO vo);
    
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage modify(UserVO vo);
    
    public UserVO inquire(String Id);
}