package dataservice.promotiondataservice;

import po.HotelPromotionPO;

public interface HotelPromotionDataService {
	
	public HotelPromotionPO find(String hotel, String promotion);
	
	public void insert(String hotel, HotelPromotionPO po);
	
	public void delete(String hotel, HotelPromotionPO po);
	
	public void update(String hotel, HotelPromotionPO po);
	
	public void init();
	
	public void finish();

}
