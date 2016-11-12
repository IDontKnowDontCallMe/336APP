package po;

public class HotelPO {
	
	private String hotelID;
	private String address;
	private String introduction;
	private String[] service;
	private String[] roomType;
	private int[] price;
	private String workerName;
	private String phoneNumber;
	
	public HotelPO(String hotelID, String address, String introduction, String[] service, String[] roomType, 
			        int[] price, String workerName, String phoneNumeber){
		
		this.hotelID = hotelID;
		this.address = address;
		this.introduction = introduction;
		this.service = service;
		this.roomType = roomType;
		this.price = price;
		this.workerName = workerName;
		this.phoneNumber = phoneNumeber;
	}
	
	public void setHotelID(String hotelID){
		this.hotelID = hotelID;
	}
	
	public String getHotelID(){
		return this.hotelID;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}
	
	public String getIntroduction(){
		return this.introduction;
	}
	
	public void setService(String[] service){
		this.service = service;
	}
	
	public String[] getService(){
		return this.service;
	}
	
	public void setRoomType(String[] roomType){
		this.roomType = roomType;
	}
	
	public String[] getRoomType(){
		return this.roomType;
	}
	
	public void setPrice(int[] price){
		this.price = price;
	}
	
	public int[] getPrice(){
		return this.price;
	}
	
	public void setWorkerName(String workerName){
		this.workerName = workerName;
	}
	
	public String getWorkerName(){
		return this.workerName;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	

}
