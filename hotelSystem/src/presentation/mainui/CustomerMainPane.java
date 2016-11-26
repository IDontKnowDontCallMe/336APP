package presentation.mainui;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import presentation.customerui.CustomerInfoPane;
import presentation.hotelui.BookedHotelPane;
import presentation.hotelui.HotelSearchPane;
import presentation.orderui.CustomerOrdersPane;
import vo.AreaVO;

public class CustomerMainPane extends VBox{

	private int customerID;
	
	public CustomerMainPane(int customerID) {
		// TODO Auto-generated constructor stub
		super();
		this.customerID = customerID;
		
		Button searchButton = new Button("搜索酒店");
		Button orderListButton = new Button("查看订单");
		Button hotelListButton = new Button("查看预定过的酒店");
		Button infoButton = new Button("查看个人信息");
		Button logoutButton = new Button("注销登录");
		
		this.getChildren().addAll(searchButton, orderListButton, hotelListButton, infoButton, logoutButton);
		
		searchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
			TheMainFrame.jumpTo(new HotelSearchPane(new AreaVO("南京","新街口"), customerID));
		});
		
		orderListButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
			TheMainFrame.jumpTo(new CustomerOrdersPane(customerID));
		});
		
		hotelListButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
			TheMainFrame.jumpTo(new BookedHotelPane(customerID));
		});
		
		infoButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
			TheMainFrame.jumpTo(new CustomerInfoPane(customerID));
		});
		
		logoutButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
			TheMainFrame.backTo();
		});
		
	}
	
}
