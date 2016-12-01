package businesslogic.promotionbl;

import java.util.ArrayList;
import java.util.List;

import data.factory.DataFactory;
import po.HotelPromotionPO;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class HotelPromotionImpl {

	private List<HotelPromotionPO> list;

	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) {
		List<HotelPromotionVO> result = new ArrayList<HotelPromotionVO>();

		for (HotelPromotionPO po : list) {
			HotelPromotionVO vo = new HotelPromotionVO(po.getHotelID(), po.getPromotionType(), po.getStartTime(),
					po.getEndTime(), po.getCompanyName(), po.getMinNum(), po.getDiscount());
			result.add(vo);
		}
		return result;
	}

	public boolean addHotelPromotion(HotelPromotionVO vo) {
		HotelPromotionPO po = new HotelPromotionPO(vo.hotelID, vo.promotionType, vo.startTime, vo.endTime,
				vo.companyName, vo.minNum, vo.discount);
		DataFactory.getPromotionDataService().writeHotelPromotionObject(vo.hotelID, po);
		return true;
	}

	public boolean updateHotelPromotion(HotelPromotionVO vo) {
		DataFactory.getPromotionDataService().deleteHotelPromotionObject(vo.hotelID, vo.promotionType);
		HotelPromotionPO po = new HotelPromotionPO(vo.hotelID, vo.promotionType, vo.startTime, vo.endTime,
				vo.companyName, vo.minNum, vo.discount);
		DataFactory.getPromotionDataService().writeHotelPromotionObject(vo.hotelID, po);
		return true;
	}

	public boolean deleteHotelPromotion(HotelPromotionVO vo) {
		DataFactory.getPromotionDataService().deleteHotelPromotionObject(vo.hotelID, vo.promotionType);
		return true;
	}

	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {

		RoomPromotion roomPromotion = new RoomPromotion();
		int roomPrice = roomPromotion.calculateOrder(calculationVO, customerVO);
		HotelTimePromotion hotelTimePromotion = new HotelTimePromotion();
		int hotelTimePrice = hotelTimePromotion.calculateOrder(calculationVO, customerVO);
		BirthdayPromotion birthdayPromotion = new BirthdayPromotion();
		int birthdayPrice = birthdayPromotion.calculateOrder(calculationVO, customerVO);
		CompanyPromotion companyPromotion = new CompanyPromotion();
		int companyPrice = companyPromotion.calculateOrder(calculationVO, customerVO);

		int resultPrice = (roomPrice < hotelTimePrice) ? roomPrice : hotelTimePrice;
		resultPrice = (resultPrice < birthdayPrice) ? resultPrice : birthdayPrice;
		resultPrice = (resultPrice < companyPrice) ? resultPrice : companyPrice;
		return resultPrice;
	}

}
