package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import vo.CreditVO;
import vo.CustomerVO;

public interface RemoteCustomerService extends Remote{

	public CustomerVO getCustomerInfo(int customerID) throws RemoteException;
	
	public boolean updateCustomerInfo(CustomerVO customerVO) throws RemoteException;
	
	public List<CreditVO> getCreditList(int customerID) throws RemoteException;
	
	public boolean registerBirthVIP(int customerID, LocalDate birthday) throws RemoteException;
	
	public boolean registerCompanyVIP(int customerID, String companyName) throws RemoteException;
	
}
