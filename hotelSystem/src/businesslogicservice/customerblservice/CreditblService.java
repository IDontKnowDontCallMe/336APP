package businesslogicservice.customerblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CreditPO;
import po.CustomerPO;
import vo.CreditVO;

public interface CreditblService extends Remote{

	//得到客户的信用变化表
	public CreditVO[] checkCredit(CustomerPO po) throws RemoteException;
	
	
	//得到客户的具体信用值变化情况
	public CreditPO concreteCheckCredit (CustomerPO po, int index) throws RemoteException;
	
}
