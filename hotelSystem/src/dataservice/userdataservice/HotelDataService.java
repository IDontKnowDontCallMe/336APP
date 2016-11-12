package dataservice.userdataservice;

import po.HotelPO;

public interface HotelDataService {
	
	public void insert(HotelPO po);
	
	public HotelPO find(String hotelID);
	
	public void delete(HotelPO po);
	
	public void update(HotelPO po);
	
	public void init();
	
	public void finish();

}
