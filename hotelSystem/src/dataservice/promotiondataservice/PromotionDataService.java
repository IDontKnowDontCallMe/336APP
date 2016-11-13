package dataservice.promotiondataservice;

import java.util.List;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.Promotion;

public interface PromotionDataService {

	public List<Promotion> getWebPromotionObject();
	
	public boolean writeWebPromotionObject(Promotion promotion);
	
	public boolean deleteWebPromotionObject(String promotionName);
	
	public LevelMethod getWebLevelObject();
	
	public boolean writeWebLevelObject(LevelMethod level);
	
	public List<Promotion> getHotelPromotionObject(int hotelID);
	
	public boolean writeHotelPromotionObject(int hotelID, Promotion promotion);
	
	public boolean deleteHotelPromotionObject(int hotelID, String promotionName);
	
}
