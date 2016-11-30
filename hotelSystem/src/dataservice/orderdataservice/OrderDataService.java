package dataservice.orderdataservice;

import java.util.List;

import po.OrderPO;

public interface OrderDataService {
	
	public OrderPO getOrderInfo(int orderID);
	
	public List<OrderPO> getCustomerOrder(int customerID);
	
	public List<OrderPO> getHotelOrder(int hotelID);
	
	public List<OrderPO> getAbnormalOrdersOfToday();
	
	//public void changeOrderState(String orderID, String state);
	
	public boolean updateOrder(OrderPO orderPO);
	
	public boolean insertOrder(OrderPO po);
	
	public int getNumOfAllOrders();

}
