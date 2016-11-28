package businesslogic.promotionbl;


import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.OrderVO;
import java.util.List;
import data.promotiondata.HotelPromotionDaoImpl;

public class RoomPromotion implements PromotionType{

	private HotelPromotionDaoImpl dao;
	private List<HotelPromotionVO> hotelPromotionList;
	private double discount;
	

	@Override
	public double getDiscount(OrderVO ovo, CustomerVO cvo) {

		dao = new HotelPromotionDaoImpl();
//		hotelPromotionList = dao.getHotelPromotionObject(opo.getHotelID());
		discount=1.0;
		
		for(HotelPromotionVO promotion: hotelPromotionList){
			if(promotion.equals("")){
				discount=1.0;
			}
		}
		return discount;
	}

}
