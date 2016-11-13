package businesslogic.orderbl;

import java.util.List;

import businesslogicservice.orderblservice.OrderBLService;
import vo.OrderVO;

public class OrderController implements OrderBLService{

	private OrderBLImpl orderBLImpl;
	
	@Override
	public List<OrderVO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> filterList(int userID, String state) {
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
	
	

}
