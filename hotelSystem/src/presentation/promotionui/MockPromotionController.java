package presentation.promotionui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import businesslogic.promotionbl.PromotionBLImpl;
import businesslogic.promotionbl.PromotionController;
import po.OrderPO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;


public class MockPromotionController extends PromotionController{

	private List<HotelPromotionVO> hotelPromotionList;
	private List<WebPromotionVO> webPromotionList;
	
	public MockPromotionController() {
		// TODO Auto-generated constructor stub
		
		
		HotelPromotionVO vo1,vo2,vo3,vo4,vo5;
		WebPromotionVO vo6,vo7,vo8;
		hotelPromotionList = new ArrayList<HotelPromotionVO>();
		webPromotionList = new ArrayList<WebPromotionVO>();
		vo1 = new HotelPromotionVO("如家","预订多间促销策略",null,null,null,3,0.8);
		vo2 = new HotelPromotionVO("如家","预订多间促销策略",null,null,null,5,0.7);
		vo3 = new HotelPromotionVO("如家","特定时间促销策略",LocalDate.parse("2016-11-10"),
				LocalDate.parse("2016-11-12"),null,-1,0.8);
		vo4 = new HotelPromotionVO("如家","合作企业促销策略",null,null,"南京大学",-1,0.8);
		vo5 = new HotelPromotionVO("如家","客户生日促销策略",null,null,null,-1,0.8);
		vo6 = new WebPromotionVO("特定时间促销策略",LocalDate.parse("2016-11-10"),LocalDate.parse("2016-11-12"),
				null,0.8);
		vo7 = new WebPromotionVO("特定商圈促销策略",null,null,"新街口",0.8);
		//vo8 = new WebPromotionVO("会员等级促销策略",null,null,null,0.8,null);
		hotelPromotionList.add(vo1);
		hotelPromotionList.add(vo2);
		hotelPromotionList.add(vo3);
		hotelPromotionList.add(vo4);
		hotelPromotionList.add(vo5);
		webPromotionList.add(vo6);
		webPromotionList.add(vo7);
//			webPromotionList.add(vo8);
		
	}

	@Override
	public List<HotelPromotionVO> getHotelPromotionList(int HotelID) {
		// TODO Auto-generated method stub
		List<HotelPromotionVO> list = new ArrayList<HotelPromotionVO>();
		for(HotelPromotionVO vo:hotelPromotionList){
			HotelPromotionVO temp = new HotelPromotionVO(vo);
			list.add(temp);
		}
		return list;
	}

	@Override
	public List<WebPromotionVO> getWebPromotionList() {
		// TODO Auto-generated method stub
		List<WebPromotionVO> list = new ArrayList<WebPromotionVO>();
		for(WebPromotionVO vo:webPromotionList){
			WebPromotionVO temp = new WebPromotionVO(vo);
			list.add(temp);
		}
		return list;
	}
	
	@Override
	public boolean addHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHotelPromotion(int hotelID, String promotionName) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebPromotion(String promotionName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calculateOrder(OrderPO po) {
		// TODO Auto-generated method stub
		return 0;
	}
}
