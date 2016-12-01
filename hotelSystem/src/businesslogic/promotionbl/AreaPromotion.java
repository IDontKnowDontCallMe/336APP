package businesslogic.promotionbl;

import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.WebPromotionVO;

public class AreaPromotion implements PromotionType {

	WebPromotionImpl webPromotionImpl;
	double discount;

	@Override
	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		List<WebPromotionVO> list = webPromotionImpl.getWebPromotionList();
		discount = 1.0;
		for (WebPromotionVO vo : list) {
			if (vo.promotionType.equals("特定商圈促销策略")) {
				if (vo.businessCircleName.equals(calculationVO.businessCircle)) {
					discount = vo.discount;
				}
			}
		}
		int days = (int) (calculationVO.endDate.toEpochDay() - calculationVO.startDate.toEpochDay());
		int result = (int) (calculationVO.roomNum * calculationVO.roomPrice * discount * days);
		System.out.println("按照特定商圈促销策略计算，折扣为" + discount + ",总价为" + result);

		return result;
	}

}
