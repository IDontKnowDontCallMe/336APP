package businesslogic.orderbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.orderblservice.OrderBLService;
import vo.OrderVO;

public class OrderController implements OrderBLService{

	private OrderBLImpl orderBLImpl;
	
	@Override
	public List<OrderVO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		OrderVO vo1,vo2,vo3;
		try {
			vo1 = new OrderVO(2, "daming", 1, "18710101010",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),233, "正常");
			vo2 = new OrderVO(2, "daming", 1, "18710101010",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),233, "已执行");
			vo3 = new OrderVO(2, "daming", 1, "18710101010",format.parse("2016-11-17") , "如家", "大床房", 1, 
					false,  format.parse("2016-11-18"), format.parse("2016-11-19"),233, "已撤销");
			orderList.add(vo1);
			orderList.add(vo2);
			orderList.add(vo3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> filterCustomerList(int userID, String state) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<OrderVO> filterHotelList(int hotelID, String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean produceOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean changeOrderState(int orderID, String state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderVO> getAbnormalOrdersOfToday() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
