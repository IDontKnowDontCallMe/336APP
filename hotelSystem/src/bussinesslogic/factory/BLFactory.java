package bussinesslogic.factory;

import java.rmi.Remote;
import businesslogicservice.customerblservice.CustomerBLService;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import businesslogicservice.userblservice.UserBLService;

public class BLFactory {
	private Remote remote;
	private static BLFactory blFactory = new BLFactory();
	public static BLFactory getInstance(){
		return blFactory;
	}
	
	private BLFactory() {
		
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public CustomerBLService getCustomerBLService() {
		return (CustomerBLService)remote;
	}
	
	public HotelBLService getHotelBLService() {
		return (HotelBLService)remote;
	}
	
	public OrderBLService getOrderBLService() {
		return (OrderBLService)remote;
	}
	
	public PromotionBLService getPromotionBLService() {
		return (PromotionBLService)remote;
	}
	
	public RoomBLService getRoomBLService() {
		return (RoomBLService)remote;
	}
	
	
	public UserBLService getUserBLService() {
		return (UserBLService)remote;
	}
	
}
