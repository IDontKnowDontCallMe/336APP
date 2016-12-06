package data.roomdata;

import java.util.Date;
import java.util.List;

import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import po.UsagePO;

public class RoomDataServiceImpl implements RoomDataService{
	
	private RoomTypeDao roomTypeDao;
	private RoomUsageDao roomUsageDao;
	
	public RoomDataServiceImpl() {
		// TODO Auto-generated constructor stub
		roomTypeDao = RoomDaoFactory.getRoomTypeDao();
		roomUsageDao = RoomDaoFactory.getRoomUsageDao();
	}

	@Override
	public boolean addRoomType(int hotelID, RoomPO po) {
		// TODO Auto-generated method stub
		return roomTypeDao.addRoomType(hotelID, po);
	}

	@Override
	public boolean updateRoomType(int roomID, RoomPO po) {
		// TODO Auto-generated method stub
		return roomTypeDao.updateRoomType(roomID, po);
	}

	@Override
	public boolean deleteRoomPO(int roomID) {
		// TODO Auto-generated method stub
		return roomTypeDao.deleteRoomPO(roomID);
	}

	@Override
	public List<RoomPO> getRoomType(int hotelID) {
		// TODO Auto-generated method stub
		return roomTypeDao.getRoomType(hotelID);
	}

	@Override
	public List<UsagePO> getUsagePO(int roomID, Date start, Date end) {
		// TODO Auto-generated method stub
		return roomUsageDao.getUsagePO(roomID, start, end);
	}

	@Override
	public boolean updateUsage(int roomID, Date start, Date end, int delta) {
		// TODO Auto-generated method stub
		return roomUsageDao.updateUsage(roomID, start, end, delta);
	}

}
