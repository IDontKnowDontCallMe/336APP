package presentation.userui;

import businesslogicservice.userblservice.UserBLService;
import presentation.customerui.MockCustomerController;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import businesslogic.userbl.UserController;
import vo.CustomerVO;
import vo.WebMarketerVO;
import vo.HotelVO;

public class MockUserController extends UserController {

	private List<CustomerVO> customerList;
	private List<HotelVO> hotelList;
	private List<WebMarketerVO> webMarketerList;
	private static MockUserController instance;

	public MockUserController() {
		CustomerVO vo1, vo2, vo3;
		HotelVO vo4, vo5, vo6;
		WebMarketerVO vo7, vo8, vo9;

		customerList = new ArrayList<CustomerVO>();
		hotelList = new ArrayList<HotelVO>();
		webMarketerList = new ArrayList<WebMarketerVO>();
		vo1 = new CustomerVO(10001, "孙泽嵩", "18787878787", true, LocalDate.parse("1997-01-18"), true, "南京大学", 10000, 1);
		vo2 = new CustomerVO(10002, "汤旭", "18787878787", false, null, true, "南京大学", 10000, 1);
		vo3 = new CustomerVO(10003, "谭昕", "18787878787", true, LocalDate.parse("1996-10-03"), false, null, 10000, 1);

		vo4 = new HotelVO(1010, "南大宿舍4", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		vo5 = new HotelVO(1010, "南大宿舍5", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");
		vo6 = new HotelVO(1010, "南大宿舍6", "南京", "仙林", "97号仙林大道", "无", "热水、网线", 1, 4.8, "校长", "101010101010", 100,
				"未预定过");

		vo7 = new WebMarketerVO(30001, "苏健龙", "17878787878");
		vo8 = new WebMarketerVO(30002, "苏龙龙", "17878787878");
		vo9 = new WebMarketerVO(30003, "龙龙龙", "17878787878");

		customerList.add(vo1);
		customerList.add(vo2);
		customerList.add(vo3);
		hotelList.add(vo4);
		hotelList.add(vo5);
		hotelList.add(vo6);
		webMarketerList.add(vo7);
		webMarketerList.add(vo8);
		webMarketerList.add(vo9);

	}

	@Override
	public List<CustomerVO> getCustomerList() throws RemoteException {
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		for (CustomerVO vo : customerList) {
			CustomerVO temp = new CustomerVO(vo);
			list.add(temp);
		}
		return list;
	}

	@Override
	public boolean updateCustomer(CustomerVO customerVO) throws RemoteException {
		return true;
	}

	@Override
	public List<HotelVO> getHotelList() throws RemoteException {
		List<HotelVO> list = new ArrayList<HotelVO>();
		for (HotelVO vo : hotelList) {
			HotelVO temp = new HotelVO(vo);
			list.add(temp);
		}
		return list;
	}

	@Override
	public boolean addHotel(HotelVO hotelVO) throws RemoteException {
		return true;
	}

	@Override
	public boolean updateHotelWorker(HotelVO hotelVO) throws RemoteException {
		return true;
	}

	@Override
	public List<WebMarketerVO> getWebMarketerList() throws RemoteException {
		List<WebMarketerVO> list = new ArrayList<WebMarketerVO>();
		for (WebMarketerVO vo : webMarketerList) {
			WebMarketerVO temp = new WebMarketerVO(vo);
			list.add(temp);
		}
		return list;
	}

	@Override
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		return true;
	}

	@Override
	public boolean updateWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		return true;
	}

	@Override
	public WebMarketerVO getWebMarketerInfo(int WebMarketerID) {
		WebMarketerVO resultVO = new WebMarketerVO(0, "", "");
		for (WebMarketerVO vo : webMarketerList) {
			if (vo.ID == WebMarketerID) {
				resultVO = vo;
				break;
			}
		}
		return resultVO;

	}

	@Override
	public String login(int userID, String password) throws RemoteException {
		return null;
	}

	public static MockUserController getInstance() {
		return instance == null ? new MockUserController() : instance;
	}
}
