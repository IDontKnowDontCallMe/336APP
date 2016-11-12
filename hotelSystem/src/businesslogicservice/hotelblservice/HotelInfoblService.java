package businesslogicservice.hotelblservice;

import po.AreaPO;
import po.ConditionPO;
import po.HotelPO;
import vo.HotelVO;

public interface HotelInfoblService {
	
	public HotelVO getHotelInfo(String hotel);
	
	public HotelVO[] search(AreaPO apo, ConditionPO cpo);
	
	public HotelVO[] sort(HotelPO[] poList, String sortType);
	
	public void update(HotelPO po);
	
	public void delete(HotelPO po);

}
