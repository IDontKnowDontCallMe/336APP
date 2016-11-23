package businesslogicservice.customerblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CustomerPO;
import po.LevelPO;

public interface VIPblService extends Remote{
	
	//使该账号注册会员
	public void registerVIP(CustomerPO po) throws RemoteException;
	
	public void updateLevel(CustomerPO cpo, LevelPO lpo) throws RemoteException;

}
