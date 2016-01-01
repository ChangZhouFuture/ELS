package businesslogicservice.userManagementblservice;

import java.util.ArrayList;
import bean.JavaBean1;
import state.Position;
import state.ResultMessage;
import vo.userVO.UserVO;

public interface UserManagementblservice {
    public JavaBean1 add(UserVO userVO);
    
    public ResultMessage deleteMany(ArrayList<String> IDList);
    
    public ResultMessage modify(UserVO userVO);
    
    public JavaBean1 inquireA(String Id);
    
    public JavaBean1 inquireB(Position position);
    
}
