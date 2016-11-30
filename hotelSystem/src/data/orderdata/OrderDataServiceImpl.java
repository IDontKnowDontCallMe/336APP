package data.orderdata;

import java.util.List;

import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;

public class OrderDataServiceImpl implements OrderDataService{
	
	private OrderDao orderDao ;
	
	public OrderDataServiceImpl() {
		// TODO Auto-generated constructor stub
		orderDao = OrderDaoFactory.getOrderDaoInstance();
	}

	@Override
	public OrderPO getOrderInfo(int orderID) {
		// TODO Auto-generated method stub
		return orderDao.getOrderInfo(orderID);
	}

	@Override
	public List<OrderPO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<OrderPO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertOrder(OrderPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderPO> getAbnormalOrdersOfToday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumOfAllOrders() {
		// TODO Auto-generated method stub
		return 0;
	}



	

}
