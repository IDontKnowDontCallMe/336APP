package po;

public class WebPromotionPO {
	
	String promotionType;
	
	String startTime;
	String endTime;
	
	String businessCircleName;
	
	double discount;
	
	double[] discountOfLevel;
	
	public WebPromotionPO(String promotionType, String startTime, String endTime, 
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
	
	public void setStartTime(String startTime){
		this.startTime = startTime;
	}
	
	public String getStartTime(){
		return this.startTime;
	}
	
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}
	
	public String getEndTime(){
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
