package vo.lineitemVO.inforManagementlineitemVO;

import state.Gender;

public class DriverslineitemVO{
	private String ID;
	private String name;
	private String phone;
	private Gender gender;
	private String driveLimitDate;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getDriveLimitDate() {
		return driveLimitDate;
	}
	public void setDriveLimitDate(String driveLimitDate) {
		this.driveLimitDate = driveLimitDate;
	}
	
}
