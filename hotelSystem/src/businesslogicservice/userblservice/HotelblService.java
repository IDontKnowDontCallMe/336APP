package businesslogicservice.userblservice;

import po.HotelPO;
import vo.HotelVO;

public interface HotelblService {
	
	public HotelVO[] geHotelList();
	
	public HotelVO getHotel(String userID);
	
	public void updateHotel(HotelPO po);
	
	public void deleteHotel(HotelPO po);
	
	public void addHotel(HotelPO po);
	

}
