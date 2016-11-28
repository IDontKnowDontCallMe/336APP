package businesslogic.promotionbl;

import po.OrderPO;
import po.CustomerPO;

public interface PromotionType {
	public double getDiscount(OrderPO opo, CustomerPO cpo);
}
