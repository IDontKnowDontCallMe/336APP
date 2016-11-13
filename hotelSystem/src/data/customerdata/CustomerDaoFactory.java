package data.customerdata;

public class CustomerDaoFactory {
	
	private static CreditDao creditDao = null;
	private static CustomerInfoDao customerInfoDao = null;
	
	public static CustomerInfoDao getCustomerInfoDao(){
		if(customerInfoDao==null){
			customerInfoDao = new CustomerInfoDaoImpl();
		}
		return customerInfoDao;
	}
	
	public static CreditDao getCreditDao(){
		if(creditDao==null){
			creditDao = new CreditDaoImpl();
		}
		return creditDao;
	}

}
