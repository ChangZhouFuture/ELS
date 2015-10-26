package businesslogicservice_client.informngmtblservice;

import state.Gender;
import state.PayType;
import state.Position;
import vo_client.informngmtVO.StaffAndAgencyVO;
import vo_client.lineitemVO.informngmtlineitemVO.StaffAndAgencylineitemVO;
/**
 * 
 * @author zt
 * 该类处理和人员机构管理有关的业务逻辑
 */
public interface StaffAndAgencyblservice {
	/**
	 * 前置条件：开启一个人员机构管理回合
	 * 后置条件：打开人员机构列表
	 * @return
	 */
    public StaffAndAgencylineitemVO inquireList();
    
    /**
     * 前置条件：打开人员机构列表
     * 后置条件：在列表中根据id查询人员信息
     * @param id
     * @return
     */
    public StaffAndAgencyVO inquire(String id);
    
    /**
     * 前置条件：开启人员管理回合
     * 后置条件：增加一个新的人员信息
     * @param id
     * @param name
     * @param age
     * @param Gender
     * @param position
     * @param paytype
     * @param amount
     * @return
     */
    public StaffAndAgencyVO add(String id,String name,int age,Gender Gender,Position position,
    		PayType paytype,double amount);
    
    /**
     * 前置条件：开启人员管理回合
     * 后置条件：修改一个人员的信息
     * @param id
     * @param name
     * @param age
     * @param gender
     * @param position
     * @param paytype
     * @param amount
     * @return
     */
    public StaffAndAgencyVO modify(String id,String name,int age,Gender gender,Position position,
    		PayType paytype,double amount);
    
    /**
     * 前置条件：开启人员管理回合
     * 后置条件：删除一个人员信息
     * @param id
     */
    public void delete(String id);
    
    /**
     * 前置条件：已完成人员机构管理
     * 后置条件：结束人员机构管理，持久化更新涉及的领域对象的数据
     */
    public void endSAA();
}
