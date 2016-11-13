package data.customerdata;

import java.util.Date;

import po.CustomerPO;

public interface CustomerInfoDao {
	public CustomerPO getInfo(int customerID);

	public boolean updateInfo(CustomerPO po);

	public boolean setBirthVIP(int customerID, Date birthday);

	public boolean setCompanyVIP(int customerID, String companyName);
}
