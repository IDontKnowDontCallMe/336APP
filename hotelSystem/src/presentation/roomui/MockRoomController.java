package presentation.roomui;

import java.util.ArrayList;
import java.util.List;

import businesslogic.roombl.RoomController;
import vo.RoomVO;

public class MockRoomController extends RoomController {

	private List<RoomVO> roomList;
	private static MockRoomController instance;

	public MockRoomController() {
		roomList = new ArrayList<RoomVO>();
		RoomVO room1 = new RoomVO(1, "大床房", 150, 20, "大床", 2);
		RoomVO room2 = new RoomVO(2, "双床房", 200, 15, "双床", 2);
		RoomVO room3 = new RoomVO(3, "单人房", 100, 10, "小床", 1);
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);
	}

	public static MockRoomController getInstance() {
		return instance == null ? instance = new MockRoomController() : instance;
	}

	@Override
	public boolean addRoomType(int hotelID, RoomVO roomVO) {
		return true;
	}

	@Override
	public boolean updateRoomType(int hotelID, RoomVO roomVO) {
		return true;
	}

	@Override
	public boolean deleteRoomType(int roomID) {
		return true;
	}

	@Override
	public List<RoomVO> getRoomTypeList(int hotelID) {
		return roomList;
	}

	@Override
	public RoomVO getRoomType(int roomID) {
		RoomVO res = new RoomVO(-1, "", -1, -1, "", -1);
		for (RoomVO vo : roomList) {
			if (vo.roomID == roomID) {
				res = vo;
			}
		}
		return res;
	}
}
