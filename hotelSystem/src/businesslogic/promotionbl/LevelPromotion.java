package businesslogic.promotionbl;

import vo.CalculationConditionVO;
import vo.CustomerVO;

public class LevelPromotion implements PromotionType{
	
	LevelImpl levelImpl;
	double discount;

	@Override
	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		discount = levelImpl.getDiscount(customerVO.credit);
		int days = (int) (calculationVO.endDate.toEpochDay() - calculationVO.startDate.toEpochDay());
		int result = (int) (calculationVO.roomNum * calculationVO.roomPrice * discount * days);
		System.out.print("按照会员等级促销策略计算，折扣为" + discount + ",总价为" + result);

		return result;
	}

}
