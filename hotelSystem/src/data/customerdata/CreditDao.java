package data.customerdata;

import java.util.List;

import po.CreditPO;

public interface CreditDao {

	public List<CreditPO> getCreditList(int customerID);
	
}
