package businesslogic.promotionbl;

import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class PromotionBLImpl {

	private HotelPromotionImpl hotelPromotionImpl;
	private WebPromotionImpl webPromotionImpl;
	private LevelImpl levelImpl;
	
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) {
		return hotelPromotionImpl.getHotelPromotionList(hotelID);
	}

	public boolean addHotelPromotion(HotelPromotionVO vo) {
		return hotelPromotionImpl.addHotelPromotion(vo);
	}

	public boolean updateHotelPromotion(HotelPromotionVO vo) {
		return hotelPromotionImpl.updateHotelPromotion(vo);
	}

	public boolean deleteHotelPromotion(HotelPromotionVO vo) {
		return hotelPromotionImpl.deleteHotelPromotion(vo);
	}

	public List<WebPromotionVO> getWebPromotionList() {
		return webPromotionImpl.getWebPromotionList();
	}

	public boolean addWebPromotion(WebPromotionVO vo) {
		return webPromotionImpl.addWebPromotion(vo);
	}

	public boolean updateWebPromotion(WebPromotionVO vo) {
		return webPromotionImpl.updateWebPromotion(vo);
	}

	public boolean deleteWebPromotion(WebPromotionVO vo) {
		return webPromotionImpl.deleteWebPromotion(vo);
	}

	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		int originalPrice = calculationVO.roomNum * calculationVO.roomPrice;
		int hotelPrice = originalPrice - hotelPromotionImpl.calculateOrder(calculationVO, customerVO);
		int webPrice = originalPrice - webPromotionImpl.calculateOrder(calculationVO, customerVO);
		return (originalPrice > 0) ? originalPrice - hotelPrice - webPrice : 0;
	}

	public int calculateLevel(int credit){
		LevelMethodImpl levelMethodImpl = new LevelMethodImpl(credit);
		levelImpl.setCalculateLevel(levelMethodImpl);
		
		return levelImpl.getCalculateLevel(credit);
	}
}
