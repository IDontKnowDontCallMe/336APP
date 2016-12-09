package vo;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			boolean isCompanyVIP, String companyName, int credit, int level) {
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

	public CustomerVO(CustomerVO vo) {
		this.customerID = vo.customerID;
		this.customerName = vo.customerName;
		this.phoneNumber = vo.phoneNumber;
		this.isBirthVIP = vo.isBirthVIP;
		this.birthday = vo.birthday;
		this.isCompanyVIP = vo.isCompanyVIP;
		this.companyName = vo.companyName;
		this.credit = vo.credit;
		this.level = vo.level;
	}
}
