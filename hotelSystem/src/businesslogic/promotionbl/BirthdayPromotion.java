package businesslogic.promotionbl;

import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class BirthdayPromotion implements PromotionType {

	HotelPromotionImpl hotelPromotionImpl;
	double discount;

	@Override
	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		List<HotelPromotionVO> list = hotelPromotionImpl.getHotelPromotionList(calculationVO.hotelID);
		discount = 1.0;
		for (HotelPromotionVO vo : list) {
			if (vo.promotionType.equals("客户生日促销策略")) {
				if (customerVO.isBirthVIP && (calculationVO.startDate.isBefore(customerVO.birthday)
						|| calculationVO.startDate.equals(customerVO.birthday)
						|| calculationVO.endDate.isAfter(customerVO.birthday))) {
					discount = vo.discount;
				}
			}
		}
		int days = (int) (calculationVO.endDate.toEpochDay() - calculationVO.startDate.toEpochDay());
		int result = (int) (calculationVO.roomNum * calculationVO.roomPrice * discount
				+ calculationVO.roomNum * calculationVO.roomPrice * discount * (days - 1));
		System.out.println("按照客户生日促销策略计算，折扣为" + discount + ",总价为" + result);

		return result;
	}

}
