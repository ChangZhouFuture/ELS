package vo.orderVO;

import state.ExpressType;

public class OrderVO {
	private String senderName;
	private String senderAdd;
	private String senderCompany;
	private String senderPhoneNumber;
	private String AddresseeName;
	private String AddresseeAdd;
	private String AddresseeCompany;
	private String AddresseePhoneNumber;
	private int numOfGoods;
	private double weight;
	private double size;
	private String goodsName;
	private ExpressType expressType;
	private int numOfCartons;
	private int numOfWoodenBox;
	private int numOfBags;
	private String id;
	private String generationDate;
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderAdd() {
		return senderAdd;
	}
	public void setSenderAdd(String senderAdd) {
		this.senderAdd = senderAdd;
	}
	public String getSenderCompany() {
		return senderCompany;
	}
	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}
	public String getSenderPhoneNumber() {
		return senderPhoneNumber;
	}
	public void setSenderPhoneNumber(String senderPhoneNumber) {
		this.senderPhoneNumber = senderPhoneNumber;
	}
	public String getAddresseeName() {
		return AddresseeName;
	}
	public void setAddresseeName(String addresseeName) {
		AddresseeName = addresseeName;
	}
	public String getAddresseeAdd() {
		return AddresseeAdd;
	}
	public void setAddresseeAdd(String addresseeAdd) {
		AddresseeAdd = addresseeAdd;
	}
	public String getAddresseeCompany() {
		return AddresseeCompany;
	}
	public void setAddresseeCompany(String addresseeCompany) {
		AddresseeCompany = addresseeCompany;
	}
	public String getAddresseePhoneNumber() {
		return AddresseePhoneNumber;
	}
	public void setAddresseePhoneNumber(String addresseePhoneNumber) {
		AddresseePhoneNumber = addresseePhoneNumber;
	}
	public int getNumOfGoods() {
		return numOfGoods;
	}
	public void setNumOfGoods(int numOfGoods) {
		this.numOfGoods = numOfGoods;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public ExpressType getExpressType() {
		return expressType;
	}
	public void setExpressType(ExpressType expressType) {
		this.expressType = expressType;
	}
	public int getNumOfCartons() {
		return numOfCartons;
	}
	public void setNumOfCartons(int numOfCartons) {
		this.numOfCartons = numOfCartons;
	}
	public int getNumOfWoodenBox() {
		return numOfWoodenBox;
	}
	public void setNumOfWoodenBox(int numOfWoodenBox) {
		this.numOfWoodenBox = numOfWoodenBox;
	}
	public int getNumOfBags() {
		return numOfBags;
	}
	public void setNumOfBags(int numOfBags) {
		this.numOfBags = numOfBags;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGenerationDate() {
		return generationDate;
	}
	public void setGenerationDate(String generationDate) {
		this.generationDate = generationDate;
	}
	public String getExpectedArrivalDate() {
		return expectedArrivalDate;
	}
	public void setExpectedArrivalDate(String expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}
	public String getActualArrivalDate() {
		return actualArrivalDate;
	}
	public void setActualArrivalDate(String actualArrivalDate) {
		this.actualArrivalDate = actualArrivalDate;
	}
	public String getActualAddresseeName() {
		return actualAddresseeName;
	}
	public void setActualAddresseeName(String actualAddresseeName) {
		this.actualAddresseeName = actualAddresseeName;
	}
	private String expectedArrivalDate;
	private String actualArrivalDate;
	private String actualAddresseeName;
}

