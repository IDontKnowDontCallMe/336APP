package businesslogic.roombl;

import businesslogicservice.roomblservice.RoomBLService;
import po.RoomPO;
import vo.RoomVO;

public class RoomBLService_Stub implements RoomBLService{
	
	RoomVO example = new RoomVO();
	
	public RoomBLService_Stub(String roomType, int roomPrice, int number) {
		// TODO Auto-generated constructor stub
		example.roomName = roomType;
		example.price = roomPrice;
		example.numOfRoom = number;
	}
	
	public RoomVO getInfo(String hotel, String roomType){
		return example;
	}
	
	public void add(RoomPO po){
		System.out.println("Add successfully");
	}

	public void delete(RoomPO po){
		System.out.println("Delete successfully");
	}
	
	public void update(RoomPO po){
		System.out.println("Update successfully");
	}

	@Override
	public void add(String hotelID, RoomPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String hotelID, RoomPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delet(String hotelID, RoomPO po) {
		// TODO Auto-generated method stub
		
	}
	

	
}
