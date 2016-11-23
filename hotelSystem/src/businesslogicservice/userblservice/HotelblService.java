package businesslogicservice.userblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.HotelPO;
import vo.HotelVO;

public interface HotelblService extends Remote{
	
	public HotelVO[] geHotelList() throws RemoteException;
	
	public HotelVO getHotel(String userID) throws RemoteException;
	
	public void updateHotel(HotelPO po) throws RemoteException;
	
	public void deleteHotel(HotelPO po) throws RemoteException;
	
	public void addHotel(HotelPO po) throws RemoteException;
	

}
