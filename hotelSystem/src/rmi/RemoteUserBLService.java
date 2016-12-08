package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

public interface RemoteUserBLService extends Remote{
	public List<CustomerVO> getCustomerList() throws RemoteException;
	
	public boolean addCustomer(CustomerVO customervo) throws RemoteException;
	
	public boolean updateCustomer(CustomerVO customerVO) throws RemoteException;
	
	public List<HotelVO> getHotelList() throws RemoteException;
	
	public boolean addHotel(HotelVO hotelVO) throws RemoteException;
	
	public boolean updateHotelWorker(HotelVO hotelVO) throws RemoteException;
	
	public List<WebMarketerVO> getWebMarketerList() throws RemoteException;
	
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException;
	
	public boolean updateCreditOfCustomer(int customerID, int delta) throws RemoteException;
	
	public String login(int userID, String password) throws RemoteException;

	public boolean updateWebMarketer(WebMarketerVO vo) throws RemoteException;
}
