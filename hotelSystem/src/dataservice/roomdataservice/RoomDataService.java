package dataservice.roomdataservice;

import po.RoomPO;

public interface RoomDataService {
	
	public void add(RoomPO po);

	public void delete(RoomPO po);
	
	public void update(RoomPO po);
	
	public void getInfo(String hotelID, String roomName);
	
}
