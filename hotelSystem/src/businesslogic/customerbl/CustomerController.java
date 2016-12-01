package businesslogic.customerbl;

import java.time.LocalDate;
import java.util.List;
import businesslogicservice.customerblservice.CustomerBLService;
import vo.CreditVO;
import vo.CustomerVO;

public class CustomerController implements CustomerBLService{
	CustomerBLImpl customerblImpl = new CustomerBLImpl();
	
	@Override
	public CustomerVO getCustomerInfo(int customerID) {
		// TODO Auto-generated method stub
		return customerblImpl.getCustomerInfo(customerID);
	}

	@Override
	public boolean updateCustomerInfo(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return customerblImpl.updateCustomerInfo(customerVO);
	}

	@Override
	public List<CreditVO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		return customerblImpl.getCreditList(customerID);
	}

	@Override
	public boolean registerCompanyVIP(int customerID, String companyName) {
		// TODO Auto-generated method stub
		return customerblImpl.registerCompanyVIP(customerID, companyName);
	}

	@Override
	public boolean registerBirthVIP(int customerID, LocalDate birthday) {
		// TODO Auto-generated method stub
		return registerBirthVIP(customerID, birthday);
	}

}
