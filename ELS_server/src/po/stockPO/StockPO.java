package po.stockPO;

import java.io.Serializable;

public class StockPO implements Serializable{
	private String id;
	private String tranCenID;
	private String inDate;
	private String destination;
	private String areaNum;                              //ÇøºÅ
	private String rowNum;                               //ÅÅºÅ
	private String frameNum;                             //¼ÜºÅ
	private String positionNum;                          //Î»ºÅ
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getAreaNum() {
		return areaNum;
	}
	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}
	public String getRowNum() {
		return rowNum;
	}
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	public String getFrameNum() {
		return frameNum;
	}
	public void setFrameNum(String frameNum) {
		this.frameNum = frameNum;
	}
	public String getPositionNum() {
		return positionNum;
	}
	public void setPositionNum(String positionNum) {
		this.positionNum = positionNum;
	}
	public String getTranCenID() {
		return tranCenID;
	}
	public void setTranCenID(String tranCenID) {
		this.tranCenID = tranCenID;
	}
}
