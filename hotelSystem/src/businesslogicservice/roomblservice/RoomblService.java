package businesslogicservice.roomblservice;

import po.RoomPO;
import vo.RoomVO;

public interface RoomblService {
	
	public void add(String hotelID, RoomPO po);
	
	public void update(String hotelID, RoomPO po);
	
	public void delet(String hotelID, RoomPO po);
	
	public RoomVO getInfo(String hotelID, String roomType);

}
