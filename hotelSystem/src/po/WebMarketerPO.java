package po;

import vo.WebMarketerVO;

public class WebMarketerPO {
	
	int ID;
	String name;
	String phoneNumber;

	public WebMarketerPO(int ID, String name, String phoneNumber) {
		this.ID = ID;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void setWebMarketerID(int webMarketerID){
		this.ID = webMarketerID;
	}
	
	public int getWebMarketerID(){
		return this.ID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
}
