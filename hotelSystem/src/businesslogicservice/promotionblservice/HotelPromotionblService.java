package businesslogicservice.promotionblservice;

import po.HotelPromotionPO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public interface HotelPromotionblService {
	
	public HotelPromotionVO[] getlPromotionList(String hotelID, String type);
	
	public HotelPromotionVO getlHotelPromotion(String promotion);
	
	public void addPromotion(HotelPromotionPO po);
	
	public void updatePromotion(HotelPromotionPO po);
	
	public void deletePromotion(HotelPromotionPO po);
	
	

}
