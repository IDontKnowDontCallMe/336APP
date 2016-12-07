package presentation.hotelui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import businesslogic.hotelbl.HotelController;
import vo.AreaVO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public class MockHotelController extends HotelController {

	private static MockHotelController instance;

	private List<HotelVO> hotelList;

	private HotelVO hotelVO;

	public MockHotelController() {
		// TODO Auto-generated constructor stub
		hotelList = new ArrayList<HotelVO>();
		HotelVO vo1 = new HotelVO(1010, "南大宿舍1", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		HotelVO vo2 = new HotelVO(1011, "南大宿舍2", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		HotelVO vo3 = new HotelVO(1012, "南大宿舍3", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		HotelVO vo4 = new HotelVO(1013, "南大宿舍4", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		HotelVO vo5 = new HotelVO(1014, "南大宿舍5", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		HotelVO vo6 = new HotelVO(1015, "南大宿舍6", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		HotelVO vo7 = new HotelVO(1016, "南大宿舍7", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		HotelVO vo8 = new HotelVO(1017, "南大宿舍8", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		hotelList.add(vo1);
		hotelList.add(vo2);
		hotelList.add(vo3);
		hotelList.add(vo4);
		hotelList.add(vo5);
		hotelList.add(vo6);
		hotelList.add(vo7);
		hotelList.add(vo8);
	}

	public static MockHotelController getInstance() {
		return instance == null ? instance = new MockHotelController() : instance;
	}

	@Override
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID) {
		// TODO Auto-generated method stub
		return hotelList;
	}

	@Override
	public List<HotelVO> search(AreaVO areaVO, SearchConditionVO searchCondionVO) {
		// TODO Auto-generated method stub
		ArrayList<HotelVO> tempArrayList = new ArrayList<>();
		int i = 0;
		for (HotelVO vo : hotelList) {
			if (i % 2 == 0) {
				HotelVO temp = new HotelVO(vo.hotelID, vo.hotelName, vo.city, vo.businessCircle, vo.address,
						vo.introduction, vo.service, vo.score, vo.commentScore, vo.workerName, vo.phoneNumber,
						vo.minPrice, vo.bookedTag);
				tempArrayList.add(temp);
			}
			i++;
		}

		return tempArrayList;
	}

	@Override
	public List<HotelVO> sort(int customerID, String sortType) {
		// TODO Auto-generated method stub
		ArrayList<HotelVO> tempArrayList = new ArrayList<>();

		for (int i = hotelList.size() - 1; i >= 0; i--) {
			HotelVO vo = hotelList.get(i);
			HotelVO temp = new HotelVO(vo.hotelID, vo.hotelName, vo.city, vo.businessCircle, vo.address,
					vo.introduction, vo.service, vo.score, vo.commentScore, vo.workerName, vo.phoneNumber, vo.minPrice,
					vo.bookedTag);
			tempArrayList.add(temp);
		}

		return tempArrayList;
	}

	@Override
	public List<HotelVO> getBookedHotelList(int customerID) {
		// TODO Auto-generated method stub
		return hotelList;
	}

	@Override
	public List<RoomVO> getRoomListOfHotel(int hotelID) {
		// TODO Auto-generated method stub
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		RoomVO room1 = new RoomVO(1, "大床房", 150, 20, "大床", 2);
		RoomVO room2 = new RoomVO(2, "双床房", 200, 15, "双床", 2);
		RoomVO room3 = new RoomVO(3, "单人房", 100, 10, "小床", 1);
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);
		return roomList;
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> orderList = new ArrayList<>();
		orderList = new ArrayList<OrderVO>();
		OrderVO vo1 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍1", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 233, "正常");
		OrderVO vo2 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍1", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 111, "已执行");
		OrderVO vo3 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍1", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 56, "已执行");
		OrderVO vo4 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍1", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 76, "已撤销");
		OrderVO vo5 = new OrderVO(1, "小明", 1, "18710101250", LocalDateTime.of(2016, 11, 16, 14, 00), "南大宿舍1", "大床房", 1,
				3, false, LocalDate.of(2016, 11, 18), LocalTime.of(14, 00, 00), LocalDate.of(2016, 11, 19), 234, "已撤销");

		orderList.add(vo1);
		orderList.add(vo2);
		orderList.add(vo3);
		orderList.add(vo4);
		orderList.add(vo5);

		return orderList;
	}

	@Override
	public List<CommentVO> getCommentList(int hotelID) {
		// TODO Auto-generated method stub
		ArrayList<CommentVO> commentList = new ArrayList<>();
		CommentVO vo1 = new CommentVO(1010, "南大宿舍1", "大床房", 1, "很好", 5, LocalDateTime.of(2016, 6, 10, 13, 00, 05));
		CommentVO vo2 = new CommentVO(1011, "南大宿舍2", "双床房", 2, "很好很吊", 5, LocalDateTime.of(2016, 6, 5, 14, 00, 05));
		CommentVO vo3 = new CommentVO(1011, "南大宿舍2", "单人房", 3, "太小了", 4, LocalDateTime.of(2016, 6, 4, 12, 00, 05));
		CommentVO vo4 = new CommentVO(1010, "南大宿舍1", "大床房", 4, "满意", 5, LocalDateTime.of(2016, 6, 3, 18, 00, 05));
		CommentVO vo5 = new CommentVO(1011, "南大宿舍2", "大床房", 5, "脏", 1, LocalDateTime.of(2016, 6, 2, 12, 00, 05));
		commentList.add(vo1);
		commentList.add(vo2);
		commentList.add(vo3);
		commentList.add(vo4);
		commentList.add(vo5);
		return commentList;
	}

	@Override
	public HotelVO getHotelInfo(int hotelID) {
		HotelVO resultVO = new HotelVO(0, "", "", "", "", "", "", 0, 0, "", "", 0, "0");
		for (HotelVO vo : hotelList) {
			if (vo.hotelID == hotelID) {
				resultVO = vo;
				break;
			}
		}
		return resultVO;
	}

	@Override
	public boolean update(HotelVO hotelVO) {
		return true;
	}

	@Override
	public boolean delete(HotelVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

}
