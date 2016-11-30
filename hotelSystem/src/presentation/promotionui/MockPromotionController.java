package presentation.promotionui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import businesslogic.promotionbl.PromotionController;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;
import vo.LevelVO;

public class MockPromotionController extends PromotionController {

	private List<HotelPromotionVO> hotelPromotionList;
	private List<WebPromotionVO> webPromotionList;
	private int creditDistance;
	private int maxLevel;
	private double discountDistance;
	private static MockPromotionController instance;

	public MockPromotionController() {

		HotelPromotionVO vo1, vo2, vo3, vo4, vo5;
		WebPromotionVO vo6, vo7;
		hotelPromotionList = new ArrayList<HotelPromotionVO>();
		webPromotionList = new ArrayList<WebPromotionVO>();
		vo1 = new HotelPromotionVO(123, "预订多间促销策略", null, null, null, 3, 0.8);
		vo2 = new HotelPromotionVO(123, "预订多间促销策略", null, null, null, 5, 0.7);
		vo3 = new HotelPromotionVO(123, "特定时间促销策略", LocalDate.parse("2016-11-10"), LocalDate.parse("2016-11-12"), null,
				-1, 0.8);
		vo4 = new HotelPromotionVO(123, "合作企业促销策略", null, null, "南京大学", -1, 0.8);
		vo5 = new HotelPromotionVO(123, "客户生日促销策略", null, null, null, -1, 0.8);
		vo6 = new WebPromotionVO("特定时间促销策略", LocalDate.parse("2016-11-10"), LocalDate.parse("2016-11-12"), null, 0.8);
		vo7 = new WebPromotionVO("特定商圈促销策略", null, null, "新街口", 0.8);
		hotelPromotionList.add(vo1);
		hotelPromotionList.add(vo2);
		hotelPromotionList.add(vo3);
		hotelPromotionList.add(vo4);
		hotelPromotionList.add(vo5);
		webPromotionList.add(vo6);
		webPromotionList.add(vo7);

		LevelVO vo;
		vo = new LevelVO(10000, 10, 0.05);
		creditDistance = vo.creditDistance;
		maxLevel = vo.maxLevel;
		discountDistance = vo.discountDistance;
	}

	public static MockPromotionController getInstance() {
		return instance == null ? new MockPromotionController() : instance;
	}

	@Override
	public List<HotelPromotionVO> getHotelPromotionList(int HotelID) {
		List<HotelPromotionVO> list = new ArrayList<HotelPromotionVO>();
		for (HotelPromotionVO vo : hotelPromotionList) {
			HotelPromotionVO temp = new HotelPromotionVO(vo);
			list.add(temp);
		}
		return list;
	}

	@Override
	public List<WebPromotionVO> getWebPromotionList() {
		List<WebPromotionVO> list = new ArrayList<WebPromotionVO>();
		for (WebPromotionVO vo : webPromotionList) {
			WebPromotionVO temp = new WebPromotionVO(vo);
			list.add(temp);
		}
		return list;
	}

	@Override
	public LevelVO getLevelMethod() {
		LevelVO resVO = new LevelVO(creditDistance, maxLevel, discountDistance);
		return resVO;
	}

	@Override
	public boolean updateLevelInfo(LevelVO levelVO) {

		return true;
	}
}
