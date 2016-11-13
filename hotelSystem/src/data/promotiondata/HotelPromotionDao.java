package data.promotiondata;

import java.util.List;

import businesslogic.promotionbl.Promotion;

public interface HotelPromotionDao {

	public List<Promotion> getHotelPromotionObject(int hotelID);
	
	public boolean writeHotelPromotionObject(int hotelID, Promotion promotion);
	
	public boolean deleteHotelPromotionObject(int hotelID, String promotionName) ;
}
