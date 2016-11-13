package businesslogic.promotionbl;

import java.util.List;

import po.OrderPO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class PromotionBLImpl {
	
	private HotelPromotionImpl hotelPromotionImpl;
	private WebPromotionImpl webPromotionImpl;
	
	
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteHotelPromotion(int hotelID, String promotionName) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<WebPromotionVO> getWebPromotionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteWebPromotion(String promotionName) {
		// TODO Auto-generated method stub
		return false;
	}

	public int calculateOrder(OrderPO po) {
		// TODO Auto-generated method stub
		return 0;
	}

}
