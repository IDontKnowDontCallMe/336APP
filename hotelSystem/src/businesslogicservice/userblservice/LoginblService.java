package businesslogicservice.userblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginblService extends Remote{
	
	public boolean check(String userID, String password) throws RemoteException;

}
