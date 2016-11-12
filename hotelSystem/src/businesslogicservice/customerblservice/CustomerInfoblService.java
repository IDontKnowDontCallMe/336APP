package businesslogicservice.customerblservice;

import vo.CustomerVO;

public interface CustomerInfoblService {
	
	//得到所有客户的列表
	public CustomerVO[] getInfoList();
	
	//得到某客户的信息
	public CustomerVO getInfo(String customerID);

}
