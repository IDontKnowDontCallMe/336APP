package businesslogic.roombl;

import java.util.List;

import data.factory.DataFactory;
import po.RoomPO;
import vo.RoomVO;

public class RoomBLImpl {
	DataFactory dataFactory;

	public boolean addRoomType(int hotelID, RoomPO roomPO){
		return dataFactory.getRoomDataService().addRoomType(hotelID, roomPO);
		
	};
	
	public boolean updateRoomType(int hotelID, RoomPO roomPO){
		return dataFactory.getRoomDataService().updateRoomType(hotelID, roomPO);
		
	};
	
	public boolean deleteRoomType(int roomID) {
		return false;
		
	};
	
	public List<RoomVO> getRoomTypeList(int hotelID) {
		return null;
		
	};
	
	public RoomVO getRoomType(int roomID){
		return null;
		
	};
}
