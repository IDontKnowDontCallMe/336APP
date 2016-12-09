package vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import sun.misc.GC.LatencyRequest;

public class OrderVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int orderID;
	public String customerName;
	public int customerID;
	public String customerPhoneNumber;
	public LocalDateTime producingTime;
	public String hotelName;
	public String roomName;
	public int roomNum;
	public int peopleNum;
	public boolean hasChildren;
	public LocalDate checkInTime;
	public LocalTime lastestArrivingTime;
	public LocalDate checkOutTime;
	public int total;
	public String orderState;
	public boolean hasComment;
	
	public OrderVO(int orderID, String customerName, int customerID, String customerPhoneNumber,LocalDateTime producingTime, String hotelName, String roomName,
					int roomNum, int peopleNum, boolean hasChildren, LocalDate checkInTime, LocalTime lastestArrivingTime,LocalDate checkOutTime, int total, 
					String orderState, boolean hasComment){
		this.orderID = orderID;
		this.customerName = customerName;
		this.customerID = customerID;
		this.customerPhoneNumber = customerPhoneNumber;
		this.producingTime = producingTime;
		this.hotelName = hotelName;
		this.roomName = roomName;
		this.roomNum = roomNum;
		this.peopleNum = peopleNum;
		this.hasChildren = hasChildren;
		this.checkInTime = checkInTime;
		this.lastestArrivingTime = lastestArrivingTime;
		this.checkOutTime = checkOutTime;
		this.total = total;
		this.orderState = orderState;
		this.hasComment = hasComment;
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
		this.lastestArrivingTime = vo.lastestArrivingTime;
		this.checkOutTime = vo.checkOutTime;
		this.total = vo.total;
		this.orderState = vo.orderState;
		this.hasComment = vo.hasComment;
	}
	
}
