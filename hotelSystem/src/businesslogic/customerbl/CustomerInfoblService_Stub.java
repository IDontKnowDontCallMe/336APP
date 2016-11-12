package businesslogic.customerbl;

import businesslogicservice.customerblservice.CustomerInfoblService;
import vo.CustomerVO;

public class CustomerInfoblService_Stub implements CustomerInfoblService{
	
	CustomerVO[] customerList;
	
	
	public CustomerInfoblService_Stub(CustomerVO[] list) {
		// TODO Auto-generated constructor stub
		
		customerList = list;
		
	}

	@Override
	public CustomerVO[] getInfoList() {
		// TODO Auto-generated method stub
		return customerList;
	}

	@Override
	public CustomerVO getInfo(String customerID) {
		// TODO Auto-generated method stub
		return customerList[0];
	}
	
	
	

	

	
}
