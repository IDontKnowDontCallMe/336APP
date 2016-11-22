package businesslogicservice.orderblservice;

import java.util.List;

import com.sun.org.glassfish.gmbal.ParameterNames;

import po.OrderPO;
import vo.OrderVO;

/**
 * 
 * @author USER
 *
 */
public interface OrderBLService {
	
	public List<OrderVO> getCustomerOrder(int customerID);
	
	public List<OrderVO> getHotelOrder(int hotelID);
	
	public List<OrderVO> getAbnormalOrdersOfToday();
	
	public List<OrderVO> filterCustomerList(int userID, String state);
	
	public List<OrderVO> filterHotelList(int hotelID, String state);
	
	public int calculateTotal();
	
	public boolean produceOrder(OrderVO vo);
	
	public boolean changeOrderState(int orderID, String state);
	
}
