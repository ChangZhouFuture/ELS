package po_client.documentsPO;


import state.GoodState;

 public class ArrivalOrder4BusiHallPO{
 
	private String id;
	private String toid;
	private String startingAdd;
	private String date;
	private GoodState goodState;
	
	public ArrivalOrder4BusiHallPO(String id,String toid,String startingAdd,String date,GoodState goodState){
		super();
		this.id=id;
		this.toid=toid;
		this.startingAdd=startingAdd;
		this.date=date;
		this.goodState=goodState;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToid() {
		return toid;
	}

	public void setToid(String toid) {
		this.toid = toid;
	}

	public String getSa() {
		return startingAdd;
	}

	public void setSa(String sa) {
		this.startingAdd = startingAdd;
	}

	public String getD() {
		return date;
	}

	public void setD(String d) {
		this.date = date;
	}

	public GoodState getGs() {
		return goodState;
	}

	public void setGs(GoodState gs) {
		this.goodState = goodState;
	}
 }
