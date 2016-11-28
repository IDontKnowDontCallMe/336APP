package dataservice.promotiondataservice;

import java.util.List;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.PromotionType;

public interface PromotionDataService {

	public List<PromotionType> getWebPromotionObject();
	
	public boolean writeWebPromotionObject(PromotionType promotion);
	
	public boolean deleteWebPromotionObject(String promotionName);
	
	public LevelMethod getWebLevelObject();
	
	public boolean writeWebLevelObject(LevelMethod level);
	
	public List<PromotionType> getHotelPromotionObject(int hotelID);
	
	public boolean writeHotelPromotionObject(int hotelID, PromotionType promotion);
	
	public boolean deleteHotelPromotionObject(int hotelID, String promotionName);
	
}
