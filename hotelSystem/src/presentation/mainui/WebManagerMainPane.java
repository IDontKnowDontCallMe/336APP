package presentation.mainui;

import java.rmi.RemoteException;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import presentation.userui.CustomerInfoPanel;
import presentation.userui.HotelPanel;
import presentation.userui.WebMarketerPanel;

public class WebManagerMainPane extends VBox {

	public WebManagerMainPane() {
		super();

		Button customerManageButton = new Button("客户管理");
		Button hotelManageButton = new Button("酒店及酒店工作人员管理");
		Button webMarketerManageButton = new Button("网站营销人员管理");
		Button logoutButton = new Button("注销登录");

		this.getChildren().addAll(customerManageButton, hotelManageButton, webMarketerManageButton, logoutButton);
		customerManageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			try {
				TheMainFrame.jumpTo(new CustomerInfoPanel());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		hotelManageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			try {
				TheMainFrame.jumpTo(new HotelPanel());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		webMarketerManageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			try {
				TheMainFrame.jumpTo(new WebMarketerPanel());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});

		logoutButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
			TheMainFrame.backTo();
		});

	}
}
