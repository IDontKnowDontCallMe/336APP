package po;

import java.util.Date;

public class OrderPO {
	
	private int orderID;
	private String customerName;
	private int customerID;
	private Date producingTime;
	private String hotelName;
	private int hotelD;
	private String roomName;
	private int roomNum;
	private boolean hasChildren;
	private int peopleNum;
	private Date checkInTime;
	private Date checkOutTime;
	private int total;
	private String orderState;
	private Date revokingTime;
	
	public OrderPO(int orderID, String customerName, int customerID, Date producingTime, String hotelName, int hotelID,
			       String roomName, int roomNum, boolean hasChildren, int peopleNum, Date checkInTime, Date checkOutTime, 
			       int total, String orderState, Date revokingTime){
		this.orderID = orderID;
		this.customerName = customerName;
		this.customerID = customerID;
		this.producingTime = producingTime;
		this.hotelName = hotelName;
		this.roomName = roomName;
		this.hasChildren = hasChildren;
		this.peopleNum = peopleNum;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.total = total;
		this.orderState = orderState;
		this.roomNum = roomNum;
		this.revokingTime = revokingTime;
	}
	
	public void setOrderID(int orderID){
		this.orderID = orderID;
	}
	
	public int getOrderID(){
		return this.orderID;
	}
	
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}	
	
	public String getCustomerName(){
		return this.customerName;
	}
	
	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}
	
	public int getCustomerID(){
		return this.customerID;
	}
	
	public void setProducingTime(Date producingTime){
		this.producingTime = producingTime;
	}
	
	public Date getProducingTime(){
		return this.producingTime;
	}
	
	public void setHotelName(String hotelName){
		this.hotelName = hotelName;
	}
	
	public String getHotelName(){
		return this.hotelName;
	}
	
	public void setHotelID(int hotelID){
		this.hotelD = hotelID;
	}
	
	public int getHotelID(){
		return this.hotelD;
	}
	
	public void setRoomName(String roomName){
		this.roomName = roomName;
	}
	
	public String getRoomName(){
		return this.roomName;
	} 
	
	public void setRoomNum(int roomNum){
		this.roomNum = roomNum;
	}
	
	public int getRoomNum(){
		return this.roomNum;
	}
	
	public void setHasChildren(boolean hasChildren){
		this.hasChildren = hasChildren;
	}
	
	public boolean getHasChildren(){
		return this.hasChildren;
	}
	
	public void setPeopleNum(int peopleNum){
		this.peopleNum = peopleNum;
	}
	
	public int getPeopleNum(){
		return this.peopleNum;
	}
	
	public void setCheckInTime(Date checkInTime){
		this.checkInTime = checkInTime;
	}
	
	public Date getCheckInTime(){
		return this.checkInTime;
	}
	
	public void setCheckOutTime(Date checkOutTime){
		this.checkOutTime = checkOutTime;
	}
	
	public Date getCheckOutTime(){
		return this.checkOutTime;
	}
	
	public void setTotal(int total){
		this.total = total;
	}
	
	public int getTotal(){
		return this.total;
	}
	
	public void setOrderState(String orderState){
		this.orderState = orderState;
	}
	
	public String getOrderState(){
		return this.orderState;
	}
	
	public void setRevokingTime(Date revokingTime){
		this.revokingTime = revokingTime;
	}
	
	public Date getRevokingTime(){
		return this.revokingTime;
	}

}
