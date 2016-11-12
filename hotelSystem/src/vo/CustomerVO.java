package vo;

public class CustomerVO {
	
	String name;
	String phoneNumber;
	
	String VIPType;
	String VIPbirthday;
	String VIPcompany;
	
	int credit;
	int level;
	
	public CustomerVO(String name, String phoneNumber, String VIPType, String VIPbirthday, String VIPcompany, int credit, int level){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.VIPbirthday = VIPbirthday;
		this.VIPType = VIPType;
		this.VIPcompany = VIPcompany;
		this.credit = credit;
		this.level = level;
		
	}

}
