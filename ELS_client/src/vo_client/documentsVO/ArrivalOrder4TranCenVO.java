package vo_client.documentsVO;
import state.GoodState;

public class ArrivalOrder4TranCenVO {
	String id;
	String tranorderoid;
	String startaddress;
	String date;
	GoodState goodstate;
	String trancenterid;
	public ArrivalOrder4TranCenVO(String id,
			String tranorderoid, String startaddress, String date, GoodState goodstate, String trancenterid) {
		this.id=id;
		this.tranorderoid=tranorderoid;
		this.startaddress=startaddress;
		this.date=date;
		this.goodstate=goodstate;
		this.trancenterid=trancenterid;
}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTranorderoid() {
		return tranorderoid;
	}
	public void setTranorderoid(String tranorderoid) {
		this.tranorderoid = tranorderoid;
	}
	public String getStartaddress() {
		return startaddress;
	}
	public void setStartaddress(String startaddress) {
		this.startaddress = startaddress;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public GoodState getGoodstate() {
		return goodstate;
	}
	public void setGoodstate(GoodState goodstate) {
		this.goodstate = goodstate;
	}
	public String getTrancenterid() {
		return trancenterid;
	}
	public void setTrancenterid(String trancenterid) {
		this.trancenterid = trancenterid;
	}
} 