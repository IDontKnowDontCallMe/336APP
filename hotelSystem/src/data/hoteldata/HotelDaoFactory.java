package data.hoteldata;

public class HotelDaoFactory {
	
	private static HotelInfoDao hotelInfoDao;
	
	
	public static HotelInfoDao getHotelInfoDao(){
		if(hotelInfoDao==null){
			hotelInfoDao = new HotelInfoDaoImpl();
		}
		return hotelInfoDao;
	}

}
