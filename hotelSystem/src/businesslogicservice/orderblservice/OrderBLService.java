package businesslogicservice.orderblservice;

import java.util.List;

import po.OrderPO;
import vo.OrderVO;

public interface OrderBLService {
	
	public List<OrderVO> getCustomerOrder(int customerID);
	
	public List<OrderVO> getHotelOrder(int hotelID);
	
	public List<OrderVO> filterList(int userID, String state);
	
	public boolean produceOrder(OrderVO vo);
	
	public boolean changeOrderState(int orderID, String state);
	
}
