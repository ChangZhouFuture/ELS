package po.inforManagementPO;

import java.io.Serializable;

import state.AgencyType;

public class AgencyPO implements Serializable{
    private String ID;
    private String city;
    private AgencyType agencyType;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public AgencyType getAgencyType() {
		return agencyType;
	}
	public void setAgencyType(AgencyType agencyType) {
		this.agencyType = agencyType;
	}
	
    
}
