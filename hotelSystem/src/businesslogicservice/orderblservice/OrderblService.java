package businesslogicservice.orderblservice;

import po.OrderPO;
import vo.OrderVO;

public interface OrderblService {
	
	public OrderVO[] getOrderList(String userID);
	
	public OrderVO getOrderInfo(String orderID);
	
	public void produceOrder(OrderPO po);
	
	public void changeOrderState(String orderID, String state);
	
	public OrderVO[] filterList(OrderPO[] po, String state);
	

}
