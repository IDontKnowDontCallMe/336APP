package businesslogicservice.customerblservice;

import vo.CustomerVO;

public interface CustomerInfoblService {
	
	//�õ����пͻ����б�
	public CustomerVO[] getInfoList();
	
	//�õ�ĳ�ͻ�����Ϣ
	public CustomerVO getInfo(String customerID);

}
