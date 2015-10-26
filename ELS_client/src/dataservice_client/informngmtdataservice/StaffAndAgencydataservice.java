package dataservice_client.informngmtdataservice;

import po_client.informngmtPO.StaffAndAgencyPO;
import state.Gender;
import state.PayType;
import state.Position;
import vo_client.lineitemVO.informngmtlineitemVO.StaffAndAgencylineitemVO;

public interface StaffAndAgencydataservice {
     
	/**
	 * 前置条件：
	 * 后置条件：将人员机构列表返回给逻辑层1
	 * @return
	 */
    public StaffAndAgencylineitemVO inquireList();
    
    /**
     * 前置条件：id对应的人员在信息库中
     * 后置条件：在列表中根据id查询人员信息，返回给逻辑层
     * @param id
     * @return
     */
    public StaffAndAgencyPO inquire(String id);
    
    /**
     * 前置条件：已输入人员信息所有数据
     * 后置条件：增加一个新的人员信息，返回给逻辑层
     * @param id
     * @param name
     * @param age
     * @param Gender
     * @param position
     * @param paytype
     * @param amount
     * @return
     */
    public StaffAndAgencyPO add(String id,String name,int age,Gender Gender,Position position,
    		PayType paytype,double amount);
    
    /**
     * 前置条件：要修改的人员在数据库里
     * 后置条件：修改一个人员的信息，返回给逻辑层
     * @param id
     * @param name
     * @param age
     * @param gender
     * @param position
     * @param paytype
     * @param amount
     * @return
     */
    public StaffAndAgencyPO modify(String id,String name,int age,Gender gender,Position position,
    		PayType paytype,double amount);
    
    /**
     * 前置条件：要删除的人员在数据库里
     * 后置条件：删除一个人员信息，返回逻辑层
     * @param id
     */
    public void delete(String id);
    
    /**
	 * 
	 * 前置条件：行为或操作已经完成
	 * 后置条件：持久化更新涉及的领域对象的数据
	 */
	public void update();

}
