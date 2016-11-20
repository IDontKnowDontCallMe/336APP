package presentation.orderui;

import java.util.Date;

public class CalculatingConditionVO {

	public int customerID;
	public int roomID;
	public Date start;
	public Date end;
	public int num;
	
	public CalculatingConditionVO(int customerID, int roomID, Date start, Date end, int num) {
		// TODO Auto-generated constructor stub
		this.customerID = customerID;
		this.roomID = roomID;
		this.start = start;
		this.end = end;
		this.num = num;
	}
	
}
