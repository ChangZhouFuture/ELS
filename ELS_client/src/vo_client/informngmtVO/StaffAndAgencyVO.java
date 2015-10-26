package vo_client.informngmtVO;

import state.Gender;
import state.PayType;
import state.Position;

public class StaffAndAgencyVO {

	String id;
	String name;
	int age;
	Gender gender;
	Position position;
	PayType paytype;
	double amount;
	
	public StaffAndAgencyVO(String id, String name, int age, Gender gender, Position position, PayType paytype,
			double amount){
		super();
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.position=position;
		this.paytype=paytype;
		this.amount=amount;
	}
	
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public PayType getPaytype() {
		return paytype;
	}

	public void setPaytype(PayType paytype) {
		this.paytype = paytype;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
