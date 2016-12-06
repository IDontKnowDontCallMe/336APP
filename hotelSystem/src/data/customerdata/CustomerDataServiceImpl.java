package data.customerdata;

import java.time.LocalDate;
import java.util.List;
import dataservice.customerdataservice.CustomerDataService;
import po.CreditPO;
import po.CustomerPO;

public class CustomerDataServiceImpl implements CustomerDataService{
	
	private CustomerInfoDao customerInfoDao;
	private CreditDao creditDao;
	
	public CustomerDataServiceImpl() {
		// TODO Auto-generated constructor stub
		customerInfoDao = CustomerDaoFactory.getCustomerInfoDao();
		creditDao = CustomerDaoFactory.getCreditDao();
	}

	@Override
	public CustomerPO getInfo(int customerID) {
		// TODO Auto-generated method stub
		return customerInfoDao.getInfo(customerID);
	}

	@Override
	public boolean updateInfo(CustomerPO po) {
		// TODO Auto-generated method stub
		return customerInfoDao.updateInfo(po);
	}

	@Override
	public boolean setBirthVIP(int customerID, LocalDate birthday) {
		// TODO Auto-generated method stub
		return customerInfoDao.setBirthVIP(customerID, birthday);
	}

	@Override
	public boolean setCompanyVIP(int customerID, String companyName) {
		// TODO Auto-generated method stub
		return customerInfoDao.setCompanyVIP(customerID, companyName);
	}

	@Override
	public List<CreditPO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		return creditDao.getCreditList(customerID);
	}


}
