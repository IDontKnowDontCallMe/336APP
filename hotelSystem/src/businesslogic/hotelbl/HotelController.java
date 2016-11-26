package businesslogic.hotelbl;

import java.util.List;

import businesslogicservice.hotelblservice.HotelBLService;
import po.HotelPO;
import vo.AreaVO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public class HotelController implements HotelBLService{

	@Override
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVo, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> search(AreaVO apo, SearchConditionVO searchCondionVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> sort(int customerID, String sortType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVO> getRoomListOfHotel(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> getCommentList(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelVO getHotelInfo(String hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HotelPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(HotelPO po) {
		// TODO Auto-generated method stub
		
	}

}
