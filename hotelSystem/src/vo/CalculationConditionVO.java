package vo;

import java.time.LocalDate;

public class CalculationConditionVO {

	public int roomID;
	public int customerID;
	public LocalDate startDate;
	public LocalDate endDate;
	public int roomNum;
	public boolean hasChildren;
	
	public CalculationConditionVO(int roomID, int customerID, LocalDate startDate, LocalDate endDate, int roomNum, boolean hasChildren) {
		// TODO Auto-generated constructor stub
		this.roomID = roomID;
		this.customerID = customerID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomNum = roomNum;
		this.hasChildren = hasChildren;
	}
	
}
