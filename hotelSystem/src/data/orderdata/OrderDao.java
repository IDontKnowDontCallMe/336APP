package data.orderdata;

import java.util.List;

import po.OrderPO;

public interface OrderDao {
	
	public OrderPO getOrderInfo(int orderID);
	
	public List<OrderPO> getCustomerOrder(int customerID);
	
	public List<OrderPO> getHotelOrder(int hotelID);
		
	public boolean updateOrderState(int orderID,String orderState);
	
	public boolean insertOrder(OrderPO po);

}
