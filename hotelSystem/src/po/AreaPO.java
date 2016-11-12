package po;

public class AreaPO {
	
	String city;
	
	String businessCircle;
	
	public AreaPO(String city, String businessCircle){
		this.city = city;
		this.businessCircle = businessCircle;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public void setBusinessCircle(String businessCircle){
		this.businessCircle = businessCircle;
	}
	
	public String getBusinessCircle(){
		return this.businessCircle;
	}

}
