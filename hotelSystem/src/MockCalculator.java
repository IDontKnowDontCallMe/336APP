import businesslogic.orderbl.OrderCalculator;
import po.CustomerPO;
import po.OrderPO;

public class MockCalculator extends OrderCalculator{
	
	public int getOrderPrice(OrderPO opo, CustomerPO cpo){
		return opo.getRoomNum()*100;
	}
	
	public boolean ableToProduce(CustomerPO po){
		if (po.getCredit()>0) {
			return true;
		}else{
		return false;
		}
	}
	
	public String changeResult(OrderPO po, String state){
		return state;
	}
	
}
