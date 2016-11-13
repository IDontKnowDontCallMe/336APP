package dataservice.promotiondataservice;

import java.util.List;

import businesslogic.promotionbl.Level;
import businesslogic.promotionbl.Promotion;

public interface PromotionDataService {

	public List<Promotion> getWebPromotionObject();
	
	public boolean writeWebPromotionObject(Promotion promotion);
	
	public boolean deleteWebPromotionObject(String promotionName);
	
	public Level getWebLevelObject();
	
	public boolean writeWebLevelObject(Level level);
	
	public List<Promotion> getHotelPromotionObject(int hotelID);
	
	public boolean writeHotelPromotionObject(int hotelID, Promotion promotion);
	
	public boolean deleteHotelPromotionObject(int hotelID, String promotionName);
	
}
