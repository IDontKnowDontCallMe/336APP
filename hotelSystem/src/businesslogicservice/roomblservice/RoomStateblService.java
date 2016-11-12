package businesslogicservice.roomblservice;

import po.ConditionPO;
import po.RoomPO;

public interface RoomStateblService {
	
	public void update(String hotelID, RoomPO po, String time, int num, String type);
	
	public int getNumOfRoom(String hotelID, String room, String time);
	
	public boolean isValid(String hotelID, ConditionPO po);

}
