package po;

import java.time.LocalDate;

public class HotelPromotionPO {

	private int hotelID;

	private String promotionType;
	private LocalDate startTime;
	private LocalDate endTime;
	private String companyName;
	private int minNum;

	private double discount;

	public HotelPromotionPO(int hotelID, String promotionType, LocalDate startTime, LocalDate endTime,
			String companyName, int minNum, double discount) {
		this.hotelID = hotelID;
		this.promotionType = promotionType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.companyName = companyName;
		this.minNum = minNum;
		this.discount = discount;
	}

	public void setHoteID(int hotelID) {
		this.hotelID = hotelID;
	}

	public int getHotelID() {
		return this.hotelID;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public String getPromotionType() {
		return this.promotionType;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getStartTime() {
		return this.startTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public LocalDate getEndTime() {
		return this.endTime;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}

	public int getMinNum() {
		return this.minNum;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDiscount() {
		return this.discount;
	}
}
