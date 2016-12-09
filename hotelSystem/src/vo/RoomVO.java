package vo;

import java.io.Serializable;

public class RoomVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int roomID;
	public String roomName;
	public int price;
	public int numOfRoom;
	public String introduction;
	public int maxNumOfPeople;
	
	public RoomVO(int roomID, String roomName, int price, int numOfRoom, String introduction, int maxNumOfPeople) {
		// TODO Auto-generated constructor stub
		this.roomID = roomID;
		this.roomName = roomName;
		this.price = price;
		this.numOfRoom = numOfRoom;
		this.introduction = introduction;
		this.maxNumOfPeople = maxNumOfPeople;
	}

}
