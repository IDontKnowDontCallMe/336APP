package businesslogic.promotionbl;

import java.time.LocalDate;
import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class HotelTimePromotion implements PromotionType {

	HotelPromotionImpl hotelPromotionImpl;
	double discount;
	int day;

	@Override
	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		List<HotelPromotionVO> list = hotelPromotionImpl.getHotelPromotionList(calculationVO.hotelID);
		discount = 1.0;

		for (HotelPromotionVO vo : list) {
			if (vo.promotionType.equals("特定时间促销策略")) {
				boolean isFitted = true;
				LocalDate orderStart = calculationVO.startDate;
				LocalDate orderEnd = calculationVO.endDate;
				LocalDate promotionStart = vo.startTime;
				LocalDate promotionEnd = vo.endTime;
				if ((orderStart.isBefore(promotionStart) && orderEnd.isBefore(promotionStart))
						|| (orderStart.isBefore(promotionStart) && orderEnd.equals(promotionStart))
						|| (orderStart.isAfter(promotionEnd) && orderEnd.isAfter(promotionEnd))) {
					isFitted = false;
				} else if (orderStart.isBefore(promotionStart) && orderEnd.isAfter(promotionStart)
						&& orderEnd.isBefore(promotionEnd)) {
					day = (int) (orderEnd.toEpochDay() - promotionStart.toEpochDay());
				} else if ((orderStart.isAfter(promotionStart) && orderEnd.isBefore(promotionEnd))
						|| (orderStart.equals(promotionStart) && orderEnd.isBefore(promotionEnd))) {
					day = (int) (orderEnd.toEpochDay() - orderStart.toEpochDay());
				} else if ((orderStart.isAfter(promotionStart) && orderStart.isBefore(orderEnd)
						&& orderEnd.isAfter(promotionEnd))
						|| (orderStart.isAfter(promotionStart) && orderStart.isBefore(orderEnd)
								&& orderEnd.equals(promotionEnd))) {
					day = (int) (promotionEnd.toEpochDay() - orderStart.toEpochDay());
				} else if (orderStart.equals(orderEnd) && orderEnd.isAfter(promotionEnd)) {
					day = 1;
				} else {
					day = (int) (promotionEnd.toEpochDay() - promotionStart.toEpochDay());
				}

				if (isFitted) {
					discount = (discount < vo.discount) ? discount : vo.discount;
				}
			}
		}
		int days = (int) (calculationVO.endDate.toEpochDay() - calculationVO.startDate.toEpochDay());
		int result = (int) (calculationVO.roomNum * calculationVO.roomPrice * discount * day
				+ calculationVO.roomNum * calculationVO.roomPrice * discount * (days - day));
		System.out.println("按照特定时间促销策略计算，折扣为" + discount + ",总价为" + result);

		return result;
	}

}
