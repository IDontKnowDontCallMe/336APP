package data.userdata;

public class UserDaoFactory {
	
	private static CustomerDao customerDao;
	private static HotelDao hotelDao;
	private static MarketerDao marketerDao;
	
	public static CustomerDao getCustomerDao(){
		if(customerDao==null){
			customerDao = new CustomerDaoImpl();
		}
		return customerDao;
	}
	
	public static HotelDao getHotelDao(){
		if(hotelDao==null){
			hotelDao = new HotelDaoImpl();
		}
		return hotelDao;
	}
	
	public static MarketerDao getMarketerDao(){
		if(marketerDao==null){
			marketerDao = new MarketerDaoImpl();
		}
		return marketerDao;
	}

}
