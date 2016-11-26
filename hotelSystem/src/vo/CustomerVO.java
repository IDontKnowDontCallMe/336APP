package vo;

import java.time.LocalDate;

public class CustomerVO {
	
	public int customerID;
	public String customerName;
	public String phoneNumber;
	public boolean isBirthVIP;
	public LocalDate birthday;
	public boolean isCompanyVIP;
	public String companyName;
	public int credit;
	public int level;
	
	
	public CustomerVO(int customerID, String customerName, String phoneNumber, boolean isBirthVIP, LocalDate birthday, 
						boolean isCompanyVIP, String companyName, int credit, int level){
		this.customerID = customerID;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.isBirthVIP = isBirthVIP;
		this.birthday = birthday;
		this.isCompanyVIP = isCompanyVIP;
		this.companyName = companyName;
		this.credit = credit;
		this.level = level;
	}

}
