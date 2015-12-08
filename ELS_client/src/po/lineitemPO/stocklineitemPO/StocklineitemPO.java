package po.lineitemPO.stocklineitemPO;

import java.io.Serializable;


public class StocklineitemPO implements Serializable{
	private String id;
	private String areaNum;                              //ÇøºÅ
	private String rowNum;                               //ÅÅºÅ
	private String frameNum;                             //¼ÜºÅ
	private String positionNum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
}
