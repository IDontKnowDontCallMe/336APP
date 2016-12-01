package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.List;

import businesslogicservice.userblservice.UserBLService;
import po.HotelPO;
import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

public class UserController implements UserBLService{
	public List<CustomerVO> getCustomerList() throws RemoteException {
		return null;
		}
	
	public boolean updateCustomer(CustomerVO customerVO) throws RemoteException {
		return false;
	}
	
		public List<HotelVO> getHotelList() throws RemoteException {
		return null;
	}
	
	public boolean addHotel(HotelVO hotelVO) throws RemoteException {
		return false;
	}
	
	public boolean updateHotelWorker(HotelVO hotelVO) throws RemoteException {
		return false;
	}
		
	public List<WebMarketerVO> getWebMarketerList() throws RemoteException {
		return null;
	}
	
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		return false;
	}
	
	public boolean updateWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		return false;
	}
	
	public String login(int userID, String password) throws RemoteException {
		return null;
	}

	public WebMarketerVO getWebMarketerInfo(int WebMarketerID) {
		return null;
	}

	@Override
	public boolean deleteWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCreditOfCustomer(int customerID, int delta) {
		// TODO Auto-generated method stub
		return false;
	}
}
