package businesslogic.utilitybl;

import businesslogic.userbl.Login;
import state.ExpressType;
import state.TransportType;

public class CalculateFreight {
	public static String origin = Login.city;
	
	public static double expressFreight(String destination, double weight, ExpressType
			eType) {
		destination = destination.substring(0, 2);
		double distance = calculateDistance(destination);
		double freight = distance / 1000 * 23;
		if (eType == ExpressType.Economic) {
			freight = (double)18 / 23 * freight;
		} 
		else if (eType == ExpressType.EMS) {
			freight = (double)25 / 23 * freight;
		}
		
		freight = Double.valueOf(String.format("%.2f", freight));
		return freight;
	}
	
	public static double transportCost(String destination, TransportType tType) {
		double distance = calculateDistance(destination);
		double cost = 0;
		
		switch (tType) {
		case Plane:
			cost = distance * 20 * 50;//假设均满载
			break;
		case Train:
			cost = distance * 0.2 * 2000;
			break;
		case Truck:
			cost = distance * 2 * 10;
			break;
		default:
			break;
		}
		
		return cost;
	}
	
	public static double calculateDistance(String destination) {
		double distance = 0;
		
		if (origin.equals(destination)) {
			distance = 30;
		}
		
		if (origin.equals("北京")) {
			switch (destination) {
			case "上海":
				distance = 1064.7;
				break;
			case "广州":
				distance = 1888.8;
				break;
			case "南京":
				distance = 900;
				break;
			default:
				break;
			}
		} 
		else if(origin.equals("上海")) {
			switch (destination) {
			case "北京":
				distance = 1064.7;
				break;
			case "广州":
				distance = 1213;
				break;
			case "南京":
				distance = 266;
				break;
			default:
				break;
			}
		}
		else if (origin.equals("广州")) {
			switch (destination) {
			case "北京":
				distance = 1888.8;
				break;
			case "上海":
				distance = 1213;
				break;
			case "南京":
				distance = 1132;
				break;
			default:
				break;
			}
		}
		else if (origin.equals("南京")) {
			switch (destination) {
			case "北京":
				distance = 900;
				break;
			case "上海":
				distance = 266;
				break;
			case "广州":
				distance = 1132;
				break;
			default:
				break;
			}
		}
		
		return distance;
	}
	
}
