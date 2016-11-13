package data.promotiondata;

import java.util.List;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.Promotion;

public interface WebPromotionDao {

	public List<Promotion> getWebPromotionObject();
	
	public boolean writeWebPromotionObject(Promotion promotion);
	
	public boolean deleteWebPromotionObject(String promotionName) ;
	
	public LevelMethod getWebLevelObject();
	
	public boolean writeWebLevelObject(LevelMethod level);
	
}
