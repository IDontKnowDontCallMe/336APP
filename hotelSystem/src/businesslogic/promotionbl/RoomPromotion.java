package businesslogic.promotionbl;


import vo.CalculationConditionVO;
import vo.CustomerVO;

public class RoomPromotion implements PromotionType{

	@Override
	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		
		return 0;
	}

}
