package vo;

import java.time.LocalDate;

public class CalculationConditionVO {

	public int hotelID;
	public int roomID;
	public int customerID;
	public LocalDate startDate;
	public LocalDate endDate;
	public int roomNum;
	public int roomPrice;
	public boolean hasChildren;
	
	public CalculationConditionVO(int hotelID, int roomID, int customerID, LocalDate startDate, LocalDate endDate, int roomNum, int roomPrice, boolean hasChildren) {
		// TODO Auto-generated constructor stub
		this.hotelID = hotelID;
		this.roomID = roomID;
		this.customerID = customerID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomNum = roomNum;
		this.roomPrice = roomPrice;
		this.hasChildren = hasChildren;
	}
	
}
