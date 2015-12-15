package po.userPO;

import java.io.Serializable;

import state.AgencyType;
import state.Gender;
import state.PayType;
import state.Position;

public class UserPO implements Serializable{
    private String Id;
    private String password;
    private String name;
    private Gender gender;
    private String birthDate;
    private String identyNum;
    private String phone;
    private String city;
//    private AgencyType agencyType;
    private String region;
    private String agencyID;
    private Position position;
//    private PayType payType;
//    private double payAmount;
//    private String percentage;
    
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
	public String getAgencyID() {
		return agencyID;
	}
	public void setAgencyID(String agencyID) {
		this.agencyID = agencyID;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
  
}
