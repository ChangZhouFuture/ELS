package po_server.inforManagementPO;

import state.AgencyType;

public class AgencyPO {
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