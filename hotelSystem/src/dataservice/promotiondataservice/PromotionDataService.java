package dataservice.promotiondataservice;

import java.util.List;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.PromotionType;
import po.HotelPromotionPO;
import po.WebPromotionPO;

public interface PromotionDataService {

	public List<PromotionType> getWebPromotionObject();
	
	public boolean writeWebPromotionObject(WebPromotionPO po);
	
	public boolean deleteWebPromotionObject(String PromotionType);
	
	public LevelMethod getWebLevelObject();
	
	public boolean writeWebLevelObject(LevelMethod level);
	
	public List<PromotionType> getHotelPromotionObject(int hotelID);
	
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionPO po);
	
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType);
	
}
