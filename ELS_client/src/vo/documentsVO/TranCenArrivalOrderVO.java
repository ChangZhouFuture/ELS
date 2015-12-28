package vo.documentsVO;
import state.AgencyType;
import state.ApproState;
import state.GoodState;

public class TranCenArrivalOrderVO {
	private String ID;
    private String tranCenID;
    private String arrivalDate;
    private String transferOrderID; //中转单编号或营业厅装车编号
    private String origin;
    private String generateTime;
    private AgencyType agencyType; //从营业厅送来的还是从中转中心送来的
    private GoodState goodState;
    private ApproState approState;
    
	public AgencyType getAgencyType() {
		return agencyType;
	}
	public void setAgencyType(AgencyType agencyType) {
		this.agencyType = agencyType;
	}
	public ApproState getApproState() {
		return approState;
	}
	public void setApproState(ApproState approState) {
		this.approState = approState;
	}
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