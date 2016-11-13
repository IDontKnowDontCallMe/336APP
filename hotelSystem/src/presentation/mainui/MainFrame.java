package presentation.mainui;

import data.factory.DataFactory;
import po.OrderPO;

public class MainFrame {
	
	public static void main(String[] args){
		
		OrderPO po = DataFactory.getOrderDataService().getOrderInfo(4);
		
		System.out.println(po.getCustomerName() + po.getHotelName());
	}

}
