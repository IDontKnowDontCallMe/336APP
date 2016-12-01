package data.customerdata;

import java.time.LocalDate;
import java.util.Date;

import po.CustomerPO;

public class CustomerInfoDaoImpl implements CustomerInfoDao{
	
	

	@Override
	public CustomerPO getInfo(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateInfo(CustomerPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setBirthVIP(int customerID, LocalDate birthday) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setCompanyVIP(int customerID, String companyName) {
		// TODO Auto-generated method stub
		return false;
	}

}
