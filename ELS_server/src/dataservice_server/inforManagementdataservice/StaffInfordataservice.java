package dataservice_server.inforManagementdataservice;

import java.util.ArrayList;

import po_server.inforManagementPO.StaffPO;
import state.ResultMessage;

public interface StaffInfordataservice {
    public ResultMessage add(StaffPO po);
    
    public StaffPO find(String Id);
    
    public ResultMessage deleteOne(String Id);
    
    public ResultMessage deleteMany(ArrayList<String> Ids);
    
    public ResultMessage update(StaffPO po);
}
