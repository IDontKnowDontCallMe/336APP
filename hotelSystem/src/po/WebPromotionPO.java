package po;

import java.time.LocalDate;;

public class WebPromotionPO {
	
	String promotionType;
	
	LocalDate startTime;
	LocalDate endTime;
	
	String businessCircleName;
	
	double discount;
	
	double[] discountOfLevel;
	
	public WebPromotionPO(String promotionType, LocalDate startTime, LocalDate endTime, 
			String businessCircleName, double discount, double[] discountOfLevel){
		
		this.promotionType = promotionType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.businessCircleName = businessCircleName;
		this.discount = discount;
		this.discountOfLevel = discountOfLevel;
		
	}
	
	public void setPromotionType(String promotionType){
		this.promotionType = promotionType;
	}

	public String getPromotionType(){
		return this.promotionType;
	}
	
	public void setStartTime(LocalDate startTime){
		this.startTime = startTime;
	}
	
	public LocalDate getStartTime(){
		return this.startTime;
	}
	
	public void setEndTime(LocalDate endTime){
		this.endTime = endTime;
	}
	
	public LocalDate getEndTime(){
		return this.endTime;
	}
	
	public void setBusinessCircle(String businessCircleName){
		this.businessCircleName = businessCircleName;
	}
	
	public String getBusinessCircleName(){
		return this.businessCircleName;
	}
	
	public void setDiscount(double discount){
		this.discount = discount;
	}
	
	public double getDiscount(){
		return this.discount;
	}
	
	public void setDiscountOfLevel(double[] discountOfLevel){
		this.discountOfLevel = discountOfLevel;
	}
	
	public double getDiscountOfLevel(){
		return this.getDiscountOfLevel();
	}
}
