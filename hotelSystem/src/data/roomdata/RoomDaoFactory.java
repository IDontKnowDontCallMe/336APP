package data.roomdata;

public class RoomDaoFactory {
	
	private static RoomTypeDao roomTypeDao;
	private static RoomUsageDao roomUsageDao;
	
	public static RoomTypeDao getRoomTypeDao(){
		if(roomTypeDao==null){
			roomTypeDao = new RoomTypeDaoImpl();
		}
		return roomTypeDao;
	}
	
	public static RoomUsageDao getRoomUsageDao(){
		if(roomUsageDao==null){
			roomUsageDao = new RoomUsageDaoImpl();
		}
		return roomUsageDao;
	}

}
