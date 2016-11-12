package businesslogicservice.promotionblservice;

import po.LevelPO;
import po.WebPromotionPO;
import vo.WebPromotionVO;

public interface WebPromotionblService {
	
	public WebPromotionVO[] getPromotionList(String type);
	
	public void addPromotion(WebPromotionPO po);
	
	public WebPromotionVO getlWebPromotion(String promotion);
	
	public void updatePromotion(WebPromotionPO po);
	
	public void deletePromotion(WebPromotionPO po);
	
	public void setLevel(LevelPO po);

}
