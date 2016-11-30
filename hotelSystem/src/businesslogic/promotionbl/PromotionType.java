package businesslogic.promotionbl;

import vo.OrderVO;
import vo.CustomerVO;

public interface PromotionType {
	public double getDiscount(OrderVO ovo, CustomerVO cvo);
	
}
