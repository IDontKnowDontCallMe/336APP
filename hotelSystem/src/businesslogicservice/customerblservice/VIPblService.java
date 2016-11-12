package businesslogicservice.customerblservice;

import po.CustomerPO;
import po.LevelPO;

public interface VIPblService {
	
	//使该账号注册会员
	public void registerVIP(CustomerPO po);
	
	public void updateLevel(CustomerPO cpo, LevelPO lpo);

}
