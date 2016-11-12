package dataservice.userdataservice;

import po.WebMarketerPO;

public interface WebMarketerDataService {
	
	public WebMarketerPO find(String webMarketerID);
	
	public void insert(WebMarketerPO po);
	
	public void delete(WebMarketerPO po);
	
	public void update(WebMarketerPO po);
	
	public void init();
	
	public void finish();

}
