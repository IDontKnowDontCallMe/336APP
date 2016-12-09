package vo;

import java.io.Serializable;
import java.time.LocalDate;;

public class WebPromotionVO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String promotionType;
    public LocalDate startTime;
    public LocalDate endTime;
    public String cityName;
    public String businessCircleName;
    public double discount;

    public WebPromotionVO(String promotionType, LocalDate startTime, LocalDate endTime,  String cityName,
    		String businessCircleName, double discount){
    	this.promotionType=promotionType;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.cityName = cityName;
    	this.businessCircleName=businessCircleName;
    	this.discount=discount;
    }
    
    public WebPromotionVO(WebPromotionVO vo){
    	this.promotionType=vo.promotionType;
    	this.startTime=vo.startTime;
    	this.endTime=vo.endTime;
    	this.cityName = vo.cityName;
    	this.businessCircleName=vo.businessCircleName;
    	this.discount=vo.discount;
    }
}
