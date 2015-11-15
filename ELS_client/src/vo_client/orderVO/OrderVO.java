package vo_client.orderVO;

import state.ExpressType;

public class OrderVO {
	String sender;
	
	String addressee;
	
	String desti;
	
	String startingPlace;
	
	ExpressType eType;
	
	String name;
	
	String id;
	
	int num;
	
	public OrderVO(String sender, String addressee, String desti, String startingPlace,
			ExpressType eType, String name, String id, int num){
		super();
		this.sender = sender;
		this.addressee = addressee;
		this.desti = desti;
		this.startingPlace = startingPlace;
		this.eType = eType;
		this.name = name;
		this.num = num;
	}
	
	public String getsender() {
		return this.sender;
	}
	
	public void setid4e(String sender) {
		this.sender = sender;
	}
	
	public String getdesti() {
		return this.desti;
	}
	
	public void setdesti(String desti) {
		this.desti = desti;
	}

	public String getaddressee() {
		return this.addressee;
	}
	
	public void setaddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getStartingPlace() {
		return startingPlace;
	}

	public void setStartingPlace(String startingPlace) {
		this.startingPlace = startingPlace;
	}

	public ExpressType geteType() {
		return eType;
	}

	public void seteType(ExpressType eType) {
		this.eType = eType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String getID() {
		return this.id;
	}
}

