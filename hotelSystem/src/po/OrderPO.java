package po;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class OrderPO {
	
	private int orderID;
	private String customerName;
	private int customerID;
	private LocalDateTime producingDateTime;
	private String hotelName;
	private int hotelD;
	private String roomName;
	private int roomNum;
	private boolean hasChildren;
	private int peopleNum;
	private LocalDate checkInDate;
	private LocalTime latestArrivingTime;
	private LocalDate checkOutDate;
	private int total;
	private String orderState;
	private LocalDateTime revokingDateTime;
	private LocalDateTime executingDateTime;
	private LocalDateTime leavingDateTime;
	
	public OrderPO(int orderID, String customerName, int customerID, LocalDateTime producingDateTime, String hotelName, int hotelID,
			       String roomName, int roomNum, boolean hasChildren, int peopleNum, LocalDate checkInDate, LocalTime lastestArrivingTime, 
			       LocalDate checkOutDate, int total, String orderState, LocalDateTime revokingDateTime, LocalDateTime executingDateTime,
			       LocalDateTime leavingDateTime){
		this.orderID = orderID;
		this.customerName = customerName;
		this.customerID = customerID;
		this.producingDateTime = producingDateTime;
		this.hotelName = hotelName;
		this.hotelD = hotelID;
		this.roomName = roomName;
		this.roomNum = roomNum;
		this.hasChildren = hasChildren;
		this.peopleNum = peopleNum;
		this.checkInDate = checkInDate;
		this.latestArrivingTime = lastestArrivingTime;
		this.checkOutDate = checkOutDate;
		this.total = total;
		this.orderState = orderState;
		this.revokingDateTime = revokingDateTime;
		this.executingDateTime = executingDateTime;
		this.leavingDateTime = leavingDateTime;
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
	
	public void setProducingDateTime(LocalDateTime producingDateTime){
		this.producingDateTime = producingDateTime;
	}
	
	public LocalDateTime getProducingDateTime(){
		return this.producingDateTime;
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
	
	public void setCheckInDate(LocalDate checkInDate){
		this.checkInDate = checkInDate;
	}
	
	public LocalDate getCheckInDate(){
		return this.checkInDate;
	}
	
	public void setLatestArrivingTime(LocalTime latestArringTime){
		this.latestArrivingTime = latestArringTime;
	}
	
	public LocalTime getLatestArrivingTime(){
		return this.latestArrivingTime;
	}
	
	public void setCheckOutDate(LocalDate checkOutDate){
		this.checkOutDate = checkOutDate;
	}
	
	public LocalDate getCheckOutDate(){
		return this.checkOutDate;
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
	
	public void setRevokingDateTime(LocalDateTime revokingDateTime){
		this.revokingDateTime = revokingDateTime;
	}
	
	public LocalDateTime getRevokingDateTime(){
		return this.revokingDateTime;
	}
	
	public void setExecutingDateTime(LocalDateTime executingDateTime){
		this.executingDateTime = executingDateTime;
	}
	
	public LocalDateTime getExecutingDateTime(){
		return this.executingDateTime;
	}
	
	public void setLeavingDateTime(LocalDateTime leavingDateTime){
		this.leavingDateTime = leavingDateTime;
	}
	
	public LocalDateTime getLeavingDateTime(){
		return this.leavingDateTime;
	}

}
