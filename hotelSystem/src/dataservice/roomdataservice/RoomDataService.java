package dataservice.roomdataservice;

import java.util.Date;
import java.util.List;

import po.RoomPO;
import po.UsagePO;

public interface RoomDataService {
	
	public boolean addRoomType(int hotelID, RoomPO po);
	
	public boolean updateRoomType(int roomID, RoomPO po);
	
	public boolean deleteRoomPO(int roomID);
	
	public List<RoomPO> getRoomType(int roomID);
	
	public List<UsagePO> getUsagePO(int roomID, Date start, Date end);
	
	public boolean updateUsage(int roomID, Date start, Date end, int delta);
	
}
