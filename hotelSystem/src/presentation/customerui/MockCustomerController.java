package presentation.customerui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import businesslogic.customerbl.CustomerController;
import sun.security.jca.GetInstance;
import sun.security.jca.GetInstance.Instance;
import vo.CreditVO;
import vo.CustomerVO;

public class MockCustomerController extends CustomerController{

	private CustomerVO customerVO = new CustomerVO(1000000001, "小明", "18787878787", false , null, false, null, 500, 5);
	private List<CreditVO> creditList;
	
	private static MockCustomerController instance;
	
	public MockCustomerController() {
		// TODO Auto-generated constructor stub
		CreditVO vo1 = new CreditVO(1000000001, LocalDateTime.of(LocalDate.of(2016, 10, 10), LocalTime.of(16, 8, 6)), 
									-1, "信用充值", 100, 500);
		CreditVO vo2 = new CreditVO(1000000001, LocalDateTime.of(LocalDate.of(2016, 9, 30), LocalTime.of(12, 00, 00)), 
									600052222, "异常订单", 150, 400);
		CreditVO vo3 = new CreditVO(1000000001, LocalDateTime.of(LocalDate.of(2016, 9, 15), LocalTime.of(15, 15, 30)), 
									600000256, "撤销订单", 125, 550);
		CreditVO vo4 = new CreditVO(1000000001, LocalDateTime.of(LocalDate.of(2016, 9, 10), LocalTime.of(12, 00, 00)), 
									600000001, "异常订单", 200, 675);
		creditList = new ArrayList<CreditVO>();
		creditList.add(vo1);
		creditList.add(vo2);
		creditList.add(vo3);
		creditList.add(vo4);
	}
	
	public static MockCustomerController getInstance(){
		return instance==null? new MockCustomerController(): instance;
	}
	
	@Override
	public CustomerVO getCustomerInfo(int customerID) {
		// TODO Auto-generated method stub
		return customerVO;
	}

	@Override
	public boolean updateCustomerInfo(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		
		if(customerVO.customerName.equals("江泽民")) return false;
		
		this.customerVO.customerName = customerVO.customerName;
		this.customerVO.phoneNumber = customerVO.phoneNumber;
		
		return true;
	}

	@Override
	public List<CreditVO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		return creditList;
	}

	@Override
	public boolean registerBirthVIP(LocalDate birthday) {
		// TODO Auto-generated method stub
		if(customerVO.isBirthVIP){
			return false;
		}
		
		customerVO.isBirthVIP = true;
		customerVO.birthday = birthday;
		
		return true;
	}

	@Override
	public boolean registerCompanyVIP(String companyName) {
		// TODO Auto-generated method stub
		if(customerVO.isCompanyVIP){
			return false;
		}
		customerVO.isCompanyVIP = true;
		customerVO.companyName = companyName;
		return true;
	}
	
}

