package vo.inforManagementVO;

import state.Gender;

public class DriversVO {
	private String ID;
	private String name;
	private String birthDate;
	private String identyNum;
	private String phone;
	private Gender gender;
	private String driveLimitDate;
	private String positon;
	private String city;
	private String region;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPositon() {
		return positon;
	}
	public void setPositon(String positon) {
		this.positon = positon;
	}
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getIdentyNum() {
		return identyNum;
	}
	public void setIdentyNum(String identyNum) {
		this.identyNum = identyNum;
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
