package businesslogic.orderbl;

import java.time.LocalDateTime;

import businesslogic.factory.BLFactory;
import data.factory.DataFactory;
import po.OrderPO;

public class OrderChanger {

	private OrderPO orderPO;
	private String targetState;
	
	
	public OrderChanger(int orderID, String state) {
		// TODO Auto-generated constructor stub
		orderPO = DataFactory.getOrderDataService().getOrderInfo(orderID);
		targetState = state;
	}
	
	public OrderPO change(){
		
		if(orderPO.getOrderState().equals("正常")){
			switch (targetState) {
			
			case "已执行":
				normalToExecuted();
				break;
				
			case "已撤销":
				normalToRevoked();
				break;
				
			case "异常":
				normalToAbnormal();
				break;

			default:
				break;
			}
			
			return orderPO;
		}
		else if(orderPO.getOrderState().equals("异常")){
			if(targetState.equals("已执行")){
				abnormalToExecuted();
			}
			else{
				abnormalToRevoked();
			}
			return orderPO;
		}
		else if(orderPO.getOrderState().equals("已执行")){
			executedToLeaving();
			
			return orderPO;
		}
		else{
			return null;
		}
		
	}
	
	private void normalToExecuted(){
		orderPO.setExecutingDateTime(LocalDateTime.now());
		orderPO.setOrderState("已执行");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		BLFactory.getUserBLService().updateCreditOfCustomer(orderPO.getCustomerID(), orderPO.getTotal());
	}
	
	private void normalToRevoked(){
		orderPO.setRevokingDateTime(LocalDateTime.now());
		orderPO.setOrderState("已撤销");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		if(LocalDateTime.now().plusHours(6).isAfter(LocalDateTime.of(orderPO.getCheckInDate(), orderPO.getLatestArrivingTime()))){
			BLFactory.getUserBLService().updateCreditOfCustomer(orderPO.getCustomerID(), -orderPO.getTotal()/2);
		}
	}
	
	private void normalToAbnormal(){
		orderPO.setOrderState("异常");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		BLFactory.getUserBLService().updateCreditOfCustomer(orderPO.getCustomerID(), -orderPO.getTotal());
	}
	
	private void abnormalToExecuted(){
		orderPO.setExecutingDateTime(LocalDateTime.now());
		orderPO.setOrderState("已执行");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		BLFactory.getUserBLService().updateCreditOfCustomer(orderPO.getCustomerID(), orderPO.getTotal());
	}
	
	private void abnormalToRevoked(){
		orderPO.setRevokingDateTime(LocalDateTime.now());
		orderPO.setOrderState("已撤销");
		DataFactory.getOrderDataService().updateOrder(orderPO);
		
		if(targetState.equals("一半")){
			BLFactory.getUserBLService().updateCreditOfCustomer(orderPO.getCustomerID(), orderPO.getTotal()/2);
		}
		else if(targetState.equals("全部")){
			BLFactory.getUserBLService().updateCreditOfCustomer(orderPO.getCustomerID(), orderPO.getTotal());
		}
	}
	
	private void executedToLeaving(){
		orderPO.setLeavingDateTime(LocalDateTime.now());
		DataFactory.getOrderDataService().updateOrder(orderPO);
	}
	
	
	
}
