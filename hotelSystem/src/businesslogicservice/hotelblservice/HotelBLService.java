package businesslogicservice.hotelblservice;

import java.util.List;

import po.HotelPO;
import vo.AreaVO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public interface HotelBLService {

	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVo, int customerID);

	public List<HotelVO> search(AreaVO apo,SearchConditionVO searchCondionVO);
	
	public List<HotelVO> sort(int customerID, String sortType);
	
	public List<RoomVO>   getRoomListOfHotel(int hotelID);
	
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID);
	
	public List<CommentVO> getCommentList(int hotelID);
	
	public HotelVO getHotelInfo(String hotel);
	
	public void update(HotelPO po);
	
	public void delete(HotelPO po);
	
}
