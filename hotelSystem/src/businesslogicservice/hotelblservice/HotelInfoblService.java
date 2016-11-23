package businesslogicservice.hotelblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.AreaPO;
import po.ConditionPO;
import po.HotelPO;
import vo.HotelVO;

public interface HotelInfoblService extends Remote{
	
	public HotelVO getHotelInfo(String hotel) throws RemoteException;
	
	public HotelVO[] search(AreaPO apo, ConditionPO cpo) throws RemoteException;
	
	public HotelVO[] sort(HotelPO[] poList, String sortType) throws RemoteException;
	
	public void update(HotelPO po) throws RemoteException;
	
	public void delete(HotelPO po) throws RemoteException;

}
