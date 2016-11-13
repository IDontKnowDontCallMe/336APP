package data.roomdata;

import java.util.List;

import po.RoomPO;

public interface RoomTypeDao {

	public boolean addRoomType(int hotelID, RoomPO po);
	
	public boolean updateRoomType(int roomID, RoomPO po);
	
	public boolean deleteRoomPO(int roomID);
	
	public List<RoomPO> getRoomType(int hotelID);
	
}
