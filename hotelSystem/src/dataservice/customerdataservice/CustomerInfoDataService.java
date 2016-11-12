package dataservice.customerdataservice;

import po.CustomerPO;

public interface CustomerInfoDataService {
	
	public CustomerPO getInfo(String customerID);
	
	public CustomerPO updateInfo(CustomerPO po);
	

}
