package businesslogicservice.userblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import po.WebMarketerPO;
import vo.WebMarketerVO;

public interface WebMarketerblService extends Remote{
	
	public WebMarketerVO[] getWebMarketerList() throws RemoteException;
	
	public WebMarketerVO getWebMarketer(String userID) throws RemoteException;
	
	public void addWebMarketer(WebMarketerPO po) throws RemoteException;
	
	public void updateWebMarketer(WebMarketerPO po) throws RemoteException;
	
	public void deleteWebMarketer(WebMarketerPO po) throws RemoteException;

}
