package businesslogic.roombl;

import java.util.ArrayList;
import java.util.List;

import data.factory.DataFactory;
import po.RoomPO;
import vo.RoomVO;

public class RoomBLImpl {

	public boolean addRoomType(int hotelID, RoomVO roomVO){
		RoomPO roomPO = new RoomPO();
		roomPO.setRoomName(roomVO.roomName);
		roomPO.setNumofRooms(roomVO.numOfRoom);
		roomPO.setprice(roomVO.price);
		return DataFactory.getRoomDataService().addRoomType(hotelID, roomPO);
		
	};
	
	public boolean updateRoomType(int hotelID, RoomVO roomVO){
		RoomPO roomPO = new RoomPO();
		roomPO.setRoomName(roomVO.roomName);
		roomPO.setNumofRooms(roomVO.numOfRoom);
		roomPO.setprice(roomVO.price);
		return DataFactory.getRoomDataService().updateRoomType(hotelID, roomPO);
		
	};
	
	public boolean deleteRoomType(int roomID) {
		return DataFactory.getRoomDataService().deleteRoomPO(roomID);
		
	};
	
	public List<RoomVO> getRoomTypeList(int hotelID) {
		List<RoomPO> poList = DataFactory.getRoomDataService().getRoomType(hotelID);
		List<RoomVO> volist = new ArrayList<RoomVO>();
		for(RoomPO po: poList){
			RoomVO roomVO = new RoomVO(po.getRoomID(), po.getRoomName(), po.getPrice(), po.getNumOfRoom(), po.getService(), po.getMaxNumOfPeople());
			volist.add(roomVO);
		}
		return volist;
		
	};
	
	public RoomVO getRoomType(int roomID){
		RoomVO roomVO;
		return DataFactory.getRoomDataService().getRoomType(roomID);
		
	};
}
