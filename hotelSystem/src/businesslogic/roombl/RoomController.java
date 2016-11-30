package businesslogic.roombl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import businesslogicservice.roomblservice.RoomBLService;
import po.RoomPO;
import vo.RoomVO;

public class RoomController implements RoomBLService{
	RoomBLImpl roomblImpl = new RoomBLImpl();

	@Override
	public boolean addRoomType(int hotelID, RoomVO roomVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRoomType(int hotelID, RoomVO roomVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRoomType(int roomID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RoomVO> getRoomTypeList(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomVO getRoomType(int roomID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
