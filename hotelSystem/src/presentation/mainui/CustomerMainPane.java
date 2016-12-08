package presentation.mainui;

import java.rmi.RemoteException;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import presentation.customerui.CustomerInfoPane;
import presentation.hotelui.AreaInputPane;
import presentation.hotelui.BookedHotelPane;
import presentation.orderui.CustomerOrdersPane;

public class CustomerMainPane extends AnchorPane {

	private int customerID;

	public CustomerMainPane(int customerID) {
		super();
		this.customerID = customerID;
		Button searchButton = new Button();
        

		searchButton.setId("searchButton");
		
		Button orderListButton = new Button();
		orderListButton.setId("orderListButton");

		Button hotelListButton = new Button();
		hotelListButton.setId("hotelListButton");
		Button infoButton = new Button();
		infoButton.setId("infoButton");

		Button logoutButton = new Button();
		logoutButton.setId("logoutButton");

		this.getChildren().addAll(searchButton, orderListButton, hotelListButton, infoButton, logoutButton);

		AnchorPane.setLeftAnchor(searchButton, 250.0);
		AnchorPane.setTopAnchor(searchButton, 100.0);
		AnchorPane.setLeftAnchor(orderListButton, 600.0);
		AnchorPane.setTopAnchor(orderListButton, 100.0);
		AnchorPane.setLeftAnchor(hotelListButton, 250.0);
		AnchorPane.setTopAnchor(hotelListButton, 400.0);
		AnchorPane.setLeftAnchor(infoButton, 600.0);
		AnchorPane.setTopAnchor(infoButton, 400.0);
		AnchorPane.setLeftAnchor(logoutButton, 950.0);
		AnchorPane.setTopAnchor(logoutButton, 100.0);
		
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
		
		this.getStylesheets().add(getClass().getResource("customerMainPane.css").toExternalForm());


	}

}
