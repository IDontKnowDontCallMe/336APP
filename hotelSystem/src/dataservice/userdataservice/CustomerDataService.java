package dataservice.userdataservice;

import po.CustomerPO;

public interface CustomerDataService {
	
	public void insert(CustomerPO po);
	
	public CustomerPO find(String customerID);
	
	public void delete(CustomerPO po);
	
	public void update(CustomerPO po);
	
	public void init();
	
	public void finish();

}
