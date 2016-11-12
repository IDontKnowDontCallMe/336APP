package data.factory;

import data.orderdata.OrderDataServiceImpl;
import dataservice.orderdataservice.OrderDataService;

public class DataFactory {
	
	private static OrderDataService orderDataService;
	
	public static OrderDataService getOrderDataServiceImplInstance(){
		if(orderDataService==null){
			orderDataService = new OrderDataServiceImpl();
		}
		return orderDataService;
	}

}
