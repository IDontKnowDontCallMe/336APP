package dataservice.customerdataservice;

import java.util.Date;
import java.util.List;

import data.factory.DataFactory;
import po.CreditPO;
import po.CustomerPO;

public interface CustomerDataService {

	public CustomerPO getInfo(int customerID);
	
	public boolean updateInfo(CustomerPO po);
	
	public boolean setBirthVIP(int customerID, Date birthday);
	
	public boolean setCompanyVIP(int customerID, String companyName);
	
	public List<CreditPO> getCreditList(int customerID);

	
}
