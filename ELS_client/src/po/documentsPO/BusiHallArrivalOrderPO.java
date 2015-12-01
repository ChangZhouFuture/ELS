package po.documentsPO;


import java.io.Serializable;

import state.GoodState;

 public class BusiHallArrivalOrderPO implements Serializable{
	 private String Id;
		private String busiHallID;
		private String arrivalDate;
		private String transferOrderID;
		private String origin;
		private GoodState goodState;
		private String generateTime;
		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		public String getBusiHallID() {
			return busiHallID;
		}
		public void setBusiHallID(String busiHallID) {
			this.busiHallID = busiHallID;
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
