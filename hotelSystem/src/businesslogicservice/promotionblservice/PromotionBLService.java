package businesslogicservice.promotionblservice;

import java.util.List;

import po.OrderPO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import vo.WebPromotionVO;

public interface PromotionBLService {
	
	
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID);
	
	public boolean addHotelPromotion(HotelPromotionVO vo);
	
	public boolean updateHotelPromotion(HotelPromotionVO vo);
	
	public boolean deleteHotelPromotion(int hotelID, String promotionName);
	
	public List<WebPromotionVO> getWebPromotionList();
	
	public boolean addWebPromotion(WebPromotionVO vo);
	
	public boolean updateWebPromotion(WebPromotionVO vo);
	
	public boolean deleteWebPromotion(String promotionName);
	
	public boolean setLevelMethod(LevelVO vo);
	
	public LevelVO getLevelMethod();
	
	
	
	public int calculateOrder(OrderPO po);
	
	public int calculateLevel(int credit);
	

}
