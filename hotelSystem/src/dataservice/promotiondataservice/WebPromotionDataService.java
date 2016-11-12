package dataservice.promotiondataservice;

import po.LevelPO;
import po.WebPromotionPO;

public interface WebPromotionDataService {
	
	public WebPromotionPO find(String promotion);
	
	public void insert(WebPromotionPO po);
	
	public void delete(WebPromotionPO po);
	
	public void update(WebPromotionPO po);
	
	public void init();
	
	public void finish();
	
	public void setLevel(LevelPO po);

}
