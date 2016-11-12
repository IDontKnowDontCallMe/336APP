package businesslogicservice.customerblservice;

import po.CreditPO;
import po.CustomerPO;
import vo.CreditVO;

public interface CreditblService {

	//得到客户的信用变化表
	public CreditVO[] checkCredit(CustomerPO po);
	
	
	//得到某一次信用变化的具体情况
	public CreditPO concreteCheckCredit (CustomerPO po, int index);
	
}
