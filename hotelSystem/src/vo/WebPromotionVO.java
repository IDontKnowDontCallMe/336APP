package vo;

import java.time.LocalDate;;

public class WebPromotionVO {
	
    public String promotionType;
    public LocalDate startTime;
    public LocalDate endTime;
    public String businessCircleName;
    public double discount;
    public double[] discountOfLevel;

    public WebPromotionVO(String promotionType, LocalDate startTime, LocalDate endTime, 
    		String businessCircleName, double discount, double[]discountOfLevel){
    	this.promotionType=promotionType;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.businessCircleName=businessCircleName;
    	this.discount=discount;
    	this.discountOfLevel=discountOfLevel;
    }
    
    public WebPromotionVO(WebPromotionVO vo){
    	this.promotionType=vo.promotionType;
    	this.startTime=vo.startTime;
    	this.endTime=vo.endTime;
    	this.businessCircleName=vo.businessCircleName;
    	this.discount=vo.discount;
    	this.discountOfLevel=vo.discountOfLevel;
    
    }
}
