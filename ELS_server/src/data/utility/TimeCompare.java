package data.utility;

public class TimeCompare {

	public int dateCompare(String date1,String date2){       //yyyy-mm-dd
		int year1=Integer.parseInt(date1.substring(0,4));
		int year2=Integer.parseInt(date2.substring(0,4));
		int month1=Integer.parseInt(date1.substring(5,7));
		int month2=Integer.parseInt(date2.substring(5,7));
		int day1=Integer.parseInt(date1.substring(8,10));
		int day2=Integer.parseInt(date2.substring(8,10));
		if(year1<year2){
			return 1;
		}else if(year1>year2){
			return 3;
		}else{
			if(month1<month2){
				return 1;
			}else if(month1>month2){
				return 3;
			}else{
				if(day1<day2){
					return 1;
				}else if(day1>day2){
					return 3;
				}else{
					return 2;
				}
			}
			
		}
		
	}
	
	public int timeCompare(String time1,String time2){         //yyyy-mm-dd hh-mm-ss
		int year1=Integer.parseInt(time1.substring(0,4));
		int year2=Integer.parseInt(time2.substring(0,4));
		int month1=Integer.parseInt(time1.substring(5,7));
		int month2=Integer.parseInt(time2.substring(5,7));
		int day1=Integer.parseInt(time1.substring(8,10));
		int day2=Integer.parseInt(time2.substring(8,10));
		int hour1=Integer.parseInt(time1.substring(11, 13));
		int hour2=Integer.parseInt(time2.substring(11, 13));
		int min1=Integer.parseInt(time1.substring(14, 16));
		int min2=Integer.parseInt(time2.substring(14, 16));
		int sec1=Integer.parseInt(time1.substring(17, 19));
		int sec2=Integer.parseInt(time2.substring(17, 19));
		if(year1<year2){
			return 1;
		}else if(year1>year2){
			return 3;
		}else{
			if(month1<month2){
				return 1;
			}else if(month1>month2){
				return 3;
			}else{
				if(day1<day2){
					return 1;
				}else if(day1>day2){
					return 3;
				}else{
				    if(hour1<hour2){
				    	return 1;
				    }else if(hour1>hour2){
				    	return 3;
				    }else{
				    	if(min1<min2){
				    		return 1;
				    	}else if(min1>min2){
				    		return 3;
				    	}else{
				    		if(sec1<sec2){
				    			return 1;
				    		}else if(sec1>sec2){
				    			return 3;
				    		}else{
				    			return 2;
				    		}
				    	}
				    }
				}
			}
			
		}
	}
}
