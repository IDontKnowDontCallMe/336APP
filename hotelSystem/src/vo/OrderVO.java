package vo;

import java.util.Date;

public class OrderVO {

	public int orderID;
	public String customerName;
	public int customerID;
	public String customerPhoneNumber;
	public Date producingTime;
	public String hotelName;
	public String roomName;
	public int roomNum;
	public boolean hasChildren;
	public Date checkInTime;
	public Date checkOutTime;
	public int total;
	public String orderState;
	
	public OrderVO(int orderID, String customerName, int customerID, String customerPhoneNumber,Date producingTime, String hotelName, String roomName,
					int roomNum, boolean hasChildren, Date checkInTime, Date checkOutTime, int total, String orderState){
		this.orderID = orderID;
		this.customerName = customerName;
		this.customerID = customerID;
		this.customerPhoneNumber = customerPhoneNumber;
		this.producingTime = producingTime;
		this.hotelName = hotelName;
		this.roomName = roomName;
		this.roomNum = roomNum;
		this.hasChildren = hasChildren;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.total = total;
		this.orderState = orderState;
		
	}
	
	public OrderVO(OrderVO vo) {
		this.orderID = vo.orderID;
		this.customerName = vo.customerName;
		this.customerID = vo.customerID;
		this.customerPhoneNumber = vo.customerPhoneNumber;
		this.producingTime = vo.producingTime;
		this.hotelName = vo.hotelName;
		this.roomName = vo.roomName;
		this.roomNum = vo.roomNum;
		this.hasChildren = vo.hasChildren;
		this.checkInTime = vo.checkInTime;
		this.checkOutTime = vo.checkOutTime;
		this.total = vo.total;
		this.orderState = vo.orderState;
	}
	
}
