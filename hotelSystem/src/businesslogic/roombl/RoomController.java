package businesslogic.roombl;

import java.util.Date;
import java.util.List;

import businesslogicservice.roomblservice.RoomBLService;
import po.RoomPO;

public class RoomController implements RoomBLService{

	@Override
	public boolean addRoomType(int hotelID, RoomPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRoomType(int hotelID, RoomPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRoomType(int roomID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RoomPO> getRoomType(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(int roomID, Date start, Date end, int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUsage(int roomID, Date start, Date end, int num) {
		// TODO Auto-generated method stub
		return false;
	}

}
