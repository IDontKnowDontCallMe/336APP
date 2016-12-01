package dataservice.customerdataservice;

import java.time.LocalDate;
import java.util.List;
import po.CreditPO;
import po.CustomerPO;

public interface CustomerDataService {

	public CustomerPO getInfo(int customerID);
	
	public boolean updateInfo(CustomerPO po);
	
	public boolean setBirthVIP(int customerID, LocalDate birthday);
	
	public boolean setCompanyVIP(int customerID, String companyName);
	
	public List<CreditPO> getCreditList(int customerID);

	
}
