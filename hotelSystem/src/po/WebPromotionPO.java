package po;

import java.time.LocalDate;;

public class WebPromotionPO {
	String promotionType;
	LocalDate startTime;
	LocalDate endTime;
	String businessCircleName;
	double discount;
	
	
	public WebPromotionPO(String promotionType, LocalDate startTime, LocalDate endTime, 
			String businessCircleName, double discount){
		
		this.promotionType = promotionType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.businessCircleName = businessCircleName;
		this.discount = discount;
		
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
	
}
