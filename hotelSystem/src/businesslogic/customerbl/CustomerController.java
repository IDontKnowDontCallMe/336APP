package businesslogic.customerbl;

import java.time.LocalDate;
import java.util.List;

import businesslogicservice.customerblservice.CustomerBLService;
import vo.CreditVO;
import vo.CustomerVO;

public class CustomerController implements CustomerBLService{

	@Override
	public CustomerVO getCustomerInfo(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomerInfo(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CreditVO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerBirthVIP(LocalDate birthday) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerCompanyVIP(String companyName) {
		// TODO Auto-generated method stub
		return false;
	}

}
