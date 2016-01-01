package po.lineitemPO.userlineitemPO;

import java.io.Serializable;
import state.AgencyType;
import state.Gender;
import state.PayType;

public class UserlineitemPO implements Serializable{
	private String Id;
	private String name;
    private Gender gender;
    private String phone;
    private String city;
    private String region;
    private AgencyType agencyType;
    private String position;
    private PayType payType;
    private double payAmount;
    private String percentage;
    
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
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
	public AgencyType getAgencyType() {
		return agencyType;
	}
	public void setAgencyType(AgencyType agencyType) {
		this.agencyType = agencyType;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
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
