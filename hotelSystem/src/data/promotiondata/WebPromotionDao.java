package data.promotiondata;

import java.util.List;

import businesslogic.promotionbl.Level;
import businesslogic.promotionbl.Promotion;

public interface WebPromotionDao {

	public List<Promotion> getWebPromotionObject();
	
	public boolean writeWebPromotionObject(Promotion promotion);
	
	public boolean deleteWebPromotionObject(String promotionName) ;
	
	public Level getWebLevelObject();
	
	public boolean writeWebLevelObject(Level level);
	
}
