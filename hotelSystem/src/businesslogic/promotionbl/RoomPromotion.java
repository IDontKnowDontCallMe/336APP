package businesslogic.promotionbl;

import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class RoomPromotion implements PromotionType {

	HotelPromotionImpl hotelPromotionImpl;
	double discount;

	@Override
	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		List<HotelPromotionVO> list = hotelPromotionImpl.getHotelPromotionList(calculationVO.hotelID);
		discount = 1.0;
		for (HotelPromotionVO vo : list) {
			if (vo.promotionType.equals("预定多间促销策略")) {
				if (vo.minNum <= calculationVO.roomNum) {
					discount = (discount < vo.discount) ? discount : vo.discount;
				}
			}
		}
		int days = (int) (calculationVO.endDate.toEpochDay() - calculationVO.startDate.toEpochDay());
		int result = (int) (calculationVO.roomNum * calculationVO.roomPrice * discount * days);
		System.out.println("按照预定多间促销策略计算，折扣为" + discount + ",总价为" + result);

		return result;
	}

}
