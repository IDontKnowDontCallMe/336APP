package businesslogic.hotelbl;

import businesslogicservice.hotelblservice.HotelInfoblService;
import po.AreaPO;
import po.ConditionPO;
import po.HotelPO;
import vo.HotelVO;


public class HotelInfoblService_Stub implements HotelInfoblService {

	HotelVO[] list;
	
	public HotelInfoblService_Stub(HotelVO[] list) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}
	
	@Override
	public HotelVO getHotelInfo(String hotel) {
		// TODO Auto-generated method stub
		HotelVO example = new HotelVO();
		example.hotelID = hotel;
		return example;
	}

	@Override
	public HotelVO[] search(AreaPO apo, ConditionPO cpo) {
		// TODO Auto-generated method stub
		
		System.out.println("search!");
		
		return list;
	}

	@Override
	public HotelVO[] sort(HotelPO[] poList, String sortType) {
		// TODO Auto-generated method stub
		
		System.out.println("sort!");
		
		return list;
	}

	@Override
	public void update(HotelPO po) {
		// TODO Auto-generated method stub
		System.out.println("update HotelPO!");
	}

	@Override
	public void delete(HotelPO po) {
		// TODO Auto-generated method stub
		System.out.println("delet HotelPO!");
	}
	
	
}
