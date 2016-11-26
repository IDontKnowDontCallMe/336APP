package presentation.userui;

import businesslogicservice.userblservice.UserBLService;

import java.util.ArrayList;
import java.util.List;
import businesslogic.userbl.UserController;
import vo.CustomerVO;
import vo.WebMarketerVO;
import vo.HotelVO;
import vo.OrderVO;

public class MockUserController extends UserController{

	private List<CustomerVO> customerList;
	private List<HotelVO> hotelList;
	private List<WebMarketerVO> webMarketerList;
	
	public MockUserController() {
		CustomerVO vo1, vo2, vo3;
		HotelVO vo4, vo5, vo6;
		WebMarketerVO vo7, vo8, vo9;
		
		customerList = new ArrayList<CustomerVO>();
		hotelList = new ArrayList<HotelVO>();
		webMarketerList = new ArrayList<WebMarketerVO>();
		
		
	}
	
}
