package businesslogicservice.roomblservice;

import java.util.Date;
import java.util.List;

import po.RoomPO;
import vo.RoomVO;

public interface RoomBLService {
	
	public boolean addRoomType(int hotelID, RoomPO po);
	
	public boolean updateRoomType(int hotelID, RoomPO po);
	
	public boolean deleteRoomType(int roomID);
	
	public List<RoomPO> getRoomType(int hotelID);
	
	public boolean isValid(int roomID, Date start, Date end, int num);
	
	public boolean updateUsage(int roomID, Date start, Date end, int num);
}
