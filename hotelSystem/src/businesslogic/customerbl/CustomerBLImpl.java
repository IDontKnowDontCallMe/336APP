package businesslogic.customerbl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.factory.DataFactory;
import po.CreditPO;
import po.CustomerPO;
import vo.CreditVO;
import vo.CustomerVO;

public class CustomerBLImpl {
	
	public CustomerVO getCustomerInfo(int customerID) {
		CustomerPO customerPO = DataFactory.getCustomerDataService().getInfo(customerID);
		CustomerVO customerVO = new CustomerVO(customerPO.getID(), customerPO.getName(), customerPO.getPhoneNumber(), customerPO.isBirthVIP(), customerPO.getVIPbirthday(), customerPO.isCompVIP(), customerPO.getVIPcompany(), customerPO.getCredit(), customerPO.getLevel());
		return customerVO;
	}
	
	public boolean updateCustomerInfo(CustomerVO customerVO) {
		if (!customerVO.equals(getCustomerInfo(customerVO.customerID))) {
			CustomerPO customerPO = new CustomerPO(customerVO.customerName, customerVO.phoneNumber, customerVO.customerID, customerVO.birthday, customerVO.companyName, customerVO.credit, customerVO.level, customerVO.isBirthVIP, customerVO.isCompanyVIP);
			return DataFactory.getCustomerDataService().updateInfo(customerPO);
		}else{
			return true;
		}
	}
	
	public List<CreditVO> getCreditList(int customerID) {
		List<CreditPO> creditPOList= DataFactory.getCustomerDataService().getCreditList(customerID);
		List<CreditVO> creditVOList = new ArrayList<CreditVO>();
		for(CreditPO po:creditPOList){
			CreditVO creditVO = new CreditVO(customerID, po.getTime(), po.getOrderID(), po.getActionType(), po.getDelta(), po.getResult());
			creditVOList.add(creditVO);
		}
		return creditVOList;
	}
	
	public boolean registerBirthVIP(int customerID, LocalDate birthday) {
		return DataFactory.getCustomerDataService().setBirthVIP(customerID, birthday);
	}

	public boolean registerCompanyVIP(int customerID, String companyName) {
		return DataFactory.getCustomerDataService().setCompanyVIP(customerID, companyName);
	}

	

}
