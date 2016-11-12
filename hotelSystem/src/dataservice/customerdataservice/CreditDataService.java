package dataservice.customerdataservice;

import po.CreditPO;
import po.CustomerPO;

public interface CreditDataService {
	
	public CreditPO[] getCredit(CustomerPO po);
	
	public CreditPO getConcreteCredit(CustomerPO po, String orderID);


}
