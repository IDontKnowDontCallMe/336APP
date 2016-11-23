package businesslogicservice.roomblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import po.RoomPO;

public interface RoomBLService extends Remote{
	
	public boolean addRoomType(int hotelID, RoomPO po) throws RemoteException;
	
	public boolean updateRoomType(int hotelID, RoomPO po) throws RemoteException;
	
	public boolean deleteRoomType(int roomID) throws RemoteException;
	
	public List<RoomPO> getRoomType(int hotelID) throws RemoteException;
	
	public boolean isValid(int roomID, Date start, Date end, int num) throws RemoteException;
	
	public boolean updateUsage(int roomID, Date start, Date end, int num) throws RemoteException;
}
