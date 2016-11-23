package businesslogicservice.userblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CustomerPO;
import vo.CustomerVO;

public interface CustomerblService extends Remote{
	
	public CustomerVO[] getCustomerList() throws RemoteException;
	
//	public CustomerVO getCustomer(String userID) throws RemoteException;
	
	public void updateCustomer(CustomerPO po) throws RemoteException;
	
	public void deleteCustomer(CustomerPO po) throws RemoteException;

}
