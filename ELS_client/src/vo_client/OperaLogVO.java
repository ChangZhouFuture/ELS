package vo_client;

public class OperaLogVO extends ParentVO{
	String position;
	
    String name;

	String date;
    
    String action;
    
    public OperaLogVO(String position,String name,String date,String action){
    	super();
    	this.position=position;
    	this.name=name;
    	this.date=date;
    	this.action=action;
    }

    public String getName() {
	    return name;
    }

    public void setName(String name) {
	    this.name = name;
    }

    public String getDate() {
	    return date;
    }

    public void setDate(String date) {
	    this.date = date;
    }

    public String getAction() {
	    return action;
    } 

    public void setAction(String action) {
	    this.action = action;
    }
}
