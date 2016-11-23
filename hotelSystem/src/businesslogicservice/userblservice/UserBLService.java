package businesslogicservice.userblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.CustomerVO;

public interface UserBLService extends Remote{

	public List<CustomerVO> getCustomerList() throws RemoteException;
	
	//public 
	
}
