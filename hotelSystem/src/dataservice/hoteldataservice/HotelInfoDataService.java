package dataservice.hoteldataservice;

import po.HotelPO;

public interface HotelInfoDataService {
	
	public HotelPO find(String hotelID);
	
	public void insert(HotelPO po);
	
	public void delete (HotelPO po);
	
	public void update(HotelPO po);
	
	public void init();
	
	public void finish();
	

}
