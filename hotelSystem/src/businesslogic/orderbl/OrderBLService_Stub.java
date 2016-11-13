package businesslogic.orderbl;

import businesslogicservice.orderblservice.OrderBLService;
import po.OrderPO;
import vo.OrderVO;

public class OrderBLService_Stub implements OrderBLService{
	
	OrderVO[] orderList;
	
	public OrderBLService_Stub(OrderVO[] list) {
		// TODO Auto-generated constructor stub
		
		this.orderList = list;
		
	}

	@Override
	public OrderVO[] getOrderList(String userID) {
		// TODO Auto-generated method stub
		System.out.println("get " + userID + "'s order list!");
		return orderList;
	}

	@Override
	public OrderVO getOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		
		OrderVO example = new OrderVO();
		
		example.orderID = orderID;
		
		System.out.println("get " + orderID + " list");
		
		return example;
	}

	@Override
	public void produceOrder(OrderPO po) {
		// TODO Auto-generated method stub
		System.out.println("produce an order!");
	}

	@Override
	public void changeOrderState(String orderID, String state) {
		// TODO Auto-generated method stub
		System.out.println("change!");
	}

	@Override
	public OrderVO[] filterList(OrderPO[] po, String state) {
		// TODO Auto-generated method stub
		return orderList;
	}

}
