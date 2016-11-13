package data.factory;

import data.customerdata.CustomerDataServiceImpl;
import data.hoteldata.HotelDataServiceImpl;
import data.orderdata.OrderDataServiceImpl;
import data.promotiondata.PromotionDataServiceImpl;
import data.roomdata.RoomDataServiceImpl;
import data.userdata.UserDataServiceImpl;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.UserDataService;

public class DataFactory {
	private static OrderDataService orderDataService;
	private static CustomerDataService  customerDataService;
	private static RoomDataService  roomDataService;
	private static HotelDataService hotelDataService ;
	private static UserDataService userDataService;
	private static PromotionDataService promotionDataService ;
	
	
	public static OrderDataService getOrderDataService(){
		if(orderDataService==null){
			orderDataService = new OrderDataServiceImpl();
		}
		return orderDataService;
	}
	
	public static CustomerDataService getCustomerDataService(){
		if(customerDataService==null){
			customerDataService = new CustomerDataServiceImpl();
		}
		return customerDataService;
	}
	
	public static RoomDataService getRoomDataService(){
		if(roomDataService==null){
			roomDataService = new RoomDataServiceImpl();
		}
		return roomDataService;
	}
	
	public static HotelDataService getHotelDataService(){
		if(hotelDataService==null){
			hotelDataService = new HotelDataServiceImpl();
		}
		return hotelDataService;
	}
	
	public static UserDataService getUserDataService(){
		if(userDataService==null){
			userDataService = new UserDataServiceImpl();
		}
		return userDataService;
	}
	
	public static PromotionDataService getPromotionDataService(){
		if(promotionDataService==null){
			promotionDataService = new PromotionDataServiceImpl();
		}
		return promotionDataService;
	}
}
