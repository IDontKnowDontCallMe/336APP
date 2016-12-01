package businesslogic.promotionbl;

import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class CompanyPromotion implements PromotionType {

	HotelPromotionImpl hotelPromotionImpl;
	double discount;

	@Override
	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		List<HotelPromotionVO> list = hotelPromotionImpl.getHotelPromotionList(calculationVO.hotelID);
		discount = 1.0;
		for (HotelPromotionVO vo : list) {
			if (vo.promotionType.equals("合作企业促销策略")) {
				if (customerVO.isCompanyVIP && customerVO.companyName.equals(vo.companyName)) {
					discount = vo.discount;
				}
			}
		}
		int days = (int) (calculationVO.endDate.toEpochDay() - calculationVO.startDate.toEpochDay());
		int result = (int) (calculationVO.roomNum * calculationVO.roomPrice * discount * days);
		System.out.println("按照合作企业促销策略计算，折扣为" + discount + ",总价为" + result);

		return result;
	}

}
