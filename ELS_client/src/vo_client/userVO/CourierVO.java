package vo_client.userVO;

public class CourierVO {
	String couriername;
	String courierid;
	String birthday;
	String idcard;
	String mobilephone;
	String sex;
	public CourierVO(String couriername,String courierid,String birthday,String idcard,String mobilephone,String sex){
		this.couriername=couriername;
		this.courierid=courierid;
		this.birthday=birthday;
		this.idcard=idcard;
		this.mobilephone=mobilephone;
		this.sex=sex;
	}
	public String getCouriername() {
		return couriername;
	}
	public void setCouriername(String couriername) {
		this.couriername = couriername;
	}
	public String getCourierid() {
		return courierid;
	}
	public void setCourierid(String courierid) {
		this.courierid = courierid;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
