package businesslogicservice.customerblservice;

import po.CreditPO;
import po.CustomerPO;
import vo.CreditVO;

public interface CreditblService {

	//�õ��ͻ������ñ仯��
	public CreditVO[] checkCredit(CustomerPO po);
	
	
	//�õ�ĳһ�����ñ仯�ľ������
	public CreditPO concreteCheckCredit (CustomerPO po, int index);
	
}
