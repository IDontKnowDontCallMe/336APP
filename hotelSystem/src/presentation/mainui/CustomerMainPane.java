package presentation.mainui;

import java.rmi.RemoteException;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import presentation.customerui.CustomerInfoPane;
import presentation.hotelui.AreaInputPane;
import presentation.hotelui.BookedHotelPane;
import presentation.orderui.CustomerOrdersPane;

public class CustomerMainPane extends VBox {

	private int customerID;

	public CustomerMainPane(int customerID) {
		super();
		this.customerID = customerID;

		Button searchButton = new Button("搜索酒店");
		Button orderListButton = new Button("查看订单");
		Button hotelListButton = new Button("查看预定过的酒店");
		Button infoButton = new Button("查看个人信息");
		Button logoutButton = new Button("注销登录");

		this.getChildren().addAll(searchButton, orderListButton, hotelListButton, infoButton, logoutButton);

		searchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new AreaInputPane(customerID));
		});

		orderListButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			try {
				TheMainFrame.jumpTo(new CustomerOrdersPane(customerID));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		hotelListButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new BookedHotelPane(customerID));
		});

		infoButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.jumpTo(new CustomerInfoPane(customerID));
		});

		logoutButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.backTo();
		});

	}

}
