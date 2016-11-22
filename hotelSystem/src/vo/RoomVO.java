package vo;

public class RoomVO {
	
	public int roomID;
	public String roomName;
	public int price;
	public int numOfRoom;
	public String service;
	public int maxNumOfPeople;
	
	public RoomVO(int roomID, String roomName, int price, int numOfRoom, String service, int maxNumOfPeople) {
		// TODO Auto-generated constructor stub
		this.roomID = roomID;
		this.roomName = roomName;
		this.price = price;
		this.numOfRoom = numOfRoom;
		this.service = service;
		this.maxNumOfPeople = maxNumOfPeople;
	}

}
