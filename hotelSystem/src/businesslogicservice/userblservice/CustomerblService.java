package businesslogicservice.userblservice;

import po.CustomerPO;
import vo.CustomerVO;

public interface CustomerblService {
	
	public CustomerVO[] getCustomerList();
	
	public CustomerVO getCustomer(String userID);
	
	public void updateCustomer(CustomerPO po);
	
	public void deleteCustomer(CustomerPO po);

}
