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
			cost = distance * 20 * 50;//���������
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
		
		if (origin.equals("����")) {
			switch (destination) {
			case "�Ϻ�":
				distance = 1064.7;
				break;
			case "����":
				distance = 1888.8;
				break;
			case "�Ͼ�":
				distance = 900;
				break;
			default:
				break;
			}
		} 
		else if(origin.equals("�Ϻ�")) {
			switch (destination) {
			case "����":
				distance = 1064.7;
				break;
			case "����":
				distance = 1213;
				break;
			case "�Ͼ�":
				distance = 266;
				break;
			default:
				break;
			}
		}
		else if (origin.equals("����")) {
			switch (destination) {
			case "����":
				distance = 1888.8;
				break;
			case "�Ϻ�":
				distance = 1213;
				break;
			case "�Ͼ�":
				distance = 1132;
				break;
			default:
				break;
			}
		}
		else if (origin.equals("�Ͼ�")) {
			switch (destination) {
			case "����":
				distance = 900;
				break;
			case "�Ϻ�":
				distance = 266;
				break;
			case "����":
				distance = 1132;
				break;
			default:
				break;
			}
		}
		
		return distance;
	}
	
}
