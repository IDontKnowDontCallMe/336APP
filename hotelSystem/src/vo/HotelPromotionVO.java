package vo;

import java.time.LocalDate;

public class HotelPromotionVO {
	public String hotelName;

	public String promotionType;
	public LocalDate startTime;
	public LocalDate endTime;
	public String companyName;
	public int minNum;
	public double discount;
	
	public HotelPromotionVO (String hotelName, String promotionType, LocalDate startTime,
			LocalDate endTime, String companyName, int minNum, double discount){
		this.hotelName=hotelName;
		this.promotionType=promotionType;
		this.startTime=startTime;
		this.endTime=endTime;
		this.companyName=companyName;
		this.minNum=minNum;
		this.discount=discount;
	}
	
	public HotelPromotionVO (HotelPromotionVO vo){
		this.hotelName=vo.hotelName;
		this.promotionType=vo.promotionType;
		this.startTime=vo.startTime;
		this.endTime=vo.endTime;
		this.companyName=vo.companyName;
		this.minNum=vo.minNum;
		this.discount=vo.discount;
	}
}
