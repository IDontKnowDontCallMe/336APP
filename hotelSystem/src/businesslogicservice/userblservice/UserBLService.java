package businesslogicservice.userblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;
import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

public interface UserBLService extends Remote{

	public List<CustomerVO> getCustomerList() throws RemoteException;
	
	public boolean updateCustomer(CustomerVO customerVO) throws RemoteException;
	
	public List<HotelVO> getHotelList() throws RemoteException;
	
	public boolean addHotel(HotelVO hotelVO) throws RemoteException;
	
	public boolean updateHotelWorker(HotelVO hotelVO) throws RemoteException;
	
	public List<WebMarketerVO> getWebMarketerList() throws RemoteException;
	
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException;
	
	public boolean updateWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException;
	
	public boolean deleteWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException;
	
	public boolean updateCreditOfCustomer(int customerID, int delta);

	
	public String login(int userID, String password) throws RemoteException;
}
