package businesslogic.promotionbl;

import vo.CalculationConditionVO;
import vo.CustomerVO;

public interface PromotionType {
	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO);
}
