package vo;

import java.time.LocalDate;

public class ProducingOrderVO {

	public int customerID;
	public int hotelID;
	public String roomName;
	public LocalDate startDate;
	public LocalDate endDate;
	public int roomNum;
	public boolean hasChildren;
	public int total;
	
	public ProducingOrderVO(int customerID, int hotelID, ) {
		// TODO Auto-generated constructor stub
	}
}
