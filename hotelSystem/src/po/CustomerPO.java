package po;

public class CustomerPO {
	
	private String name;
	private String phoneNumber;
	
	private String VIPType;
	private String VIPbirthday;
	private String VIPcompany;
	
	private int credit;
	private int level;
	
	public CustomerPO(String name, String phoneNumber, String VIPType, String VIPbirthday, String VIPcompany, int credit, int level){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.VIPbirthday = VIPbirthday;
		this.VIPType = VIPType;
		this.VIPcompany = VIPcompany;
		this.credit = credit;
		this.level = level;
		
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
	
	public void setVIPType(String VIPType){
		this.VIPType = VIPType;
	}
	
	public String getVIPType(){
		return this.VIPType;
	}
	
	public void setVIPbirthday(String VIPbirthday){
		this.VIPbirthday = VIPbirthday;
	}
	
	public String getVIPbirthday(){
		return this.VIPbirthday;
	}
	
	public void setVIPcompany(String VIPcompany){
		this.VIPcompany = VIPcompany;
	}
	
	public String getVIPcompany(){
		return this.VIPcompany;
	}
	
	public void setCredit(int credit){
		this.credit = credit;
	}
	
	public int getCredit(){
		return this.credit;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return this.level;
	}
	
}
