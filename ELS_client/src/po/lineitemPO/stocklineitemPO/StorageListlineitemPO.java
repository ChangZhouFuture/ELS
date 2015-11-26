package po.lineitemPO.stocklineitemPO;

public class StorageListlineitemPO{
	String id4e;
	
	String desti;
	
	String dis;
	
	String row;
	
	String she;
	
	String pos;
	
	String time;
	
	String id4obo;
	
	
	public StorageListlineitemPO(String id4e, String desti, String dis, String row, String she,String pos, String time){
		super();
		this.id4e = id4e;
		this.desti = desti;
		this.dis = dis;
		this.row = row;
		this.she = she;
		this.pos = pos;
	}

	public String getId() {
		return this.id4obo;
	}
	
	public String getTime() {
		return this.time;
	}
	
	
	public String getId4e() {
		return id4e;
	}


	public void setId4e(String id4e) {
		this.id4e = id4e;
	}


	public String getDesti() {
		return desti;
	}


	public void setDesti(String desti) {
		this.desti = desti;
	}


	public String getDis() {
		return dis;
	}


	public void setDis(String dis) {
		this.dis = dis;
	}


	public String getRow() {
		return row;
	}


	public void setRow(String row) {
		this.row = row;
	}


	public String getShe() {
		return she;
	}


	public void setShe(String she) {
		this.she = she;
	}


	public String getPos() {
		return pos;
	}


	public void setPos(String pos) {
		this.pos = pos;
	}
	
	
}
