package po;

public class RoomPO {
	
	String hotelName;
	String roomName;
	String service;
	int price;
	int numOfRoom;
	int MaxNumOfPeople;
	int roomID;
	
	public void setHotelName(String hotelname) {
		this.hotelName = hotelname;
	}
	
	public void setRoomName(String roomname) {
		this.roomName = roomname;
	}
	
	public void setprice(int price) {
		this.price = price;
	}
	
	public void setNumofRooms(int num) {
		this.numOfRoom = num;
	}
	
	public void setService(String string) {
		this.service = string;
	}
	
	public void setMaxNumOfPeople(int maxNum) {
		this.MaxNumOfPeople = maxNum;
	}
	
	public String getHotelName() {
		return this.hotelName;
	}
	
	public String getRoomName() {
		return this.roomName;
	}
	
	public String getService() {
		return this.service;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getNumOfRoom() {
		return this.numOfRoom;
	}
	
	public int getMaxNumOfPeople() {
		return this.MaxNumOfPeople;
	}
	
	public void setRoomID(int ID) {
		this.roomID = ID;
	}

	public int getRoomID() {
		return this.roomID;
	}

}
