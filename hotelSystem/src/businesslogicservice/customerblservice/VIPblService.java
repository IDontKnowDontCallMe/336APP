package businesslogicservice.customerblservice;

import po.CustomerPO;
import po.LevelPO;

public interface VIPblService {
	
	//ʹ���˺�ע���Ա
	public void registerVIP(CustomerPO po);
	
	public void updateLevel(CustomerPO cpo, LevelPO lpo);

}
