package data.promotiondata;

import java.util.List;

import businesslogic.promotionbl.PromotionType;

public interface HotelPromotionDao {

	public List<PromotionType> getHotelPromotionObject(int hotelID);
	
	public boolean writeHotelPromotionObject(int hotelID, PromotionType promotion);
	
	public boolean deleteHotelPromotionObject(int hotelID, String promotionName) ;
}
