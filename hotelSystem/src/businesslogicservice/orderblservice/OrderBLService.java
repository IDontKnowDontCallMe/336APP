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
	
	public List<OrderVO> filterList(int userID, String state);
	
	public boolean produceOrder(OrderVO vo);
	
	public boolean changeOrderState(int orderID, String state);
	
}
