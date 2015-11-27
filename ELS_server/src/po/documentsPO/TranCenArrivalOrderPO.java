package po.documentsPO;

import java.io.Serializable;

import state.GoodState;

 public class TranCenArrivalOrderPO implements Serializable{
	 private String ID;
	    private String tranCenID;
	    private String arrivalDate;
	    private String transferOrderID;
	    private String origin;
	    private GoodState goodState;
	    private String generateTime;
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public String getTranCenID() {
			return tranCenID;
		}
		public void setTranCenID(String tranCenID) {
			this.tranCenID = tranCenID;
		}
		public String getArrivalDate() {
			return arrivalDate;
		}
		public void setArrivalDate(String arrivalDate) {
			this.arrivalDate = arrivalDate;
		}
		public String getTransferOrderID() {
			return transferOrderID;
		}
		public void setTransferOrderID(String transferOrderID) {
			this.transferOrderID = transferOrderID;
		}
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		public GoodState getGoodState() {
			return goodState;
		}
		public void setGoodState(GoodState goodState) {
			this.goodState = goodState;
		}
		public String getGenerateTime() {
			return generateTime;
		}
		public void setGenerateTime(String generateTime) {
			this.generateTime = generateTime;
		}
 }
