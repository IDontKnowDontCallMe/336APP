package businesslogic.promotionbl;

import businesslogicservice.promotionblservice.WebPromotionblService;
import po.LevelPO;
import po.WebPromotionPO;
import vo.WebPromotionVO;

public class WebPromotionblService_Stub implements WebPromotionblService{
	
	WebPromotionVO[] list;
	
	public WebPromotionblService_Stub(WebPromotionVO[] list) {
		// TODO Auto-generated constructor stub
		
		
		this.list = list;
	}
	
	
	public WebPromotionVO[] getPromotionList(String type){
		
		System.out.println("get web promotion list successfully");
		
		return list;
	}
	
	public void addPromotion(WebPromotionPO po){
		System.out.println("Add promotion successfully");
	}
	
	public WebPromotionVO getlWebPromotion(String promotion){
		
		WebPromotionVO example = new WebPromotionVO();
		
		System.out.println("get promotion successfully");
		
		return example;
	}
	
	public void updatePromotion(WebPromotionPO po){
		System.out.println("Edit promotion successfully");
	}
	
	public void deletePromotion(WebPromotionPO po){
		System.out.println("Delete promotion successfully");
	}
	
	public void setLevel(LevelPO po){
		System.out.println("Set level successfully");
	}


	


	
}
