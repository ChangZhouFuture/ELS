package businesslogicservice.userManagementblservice;

import java.util.ArrayList;

import bean.JavaBean1;
import state.ResultMessage;
import vo.userVO.UserVO;

public interface UserManagementblservice {
    public JavaBean1 add(UserVO userVO);
    
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> IDList);
    
    public ResultMessage modify(UserVO userVO);
    
    public JavaBean1 inquireA(String Id);
    
    public JavaBean1 inquireB(String position);
    
}
