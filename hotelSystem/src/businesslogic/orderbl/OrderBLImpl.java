package businesslogic.orderbl;

import java.util.List;

import po.CustomerPO;
import po.OrderPO;
import vo.OrderVO;

public class OrderBLImpl {

	private OrderCalculator orderCalculator;
	
	public void setCalculator(OrderCalculator calculator){
		orderCalculator = calculator;
	}
	
	public int getOrderPrice(OrderPO opo, CustomerPO cpo){
		return orderCalculator.getOrderPrice(opo, cpo);
	}
	
	public List<OrderVO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> filterList(int userID, String state) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean produceOrder(CustomerPO po) {
		// TODO Auto-generated method stub
		orderCalculator.ableToProduce(po);
		return false;
	}

	public boolean changeOrderState(int orderID, String state) {
		// TODO Auto-generated method stub
		
		return false;
	}
	
}
