package po_server.inforManagementPO;

import java.io.Serializable;

public class DriversPO implements Serializable{
	private static final long serialVersionUID = -8345248940752949681L;
	private String ID;
	private String name;
	private String birthDate;
	private String identyNum;
	private String phone;
	private int gender;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDriveLimitDate() {
		return driveLimitDate;
	}

	public void setDriveLimitDate(String driveLimitDate) {
		this.driveLimitDate = driveLimitDate;
	}
	
}
