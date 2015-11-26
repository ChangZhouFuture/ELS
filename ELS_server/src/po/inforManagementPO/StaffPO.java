package po.inforManagementPO;

import state.Gender;
import state.PayType;
import state.Position;

public class StaffPO {
	private String ID;
    private String name;
    private Gender gender;
    private String birthDate;
    private String identyNum;
    private String phone;
    private String agency;
    private Position position;
    private PayType payType;
    private double payAmount;
    private String percentage;
    
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
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public PayType getPayType() {
		return payType;
	}
	public void setPayType(PayType payType) {
		this.payType = payType;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
    
    
}
