package businesslogicservice.customerblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.CustomerVO;

public interface CustomerInfoblService extends Remote {
	
	//得到所有客户的列表
	public CustomerVO[] getInfoList() throws RemoteException;
	
	//得到某客户的信息
	public CustomerVO getInfo(String customerID) throws RemoteException;

}
