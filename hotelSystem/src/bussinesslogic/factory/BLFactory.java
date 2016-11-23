package bussinesslogic.factory;

import java.rmi.Remote;
import businesslogicservice.customerblservice.CreditblService;
import businesslogicservice.customerblservice.CustomerBLService;
import businesslogicservice.customerblservice.CustomerInfoblService;
import businesslogicservice.customerblservice.VIPblService;
import businesslogicservice.hotelblservice.CommentblService;
import businesslogicservice.hotelblservice.HotelInfoblService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import businesslogicservice.userblservice.CustomerblService;
import businesslogicservice.userblservice.HotelblService;
import businesslogicservice.userblservice.LoginblService;
import businesslogicservice.userblservice.UserBLService;
import businesslogicservice.userblservice.WebMarketerblService;

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
	
	public CreditblService getCreditblService() {
		return (CreditblService)remote;
	}
	
	public CustomerBLService getCustomerBLService() {
		return (CustomerBLService)remote;
	}
	
	public CustomerInfoblService getCustomerInfoblService() {
		return (CustomerInfoblService)remote;
	}
	
	public VIPblService getVIPblService() {
		return (VIPblService)remote;
	}
	
	public CommentblService getCommentblService() {
		return (CommentblService)remote;
	}
	
	public HotelInfoblService getHotelInfoblService() {
		return (HotelInfoblService)remote;
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
	
	public CustomerblService getCustomerblService() {
		return (CustomerblService)remote;
	}
	
	public HotelblService getHotelblService() {
		return (HotelblService)remote;
	}
	
	public LoginblService getLoginblService() {
		return (LoginblService)remote;
	}
	
	public UserBLService getUserBLService() {
		return (UserBLService)remote;
	}
	
	public WebMarketerblService getWebMarketerblService() {
		return (WebMarketerblService)remote;
	}

}
