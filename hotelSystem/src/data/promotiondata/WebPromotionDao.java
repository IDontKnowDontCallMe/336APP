package data.promotiondata;

import java.util.List;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.PromotionType;

public interface WebPromotionDao {

	public List<PromotionType> getWebPromotionObject();
	
	public boolean writeWebPromotionObject(PromotionType promotion);
	
	public boolean deleteWebPromotionObject(String promotionName) ;
	
	public LevelMethod getWebLevelObject();
	
	public boolean writeWebLevelObject(LevelMethod level);
	
}
