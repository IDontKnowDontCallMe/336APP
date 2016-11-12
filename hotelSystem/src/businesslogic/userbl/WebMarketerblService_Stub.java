package businesslogic.userbl;

import businesslogicservice.userblservice.WebMarketerblService;
import po.WebMarketerPO;
import vo.WebMarketerVO;

public class WebMarketerblService_Stub implements WebMarketerblService{
	
	WebMarketerVO[] list;
	
	public WebMarketerblService_Stub(WebMarketerVO[] list) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}
	

	public WebMarketerVO[] getWebMarketerList(){
		return list;
	}
	
	public WebMarketerVO getWebMarketer(String userID){
		
		WebMarketerVO example = new WebMarketerVO();
		
		System.out.println("Get webmarketer successfully");

		
		return example;
	}
	
	public void addWebMarketer(WebMarketerPO po){
		System.out.println("Add webmarketer successfully");
	}
	
	public void editWebMarketer(WebMarketerPO po){
		System.out.println("Edit webmarketer successfully");
	}
	
	public void deleteWebMarketer(WebMarketerPO po){
		System.out.println("Delete webmarketer successfully");
	}
	
	public boolean check(String userID, String password){
		
		System.out.println("Yes!");

		
		return true;
	}


	@Override
	public void updateWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
