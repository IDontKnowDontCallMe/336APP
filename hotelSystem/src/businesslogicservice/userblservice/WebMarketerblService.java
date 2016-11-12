package businesslogicservice.userblservice;

import po.WebMarketerPO;
import vo.WebMarketerVO;

public interface WebMarketerblService {
	
	public WebMarketerVO[] getWebMarketerList();
	
	public WebMarketerVO getWebMarketer(String userID);
	
	public void addWebMarketer(WebMarketerPO po);
	
	public void updateWebMarketer(WebMarketerPO po);
	
	public void deleteWebMarketer(WebMarketerPO po);

}
